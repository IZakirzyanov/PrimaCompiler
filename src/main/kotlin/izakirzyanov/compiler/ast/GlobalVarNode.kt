package izakirzyanov.compiler.ast

import izakirzyanov.compiler.ast.ExprNode

class GlobalVarNode(val name: String, val Type: TypeNode, val expr: ExprNode? = null) : ASTNode()