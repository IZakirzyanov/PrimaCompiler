package izakirzyanov.compiler.ast.statement

import izakirzyanov.compiler.ast.ASMHelper
import izakirzyanov.compiler.ast.FunctionNode
import izakirzyanov.compiler.ast.SimplifyResult
import izakirzyanov.compiler.ast.Type
import izakirzyanov.compiler.ast.expr.ExprNode
import izakirzyanov.compiler.ast.expr.LiteralNode
import izakirzyanov.compiler.errors.CompileError
import izakirzyanov.compiler.scope.OptimizationScope
import izakirzyanov.compiler.scope.Scope
import org.antlr.v4.runtime.ParserRuleContext
import org.objectweb.asm.Opcodes.ASTORE
import org.objectweb.asm.Opcodes.ISTORE
import java.util.*

sealed class VarDeclarationNode(val name: String, ctx: ParserRuleContext) : StatementNode(ctx) {
    class PrimitiveVarDeclarationNode(name: String, val type: Type, var expr: ExprNode, ctx: ParserRuleContext) : VarDeclarationNode(name, ctx) {
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

        override fun countLeftAndRightUsesOnly(constantScope: OptimizationScope, variablesScope: OptimizationScope) {
            expr.countLeftAndRightUsesOnly(constantScope, variablesScope)
        }

        override fun simplify(constantScope: OptimizationScope, variablesScope: OptimizationScope, useGlobalVars: Boolean): SimplifyResult {
            val res = expr.simplify(constantScope, variablesScope, useGlobalVars)
            if (res.newNode != null) {
                expr = res.newNode as ExprNode
            }

            variablesScope.put(name, expr.type, null)
            if (expr is LiteralNode) {
                constantScope.put(name, type, (expr as LiteralNode).value)
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

        fun hasFunctionCalls(): Boolean {
            return expr.hasFunctionCalls()
        }
    }

    class ArrayVarDeclarationNode(name: String, val type: Type.Arr<*>, val constructorPrimitiveType: Type, var sizes: List<ExprNode>, ctx: ParserRuleContext) : VarDeclarationNode(name, ctx) {
        override fun checkForErrorsAndInferType(scope: Scope, functionsList: HashMap<String, FunctionNode>): List<CompileError> {
            val errors = ArrayList<CompileError>()
            sizes.forEach {
                errors.addAll(it.checkForErrorsAndInferType(scope, functionsList))
                if (it.type != Type.Integer) {
                    errors.add(CompileError.ArrayIndicesShouldBeInt(it.type, it.ctx.text, it.ctx.getStart().line, it.ctx.getStart().charPositionInLine))
                }
            }
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

        override fun countLeftAndRightUsesOnly(constantScope: OptimizationScope, variablesScope: OptimizationScope) {
            sizes.forEach { it.countLeftAndRightUsesOnly(constantScope, variablesScope) }
        }

        override fun simplify(constantScope: OptimizationScope, variablesScope: OptimizationScope, useGlobalVars: Boolean): SimplifyResult {
            val newSizes = ArrayList<ExprNode>()
            var changed = false
            var res: SimplifyResult
            sizes.forEach {
                res = it.simplify(constantScope, variablesScope, useGlobalVars)
                newSizes.add(res.newNode as? ExprNode ?: it)
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