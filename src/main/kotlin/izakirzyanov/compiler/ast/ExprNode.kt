package izakirzyanov.compiler.ast

import izakirzyanov.compiler.errors.CompileError
import izakirzyanov.compiler.scope.Scope
import org.antlr.v4.runtime.ParserRuleContext
import java.util.*

sealed class ExprNode(ctx: ParserRuleContext) : ASTNode(ctx) {
    abstract fun checkForErrorsAndTypes(scope: Scope, functionsList: HashMap<String, FunctionNode>): List<CompileError>
    lateinit var type: Type

    class BinaryNode(val op: Op.BinOp, val left: ExprNode, val right: ExprNode, ctx: ParserRuleContext) : ExprNode(ctx) {

        override fun checkForErrorsAndTypes(scope: Scope, functionsList: HashMap<String, FunctionNode>): List<CompileError> {
            val errors = ArrayList<CompileError>()
            errors.addAll(left.checkForErrorsAndTypes(scope, functionsList))
            errors.addAll(right.checkForErrorsAndTypes(scope, functionsList))
            when (op) {
                is Op.IntOp -> {
                    if (left.type != Type.Integer) {
                        errors.add(CompileError.UnsupportedOperator(op, left.type, left.ctx.getStart().line, left.ctx.getStart().charPositionInLine))
                    }
                    if (right.type != Type.Integer) {
                        errors.add(CompileError.UnsupportedOperator(op, right.type, left.ctx.getStart().line, left.ctx.getStart().charPositionInLine))
                    }
                }
                is Op.BoolOp -> {
                    if (left.type != Type.Bool) {
                        errors.add(CompileError.UnsupportedOperator(op, left.type, left.ctx.getStart().line, left.ctx.getStart().charPositionInLine))
                    }
                    if (right.type != Type.Bool) {
                        errors.add(CompileError.UnsupportedOperator(op, right.type, left.ctx.getStart().line, left.ctx.getStart().charPositionInLine))
                    }
                }
            }
            if (left.type != right.type) {
                errors.add(CompileError.TypeMismathInBinaryOperator(op, left.type, right.type, ctx.getStart().line, ctx.getStart().charPositionInLine))
                type
            }
        }
    }

    class FunctionCallExprNode(val name: String, val arguments: List<ExprNode>? = null, ctx: ParserRuleContext) : ExprNode(ctx)
    sealed class LiteralNode(ctx: ParserRuleContext) : ExprNode(ctx) {
        class BoolLiteralNode(val value: Boolean, ctx: ParserRuleContext) : LiteralNode(ctx) {
            val type = Type.Bool
        }

        class IntLiteralNode(val value: Int, ctx: ParserRuleContext) : LiteralNode(ctx) {
            val type = Type.Integer
        }
    }

    class ReadCallNode(val type: Type, ctx: ParserRuleContext) : ExprNode(ctx)
    class UnaryNode(val op: UnOp, val expr: ExprNode, ctx: ParserRuleContext) : ExprNode(ctx)
    class VaraiableNameNode(val name: String, ctx: ParserRuleContext) : ExprNode(ctx)
}