// Generated from D:/hw/PrimaCompiler/src/main/java/izakirzyanov/compiler\Prima.g4 by ANTLR 4.7
package izakirzyanov.compiler;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link PrimaParser}.
 */
public interface PrimaListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link PrimaParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(PrimaParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link PrimaParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(PrimaParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link PrimaParser#globalVarDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterGlobalVarDeclaration(PrimaParser.GlobalVarDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link PrimaParser#globalVarDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitGlobalVarDeclaration(PrimaParser.GlobalVarDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link PrimaParser#functionDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterFunctionDeclaration(PrimaParser.FunctionDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link PrimaParser#functionDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitFunctionDeclaration(PrimaParser.FunctionDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link PrimaParser#functionSignature}.
	 * @param ctx the parse tree
	 */
	void enterFunctionSignature(PrimaParser.FunctionSignatureContext ctx);
	/**
	 * Exit a parse tree produced by {@link PrimaParser#functionSignature}.
	 * @param ctx the parse tree
	 */
	void exitFunctionSignature(PrimaParser.FunctionSignatureContext ctx);
	/**
	 * Enter a parse tree produced by {@link PrimaParser#functionArguments}.
	 * @param ctx the parse tree
	 */
	void enterFunctionArguments(PrimaParser.FunctionArgumentsContext ctx);
	/**
	 * Exit a parse tree produced by {@link PrimaParser#functionArguments}.
	 * @param ctx the parse tree
	 */
	void exitFunctionArguments(PrimaParser.FunctionArgumentsContext ctx);
	/**
	 * Enter a parse tree produced by {@link PrimaParser#functionArg}.
	 * @param ctx the parse tree
	 */
	void enterFunctionArg(PrimaParser.FunctionArgContext ctx);
	/**
	 * Exit a parse tree produced by {@link PrimaParser#functionArg}.
	 * @param ctx the parse tree
	 */
	void exitFunctionArg(PrimaParser.FunctionArgContext ctx);
	/**
	 * Enter a parse tree produced by {@link PrimaParser#block}.
	 * @param ctx the parse tree
	 */
	void enterBlock(PrimaParser.BlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link PrimaParser#block}.
	 * @param ctx the parse tree
	 */
	void exitBlock(PrimaParser.BlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link PrimaParser#type}.
	 * @param ctx the parse tree
	 */
	void enterType(PrimaParser.TypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link PrimaParser#type}.
	 * @param ctx the parse tree
	 */
	void exitType(PrimaParser.TypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link PrimaParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(PrimaParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link PrimaParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(PrimaParser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link PrimaParser#assignmentStatement}.
	 * @param ctx the parse tree
	 */
	void enterAssignmentStatement(PrimaParser.AssignmentStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link PrimaParser#assignmentStatement}.
	 * @param ctx the parse tree
	 */
	void exitAssignmentStatement(PrimaParser.AssignmentStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link PrimaParser#assignment}.
	 * @param ctx the parse tree
	 */
	void enterAssignment(PrimaParser.AssignmentContext ctx);
	/**
	 * Exit a parse tree produced by {@link PrimaParser#assignment}.
	 * @param ctx the parse tree
	 */
	void exitAssignment(PrimaParser.AssignmentContext ctx);
	/**
	 * Enter a parse tree produced by {@link PrimaParser#arraySetterStatement}.
	 * @param ctx the parse tree
	 */
	void enterArraySetterStatement(PrimaParser.ArraySetterStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link PrimaParser#arraySetterStatement}.
	 * @param ctx the parse tree
	 */
	void exitArraySetterStatement(PrimaParser.ArraySetterStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link PrimaParser#ifStatement}.
	 * @param ctx the parse tree
	 */
	void enterIfStatement(PrimaParser.IfStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link PrimaParser#ifStatement}.
	 * @param ctx the parse tree
	 */
	void exitIfStatement(PrimaParser.IfStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link PrimaParser#whileStatement}.
	 * @param ctx the parse tree
	 */
	void enterWhileStatement(PrimaParser.WhileStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link PrimaParser#whileStatement}.
	 * @param ctx the parse tree
	 */
	void exitWhileStatement(PrimaParser.WhileStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link PrimaParser#readCall}.
	 * @param ctx the parse tree
	 */
	void enterReadCall(PrimaParser.ReadCallContext ctx);
	/**
	 * Exit a parse tree produced by {@link PrimaParser#readCall}.
	 * @param ctx the parse tree
	 */
	void exitReadCall(PrimaParser.ReadCallContext ctx);
	/**
	 * Enter a parse tree produced by {@link PrimaParser#writeStatement}.
	 * @param ctx the parse tree
	 */
	void enterWriteStatement(PrimaParser.WriteStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link PrimaParser#writeStatement}.
	 * @param ctx the parse tree
	 */
	void exitWriteStatement(PrimaParser.WriteStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link PrimaParser#returnStatement}.
	 * @param ctx the parse tree
	 */
	void enterReturnStatement(PrimaParser.ReturnStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link PrimaParser#returnStatement}.
	 * @param ctx the parse tree
	 */
	void exitReturnStatement(PrimaParser.ReturnStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link PrimaParser#varDeclarationStatement}.
	 * @param ctx the parse tree
	 */
	void enterVarDeclarationStatement(PrimaParser.VarDeclarationStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link PrimaParser#varDeclarationStatement}.
	 * @param ctx the parse tree
	 */
	void exitVarDeclarationStatement(PrimaParser.VarDeclarationStatementContext ctx);
	/**
	 * Enter a parse tree produced by the {@code arrayDeclaration}
	 * labeled alternative in {@link PrimaParser#varDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterArrayDeclaration(PrimaParser.ArrayDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by the {@code arrayDeclaration}
	 * labeled alternative in {@link PrimaParser#varDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitArrayDeclaration(PrimaParser.ArrayDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by the {@code primitiveDeclaration}
	 * labeled alternative in {@link PrimaParser#varDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterPrimitiveDeclaration(PrimaParser.PrimitiveDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by the {@code primitiveDeclaration}
	 * labeled alternative in {@link PrimaParser#varDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitPrimitiveDeclaration(PrimaParser.PrimitiveDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link PrimaParser#arrayInitializer}.
	 * @param ctx the parse tree
	 */
	void enterArrayInitializer(PrimaParser.ArrayInitializerContext ctx);
	/**
	 * Exit a parse tree produced by {@link PrimaParser#arrayInitializer}.
	 * @param ctx the parse tree
	 */
	void exitArrayInitializer(PrimaParser.ArrayInitializerContext ctx);
	/**
	 * Enter a parse tree produced by {@link PrimaParser#nopStatement}.
	 * @param ctx the parse tree
	 */
	void enterNopStatement(PrimaParser.NopStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link PrimaParser#nopStatement}.
	 * @param ctx the parse tree
	 */
	void exitNopStatement(PrimaParser.NopStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link PrimaParser#nonVoidType}.
	 * @param ctx the parse tree
	 */
	void enterNonVoidType(PrimaParser.NonVoidTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link PrimaParser#nonVoidType}.
	 * @param ctx the parse tree
	 */
	void exitNonVoidType(PrimaParser.NonVoidTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link PrimaParser#primitiveType}.
	 * @param ctx the parse tree
	 */
	void enterPrimitiveType(PrimaParser.PrimitiveTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link PrimaParser#primitiveType}.
	 * @param ctx the parse tree
	 */
	void exitPrimitiveType(PrimaParser.PrimitiveTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link PrimaParser#arrayType}.
	 * @param ctx the parse tree
	 */
	void enterArrayType(PrimaParser.ArrayTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link PrimaParser#arrayType}.
	 * @param ctx the parse tree
	 */
	void exitArrayType(PrimaParser.ArrayTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link PrimaParser#dims}.
	 * @param ctx the parse tree
	 */
	void enterDims(PrimaParser.DimsContext ctx);
	/**
	 * Exit a parse tree produced by {@link PrimaParser#dims}.
	 * @param ctx the parse tree
	 */
	void exitDims(PrimaParser.DimsContext ctx);
	/**
	 * Enter a parse tree produced by {@link PrimaParser#voidType}.
	 * @param ctx the parse tree
	 */
	void enterVoidType(PrimaParser.VoidTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link PrimaParser#voidType}.
	 * @param ctx the parse tree
	 */
	void exitVoidType(PrimaParser.VoidTypeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code eXPRBinary}
	 * labeled alternative in {@link PrimaParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterEXPRBinary(PrimaParser.EXPRBinaryContext ctx);
	/**
	 * Exit a parse tree produced by the {@code eXPRBinary}
	 * labeled alternative in {@link PrimaParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitEXPRBinary(PrimaParser.EXPRBinaryContext ctx);
	/**
	 * Enter a parse tree produced by the {@code eXPRUnary}
	 * labeled alternative in {@link PrimaParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterEXPRUnary(PrimaParser.EXPRUnaryContext ctx);
	/**
	 * Exit a parse tree produced by the {@code eXPRUnary}
	 * labeled alternative in {@link PrimaParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitEXPRUnary(PrimaParser.EXPRUnaryContext ctx);
	/**
	 * Enter a parse tree produced by the {@code eXPRReadCall}
	 * labeled alternative in {@link PrimaParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterEXPRReadCall(PrimaParser.EXPRReadCallContext ctx);
	/**
	 * Exit a parse tree produced by the {@code eXPRReadCall}
	 * labeled alternative in {@link PrimaParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitEXPRReadCall(PrimaParser.EXPRReadCallContext ctx);
	/**
	 * Enter a parse tree produced by the {@code eXPRFunctionCall}
	 * labeled alternative in {@link PrimaParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterEXPRFunctionCall(PrimaParser.EXPRFunctionCallContext ctx);
	/**
	 * Exit a parse tree produced by the {@code eXPRFunctionCall}
	 * labeled alternative in {@link PrimaParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitEXPRFunctionCall(PrimaParser.EXPRFunctionCallContext ctx);
	/**
	 * Enter a parse tree produced by the {@code eXPRArrayGetter}
	 * labeled alternative in {@link PrimaParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterEXPRArrayGetter(PrimaParser.EXPRArrayGetterContext ctx);
	/**
	 * Exit a parse tree produced by the {@code eXPRArrayGetter}
	 * labeled alternative in {@link PrimaParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitEXPRArrayGetter(PrimaParser.EXPRArrayGetterContext ctx);
	/**
	 * Enter a parse tree produced by the {@code eXPRVarName}
	 * labeled alternative in {@link PrimaParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterEXPRVarName(PrimaParser.EXPRVarNameContext ctx);
	/**
	 * Exit a parse tree produced by the {@code eXPRVarName}
	 * labeled alternative in {@link PrimaParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitEXPRVarName(PrimaParser.EXPRVarNameContext ctx);
	/**
	 * Enter a parse tree produced by the {@code eXPRParenthesis}
	 * labeled alternative in {@link PrimaParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterEXPRParenthesis(PrimaParser.EXPRParenthesisContext ctx);
	/**
	 * Exit a parse tree produced by the {@code eXPRParenthesis}
	 * labeled alternative in {@link PrimaParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitEXPRParenthesis(PrimaParser.EXPRParenthesisContext ctx);
	/**
	 * Enter a parse tree produced by the {@code eXPRLiteral}
	 * labeled alternative in {@link PrimaParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterEXPRLiteral(PrimaParser.EXPRLiteralContext ctx);
	/**
	 * Exit a parse tree produced by the {@code eXPRLiteral}
	 * labeled alternative in {@link PrimaParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitEXPRLiteral(PrimaParser.EXPRLiteralContext ctx);
	/**
	 * Enter a parse tree produced by {@link PrimaParser#arrayGetter}.
	 * @param ctx the parse tree
	 */
	void enterArrayGetter(PrimaParser.ArrayGetterContext ctx);
	/**
	 * Exit a parse tree produced by {@link PrimaParser#arrayGetter}.
	 * @param ctx the parse tree
	 */
	void exitArrayGetter(PrimaParser.ArrayGetterContext ctx);
	/**
	 * Enter a parse tree produced by {@link PrimaParser#functionCallStatement}.
	 * @param ctx the parse tree
	 */
	void enterFunctionCallStatement(PrimaParser.FunctionCallStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link PrimaParser#functionCallStatement}.
	 * @param ctx the parse tree
	 */
	void exitFunctionCallStatement(PrimaParser.FunctionCallStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link PrimaParser#functionCall}.
	 * @param ctx the parse tree
	 */
	void enterFunctionCall(PrimaParser.FunctionCallContext ctx);
	/**
	 * Exit a parse tree produced by {@link PrimaParser#functionCall}.
	 * @param ctx the parse tree
	 */
	void exitFunctionCall(PrimaParser.FunctionCallContext ctx);
	/**
	 * Enter a parse tree produced by {@link PrimaParser#argumentList}.
	 * @param ctx the parse tree
	 */
	void enterArgumentList(PrimaParser.ArgumentListContext ctx);
	/**
	 * Exit a parse tree produced by {@link PrimaParser#argumentList}.
	 * @param ctx the parse tree
	 */
	void exitArgumentList(PrimaParser.ArgumentListContext ctx);
	/**
	 * Enter a parse tree produced by {@link PrimaParser#intLiteral}.
	 * @param ctx the parse tree
	 */
	void enterIntLiteral(PrimaParser.IntLiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link PrimaParser#intLiteral}.
	 * @param ctx the parse tree
	 */
	void exitIntLiteral(PrimaParser.IntLiteralContext ctx);
	/**
	 * Enter a parse tree produced by {@link PrimaParser#boolLiteral}.
	 * @param ctx the parse tree
	 */
	void enterBoolLiteral(PrimaParser.BoolLiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link PrimaParser#boolLiteral}.
	 * @param ctx the parse tree
	 */
	void exitBoolLiteral(PrimaParser.BoolLiteralContext ctx);
	/**
	 * Enter a parse tree produced by {@link PrimaParser#stringLiteral}.
	 * @param ctx the parse tree
	 */
	void enterStringLiteral(PrimaParser.StringLiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link PrimaParser#stringLiteral}.
	 * @param ctx the parse tree
	 */
	void exitStringLiteral(PrimaParser.StringLiteralContext ctx);
	/**
	 * Enter a parse tree produced by {@link PrimaParser#variableName}.
	 * @param ctx the parse tree
	 */
	void enterVariableName(PrimaParser.VariableNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link PrimaParser#variableName}.
	 * @param ctx the parse tree
	 */
	void exitVariableName(PrimaParser.VariableNameContext ctx);
}