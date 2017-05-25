package izakirzyanov.compiler.ast.statement

import izakirzyanov.compiler.ast.*
import izakirzyanov.compiler.ast.expr.ExprNode
import izakirzyanov.compiler.ast.expr.LiteralNode
import izakirzyanov.compiler.ast.expr.UnaryNode
import izakirzyanov.compiler.errors.CompileError
import izakirzyanov.compiler.scope.OptimizationScope
import izakirzyanov.compiler.scope.Scope
import org.antlr.v4.runtime.ParserRuleContext
import org.objectweb.asm.Label
import org.objectweb.asm.Opcodes.GOTO
import org.objectweb.asm.Opcodes.IFEQ
import java.util.*

class IfNode(var condition: ExprNode, var thenBlock: BlockNode, var elseBlock: BlockNode? = null, ctx: ParserRuleContext) : StatementNode(ctx) {
    override fun checkForErrorsAndInferType(scope: Scope, functionsList: HashMap<String, FunctionNode>): List<CompileError> {
        val errors = ArrayList<CompileError>()
        errors.addAll(condition.checkForErrorsAndInferType(scope, functionsList))
        if (condition.type != Type.Bool) {
            if (condition.type != Type.Unknown) {
                errors.add(CompileError.IfConditionMustBeBoolean(condition.type, condition.ctx.getStart().line, condition.ctx.getStart().charPositionInLine))
            }
        }

        errors.addAll(thenBlock.checkForErrorsAndInferType(scope, functionsList))
        val elseBlock = elseBlock
        if (elseBlock != null) {
            errors.addAll(elseBlock.checkForErrorsAndInferType(scope, functionsList))
        }
        return errors
    }

    override fun simplify(scope: OptimizationScope, useGlobalVars: Boolean): SimplifyResult {
        val resCond = condition.simplify(scope, useGlobalVars)
        if (resCond.newNode != null) {
            condition = resCond.newNode as ExprNode
        }

        val condition = condition
        if (condition is LiteralNode.BoolLiteralNode) {
            if (condition.value as Boolean) {
                val resThen = thenBlock.simplify(scope, useGlobalVars)
                return SimplifyResult(resThen.newNode ?: thenBlock, true)
            } else {
                val elseBlock = elseBlock
                if (elseBlock != null) {
                    val resElse = elseBlock.simplify(scope, useGlobalVars)
                    return SimplifyResult(resElse.newNode ?: elseBlock, true)
                } else {
                    return SimplifyResult(NopNode(ParserRuleContext()), true)
                }
            }
        }

        val resThen = thenBlock.simplify(scope, useGlobalVars)
        val resElse = elseBlock?.simplify(scope, useGlobalVars)

        if (resThen.newNode != null) {
            if ((resThen.newNode as BlockNode).statements.isEmpty()) {
                if (resElse?.newNode != null) {
                    if ((resElse.newNode as BlockNode).statements.isEmpty()) {
                        return SimplifyResult(NopNode(ParserRuleContext()), true)
                    } else {
                        elseBlock = resElse.newNode
                    }
                }
                if (elseBlock != null) {
                    return SimplifyResult(IfNode(UnaryNode(Op.Not, condition, ParserRuleContext()), elseBlock!!, null, ParserRuleContext()), true)
                } else {
                    return SimplifyResult(NopNode(ParserRuleContext()), true)
                }
            } else {
                thenBlock = resThen.newNode
            }
        } else {
            if (resElse?.newNode != null) {
                if ((resElse.newNode as BlockNode).statements.isEmpty()) {
                    elseBlock = null
                } else {
                    elseBlock = resElse.newNode
                }
            }
        }

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