package izakirzyanov.compiler.ast.statement

import izakirzyanov.compiler.Scope
import izakirzyanov.compiler.ast.ASMHelper
import izakirzyanov.compiler.ast.FunctionNode
import izakirzyanov.compiler.ast.Type
import izakirzyanov.compiler.ast.expr.ExprNode
import izakirzyanov.compiler.errors.CompileError
import org.antlr.v4.runtime.ParserRuleContext
import org.objectweb.asm.Opcodes.ARETURN
import org.objectweb.asm.Opcodes.IRETURN
import java.util.ArrayList
import java.util.HashMap

class ReturnNode(val value: ExprNode, ctx: ParserRuleContext) : StatementNode(ctx) {
    lateinit var funName: String

    override fun checkForErrorsAndTypes(scope: Scope, functionsList: HashMap<String, FunctionNode>): List<CompileError> {
        val errors = ArrayList<CompileError>()
        errors.addAll(value.checkForErrorsAndInferType(scope, functionsList))
        val actual = value.type
        val expected = functionsList[funName]?.signature?.type ?: Type.Void
        if (actual != expected) {
            errors.add(CompileError.ReturnTypeMismatch(funName, actual, expected, ctx.getStart().line, ctx.getStart().charPositionInLine))
        }
        return errors
    }

    fun setNameOfFunInReturn(name: String) {
        funName = name
    }

    override fun generateByteCode(helper: ASMHelper, scope: Scope, functionsList: HashMap<String, FunctionNode>) {
        value.generateByteCode(helper, scope, functionsList)
        if (value.type == Type.Integer || value.type == Type.Bool) {
            helper.mv!!.visitInsn(IRETURN)
        } else if (value.type == Type.Str || value.type is Type.Arr<*>) {
            helper.mv!!.visitInsn(ARETURN)
        }
    }
}