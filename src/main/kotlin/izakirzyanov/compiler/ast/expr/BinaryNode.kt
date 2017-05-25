package izakirzyanov.compiler.ast.expr

import izakirzyanov.compiler.ast.*
import izakirzyanov.compiler.errors.CompileError
import izakirzyanov.compiler.scope.OptimizationScope
import izakirzyanov.compiler.scope.Scope
import org.antlr.v4.runtime.ParserRuleContext
import org.objectweb.asm.Label
import org.objectweb.asm.Opcodes.*
import java.util.*

class BinaryNode(val op: Op.BinOp, var left: ExprNode, var right: ExprNode, ctx: ParserRuleContext) : ExprNode(ctx) {

    override fun checkForErrorsAndInferType(scope: Scope, functionsList: HashMap<String, FunctionNode>): List<CompileError> {
        val errors = ArrayList<CompileError>()
        errors.addAll(left.checkForErrorsAndInferType(scope, functionsList))
        errors.addAll(right.checkForErrorsAndInferType(scope, functionsList))
        when (op) {
            is Op.EqualityOp -> {
                if (!left.type.isPrimitive || !right.type.isPrimitive) {
                    if (left.type !is Type.Unknown || right.type !is Type.Unknown) {
                        errors.add(CompileError.TypeMismatchInBinaryOperator(op, left.type, right.type, ctx.text, ctx.getStart().line, ctx.getStart().charPositionInLine))
                    }
                    type = Type.Unknown
                } else {
                    type = Type.Bool
                }
            }
            is Op.Plus -> {
                if (left.type != Type.Integer && left.type != Type.Str || right.type != Type.Integer && right.type != Type.Str) {
                    if (left.type !is Type.Unknown || right.type !is Type.Unknown) {
                        errors.add(CompileError.TypeMismatchInBinaryOperator(op, left.type, right.type, ctx.text, ctx.getStart().line, ctx.getStart().charPositionInLine))
                    }
                    type = Type.Unknown
                } else if (left.type == Type.Integer && right.type == Type.Integer) {
                    type = Type.Integer
                } else if (left.type == Type.Str && right.type == Type.Str) {
                    type = Type.Str
                }
            }
            is Op.IntOp -> {
                if (left.type != Type.Integer || right.type != Type.Integer) {
                    if (left.type !is Type.Unknown || right.type !is Type.Unknown) {
                        errors.add(CompileError.TypeMismatchInBinaryOperator(op, left.type, right.type, ctx.text, ctx.getStart().line, ctx.getStart().charPositionInLine))
                    }
                    type = Type.Unknown
                } else if (left.type == Type.Integer && right.type == Type.Integer) {
                    if (op is Op.CmpOp) {
                        type = Type.Bool
                    } else {
                        type = Type.Integer
                    }
                }
            }
            is Op.BoolOp -> {
                if (left.type != Type.Bool || right.type != Type.Bool) {
                    if (left.type !is Type.Unknown || right.type !is Type.Unknown) {
                        errors.add(CompileError.TypeMismatchInBinaryOperator(op, left.type, right.type, ctx.text, ctx.getStart().line, ctx.getStart().charPositionInLine))
                    }
                    type = Type.Unknown
                }
                if (left.type == Type.Bool && right.type == Type.Bool) {
                    type = Type.Bool
                }
            }
        }
        if (left.type != right.type) {
            if (left.type !is Type.Unknown || right.type !is Type.Unknown) {
                errors.add(CompileError.TypeMismatchInBinaryOperator(op, left.type, right.type, ctx.text, ctx.getStart().line, ctx.getStart().charPositionInLine))
            }
            type = Type.Unknown
        }
        return errors
    }

