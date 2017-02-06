package izakirzyanov.compiler.ast

class ProgramNode(val functions: List<FunctionNode>, val globalVars: List<GlobalVarNode>) : ASTNode()