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
import org.objectweb.asm.Opcodes.GETSTATIC
import org.objectweb.asm.Opcodes.INVOKEVIRTUAL
import java.util.*

class WriteNode(val nextLine: Boolean = true, var expr: ExprNode? = null, ctx: ParserRuleContext) : StatementNode(ctx) {
    override fun checkForErrorsAndInferType(scope: Scope, functionsList: HashMap<String, FunctionNode>): List<CompileError> {
        val errors = ArrayList<CompileError>()
        errors.addAll(expr?.checkForErrorsAndInferType(scope, functionsList) ?: emptyList())
        val valType = expr?.type
        if (valType != null && !valType.isPrimitive) {
            if (valType != Type.Unknown) {
                errors.add(CompileError.WriteIsNotDefinedForNonPrimitiveTypes(valType, ctx.getStart().line, ctx.getStart().charPositionInLine))
            }
        }
        return errors
    }

    override fun countLeftAndRightUsesOnly(constantScope: OptimizationScope, variablesScope: OptimizationScope) {
        expr?.countLeftAndRightUsesOnly(constantScope, variablesScope)
    }

    override fun simplify(constantScope: OptimizationScope, variablesScope: OptimizationScope, useGlobalVars: Boolean): SimplifyResult {
        val expr = expr
        if (expr != null) {
            val res = expr.simplify(constantScope, variablesScope, useGlobalVars)
            if (res.newNode != null) {
                this.expr = res.newNode as ExprNode
            }
            return SimplifyResult(null, res.changed)
        }
        return SimplifyResult(null, false)
    }

    override fun generateByteCode(helper: ASMHelper, scope: Scope, functionsList: HashMap<String, FunctionNode>) {
        if (nextLine) {
            helper.mv!!.visitFieldInsn(GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;")
            expr?.generateByteCode(helper, scope, functionsList)
            helper.mv!!.visitMethodInsn(INVOKEVIRTUAL, "java/io/PrintStream", "println", "(" + (expr?.type?.toJVMType() ?: "") + ")V", false)
        } else {
            val expr = expr
            if (expr != null) {
                helper.mv!!.visitFieldInsn(GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;")
                expr.generateByteCode(helper, scope, functionsList)
                helper.mv!!.visitMethodInsn(INVOKEVIRTUAL, "java/io/PrintStream", "print", "(" + expr.type.toJVMType() + ")V", false)
            }
        }
    }
}