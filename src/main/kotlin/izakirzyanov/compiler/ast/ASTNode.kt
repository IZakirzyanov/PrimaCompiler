package izakirzyanov.compiler.ast

import izakirzyanov.compiler.errors.CompileError
import izakirzyanov.compiler.scope.OptimizationScope
import izakirzyanov.compiler.scope.Scope
import org.antlr.v4.runtime.ParserRuleContext
import org.objectweb.asm.ClassWriter
import org.objectweb.asm.FieldVisitor
import org.objectweb.asm.MethodVisitor
import java.util.*

abstract class ASTNode(val ctx: ParserRuleContext) {
    abstract fun checkForErrorsAndInferType(scope: Scope, functionsList: HashMap<String, FunctionNode>): List<CompileError>
    abstract fun <T> simplify(scope: OptimizationScope): SimplifyResult<T>
    abstract fun generateByteCode(helper: ASMHelper, scope: Scope, functionsList: HashMap<String, FunctionNode>)
}

data class ASMHelper(val cw: ClassWriter, var fv: FieldVisitor?, var mv: MethodVisitor?, val className: String)

data class SimplifyResult<T>(val newNode: T?, val changed: Boolean)
