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

class WhileNode(val condition: ExprNode, val body: BlockNode, ctx: ParserRuleContext) : StatementNode(ctx) {
    override fun checkForErrorsAndTypes(scope: Scope, functionsList: HashMap<String, FunctionNode>): List<CompileError> {
        val errors = ArrayList<CompileError>()
        errors.addAll(condition.checkForErrorsAndInferType(scope, functionsList))
        if (condition.type != Type.Bool) {
            errors.add(CompileError.LoopConditionMustBeBoolean(condition.type, condition.ctx.getStart().line, condition.ctx.getStart().charPositionInLine))
        }

        errors.addAll(body.checkForErrorsAndTypes(scope, functionsList))
        return errors
    }

    fun setNameOfFunInReturn(name: String) {
        body.setNameOfFunInReturn(name)
    }

    fun alwaysReturns(): Boolean {
        return false
    }

    override fun generateByteCode(helper: ASMHelper, scope: Scope, functionsList: HashMap<String, FunctionNode>) {
        val l0 = Label()
        helper.mv!!.visitLabel(l0)
        condition.generateByteCode(helper, scope, functionsList)
        val l1 = Label()
        helper.mv!!.visitJumpInsn(IFEQ, l1)
        body.generateByteCode(helper, scope, functionsList)
        helper.mv!!.visitJumpInsn(GOTO, l0)
        helper.mv!!.visitLabel(l1)
    }
}