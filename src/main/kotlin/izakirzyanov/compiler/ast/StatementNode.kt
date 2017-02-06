package izakirzyanov.compiler.ast

import izakirzyanov.compiler.ast.ASTNode
import izakirzyanov.compiler.ast.ArgumentNode
import izakirzyanov.compiler.ast.TypeNode
import izakirzyanov.compiler.ast.ExprNode

sealed class StatementNode : ASTNode() {
    class NopNode() : StatementNode()
    class BlockNode(val statements: List<StatementNode>? = null) : StatementNode()
    class VarDeclarationNode(val name: String, val Type: TypeNode, val value: ExprNode? = null) : StatementNode()
    class AssignmentNode(val name: String, val op: String, val value: ExprNode) : StatementNode()
    class IfNode(val condition: ExprNode, val thenBlock: BlockNode, val elseBlock: BlockNode? = null) : StatementNode()
    class ForNode(val init: StatementNode? = null, val stopCondition: ExprNode? = null, val iteration: AssignmentNode? = null, val body: BlockNode) : StatementNode()
    class WhileNode(val condition: ExprNode, val body: BlockNode) : StatementNode()
    class ReadNode(val type: TypeNode) : StatementNode()
    class WriteNode(val nextLine: Boolean = true, val value: ExprNode? = null) : StatementNode()
    class ReturnNode(val value: ExprNode) : StatementNode()
    class FunctionCallNode(val name: String, val arguments: List<ExprNode>? = null) : StatementNode()
}