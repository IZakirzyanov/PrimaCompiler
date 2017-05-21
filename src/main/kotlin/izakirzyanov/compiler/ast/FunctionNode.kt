package izakirzyanov.compiler.ast

import izakirzyanov.compiler.errors.CompileError
import izakirzyanov.compiler.errors.CompileError.DuplicatedArgument
import izakirzyanov.compiler.Scope
import org.antlr.v4.runtime.ParserRuleContext
import org.objectweb.asm.Opcodes.*
import java.util.*

class FunctionNode(val signature: FunctionSignatureNode, val body: StatementNode.BlockNode, ctx: ParserRuleContext) : ASTNode(ctx) {
    fun checkForErrorsAndTypes(scope: Scope, functionsList: HashMap<String, FunctionNode>): List<CompileError> {
        val errors = ArrayList<CompileError>()
        val args = HashSet<String>()
        signature.arguments?.forEach {
            if (args.contains(it.name)) {
                errors.add(DuplicatedArgument(it.name, it.ctx.getStart().line, it.ctx.getStart().charPositionInLine))
            }
            args.add(it.name)
            scope.putVariableWithOverride(it.name, it.type)
        }
        body.setNameOfFunInReturn(signature.name)
        if (!body.alwaysReturns() && signature.type != Type.Void) {
            errors.add(CompileError.FunctionMayNotReturnValue(signature.name, ctx.getStart().line, ctx.getStart().charPositionInLine))
        }

        errors.addAll(body.checkForErrorsAndTypes(scope, functionsList))
        return errors
    }

    override fun generateByteCode(helper: ASMHelper) {
        helper.mv = helper.cw.visitMethod(ACC_PUBLIC + ACC_STATIC, signature.name, signature.toJVMType(), null, null)
        helper.mv!!.visitCode()
        body.generateByteCode(helper)
        if (signature.type == Type.Void) {
            helper.mv!!.visitInsn(RETURN)
        }
        helper.mv!!.visitMaxs(0, 0)
        helper.mv!!.visitEnd()
    }

}

class FunctionSignatureNode(val name: String, val arguments: List<ArgumentNode>? = null, val type: Type, ctx: ParserRuleContext) : ASTNode(ctx) {
    override fun toString(): String {
        return "fun " + name + "(" + argumentsToString() + "): " + type.toString()
    }

    private fun argumentsToString(): String {
        if (arguments == null) {
            return ""
        } else {
            return arguments.joinToString(", ")
        }
    }

    override fun generateByteCode(helper: ASMHelper) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    fun toJVMType(): String {
        if (name == "main") {
            return "([Ljava/lang/String;)V"
        } else {
            return "(" + arguments?.map { it.type.toJVMType() }?.joinToString { "" } + ")" + type.toJVMType()
        }
    }

}

class ArgumentNode(val name: String, val type: Type, ctx: ParserRuleContext) : ASTNode(ctx) {
    override fun toString(): String {
        return "$name: $type"
    }

    override fun generateByteCode(helper: ASMHelper) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}