package izakirzyanov.compiler.ast

import izakirzyanov.compiler.Scope
import org.antlr.v4.runtime.ParserRuleContext
import org.objectweb.asm.ClassWriter
import org.objectweb.asm.FieldVisitor
import org.objectweb.asm.MethodVisitor
import java.util.HashMap

abstract class ASTNode(val ctx: ParserRuleContext) {
    abstract fun generateByteCode(helper: ASMHelper, scope: Scope, functionsList: HashMap<String, FunctionNode>)
}

data class ASMHelper(val cw: ClassWriter, var fv: FieldVisitor?, var mv: MethodVisitor?, val className: String)
