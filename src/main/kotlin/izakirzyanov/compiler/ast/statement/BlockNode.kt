package izakirzyanov.compiler.ast.statement

import izakirzyanov.compiler.PrimaParser
import izakirzyanov.compiler.ast.ASMHelper
import izakirzyanov.compiler.ast.FunctionNode
import izakirzyanov.compiler.ast.SimplifyResult
import izakirzyanov.compiler.errors.CompileError
import izakirzyanov.compiler.scope.OptimizationScope
import izakirzyanov.compiler.scope.Scope
import org.antlr.v4.runtime.ParserRuleContext
import java.util.*

class BlockNode(var statements: ArrayList<StatementNode> = ArrayList(), ctx: ParserRuleContext) : StatementNode(ctx) {
    override fun checkForErrorsAndInferType(scope: Scope, functionsList: HashMap<String, FunctionNode>): List<CompileError> {
        if (ctx.parent !is PrimaParser.FunctionDeclarationContext) {
            scope.beginNewScope()
        }
        val errors = ArrayList<CompileError>()
        statements.forEach {
            if (it is ReturnNode && it != statements.last()) {
                errors.add(CompileError.DeadCodeAfterReturn(it.ctx.getStart().line, it.ctx.getStart().charPositionInLine))
            }
            errors.addAll(it.checkForErrorsAndInferType(scope, functionsList))
        }
        if (ctx.parent !is PrimaParser.FunctionDeclarationContext) {
            scope.endScope()
        }
        return errors
    }

    override fun simplify(scope: OptimizationScope, useGlobalVars: Boolean): SimplifyResult {
        if (ctx.parent !is PrimaParser.FunctionDeclarationContext) {
            scope.beginNewScope()
        }
        var newStatements: ArrayList<StatementNode> = ArrayList()
        var res: SimplifyResult
        var changed = false
        statements.forEach {
            if (it !is NopNode) {
                res = it.simplify(scope, useGlobalVars)
                newStatements.add(res.newNode as? StatementNode ?: it)
                changed = changed || res.changed
            } else {
                changed = true
            }
        }
        statements = newStatements

        newStatements = ArrayList()
        statements.forEach {
            if (it is AssignmentNode) {
                if (scope.getValue(it.name)?.rused != 0) {
                    newStatements.add(it)
                } else {
                    changed = true
                }
            } else if (it is VarDeclarationNode) {
                if (scope.getValue(it.name)?.rused != 0) {
                    newStatements.add(it)
                } else {
                    changed = true
                }
            } else {
                newStatements.add(it)
            }
        }
        statements = newStatements
        if (ctx.parent !is PrimaParser.FunctionDeclarationContext) {
            scope.endScope()
        }
        return SimplifyResult(null, changed)
    }

    override fun generateByteCode(helper: ASMHelper, scope: Scope, functionsList: HashMap<String, FunctionNode>) {
        if (ctx.parent !is PrimaParser.FunctionDeclarationContext) {
            scope.beginNewScope()
        }
        statements.forEach { it.generateByteCode(helper, scope, functionsList) }
        if (ctx.parent !is PrimaParser.FunctionDeclarationContext) {
            scope.endScope()
        }
    }

    fun addStatementToBody(statement: StatementNode) {
        statements.add(statement)
    }

    fun setNameOfFunInReturn(name: String) {
        statements.forEach {
            when (it) {
                is BlockNode -> it.setNameOfFunInReturn(name)
                is IfNode -> it.setNameOfFunInReturn(name)
                is WhileNode -> it.setNameOfFunInReturn(name)
                is ReturnNode -> it.setNameOfFunInReturn(name)
            }
        }
    }

    fun alwaysReturns(): Boolean {
        statements.forEach {
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
}