    override fun simplify(scope: OptimizationScope, useGlobalVars: Boolean): SimplifyResult {
        var newNode: ExprNode? = null

        val resL = left.simplify(scope, useGlobalVars)
        if (resL.newNode != null) {
            left = resL.newNode as ExprNode
        }

        val resR = right.simplify(scope, useGlobalVars)
        if (resR.newNode != null) {
            right = resR.newNode as ExprNode
        }

        val left = left
        val right = right
        when (op) {
            Op.Plus -> {
                if (left is LiteralNode.IntLiteralNode && right is LiteralNode.IntLiteralNode) {
                    newNode = LiteralNode.IntLiteralNode(left.value as Int + right.value as Int, ParserRuleContext())
                }
                if (left is LiteralNode.StrLiteralNode && right is LiteralNode.StrLiteralNode) {
                    newNode = LiteralNode.StrLiteralNode(left.value as String + right.value as String, ParserRuleContext())
                }
            }
            Op.Minus -> {
                if ((left is LiteralNode.IntLiteralNode) && (right is LiteralNode.IntLiteralNode)) {
                    newNode = LiteralNode.IntLiteralNode(left.value as Int - right.value as Int, ParserRuleContext())
                }
            }
            Op.Mult -> {
                if (left is LiteralNode.IntLiteralNode && left.value as Int == 0) {
                    newNode = LiteralNode.IntLiteralNode(0, ParserRuleContext())
                } else if (right is LiteralNode.IntLiteralNode && right.value as Int == 0) {
                    newNode = LiteralNode.IntLiteralNode(0, ParserRuleContext())
                } else if (left is LiteralNode.IntLiteralNode && right is LiteralNode.IntLiteralNode) {
                    newNode = LiteralNode.IntLiteralNode(left.value as Int * right.value as Int, ParserRuleContext())
                }
            }
            Op.Div -> {
                if (left is LiteralNode.IntLiteralNode && right is LiteralNode.IntLiteralNode) {
                    newNode = LiteralNode.IntLiteralNode(left.value as Int / right.value as Int, ParserRuleContext())
                } else if (left is LiteralNode.IntLiteralNode && left.value as Int == 0) {
                    newNode = LiteralNode.IntLiteralNode(0, ParserRuleContext())
                }
            }
            Op.Mod -> {
                if (left is LiteralNode.IntLiteralNode && right is LiteralNode.IntLiteralNode) {
                    newNode = LiteralNode.IntLiteralNode(left.value as Int % right.value as Int, ParserRuleContext())
                } else if (left is LiteralNode.IntLiteralNode && left.value as Int == 0) {
                    newNode = LiteralNode.IntLiteralNode(0, ParserRuleContext())
                } else if (right is LiteralNode.IntLiteralNode && right.value as Int == 0) {
                    newNode = LiteralNode.IntLiteralNode(0, ParserRuleContext())
                }
            }
            Op.And -> {
                if (left is LiteralNode.BoolLiteralNode && right is LiteralNode.BoolLiteralNode) {
                    newNode = LiteralNode.BoolLiteralNode(left.value as Boolean && right.value as Boolean, ParserRuleContext())
                }
            }
            Op.Or -> {
                if (left is LiteralNode.BoolLiteralNode && right is LiteralNode.BoolLiteralNode) {
                    newNode = LiteralNode.BoolLiteralNode(left.value as Boolean || right.value as Boolean, ParserRuleContext())
                }
            }
            Op.EQ -> {
                if (left is LiteralNode.IntLiteralNode && right is LiteralNode.IntLiteralNode) {
                    newNode = LiteralNode.BoolLiteralNode(left.value as Int == right.value as Int, ParserRuleContext())
                }
                if (left is LiteralNode.StrLiteralNode && right is LiteralNode.StrLiteralNode) {
                    newNode = LiteralNode.BoolLiteralNode(left.value as String == right.value as String, ParserRuleContext())
                }
                if (left is LiteralNode.BoolLiteralNode && right is LiteralNode.BoolLiteralNode) {
                    newNode = LiteralNode.BoolLiteralNode(left.value as Boolean == right.value as Boolean, ParserRuleContext())
                }
            }
            Op.NE -> {
                if (left is LiteralNode.IntLiteralNode && right is LiteralNode.IntLiteralNode) {
                    newNode = LiteralNode.BoolLiteralNode(left.value as Int != right.value as Int, ParserRuleContext())
                }
                if (left is LiteralNode.StrLiteralNode && right is LiteralNode.StrLiteralNode) {
                    newNode = LiteralNode.BoolLiteralNode(left.value as String != right.value as String, ParserRuleContext())
                }
                if (left is LiteralNode.BoolLiteralNode && right is LiteralNode.BoolLiteralNode) {
                    newNode = LiteralNode.BoolLiteralNode(left.value as Boolean != right.value as Boolean, ParserRuleContext())
                }
            }
            Op.GT -> {
                if (left is LiteralNode.IntLiteralNode && right is LiteralNode.IntLiteralNode) {
                    newNode = LiteralNode.BoolLiteralNode(left.value as Int > right.value as Int, ParserRuleContext())
                }
            }
            Op.GE -> {
                if (left is LiteralNode.IntLiteralNode && right is LiteralNode.IntLiteralNode) {
                    newNode = LiteralNode.BoolLiteralNode(left.value as Int >= right.value as Int, ParserRuleContext())
                }
            }
            Op.LT -> {
                if (left is LiteralNode.IntLiteralNode && right is LiteralNode.IntLiteralNode) {
                    newNode = LiteralNode.BoolLiteralNode((left.value as Int) < (right.value as Int), ParserRuleContext())
                }
            }
            Op.LE -> {
                if (left is LiteralNode.IntLiteralNode && right is LiteralNode.IntLiteralNode) {
                    newNode = LiteralNode.BoolLiteralNode(left.value as Int <= right.value as Int, ParserRuleContext())
                }
            }
        }
        return SimplifyResult(newNode, resL.changed || resR.changed || newNode != null)
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