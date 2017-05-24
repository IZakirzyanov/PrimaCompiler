package izakirzyanov.compiler.ast.expr

import izakirzyanov.compiler.Scope
import izakirzyanov.compiler.ast.ASMHelper
import izakirzyanov.compiler.ast.FunctionNode
import izakirzyanov.compiler.ast.Type
import izakirzyanov.compiler.errors.CompileError
import org.antlr.v4.runtime.ParserRuleContext
import org.objectweb.asm.Opcodes.*
import java.util.HashMap

sealed class LiteralNode(ctx: ParserRuleContext) : ExprNode(ctx) {
    class BoolLiteralNode(val value: Boolean, ctx: ParserRuleContext) : LiteralNode(ctx) {
        init {
            type = Type.Bool
        }

        override fun checkForErrorsAndInferType(scope: Scope, functionsList: HashMap<String, FunctionNode>): List<CompileError> {
            return emptyList()
        }

        override fun generateByteCode(helper: ASMHelper, scope: Scope, functionsList: HashMap<String, FunctionNode>) {
            helper.mv!!.visitInsn(if (value) ICONST_1 else ICONST_0)
        }
    }

    class IntLiteralNode(val value: Int, ctx: ParserRuleContext) : LiteralNode(ctx) {
        init {
            type = Type.Integer
        }

        override fun checkForErrorsAndInferType(scope: Scope, functionsList: HashMap<String, FunctionNode>): List<CompileError> {
            return emptyList()
        }

        override fun generateByteCode(helper: ASMHelper, scope: Scope, functionsList: HashMap<String, FunctionNode>) {
            helper.mv!!.visitLdcInsn(Integer(value))
        }

    }

    class StringLiteralNode(val value: String, ctx: ParserRuleContext) : LiteralNode(ctx) {
        init {
            type = Type.Str
        }

        override fun checkForErrorsAndInferType(scope: Scope, functionsList: HashMap<String, FunctionNode>): List<CompileError> {
            return emptyList()
        }

        override fun generateByteCode(helper: ASMHelper, scope: Scope, functionsList: HashMap<String, FunctionNode>) {
            helper.mv!!.visitTypeInsn(NEW, "java/lang/String")
            helper.mv!!.visitInsn(DUP)
            helper.mv!!.visitLdcInsn(value)
            helper.mv!!.visitMethodInsn(INVOKESPECIAL, "java/lang/String", "<init>", "(Ljava/lang/String;)V", false)
        }
    }
}