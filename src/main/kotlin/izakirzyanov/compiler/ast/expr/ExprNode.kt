package izakirzyanov.compiler.ast.expr

import izakirzyanov.compiler.ast.ASTNode
import izakirzyanov.compiler.ast.Type
import org.antlr.v4.runtime.ParserRuleContext

abstract class ExprNode(ctx: ParserRuleContext) : ASTNode(ctx) {
    open lateinit var type: Type
    abstract fun hasFunctionCalls(): Boolean
}