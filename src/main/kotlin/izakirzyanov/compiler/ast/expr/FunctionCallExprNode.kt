package izakirzyanov.compiler.ast.expr

import izakirzyanov.compiler.Scope
import izakirzyanov.compiler.ast.ASMHelper
import izakirzyanov.compiler.ast.FunctionNode
import izakirzyanov.compiler.ast.Type
import izakirzyanov.compiler.errors.CompileError
import org.antlr.v4.runtime.ParserRuleContext
import org.objectweb.asm.Opcodes.INVOKESTATIC
import java.util.ArrayList
import java.util.HashMap

class FunctionCallExprNode(val name: String, val arguments: List<ExprNode>? = null, ctx: ParserRuleContext) : ExprNode(ctx) {
    override fun checkForErrorsAndInferType(scope: Scope, functionsList: HashMap<String, FunctionNode>): List<CompileError> {
        val errors = ArrayList<CompileError>()
        arguments?.forEach { errors.addAll(it.checkForErrorsAndInferType(scope, functionsList)) }
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
        type = functionsList[name]?.signature?.type ?: Type.Unknown
        return errors
    }

    override fun generateByteCode(helper: ASMHelper, scope: Scope, functionsList: HashMap<String, FunctionNode>) {
        arguments?.forEach { it.generateByteCode(helper, scope, functionsList) }
        helper.mv!!.visitMethodInsn(INVOKESTATIC, helper.className, name, functionsList[name]?.signature?.toJVMType(), false)
    }
}