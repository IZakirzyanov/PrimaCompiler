package izakirzyanov.compiler.ast

import izakirzyanov.compiler.errors.CompileError
import izakirzyanov.compiler.errors.CompileError.FunctionIsAlreadyDefined
import izakirzyanov.compiler.scope.OptimizationScope
import izakirzyanov.compiler.scope.Scope
import org.antlr.v4.runtime.ParserRuleContext
import org.objectweb.asm.ClassWriter
import org.objectweb.asm.FieldVisitor
import org.objectweb.asm.MethodVisitor
import org.objectweb.asm.Opcodes.*
import java.util.*

class ProgramNode(val functions: ArrayList<FunctionNode>, var globalVars: ArrayList<GlobalVarNode>, ctx: ParserRuleContext) : ASTNode(ctx) {
    fun checkForErrorsAndInferType(): List<CompileError> {
        val scope = Scope()
        val functionsList = HashMap<String, FunctionNode>()
        return checkForErrorsAndInferType(scope, functionsList)
    }


    override fun checkForErrorsAndInferType(scope: Scope, functionsList: HashMap<String, FunctionNode>): List<CompileError> {
        val errors = ArrayList<CompileError>()

        globalVars.forEach {
            errors.addAll(it.checkForErrorsAndInferType(scope, functionsList))
        }

        functions.forEach {
            if (it.signature.name == "readInt" || it.signature.name == "readBool" || it.signature.name == "readStr" || it.signature.name == "write" || it.signature.name == "writeln") {
                errors.add(FunctionIsAlreadyDefined(it.signature.name, it.ctx.getStart().line, it.ctx.getStart().charPositionInLine))
            }
            if (!functionsList.containsKey(it.signature.name)) {
                functionsList.put(it.signature.name, it)
            } else {
                errors.add(FunctionIsAlreadyDefined(it.signature.name, it.ctx.getStart().line, it.ctx.getStart().charPositionInLine))
            }
        }

        functions.forEach {
            errors.addAll(it.checkForErrorsAndInferType(scope, functionsList))
        }
        val main = functionsList["main"]
        if (main == null) {
            errors.add(CompileError.MainFunctionIsMissed())
        } else if (main.signature.type != Type.Void || main.signature.arguments != null) {
            errors.add(CompileError.MainFunctionWrongSignature(main.signature.toString(), main.ctx.getStart().line, main.ctx.getStart().charPositionInLine))
        }

        errors.sortWith(Comparator({ err1, err2 ->
            if (err1.line != err2.line) {
                err1.line.compareTo(err2.line)
            } else {
                err1.column.compareTo(err2.column)
            }
        }))

        return errors
    }

    override fun simplify(scope: OptimizationScope, useGlobalVars: Boolean): SimplifyResult{
        var changed = false
        globalVars.forEach {
            val res = it.simplify(scope, true)
            assert(res.newNode == null)
            changed = changed || res.changed
        }

        functions.forEach {
            val res = it.simplify(scope, false)
            assert(res.newNode == null)
            changed = changed || res.changed
        }

        val newGlobalVars: ArrayList<GlobalVarNode> = ArrayList()
        globalVars.forEach {
            val info: OptimizationScope.ConstantInfo = scope.getValue(it.varNode.name)!!
            if (info.lused == 0) {
                info.useInPropagation = true
                changed = true
            }
            if (info.rused > 0) {
                newGlobalVars.add(it)
            } else {
                changed = true
            }
        }
        globalVars = newGlobalVars
        return SimplifyResult(null, changed)
    }

    fun simplify() {
        //global stays there during all iterations
        val scope = OptimizationScope()

        while (simplify(scope, false).changed) {
        }
    }

    fun getByteCode(className: String): ByteArray {
        val scope = Scope()
        val functionsList = HashMap<String, FunctionNode>()
        val cw = ClassWriter(ClassWriter.COMPUTE_FRAMES)
        val fv: FieldVisitor? = null
        val mv: MethodVisitor? = null
        generateByteCode(ASMHelper(cw, fv, mv, className), scope, functionsList)
        return cw.toByteArray()
    }

    override fun generateByteCode(helper: ASMHelper, scope: Scope, functionsList: HashMap<String, FunctionNode>) {
        helper.cw.visit(V1_7, ACC_PUBLIC + ACC_SUPER, helper.className, null, "java/lang/Object", null)
        helper.mv = helper.cw.visitMethod(0, "<init>", "()V", null, null)
        helper.mv!!.visitCode()
        helper.mv!!.visitVarInsn(ALOAD, 0)
        helper.mv!!.visitMethodInsn(INVOKESPECIAL, "java/lang/Object", "<init>", "()V", false)
        helper.mv!!.visitInsn(RETURN)
        helper.mv!!.visitMaxs(0, 0)
        helper.mv!!.visitEnd()

        if (globalVars.isNotEmpty()) {
            helper.mv = helper.cw.visitMethod(ACC_PUBLIC + ACC_STATIC, "<clinit>", "()V", null, null)
            helper.mv!!.visitCode()
            globalVars.forEach { it.generateByteCode(helper, scope, functionsList) }
            helper.mv!!.visitInsn(RETURN)
            helper.mv!!.visitMaxs(0, 0)
            helper.mv!!.visitEnd()
        }

        functions.forEach { functionsList.put(it.signature.name, it) }
        functions.forEach { it.generateByteCode(helper, scope, functionsList) }

        helper.cw.visitEnd()
    }
}