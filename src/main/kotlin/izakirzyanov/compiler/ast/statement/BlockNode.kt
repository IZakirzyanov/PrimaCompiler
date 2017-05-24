package izakirzyanov.compiler.ast.statement

import izakirzyanov.compiler.PrimaParser
import izakirzyanov.compiler.Scope
import izakirzyanov.compiler.ast.ASMHelper
import izakirzyanov.compiler.ast.FunctionNode
import izakirzyanov.compiler.errors.CompileError
import org.antlr.v4.runtime.ParserRuleContext
import java.util.ArrayList
import java.util.HashMap

class BlockNode(val statements: ArrayList<StatementNode> = ArrayList(), ctx: ParserRuleContext) : StatementNode(ctx) {

    override fun checkForErrorsAndTypes(scope: Scope, functionsList: HashMap<String, FunctionNode>): List<CompileError> {
        if (ctx.parent !is PrimaParser.FunctionDeclarationContext) {
            scope.beginNewScope()
        }
        val errors = ArrayList<CompileError>()
        statements.forEach {
            if (it is ReturnNode && it != statements.last()) {
                errors.add(CompileError.DeadCodeAfterReturn(it.ctx.getStart().line, it.ctx.getStart().charPositionInLine))
            }
            errors.addAll(it.checkForErrorsAndTypes(scope, functionsList))
        }
        if (ctx.parent !is PrimaParser.FunctionDeclarationContext) {
            scope.endScope()
        }
        return errors
    }

    fun addStatementToBody(statement: StatementNode) {
        statements.add(statement)
    }

    fun setNameOfFunInReturn(name: String) {
        statements?.forEach {
            when (it) {
                is BlockNode -> it.setNameOfFunInReturn(name)
                is IfNode -> it.setNameOfFunInReturn(name)
                is WhileNode -> it.setNameOfFunInReturn(name)
                is ReturnNode -> it.setNameOfFunInReturn(name)
            }
        }
    }

    fun alwaysReturns(): Boolean {
        statements?.forEach {
            if (it is BlockNode) {
                if (it.alwaysReturns()) {
                    return true
                }
            }
            if (it is IfNode) {
                if (it.alwaysReturns()) {
                    return true
                }
            }
            if (it is WhileNode) {
                if (it.alwaysReturns()) {
                    return true
                }
            }
            if (it is ReturnNode) {
                return true
            }
        }
        return false
    }

    override fun generateByteCode(helper: ASMHelper, scope: Scope, functionsList: HashMap<String, FunctionNode>) {
        if (ctx.parent !is PrimaParser.FunctionDeclarationContext) {
            scope.beginNewScope()
        }
        statements?.forEach { it.generateByteCode(helper, scope, functionsList) }
        if (ctx.parent !is PrimaParser.FunctionDeclarationContext) {
            scope.endScope()
        }
    }
}