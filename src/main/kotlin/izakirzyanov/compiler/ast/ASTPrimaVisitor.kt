package izakirzyanov.compiler.ast

import izakirzyanov.compiler.PrimaBaseVisitor
import izakirzyanov.compiler.PrimaParser
import izakirzyanov.compiler.ast.expr.*
import izakirzyanov.compiler.ast.statement.*
import java.util.*

class ASTPrimaVisitor : PrimaBaseVisitor<ASTNode>() {
    override fun visitProgram(ctx: PrimaParser.ProgramContext): ProgramNode {
        val functions = ctx.functionDeclaration().map { visitFunctionDeclaration(it) }
        val globalVars = ctx.globalVarDeclaration().map { visitGlobalVarDeclaration(it) }
        return ProgramNode(ArrayList(functions), ArrayList(globalVars), ctx)
    }

    override fun visitGlobalVarDeclaration(ctx: PrimaParser.GlobalVarDeclarationContext): GlobalVarNode {
        return GlobalVarNode(visitVarDeclaration(ctx.varDeclarationStatement().varDeclaration()), ctx)
    }

    override fun visitFunctionDeclaration(ctx: PrimaParser.FunctionDeclarationContext): FunctionNode {
        return FunctionNode(visitFunctionSignature(ctx.functionSignature()), visitBlock(ctx.block()), ctx)
    }

    override fun visitFunctionSignature(ctx: PrimaParser.FunctionSignatureContext): FunctionSignatureNode {
        val arguments = ctx.functionArguments()?.functionArg()?.map { visitFunctionArg(it) }?.toList()
        val type = ctx.type().nonVoidType()?.text?.toTypeNode() ?: Type.Void
        return FunctionSignatureNode(ctx.name.text, arguments, type, ctx)
    }

    override fun visitFunctionArg(ctx: PrimaParser.FunctionArgContext): ArgumentNode {
        return ArgumentNode(ctx.name.text, ctx.nonVoidType().text.toTypeNode(), ctx)
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
        if (ctx.arraySetterStatement() != null) return visitArraySetterStatement(ctx.arraySetterStatement())
        if (ctx.forStatement() != null) return visitForStatement(ctx.forStatement())
        throw RuntimeException("Shouldn't be HERE!")
    }

    override fun visitNopStatement(ctx: PrimaParser.NopStatementContext): NopNode {
        return NopNode(ctx)
    }

    override fun visitBlock(ctx: PrimaParser.BlockContext): BlockNode {
        val statements = if (ctx.statement() != null) {
             ArrayList(ctx.statement().map { visitStatement(it) })
        } else {
            ArrayList()
        }
        return BlockNode(statements, ctx)
    }

    override fun visitVarDeclarationStatement(ctx: PrimaParser.VarDeclarationStatementContext): VarDeclarationNode {
        return visitVarDeclaration(ctx.varDeclaration())
    }

    fun visitVarDeclaration(ctx: PrimaParser.VarDeclarationContext): VarDeclarationNode {
        return when (ctx) {
            is PrimaParser.PrimitiveDeclarationContext -> visitPrimitiveDeclaration(ctx)
            is PrimaParser.ArrayDeclarationContext -> visitArrayDeclaration(ctx)
            else -> throw RuntimeException("This should never happen")
        }
    }

    override fun visitPrimitiveDeclaration(ctx: PrimaParser.PrimitiveDeclarationContext): VarDeclarationNode.PrimitiveVarDeclarationNode {
        return VarDeclarationNode.PrimitiveVarDeclarationNode(ctx.name.text, ctx.primitiveType().text.toTypeNode(), visitEXPR(ctx.expr()), ctx)
    }

    override fun visitArrayDeclaration(ctx: PrimaParser.ArrayDeclarationContext): VarDeclarationNode.ArrayVarDeclarationNode {
        return VarDeclarationNode.ArrayVarDeclarationNode(
                ctx.name.text,
                ctx.arrayType().text.toTypeNode() as Type.Arr<*>,
                ctx.arrayInitializer().primitiveType().text.toTypeNode(),
                ArrayList(ctx.arrayInitializer().sizes.map { visitEXPR(it) }),
                ctx
        )
    }

