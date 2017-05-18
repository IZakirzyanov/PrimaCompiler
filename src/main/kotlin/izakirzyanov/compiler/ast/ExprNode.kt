package izakirzyanov.compiler.ast

import org.antlr.v4.runtime.ParserRuleContext

sealed class ExprNode(ctx: ParserRuleContext) : ASTNode(ctx) {
    abstract fun  getType(): Type

    class BinaryNode(val op: String, val left: ExprNode, val right: ExprNode, ctx: ParserRuleContext) : ExprNode(ctx)
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
    class UnaryNode(val op: String, val expr: ExprNode, ctx: ParserRuleContext) : ExprNode(ctx)
    class VaraiableNameNode(val name: String, ctx: ParserRuleContext) : ExprNode(ctx)
}