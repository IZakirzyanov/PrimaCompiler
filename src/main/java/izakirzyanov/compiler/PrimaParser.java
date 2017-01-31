// Generated from D:/Prog/java/PrimaCompiler/src/main/java/izakirzyanov/compiler\Prima.g4 by ANTLR 4.6
package izakirzyanov.compiler;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class PrimaParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.6", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, T__23=24, 
		T__24=25, T__25=26, T__26=27, T__27=28, T__28=29, T__29=30, T__30=31, 
		T__31=32, T__32=33, T__33=34, T__34=35, T__35=36, T__36=37, T__37=38, 
		T__38=39, T__39=40, Identifier=41, Nop=42, ID=43, B=44, Z=45, WS=46, COMMENT=47, 
		LINE_COMMENT=48;
	public static final int
		RULE_program = 0, RULE_globalDeclaration = 1, RULE_functionDeclaration = 2, 
		RULE_functionSignature = 3, RULE_functionArguments = 4, RULE_functionArg = 5, 
		RULE_block = 6, RULE_type = 7, RULE_statement = 8, RULE_assignmentStatement = 9, 
		RULE_assignment = 10, RULE_ifStatement = 11, RULE_ifElseStatement = 12, 
		RULE_forStatement = 13, RULE_forInit = 14, RULE_forStopCondition = 15, 
		RULE_forIteration = 16, RULE_whileStatement = 17, RULE_readStatement = 18, 
		RULE_readCall = 19, RULE_writeStatement = 20, RULE_returnStatement = 21, 
		RULE_varDeclarationStatement = 22, RULE_varDeclaration = 23, RULE_nopStatement = 24, 
		RULE_nonVoidType = 25, RULE_voidType = 26, RULE_expr = 27, RULE_functionCallStatement = 28, 
		RULE_functionCall = 29, RULE_argumentList = 30, RULE_intLiteral = 31, 
		RULE_boolLiteral = 32, RULE_var = 33, RULE_unaryIntOp = 34, RULE_unaryBoolOp = 35, 
		RULE_divModMultOp = 36, RULE_addSubOp = 37, RULE_compOp = 38, RULE_equalOp = 39, 
		RULE_boolAndOp = 40, RULE_boolOrOp = 41, RULE_assignmentOP = 42;
	public static final String[] ruleNames = {
		"program", "globalDeclaration", "functionDeclaration", "functionSignature", 
		"functionArguments", "functionArg", "block", "type", "statement", "assignmentStatement", 
		"assignment", "ifStatement", "ifElseStatement", "forStatement", "forInit", 
		"forStopCondition", "forIteration", "whileStatement", "readStatement", 
		"readCall", "writeStatement", "returnStatement", "varDeclarationStatement", 
		"varDeclaration", "nopStatement", "nonVoidType", "voidType", "expr", "functionCallStatement", 
		"functionCall", "argumentList", "intLiteral", "boolLiteral", "var", "unaryIntOp", 
		"unaryBoolOp", "divModMultOp", "addSubOp", "compOp", "equalOp", "boolAndOp", 
		"boolOrOp", "assignmentOP"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'fun'", "'('", "')'", "':'", "','", "'{'", "'}'", "';'", "'if'", 
		"'else'", "'for'", "'while'", "'readInt'", "'readBool'", "'write'", "'writeln'", 
		"'return'", "'='", "'int'", "'bool'", "'void'", "'+'", "'-'", "'!'", "'/'", 
		"'%'", "'*'", "'<'", "'>'", "'<='", "'>='", "'=='", "'!='", "'&&'", "'||'", 
		"'+='", "'-='", "'*='", "'/='", "'%='", null, "'nop'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, "Identifier", "Nop", "ID", "B", "Z", "WS", 
		"COMMENT", "LINE_COMMENT"
	};
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "Prima.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public PrimaParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class ProgramContext extends ParserRuleContext {
		public List<GlobalDeclarationContext> globalDeclaration() {
			return getRuleContexts(GlobalDeclarationContext.class);
		}
		public GlobalDeclarationContext globalDeclaration(int i) {
			return getRuleContext(GlobalDeclarationContext.class,i);
		}
		public List<FunctionDeclarationContext> functionDeclaration() {
			return getRuleContexts(FunctionDeclarationContext.class);
		}
		public FunctionDeclarationContext functionDeclaration(int i) {
			return getRuleContext(FunctionDeclarationContext.class,i);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PrimaListener ) ((PrimaListener)listener).enterProgram(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PrimaListener ) ((PrimaListener)listener).exitProgram(this);
		}
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(88); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				setState(88);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case Identifier:
					{
					setState(86);
					globalDeclaration();
					}
					break;
				case T__0:
					{
					setState(87);
					functionDeclaration();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(90); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==T__0 || _la==Identifier );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class GlobalDeclarationContext extends ParserRuleContext {
		public VarDeclarationStatementContext varDeclarationStatement() {
			return getRuleContext(VarDeclarationStatementContext.class,0);
		}
		public GlobalDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_globalDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PrimaListener ) ((PrimaListener)listener).enterGlobalDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PrimaListener ) ((PrimaListener)listener).exitGlobalDeclaration(this);
		}
	}

	public final GlobalDeclarationContext globalDeclaration() throws RecognitionException {
		GlobalDeclarationContext _localctx = new GlobalDeclarationContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_globalDeclaration);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(92);
			varDeclarationStatement();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FunctionDeclarationContext extends ParserRuleContext {
		public FunctionSignatureContext functionSignature() {
			return getRuleContext(FunctionSignatureContext.class,0);
		}
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public FunctionDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PrimaListener ) ((PrimaListener)listener).enterFunctionDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PrimaListener ) ((PrimaListener)listener).exitFunctionDeclaration(this);
		}
	}

	public final FunctionDeclarationContext functionDeclaration() throws RecognitionException {
		FunctionDeclarationContext _localctx = new FunctionDeclarationContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_functionDeclaration);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(94);
			match(T__0);
			setState(95);
			functionSignature();
			setState(96);
			block();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FunctionSignatureContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(PrimaParser.Identifier, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public FunctionArgumentsContext functionArguments() {
			return getRuleContext(FunctionArgumentsContext.class,0);
		}
		public FunctionSignatureContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionSignature; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PrimaListener ) ((PrimaListener)listener).enterFunctionSignature(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PrimaListener ) ((PrimaListener)listener).exitFunctionSignature(this);
		}
	}

	public final FunctionSignatureContext functionSignature() throws RecognitionException {
		FunctionSignatureContext _localctx = new FunctionSignatureContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_functionSignature);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(98);
			match(Identifier);
			setState(99);
			match(T__1);
			setState(101);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Identifier) {
				{
				setState(100);
				functionArguments();
				}
			}

			setState(103);
			match(T__2);
			setState(104);
			match(T__3);
			setState(105);
			type();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FunctionArgumentsContext extends ParserRuleContext {
		public List<FunctionArgContext> functionArg() {
			return getRuleContexts(FunctionArgContext.class);
		}
		public FunctionArgContext functionArg(int i) {
			return getRuleContext(FunctionArgContext.class,i);
		}
		public FunctionArgumentsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionArguments; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PrimaListener ) ((PrimaListener)listener).enterFunctionArguments(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PrimaListener ) ((PrimaListener)listener).exitFunctionArguments(this);
		}
	}

	public final FunctionArgumentsContext functionArguments() throws RecognitionException {
		FunctionArgumentsContext _localctx = new FunctionArgumentsContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_functionArguments);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(107);
			functionArg();
			setState(112);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__4) {
				{
				{
				setState(108);
				match(T__4);
				setState(109);
				functionArg();
				}
				}
				setState(114);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FunctionArgContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(PrimaParser.Identifier, 0); }
		public NonVoidTypeContext nonVoidType() {
			return getRuleContext(NonVoidTypeContext.class,0);
		}
		public FunctionArgContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionArg; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PrimaListener ) ((PrimaListener)listener).enterFunctionArg(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PrimaListener ) ((PrimaListener)listener).exitFunctionArg(this);
		}
	}

	public final FunctionArgContext functionArg() throws RecognitionException {
		FunctionArgContext _localctx = new FunctionArgContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_functionArg);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(115);
			match(Identifier);
			setState(116);
			match(T__3);
			setState(117);
			nonVoidType();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BlockContext extends ParserRuleContext {
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public BlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_block; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PrimaListener ) ((PrimaListener)listener).enterBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PrimaListener ) ((PrimaListener)listener).exitBlock(this);
		}
	}

	public final BlockContext block() throws RecognitionException {
		BlockContext _localctx = new BlockContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_block);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(119);
			match(T__5);
			setState(123);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__5) | (1L << T__8) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << T__15) | (1L << T__16) | (1L << Identifier) | (1L << Nop))) != 0)) {
				{
				{
				setState(120);
				statement();
				}
				}
				setState(125);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(126);
			match(T__6);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TypeContext extends ParserRuleContext {
		public NonVoidTypeContext nonVoidType() {
			return getRuleContext(NonVoidTypeContext.class,0);
		}
		public VoidTypeContext voidType() {
			return getRuleContext(VoidTypeContext.class,0);
		}
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PrimaListener ) ((PrimaListener)listener).enterType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PrimaListener ) ((PrimaListener)listener).exitType(this);
		}
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_type);
		try {
			setState(130);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__18:
			case T__19:
				enterOuterAlt(_localctx, 1);
				{
				setState(128);
				nonVoidType();
				}
				break;
			case T__20:
				enterOuterAlt(_localctx, 2);
				{
				setState(129);
				voidType();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StatementContext extends ParserRuleContext {
		public NopStatementContext nopStatement() {
			return getRuleContext(NopStatementContext.class,0);
		}
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public VarDeclarationStatementContext varDeclarationStatement() {
			return getRuleContext(VarDeclarationStatementContext.class,0);
		}
		public AssignmentStatementContext assignmentStatement() {
			return getRuleContext(AssignmentStatementContext.class,0);
		}
		public IfStatementContext ifStatement() {
			return getRuleContext(IfStatementContext.class,0);
		}
		public IfElseStatementContext ifElseStatement() {
			return getRuleContext(IfElseStatementContext.class,0);
		}
		public ForStatementContext forStatement() {
			return getRuleContext(ForStatementContext.class,0);
		}
		public WhileStatementContext whileStatement() {
			return getRuleContext(WhileStatementContext.class,0);
		}
		public ReadStatementContext readStatement() {
			return getRuleContext(ReadStatementContext.class,0);
		}
		public WriteStatementContext writeStatement() {
			return getRuleContext(WriteStatementContext.class,0);
		}
		public ReturnStatementContext returnStatement() {
			return getRuleContext(ReturnStatementContext.class,0);
		}
		public FunctionCallStatementContext functionCallStatement() {
			return getRuleContext(FunctionCallStatementContext.class,0);
		}
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PrimaListener ) ((PrimaListener)listener).enterStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PrimaListener ) ((PrimaListener)listener).exitStatement(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_statement);
		try {
			setState(144);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(132);
				nopStatement();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(133);
				block();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(134);
				varDeclarationStatement();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(135);
				assignmentStatement();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(136);
				ifStatement();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(137);
				ifElseStatement();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(138);
				forStatement();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(139);
				whileStatement();
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(140);
				readStatement();
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(141);
				writeStatement();
				}
				break;
			case 11:
				enterOuterAlt(_localctx, 11);
				{
				setState(142);
				returnStatement();
				}
				break;
			case 12:
				enterOuterAlt(_localctx, 12);
				{
				setState(143);
				functionCallStatement();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AssignmentStatementContext extends ParserRuleContext {
		public AssignmentContext assignment() {
			return getRuleContext(AssignmentContext.class,0);
		}
		public AssignmentStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignmentStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PrimaListener ) ((PrimaListener)listener).enterAssignmentStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PrimaListener ) ((PrimaListener)listener).exitAssignmentStatement(this);
		}
	}

	public final AssignmentStatementContext assignmentStatement() throws RecognitionException {
		AssignmentStatementContext _localctx = new AssignmentStatementContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_assignmentStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(146);
			assignment();
			setState(147);
			match(T__7);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AssignmentContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(PrimaParser.Identifier, 0); }
		public AssignmentOPContext assignmentOP() {
			return getRuleContext(AssignmentOPContext.class,0);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public AssignmentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignment; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PrimaListener ) ((PrimaListener)listener).enterAssignment(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PrimaListener ) ((PrimaListener)listener).exitAssignment(this);
		}
	}

	public final AssignmentContext assignment() throws RecognitionException {
		AssignmentContext _localctx = new AssignmentContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_assignment);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(149);
			match(Identifier);
			setState(150);
			assignmentOP();
			setState(151);
			expr(0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class IfStatementContext extends ParserRuleContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public IfStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ifStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PrimaListener ) ((PrimaListener)listener).enterIfStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PrimaListener ) ((PrimaListener)listener).exitIfStatement(this);
		}
	}

	public final IfStatementContext ifStatement() throws RecognitionException {
		IfStatementContext _localctx = new IfStatementContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_ifStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(153);
			match(T__8);
			setState(154);
			match(T__1);
			setState(155);
			expr(0);
			setState(156);
			match(T__2);
			setState(157);
			block();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class IfElseStatementContext extends ParserRuleContext {
		public BlockContext thenBlock;
		public BlockContext elseBlock;
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public List<BlockContext> block() {
			return getRuleContexts(BlockContext.class);
		}
		public BlockContext block(int i) {
			return getRuleContext(BlockContext.class,i);
		}
		public IfElseStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ifElseStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PrimaListener ) ((PrimaListener)listener).enterIfElseStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PrimaListener ) ((PrimaListener)listener).exitIfElseStatement(this);
		}
	}

	public final IfElseStatementContext ifElseStatement() throws RecognitionException {
		IfElseStatementContext _localctx = new IfElseStatementContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_ifElseStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(159);
			match(T__8);
			setState(160);
			match(T__1);
			setState(161);
			expr(0);
			setState(162);
			match(T__2);
			setState(163);
			((IfElseStatementContext)_localctx).thenBlock = block();
			setState(164);
			match(T__9);
			setState(165);
			((IfElseStatementContext)_localctx).elseBlock = block();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ForStatementContext extends ParserRuleContext {
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public ForInitContext forInit() {
			return getRuleContext(ForInitContext.class,0);
		}
		public ForStopConditionContext forStopCondition() {
			return getRuleContext(ForStopConditionContext.class,0);
		}
		public ForIterationContext forIteration() {
			return getRuleContext(ForIterationContext.class,0);
		}
		public ForStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_forStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PrimaListener ) ((PrimaListener)listener).enterForStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PrimaListener ) ((PrimaListener)listener).exitForStatement(this);
		}
	}

	public final ForStatementContext forStatement() throws RecognitionException {
		ForStatementContext _localctx = new ForStatementContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_forStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(167);
			match(T__10);
			setState(168);
			match(T__1);
			setState(170);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Identifier) {
				{
				setState(169);
				forInit();
				}
			}

			setState(172);
			match(T__7);
			setState(174);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__1) | (1L << T__12) | (1L << T__13) | (1L << T__21) | (1L << T__22) | (1L << T__23) | (1L << Identifier) | (1L << B) | (1L << Z))) != 0)) {
				{
				setState(173);
				forStopCondition();
				}
			}

			setState(176);
			match(T__7);
			setState(178);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Identifier) {
				{
				setState(177);
				forIteration();
				}
			}

			setState(180);
			match(T__2);
			setState(181);
			block();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ForInitContext extends ParserRuleContext {
		public AssignmentContext assignment() {
			return getRuleContext(AssignmentContext.class,0);
		}
		public VarDeclarationContext varDeclaration() {
			return getRuleContext(VarDeclarationContext.class,0);
		}
		public ForInitContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_forInit; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PrimaListener ) ((PrimaListener)listener).enterForInit(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PrimaListener ) ((PrimaListener)listener).exitForInit(this);
		}
	}

	public final ForInitContext forInit() throws RecognitionException {
		ForInitContext _localctx = new ForInitContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_forInit);
		try {
			setState(185);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(183);
				assignment();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(184);
				varDeclaration();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ForStopConditionContext extends ParserRuleContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public ForStopConditionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_forStopCondition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PrimaListener ) ((PrimaListener)listener).enterForStopCondition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PrimaListener ) ((PrimaListener)listener).exitForStopCondition(this);
		}
	}

	public final ForStopConditionContext forStopCondition() throws RecognitionException {
		ForStopConditionContext _localctx = new ForStopConditionContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_forStopCondition);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(187);
			expr(0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ForIterationContext extends ParserRuleContext {
		public AssignmentContext assignment() {
			return getRuleContext(AssignmentContext.class,0);
		}
		public ForIterationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_forIteration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PrimaListener ) ((PrimaListener)listener).enterForIteration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PrimaListener ) ((PrimaListener)listener).exitForIteration(this);
		}
	}

	public final ForIterationContext forIteration() throws RecognitionException {
		ForIterationContext _localctx = new ForIterationContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_forIteration);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(189);
			assignment();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class WhileStatementContext extends ParserRuleContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public WhileStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_whileStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PrimaListener ) ((PrimaListener)listener).enterWhileStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PrimaListener ) ((PrimaListener)listener).exitWhileStatement(this);
		}
	}

	public final WhileStatementContext whileStatement() throws RecognitionException {
		WhileStatementContext _localctx = new WhileStatementContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_whileStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(191);
			match(T__11);
			setState(192);
			match(T__1);
			setState(193);
			expr(0);
			setState(194);
			match(T__2);
			setState(195);
			block();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ReadStatementContext extends ParserRuleContext {
		public ReadCallContext readCall() {
			return getRuleContext(ReadCallContext.class,0);
		}
		public ReadStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_readStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PrimaListener ) ((PrimaListener)listener).enterReadStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PrimaListener ) ((PrimaListener)listener).exitReadStatement(this);
		}
	}

	public final ReadStatementContext readStatement() throws RecognitionException {
		ReadStatementContext _localctx = new ReadStatementContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_readStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(197);
			readCall();
			setState(198);
			match(T__7);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ReadCallContext extends ParserRuleContext {
		public Token name;
		public ReadCallContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_readCall; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PrimaListener ) ((PrimaListener)listener).enterReadCall(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PrimaListener ) ((PrimaListener)listener).exitReadCall(this);
		}
	}

	public final ReadCallContext readCall() throws RecognitionException {
		ReadCallContext _localctx = new ReadCallContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_readCall);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(200);
			((ReadCallContext)_localctx).name = _input.LT(1);
			_la = _input.LA(1);
			if ( !(_la==T__12 || _la==T__13) ) {
				((ReadCallContext)_localctx).name = (Token)_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(201);
			match(T__1);
			setState(202);
			match(T__2);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class WriteStatementContext extends ParserRuleContext {
		public Token name;
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public WriteStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_writeStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PrimaListener ) ((PrimaListener)listener).enterWriteStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PrimaListener ) ((PrimaListener)listener).exitWriteStatement(this);
		}
	}

	public final WriteStatementContext writeStatement() throws RecognitionException {
		WriteStatementContext _localctx = new WriteStatementContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_writeStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(204);
			((WriteStatementContext)_localctx).name = _input.LT(1);
			_la = _input.LA(1);
			if ( !(_la==T__14 || _la==T__15) ) {
				((WriteStatementContext)_localctx).name = (Token)_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(205);
			match(T__1);
			setState(206);
			expr(0);
			setState(207);
			match(T__2);
			setState(208);
			match(T__7);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ReturnStatementContext extends ParserRuleContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public ReturnStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_returnStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PrimaListener ) ((PrimaListener)listener).enterReturnStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PrimaListener ) ((PrimaListener)listener).exitReturnStatement(this);
		}
	}

	public final ReturnStatementContext returnStatement() throws RecognitionException {
		ReturnStatementContext _localctx = new ReturnStatementContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_returnStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(210);
			match(T__16);
			setState(211);
			expr(0);
			setState(212);
			match(T__7);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class VarDeclarationStatementContext extends ParserRuleContext {
		public VarDeclarationContext varDeclaration() {
			return getRuleContext(VarDeclarationContext.class,0);
		}
		public VarDeclarationStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_varDeclarationStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PrimaListener ) ((PrimaListener)listener).enterVarDeclarationStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PrimaListener ) ((PrimaListener)listener).exitVarDeclarationStatement(this);
		}
	}

	public final VarDeclarationStatementContext varDeclarationStatement() throws RecognitionException {
		VarDeclarationStatementContext _localctx = new VarDeclarationStatementContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_varDeclarationStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(214);
			varDeclaration();
			setState(215);
			match(T__7);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class VarDeclarationContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(PrimaParser.Identifier, 0); }
		public NonVoidTypeContext nonVoidType() {
			return getRuleContext(NonVoidTypeContext.class,0);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public VarDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_varDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PrimaListener ) ((PrimaListener)listener).enterVarDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PrimaListener ) ((PrimaListener)listener).exitVarDeclaration(this);
		}
	}

	public final VarDeclarationContext varDeclaration() throws RecognitionException {
		VarDeclarationContext _localctx = new VarDeclarationContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_varDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(217);
			match(Identifier);
			setState(218);
			match(T__3);
			setState(219);
			nonVoidType();
			setState(222);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__17) {
				{
				setState(220);
				match(T__17);
				setState(221);
				expr(0);
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class NopStatementContext extends ParserRuleContext {
		public TerminalNode Nop() { return getToken(PrimaParser.Nop, 0); }
		public NopStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_nopStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PrimaListener ) ((PrimaListener)listener).enterNopStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PrimaListener ) ((PrimaListener)listener).exitNopStatement(this);
		}
	}

	public final NopStatementContext nopStatement() throws RecognitionException {
		NopStatementContext _localctx = new NopStatementContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_nopStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(224);
			match(Nop);
			setState(225);
			match(T__7);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class NonVoidTypeContext extends ParserRuleContext {
		public NonVoidTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_nonVoidType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PrimaListener ) ((PrimaListener)listener).enterNonVoidType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PrimaListener ) ((PrimaListener)listener).exitNonVoidType(this);
		}
	}

	public final NonVoidTypeContext nonVoidType() throws RecognitionException {
		NonVoidTypeContext _localctx = new NonVoidTypeContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_nonVoidType);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(227);
			_la = _input.LA(1);
			if ( !(_la==T__18 || _la==T__19) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class VoidTypeContext extends ParserRuleContext {
		public VoidTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_voidType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PrimaListener ) ((PrimaListener)listener).enterVoidType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PrimaListener ) ((PrimaListener)listener).exitVoidType(this);
		}
	}

	public final VoidTypeContext voidType() throws RecognitionException {
		VoidTypeContext _localctx = new VoidTypeContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_voidType);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(229);
			match(T__20);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExprContext extends ParserRuleContext {
		public ExprContext left;
		public ExprContext right;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public IntLiteralContext intLiteral() {
			return getRuleContext(IntLiteralContext.class,0);
		}
		public BoolLiteralContext boolLiteral() {
			return getRuleContext(BoolLiteralContext.class,0);
		}
		public VarContext var() {
			return getRuleContext(VarContext.class,0);
		}
		public UnaryIntOpContext unaryIntOp() {
			return getRuleContext(UnaryIntOpContext.class,0);
		}
		public UnaryBoolOpContext unaryBoolOp() {
			return getRuleContext(UnaryBoolOpContext.class,0);
		}
		public ReadCallContext readCall() {
			return getRuleContext(ReadCallContext.class,0);
		}
		public FunctionCallContext functionCall() {
			return getRuleContext(FunctionCallContext.class,0);
		}
		public DivModMultOpContext divModMultOp() {
			return getRuleContext(DivModMultOpContext.class,0);
		}
		public AddSubOpContext addSubOp() {
			return getRuleContext(AddSubOpContext.class,0);
		}
		public CompOpContext compOp() {
			return getRuleContext(CompOpContext.class,0);
		}
		public EqualOpContext equalOp() {
			return getRuleContext(EqualOpContext.class,0);
		}
		public BoolAndOpContext boolAndOp() {
			return getRuleContext(BoolAndOpContext.class,0);
		}
		public BoolOrOpContext boolOrOp() {
			return getRuleContext(BoolOrOpContext.class,0);
		}
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PrimaListener ) ((PrimaListener)listener).enterExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PrimaListener ) ((PrimaListener)listener).exitExpr(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		return expr(0);
	}

	private ExprContext expr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExprContext _localctx = new ExprContext(_ctx, _parentState);
		ExprContext _prevctx = _localctx;
		int _startState = 54;
		enterRecursionRule(_localctx, 54, RULE_expr, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(247);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
			case 1:
				{
				setState(232);
				match(T__1);
				setState(233);
				expr(0);
				setState(234);
				match(T__2);
				}
				break;
			case 2:
				{
				setState(236);
				intLiteral();
				}
				break;
			case 3:
				{
				setState(237);
				boolLiteral();
				}
				break;
			case 4:
				{
				setState(238);
				var();
				}
				break;
			case 5:
				{
				setState(239);
				unaryIntOp();
				setState(240);
				expr(10);
				}
				break;
			case 6:
				{
				setState(242);
				unaryBoolOp();
				setState(243);
				expr(9);
				}
				break;
			case 7:
				{
				setState(245);
				readCall();
				}
				break;
			case 8:
				{
				setState(246);
				functionCall();
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(275);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,14,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(273);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
					case 1:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						_localctx.left = _prevctx;
						_localctx.left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(249);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(250);
						divModMultOp();
						setState(251);
						((ExprContext)_localctx).right = expr(9);
						}
						break;
					case 2:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						_localctx.left = _prevctx;
						_localctx.left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(253);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(254);
						addSubOp();
						setState(255);
						((ExprContext)_localctx).right = expr(8);
						}
						break;
					case 3:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						_localctx.left = _prevctx;
						_localctx.left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(257);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(258);
						compOp();
						setState(259);
						((ExprContext)_localctx).right = expr(7);
						}
						break;
					case 4:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						_localctx.left = _prevctx;
						_localctx.left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(261);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(262);
						equalOp();
						setState(263);
						((ExprContext)_localctx).right = expr(6);
						}
						break;
					case 5:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						_localctx.left = _prevctx;
						_localctx.left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(265);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(266);
						boolAndOp();
						setState(267);
						((ExprContext)_localctx).right = expr(5);
						}
						break;
					case 6:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						_localctx.left = _prevctx;
						_localctx.left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(269);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(270);
						boolOrOp();
						setState(271);
						((ExprContext)_localctx).right = expr(4);
						}
						break;
					}
					} 
				}
				setState(277);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,14,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class FunctionCallStatementContext extends ParserRuleContext {
		public FunctionCallContext functionCall() {
			return getRuleContext(FunctionCallContext.class,0);
		}
		public FunctionCallStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionCallStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PrimaListener ) ((PrimaListener)listener).enterFunctionCallStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PrimaListener ) ((PrimaListener)listener).exitFunctionCallStatement(this);
		}
	}

	public final FunctionCallStatementContext functionCallStatement() throws RecognitionException {
		FunctionCallStatementContext _localctx = new FunctionCallStatementContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_functionCallStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(278);
			functionCall();
			setState(279);
			match(T__7);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FunctionCallContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(PrimaParser.Identifier, 0); }
		public ArgumentListContext argumentList() {
			return getRuleContext(ArgumentListContext.class,0);
		}
		public FunctionCallContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionCall; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PrimaListener ) ((PrimaListener)listener).enterFunctionCall(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PrimaListener ) ((PrimaListener)listener).exitFunctionCall(this);
		}
	}

	public final FunctionCallContext functionCall() throws RecognitionException {
		FunctionCallContext _localctx = new FunctionCallContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_functionCall);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(281);
			match(Identifier);
			setState(282);
			match(T__1);
			setState(284);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__1) | (1L << T__12) | (1L << T__13) | (1L << T__21) | (1L << T__22) | (1L << T__23) | (1L << Identifier) | (1L << B) | (1L << Z))) != 0)) {
				{
				setState(283);
				argumentList();
				}
			}

			setState(286);
			match(T__2);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ArgumentListContext extends ParserRuleContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public ArgumentListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_argumentList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PrimaListener ) ((PrimaListener)listener).enterArgumentList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PrimaListener ) ((PrimaListener)listener).exitArgumentList(this);
		}
	}

	public final ArgumentListContext argumentList() throws RecognitionException {
		ArgumentListContext _localctx = new ArgumentListContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_argumentList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(288);
			expr(0);
			setState(293);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__4) {
				{
				{
				setState(289);
				match(T__4);
				setState(290);
				expr(0);
				}
				}
				setState(295);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class IntLiteralContext extends ParserRuleContext {
		public TerminalNode Z() { return getToken(PrimaParser.Z, 0); }
		public IntLiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_intLiteral; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PrimaListener ) ((PrimaListener)listener).enterIntLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PrimaListener ) ((PrimaListener)listener).exitIntLiteral(this);
		}
	}

	public final IntLiteralContext intLiteral() throws RecognitionException {
		IntLiteralContext _localctx = new IntLiteralContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_intLiteral);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(296);
			match(Z);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BoolLiteralContext extends ParserRuleContext {
		public TerminalNode B() { return getToken(PrimaParser.B, 0); }
		public BoolLiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_boolLiteral; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PrimaListener ) ((PrimaListener)listener).enterBoolLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PrimaListener ) ((PrimaListener)listener).exitBoolLiteral(this);
		}
	}

	public final BoolLiteralContext boolLiteral() throws RecognitionException {
		BoolLiteralContext _localctx = new BoolLiteralContext(_ctx, getState());
		enterRule(_localctx, 64, RULE_boolLiteral);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(298);
			match(B);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class VarContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(PrimaParser.Identifier, 0); }
		public VarContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_var; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PrimaListener ) ((PrimaListener)listener).enterVar(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PrimaListener ) ((PrimaListener)listener).exitVar(this);
		}
	}

	public final VarContext var() throws RecognitionException {
		VarContext _localctx = new VarContext(_ctx, getState());
		enterRule(_localctx, 66, RULE_var);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(300);
			match(Identifier);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class UnaryIntOpContext extends ParserRuleContext {
		public UnaryIntOpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unaryIntOp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PrimaListener ) ((PrimaListener)listener).enterUnaryIntOp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PrimaListener ) ((PrimaListener)listener).exitUnaryIntOp(this);
		}
	}

	public final UnaryIntOpContext unaryIntOp() throws RecognitionException {
		UnaryIntOpContext _localctx = new UnaryIntOpContext(_ctx, getState());
		enterRule(_localctx, 68, RULE_unaryIntOp);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(302);
			_la = _input.LA(1);
			if ( !(_la==T__21 || _la==T__22) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class UnaryBoolOpContext extends ParserRuleContext {
		public UnaryBoolOpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unaryBoolOp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PrimaListener ) ((PrimaListener)listener).enterUnaryBoolOp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PrimaListener ) ((PrimaListener)listener).exitUnaryBoolOp(this);
		}
	}

	public final UnaryBoolOpContext unaryBoolOp() throws RecognitionException {
		UnaryBoolOpContext _localctx = new UnaryBoolOpContext(_ctx, getState());
		enterRule(_localctx, 70, RULE_unaryBoolOp);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(304);
			match(T__23);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DivModMultOpContext extends ParserRuleContext {
		public DivModMultOpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_divModMultOp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PrimaListener ) ((PrimaListener)listener).enterDivModMultOp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PrimaListener ) ((PrimaListener)listener).exitDivModMultOp(this);
		}
	}

	public final DivModMultOpContext divModMultOp() throws RecognitionException {
		DivModMultOpContext _localctx = new DivModMultOpContext(_ctx, getState());
		enterRule(_localctx, 72, RULE_divModMultOp);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(306);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__24) | (1L << T__25) | (1L << T__26))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AddSubOpContext extends ParserRuleContext {
		public AddSubOpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_addSubOp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PrimaListener ) ((PrimaListener)listener).enterAddSubOp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PrimaListener ) ((PrimaListener)listener).exitAddSubOp(this);
		}
	}

	public final AddSubOpContext addSubOp() throws RecognitionException {
		AddSubOpContext _localctx = new AddSubOpContext(_ctx, getState());
		enterRule(_localctx, 74, RULE_addSubOp);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(308);
			_la = _input.LA(1);
			if ( !(_la==T__21 || _la==T__22) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CompOpContext extends ParserRuleContext {
		public CompOpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_compOp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PrimaListener ) ((PrimaListener)listener).enterCompOp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PrimaListener ) ((PrimaListener)listener).exitCompOp(this);
		}
	}

	public final CompOpContext compOp() throws RecognitionException {
		CompOpContext _localctx = new CompOpContext(_ctx, getState());
		enterRule(_localctx, 76, RULE_compOp);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(310);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__27) | (1L << T__28) | (1L << T__29) | (1L << T__30))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class EqualOpContext extends ParserRuleContext {
		public EqualOpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_equalOp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PrimaListener ) ((PrimaListener)listener).enterEqualOp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PrimaListener ) ((PrimaListener)listener).exitEqualOp(this);
		}
	}

	public final EqualOpContext equalOp() throws RecognitionException {
		EqualOpContext _localctx = new EqualOpContext(_ctx, getState());
		enterRule(_localctx, 78, RULE_equalOp);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(312);
			_la = _input.LA(1);
			if ( !(_la==T__31 || _la==T__32) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BoolAndOpContext extends ParserRuleContext {
		public BoolAndOpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_boolAndOp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PrimaListener ) ((PrimaListener)listener).enterBoolAndOp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PrimaListener ) ((PrimaListener)listener).exitBoolAndOp(this);
		}
	}

	public final BoolAndOpContext boolAndOp() throws RecognitionException {
		BoolAndOpContext _localctx = new BoolAndOpContext(_ctx, getState());
		enterRule(_localctx, 80, RULE_boolAndOp);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(314);
			match(T__33);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BoolOrOpContext extends ParserRuleContext {
		public BoolOrOpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_boolOrOp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PrimaListener ) ((PrimaListener)listener).enterBoolOrOp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PrimaListener ) ((PrimaListener)listener).exitBoolOrOp(this);
		}
	}

	public final BoolOrOpContext boolOrOp() throws RecognitionException {
		BoolOrOpContext _localctx = new BoolOrOpContext(_ctx, getState());
		enterRule(_localctx, 82, RULE_boolOrOp);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(316);
			match(T__34);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AssignmentOPContext extends ParserRuleContext {
		public AssignmentOPContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignmentOP; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PrimaListener ) ((PrimaListener)listener).enterAssignmentOP(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PrimaListener ) ((PrimaListener)listener).exitAssignmentOP(this);
		}
	}

	public final AssignmentOPContext assignmentOP() throws RecognitionException {
		AssignmentOPContext _localctx = new AssignmentOPContext(_ctx, getState());
		enterRule(_localctx, 84, RULE_assignmentOP);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(318);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__17) | (1L << T__35) | (1L << T__36) | (1L << T__37) | (1L << T__38) | (1L << T__39))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 27:
			return expr_sempred((ExprContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expr_sempred(ExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 8);
		case 1:
			return precpred(_ctx, 7);
		case 2:
			return precpred(_ctx, 6);
		case 3:
			return precpred(_ctx, 5);
		case 4:
			return precpred(_ctx, 4);
		case 5:
			return precpred(_ctx, 3);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\62\u0143\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\3\2\3\2\6\2[\n\2\r\2\16\2\\\3\3\3\3\3\4\3\4\3\4\3\4\3\5\3\5\3\5\5"+
		"\5h\n\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6\7\6q\n\6\f\6\16\6t\13\6\3\7\3\7\3"+
		"\7\3\7\3\b\3\b\7\b|\n\b\f\b\16\b\177\13\b\3\b\3\b\3\t\3\t\5\t\u0085\n"+
		"\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\5\n\u0093\n\n\3\13"+
		"\3\13\3\13\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\r\3\16\3\16\3\16\3\16"+
		"\3\16\3\16\3\16\3\16\3\17\3\17\3\17\5\17\u00ad\n\17\3\17\3\17\5\17\u00b1"+
		"\n\17\3\17\3\17\5\17\u00b5\n\17\3\17\3\17\3\17\3\20\3\20\5\20\u00bc\n"+
		"\20\3\21\3\21\3\22\3\22\3\23\3\23\3\23\3\23\3\23\3\23\3\24\3\24\3\24\3"+
		"\25\3\25\3\25\3\25\3\26\3\26\3\26\3\26\3\26\3\26\3\27\3\27\3\27\3\27\3"+
		"\30\3\30\3\30\3\31\3\31\3\31\3\31\3\31\5\31\u00e1\n\31\3\32\3\32\3\32"+
		"\3\33\3\33\3\34\3\34\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35"+
		"\3\35\3\35\3\35\3\35\3\35\3\35\5\35\u00fa\n\35\3\35\3\35\3\35\3\35\3\35"+
		"\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35"+
		"\3\35\3\35\3\35\3\35\3\35\7\35\u0114\n\35\f\35\16\35\u0117\13\35\3\36"+
		"\3\36\3\36\3\37\3\37\3\37\5\37\u011f\n\37\3\37\3\37\3 \3 \3 \7 \u0126"+
		"\n \f \16 \u0129\13 \3!\3!\3\"\3\"\3#\3#\3$\3$\3%\3%\3&\3&\3\'\3\'\3("+
		"\3(\3)\3)\3*\3*\3+\3+\3,\3,\3,\2\38-\2\4\6\b\n\f\16\20\22\24\26\30\32"+
		"\34\36 \"$&(*,.\60\62\64\668:<>@BDFHJLNPRTV\2\n\3\2\17\20\3\2\21\22\3"+
		"\2\25\26\3\2\30\31\3\2\33\35\3\2\36!\3\2\"#\4\2\24\24&*\u013c\2Z\3\2\2"+
		"\2\4^\3\2\2\2\6`\3\2\2\2\bd\3\2\2\2\nm\3\2\2\2\fu\3\2\2\2\16y\3\2\2\2"+
		"\20\u0084\3\2\2\2\22\u0092\3\2\2\2\24\u0094\3\2\2\2\26\u0097\3\2\2\2\30"+
		"\u009b\3\2\2\2\32\u00a1\3\2\2\2\34\u00a9\3\2\2\2\36\u00bb\3\2\2\2 \u00bd"+
		"\3\2\2\2\"\u00bf\3\2\2\2$\u00c1\3\2\2\2&\u00c7\3\2\2\2(\u00ca\3\2\2\2"+
		"*\u00ce\3\2\2\2,\u00d4\3\2\2\2.\u00d8\3\2\2\2\60\u00db\3\2\2\2\62\u00e2"+
		"\3\2\2\2\64\u00e5\3\2\2\2\66\u00e7\3\2\2\28\u00f9\3\2\2\2:\u0118\3\2\2"+
		"\2<\u011b\3\2\2\2>\u0122\3\2\2\2@\u012a\3\2\2\2B\u012c\3\2\2\2D\u012e"+
		"\3\2\2\2F\u0130\3\2\2\2H\u0132\3\2\2\2J\u0134\3\2\2\2L\u0136\3\2\2\2N"+
		"\u0138\3\2\2\2P\u013a\3\2\2\2R\u013c\3\2\2\2T\u013e\3\2\2\2V\u0140\3\2"+
		"\2\2X[\5\4\3\2Y[\5\6\4\2ZX\3\2\2\2ZY\3\2\2\2[\\\3\2\2\2\\Z\3\2\2\2\\]"+
		"\3\2\2\2]\3\3\2\2\2^_\5.\30\2_\5\3\2\2\2`a\7\3\2\2ab\5\b\5\2bc\5\16\b"+
		"\2c\7\3\2\2\2de\7+\2\2eg\7\4\2\2fh\5\n\6\2gf\3\2\2\2gh\3\2\2\2hi\3\2\2"+
		"\2ij\7\5\2\2jk\7\6\2\2kl\5\20\t\2l\t\3\2\2\2mr\5\f\7\2no\7\7\2\2oq\5\f"+
		"\7\2pn\3\2\2\2qt\3\2\2\2rp\3\2\2\2rs\3\2\2\2s\13\3\2\2\2tr\3\2\2\2uv\7"+
		"+\2\2vw\7\6\2\2wx\5\64\33\2x\r\3\2\2\2y}\7\b\2\2z|\5\22\n\2{z\3\2\2\2"+
		"|\177\3\2\2\2}{\3\2\2\2}~\3\2\2\2~\u0080\3\2\2\2\177}\3\2\2\2\u0080\u0081"+
		"\7\t\2\2\u0081\17\3\2\2\2\u0082\u0085\5\64\33\2\u0083\u0085\5\66\34\2"+
		"\u0084\u0082\3\2\2\2\u0084\u0083\3\2\2\2\u0085\21\3\2\2\2\u0086\u0093"+
		"\5\62\32\2\u0087\u0093\5\16\b\2\u0088\u0093\5.\30\2\u0089\u0093\5\24\13"+
		"\2\u008a\u0093\5\30\r\2\u008b\u0093\5\32\16\2\u008c\u0093\5\34\17\2\u008d"+
		"\u0093\5$\23\2\u008e\u0093\5&\24\2\u008f\u0093\5*\26\2\u0090\u0093\5,"+
		"\27\2\u0091\u0093\5:\36\2\u0092\u0086\3\2\2\2\u0092\u0087\3\2\2\2\u0092"+
		"\u0088\3\2\2\2\u0092\u0089\3\2\2\2\u0092\u008a\3\2\2\2\u0092\u008b\3\2"+
		"\2\2\u0092\u008c\3\2\2\2\u0092\u008d\3\2\2\2\u0092\u008e\3\2\2\2\u0092"+
		"\u008f\3\2\2\2\u0092\u0090\3\2\2\2\u0092\u0091\3\2\2\2\u0093\23\3\2\2"+
		"\2\u0094\u0095\5\26\f\2\u0095\u0096\7\n\2\2\u0096\25\3\2\2\2\u0097\u0098"+
		"\7+\2\2\u0098\u0099\5V,\2\u0099\u009a\58\35\2\u009a\27\3\2\2\2\u009b\u009c"+
		"\7\13\2\2\u009c\u009d\7\4\2\2\u009d\u009e\58\35\2\u009e\u009f\7\5\2\2"+
		"\u009f\u00a0\5\16\b\2\u00a0\31\3\2\2\2\u00a1\u00a2\7\13\2\2\u00a2\u00a3"+
		"\7\4\2\2\u00a3\u00a4\58\35\2\u00a4\u00a5\7\5\2\2\u00a5\u00a6\5\16\b\2"+
		"\u00a6\u00a7\7\f\2\2\u00a7\u00a8\5\16\b\2\u00a8\33\3\2\2\2\u00a9\u00aa"+
		"\7\r\2\2\u00aa\u00ac\7\4\2\2\u00ab\u00ad\5\36\20\2\u00ac\u00ab\3\2\2\2"+
		"\u00ac\u00ad\3\2\2\2\u00ad\u00ae\3\2\2\2\u00ae\u00b0\7\n\2\2\u00af\u00b1"+
		"\5 \21\2\u00b0\u00af\3\2\2\2\u00b0\u00b1\3\2\2\2\u00b1\u00b2\3\2\2\2\u00b2"+
		"\u00b4\7\n\2\2\u00b3\u00b5\5\"\22\2\u00b4\u00b3\3\2\2\2\u00b4\u00b5\3"+
		"\2\2\2\u00b5\u00b6\3\2\2\2\u00b6\u00b7\7\5\2\2\u00b7\u00b8\5\16\b\2\u00b8"+
		"\35\3\2\2\2\u00b9\u00bc\5\26\f\2\u00ba\u00bc\5\60\31\2\u00bb\u00b9\3\2"+
		"\2\2\u00bb\u00ba\3\2\2\2\u00bc\37\3\2\2\2\u00bd\u00be\58\35\2\u00be!\3"+
		"\2\2\2\u00bf\u00c0\5\26\f\2\u00c0#\3\2\2\2\u00c1\u00c2\7\16\2\2\u00c2"+
		"\u00c3\7\4\2\2\u00c3\u00c4\58\35\2\u00c4\u00c5\7\5\2\2\u00c5\u00c6\5\16"+
		"\b\2\u00c6%\3\2\2\2\u00c7\u00c8\5(\25\2\u00c8\u00c9\7\n\2\2\u00c9\'\3"+
		"\2\2\2\u00ca\u00cb\t\2\2\2\u00cb\u00cc\7\4\2\2\u00cc\u00cd\7\5\2\2\u00cd"+
		")\3\2\2\2\u00ce\u00cf\t\3\2\2\u00cf\u00d0\7\4\2\2\u00d0\u00d1\58\35\2"+
		"\u00d1\u00d2\7\5\2\2\u00d2\u00d3\7\n\2\2\u00d3+\3\2\2\2\u00d4\u00d5\7"+
		"\23\2\2\u00d5\u00d6\58\35\2\u00d6\u00d7\7\n\2\2\u00d7-\3\2\2\2\u00d8\u00d9"+
		"\5\60\31\2\u00d9\u00da\7\n\2\2\u00da/\3\2\2\2\u00db\u00dc\7+\2\2\u00dc"+
		"\u00dd\7\6\2\2\u00dd\u00e0\5\64\33\2\u00de\u00df\7\24\2\2\u00df\u00e1"+
		"\58\35\2\u00e0\u00de\3\2\2\2\u00e0\u00e1\3\2\2\2\u00e1\61\3\2\2\2\u00e2"+
		"\u00e3\7,\2\2\u00e3\u00e4\7\n\2\2\u00e4\63\3\2\2\2\u00e5\u00e6\t\4\2\2"+
		"\u00e6\65\3\2\2\2\u00e7\u00e8\7\27\2\2\u00e8\67\3\2\2\2\u00e9\u00ea\b"+
		"\35\1\2\u00ea\u00eb\7\4\2\2\u00eb\u00ec\58\35\2\u00ec\u00ed\7\5\2\2\u00ed"+
		"\u00fa\3\2\2\2\u00ee\u00fa\5@!\2\u00ef\u00fa\5B\"\2\u00f0\u00fa\5D#\2"+
		"\u00f1\u00f2\5F$\2\u00f2\u00f3\58\35\f\u00f3\u00fa\3\2\2\2\u00f4\u00f5"+
		"\5H%\2\u00f5\u00f6\58\35\13\u00f6\u00fa\3\2\2\2\u00f7\u00fa\5(\25\2\u00f8"+
		"\u00fa\5<\37\2\u00f9\u00e9\3\2\2\2\u00f9\u00ee\3\2\2\2\u00f9\u00ef\3\2"+
		"\2\2\u00f9\u00f0\3\2\2\2\u00f9\u00f1\3\2\2\2\u00f9\u00f4\3\2\2\2\u00f9"+
		"\u00f7\3\2\2\2\u00f9\u00f8\3\2\2\2\u00fa\u0115\3\2\2\2\u00fb\u00fc\f\n"+
		"\2\2\u00fc\u00fd\5J&\2\u00fd\u00fe\58\35\13\u00fe\u0114\3\2\2\2\u00ff"+
		"\u0100\f\t\2\2\u0100\u0101\5L\'\2\u0101\u0102\58\35\n\u0102\u0114\3\2"+
		"\2\2\u0103\u0104\f\b\2\2\u0104\u0105\5N(\2\u0105\u0106\58\35\t\u0106\u0114"+
		"\3\2\2\2\u0107\u0108\f\7\2\2\u0108\u0109\5P)\2\u0109\u010a\58\35\b\u010a"+
		"\u0114\3\2\2\2\u010b\u010c\f\6\2\2\u010c\u010d\5R*\2\u010d\u010e\58\35"+
		"\7\u010e\u0114\3\2\2\2\u010f\u0110\f\5\2\2\u0110\u0111\5T+\2\u0111\u0112"+
		"\58\35\6\u0112\u0114\3\2\2\2\u0113\u00fb\3\2\2\2\u0113\u00ff\3\2\2\2\u0113"+
		"\u0103\3\2\2\2\u0113\u0107\3\2\2\2\u0113\u010b\3\2\2\2\u0113\u010f\3\2"+
		"\2\2\u0114\u0117\3\2\2\2\u0115\u0113\3\2\2\2\u0115\u0116\3\2\2\2\u0116"+
		"9\3\2\2\2\u0117\u0115\3\2\2\2\u0118\u0119\5<\37\2\u0119\u011a\7\n\2\2"+
		"\u011a;\3\2\2\2\u011b\u011c\7+\2\2\u011c\u011e\7\4\2\2\u011d\u011f\5>"+
		" \2\u011e\u011d\3\2\2\2\u011e\u011f\3\2\2\2\u011f\u0120\3\2\2\2\u0120"+
		"\u0121\7\5\2\2\u0121=\3\2\2\2\u0122\u0127\58\35\2\u0123\u0124\7\7\2\2"+
		"\u0124\u0126\58\35\2\u0125\u0123\3\2\2\2\u0126\u0129\3\2\2\2\u0127\u0125"+
		"\3\2\2\2\u0127\u0128\3\2\2\2\u0128?\3\2\2\2\u0129\u0127\3\2\2\2\u012a"+
		"\u012b\7/\2\2\u012bA\3\2\2\2\u012c\u012d\7.\2\2\u012dC\3\2\2\2\u012e\u012f"+
		"\7+\2\2\u012fE\3\2\2\2\u0130\u0131\t\5\2\2\u0131G\3\2\2\2\u0132\u0133"+
		"\7\32\2\2\u0133I\3\2\2\2\u0134\u0135\t\6\2\2\u0135K\3\2\2\2\u0136\u0137"+
		"\t\5\2\2\u0137M\3\2\2\2\u0138\u0139\t\7\2\2\u0139O\3\2\2\2\u013a\u013b"+
		"\t\b\2\2\u013bQ\3\2\2\2\u013c\u013d\7$\2\2\u013dS\3\2\2\2\u013e\u013f"+
		"\7%\2\2\u013fU\3\2\2\2\u0140\u0141\t\t\2\2\u0141W\3\2\2\2\23Z\\gr}\u0084"+
		"\u0092\u00ac\u00b0\u00b4\u00bb\u00e0\u00f9\u0113\u0115\u011e\u0127";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}