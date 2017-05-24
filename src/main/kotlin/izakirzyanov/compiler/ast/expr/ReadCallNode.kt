package izakirzyanov.compiler.ast.expr

import izakirzyanov.compiler.Scope
import izakirzyanov.compiler.ast.ASMHelper
import izakirzyanov.compiler.ast.FunctionNode
import izakirzyanov.compiler.ast.Type
import izakirzyanov.compiler.errors.CompileError
import org.antlr.v4.runtime.ParserRuleContext
import org.objectweb.asm.Opcodes.*
import java.util.HashMap

class ReadCallNode(override var type: Type, ctx: ParserRuleContext) : ExprNode(ctx) {
    override fun checkForErrorsAndInferType(scope: Scope, functionsList: HashMap<String, FunctionNode>): List<CompileError> {
        return emptyList()
    }

    override fun generateByteCode(helper: ASMHelper, scope: Scope, functionsList: HashMap<String, FunctionNode>) {
        if (scope.getType("!scanner") == null) {
            scope.putVariableWithOverride("!scanner", Type.Unknown)
            helper.mv!!.visitTypeInsn(NEW, "java/util/Scanner")
            helper.mv!!.visitInsn(DUP)
            helper.mv!!.visitFieldInsn(GETSTATIC, "java/lang/System", "in", "Ljava/io/InputStream;")
            helper.mv!!.visitMethodInsn(INVOKESPECIAL, "java/util/Scanner", "<init>", "(Ljava/io/InputStream;)V", false)
            helper.mv!!.visitVarInsn(ASTORE, scope.getVarNum("!scanner"))
        }
        if (type == Type.Bool) {
            helper.mv!!.visitVarInsn(ALOAD, scope.getVarNum("!scanner"))
            helper.mv!!.visitMethodInsn(INVOKEVIRTUAL, "java/util/Scanner", "nextBoolean", "()Z", false)
        } else if (type == Type.Integer) {
            helper.mv!!.visitVarInsn(ALOAD, scope.getVarNum("!scanner"))
            helper.mv!!.visitMethodInsn(INVOKEVIRTUAL, "java/util/Scanner", "nextInt", "()I", false)
        } else if (type == Type.Str) {
            helper.mv!!.visitVarInsn(ALOAD, scope.getVarNum("!scanner"))
            helper.mv!!.visitMethodInsn(INVOKEVIRTUAL, "java/util/Scanner", "next", "()Ljava/lang/String;", false)
        }
    }

}