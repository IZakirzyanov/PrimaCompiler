package izakirzyanov.compiler.ast

import izakirzyanov.compiler.errors.CompileError
import izakirzyanov.compiler.scope.Scope
import org.antlr.v4.runtime.ParserRuleContext
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
    }

    sealed class LiteralNode(ctx: ParserRuleContext) : ExprNode(ctx) {
        class BoolLiteralNode(val value: Boolean, ctx: ParserRuleContext) : LiteralNode(ctx) {
            init {
                type = Type.Bool
            }
            override fun checkForErrorsAndInferType(scope: Scope, functionsList: HashMap<String, FunctionNode>): List<CompileError> {
                return emptyList()
            }
        }

        class IntLiteralNode(val value: Int, ctx: ParserRuleContext) : LiteralNode(ctx) {
            init {
                type = Type.Integer
            }
            override fun checkForErrorsAndInferType(scope: Scope, functionsList: HashMap<String, FunctionNode>): List<CompileError> {
                return emptyList()
            }
        }
    }

    class ReadCallNode(override var type: Type, ctx: ParserRuleContext) : ExprNode(ctx) {
        override fun checkForErrorsAndInferType(scope: Scope, functionsList: HashMap<String, FunctionNode>): List<CompileError> {
            return emptyList()
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
    }

    class VariableNameNode(val name: String, ctx: ParserRuleContext) : ExprNode(ctx) {
        override fun checkForErrorsAndInferType(scope: Scope, functionsList: HashMap<String, FunctionNode>): List<CompileError> {
            val errors = ArrayList<CompileError>()
            if (scope[name] == null) {
                errors.add(CompileError.VariableIsNotDefined(name, ctx.getStart().line, ctx.getStart().charPositionInLine))
            }
            type = scope[name] ?: Type.Unknown
            return errors
        }
    }
}