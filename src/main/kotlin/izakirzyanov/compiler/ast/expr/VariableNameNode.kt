package izakirzyanov.compiler.ast.expr

import izakirzyanov.compiler.scope.Scope
import izakirzyanov.compiler.ast.ASMHelper
import izakirzyanov.compiler.ast.FunctionNode
import izakirzyanov.compiler.ast.Type
import izakirzyanov.compiler.errors.CompileError
import org.antlr.v4.runtime.ParserRuleContext
import org.objectweb.asm.Opcodes.*
import java.util.ArrayList
import java.util.HashMap

class VariableNameNode(val name: String, ctx: ParserRuleContext) : ExprNode(ctx) {
    override fun checkForErrorsAndInferType(scope: Scope, functionsList: HashMap<String, FunctionNode>): List<CompileError> {
        val errors = ArrayList<CompileError>()
        if (scope.getType(name) == null) {
            errors.add(CompileError.VariableIsNotDefined(name, ctx.getStart().line, ctx.getStart().charPositionInLine))
        }
        type = scope.getType(name) ?: Type.Unknown
        return errors
    }

    override fun generateByteCode(helper: ASMHelper, scope: Scope, functionsList: HashMap<String, FunctionNode>) {
        if (scope.isGlobal(name)) {
            helper.mv!!.visitFieldInsn(GETSTATIC, helper.className, name, scope.getType(name)?.toJVMType())
        } else {
            if (scope.getType(name) == Type.Integer || scope.getType(name) == Type.Bool) {
                helper.mv!!.visitVarInsn(ILOAD, scope.getVarNum(name))
            } else if (scope.getType(name) == Type.Str) {
                helper.mv!!.visitVarInsn(ALOAD, scope.getVarNum(name))
            } else if (scope.getType(name) is Type.Arr<*>) {
                helper.mv!!.visitVarInsn(ALOAD, scope.getVarNum(name))
            }
        }
    }
}