package izakirzyanov.compiler.ast.statement

import izakirzyanov.compiler.Scope
import izakirzyanov.compiler.ast.ASMHelper
import izakirzyanov.compiler.ast.FunctionNode
import izakirzyanov.compiler.ast.Type
import izakirzyanov.compiler.ast.expr.ExprNode
import izakirzyanov.compiler.errors.CompileError
import org.antlr.v4.runtime.ParserRuleContext
import org.objectweb.asm.Label
import org.objectweb.asm.Opcodes.GOTO
import org.objectweb.asm.Opcodes.IFEQ
import java.util.ArrayList
import java.util.HashMap

class IfNode(val condition: ExprNode, val thenBlock: BlockNode, val elseBlock: BlockNode? = null, ctx: ParserRuleContext) : StatementNode(ctx) {
    override fun checkForErrorsAndTypes(scope: Scope, functionsList: HashMap<String, FunctionNode>): List<CompileError> {
        val errors = ArrayList<CompileError>()
        errors.addAll(condition.checkForErrorsAndInferType(scope, functionsList))
        if (condition.type != Type.Bool) {
            errors.add(CompileError.IfConditionMustBeBoolean(condition.type, condition.ctx.getStart().line, condition.ctx.getStart().charPositionInLine))
        }

        errors.addAll(thenBlock.checkForErrorsAndTypes(scope, functionsList))
        if (elseBlock != null) {
            errors.addAll(elseBlock.checkForErrorsAndTypes(scope, functionsList))
        }
        return errors
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