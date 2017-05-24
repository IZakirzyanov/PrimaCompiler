package izakirzyanov.compiler.ast

import izakirzyanov.compiler.ast.statement.VarDeclarationNode
import izakirzyanov.compiler.errors.CompileError
import izakirzyanov.compiler.scope.OptimizationScope
import izakirzyanov.compiler.scope.Scope
import org.antlr.v4.runtime.ParserRuleContext
import org.objectweb.asm.Opcodes.*
import java.util.*

class GlobalVarNode(val varNode: VarDeclarationNode, ctx: ParserRuleContext) : ASTNode(ctx) {
    override fun checkForErrorsAndInferType(scope: Scope, functionsList: HashMap<String, FunctionNode>): List<CompileError> {
        return varNode.checkForErrorsAndInferType(scope, functionsList)
    }

    override fun <T> simplify(scope: OptimizationScope): SimplifyResult<T> {
        val res = varNode.simplify<VarDeclarationNode>(scope)
        assert(res.newNode == null)
        return SimplifyResult(null, res.changed)
    }

    override fun generateByteCode(helper: ASMHelper, scope: Scope, functionsList: HashMap<String, FunctionNode>) {
        if (varNode is VarDeclarationNode.PrimitiveVarDeclarationNode) {
            scope.putVariableWithOverride(varNode.name, varNode.type)
            helper.cw.visitField(ACC_PUBLIC + ACC_STATIC, varNode.name, varNode.type.toJVMType(), null, null).visitEnd()
            varNode.expr.generateByteCode(helper, scope, functionsList)
            helper.mv!!.visitFieldInsn(PUTSTATIC, helper.className, varNode.name, varNode.type.toJVMType())
        } else if (varNode is VarDeclarationNode.ArrayVarDeclarationNode) {
            scope.putVariableWithOverride(varNode.name, varNode.type)
            helper.cw.visitField(ACC_PUBLIC + ACC_STATIC, varNode.name, varNode.type.toJVMType(), null, null).visitEnd()
            varNode.sizes.forEach { it.generateByteCode(helper, scope, functionsList) }
            helper.mv!!.visitMultiANewArrayInsn(varNode.type.toJVMType(), varNode.sizes.size)
            helper.mv!!.visitFieldInsn(PUTSTATIC, helper.className, varNode.name, varNode.type.toJVMType())
        }
    }
}