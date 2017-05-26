package izakirzyanov.compiler.ast.statement

import izakirzyanov.compiler.ast.ASMHelper
import izakirzyanov.compiler.ast.FunctionNode
import izakirzyanov.compiler.ast.SimplifyResult
import izakirzyanov.compiler.ast.Type
import izakirzyanov.compiler.ast.expr.ExprNode
import izakirzyanov.compiler.errors.CompileError
import izakirzyanov.compiler.scope.OptimizationScope
import izakirzyanov.compiler.scope.Scope
import org.antlr.v4.runtime.ParserRuleContext
import org.objectweb.asm.Opcodes.*
import java.util.*

class ArraySetterNode(val name: String, var indices: List<ExprNode>, var expr: ExprNode, ctx: ParserRuleContext) : StatementNode(ctx) {
    override fun checkForErrorsAndInferType(scope: Scope, functionsList: HashMap<String, FunctionNode>): List<CompileError> {
        val errors = ArrayList<CompileError>()
        errors.addAll(expr.checkForErrorsAndInferType(scope, functionsList))
        val fullType = scope.getType(name)
        if (fullType == null) {
            errors.add(CompileError.VariableIsNotDefined(name, ctx.getStart().line, ctx.getStart().charPositionInLine))
        } else {
            if (fullType != Type.Unknown) {
                if (fullType !is Type.Arr<*>) {
                    errors.add(CompileError.VariableIsNotArray(name, fullType, ctx.getStart().line, ctx.getStart().charPositionInLine))
                } else if (fullType.getArrayDepth() < indices.size) {
                    errors.add(CompileError.VariableIsNotArray(Type.Arr.buildArrCall(name, indices), fullType.getPrimitiveType(), ctx.getStart().line, ctx.getStart().charPositionInLine))
                } else {
                    val leftType = fullType.getSubType(indices)
                    if (leftType != expr.type) {
                        if (expr.type != Type.Unknown) {
                            errors.add(CompileError.VariableTypeMismatch(name, expr.type, leftType, ctx.getStart().line, ctx.getStart().charPositionInLine))
                        }
                    }
                }
            }
        }
        indices.forEach {
            errors.addAll(it.checkForErrorsAndInferType(scope, functionsList))
            if (it.type != Type.Integer) {
                errors.add(CompileError.ArrayIndicesShouldBeInt(it.type, it.ctx.text, it.ctx.getStart().line, it.ctx.getStart().charPositionInLine))
            }
        }
        return errors
    }

    override fun countLeftAndRightUsesOnly(constantScope: OptimizationScope, variablesScope: OptimizationScope) {
        indices.forEach { it.countLeftAndRightUsesOnly(constantScope, variablesScope) }
        expr.countLeftAndRightUsesOnly(constantScope, variablesScope)
    }

    override fun simplify(constantScope: OptimizationScope, variablesScope: OptimizationScope, useGlobalVars: Boolean): SimplifyResult {
        val newIndices = ArrayList<ExprNode>()
        var changed = false
        var resIn: SimplifyResult
        indices.forEach {
            resIn = it.simplify(constantScope, variablesScope, useGlobalVars)
            newIndices.add((resIn.newNode as? ExprNode) ?: it)
            changed = changed || resIn.changed
        }
        indices = newIndices

        val res = expr.simplify(constantScope, variablesScope, useGlobalVars)
        if (res.newNode != null) {
            expr = res.newNode as ExprNode
        }
        changed = changed || res.changed

        return SimplifyResult(null, changed)
    }

    override fun generateByteCode(helper: ASMHelper, scope: Scope, functionsList: HashMap<String, FunctionNode>) {
        var type = scope.getType(name)
        helper.mv!!.visitVarInsn(ALOAD, scope.getVarNum(name))
        indices.dropLast(1).forEach {
            it.generateByteCode(helper, scope, functionsList)
            helper.mv!!.visitInsn(AALOAD)
            type = (type as Type.Arr<*>).type
        }
        indices.last().generateByteCode(helper, scope, functionsList)
        expr.generateByteCode(helper, scope, functionsList)
        if (expr.type == Type.Integer) {
            helper.mv!!.visitInsn(IASTORE)
        } else if (expr.type == Type.Bool) {
            helper.mv!!.visitInsn(BASTORE)
        } else if (expr.type == Type.Str || expr.type is Type.Arr<*>) {
            helper.mv!!.visitInsn(AASTORE)
        }
    }
}