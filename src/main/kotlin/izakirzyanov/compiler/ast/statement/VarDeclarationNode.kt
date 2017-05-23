package izakirzyanov.compiler.ast.statement

import izakirzyanov.compiler.Scope
import izakirzyanov.compiler.ast.ASMHelper
import izakirzyanov.compiler.ast.FunctionNode
import izakirzyanov.compiler.ast.Type
import izakirzyanov.compiler.ast.expr.ExprNode
import izakirzyanov.compiler.errors.CompileError
import org.antlr.v4.runtime.ParserRuleContext
import org.objectweb.asm.Opcodes.ASTORE
import org.objectweb.asm.Opcodes.ISTORE
import java.util.ArrayList
import java.util.HashMap

sealed class VarDeclarationNode(ctx: ParserRuleContext) : StatementNode(ctx) {
    class PrimitiveVarDeclarationNode(val name: String, val type: Type, val value: ExprNode, ctx: ParserRuleContext) : VarDeclarationNode(ctx) {
        override fun checkForErrorsAndTypes(scope: Scope, functionsList: HashMap<String, FunctionNode>): List<CompileError> {
            val errors = ArrayList<CompileError>()
            if (scope.definedInTheLastScope(name)) {
                errors.add(CompileError.VariableIsAlreadyDefinedInThisScope(name, ctx.getStart().line, ctx.getStart().charPositionInLine))
            } else {
                scope.putVariableWithOverride(name, type)
                errors.addAll(value.checkForErrorsAndInferType(scope, functionsList))
                if (type != value.type) {
                    errors.add(CompileError.VariableTypeMismatch(name, value.type, type, ctx.getStart().line, ctx.getStart().charPositionInLine))
                }
            }
            return errors
        }

        override fun generateByteCode(helper: ASMHelper, scope: Scope, functionsList: HashMap<String, FunctionNode>) {
            scope.putVariableWithOverride(name, type)
            value.generateByteCode(helper, scope, functionsList)
            if (type.isPrimitive) {
                helper.mv!!.visitVarInsn(ISTORE, scope.getVarNum(name))
            } else {
                helper.mv!!.visitVarInsn(ASTORE, scope.getVarNum(name))
            }
        }
    }

    class ArrayVarDeclarationNode(val name: String, val type: Type.Arr<*>, val constructorPrimitiveType: Type, val sizes: List<ExprNode>, ctx: ParserRuleContext) : VarDeclarationNode(ctx) {
        override fun checkForErrorsAndTypes(scope: Scope, functionsList: HashMap<String, FunctionNode>): List<CompileError> {
            val errors = ArrayList<CompileError>()
            if (scope.definedInTheLastScope(name)) {
                errors.add(CompileError.VariableIsAlreadyDefinedInThisScope(name, ctx.getStart().line, ctx.getStart().charPositionInLine))
            } else {
                val expected = type.getPrimitiveType()
                if (expected != constructorPrimitiveType || sizes.size != type.getArrayDepth()) {
                    errors.add(CompileError.ConstructorTypeMismatch(name, Type.Arr.buildArrType(constructorPrimitiveType, sizes.size), expected, ctx.getStart().line, ctx.getStart().charPositionInLine))
                }
                scope.putVariableWithOverride(name, type)
            }
            return errors
        }

        override fun generateByteCode(helper: ASMHelper, scope: Scope, functionsList: HashMap<String, FunctionNode>) {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }
    }
}