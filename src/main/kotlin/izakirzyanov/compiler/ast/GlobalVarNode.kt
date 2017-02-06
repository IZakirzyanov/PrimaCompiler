package izakirzyanov.compiler.ast

import izakirzyanov.compiler.ast.exrp.ExprNode

class GlobalVarNode(val name: String, val Type: TypeNode, val expr: ExprNode? = null) : ASTNode()