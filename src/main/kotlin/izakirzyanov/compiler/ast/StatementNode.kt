package izakirzyanov.compiler.ast

import izakirzyanov.compiler.errors.CompileError
import izakirzyanov.compiler.scope.Scope
import org.antlr.v4.runtime.ParserRuleContext
import java.util.*

sealed class StatementNode(ctx: ParserRuleContext) : ASTNode(ctx) {
    abstract fun checkForErrorsAndTypes(scope: Scope, functionsList: HashMap<String, FunctionNode>): List<CompileError>

    class NopNode(ctx: ParserRuleContext) : StatementNode(ctx) {
        override fun checkForErrorsAndTypes(scope: Scope, functionsList: HashMap<String, FunctionNode>): List<CompileError> {
            return ArrayList()
        }
    }

    class BlockNode(val statements: List<StatementNode>? = null, ctx: ParserRuleContext) : StatementNode(ctx) {

        override fun checkForErrorsAndTypes(scope: Scope, functionsList: HashMap<String, FunctionNode>): List<CompileError> {
            val errors = ArrayList<CompileError>()
            statements?.forEach { errors.addAll(it.checkForErrorsAndTypes(scope, functionsList)) }
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
        }
    }

    class AssignmentNode(val name: String, val op: String, val value: ExprNode, ctx: ParserRuleContext) : StatementNode(ctx)
    class IfNode(val condition: ExprNode, val thenBlock: BlockNode, val elseBlock: BlockNode? = null, ctx: ParserRuleContext) : StatementNode(ctx)
    class WhileNode(val condition: ExprNode, val body: BlockNode, ctx: ParserRuleContext) : StatementNode(ctx)
    class WriteNode(val nextLine: Boolean = true, val value: ExprNode? = null, ctx: ParserRuleContext) : StatementNode(ctx)
    class ReturnNode(val value: ExprNode, ctx: ParserRuleContext) : StatementNode(ctx)
    class FunctionCallNode(val name: String, val arguments: List<ExprNode>? = null, ctx: ParserRuleContext) : StatementNode(ctx)
}