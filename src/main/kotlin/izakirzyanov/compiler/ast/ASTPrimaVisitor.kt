package izakirzyanov.compiler.ast

import izakirzyanov.compiler.PrimaBaseVisitor
import izakirzyanov.compiler.PrimaParser
import izakirzyanov.compiler.ast.ExprNode.*
import izakirzyanov.compiler.ast.StatementNode.*

class ASTPrimaVisitor : PrimaBaseVisitor<ASTNode>() {
    override fun visitProgram(ctx: PrimaParser.ProgramContext): ProgramNode {
        val functions = ctx.functionDeclaration().map { visitFunctionDeclaration(it) }.toList()
        val globalVars = ctx.globalVarDeclaration().map { visitGlobalVarDeclaration(it) }.toList()
        return ProgramNode(functions, globalVars, ctx)
    }

    override fun visitGlobalVarDeclaration(ctx: PrimaParser.GlobalVarDeclarationContext): GlobalVarNode {
        val varDeclarationContext = ctx.varDeclarationStatement().varDeclaration()
        val name = varDeclarationContext.name.text
        val type = varDeclarationContext.nonVoidType().text.toTypeNode()
        val expr = varDeclarationContext.expr()?.let { visitEXPR(it) }
        return GlobalVarNode(VarDeclarationNode(name, type, expr, varDeclarationContext), ctx)
    }

    override fun visitFunctionDeclaration(ctx: PrimaParser.FunctionDeclarationContext): FunctionNode {
        val signature = visitFunctionSignature(ctx.functionSignature())
        val body = visitBlock(ctx.block())
        return FunctionNode(signature, body, ctx)
    }

    override fun visitFunctionSignature(ctx: PrimaParser.FunctionSignatureContext): FunctionSignatureNode {
        val name = ctx.name.text
        val arguments = ctx.functionArguments()?.functionArg()?.map { visitFunctionArg(it) }?.toList()
        val type = ctx.type().nonVoidType()?.text?.toTypeNode() ?: Type.Void
        return FunctionSignatureNode(name, arguments, type, ctx)
    }

    override fun visitFunctionArg(ctx: PrimaParser.FunctionArgContext): ArgumentNode {
        val name = ctx.name.text
        val type = ctx.nonVoidType().text.toTypeNode()
        return ArgumentNode(name, type, ctx)
    }

    override fun visitStatement(ctx: PrimaParser.StatementContext): StatementNode {
        if (ctx.nopStatement() != null) return visitNopStatement(ctx.nopStatement())
        if (ctx.block() != null) return visitBlock(ctx.block())
        if (ctx.varDeclarationStatement() != null) return visitVarDeclarationStatement(ctx.varDeclarationStatement())
        if (ctx.assignmentStatement() != null) return visitAssignmentStatement(ctx.assignmentStatement())
        if (ctx.ifStatement() != null) return visitIfStatement(ctx.ifStatement())
        if (ctx.whileStatement() != null) return visitWhileStatement(ctx.whileStatement())
        if (ctx.writeStatement() != null) return visitWriteStatement(ctx.writeStatement())
        if (ctx.returnStatement() != null) return visitReturnStatement(ctx.returnStatement())
        if (ctx.functionCallStatement() != null) return visitFunctionCallStatement(ctx.functionCallStatement())
        throw RuntimeException("Shouldn't be HERE!")
    }

    override fun visitNopStatement(ctx: PrimaParser.NopStatementContext): NopNode {
        return NopNode(ctx)
    }

    override fun visitBlock(ctx: PrimaParser.BlockContext): BlockNode {
        val statements = ctx.statement().map { visitStatement(it) }.toList()
        return BlockNode(statements, ctx)
    }

    override fun visitVarDeclarationStatement(ctx: PrimaParser.VarDeclarationStatementContext): VarDeclarationNode {
        return visitVarDeclaration(ctx.varDeclaration())
    }

    override fun visitVarDeclaration(ctx: PrimaParser.VarDeclarationContext): VarDeclarationNode {
        val name = ctx.name.text
        val type = ctx.nonVoidType().text.toTypeNode()
        val value = ctx.expr()?.let { visitEXPR(it) }
        return VarDeclarationNode(name, type, value, ctx)
    }

    override fun visitAssignmentStatement(ctx: PrimaParser.AssignmentStatementContext): AssignmentNode {
        return visitAssignment(ctx.assignment())
    }

