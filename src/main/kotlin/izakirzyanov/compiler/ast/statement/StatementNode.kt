package izakirzyanov.compiler.ast.statement

import izakirzyanov.compiler.Scope
import izakirzyanov.compiler.ast.ASTNode
import izakirzyanov.compiler.ast.FunctionNode
import izakirzyanov.compiler.errors.CompileError
import org.antlr.v4.runtime.ParserRuleContext
import java.util.*

abstract class StatementNode(ctx: ParserRuleContext) : ASTNode(ctx) {
    abstract fun checkForErrorsAndTypes(scope: Scope, functionsList: HashMap<String, FunctionNode>): List<CompileError>
}