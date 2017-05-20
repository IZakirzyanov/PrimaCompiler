package izakirzyanov.compiler.ast

import izakirzyanov.compiler.errors.CompileError
import izakirzyanov.compiler.scope.Scope
import org.antlr.v4.runtime.ParserRuleContext
import java.util.*

sealed class StatementNode(ctx: ParserRuleContext) : ASTNode(ctx) {
    abstract fun checkForErrorsAndTypes(scope: Scope, functionsList: HashMap<String, FunctionNode>): List<CompileError>

    class NopNode(ctx: ParserRuleContext) : StatementNode(ctx) {
        override fun checkForErrorsAndTypes(scope: Scope, functionsList: HashMap<String, FunctionNode>): List<CompileError> {
            return emptyList()
        }
    }

    class BlockNode(val statements: List<StatementNode>? = null, ctx: ParserRuleContext) : StatementNode(ctx) {

        override fun checkForErrorsAndTypes(scope: Scope, functionsList: HashMap<String, FunctionNode>): List<CompileError> {
            scope.beginNewScope()
            val errors = ArrayList<CompileError>()
            statements?.forEach {
                if (it is ReturnNode && it != statements.last()) {
                    errors.add(CompileError.DeadCodeAfterReturn(it.ctx.getStart().line, it.ctx.getStart().charPositionInLine))
                }
                errors.addAll(it.checkForErrorsAndTypes(scope, functionsList))
            }
            scope.endScope()
            return errors
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
    }

    class VarDeclarationNode(val name: String, val type: Type, val value: ExprNode? = null, ctx: ParserRuleContext) : StatementNode(ctx) {
        override fun checkForErrorsAndTypes(scope: Scope, functionsList: HashMap<String, FunctionNode>): List<CompileError> {
            val errors = ArrayList<CompileError>()
            if (scope.definedInTheLastScope(name)) {
                errors.add(CompileError.VariableIsAlreadyDefinedInThisScope(name, ctx.getStart().line, ctx.getStart().charPositionInLine))
            } else {
                scope.putVariableWithOverride(name, type)
                if (value != null) {
                    if (type != value.type) {
                        errors.add(CompileError.VariableTypeMismatch(name, value.type, type, ctx.getStart().line, ctx.getStart().charPositionInLine))
                    }
                }
            }
            return errors
        }
    }

    class AssignmentNode(val name: String, val op: String, val value: ExprNode, ctx: ParserRuleContext) : StatementNode(ctx) {
        override fun checkForErrorsAndTypes(scope: Scope, functionsList: HashMap<String, FunctionNode>): List<CompileError> {
            val errors = ArrayList<CompileError>()
            val type = scope[name]
            if (type == null) {
                errors.add(CompileError.VariableIsNotDefined(name, ctx.getStart().line, ctx.getStart().charPositionInLine))
            } else if (value.type != type) {
                errors.add(CompileError.VariableTypeMismatch(name, value.type, type, ctx.getStart().line, ctx.getStart().charPositionInLine))
            }
            return errors
        }
    }

    class IfNode(val condition: ExprNode, val thenBlock: BlockNode, val elseBlock: BlockNode? = null, ctx: ParserRuleContext) : StatementNode(ctx) {
        override fun checkForErrorsAndTypes(scope: Scope, functionsList: HashMap<String, FunctionNode>): List<CompileError> {
            val errors = ArrayList<CompileError>()
            if (condition.type != Type.Bool) {
                errors.add(CompileError.IfConditionMustBeBoolean(condition.type, condition.ctx.getStart().line, condition.ctx.getStart().charPositionInLine))
            }

            errors.addAll(thenBlock.checkForErrorsAndTypes(scope, functionsList))
            if (elseBlock != null) {
                errors.addAll(elseBlock.checkForErrorsAndTypes(scope, functionsList))
            }
            return errors
        }

        fun setNameOfFunInReturn(name: String) {
            thenBlock.setNameOfFunInReturn(name)
            elseBlock?.setNameOfFunInReturn(name)
        }

        fun alwaysReturns(): Boolean {
            return thenBlock.alwaysReturns() && (elseBlock?.alwaysReturns() ?: true)
        }
    }

    class WhileNode(val condition: ExprNode, val body: BlockNode, ctx: ParserRuleContext) : StatementNode(ctx) {
        override fun checkForErrorsAndTypes(scope: Scope, functionsList: HashMap<String, FunctionNode>): List<CompileError> {
            val errors = ArrayList<CompileError>()
            if (condition.type != Type.Bool) {
                errors.add(CompileError.WhileConditionMustBeBoolean(condition.type, condition.ctx.getStart().line, condition.ctx.getStart().charPositionInLine))
            }

            errors.addAll(body.checkForErrorsAndTypes(scope, functionsList))
            return errors
        }

        fun setNameOfFunInReturn(name: String) {
            body.setNameOfFunInReturn(name)
        }

        fun alwaysReturns(): Boolean {
            return body.alwaysReturns()
        }
    }

    class WriteNode(val nextLine: Boolean = true, val value: ExprNode? = null, ctx: ParserRuleContext) : StatementNode(ctx) {
        override fun checkForErrorsAndTypes(scope: Scope, functionsList: HashMap<String, FunctionNode>): List<CompileError> {
            return emptyList()
        }
    }

    class ReturnNode(val value: ExprNode, ctx: ParserRuleContext) : StatementNode(ctx) {
        lateinit var funName: String

        override fun checkForErrorsAndTypes(scope: Scope, functionsList: HashMap<String, FunctionNode>): List<CompileError> {
            val actual = value.type
            val expected = functionsList[funName]?.signature?.type ?: Type.Void
            return if (actual != expected) emptyList() else listOf(CompileError.ReturnTypeMismatch(funName, actual, expected, ctx.getStart().line, ctx.getStart().charPositionInLine))
        }

        fun setNameOfFunInReturn(name: String) {
            funName = name
        }
    }

    class FunctionCallStatementNode(val name: String, val arguments: List<ExprNode>? = null, ctx: ParserRuleContext) : StatementNode(ctx) {
        override fun checkForErrorsAndTypes(scope: Scope, functionsList: HashMap<String, FunctionNode>): List<CompileError> {
            val errors = ArrayList<CompileError>()

            val argsActual = arguments ?: ArrayList()
            val argsActuallyNum = argsActual.size
            val argsExpected = functionsList[name]?.signature?.arguments ?: ArrayList()
            val argsExpectedNum = argsExpected.size

            if (!functionsList.containsKey(name)) {
                errors.add(CompileError.FunctionIsNotDefined(name, ctx.getStart().line, ctx.getStart().charPositionInLine))
            } else if (argsActuallyNum != argsExpectedNum) {
                errors.add(CompileError.WrongNumberOfArguments(name, argsActuallyNum, argsExpectedNum, ctx.getStart().line, ctx.getStart().charPositionInLine))
            } else {
                argsActual.zip(argsExpected).forEach {
                    if (it.first.type != it.second.type) {
                        errors.add(CompileError.ArgumentTypeMismatch(it.second.name, it.first.type, it.second.type,
                                it.first.ctx.getStart().line, it.first.ctx.getStart().charPositionInLine))
                    }
                }
            }
            return errors
        }
    }
}