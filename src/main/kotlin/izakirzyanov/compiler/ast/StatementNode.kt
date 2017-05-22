package izakirzyanov.compiler.ast

import izakirzyanov.compiler.PrimaParser
import izakirzyanov.compiler.errors.CompileError
import izakirzyanov.compiler.Scope
import org.antlr.v4.runtime.ParserRuleContext
import org.objectweb.asm.Label
import java.util.*
import org.objectweb.asm.Opcodes.*

sealed class StatementNode(ctx: ParserRuleContext) : ASTNode(ctx) {
    abstract fun checkForErrorsAndTypes(scope: Scope, functionsList: HashMap<String, FunctionNode>): List<CompileError>

    class NopNode(ctx: ParserRuleContext) : StatementNode(ctx) {
        override fun checkForErrorsAndTypes(scope: Scope, functionsList: HashMap<String, FunctionNode>): List<CompileError> {
            return emptyList()
        }

        override fun generateByteCode(helper: ASMHelper, scope: Scope, functionsList: HashMap<String, FunctionNode>) {}
    }

    class BlockNode(val statements: List<StatementNode>? = null, ctx: ParserRuleContext) : StatementNode(ctx) {

        override fun checkForErrorsAndTypes(scope: Scope, functionsList: HashMap<String, FunctionNode>): List<CompileError> {
            if (ctx.parent !is PrimaParser.FunctionDeclarationContext) {
                scope.beginNewScope()
            }
            val errors = ArrayList<CompileError>()
            statements?.forEach {
                if (it is ReturnNode && it != statements.last()) {
                    errors.add(CompileError.DeadCodeAfterReturn(it.ctx.getStart().line, it.ctx.getStart().charPositionInLine))
                }
                errors.addAll(it.checkForErrorsAndTypes(scope, functionsList))
            }
            if (ctx.parent !is PrimaParser.FunctionDeclarationContext) {
                scope.endScope()
            }
            return errors
        }

        fun setNameOfFunInReturn(name: String) {
            statements?.forEach {
                when (it) {
                    is BlockNode -> it.setNameOfFunInReturn(name)
                    is IfNode -> it.setNameOfFunInReturn(name)
                    is WhileNode -> it.setNameOfFunInReturn(name)
                    is ReturnNode -> it.setNameOfFunInReturn(name)
                }
            }
        }

        fun alwaysReturns(): Boolean {
            statements?.forEach {
                if (it is BlockNode) {
                    if (it.alwaysReturns()) {
                        return true
                    }
                }
                if (it is IfNode) {
                    if (it.alwaysReturns()) {
                        return true
                    }
                }
                if (it is WhileNode) {
                    if (it.alwaysReturns()) {
                        return true
                    }
                }
                if (it is ReturnNode) {
                    return true
                }
            }
            return false
        }

        override fun generateByteCode(helper: ASMHelper, scope: Scope, functionsList: HashMap<String, FunctionNode>) {
            if (ctx.parent !is PrimaParser.FunctionDeclarationContext) {
                scope.beginNewScope()
            }
            statements?.forEach { it.generateByteCode(helper, scope, functionsList) }
            if (ctx.parent !is PrimaParser.FunctionDeclarationContext) {
                scope.endScope()
            }
        }
    }

    class VarDeclarationNode(val name: String, val type: Type, val value: ExprNode, ctx: ParserRuleContext) : StatementNode(ctx) {
        override fun checkForErrorsAndTypes(scope: Scope, functionsList: HashMap<String, FunctionNode>): List<CompileError> {
            val errors = ArrayList<CompileError>()
            if (scope.definedInTheLastScope(name)) {
                errors.add(CompileError.VariableIsAlreadyDefinedInThisScope(name, ctx.getStart().line, ctx.getStart().charPositionInLine))
            } else {
                scope.putVariableWithOverride(name, type)
                errors.addAll(value.checkForErrorsAndInferType(scope, functionsList))
                if (type != value.type) {
                    errors.add(CompileError.VariableTypeMismatch(name, value.type, type, ctx.getStart().line, ctx.getStart().charPositionInLine))
                }
            }
            return errors
        }

        override fun generateByteCode(helper: ASMHelper, scope: Scope, functionsList: HashMap<String, FunctionNode>) {
            scope.putVariableWithOverride(name, type)
            value.generateByteCode(helper, scope, functionsList)
            helper.mv!!.visitVarInsn(ISTORE, scope.getVarNum(name))
        }
    }

