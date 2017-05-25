package izakirzyanov.compiler.ast.expr

import izakirzyanov.compiler.ast.ASMHelper
import izakirzyanov.compiler.ast.FunctionNode
import izakirzyanov.compiler.ast.SimplifyResult
import izakirzyanov.compiler.ast.Type
import izakirzyanov.compiler.errors.CompileError
import izakirzyanov.compiler.scope.OptimizationScope
import izakirzyanov.compiler.scope.Scope
import org.antlr.v4.runtime.ParserRuleContext
import org.objectweb.asm.Opcodes.INVOKESTATIC
import java.util.*

class FunctionCallExprNode(val name: String, var arguments: List<ExprNode>, ctx: ParserRuleContext) : ExprNode(ctx) {
    override fun checkForErrorsAndInferType(scope: Scope, functionsList: HashMap<String, FunctionNode>): List<CompileError> {
        val errors = ArrayList<CompileError>()
        arguments.forEach { errors.addAll(it.checkForErrorsAndInferType(scope, functionsList)) }
        val argsActual = arguments
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
                    if (it.first.type != Type.Unknown) {
                        errors.add(CompileError.ArgumentTypeMismatch(it.second.name, it.first.type, it.second.type,
                                it.first.ctx.getStart().line, it.first.ctx.getStart().charPositionInLine))
                    }
                }
            }
        }
        type = functionsList[name]?.signature?.type ?: Type.Unknown
        return errors
    }

    override fun simplify(scope: OptimizationScope, useGlobalVars: Boolean): SimplifyResult {
        val newArguments = ArrayList<ExprNode>()
        var res: SimplifyResult
        var changed = false
        arguments.forEach {
            res = it.simplify(scope, useGlobalVars)
            newArguments.add((res.newNode as? ExprNode) ?: it)
            changed = changed || res.changed
        }
        arguments = newArguments

        return SimplifyResult(null, changed)
    }

    override fun generateByteCode(helper: ASMHelper, scope: Scope, functionsList: HashMap<String, FunctionNode>) {
        arguments.forEach { it.generateByteCode(helper, scope, functionsList) }
        helper.mv!!.visitMethodInsn(INVOKESTATIC, helper.className, name, functionsList[name]?.signature?.toJVMType(), false)
    }
}