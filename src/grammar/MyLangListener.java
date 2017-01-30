// Generated from D:/Prog/java/compiler/grammar\MyLang.g4 by ANTLR 4.6
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link MyLangParser}.
 */
public interface MyLangListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link MyLangParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(MyLangParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyLangParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(MyLangParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyLangParser#globalDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterGlobalDeclaration(MyLangParser.GlobalDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyLangParser#globalDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitGlobalDeclaration(MyLangParser.GlobalDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyLangParser#functionDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterFunctionDeclaration(MyLangParser.FunctionDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyLangParser#functionDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitFunctionDeclaration(MyLangParser.FunctionDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyLangParser#functionSignature}.
	 * @param ctx the parse tree
	 */
	void enterFunctionSignature(MyLangParser.FunctionSignatureContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyLangParser#functionSignature}.
	 * @param ctx the parse tree
	 */
	void exitFunctionSignature(MyLangParser.FunctionSignatureContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyLangParser#functionArguments}.
	 * @param ctx the parse tree
	 */
	void enterFunctionArguments(MyLangParser.FunctionArgumentsContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyLangParser#functionArguments}.
	 * @param ctx the parse tree
	 */
	void exitFunctionArguments(MyLangParser.FunctionArgumentsContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyLangParser#functionArg}.
	 * @param ctx the parse tree
	 */
	void enterFunctionArg(MyLangParser.FunctionArgContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyLangParser#functionArg}.
	 * @param ctx the parse tree
	 */
	void exitFunctionArg(MyLangParser.FunctionArgContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyLangParser#block}.
	 * @param ctx the parse tree
	 */
	void enterBlock(MyLangParser.BlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyLangParser#block}.
	 * @param ctx the parse tree
	 */
	void exitBlock(MyLangParser.BlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyLangParser#type}.
	 * @param ctx the parse tree
	 */
	void enterType(MyLangParser.TypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyLangParser#type}.
	 * @param ctx the parse tree
	 */
	void exitType(MyLangParser.TypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyLangParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(MyLangParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyLangParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(MyLangParser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyLangParser#assignmentStatement}.
	 * @param ctx the parse tree
	 */
	void enterAssignmentStatement(MyLangParser.AssignmentStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyLangParser#assignmentStatement}.
	 * @param ctx the parse tree
	 */
	void exitAssignmentStatement(MyLangParser.AssignmentStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyLangParser#assignment}.
	 * @param ctx the parse tree
	 */
	void enterAssignment(MyLangParser.AssignmentContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyLangParser#assignment}.
	 * @param ctx the parse tree
	 */
	void exitAssignment(MyLangParser.AssignmentContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyLangParser#ifStatement}.
	 * @param ctx the parse tree
	 */
	void enterIfStatement(MyLangParser.IfStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyLangParser#ifStatement}.
	 * @param ctx the parse tree
	 */
	void exitIfStatement(MyLangParser.IfStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyLangParser#ifElseStatement}.
	 * @param ctx the parse tree
	 */
	void enterIfElseStatement(MyLangParser.IfElseStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyLangParser#ifElseStatement}.
	 * @param ctx the parse tree
	 */
	void exitIfElseStatement(MyLangParser.IfElseStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyLangParser#forStatement}.
	 * @param ctx the parse tree
	 */
	void enterForStatement(MyLangParser.ForStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyLangParser#forStatement}.
	 * @param ctx the parse tree
	 */
	void exitForStatement(MyLangParser.ForStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyLangParser#forInit}.
	 * @param ctx the parse tree
	 */
	void enterForInit(MyLangParser.ForInitContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyLangParser#forInit}.
	 * @param ctx the parse tree
	 */
	void exitForInit(MyLangParser.ForInitContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyLangParser#forStopCondition}.
	 * @param ctx the parse tree
	 */
	void enterForStopCondition(MyLangParser.ForStopConditionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyLangParser#forStopCondition}.
	 * @param ctx the parse tree
	 */
	void exitForStopCondition(MyLangParser.ForStopConditionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyLangParser#forIteration}.
	 * @param ctx the parse tree
	 */
	void enterForIteration(MyLangParser.ForIterationContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyLangParser#forIteration}.
	 * @param ctx the parse tree
	 */
	void exitForIteration(MyLangParser.ForIterationContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyLangParser#whileStatement}.
	 * @param ctx the parse tree
	 */
	void enterWhileStatement(MyLangParser.WhileStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyLangParser#whileStatement}.
	 * @param ctx the parse tree
	 */
	void exitWhileStatement(MyLangParser.WhileStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyLangParser#readStatement}.
	 * @param ctx the parse tree
	 */
	void enterReadStatement(MyLangParser.ReadStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyLangParser#readStatement}.
	 * @param ctx the parse tree
	 */
	void exitReadStatement(MyLangParser.ReadStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyLangParser#readCall}.
	 * @param ctx the parse tree
	 */
	void enterReadCall(MyLangParser.ReadCallContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyLangParser#readCall}.
	 * @param ctx the parse tree
	 */
	void exitReadCall(MyLangParser.ReadCallContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyLangParser#writeStatement}.
	 * @param ctx the parse tree
	 */
	void enterWriteStatement(MyLangParser.WriteStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyLangParser#writeStatement}.
	 * @param ctx the parse tree
	 */
	void exitWriteStatement(MyLangParser.WriteStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyLangParser#returnStatement}.
	 * @param ctx the parse tree
	 */
	void enterReturnStatement(MyLangParser.ReturnStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyLangParser#returnStatement}.
	 * @param ctx the parse tree
	 */
	void exitReturnStatement(MyLangParser.ReturnStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyLangParser#varDeclarationStatement}.
	 * @param ctx the parse tree
	 */
	void enterVarDeclarationStatement(MyLangParser.VarDeclarationStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyLangParser#varDeclarationStatement}.
	 * @param ctx the parse tree
	 */
	void exitVarDeclarationStatement(MyLangParser.VarDeclarationStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyLangParser#varDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterVarDeclaration(MyLangParser.VarDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyLangParser#varDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitVarDeclaration(MyLangParser.VarDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyLangParser#nopStatement}.
	 * @param ctx the parse tree
	 */
	void enterNopStatement(MyLangParser.NopStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyLangParser#nopStatement}.
	 * @param ctx the parse tree
	 */
	void exitNopStatement(MyLangParser.NopStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyLangParser#nonVoidType}.
	 * @param ctx the parse tree
	 */
	void enterNonVoidType(MyLangParser.NonVoidTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyLangParser#nonVoidType}.
	 * @param ctx the parse tree
	 */
	void exitNonVoidType(MyLangParser.NonVoidTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyLangParser#voidType}.
	 * @param ctx the parse tree
	 */
	void enterVoidType(MyLangParser.VoidTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyLangParser#voidType}.
	 * @param ctx the parse tree
	 */
	void exitVoidType(MyLangParser.VoidTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyLangParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpr(MyLangParser.ExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyLangParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpr(MyLangParser.ExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyLangParser#functionCallStatement}.
	 * @param ctx the parse tree
	 */
	void enterFunctionCallStatement(MyLangParser.FunctionCallStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyLangParser#functionCallStatement}.
	 * @param ctx the parse tree
	 */
	void exitFunctionCallStatement(MyLangParser.FunctionCallStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyLangParser#functionCall}.
	 * @param ctx the parse tree
	 */
	void enterFunctionCall(MyLangParser.FunctionCallContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyLangParser#functionCall}.
	 * @param ctx the parse tree
	 */
	void exitFunctionCall(MyLangParser.FunctionCallContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyLangParser#argumentList}.
	 * @param ctx the parse tree
	 */
	void enterArgumentList(MyLangParser.ArgumentListContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyLangParser#argumentList}.
	 * @param ctx the parse tree
	 */
	void exitArgumentList(MyLangParser.ArgumentListContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyLangParser#intLiteral}.
	 * @param ctx the parse tree
	 */
	void enterIntLiteral(MyLangParser.IntLiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyLangParser#intLiteral}.
	 * @param ctx the parse tree
	 */
	void exitIntLiteral(MyLangParser.IntLiteralContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyLangParser#boolLiteral}.
	 * @param ctx the parse tree
	 */
	void enterBoolLiteral(MyLangParser.BoolLiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyLangParser#boolLiteral}.
	 * @param ctx the parse tree
	 */
	void exitBoolLiteral(MyLangParser.BoolLiteralContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyLangParser#var}.
	 * @param ctx the parse tree
	 */
	void enterVar(MyLangParser.VarContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyLangParser#var}.
	 * @param ctx the parse tree
	 */
	void exitVar(MyLangParser.VarContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyLangParser#unaryIntOp}.
	 * @param ctx the parse tree
	 */
	void enterUnaryIntOp(MyLangParser.UnaryIntOpContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyLangParser#unaryIntOp}.
	 * @param ctx the parse tree
	 */
	void exitUnaryIntOp(MyLangParser.UnaryIntOpContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyLangParser#unaryBoolOp}.
	 * @param ctx the parse tree
	 */
	void enterUnaryBoolOp(MyLangParser.UnaryBoolOpContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyLangParser#unaryBoolOp}.
	 * @param ctx the parse tree
	 */
	void exitUnaryBoolOp(MyLangParser.UnaryBoolOpContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyLangParser#divModMultOp}.
	 * @param ctx the parse tree
	 */
	void enterDivModMultOp(MyLangParser.DivModMultOpContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyLangParser#divModMultOp}.
	 * @param ctx the parse tree
	 */
	void exitDivModMultOp(MyLangParser.DivModMultOpContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyLangParser#addSubOp}.
	 * @param ctx the parse tree
	 */
	void enterAddSubOp(MyLangParser.AddSubOpContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyLangParser#addSubOp}.
	 * @param ctx the parse tree
	 */
	void exitAddSubOp(MyLangParser.AddSubOpContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyLangParser#compOp}.
	 * @param ctx the parse tree
	 */
	void enterCompOp(MyLangParser.CompOpContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyLangParser#compOp}.
	 * @param ctx the parse tree
	 */
	void exitCompOp(MyLangParser.CompOpContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyLangParser#equalOp}.
	 * @param ctx the parse tree
	 */
	void enterEqualOp(MyLangParser.EqualOpContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyLangParser#equalOp}.
	 * @param ctx the parse tree
	 */
	void exitEqualOp(MyLangParser.EqualOpContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyLangParser#boolAndOp}.
	 * @param ctx the parse tree
	 */
	void enterBoolAndOp(MyLangParser.BoolAndOpContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyLangParser#boolAndOp}.
	 * @param ctx the parse tree
	 */
	void exitBoolAndOp(MyLangParser.BoolAndOpContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyLangParser#boolOrOp}.
	 * @param ctx the parse tree
	 */
	void enterBoolOrOp(MyLangParser.BoolOrOpContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyLangParser#boolOrOp}.
	 * @param ctx the parse tree
	 */
	void exitBoolOrOp(MyLangParser.BoolOrOpContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyLangParser#assignmentOP}.
	 * @param ctx the parse tree
	 */
	void enterAssignmentOP(MyLangParser.AssignmentOPContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyLangParser#assignmentOP}.
	 * @param ctx the parse tree
	 */
	void exitAssignmentOP(MyLangParser.AssignmentOPContext ctx);
}