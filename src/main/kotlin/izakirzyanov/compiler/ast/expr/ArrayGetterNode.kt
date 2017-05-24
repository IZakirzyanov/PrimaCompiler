package izakirzyanov.compiler.ast.expr

import izakirzyanov.compiler.Scope
import izakirzyanov.compiler.ast.ASMHelper
import izakirzyanov.compiler.ast.FunctionNode
import izakirzyanov.compiler.ast.Type
import izakirzyanov.compiler.errors.CompileError
import org.antlr.v4.runtime.ParserRuleContext
import org.objectweb.asm.Opcodes.*
import java.util.ArrayList
import java.util.HashMap

class ArrayGetterNode(val name: String, val indices: List<ExprNode>, ctx: ParserRuleContext) : ExprNode(ctx) {
    override fun checkForErrorsAndInferType(scope: Scope, functionsList: HashMap<String, FunctionNode>): List<CompileError> {
        val errors = ArrayList<CompileError>()
        val fullType = scope.getType(name)
        if (fullType == null) {
            errors.add(CompileError.VariableIsNotDefined(name, ctx.getStart().line, ctx.getStart().charPositionInLine))
        } else {
            if (fullType !is Type.Arr<*>) {
                errors.add(CompileError.VariableIsNotArray(name, fullType, ctx.getStart().line, ctx.getStart().charPositionInLine))
            } else if (fullType.getArrayDepth() < indices.size) {
                errors.add(CompileError.VariableIsNotArray(Type.Arr.buildArrCall(name, indices), fullType.getPrimitiveType(), ctx.getStart().line, ctx.getStart().charPositionInLine))
            }
        }
        type = (fullType as? Type.Arr<*>)?.getSubType(indices) ?: Type.Unknown
        return errors
    }

    override fun generateByteCode(helper: ASMHelper, scope: Scope, functionsList: HashMap<String, FunctionNode>) {
        var type = scope.getType(name)
        if (scope.isGlobal(name)) {
            helper.mv!!.visitFieldInsn(GETSTATIC, helper.className, name, scope.getType(name)?.toJVMType())
        } else {
            helper.mv!!.visitVarInsn(ALOAD, scope.getVarNum(name))
        }
        indices.forEach {
            it.generateByteCode(helper, scope, functionsList)
            if (!(type as Type.Arr<*>).type.isPrimitive) {
                helper.mv!!.visitInsn(AALOAD)
            }
            type = (type as Type.Arr<*>).type
        }
        if (type == Type.Integer) {
            helper.mv!!.visitInsn(IALOAD)
        } else if (type == Type.Bool) {
            helper.mv!!.visitInsn(BALOAD)
        } else if (type == Type.Str || type is Type.Arr<*>) {
            helper.mv!!.visitInsn(AALOAD)
        }
    }
}