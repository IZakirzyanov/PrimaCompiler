package izakirzyanov.compiler.ast

import izakirzyanov.compiler.ast.statement.BlockNode
import izakirzyanov.compiler.errors.CompileError
import izakirzyanov.compiler.scope.OptimizationScope
import izakirzyanov.compiler.scope.Scope
import org.antlr.v4.runtime.ParserRuleContext
import org.objectweb.asm.Opcodes.*
import java.util.*

class FunctionNode(val signature: FunctionSignatureNode, var body: BlockNode, ctx: ParserRuleContext) : ASTNode(ctx) {
    override fun checkForErrorsAndInferType(scope: Scope, functionsList: HashMap<String, FunctionNode>): List<CompileError> {
        val errors = ArrayList<CompileError>()
        errors.addAll(signature.checkForErrorsAndInferType(scope, functionsList))
        scope.beginNewScope()
        body.setNameOfFunInReturn(signature.name)
        if (!body.alwaysReturns() && signature.type != Type.Void) {
            errors.add(CompileError.FunctionMayNotReturnValue(signature.name, ctx.getStart().line, ctx.getStart().charPositionInLine))
        }
        errors.addAll(body.checkForErrorsAndInferType(scope, functionsList))
        scope.endScope()
        return errors
    }

    override fun countLeftAndRightUsesOnly(constantScope: OptimizationScope, variablesScope: OptimizationScope) {
        body.countLeftAndRightUsesOnly(constantScope, variablesScope)
    }

    override fun simplify(constantScope: OptimizationScope, variablesScope: OptimizationScope, useGlobalVars: Boolean): SimplifyResult {
        constantScope.beginNewScope()
        variablesScope.beginNewScope()
        val bodyRes = body.simplify(constantScope, variablesScope, useGlobalVars)
        if (bodyRes.newNode != null) {
            body = bodyRes.newNode as BlockNode
        }
        variablesScope.endScope()
        constantScope.endScope()
        return SimplifyResult(null, bodyRes.changed)
    }

    override fun generateByteCode(helper: ASMHelper, scope: Scope, functionsList: HashMap<String, FunctionNode>) {
        scope.resetVarNums()
        scope.beginNewScope()
        signature.generateByteCode(helper, scope, functionsList)
        helper.mv!!.visitCode()
        body.generateByteCode(helper, scope, functionsList)
        if (signature.type == Type.Void) {
            helper.mv!!.visitInsn(RETURN)
        }
        helper.mv!!.visitMaxs(0, 0)
        helper.mv!!.visitEnd()
        scope.endScope()
    }

}

class FunctionSignatureNode(val name: String, val arguments: List<ArgumentNode>? = null, val type: Type, ctx: ParserRuleContext) : ASTNode(ctx) {
    override fun checkForErrorsAndInferType(scope: Scope, functionsList: HashMap<String, FunctionNode>): List<CompileError> {
        val errors = ArrayList<CompileError>()
        val args = HashSet<String>()

        arguments?.forEach {
            if (args.contains(it.name)) {
                errors.add(CompileError.VariableIsAlreadyDefinedInThisScope(it.name, it.ctx.getStart().line, it.ctx.getStart().charPositionInLine))
            }
            args.add(it.name)
            scope.putVariableWithOverride(it.name, it.type)
        }
        return errors
    }

    override fun countLeftAndRightUsesOnly(constantScope: OptimizationScope, variablesScope: OptimizationScope) {}

    override fun simplify(constantScope: OptimizationScope, variablesScope: OptimizationScope, useGlobalVars: Boolean): SimplifyResult {
        return SimplifyResult(null, false)
    }

    override fun generateByteCode(helper: ASMHelper, scope: Scope, functionsList: HashMap<String, FunctionNode>) {
        if (name == "main") {
            scope.varNums++
        }
        arguments?.forEach { it.generateByteCode(helper, scope, functionsList) }
        helper.mv = helper.cw.visitMethod(ACC_PUBLIC + ACC_STATIC, name, this.toJVMType(), null, null)
    }

    fun toJVMType(): String {
        if (name == "main") {
            return "([Ljava/lang/String;)V"
        } else {
            return "(" + (arguments?.map { it.type.toJVMType() }?.joinToString(separator = "") ?: "") + ")" + type.toJVMType()
        }
    }

    override fun toString(): String {
        return "fun " + name + "(" + (arguments?.joinToString(", ") ?: "") + "): " + type.toString()
    }
}

class ArgumentNode(val name: String, val type: Type, ctx: ParserRuleContext) : ASTNode(ctx) {
    override fun checkForErrorsAndInferType(scope: Scope, functionsList: HashMap<String, FunctionNode>): List<CompileError> {
        return emptyList()
    }

    override fun countLeftAndRightUsesOnly(constantScope: OptimizationScope, variablesScope: OptimizationScope) {}

    override fun simplify(constantScope: OptimizationScope, variablesScope: OptimizationScope, useGlobalVars: Boolean): SimplifyResult {
        return SimplifyResult(null, false)
    }

    override fun generateByteCode(helper: ASMHelper, scope: Scope, functionsList: HashMap<String, FunctionNode>) {
        scope.putVariableWithOverride(name, type)
    }

    override fun toString(): String {
        return "$name: $type"
    }
}