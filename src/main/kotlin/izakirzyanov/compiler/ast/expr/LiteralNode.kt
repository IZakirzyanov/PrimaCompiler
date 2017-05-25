package izakirzyanov.compiler.ast.expr

import izakirzyanov.compiler.scope.Scope
import izakirzyanov.compiler.ast.ASMHelper
import izakirzyanov.compiler.ast.FunctionNode
import izakirzyanov.compiler.ast.SimplifyResult
import izakirzyanov.compiler.ast.Type
import izakirzyanov.compiler.errors.CompileError
import izakirzyanov.compiler.scope.OptimizationScope
import org.antlr.v4.runtime.ParserRuleContext
import org.objectweb.asm.Opcodes.*
import java.util.HashMap

sealed class LiteralNode(val value: Any, ctx: ParserRuleContext) : ExprNode(ctx) {

    class BoolLiteralNode(value: Boolean, ctx: ParserRuleContext) : LiteralNode(value, ctx) {
        override fun simplify(scope: OptimizationScope): SimplifyResult {
            return SimplifyResult(null, false)
        }

        init {
            type = Type.Bool
        }

        override fun checkForErrorsAndInferType(scope: Scope, functionsList: HashMap<String, FunctionNode>): List<CompileError> {
            return emptyList()
        }

        override fun generateByteCode(helper: ASMHelper, scope: Scope, functionsList: HashMap<String, FunctionNode>) {
            helper.mv!!.visitInsn(if (value as Boolean) ICONST_1 else ICONST_0)
        }
    }

    class IntLiteralNode(value: Int, ctx: ParserRuleContext) : LiteralNode(value, ctx) {
        override fun simplify(scope: OptimizationScope): SimplifyResult {
            return SimplifyResult(null, false)
        }

        init {
            type = Type.Integer
        }

        override fun checkForErrorsAndInferType(scope: Scope, functionsList: HashMap<String, FunctionNode>): List<CompileError> {
            return emptyList()
        }

        override fun generateByteCode(helper: ASMHelper, scope: Scope, functionsList: HashMap<String, FunctionNode>) {
            helper.mv!!.visitLdcInsn(value as Int)
        }

    }

    class StrLiteralNode(value: String, ctx: ParserRuleContext) : LiteralNode(value, ctx) {
        override fun simplify(scope: OptimizationScope): SimplifyResult {
            return SimplifyResult(null, false)
        }

        init {
            type = Type.Str
        }

        override fun checkForErrorsAndInferType(scope: Scope, functionsList: HashMap<String, FunctionNode>): List<CompileError> {
            return emptyList()
        }

        override fun generateByteCode(helper: ASMHelper, scope: Scope, functionsList: HashMap<String, FunctionNode>) {
            helper.mv!!.visitTypeInsn(NEW, "java/lang/String")
            helper.mv!!.visitInsn(DUP)
            helper.mv!!.visitLdcInsn(value as String)
            helper.mv!!.visitMethodInsn(INVOKESPECIAL, "java/lang/String", "<init>", "(Ljava/lang/String;)V", false)
        }
    }
}