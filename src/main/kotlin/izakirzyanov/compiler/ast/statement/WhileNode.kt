package izakirzyanov.compiler.ast.statement

import izakirzyanov.compiler.scope.Scope
import izakirzyanov.compiler.ast.ASMHelper
import izakirzyanov.compiler.ast.FunctionNode
import izakirzyanov.compiler.ast.SimplifyResult
import izakirzyanov.compiler.ast.Type
import izakirzyanov.compiler.ast.expr.ExprNode
import izakirzyanov.compiler.errors.CompileError
import izakirzyanov.compiler.scope.OptimizationScope
import org.antlr.v4.runtime.ParserRuleContext
import org.objectweb.asm.Label
import org.objectweb.asm.Opcodes.GOTO
import org.objectweb.asm.Opcodes.IFEQ
import java.util.*

class WhileNode(var condition: ExprNode, var body: BlockNode, ctx: ParserRuleContext) : StatementNode(ctx) {
    override fun checkForErrorsAndInferType(scope: Scope, functionsList: HashMap<String, FunctionNode>): List<CompileError> {
        val errors = ArrayList<CompileError>()
        errors.addAll(condition.checkForErrorsAndInferType(scope, functionsList))
        if (condition.type != Type.Bool) {
            if (condition.type != Type.Unknown) {
                errors.add(CompileError.LoopConditionMustBeBoolean(condition.type, condition.ctx.getStart().line, condition.ctx.getStart().charPositionInLine))
            }
        }

        errors.addAll(body.checkForErrorsAndInferType(scope, functionsList))
        return errors
    }

    override fun simplify(scope: OptimizationScope): SimplifyResult {
        //new scope here
        val resBody = body.simplify(OptimizationScope())
        if (resBody.newNode != null) {
            body = resBody.newNode as BlockNode
        }
        return SimplifyResult(null, resBody.changed)
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