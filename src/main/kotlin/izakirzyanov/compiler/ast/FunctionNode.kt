package izakirzyanov.compiler.ast

import izakirzyanov.compiler.errors.CompileError
import izakirzyanov.compiler.errors.CompileError.DuplicatedArgument
import izakirzyanov.compiler.scope.Scope
import org.antlr.v4.runtime.ParserRuleContext
import java.util.*

class FunctionNode(val signature: FunctionSignatureNode, val body: StatementNode.BlockNode, ctx: ParserRuleContext) : ASTNode(ctx) {
    fun checkForErrorsAndTypes(scope: Scope, functionsList: HashMap<String, FunctionNode>): List<CompileError> {
        val errors = ArrayList<CompileError>()
        val args = HashSet<String>()
        signature.arguments?.forEach {
            if (args.contains(it.name)) {
                errors.add(DuplicatedArgument(it.name, it.ctx.getStart().line, it.ctx.getStart().charPositionInLine))
            }
            args.add(it.name)
            scope.putVariableWithOverride(it.name, it.type)
        }
        body.setNameOfFunInReturn(signature.name)
        if (!body.alwaysReturns() && signature.type != Type.Void) {
            errors.add(CompileError.FunctionMayNotReturnValue(signature.name, ctx.getStart().line, ctx.getStart().charPositionInLine))
        }

        errors.addAll(body.checkForErrorsAndTypes(scope, functionsList))
        return errors
    }
}

class FunctionSignatureNode(val name: String, val arguments: List<ArgumentNode>? = null, val type: Type, ctx: ParserRuleContext) : ASTNode(ctx)

class ArgumentNode(val name: String, val type: Type, ctx: ParserRuleContext) : ASTNode(ctx)