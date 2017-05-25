package izakirzyanov.compiler.ast.expr

import izakirzyanov.compiler.ast.ASMHelper
import izakirzyanov.compiler.ast.FunctionNode
import izakirzyanov.compiler.ast.SimplifyResult
import izakirzyanov.compiler.ast.Type
import izakirzyanov.compiler.errors.CompileError
import izakirzyanov.compiler.scope.OptimizationScope
import izakirzyanov.compiler.scope.Scope
import org.antlr.v4.runtime.ParserRuleContext
import org.objectweb.asm.Opcodes.*
import java.util.*

class VariableNameNode(val name: String, ctx: ParserRuleContext) : ExprNode(ctx) {
    override fun checkForErrorsAndInferType(scope: Scope, functionsList: HashMap<String, FunctionNode>): List<CompileError> {
        val errors = ArrayList<CompileError>()
        if (scope.getType(name) == null) {
            errors.add(CompileError.VariableIsNotDefined(name, ctx.getStart().line, ctx.getStart().charPositionInLine))
        }
        type = scope.getType(name) ?: Type.Unknown
        return errors
    }

    override fun countLeftAndRightUsesOnly(constantScope: OptimizationScope, variablesScope: OptimizationScope) {
        variablesScope.getValue(name)!!.rused++

        val constInfo = constantScope.getValue(name)
        if (constInfo != null) {
            constInfo.rused++
        }
    }

    override fun simplify(constantScope: OptimizationScope, variablesScope: OptimizationScope, useGlobalVars: Boolean): SimplifyResult {
        variablesScope.getValue(name)!!.rused++

        val constInfo = constantScope.getValue(name)
        if (constInfo == null) {
            return SimplifyResult(null, false)
        } else {
            if (constInfo.useInPropagation || !(!useGlobalVars && constantScope.isGlobal(name))) {
                var newNode: LiteralNode? = null
                when (constInfo.type) {
                    is Type.Integer -> {
                        newNode = LiteralNode.IntLiteralNode(constInfo.value as Int, ParserRuleContext())
                    }
                    is Type.Bool -> {
                        newNode = LiteralNode.BoolLiteralNode(constInfo.value as Boolean, ParserRuleContext())
                    }
                    is Type.Str -> {
                        newNode = LiteralNode.StrLiteralNode(constInfo.value as String, ParserRuleContext())
                    }
                }
                return SimplifyResult(newNode, newNode != null)
            } else {
                constInfo.rused++
                return SimplifyResult(null, false)
            }
        }
    }

    override fun generateByteCode(helper: ASMHelper, scope: Scope, functionsList: HashMap<String, FunctionNode>) {
        if (scope.isGlobal(name)) {
            helper.mv!!.visitFieldInsn(GETSTATIC, helper.className, name, scope.getType(name)?.toJVMType())
        } else {
            if (scope.getType(name) == Type.Integer || scope.getType(name) == Type.Bool) {
                helper.mv!!.visitVarInsn(ILOAD, scope.getVarNum(name))
            } else if (scope.getType(name) == Type.Str) {
                helper.mv!!.visitVarInsn(ALOAD, scope.getVarNum(name))
            } else if (scope.getType(name) is Type.Arr<*>) {
                helper.mv!!.visitVarInsn(ALOAD, scope.getVarNum(name))
            }
        }
    }
}