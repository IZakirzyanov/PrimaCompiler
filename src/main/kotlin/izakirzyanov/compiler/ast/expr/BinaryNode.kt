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
import java.util.ArrayList
import java.util.HashMap

class BinaryNode(val op: Op.BinOp, val left: ExprNode, val right: ExprNode, ctx: ParserRuleContext) : ExprNode(ctx) {

    override fun checkForErrorsAndInferType(scope: Scope, functionsList: HashMap<String, FunctionNode>): List<CompileError> {
        val errors = ArrayList<CompileError>()
        errors.addAll(left.checkForErrorsAndInferType(scope, functionsList))
        errors.addAll(right.checkForErrorsAndInferType(scope, functionsList))
        when (op) {
            is Op.EqualityOp -> {
                if (!left.type.isPrimitive) {
                    errors.add(CompileError.UnsupportedOperator(op, left.type, left.ctx.text, left.ctx.getStart().line, left.ctx.getStart().charPositionInLine))
                    type = Type.Unknown
                }
                if (!right.type.isPrimitive) {
                    errors.add(CompileError.UnsupportedOperator(op, right.type, right.ctx.text, right.ctx.getStart().line, right.ctx.getStart().charPositionInLine))
                    type = Type.Unknown
                } else {
                    type = Type.Bool
                }
            }
            is Op.Plus -> {
                if (left.type != Type.Integer && left.type != Type.Str) {
                    errors.add(CompileError.UnsupportedOperator(op, left.type, left.ctx.text, left.ctx.getStart().line, left.ctx.getStart().charPositionInLine))
                    type = Type.Unknown
                }
                if (right.type != Type.Integer && right.type != Type.Str) {
                    errors.add(CompileError.UnsupportedOperator(op, right.type, right.ctx.text, right.ctx.getStart().line, right.ctx.getStart().charPositionInLine))
                    type = Type.Unknown
                }
                if (left.type == Type.Integer && right.type == Type.Integer) {
                    type = Type.Integer
                } else if (left.type == Type.Str && right.type == Type.Str) {
                    type = Type.Str
                }
            }
            is Op.IntOp -> {
                if (left.type != Type.Integer) {
                    errors.add(CompileError.UnsupportedOperator(op, left.type, left.ctx.text, left.ctx.getStart().line, left.ctx.getStart().charPositionInLine))
                    type = Type.Unknown
                }
                if (right.type != Type.Integer) {
                    errors.add(CompileError.UnsupportedOperator(op, right.type, right.ctx.text, right.ctx.getStart().line, right.ctx.getStart().charPositionInLine))
                    type = Type.Unknown
                }
                if (left.type == Type.Integer && right.type == Type.Integer) {
                    if (op is Op.CmpOp) {
                        type = Type.Bool
                    } else {
                        type = Type.Integer
                    }
                }
            }
            is Op.BoolOp -> {
                if (left.type != Type.Bool) {
                    errors.add(CompileError.UnsupportedOperator(op, left.type, left.ctx.text, left.ctx.getStart().line, left.ctx.getStart().charPositionInLine))
                    type = Type.Unknown
                }
                if (right.type != Type.Bool) {
                    errors.add(CompileError.UnsupportedOperator(op, right.type, right.ctx.text, right.ctx.getStart().line, right.ctx.getStart().charPositionInLine))
                    type = Type.Unknown
                }
                if (left.type == Type.Bool && right.type == Type.Bool) {
                    type = Type.Bool
                }
            }
        }
        if (left.type != right.type) {
            errors.add(CompileError.TypeMismatchInBinaryOperator(op, left.type, right.type, ctx.getStart().line, ctx.getStart().charPositionInLine))
            type = Type.Unknown
        }
        return errors
    }

