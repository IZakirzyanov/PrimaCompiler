package izakirzyanov.compiler.ast.expr

import izakirzyanov.compiler.ast.ASMHelper
import izakirzyanov.compiler.ast.FunctionNode
import izakirzyanov.compiler.ast.SimplifyResult
import izakirzyanov.compiler.ast.Type
import izakirzyanov.compiler.errors.CompileError
import izakirzyanov.compiler.scope.OptimizationScope
import izakirzyanov.compiler.scope.Scope
import org.antlr.v4.runtime.ParserRuleContext
import org.objectweb.asm.Opcodes.*
import java.util.*

sealed class LiteralNode(val value: Any, ctx: ParserRuleContext) : ExprNode(ctx) {

    class BoolLiteralNode(value: Boolean, ctx: ParserRuleContext) : LiteralNode(value, ctx) {
        init {
            type = Type.Bool
        }

        override fun checkForErrorsAndInferType(scope: Scope, functionsList: HashMap<String, FunctionNode>): List<CompileError> {
            return emptyList()
        }

        override fun countLeftAndRightUsesOnly(constantScope: OptimizationScope, variablesScope: OptimizationScope) {}

        override fun simplify(constantScope: OptimizationScope, variablesScope: OptimizationScope, useGlobalVars: Boolean): SimplifyResult {
            return SimplifyResult(null, false)
        }

        override fun generateByteCode(helper: ASMHelper, scope: Scope, functionsList: HashMap<String, FunctionNode>) {
            helper.mv!!.visitInsn(if (value as Boolean) ICONST_1 else ICONST_0)
        }

        override fun hasFunctionCalls(): Boolean {
            return false
        }
    }

    class IntLiteralNode(value: Int, ctx: ParserRuleContext) : LiteralNode(value, ctx) {
        init {
            type = Type.Integer
        }

        override fun checkForErrorsAndInferType(scope: Scope, functionsList: HashMap<String, FunctionNode>): List<CompileError> {
            return emptyList()
        }

        override fun countLeftAndRightUsesOnly(constantScope: OptimizationScope, variablesScope: OptimizationScope) {}

        override fun simplify(constantScope: OptimizationScope, variablesScope: OptimizationScope, useGlobalVars: Boolean): SimplifyResult {
            return SimplifyResult(null, false)
        }

        override fun generateByteCode(helper: ASMHelper, scope: Scope, functionsList: HashMap<String, FunctionNode>) {
            helper.mv!!.visitLdcInsn(value as Int)
        }

        override fun hasFunctionCalls(): Boolean {
            return false
        }
    }

    class StrLiteralNode(value: String, ctx: ParserRuleContext) : LiteralNode(value, ctx) {
        init {
            type = Type.Str
        }

        override fun checkForErrorsAndInferType(scope: Scope, functionsList: HashMap<String, FunctionNode>): List<CompileError> {
            return emptyList()
        }

        override fun countLeftAndRightUsesOnly(constantScope: OptimizationScope, variablesScope: OptimizationScope) {}

        override fun simplify(constantScope: OptimizationScope, variablesScope: OptimizationScope, useGlobalVars: Boolean): SimplifyResult {
            return SimplifyResult(null, false)
        }

        override fun generateByteCode(helper: ASMHelper, scope: Scope, functionsList: HashMap<String, FunctionNode>) {
            helper.mv!!.visitTypeInsn(NEW, "java/lang/String")
            helper.mv!!.visitInsn(DUP)
            helper.mv!!.visitLdcInsn(value as String)
            helper.mv!!.visitMethodInsn(INVOKESPECIAL, "java/lang/String", "<init>", "(Ljava/lang/String;)V", false)
        }

        override fun hasFunctionCalls(): Boolean {
            return false
        }
    }
}