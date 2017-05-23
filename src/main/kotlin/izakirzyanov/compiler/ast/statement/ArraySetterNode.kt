package izakirzyanov.compiler.ast.statement

import izakirzyanov.compiler.Scope
import izakirzyanov.compiler.ast.ASMHelper
import izakirzyanov.compiler.ast.FunctionNode
import izakirzyanov.compiler.ast.Type
import izakirzyanov.compiler.ast.expr.ExprNode
import izakirzyanov.compiler.errors.CompileError
import org.antlr.v4.runtime.ParserRuleContext
import java.util.ArrayList
import java.util.HashMap

class ArraySetterNode(val name: String, val indices: List<ExprNode>, val value: ExprNode, ctx: ParserRuleContext) : StatementNode(ctx) {
    override fun checkForErrorsAndTypes(scope: Scope, functionsList: HashMap<String, FunctionNode>): List<CompileError> {
        val errors = ArrayList<CompileError>()
        errors.addAll(value.checkForErrorsAndInferType(scope, functionsList))
        val fullType = scope.getType(name)
        if (fullType == null) {
            errors.add(CompileError.VariableIsNotDefined(name, ctx.getStart().line, ctx.getStart().charPositionInLine))
        } else {
            if (fullType !is Type.Arr<*>) {
                errors.add(CompileError.VariableIsNotArray(name, fullType, ctx.getStart().line, ctx.getStart().charPositionInLine))
            } else if (fullType.getArrayDepth() < indices.size) {
                errors.add(CompileError.VariableIsNotArray(Type.Arr.buildArrCall(name, indices), fullType.getPrimitiveType(), ctx.getStart().line, ctx.getStart().charPositionInLine))
            } else {
                val leftType = fullType.getSubType(indices)
                if (leftType != value.type) {
                    errors.add(CompileError.VariableTypeMismatch(name, value.type, leftType, ctx.getStart().line, ctx.getStart().charPositionInLine))
                }
            }
        }
        return errors
    }

    override fun generateByteCode(helper: ASMHelper, scope: Scope, functionsList: HashMap<String, FunctionNode>) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}