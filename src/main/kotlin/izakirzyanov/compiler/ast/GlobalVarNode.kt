package izakirzyanov.compiler.ast

import izakirzyanov.compiler.Scope
import izakirzyanov.compiler.errors.CompileError
import org.antlr.v4.runtime.ParserRuleContext
import org.objectweb.asm.Opcodes.*
import java.util.*

class GlobalVarNode(val varNode: StatementNode.VarDeclarationNode, ctx: ParserRuleContext) : ASTNode(ctx) {
    fun checkForErrorsAndTypes(scope: Scope, functionsList: HashMap<String, FunctionNode>): Collection<CompileError> {
        return varNode.checkForErrorsAndTypes(scope, functionsList)
    }

    override fun generateByteCode(helper: ASMHelper, scope: Scope, functionsList: HashMap<String, FunctionNode>) {
        scope.putVariableWithOverride(varNode.name, varNode.type)
        helper.cw.visitField(ACC_PUBLIC + ACC_STATIC, varNode.name, varNode.type.toJVMType(), null, null).visitEnd()
        varNode.value.generateByteCode(helper, scope, functionsList)
        helper.mv!!.visitFieldInsn(PUTSTATIC, helper.className, varNode.name, varNode.type.toJVMType())
    }
}