package izakirzyanov.compiler.ast.expr

import izakirzyanov.compiler.Scope
import izakirzyanov.compiler.ast.ASMHelper
import izakirzyanov.compiler.ast.FunctionNode
import izakirzyanov.compiler.ast.Op
import izakirzyanov.compiler.ast.Type
import izakirzyanov.compiler.errors.CompileError
import org.antlr.v4.runtime.ParserRuleContext
import org.objectweb.asm.Label
import org.objectweb.asm.Opcodes.*
import java.util.*

class UnaryNode(val op: Op.UnOp, val expr: ExprNode, ctx: ParserRuleContext) : ExprNode(ctx) {
    override fun checkForErrorsAndInferType(scope: Scope, functionsList: HashMap<String, FunctionNode>): List<CompileError> {
        val errors = ArrayList<CompileError>()
        errors.addAll(expr.checkForErrorsAndInferType(scope, functionsList))
        when (op) {
            is Op.IntOp -> {
                if (expr.type != Type.Integer) {
                    if (expr.type != Type.Unknown) {
                        errors.add(CompileError.TypeMismatchInUnaryOperator(op, expr.type, expr.ctx.text, expr.ctx.getStart().line, expr.ctx.getStart().charPositionInLine))
                    }
                    type = Type.Unknown
                } else {
                    type = Type.Integer
                }
            }
            is Op.BoolOp -> {
                if (expr.type != Type.Bool) {
                    if (expr.type != Type.Unknown) {
                        errors.add(CompileError.TypeMismatchInUnaryOperator(op, expr.type, expr.ctx.text, expr.ctx.getStart().line, expr.ctx.getStart().charPositionInLine))
                    }
                    type = Type.Unknown
                } else {
                    type = Type.Bool
                }
            }
        }
        return errors
    }

    override fun generateByteCode(helper: ASMHelper, scope: Scope, functionsList: HashMap<String, FunctionNode>) {
        expr.generateByteCode(helper, scope, functionsList)
        when (op) {
            is Op.UnMinus -> {
                helper.mv!!.visitInsn(INEG)
            }
            is Op.Not -> {
                val l0 = Label()
                helper.mv!!.visitJumpInsn(IFNE, l0)
                helper.mv!!.visitInsn(ICONST_1)
                val l1 = Label()
                helper.mv!!.visitJumpInsn(GOTO, l1)
                helper.mv!!.visitLabel(l0)
                helper.mv!!.visitInsn(ICONST_0)
                helper.mv!!.visitLabel(l1)
            }
        }
    }
}