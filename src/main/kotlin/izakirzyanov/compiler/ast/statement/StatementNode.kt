package izakirzyanov.compiler.ast.statement

import izakirzyanov.compiler.ast.ASTNode
import org.antlr.v4.runtime.ParserRuleContext

abstract class StatementNode(ctx: ParserRuleContext) : ASTNode(ctx)