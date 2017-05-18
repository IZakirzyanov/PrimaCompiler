package izakirzyanov.compiler.ast

import izakirzyanov.compiler.errors.CompileError
import izakirzyanov.compiler.scope.Scope
import org.antlr.v4.runtime.ParserRuleContext
import java.util.*

class GlobalVarNode(val varNode : StatementNode.VarDeclarationNode, ctx: ParserRuleContext) : ASTNode(ctx) {
    fun checkForErrorsAndTypes(scope: Scope, functionsList: HashMap<String, FunctionNode>): Collection<CompileError> {
        return varNode.checkForErrorsAndTypes(scope, functionsList)
    }
}