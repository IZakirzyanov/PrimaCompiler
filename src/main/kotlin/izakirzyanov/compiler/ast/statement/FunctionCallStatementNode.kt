package izakirzyanov.compiler.ast.statement

import izakirzyanov.compiler.ast.ASMHelper
import izakirzyanov.compiler.ast.FunctionNode
import izakirzyanov.compiler.ast.SimplifyResult
import izakirzyanov.compiler.ast.Type
import izakirzyanov.compiler.ast.expr.ExprNode
import izakirzyanov.compiler.errors.CompileError
import izakirzyanov.compiler.scope.OptimizationScope
import izakirzyanov.compiler.scope.Scope
import org.antlr.v4.runtime.ParserRuleContext
import org.objectweb.asm.Opcodes.INVOKESTATIC
import org.objectweb.asm.Opcodes.POP
import java.util.*

class FunctionCallStatementNode(val name: String, var arguments: List<ExprNode>, ctx: ParserRuleContext) : StatementNode(ctx) {
    override fun checkForErrorsAndInferType(scope: Scope, functionsList: HashMap<String, FunctionNode>): List<CompileError> {
        val errors = ArrayList<CompileError>()

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
                errors.addAll(it.first.checkForErrorsAndInferType(scope, functionsList))
                if (it.first.type != it.second.type) {
                    if (it.first.type != Type.Unknown) {
                        errors.add(CompileError.ArgumentTypeMismatch(it.second.name, it.first.type, it.second.type,
                                it.first.ctx.getStart().line, it.first.ctx.getStart().charPositionInLine))
                    }
                }
            }
        }
        return errors
    }

    override fun simplify(scope: OptimizationScope): SimplifyResult {
        val newArguments = ArrayList<ExprNode>()
        var res: SimplifyResult
        var changed = false
        arguments.forEach {
            res = it.simplify(scope)
            newArguments.add(res.newNode ?: it)
            changed = changed || res.changed
        }
        arguments = newArguments

        return SimplifyResult(null, changed)
    }

    override fun generateByteCode(helper: ASMHelper, scope: Scope, functionsList: HashMap<String, FunctionNode>) {
        arguments.forEach { it.generateByteCode(helper, scope, functionsList) }
        helper.mv!!.visitMethodInsn(INVOKESTATIC, helper.className, name, functionsList[name]?.signature?.toJVMType(), false)
        if (functionsList[name]?.signature?.type != Type.Void) {
            helper.mv!!.visitInsn(POP)
        }
    }
}