    class AssignmentNode(val name: String, val value: ExprNode, ctx: ParserRuleContext) : StatementNode(ctx) {
        override fun checkForErrorsAndTypes(scope: Scope, functionsList: HashMap<String, FunctionNode>): List<CompileError> {
            val errors = ArrayList<CompileError>()
            errors.addAll(value.checkForErrorsAndInferType(scope, functionsList))
            val type = scope.getType(name)
            if (type == null) {
                errors.add(CompileError.VariableIsNotDefined(name, ctx.getStart().line, ctx.getStart().charPositionInLine))
            } else if (value.type != type) {
                errors.add(CompileError.VariableTypeMismatch(name, value.type, type, ctx.getStart().line, ctx.getStart().charPositionInLine))
            }
            return errors
        }

        override fun generateByteCode(helper: ASMHelper, scope: Scope, functionsList: HashMap<String, FunctionNode>) {
            value.generateByteCode(helper, scope, functionsList)
            if (scope.isGlobal(name)) {
                helper.mv!!.visitFieldInsn(PUTSTATIC, helper.className, name, scope.getType(name)?.toJVMType())
            } else {
                helper.mv!!.visitVarInsn(ISTORE, scope.getVarNum(name))
            }
        }
    }

    class IfNode(val condition: ExprNode, val thenBlock: BlockNode, val elseBlock: BlockNode? = null, ctx: ParserRuleContext) : StatementNode(ctx) {
        override fun checkForErrorsAndTypes(scope: Scope, functionsList: HashMap<String, FunctionNode>): List<CompileError> {
            val errors = ArrayList<CompileError>()
            errors.addAll(condition.checkForErrorsAndInferType(scope, functionsList))
            if (condition.type != Type.Bool) {
                errors.add(CompileError.IfConditionMustBeBoolean(condition.type, condition.ctx.getStart().line, condition.ctx.getStart().charPositionInLine))
            }

            errors.addAll(thenBlock.checkForErrorsAndTypes(scope, functionsList))
            if (elseBlock != null) {
                errors.addAll(elseBlock.checkForErrorsAndTypes(scope, functionsList))
            }
            return errors
        }

        fun setNameOfFunInReturn(name: String) {
            thenBlock.setNameOfFunInReturn(name)
            elseBlock?.setNameOfFunInReturn(name)
        }

        fun alwaysReturns(): Boolean {
            return thenBlock.alwaysReturns() && (elseBlock?.alwaysReturns() ?: true)
        }

        override fun generateByteCode(helper: ASMHelper, scope: Scope, functionsList: HashMap<String, FunctionNode>) {
            condition.generateByteCode(helper, scope, functionsList)
            val l0 = Label()
            helper.mv!!.visitJumpInsn(IFEQ, l0)
            thenBlock.generateByteCode(helper, scope, functionsList)
            helper.mv!!.visitLabel(l0)
            elseBlock?.generateByteCode(helper, scope, functionsList)
        }
    }

    class WhileNode(val condition: ExprNode, val body: BlockNode, ctx: ParserRuleContext) : StatementNode(ctx) {
        override fun checkForErrorsAndTypes(scope: Scope, functionsList: HashMap<String, FunctionNode>): List<CompileError> {
            val errors = ArrayList<CompileError>()
            errors.addAll(condition.checkForErrorsAndInferType(scope, functionsList))
            if (condition.type != Type.Bool) {
                errors.add(CompileError.WhileConditionMustBeBoolean(condition.type, condition.ctx.getStart().line, condition.ctx.getStart().charPositionInLine))
            }

            errors.addAll(body.checkForErrorsAndTypes(scope, functionsList))
            return errors
        }

        fun setNameOfFunInReturn(name: String) {
            body.setNameOfFunInReturn(name)
        }

        fun alwaysReturns(): Boolean {
            return body.alwaysReturns()
        }

        override fun generateByteCode(helper: ASMHelper, scope: Scope, functionsList: HashMap<String, FunctionNode>) {
            val l0 = Label()
            helper.mv!!.visitLabel(l0)
            condition.generateByteCode(helper, scope, functionsList)
            val l1 = Label()
            helper.mv!!.visitJumpInsn(IFEQ, l1)
            body.generateByteCode(helper, scope, functionsList)
            helper.mv!!.visitJumpInsn(GOTO, l0)
            helper.mv!!.visitLabel(l1)
        }
    }