    override fun visitAssignment(ctx: PrimaParser.AssignmentContext): AssignmentNode {
        val name = ctx.name.text
        val op = ctx.op.text
        val value = visitEXPR(ctx.expr())
        return AssignmentNode(name, op, value, ctx)
    }

    override fun visitIfStatement(ctx: PrimaParser.IfStatementContext): IfNode {
        val condition = visitEXPR(ctx.condition)
        val thenBlock = visitBlock(ctx.thenBlock)
        val elseBlock = ctx.elseBlock?.let { visitBlock(it) }
        return IfNode(condition, thenBlock, elseBlock, ctx)
    }

    override fun visitWhileStatement(ctx: PrimaParser.WhileStatementContext): WhileNode {
        val condition = visitEXPR(ctx.condition)
        val body = visitBlock(ctx.body)
        return WhileNode(condition, body, ctx)
    }

    override fun visitWriteStatement(ctx: PrimaParser.WriteStatementContext): WriteNode {
        return WriteNode(ctx.writeln != null, ctx.expr()?.let { visitEXPR(it) }, ctx)
    }

    override fun visitReturnStatement(ctx: PrimaParser.ReturnStatementContext): ReturnNode {
        return ReturnNode(visitEXPR(ctx.expr()), ctx)
    }

    override fun visitFunctionCallStatement(ctx: PrimaParser.FunctionCallStatementContext): FunctionCallStatementNode {
        val name = ctx.functionCall().name.text
        val arguments = ctx.functionCall().argumentList().expr().map { visitEXPR(it) }.toList()
        return FunctionCallStatementNode(name, arguments, ctx)
    }

    override fun visitEXPRParenthesis(ctx: PrimaParser.EXPRParenthesisContext): ExprNode {
        return visitEXPR(ctx.expr())
    }

    override fun visitEXPRLiteral(ctx: PrimaParser.EXPRLiteralContext): LiteralNode {
        if (ctx.boolLiteral() != null) {
            return LiteralNode.BoolLiteralNode(ctx.boolLiteral().text.toBoolean(), ctx)
        }
        if (ctx.intLiteral() != null) {
            return LiteralNode.IntLiteralNode(ctx.intLiteral().text.toInt(), ctx)
        }
        throw RuntimeException("This should never happen")
    }

    override fun visitEXPRVarName(ctx: PrimaParser.EXPRVarNameContext): VariableNameNode {
        return VariableNameNode(ctx.variableName().name.text, ctx)
    }

    override fun visitEXPRUnary(ctx: PrimaParser.EXPRUnaryContext): UnaryNode {
        return UnaryNode(ctx.op.text.toUnOp(), visitEXPR(ctx.expr()), ctx)
    }

    override fun visitEXPRBinary(ctx: PrimaParser.EXPRBinaryContext): BinaryNode {
        return BinaryNode(ctx.op.text.toBinOp(), visitEXPR(ctx.left), visitEXPR(ctx.right), ctx)
    }

    override fun visitEXPRReadCall(ctx: PrimaParser.EXPRReadCallContext): ReadCallNode {
        return ReadCallNode(readCallToType(ctx.readCall().name.text), ctx)
    }

    override fun visitEXPRFunctionCall(ctx: PrimaParser.EXPRFunctionCallContext): FunctionCallExprNode {
        val name = ctx.functionCall().name.text
        val arguments = ctx.functionCall().argumentList()?.expr()?.map { visitEXPR(it) }?.toList()
        return FunctionCallExprNode(name, arguments, ctx)
    }

    fun visitEXPR(ctx: PrimaParser.ExprContext): ExprNode {
        return when (ctx) {
            is PrimaParser.EXPRParenthesisContext -> visitEXPR(ctx.expr())
            is PrimaParser.EXPRLiteralContext -> visitEXPRLiteral(ctx)
            is PrimaParser.EXPRVarNameContext -> visitEXPRVarName(ctx)
            is PrimaParser.EXPRUnaryContext -> visitEXPRUnary(ctx)
            is PrimaParser.EXPRBinaryContext -> visitEXPRBinary(ctx)
            is PrimaParser.EXPRFunctionCallContext -> visitEXPRFunctionCall(ctx)
            is PrimaParser.EXPRReadCallContext -> visitEXPRReadCall(ctx)
            else -> throw RuntimeException("This should never happen")
        }
    }
}

fun readCallToType(str: String): Type {
    return when (str) {
        "readInt" -> Type.Integer
        "readBool" -> Type.Bool
        else -> throw RuntimeException("Shouldn't be here!")
    }
}