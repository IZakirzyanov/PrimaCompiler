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

    override fun <T> simplify(scope: OptimizationScope): SimplifyResult<T> {
        val res = expr.simplify<ExprNode>(scope)
        if (res.newNode != null) {
            expr = res.newNode
        }

        if (expr is LiteralNode) {
            scope.putVariableWithOverride(name, expr.type, (expr as LiteralNode).value)
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
}