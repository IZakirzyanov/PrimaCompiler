package izakirzyanov.compiler.ast

import izakirzyanov.compiler.errors.CompileError
import izakirzyanov.compiler.errors.CompileError.VariableIsAlreadyDefinedInThisScope
import izakirzyanov.compiler.errors.CompileError.FunctionIsAlreadyDefined
import izakirzyanov.compiler.scope.Scope
import org.antlr.v4.runtime.ParserRuleContext
import java.util.*

class ProgramNode(val functions: List<FunctionNode>, val globalVars: List<GlobalVarNode>, ctx: ParserRuleContext) : ASTNode(ctx) {

    fun checkForErrorsAndTypes(): List<CompileError> {
        val scope = Scope()
        val functionsList = HashMap<String, FunctionNode>()
        val errors = ArrayList<CompileError>()

        globalVars.forEach {
            if (!scope.putVariableWithCheck(it.varNode.name, it.varNode.type)) {
                errors.add(VariableIsAlreadyDefinedInThisScope(it.varNode.name, it.ctx.getStart().line, it.ctx.getStart().charPositionInLine))
            }
        }
        functions.forEach {
            if (it.signature.name == "readInt" || it.signature.name == "readBool" || it.signature.name == "write" || it.signature.name == "writeln") {
                errors.add(FunctionIsAlreadyDefined(it.signature.name, it.ctx.getStart().line, it.ctx.getStart().charPositionInLine))
            }
            if (!functionsList.containsKey(it.signature.name)) {
                functionsList.put(it.signature.name, it)
            } else {
                errors.add(FunctionIsAlreadyDefined(it.signature.name, it.ctx.getStart().line, it.ctx.getStart().charPositionInLine))
            }
        }

        functions.forEach {
            errors.addAll(it.checkForErrorsAndTypes(scope, functionsList))
        }

        globalVars.forEach {
            errors.addAll(it.checkForErrorsAndTypes(scope, functionsList))
        }

        return errors
    }
}