package izakirzyanov.compiler.ast.statement

import izakirzyanov.compiler.Scope
import izakirzyanov.compiler.ast.ASMHelper
import izakirzyanov.compiler.ast.FunctionNode
import izakirzyanov.compiler.ast.Type
import izakirzyanov.compiler.ast.expr.ExprNode
import izakirzyanov.compiler.errors.CompileError
import org.antlr.v4.runtime.ParserRuleContext
import org.objectweb.asm.Opcodes.GETSTATIC
import org.objectweb.asm.Opcodes.INVOKEVIRTUAL
import java.util.*

class WriteNode(val nextLine: Boolean = true, val value: ExprNode? = null, ctx: ParserRuleContext) : StatementNode(ctx) {
    override fun checkForErrorsAndTypes(scope: Scope, functionsList: HashMap<String, FunctionNode>): List<CompileError> {
        val errors = ArrayList<CompileError>()
        errors.addAll(value?.checkForErrorsAndInferType(scope, functionsList) ?: emptyList())
        val valType = value?.type
        if (valType != null && !valType.isPrimitive) {
            if (valType != Type.Unknown) {
                errors.add(CompileError.WriteIsNotDefinedForNonPrimitiveTypes(valType, ctx.getStart().line, ctx.getStart().charPositionInLine))
            }
        }
        return errors
    }

    override fun generateByteCode(helper: ASMHelper, scope: Scope, functionsList: HashMap<String, FunctionNode>) {
        if (nextLine) {
            helper.mv!!.visitFieldInsn(GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;")
            value?.generateByteCode(helper, scope, functionsList)
            helper.mv!!.visitMethodInsn(INVOKEVIRTUAL, "java/io/PrintStream", "println", "(" + (value?.type?.toJVMType() ?: "") + ")V", false)
        } else {
            if (value != null) {
                helper.mv!!.visitFieldInsn(GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;")
                value.generateByteCode(helper, scope, functionsList)
                helper.mv!!.visitMethodInsn(INVOKEVIRTUAL, "java/io/PrintStream", "print", "(" + value.type.toJVMType() + ")V", false)
            }
        }
    }
}