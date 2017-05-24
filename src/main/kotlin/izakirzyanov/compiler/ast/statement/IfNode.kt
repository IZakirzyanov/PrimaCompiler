package izakirzyanov.compiler.ast.statement

import izakirzyanov.compiler.ast.ASMHelper
import izakirzyanov.compiler.ast.FunctionNode
import izakirzyanov.compiler.ast.SimplifyResult
import izakirzyanov.compiler.ast.Type
import izakirzyanov.compiler.ast.expr.ExprNode
import izakirzyanov.compiler.errors.CompileError
import izakirzyanov.compiler.scope.OptimizationScope
import izakirzyanov.compiler.scope.Scope
import org.antlr.v4.runtime.ParserRuleContext
import org.objectweb.asm.Label
import org.objectweb.asm.Opcodes.GOTO
import org.objectweb.asm.Opcodes.IFEQ
import java.util.*

class IfNode(var condition: ExprNode, val thenBlock: BlockNode, val elseBlock: BlockNode? = null, ctx: ParserRuleContext) : StatementNode(ctx) {
    override fun checkForErrorsAndInferType(scope: Scope, functionsList: HashMap<String, FunctionNode>): List<CompileError> {
        val errors = ArrayList<CompileError>()
        errors.addAll(condition.checkForErrorsAndInferType(scope, functionsList))
        if (condition.type != Type.Bool) {
            if (condition.type != Type.Unknown) {
                errors.add(CompileError.IfConditionMustBeBoolean(condition.type, condition.ctx.getStart().line, condition.ctx.getStart().charPositionInLine))
            }
        }

        errors.addAll(thenBlock.checkForErrorsAndInferType(scope, functionsList))
        if (elseBlock != null) {
            errors.addAll(elseBlock.checkForErrorsAndInferType(scope, functionsList))
        }
        return errors
    }

    override fun <T> simplify(scope: OptimizationScope): SimplifyResult<T> {
        val resCond = condition.simplify<ExprNode>(scope)
        if (resCond.newNode != null) {
            condition = resCond.newNode
        }

        val resThen = thenBlock.simplify<BlockNode>(scope)
        assert(resThen.newNode == null)

        val resElse = elseBlock?.simplify<BlockNode>(scope)
        assert(resElse?.newNode == null)

        return SimplifyResult(null, resCond.changed || resThen.changed || resElse?.changed ?: false)
    }

    fun setNameOfFunInReturn(name: String) {
        thenBlock.setNameOfFunInReturn(name)
        elseBlock?.setNameOfFunInReturn(name)
    }

    fun alwaysReturns(): Boolean {
        return thenBlock.alwaysReturns() && (elseBlock?.alwaysReturns() ?: false)
    }

    override fun generateByteCode(helper: ASMHelper, scope: Scope, functionsList: HashMap<String, FunctionNode>) {
        condition.generateByteCode(helper, scope, functionsList)
        val l0 = Label()
        helper.mv!!.visitJumpInsn(IFEQ, l0)
        thenBlock.generateByteCode(helper, scope, functionsList)
        val l1 = Label()
        helper.mv!!.visitJumpInsn(GOTO, l1)
        helper.mv!!.visitLabel(l0)
        elseBlock?.generateByteCode(helper, scope, functionsList)
        helper.mv!!.visitLabel(l1)
    }
}