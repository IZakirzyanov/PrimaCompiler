package izakirzyanov.compiler.ast

import izakirzyanov.compiler.errors.CompileError
import izakirzyanov.compiler.Scope
import org.antlr.v4.runtime.ParserRuleContext
import org.objectweb.asm.Label
import org.objectweb.asm.Opcodes.*
import java.util.*

sealed class ExprNode(ctx: ParserRuleContext) : ASTNode(ctx) {
    abstract fun checkForErrorsAndInferType(scope: Scope, functionsList: HashMap<String, FunctionNode>): List<CompileError>
    open lateinit var type: Type

    class BinaryNode(val op: Op.BinOp, val left: ExprNode, val right: ExprNode, ctx: ParserRuleContext) : ExprNode(ctx) {

        override fun checkForErrorsAndInferType(scope: Scope, functionsList: HashMap<String, FunctionNode>): List<CompileError> {
            val errors = ArrayList<CompileError>()
            errors.addAll(left.checkForErrorsAndInferType(scope, functionsList))
            errors.addAll(right.checkForErrorsAndInferType(scope, functionsList))
            when (op) {
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
                        if (op is Op.CmpOp || op is Op.EqualityOp) {
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
                    left.generateByteCode(helper, scope, functionsList)
                    right.generateByteCode(helper, scope, functionsList)
                    helper.mv!!.visitInsn(IADD)
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
                Op.NE -> {
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

    class FunctionCallExprNode(val name: String, val arguments: List<ExprNode>? = null, ctx: ParserRuleContext) : ExprNode(ctx) {
        override fun checkForErrorsAndInferType(scope: Scope, functionsList: HashMap<String, FunctionNode>): List<CompileError> {
            val errors = ArrayList<CompileError>()

            val argsActual = arguments ?: ArrayList()
            val argsActuallyNum = argsActual.size
            val argsExpected = functionsList[name]?.signature?.arguments ?: ArrayList()
            val argsExpectedNum = argsExpected.size

            if (!functionsList.containsKey(name)) {
                errors.add(CompileError.FunctionIsNotDefined(name, ctx.getStart().line, ctx.getStart().charPositionInLine))
            } else if (argsActuallyNum != argsExpectedNum) {
                errors.add(CompileError.WrongNumberOfArguments(name, argsActuallyNum, argsExpectedNum, ctx.getStart().line, ctx.getStart().charPositionInLine))
            } else {
                argsActual.zip(argsExpected).forEach {
                    if (it.first.type != it.second.type) {
                        errors.add(CompileError.ArgumentTypeMismatch(it.second.name, it.first.type, it.second.type,
                                it.first.ctx.getStart().line, it.first.ctx.getStart().charPositionInLine))
                    }
                }
            }
            type = functionsList[name]?.signature?.type ?: Type.Unknown
            return errors
        }

        override fun generateByteCode(helper: ASMHelper, scope: Scope, functionsList: HashMap<String, FunctionNode>) {
            arguments?.forEach { it.generateByteCode(helper, scope, functionsList) }
            helper.mv!!.visitMethodInsn(INVOKESTATIC, helper.className, name, functionsList[name]?.signature?.toJVMType(), false)
        }
    }

    sealed class LiteralNode(ctx: ParserRuleContext) : ExprNode(ctx) {
        class BoolLiteralNode(val value: Boolean, ctx: ParserRuleContext) : LiteralNode(ctx) {
            init {
                type = Type.Bool
            }

            override fun checkForErrorsAndInferType(scope: Scope, functionsList: HashMap<String, FunctionNode>): List<CompileError> {
                return emptyList()
            }

            override fun generateByteCode(helper: ASMHelper, scope: Scope, functionsList: HashMap<String, FunctionNode>) {
                helper.mv!!.visitInsn(if (value) ICONST_1 else ICONST_0)
            }
        }

        class IntLiteralNode(val value: Int, ctx: ParserRuleContext) : LiteralNode(ctx) {
            init {
                type = Type.Integer
            }

            override fun checkForErrorsAndInferType(scope: Scope, functionsList: HashMap<String, FunctionNode>): List<CompileError> {
                return emptyList()
            }

            override fun generateByteCode(helper: ASMHelper, scope: Scope, functionsList: HashMap<String, FunctionNode>) {
                helper.mv!!.visitLdcInsn(Integer(value))
            }

        }
    }

    class ReadCallNode(override var type: Type, ctx: ParserRuleContext) : ExprNode(ctx) {
        override fun checkForErrorsAndInferType(scope: Scope, functionsList: HashMap<String, FunctionNode>): List<CompileError> {
            return emptyList()
        }

        override fun generateByteCode(helper: ASMHelper, scope: Scope, functionsList: HashMap<String, FunctionNode>) {
            if (scope.getType("!scanner") == null) {
                scope.putVariableWithOverride("!scanner", Type.Unknown)
                helper.mv!!.visitTypeInsn(NEW, "java/util/Scanner")
                helper.mv!!.visitInsn(DUP)
                helper.mv!!.visitFieldInsn(GETSTATIC, "java/lang/System", "in", "Ljava/io/InputStream;")
                helper.mv!!.visitMethodInsn(INVOKESPECIAL, "java/util/Scanner", "<init>", "(Ljava/io/InputStream;)V", false)
                helper.mv!!.visitVarInsn(ASTORE, scope.getVarNum("!scanner"))
            }
            if (type == Type.Bool) {
                helper.mv!!.visitVarInsn(ALOAD, scope.getVarNum("!scanner"))
                helper.mv!!.visitMethodInsn(INVOKEVIRTUAL, "java/util/Scanner", "nextBoolean", "()Z", false)
            } else if (type == Type.Integer) {
                helper.mv!!.visitVarInsn(ALOAD, scope.getVarNum("!scanner"))
                helper.mv!!.visitMethodInsn(INVOKEVIRTUAL, "java/util/Scanner", "nextInt", "()I", false)
            }
        }

    }

    class UnaryNode(val op: Op.UnOp, val expr: ExprNode, ctx: ParserRuleContext) : ExprNode(ctx) {
        override fun checkForErrorsAndInferType(scope: Scope, functionsList: HashMap<String, FunctionNode>): List<CompileError> {
            val errors = ArrayList<CompileError>()
            errors.addAll(expr.checkForErrorsAndInferType(scope, functionsList))
            when (op) {
                is Op.IntOp -> {
                    if (expr.type != Type.Integer) {
                        errors.add(CompileError.UnsupportedOperator(op, expr.type, expr.ctx.text, expr.ctx.getStart().line, expr.ctx.getStart().charPositionInLine))
                        type = Type.Unknown
                    } else {
                        type = Type.Integer
                    }
                }
                is Op.BoolOp -> {
                    if (expr.type != Type.Bool) {
                        errors.add(CompileError.UnsupportedOperator(op, expr.type, expr.ctx.text, expr.ctx.getStart().line, expr.ctx.getStart().charPositionInLine))
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

    class VariableNameNode(val name: String, ctx: ParserRuleContext) : ExprNode(ctx) {
        override fun checkForErrorsAndInferType(scope: Scope, functionsList: HashMap<String, FunctionNode>): List<CompileError> {
            val errors = ArrayList<CompileError>()
            if (scope.getType(name) == null) {
                errors.add(CompileError.VariableIsNotDefined(name, ctx.getStart().line, ctx.getStart().charPositionInLine))
            }
            type = scope.getType(name) ?: Type.Unknown
            return errors
        }

        override fun generateByteCode(helper: ASMHelper, scope: Scope, functionsList: HashMap<String, FunctionNode>) {
            if (scope.isGlobal(name)) {
                helper.mv!!.visitFieldInsn(GETSTATIC, helper.className, name, scope.getType(name)?.toJVMType())
            } else {
                helper.mv!!.visitVarInsn(ILOAD, scope.getVarNum(name))
            }
        }

    }
}