    override fun generateByteCode(helper: ASMHelper, scope: Scope, functionsList: HashMap<String, FunctionNode>) {
        when (op) {
            Op.Plus -> {
                if (left.type == Type.Integer) {
                    left.generateByteCode(helper, scope, functionsList)
                    right.generateByteCode(helper, scope, functionsList)
                    helper.mv!!.visitInsn(IADD)
                }
                if (left.type == Type.Str) {
                    helper.mv!!.visitTypeInsn(NEW, "java/lang/StringBuilder")
                    helper.mv!!.visitInsn(DUP)
                    helper.mv!!.visitMethodInsn(INVOKESPECIAL, "java/lang/StringBuilder", "<init>", "()V", false)
                    left.generateByteCode(helper, scope, functionsList)
                    helper.mv!!.visitMethodInsn(INVOKEVIRTUAL, "java/lang/StringBuilder", "append", "(Ljava/lang/String;)Ljava/lang/StringBuilder;", false)
                    right.generateByteCode(helper, scope, functionsList)
                    helper.mv!!.visitMethodInsn(INVOKEVIRTUAL, "java/lang/StringBuilder", "append", "(Ljava/lang/String;)Ljava/lang/StringBuilder;", false)
                    helper.mv!!.visitMethodInsn(INVOKEVIRTUAL, "java/lang/StringBuilder", "toString", "()Ljava/lang/String;", false)
                }
            }
            Op.Minus -> {
                left.generateByteCode(helper, scope, functionsList)
                right.generateByteCode(helper, scope, functionsList)
                helper.mv!!.visitInsn(ISUB)
            }
            Op.Mult -> {
                left.generateByteCode(helper, scope, functionsList)
                right.generateByteCode(helper, scope, functionsList)
                helper.mv!!.visitInsn(IMUL)
            }
            Op.Div -> {
                left.generateByteCode(helper, scope, functionsList)
                right.generateByteCode(helper, scope, functionsList)
                helper.mv!!.visitInsn(IDIV)
            }
            Op.Mod -> {
                left.generateByteCode(helper, scope, functionsList)
                right.generateByteCode(helper, scope, functionsList)
                helper.mv!!.visitInsn(IREM)
            }
            Op.And -> {
                left.generateByteCode(helper, scope, functionsList)
                val l0 = Label()
                helper.mv!!.visitJumpInsn(IFEQ, l0)
                right.generateByteCode(helper, scope, functionsList)
                helper.mv!!.visitJumpInsn(IFEQ, l0)
                helper.mv!!.visitInsn(ICONST_1)
                val l1 = Label()
                helper.mv!!.visitJumpInsn(GOTO, l1)
                helper.mv!!.visitLabel(l0)
                helper.mv!!.visitInsn(ICONST_0)
                helper.mv!!.visitLabel(l1)
            }
            Op.Or -> {
                left.generateByteCode(helper, scope, functionsList)
                val l0 = Label()
                helper.mv!!.visitJumpInsn(IFNE, l0)
                right.generateByteCode(helper, scope, functionsList)
                val l1 = Label()
                helper.mv!!.visitJumpInsn(IFEQ, l1)
                helper.mv!!.visitLabel(l0)
                helper.mv!!.visitInsn(ICONST_1)
                val l2 = Label()
                helper.mv!!.visitJumpInsn(GOTO, l2)
                helper.mv!!.visitLabel(l1)
                helper.mv!!.visitInsn(ICONST_0)
                helper.mv!!.visitLabel(l2)
            }
            Op.EQ -> {
                if (left.type == Type.Integer || left.type == Type.Bool) {
                    left.generateByteCode(helper, scope, functionsList)
                    right.generateByteCode(helper, scope, functionsList)
                    val l0 = Label()
                    helper.mv!!.visitJumpInsn(IF_ICMPNE, l0)
                    helper.mv!!.visitInsn(ICONST_1)
                    val l1 = Label()
                    helper.mv!!.visitJumpInsn(GOTO, l1)
                    helper.mv!!.visitLabel(l0)
                    helper.mv!!.visitInsn(ICONST_0)
                    helper.mv!!.visitLabel(l1)
                }
                if (left.type == Type.Str) {
                    left.generateByteCode(helper, scope, functionsList)
                    right.generateByteCode(helper, scope, functionsList)
                    helper.mv!!.visitMethodInsn(INVOKEVIRTUAL, "java/lang/String", "equals", "(Ljava/lang/Object;)Z", false)
                }
            }
            Op.NE -> {
                if (left.type == Type.Integer || left.type == Type.Bool) {
                    left.generateByteCode(helper, scope, functionsList)
                    right.generateByteCode(helper, scope, functionsList)
                    val l0 = Label()
                    helper.mv!!.visitJumpInsn(IF_ICMPEQ, l0)
                    helper.mv!!.visitInsn(ICONST_1)
                    val l1 = Label()
                    helper.mv!!.visitJumpInsn(GOTO, l1)
                    helper.mv!!.visitLabel(l0)
                    helper.mv!!.visitInsn(ICONST_0)
                    helper.mv!!.visitLabel(l1)
                }
                if (left.type == Type.Str) {
                    left.generateByteCode(helper, scope, functionsList)
                    right.generateByteCode(helper, scope, functionsList)
                    helper.mv!!.visitMethodInsn(INVOKEVIRTUAL, "java/lang/String", "equals", "(Ljava/lang/Object;)Z", false)
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
            Op.GT -> {
                left.generateByteCode(helper, scope, functionsList)
                right.generateByteCode(helper, scope, functionsList)
                val l0 = Label()
                helper.mv!!.visitJumpInsn(IF_ICMPLE, l0)
                helper.mv!!.visitInsn(ICONST_1)
                val l1 = Label()
                helper.mv!!.visitJumpInsn(GOTO, l1)
                helper.mv!!.visitLabel(l0)
                helper.mv!!.visitInsn(ICONST_0)
                helper.mv!!.visitLabel(l1)
            }
            Op.GE -> {
                left.generateByteCode(helper, scope, functionsList)
                right.generateByteCode(helper, scope, functionsList)
                val l0 = Label()
                helper.mv!!.visitJumpInsn(IF_ICMPLT, l0)
                helper.mv!!.visitInsn(ICONST_1)
                val l1 = Label()
                helper.mv!!.visitJumpInsn(GOTO, l1)
                helper.mv!!.visitLabel(l0)
                helper.mv!!.visitInsn(ICONST_0)
                helper.mv!!.visitLabel(l1)
            }
            Op.LT -> {
                left.generateByteCode(helper, scope, functionsList)
                right.generateByteCode(helper, scope, functionsList)
                val l0 = Label()
                helper.mv!!.visitJumpInsn(IF_ICMPGE, l0)
                helper.mv!!.visitInsn(ICONST_1)
                val l1 = Label()
                helper.mv!!.visitJumpInsn(GOTO, l1)
                helper.mv!!.visitLabel(l0)
                helper.mv!!.visitInsn(ICONST_0)
                helper.mv!!.visitLabel(l1)
            }
            Op.LE -> {
                left.generateByteCode(helper, scope, functionsList)
                right.generateByteCode(helper, scope, functionsList)
                val l0 = Label()
                helper.mv!!.visitJumpInsn(IF_ICMPGT, l0)
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