    override fun visitArraySetterStatement(ctx: PrimaParser.ArraySetterStatementContext): ArraySetterNode {
        return ArraySetterNode(ctx.name.text, ctx.indices.map { visitEXPR(it) }, visitEXPR(ctx.value), ctx)
    }

    override fun visitAssignmentStatement(ctx: PrimaParser.AssignmentStatementContext): AssignmentNode {
        return visitAssignment(ctx.assignment())
    }

    override fun visitAssignment(ctx: PrimaParser.AssignmentContext): AssignmentNode {
        return AssignmentNode(ctx.name.text, visitEXPR(ctx.expr()), ctx)
    }

    override fun visitIfStatement(ctx: PrimaParser.IfStatementContext): IfNode {
        return IfNode(visitEXPR(ctx.condition), visitBlock(ctx.thenBlock), ctx.elseBlock?.let { visitBlock(it) }, ctx)
    }

    override fun visitForStatement(ctx: PrimaParser.ForStatementContext): BlockNode {
        val statements: ArrayList<StatementNode> = ArrayList()
        val init = ctx.forInit()
        if (init != null) {
            statements.add(if (init.assignment() != null) {
                visitAssignment(init.assignment())
            } else if (init.varDeclaration() != null) {
                visitVarDeclaration(init.varDeclaration())
            } else {
                throw RuntimeException("This should never happen")
            })
        }
        val iteration = ctx.forIteration()
        val whileNode = WhileNode(visitEXPR(ctx.forStopCondition), visitBlock(ctx.body), ctx)
        if (iteration != null) {
            whileNode.body.addStatementToBody(visitAssignment(iteration.assignment()))
        }
        statements.add(whileNode)
        return BlockNode(statements, ctx)
    }

    override fun visitWhileStatement(ctx: PrimaParser.WhileStatementContext): WhileNode {
        return WhileNode(visitEXPR(ctx.condition), visitBlock(ctx.body), ctx)
    }

    override fun visitWriteStatement(ctx: PrimaParser.WriteStatementContext): WriteNode {
        return WriteNode(ctx.writeln != null, ctx.expr()?.let { visitEXPR(it) }, ctx)
    }

    override fun visitReturnStatement(ctx: PrimaParser.ReturnStatementContext): ReturnNode {
        return ReturnNode(visitEXPR(ctx.expr()), ctx)
    }

    override fun visitFunctionCallStatement(ctx: PrimaParser.FunctionCallStatementContext): FunctionCallStatementNode {
        val arguments = ctx.functionCall().argumentList()?.expr()?.map { visitEXPR(it) } ?: emptyList()
        return FunctionCallStatementNode(ctx.functionCall().name.text, arguments, ctx)
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
        if (ctx.stringLiteral() != null) {
            return LiteralNode.StringLiteralNode(ctx.stringLiteral().text.toString().drop(1).dropLast(1), ctx)
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
        val arguments = ctx.functionCall().argumentList()?.expr()?.map { visitEXPR(it) }?.toList()
        return FunctionCallExprNode(ctx.functionCall().name.text, arguments, ctx)
    }

    override fun visitArrayGetter(ctx: PrimaParser.ArrayGetterContext): ArrayGetterNode {
        return ArrayGetterNode(ctx.name.text, ctx.indices.map { visitEXPR(it) }, ctx)
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
            is PrimaParser.EXPRArrayGetterContext -> visitArrayGetter(ctx.arrayGetter())
            else -> throw RuntimeException("This should never happen")
        }
    }
}

fun readCallToType(str: String): Type {
    return when (str) {
        "readInt" -> Type.Integer
        "readBool" -> Type.Bool
        "readStr" -> Type.Str
        else -> throw RuntimeException("Shouldn't be here!")
    }
}