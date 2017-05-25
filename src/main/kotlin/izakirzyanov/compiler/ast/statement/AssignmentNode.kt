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
import org.objectweb.asm.Opcodes.*
import java.util.*

class AssignmentNode(val name: String, var expr: ExprNode, ctx: ParserRuleContext) : StatementNode(ctx) {
    override fun checkForErrorsAndInferType(scope: Scope, functionsList: HashMap<String, FunctionNode>): List<CompileError> {
        val errors = ArrayList<CompileError>()
        errors.addAll(expr.checkForErrorsAndInferType(scope, functionsList))
        val type = scope.getType(name)
        if (type == null) {
            errors.add(CompileError.VariableIsNotDefined(name, ctx.getStart().line, ctx.getStart().charPositionInLine))
        } else if (expr.type != type) {
            if (expr.type != Type.Unknown) {
                errors.add(CompileError.VariableTypeMismatch(name, expr.type, type, ctx.getStart().line, ctx.getStart().charPositionInLine))
            }
        }
        return errors
    }

    override fun countLeftAndRightUsesOnly(constantScope: OptimizationScope, variablesScope: OptimizationScope) {
        expr.countLeftAndRightUsesOnly(constantScope, variablesScope)
        variablesScope.getValue(name)!!.lused++
        val constInfo = constantScope.getValue(name)
        if (constInfo != null) {
            constInfo.lused++
        }
    }

    override fun simplify(constantScope: OptimizationScope, variablesScope: OptimizationScope, useGlobalVars: Boolean): SimplifyResult {
        val res = expr.simplify(constantScope, variablesScope, useGlobalVars)
        if (res.newNode != null) {
            expr = res.newNode as ExprNode
        }

        val constInfo = constantScope.getValue(name)
        if (constInfo != null) {
            if (expr is LiteralNode) {
                constantScope.updateIfCan(name, (expr as LiteralNode).value)
            } else {
                constantScope.removeIfExist(name)
            }
            constInfo.lused++
        }


        val varInfo = variablesScope.getValue(name)
        if (varInfo != null) {
            varInfo.lused++
        }
        return SimplifyResult(null, res.changed)
    }

    override fun generateByteCode(helper: ASMHelper, scope: Scope, functionsList: HashMap<String, FunctionNode>) {
        expr.generateByteCode(helper, scope, functionsList)
        val type = scope.getType(name)
        if (scope.isGlobal(name)) {
            helper.mv!!.visitFieldInsn(PUTSTATIC, helper.className, name, type?.toJVMType())
        } else {
            if (type!! == Type.Integer || type == Type.Bool) {
                helper.mv!!.visitVarInsn(ISTORE, scope.getVarNum(name))
            } else {
                helper.mv!!.visitVarInsn(ASTORE, scope.getVarNum(name))
            }
        }
    }

    fun hasFunctionCalls(): Boolean {
        return expr.hasFunctionCalls()
    }
}