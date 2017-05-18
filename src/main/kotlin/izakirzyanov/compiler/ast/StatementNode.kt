package izakirzyanov.compiler.ast

import izakirzyanov.compiler.errors.CompileError
import izakirzyanov.compiler.scope.Scope
import org.antlr.v4.runtime.ParserRuleContext
import java.util.*

sealed class StatementNode(ctx: ParserRuleContext) : ASTNode(ctx) {
    abstract fun checkForErrorsAndTypes(scope: Scope, functionsList: HashMap<String, FunctionNode>): List<CompileError>
    val noErrors = ArrayList<CompileError>()

    class NopNode(ctx: ParserRuleContext) : StatementNode(ctx) {
        override fun checkForErrorsAndTypes(scope: Scope, functionsList: HashMap<String, FunctionNode>): List<CompileError> {
            return noErrors
        }
    }

    class BlockNode(val statements: List<StatementNode>? = null, ctx: ParserRuleContext) : StatementNode(ctx) {

        override fun checkForErrorsAndTypes(scope: Scope, functionsList: HashMap<String, FunctionNode>): List<CompileError> {
            scope.enterScope()
            val errors = ArrayList<CompileError>()
            statements?.forEach { errors.addAll(it.checkForErrorsAndTypes(scope, functionsList)) }
            scope.leaveScope()
            return errors
        }

        fun getReturnType(): Type {
            if (statements == null || statements.isEmpty()) {
                return Type.Void
            }
            val lastStatement = statements.last()

            if (lastStatement is ReturnNode) {
                return lastStatement.value.getType()
            }
            return Type.Void
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
                    if (type != value.getType()) {
                        errors.add(CompileError.VariableTypeMismatch(name, value.getType(), type, ctx.getStart().line, ctx.getStart().charPositionInLine))
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
            } else if (value.getType() != type) {
                errors.add(CompileError.VariableTypeMismatch(name, value.getType(), type, ctx.getStart().line, ctx.getStart().charPositionInLine))
            }
            return errors
        }
    }

    class IfNode(val condition: ExprNode, val thenBlock: BlockNode, val elseBlock: BlockNode? = null, ctx: ParserRuleContext) : StatementNode(ctx) {
        override fun checkForErrorsAndTypes(scope: Scope, functionsList: HashMap<String, FunctionNode>): List<CompileError> {
            val errors = ArrayList<CompileError>()
            if (condition.getType() != Type.Bool) {
                errors.add(CompileError.IfConditionMustBeBoolean(condition.getType(), condition.ctx.getStart().line, condition.ctx.getStart().charPositionInLine))
            }

            errors.addAll(thenBlock.checkForErrorsAndTypes(scope, functionsList))
            if (elseBlock != null) {
                errors.addAll(elseBlock.checkForErrorsAndTypes(scope, functionsList))
            }
            return errors
        }
    }

    class WhileNode(val condition: ExprNode, val body: BlockNode, ctx: ParserRuleContext) : StatementNode(ctx) {
        override fun checkForErrorsAndTypes(scope: Scope, functionsList: HashMap<String, FunctionNode>): List<CompileError> {
            val errors = ArrayList<CompileError>()
            if (condition.getType() != Type.Bool) {
                errors.add(CompileError.WhileConditionMustBeBoolean(condition.getType(), condition.ctx.getStart().line, condition.ctx.getStart().charPositionInLine))
            }

            errors.addAll(body.checkForErrorsAndTypes(scope, functionsList))
            return errors
        }
    }

    class WriteNode(val nextLine: Boolean = true, val value: ExprNode? = null, ctx: ParserRuleContext) : StatementNode(ctx) {
        override fun checkForErrorsAndTypes(scope: Scope, functionsList: HashMap<String, FunctionNode>): List<CompileError> {
            return noErrors
        }
    }

    class ReturnNode(val value: ExprNode, ctx: ParserRuleContext) : StatementNode(ctx){
        override fun checkForErrorsAndTypes(scope: Scope, functionsList: HashMap<String, FunctionNode>): List<CompileError> {
            return noErrors
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
                    if (it.first.getType() != it.second.type) {
                        errors.add(CompileError.ArgumentTypeMismatch(it.second.name, it.first.getType(), it.second.type,
                                it.first.ctx.getStart().line, it.first.ctx.getStart().charPositionInLine))
                    }
                }
            }
            return errors
        }
    }
}