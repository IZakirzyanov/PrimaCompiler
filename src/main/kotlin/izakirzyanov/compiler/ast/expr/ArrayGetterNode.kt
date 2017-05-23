package izakirzyanov.compiler.ast.expr

import izakirzyanov.compiler.Scope
import izakirzyanov.compiler.ast.ASMHelper
import izakirzyanov.compiler.ast.FunctionNode
import izakirzyanov.compiler.ast.Type
import izakirzyanov.compiler.errors.CompileError
import org.antlr.v4.runtime.ParserRuleContext
import java.util.ArrayList
import java.util.HashMap

class ArrayGetterNode(val name: String, val indices: List<ExprNode>, ctx: ParserRuleContext) : ExprNode(ctx) {
    override fun checkForErrorsAndInferType(scope: Scope, functionsList: HashMap<String, FunctionNode>): List<CompileError> {
        val errors = ArrayList<CompileError>()
        val fullType = scope.getType(name)
        if (fullType == null) {
            errors.add(CompileError.VariableIsNotDefined(name, ctx.getStart().line, ctx.getStart().charPositionInLine))
        } else {
            if (fullType !is Type.Arr<*>) {
                errors.add(CompileError.VariableIsNotArray(name, fullType, ctx.getStart().line, ctx.getStart().charPositionInLine))
            } else if (fullType.getArrayDepth() < indices.size) {
                errors.add(CompileError.VariableIsNotArray(Type.Arr.buildArrCall(name, indices), fullType.getPrimitiveType(), ctx.getStart().line, ctx.getStart().charPositionInLine))
            }
        }
        type = (fullType as? Type.Arr<*>)?.getSubType(indices) ?: Type.Unknown
        return errors
    }

    override fun generateByteCode(helper: ASMHelper, scope: Scope, functionsList: HashMap<String, FunctionNode>) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}