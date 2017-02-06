package izakirzyanov.compiler.ast

import izakirzyanov.compiler.ast.StatementNode

class FunctionNode(val signature: FunctionSignatureNode, val body: StatementNode.BlockNode) : ASTNode()

class FunctionSignatureNode(val name: String, val arguments: List<ArgumentNode>? = null, val type: TypeNode?) : ASTNode()

class ArgumentNode(val name: String, val type: TypeNode) : ASTNode()