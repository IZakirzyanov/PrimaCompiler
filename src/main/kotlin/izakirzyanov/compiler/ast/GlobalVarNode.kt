package izakirzyanov.compiler.ast

import izakirzyanov.compiler.Scope
import izakirzyanov.compiler.errors.CompileError
import org.antlr.v4.runtime.ParserRuleContext
import org.objectweb.asm.Opcodes.*
import java.util.*

class GlobalVarNode(val primitiveVarNode: StatementNode.PrimitiveVarDeclarationNode, ctx: ParserRuleContext) : ASTNode(ctx) {
    fun checkForErrorsAndTypes(scope: Scope, functionsList: HashMap<String, FunctionNode>): Collection<CompileError> {
        return primitiveVarNode.checkForErrorsAndTypes(scope, functionsList)
    }

    override fun generateByteCode(helper: ASMHelper, scope: Scope, functionsList: HashMap<String, FunctionNode>) {
        scope.putVariableWithOverride(primitiveVarNode.name, primitiveVarNode.type)
        helper.cw.visitField(ACC_PUBLIC + ACC_STATIC, primitiveVarNode.name, primitiveVarNode.type.toJVMType(), null, null).visitEnd()
        primitiveVarNode.value.generateByteCode(helper, scope, functionsList)
        helper.mv!!.visitFieldInsn(PUTSTATIC, helper.className, primitiveVarNode.name, primitiveVarNode.type.toJVMType())
    }
}