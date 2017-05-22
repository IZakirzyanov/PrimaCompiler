// Generated from D:/prog/studying/PrimaCompiler/src/main/java/izakirzyanov/compiler\Prima.g4 by ANTLR 4.7
package izakirzyanov.compiler;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link PrimaParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface PrimaVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link PrimaParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(PrimaParser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by {@link PrimaParser#globalVarDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGlobalVarDeclaration(PrimaParser.GlobalVarDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link PrimaParser#functionDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionDeclaration(PrimaParser.FunctionDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link PrimaParser#functionSignature}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionSignature(PrimaParser.FunctionSignatureContext ctx);
	/**
	 * Visit a parse tree produced by {@link PrimaParser#functionArguments}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionArguments(PrimaParser.FunctionArgumentsContext ctx);
	/**
	 * Visit a parse tree produced by {@link PrimaParser#functionArg}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionArg(PrimaParser.FunctionArgContext ctx);
	/**
	 * Visit a parse tree produced by {@link PrimaParser#block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlock(PrimaParser.BlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link PrimaParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitType(PrimaParser.TypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link PrimaParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement(PrimaParser.StatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link PrimaParser#assignmentStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignmentStatement(PrimaParser.AssignmentStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link PrimaParser#assignment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignment(PrimaParser.AssignmentContext ctx);
	/**
	 * Visit a parse tree produced by {@link PrimaParser#ifStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfStatement(PrimaParser.IfStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link PrimaParser#whileStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhileStatement(PrimaParser.WhileStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link PrimaParser#readCall}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReadCall(PrimaParser.ReadCallContext ctx);
	/**
	 * Visit a parse tree produced by {@link PrimaParser#writeStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWriteStatement(PrimaParser.WriteStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link PrimaParser#returnStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturnStatement(PrimaParser.ReturnStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link PrimaParser#varDeclarationStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarDeclarationStatement(PrimaParser.VarDeclarationStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link PrimaParser#varDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarDeclaration(PrimaParser.VarDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link PrimaParser#nopStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNopStatement(PrimaParser.NopStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link PrimaParser#nonVoidType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNonVoidType(PrimaParser.NonVoidTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link PrimaParser#voidType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVoidType(PrimaParser.VoidTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code eXPRBinary}
	 * labeled alternative in {@link PrimaParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEXPRBinary(PrimaParser.EXPRBinaryContext ctx);
	/**
	 * Visit a parse tree produced by the {@code eXPRUnary}
	 * labeled alternative in {@link PrimaParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEXPRUnary(PrimaParser.EXPRUnaryContext ctx);
	/**
	 * Visit a parse tree produced by the {@code eXPRReadCall}
	 * labeled alternative in {@link PrimaParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEXPRReadCall(PrimaParser.EXPRReadCallContext ctx);
	/**
	 * Visit a parse tree produced by the {@code eXPRFunctionCall}
	 * labeled alternative in {@link PrimaParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEXPRFunctionCall(PrimaParser.EXPRFunctionCallContext ctx);
	/**
	 * Visit a parse tree produced by the {@code eXPRVarName}
	 * labeled alternative in {@link PrimaParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEXPRVarName(PrimaParser.EXPRVarNameContext ctx);
	/**
	 * Visit a parse tree produced by the {@code eXPRParenthesis}
	 * labeled alternative in {@link PrimaParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEXPRParenthesis(PrimaParser.EXPRParenthesisContext ctx);
	/**
	 * Visit a parse tree produced by the {@code eXPRLiteral}
	 * labeled alternative in {@link PrimaParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEXPRLiteral(PrimaParser.EXPRLiteralContext ctx);
	/**
	 * Visit a parse tree produced by {@link PrimaParser#functionCallStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionCallStatement(PrimaParser.FunctionCallStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link PrimaParser#functionCall}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionCall(PrimaParser.FunctionCallContext ctx);
	/**
	 * Visit a parse tree produced by {@link PrimaParser#argumentList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArgumentList(PrimaParser.ArgumentListContext ctx);
	/**
	 * Visit a parse tree produced by {@link PrimaParser#intLiteral}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIntLiteral(PrimaParser.IntLiteralContext ctx);
	/**
	 * Visit a parse tree produced by {@link PrimaParser#boolLiteral}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBoolLiteral(PrimaParser.BoolLiteralContext ctx);
	/**
	 * Visit a parse tree produced by {@link PrimaParser#stringLiteral}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStringLiteral(PrimaParser.StringLiteralContext ctx);
	/**
	 * Visit a parse tree produced by {@link PrimaParser#variableName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariableName(PrimaParser.VariableNameContext ctx);
}