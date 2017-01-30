// Generated from D:/Prog/java/compiler/grammar\MyLang.g4 by ANTLR 4.6
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link MyLangParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface MyLangVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link MyLangParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(MyLangParser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyLangParser#globalDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGlobalDeclaration(MyLangParser.GlobalDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyLangParser#functionDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionDeclaration(MyLangParser.FunctionDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyLangParser#functionSignature}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionSignature(MyLangParser.FunctionSignatureContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyLangParser#functionArguments}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionArguments(MyLangParser.FunctionArgumentsContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyLangParser#functionArg}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionArg(MyLangParser.FunctionArgContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyLangParser#block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlock(MyLangParser.BlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyLangParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitType(MyLangParser.TypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyLangParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement(MyLangParser.StatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyLangParser#assignmentStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignmentStatement(MyLangParser.AssignmentStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyLangParser#assignment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignment(MyLangParser.AssignmentContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyLangParser#ifStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfStatement(MyLangParser.IfStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyLangParser#ifElseStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfElseStatement(MyLangParser.IfElseStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyLangParser#forStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForStatement(MyLangParser.ForStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyLangParser#forInit}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForInit(MyLangParser.ForInitContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyLangParser#forStopCondition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForStopCondition(MyLangParser.ForStopConditionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyLangParser#forIteration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForIteration(MyLangParser.ForIterationContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyLangParser#whileStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhileStatement(MyLangParser.WhileStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyLangParser#readStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReadStatement(MyLangParser.ReadStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyLangParser#readCall}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReadCall(MyLangParser.ReadCallContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyLangParser#writeStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWriteStatement(MyLangParser.WriteStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyLangParser#returnStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturnStatement(MyLangParser.ReturnStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyLangParser#varDeclarationStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarDeclarationStatement(MyLangParser.VarDeclarationStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyLangParser#varDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarDeclaration(MyLangParser.VarDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyLangParser#nopStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNopStatement(MyLangParser.NopStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyLangParser#nonVoidType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNonVoidType(MyLangParser.NonVoidTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyLangParser#voidType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVoidType(MyLangParser.VoidTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyLangParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpr(MyLangParser.ExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyLangParser#functionCallStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionCallStatement(MyLangParser.FunctionCallStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyLangParser#functionCall}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionCall(MyLangParser.FunctionCallContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyLangParser#argumentList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArgumentList(MyLangParser.ArgumentListContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyLangParser#intLiteral}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIntLiteral(MyLangParser.IntLiteralContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyLangParser#boolLiteral}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBoolLiteral(MyLangParser.BoolLiteralContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyLangParser#var}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVar(MyLangParser.VarContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyLangParser#unaryIntOp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnaryIntOp(MyLangParser.UnaryIntOpContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyLangParser#unaryBoolOp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnaryBoolOp(MyLangParser.UnaryBoolOpContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyLangParser#divModMultOp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDivModMultOp(MyLangParser.DivModMultOpContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyLangParser#addSubOp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAddSubOp(MyLangParser.AddSubOpContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyLangParser#compOp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCompOp(MyLangParser.CompOpContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyLangParser#equalOp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEqualOp(MyLangParser.EqualOpContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyLangParser#boolAndOp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBoolAndOp(MyLangParser.BoolAndOpContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyLangParser#boolOrOp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBoolOrOp(MyLangParser.BoolOrOpContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyLangParser#assignmentOP}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignmentOP(MyLangParser.AssignmentOPContext ctx);
}