    class WriteNode(val nextLine: Boolean = true, val value: ExprNode? = null, ctx: ParserRuleContext) : StatementNode(ctx) {
        override fun checkForErrorsAndTypes(scope: Scope, functionsList: HashMap<String, FunctionNode>): List<CompileError> {
            return value?.checkForErrorsAndInferType(scope, functionsList) ?: emptyList()
        }

        override fun generateByteCode(helper: ASMHelper, scope: Scope, functionsList: HashMap<String, FunctionNode>) {
            if (nextLine) {
                helper.mv!!.visitFieldInsn(GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;")
                value?.generateByteCode(helper, scope, functionsList)
                helper.mv!!.visitMethodInsn(INVOKEVIRTUAL, "java/io/PrintStream", "println", "(" + (value?.type?.toJVMType() ?: "") + ")V", false)
            } else {
                if (value != null) {
                    helper.mv!!.visitFieldInsn(GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;")
                    value.generateByteCode(helper, scope, functionsList)
                    helper.mv!!.visitMethodInsn(INVOKEVIRTUAL, "java/io/PrintStream", "print", "(" + value.type.toJVMType() + ")V", false)
                }
            }
        }
    }

    class ReturnNode(val value: ExprNode, ctx: ParserRuleContext) : StatementNode(ctx) {
        lateinit var funName: String

        override fun checkForErrorsAndTypes(scope: Scope, functionsList: HashMap<String, FunctionNode>): List<CompileError> {
            val errors = ArrayList<CompileError>()
            errors.addAll(value.checkForErrorsAndInferType(scope, functionsList))
            val actual = value.type
            val expected = functionsList[funName]?.signature?.type ?: Type.Void
            if (actual != expected) {
                errors.add(CompileError.ReturnTypeMismatch(funName, actual, expected, ctx.getStart().line, ctx.getStart().charPositionInLine))
            }
            return errors
        }

        fun setNameOfFunInReturn(name: String) {
            funName = name
        }

        override fun generateByteCode(helper: ASMHelper, scope: Scope, functionsList: HashMap<String, FunctionNode>) {
            value.generateByteCode(helper, scope, functionsList)
            helper.mv!!.visitInsn(IRETURN)
        }
    }

    class FunctionCallStatementNode(val name: String, val arguments: List<ExprNode>? = null, ctx: ParserRuleContext) : StatementNode(ctx) {
        override fun checkForErrorsAndTypes(scope: Scope, functionsList: HashMap<String, FunctionNode>): List<CompileError> {
            val errors = ArrayList<CompileError>()

            val argsActual = arguments ?: ArrayList()
            val argsActuallyNum = argsActual.size
            val argsExpected = functionsList[name]?.signature?.arguments ?: ArrayList()
            val argsExpectedNum = argsExpected.size

            if (!functionsList.containsKey(name)) {
                errors.add(CompileError.FunctionIsNotDefined(name, ctx.getStart().line, ctx.getStart().charPositionInLine))
            } else if (argsActuallyNum != argsExpectedNum) {
                errors.add(CompileError.WrongNumberOfArguments(name, argsActuallyNum, argsExpectedNum, ctx.getStart().line, ctx.getStart().charPositionInLine))
            } else {
                argsActual.zip(argsExpected).forEach {
                    errors.addAll(it.first.checkForErrorsAndInferType(scope, functionsList))
                    if (it.first.type != it.second.type) {
                        errors.add(CompileError.ArgumentTypeMismatch(it.second.name, it.first.type, it.second.type,
                                it.first.ctx.getStart().line, it.first.ctx.getStart().charPositionInLine))
                    }
                }
            }
            return errors
        }

        override fun generateByteCode(helper: ASMHelper, scope: Scope, functionsList: HashMap<String, FunctionNode>) {
            arguments?.forEach { it.generateByteCode(helper, scope, functionsList) }
            helper.mv!!.visitMethodInsn(INVOKESTATIC, helper.className, name, functionsList[name]?.signature?.toJVMType(), false)
            if (functionsList[name]?.signature?.type != Type.Void) {
                helper.mv!!.visitInsn(POP)
            }
        }
    }
}