package izakirzyanov.compiler.ast.statement

import izakirzyanov.compiler.ast.*
import izakirzyanov.compiler.scope.Scope
import izakirzyanov.compiler.ast.expr.ExprNode
import izakirzyanov.compiler.errors.CompileError
import izakirzyanov.compiler.scope.OptimizationScope
import org.antlr.v4.runtime.ParserRuleContext
import org.objectweb.asm.Opcodes.ARETURN
import org.objectweb.asm.Opcodes.IRETURN
import java.util.*

class ReturnNode(var expr: ExprNode, ctx: ParserRuleContext) : StatementNode(ctx) {
    lateinit var funName: String

    override fun checkForErrorsAndInferType(scope: Scope, functionsList: HashMap<String, FunctionNode>): List<CompileError> {
        val errors = ArrayList<CompileError>()
        errors.addAll(expr.checkForErrorsAndInferType(scope, functionsList))
        val actual = expr.type
        val expected = functionsList[funName]?.signature?.type ?: Type.Void
        if (actual != expected) {
            if (actual != Type.Unknown) {
                errors.add(CompileError.ReturnTypeMismatch(funName, actual, expected, ctx.getStart().line, ctx.getStart().charPositionInLine))
            }
        }
        return errors
    }

    override fun simplify(scope: OptimizationScope): SimplifyResult {
        val res = expr.simplify(scope)
        if (res.newNode != null) {
            expr = res.newNode
        }

        return SimplifyResult(null, res.changed)
    }

    override fun generateByteCode(helper: ASMHelper, scope: Scope, functionsList: HashMap<String, FunctionNode>) {
        expr.generateByteCode(helper, scope, functionsList)
        if (expr.type == Type.Integer || expr.type == Type.Bool) {
            helper.mv!!.visitInsn(IRETURN)
        } else if (expr.type == Type.Str || expr.type is Type.Arr<*>) {
            helper.mv!!.visitInsn(ARETURN)
        }
    }

    fun setNameOfFunInReturn(name: String) {
        funName = name
    }
}