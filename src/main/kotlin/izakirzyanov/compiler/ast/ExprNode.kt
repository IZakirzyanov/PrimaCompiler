package izakirzyanov.compiler.ast

import izakirzyanov.compiler.ast.ASTNode
import izakirzyanov.compiler.ast.TypeNode

sealed class ExprNode : ASTNode() {
    class BinaryNode(val op: String, val left: ExprNode, val right: ExprNode) : ExprNode()
    class FunctionCallExprNode(val name: String, val arguments: List<ExprNode>? = null) : ExprNode()
    sealed class LiteralNode : ExprNode() {
        class BoolLiteralNode(val value: Boolean) : LiteralNode() {
            val type = TypeNode.Bool
        }

        class IntLiteralNode(val value: Int) : LiteralNode() {
            val type = TypeNode.Integer
        }
    }

    class ReadCallNode(val type: TypeNode) : ExprNode()
    class UnaryNode(val op: String, val expr: ExprNode) : ExprNode()
    class VaraiableNameNode(val name: String) : ExprNode()
}