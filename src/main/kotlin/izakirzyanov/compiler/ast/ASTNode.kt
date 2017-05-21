package izakirzyanov.compiler.ast

import org.antlr.v4.runtime.ParserRuleContext
import org.objectweb.asm.ClassWriter
import org.objectweb.asm.FieldVisitor
import org.objectweb.asm.MethodVisitor

abstract class ASTNode(val ctx: ParserRuleContext) {
    abstract fun generateByteCode(helper: ASMHelper)
}

data class ASMHelper(val cw: ClassWriter, var fv: FieldVisitor?, var mv: MethodVisitor?, val className: String)
