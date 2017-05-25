package izakirzyanov.compiler.ast.statement

import izakirzyanov.compiler.ast.*
import izakirzyanov.compiler.ast.expr.ExprNode
import izakirzyanov.compiler.ast.expr.LiteralNode
import izakirzyanov.compiler.errors.CompileError
import izakirzyanov.compiler.scope.OptimizationScope
import izakirzyanov.compiler.scope.Scope
import org.antlr.v4.runtime.ParserRuleContext
import org.objectweb.asm.Opcodes.ASTORE
import org.objectweb.asm.Opcodes.ISTORE
import java.util.*

sealed class VarDeclarationNode(ctx: ParserRuleContext) : StatementNode(ctx) {
    class PrimitiveVarDeclarationNode(val name: String, val type: Type, var expr: ExprNode, ctx: ParserRuleContext) : VarDeclarationNode(ctx) {
        override fun checkForErrorsAndInferType(scope: Scope, functionsList: HashMap<String, FunctionNode>): List<CompileError> {
            val errors = ArrayList<CompileError>()
            if (scope.isReserved(name)) {
                errors.add(CompileError.ReservedCanNotBeUsedAsName(name, ctx.getStart().line, ctx.getStart().charPositionInLine))
            }
            if (scope.definedInTheLastScope(name)) {
                errors.add(CompileError.VariableIsAlreadyDefinedInThisScope(name, ctx.getStart().line, ctx.getStart().charPositionInLine))
            } else {
                scope.putVariableWithOverride(name, type)
                errors.addAll(expr.checkForErrorsAndInferType(scope, functionsList))
                if (type != expr.type) {
                    if (expr.type != Type.Unknown) {
                        errors.add(CompileError.VariableTypeMismatch(name, expr.type, type, ctx.getStart().line, ctx.getStart().charPositionInLine))
                    }
                }
            }
            return errors
        }

        override fun simplify(scope: OptimizationScope): SimplifyResult {
            val res = expr.simplify(scope)
            if (res.newNode != null) {
                expr = res.newNode
            }

            if (expr is LiteralNode) {
                scope.putVariableWithOverride(name, type, (expr as LiteralNode).value)
            }
            return SimplifyResult(null, res.changed)
        }

        override fun generateByteCode(helper: ASMHelper, scope: Scope, functionsList: HashMap<String, FunctionNode>) {
            scope.putVariableWithOverride(name, type)
            expr.generateByteCode(helper, scope, functionsList)
            if (type == Type.Integer || type == Type.Bool) {
                helper.mv!!.visitVarInsn(ISTORE, scope.getVarNum(name))
            } else {
                helper.mv!!.visitVarInsn(ASTORE, scope.getVarNum(name))
            }
        }
    }

    class ArrayVarDeclarationNode(val name: String, val type: Type.Arr<*>, val constructorPrimitiveType: Type, var sizes: List<ExprNode>, ctx: ParserRuleContext) : VarDeclarationNode(ctx) {
        override fun checkForErrorsAndInferType(scope: Scope, functionsList: HashMap<String, FunctionNode>): List<CompileError> {
            val errors = ArrayList<CompileError>()
            sizes.forEach { errors.addAll(it.checkForErrorsAndInferType(scope, functionsList)) }
            if (scope.isReserved(name)) {
                errors.add(CompileError.ReservedCanNotBeUsedAsName(name, ctx.getStart().line, ctx.getStart().charPositionInLine))
            }
            if (scope.definedInTheLastScope(name)) {
                errors.add(CompileError.VariableIsAlreadyDefinedInThisScope(name, ctx.getStart().line, ctx.getStart().charPositionInLine))
            } else {
                if (type.getPrimitiveType() != constructorPrimitiveType || sizes.size != type.getArrayDepth()) {
                    errors.add(CompileError.ConstructorTypeMismatch(name, Type.Arr.buildArrType(constructorPrimitiveType, sizes.size), type, ctx.getStart().line, ctx.getStart().charPositionInLine))
                }
                scope.putVariableWithOverride(name, type)
            }
            return errors
        }

        override fun simplify(scope: OptimizationScope): SimplifyResult {
            val newSizes = ArrayList<ExprNode>()
            var changed = false
            var res: SimplifyResult
            sizes.forEach {
                res = it.simplify(scope)
                newSizes.add(res.newNode ?: it)
                changed = changed || res.changed
            }
            sizes = newSizes
            return SimplifyResult(null, changed)
        }

        override fun generateByteCode(helper: ASMHelper, scope: Scope, functionsList: HashMap<String, FunctionNode>) {
            scope.putVariableWithOverride(name, type)
            sizes.forEach { it.generateByteCode(helper, scope, functionsList) }
            helper.mv!!.visitMultiANewArrayInsn(type.toJVMType(), sizes.size)
            helper.mv!!.visitVarInsn(ASTORE, scope.getVarNum(name))
        }
    }
}