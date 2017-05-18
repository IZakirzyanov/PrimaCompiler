package izakirzyanov.compiler.ast

import org.antlr.v4.runtime.ParserRuleContext

class GlobalVarNode(val varNode : StatementNode.VarDeclarationNode, ctx: ParserRuleContext) : ASTNode(ctx)