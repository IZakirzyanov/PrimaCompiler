// Generated from D:/hw/PrimaCompiler/src/main/java/izakirzyanov/compiler\Prima.g4 by ANTLR 4.7
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
	static { RuntimeMetaData.checkVersion("4.7", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, T__23=24, 
		T__24=25, T__25=26, T__26=27, T__27=28, T__28=29, T__29=30, T__30=31, 
		T__31=32, T__32=33, T__33=34, T__34=35, T__35=36, T__36=37, T__37=38, 
		T__38=39, T__39=40, Nop=41, B=42, Z=43, STRING=44, Identifier=45, ID=46, 
		WS=47, COMMENT=48, LINE_COMMENT=49;
	public static final int
		RULE_program = 0, RULE_globalVarDeclaration = 1, RULE_functionDeclaration = 2, 
		RULE_functionSignature = 3, RULE_functionArguments = 4, RULE_functionArg = 5, 
		RULE_block = 6, RULE_type = 7, RULE_statement = 8, RULE_assignmentStatement = 9, 
		RULE_assignment = 10, RULE_arraySetterStatement = 11, RULE_ifStatement = 12, 
		RULE_forStatement = 13, RULE_forInit = 14, RULE_forIteration = 15, RULE_whileStatement = 16, 
		RULE_readCall = 17, RULE_writeStatement = 18, RULE_returnStatement = 19, 
		RULE_varDeclarationStatement = 20, RULE_varDeclaration = 21, RULE_arrayInitializer = 22, 
		RULE_nopStatement = 23, RULE_nonVoidType = 24, RULE_primitiveType = 25, 
		RULE_arrayType = 26, RULE_dims = 27, RULE_voidType = 28, RULE_expr = 29, 
		RULE_arrayGetter = 30, RULE_functionCallStatement = 31, RULE_functionCall = 32, 
		RULE_argumentList = 33, RULE_intLiteral = 34, RULE_boolLiteral = 35, RULE_stringLiteral = 36, 
		RULE_variableName = 37;
	public static final String[] ruleNames = {
		"program", "globalVarDeclaration", "functionDeclaration", "functionSignature", 
		"functionArguments", "functionArg", "block", "type", "statement", "assignmentStatement", 
		"assignment", "arraySetterStatement", "ifStatement", "forStatement", "forInit", 
		"forIteration", "whileStatement", "readCall", "writeStatement", "returnStatement", 
		"varDeclarationStatement", "varDeclaration", "arrayInitializer", "nopStatement", 
		"nonVoidType", "primitiveType", "arrayType", "dims", "voidType", "expr", 
		"arrayGetter", "functionCallStatement", "functionCall", "argumentList", 
		"intLiteral", "boolLiteral", "stringLiteral", "variableName"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'fun'", "'('", "')'", "':'", "','", "'{'", "'}'", "';'", "'='", 
		"'['", "']'", "'if'", "'else'", "'for'", "'while'", "'readInt'", "'readBool'", 
		"'readStr'", "'write'", "'writeln'", "'return'", "'var'", "'int'", "'bool'", 
		"'str'", "'void'", "'+'", "'-'", "'!'", "'/'", "'%'", "'*'", "'<'", "'>'", 
		"'<='", "'>='", "'=='", "'!='", "'&&'", "'||'", "'nop'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, "Nop", "B", "Z", "STRING", "Identifier", 
		"ID", "WS", "COMMENT", "LINE_COMMENT"
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
		public List<GlobalVarDeclarationContext> globalVarDeclaration() {
			return getRuleContexts(GlobalVarDeclarationContext.class);
		}
		public GlobalVarDeclarationContext globalVarDeclaration(int i) {
			return getRuleContext(GlobalVarDeclarationContext.class,i);
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PrimaVisitor ) return ((PrimaVisitor<? extends T>)visitor).visitProgram(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(78); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				setState(78);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__21:
					{
					setState(76);
					globalVarDeclaration();
					}
					break;
				case T__0:
					{
					setState(77);
					functionDeclaration();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(80); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==T__0 || _la==T__21 );
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

	public static class GlobalVarDeclarationContext extends ParserRuleContext {
		public VarDeclarationStatementContext varDeclarationStatement() {
			return getRuleContext(VarDeclarationStatementContext.class,0);
		}
		public GlobalVarDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_globalVarDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PrimaListener ) ((PrimaListener)listener).enterGlobalVarDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PrimaListener ) ((PrimaListener)listener).exitGlobalVarDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PrimaVisitor ) return ((PrimaVisitor<? extends T>)visitor).visitGlobalVarDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final GlobalVarDeclarationContext globalVarDeclaration() throws RecognitionException {
		GlobalVarDeclarationContext _localctx = new GlobalVarDeclarationContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_globalVarDeclaration);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(82);
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PrimaVisitor ) return ((PrimaVisitor<? extends T>)visitor).visitFunctionDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctionDeclarationContext functionDeclaration() throws RecognitionException {
		FunctionDeclarationContext _localctx = new FunctionDeclarationContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_functionDeclaration);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(84);
			match(T__0);
			setState(85);
			functionSignature();
			setState(86);
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
		public Token name;
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode Identifier() { return getToken(PrimaParser.Identifier, 0); }
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PrimaVisitor ) return ((PrimaVisitor<? extends T>)visitor).visitFunctionSignature(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctionSignatureContext functionSignature() throws RecognitionException {
		FunctionSignatureContext _localctx = new FunctionSignatureContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_functionSignature);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(88);
			((FunctionSignatureContext)_localctx).name = match(Identifier);
			setState(89);
			match(T__1);
			setState(91);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Identifier) {
				{
				setState(90);
				functionArguments();
				}
			}

			setState(93);
			match(T__2);
			setState(94);
			match(T__3);
			setState(95);
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PrimaVisitor ) return ((PrimaVisitor<? extends T>)visitor).visitFunctionArguments(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctionArgumentsContext functionArguments() throws RecognitionException {
		FunctionArgumentsContext _localctx = new FunctionArgumentsContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_functionArguments);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(97);
			functionArg();
			setState(102);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__4) {
				{
				{
				setState(98);
				match(T__4);
				setState(99);
				functionArg();
				}
				}
				setState(104);
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
		public Token name;
		public NonVoidTypeContext nonVoidType() {
			return getRuleContext(NonVoidTypeContext.class,0);
		}
		public TerminalNode Identifier() { return getToken(PrimaParser.Identifier, 0); }
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PrimaVisitor ) return ((PrimaVisitor<? extends T>)visitor).visitFunctionArg(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctionArgContext functionArg() throws RecognitionException {
		FunctionArgContext _localctx = new FunctionArgContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_functionArg);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(105);
			((FunctionArgContext)_localctx).name = match(Identifier);
			setState(106);
			match(T__3);
			setState(107);
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PrimaVisitor ) return ((PrimaVisitor<? extends T>)visitor).visitBlock(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BlockContext block() throws RecognitionException {
		BlockContext _localctx = new BlockContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_block);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(109);
			match(T__5);
			setState(113);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__5) | (1L << T__11) | (1L << T__13) | (1L << T__14) | (1L << T__18) | (1L << T__19) | (1L << T__20) | (1L << T__21) | (1L << Nop) | (1L << Identifier))) != 0)) {
				{
				{
				setState(110);
				statement();
				}
				}
				setState(115);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(116);
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PrimaVisitor ) return ((PrimaVisitor<? extends T>)visitor).visitType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_type);
		try {
			setState(120);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__22:
			case T__23:
			case T__24:
				enterOuterAlt(_localctx, 1);
				{
				setState(118);
				nonVoidType();
				}
				break;
			case T__25:
				enterOuterAlt(_localctx, 2);
				{
				setState(119);
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
		public ArraySetterStatementContext arraySetterStatement() {
			return getRuleContext(ArraySetterStatementContext.class,0);
		}
		public AssignmentStatementContext assignmentStatement() {
			return getRuleContext(AssignmentStatementContext.class,0);
		}
		public IfStatementContext ifStatement() {
			return getRuleContext(IfStatementContext.class,0);
		}
		public WhileStatementContext whileStatement() {
			return getRuleContext(WhileStatementContext.class,0);
		}
		public ForStatementContext forStatement() {
			return getRuleContext(ForStatementContext.class,0);
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PrimaVisitor ) return ((PrimaVisitor<? extends T>)visitor).visitStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_statement);
		try {
			setState(133);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(122);
				nopStatement();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(123);
				block();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(124);
				varDeclarationStatement();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(125);
				arraySetterStatement();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(126);
				assignmentStatement();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(127);
				ifStatement();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(128);
				whileStatement();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(129);
				forStatement();
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(130);
				writeStatement();
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(131);
				returnStatement();
				}
				break;
			case 11:
				enterOuterAlt(_localctx, 11);
				{
				setState(132);
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PrimaVisitor ) return ((PrimaVisitor<? extends T>)visitor).visitAssignmentStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AssignmentStatementContext assignmentStatement() throws RecognitionException {
		AssignmentStatementContext _localctx = new AssignmentStatementContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_assignmentStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(135);
			assignment();
			setState(136);
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
		public Token name;
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode Identifier() { return getToken(PrimaParser.Identifier, 0); }
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PrimaVisitor ) return ((PrimaVisitor<? extends T>)visitor).visitAssignment(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AssignmentContext assignment() throws RecognitionException {
		AssignmentContext _localctx = new AssignmentContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_assignment);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(138);
			((AssignmentContext)_localctx).name = match(Identifier);
			setState(139);
			match(T__8);
			setState(140);
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

	public static class ArraySetterStatementContext extends ParserRuleContext {
		public Token name;
		public ExprContext expr;
		public List<ExprContext> indices = new ArrayList<ExprContext>();
		public ExprContext value;
		public TerminalNode Identifier() { return getToken(PrimaParser.Identifier, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public ArraySetterStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arraySetterStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PrimaListener ) ((PrimaListener)listener).enterArraySetterStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PrimaListener ) ((PrimaListener)listener).exitArraySetterStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PrimaVisitor ) return ((PrimaVisitor<? extends T>)visitor).visitArraySetterStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArraySetterStatementContext arraySetterStatement() throws RecognitionException {
		ArraySetterStatementContext _localctx = new ArraySetterStatementContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_arraySetterStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(142);
			((ArraySetterStatementContext)_localctx).name = match(Identifier);
			setState(147); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(143);
				match(T__9);
				setState(144);
				((ArraySetterStatementContext)_localctx).expr = expr(0);
				((ArraySetterStatementContext)_localctx).indices.add(((ArraySetterStatementContext)_localctx).expr);
				setState(145);
				match(T__10);
				}
				}
				setState(149); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==T__9 );
			setState(151);
			match(T__8);
			setState(152);
			((ArraySetterStatementContext)_localctx).value = expr(0);
			setState(153);
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

	public static class IfStatementContext extends ParserRuleContext {
		public ExprContext condition;
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PrimaVisitor ) return ((PrimaVisitor<? extends T>)visitor).visitIfStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IfStatementContext ifStatement() throws RecognitionException {
		IfStatementContext _localctx = new IfStatementContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_ifStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(155);
			match(T__11);
			setState(156);
			match(T__1);
			setState(157);
			((IfStatementContext)_localctx).condition = expr(0);
			setState(158);
			match(T__2);
			setState(159);
			((IfStatementContext)_localctx).thenBlock = block();
			setState(162);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__12) {
				{
				setState(160);
				match(T__12);
				setState(161);
				((IfStatementContext)_localctx).elseBlock = block();
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

	public static class ForStatementContext extends ParserRuleContext {
		public ExprContext forStopCondition;
		public BlockContext body;
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public ForInitContext forInit() {
			return getRuleContext(ForInitContext.class,0);
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PrimaVisitor ) return ((PrimaVisitor<? extends T>)visitor).visitForStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ForStatementContext forStatement() throws RecognitionException {
		ForStatementContext _localctx = new ForStatementContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_forStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(164);
			match(T__13);
			setState(165);
			match(T__1);
			setState(167);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__21 || _la==Identifier) {
				{
				setState(166);
				forInit();
				}
			}

			setState(169);
			match(T__7);
			setState(170);
			((ForStatementContext)_localctx).forStopCondition = expr(0);
			setState(171);
			match(T__7);
			setState(173);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Identifier) {
				{
				setState(172);
				forIteration();
				}
			}

			setState(175);
			match(T__2);
			setState(176);
			((ForStatementContext)_localctx).body = block();
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PrimaVisitor ) return ((PrimaVisitor<? extends T>)visitor).visitForInit(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ForInitContext forInit() throws RecognitionException {
		ForInitContext _localctx = new ForInitContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_forInit);
		try {
			setState(180);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Identifier:
				enterOuterAlt(_localctx, 1);
				{
				setState(178);
				assignment();
				}
				break;
			case T__21:
				enterOuterAlt(_localctx, 2);
				{
				setState(179);
				varDeclaration();
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PrimaVisitor ) return ((PrimaVisitor<? extends T>)visitor).visitForIteration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ForIterationContext forIteration() throws RecognitionException {
		ForIterationContext _localctx = new ForIterationContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_forIteration);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(182);
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
		public ExprContext condition;
		public BlockContext body;
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PrimaVisitor ) return ((PrimaVisitor<? extends T>)visitor).visitWhileStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final WhileStatementContext whileStatement() throws RecognitionException {
		WhileStatementContext _localctx = new WhileStatementContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_whileStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(184);
			match(T__14);
			setState(185);
			match(T__1);
			setState(186);
			((WhileStatementContext)_localctx).condition = expr(0);
			setState(187);
			match(T__2);
			setState(188);
			((WhileStatementContext)_localctx).body = block();
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PrimaVisitor ) return ((PrimaVisitor<? extends T>)visitor).visitReadCall(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ReadCallContext readCall() throws RecognitionException {
		ReadCallContext _localctx = new ReadCallContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_readCall);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(190);
			((ReadCallContext)_localctx).name = _input.LT(1);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__15) | (1L << T__16) | (1L << T__17))) != 0)) ) {
				((ReadCallContext)_localctx).name = (Token)_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(191);
			match(T__1);
			setState(192);
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
		public Token write;
		public Token writeln;
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PrimaVisitor ) return ((PrimaVisitor<? extends T>)visitor).visitWriteStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final WriteStatementContext writeStatement() throws RecognitionException {
		WriteStatementContext _localctx = new WriteStatementContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_writeStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(196);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__18:
				{
				setState(194);
				((WriteStatementContext)_localctx).write = match(T__18);
				}
				break;
			case T__19:
				{
				setState(195);
				((WriteStatementContext)_localctx).writeln = match(T__19);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(198);
			match(T__1);
			setState(200);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__1) | (1L << T__15) | (1L << T__16) | (1L << T__17) | (1L << T__26) | (1L << T__27) | (1L << T__28) | (1L << B) | (1L << Z) | (1L << STRING) | (1L << Identifier))) != 0)) {
				{
				setState(199);
				expr(0);
				}
			}

			setState(202);
			match(T__2);
			setState(203);
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PrimaVisitor ) return ((PrimaVisitor<? extends T>)visitor).visitReturnStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ReturnStatementContext returnStatement() throws RecognitionException {
		ReturnStatementContext _localctx = new ReturnStatementContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_returnStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(205);
			match(T__20);
			setState(206);
			expr(0);
			setState(207);
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PrimaVisitor ) return ((PrimaVisitor<? extends T>)visitor).visitVarDeclarationStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VarDeclarationStatementContext varDeclarationStatement() throws RecognitionException {
		VarDeclarationStatementContext _localctx = new VarDeclarationStatementContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_varDeclarationStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(209);
			varDeclaration();
			setState(210);
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
		public VarDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_varDeclaration; }
	 
		public VarDeclarationContext() { }
		public void copyFrom(VarDeclarationContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class PrimitiveDeclarationContext extends VarDeclarationContext {
		public Token name;
		public PrimitiveTypeContext primitiveType() {
			return getRuleContext(PrimitiveTypeContext.class,0);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode Identifier() { return getToken(PrimaParser.Identifier, 0); }
		public PrimitiveDeclarationContext(VarDeclarationContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PrimaListener ) ((PrimaListener)listener).enterPrimitiveDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PrimaListener ) ((PrimaListener)listener).exitPrimitiveDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PrimaVisitor ) return ((PrimaVisitor<? extends T>)visitor).visitPrimitiveDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ArrayDeclarationContext extends VarDeclarationContext {
		public Token name;
		public ArrayTypeContext arrayType() {
			return getRuleContext(ArrayTypeContext.class,0);
		}
		public ArrayInitializerContext arrayInitializer() {
			return getRuleContext(ArrayInitializerContext.class,0);
		}
		public TerminalNode Identifier() { return getToken(PrimaParser.Identifier, 0); }
		public ArrayDeclarationContext(VarDeclarationContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PrimaListener ) ((PrimaListener)listener).enterArrayDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PrimaListener ) ((PrimaListener)listener).exitArrayDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PrimaVisitor ) return ((PrimaVisitor<? extends T>)visitor).visitArrayDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VarDeclarationContext varDeclaration() throws RecognitionException {
		VarDeclarationContext _localctx = new VarDeclarationContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_varDeclaration);
		try {
			setState(226);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
			case 1:
				_localctx = new ArrayDeclarationContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(212);
				match(T__21);
				setState(213);
				((ArrayDeclarationContext)_localctx).name = match(Identifier);
				setState(214);
				match(T__3);
				setState(215);
				arrayType();
				setState(216);
				match(T__8);
				setState(217);
				arrayInitializer();
				}
				break;
			case 2:
				_localctx = new PrimitiveDeclarationContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(219);
				match(T__21);
				setState(220);
				((PrimitiveDeclarationContext)_localctx).name = match(Identifier);
				setState(221);
				match(T__3);
				setState(222);
				primitiveType();
				setState(223);
				match(T__8);
				setState(224);
				expr(0);
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

	public static class ArrayInitializerContext extends ParserRuleContext {
		public ExprContext expr;
		public List<ExprContext> sizes = new ArrayList<ExprContext>();
		public PrimitiveTypeContext primitiveType() {
			return getRuleContext(PrimitiveTypeContext.class,0);
		}
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public ArrayInitializerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arrayInitializer; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PrimaListener ) ((PrimaListener)listener).enterArrayInitializer(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PrimaListener ) ((PrimaListener)listener).exitArrayInitializer(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PrimaVisitor ) return ((PrimaVisitor<? extends T>)visitor).visitArrayInitializer(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArrayInitializerContext arrayInitializer() throws RecognitionException {
		ArrayInitializerContext _localctx = new ArrayInitializerContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_arrayInitializer);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(228);
			primitiveType();
			setState(233); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(229);
				match(T__9);
				setState(230);
				((ArrayInitializerContext)_localctx).expr = expr(0);
				((ArrayInitializerContext)_localctx).sizes.add(((ArrayInitializerContext)_localctx).expr);
				setState(231);
				match(T__10);
				}
				}
				setState(235); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==T__9 );
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PrimaVisitor ) return ((PrimaVisitor<? extends T>)visitor).visitNopStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NopStatementContext nopStatement() throws RecognitionException {
		NopStatementContext _localctx = new NopStatementContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_nopStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(237);
			match(Nop);
			setState(238);
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
		public PrimitiveTypeContext primitiveType() {
			return getRuleContext(PrimitiveTypeContext.class,0);
		}
		public ArrayTypeContext arrayType() {
			return getRuleContext(ArrayTypeContext.class,0);
		}
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PrimaVisitor ) return ((PrimaVisitor<? extends T>)visitor).visitNonVoidType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NonVoidTypeContext nonVoidType() throws RecognitionException {
		NonVoidTypeContext _localctx = new NonVoidTypeContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_nonVoidType);
		try {
			setState(242);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(240);
				primitiveType();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(241);
				arrayType();
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

	public static class PrimitiveTypeContext extends ParserRuleContext {
		public PrimitiveTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_primitiveType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PrimaListener ) ((PrimaListener)listener).enterPrimitiveType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PrimaListener ) ((PrimaListener)listener).exitPrimitiveType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PrimaVisitor ) return ((PrimaVisitor<? extends T>)visitor).visitPrimitiveType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PrimitiveTypeContext primitiveType() throws RecognitionException {
		PrimitiveTypeContext _localctx = new PrimitiveTypeContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_primitiveType);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(244);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__22) | (1L << T__23) | (1L << T__24))) != 0)) ) {
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

	public static class ArrayTypeContext extends ParserRuleContext {
		public PrimitiveTypeContext primitiveType() {
			return getRuleContext(PrimitiveTypeContext.class,0);
		}
		public DimsContext dims() {
			return getRuleContext(DimsContext.class,0);
		}
		public ArrayTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arrayType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PrimaListener ) ((PrimaListener)listener).enterArrayType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PrimaListener ) ((PrimaListener)listener).exitArrayType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PrimaVisitor ) return ((PrimaVisitor<? extends T>)visitor).visitArrayType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArrayTypeContext arrayType() throws RecognitionException {
		ArrayTypeContext _localctx = new ArrayTypeContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_arrayType);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(246);
			primitiveType();
			setState(247);
			dims();
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

	public static class DimsContext extends ParserRuleContext {
		public DimsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dims; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PrimaListener ) ((PrimaListener)listener).enterDims(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PrimaListener ) ((PrimaListener)listener).exitDims(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PrimaVisitor ) return ((PrimaVisitor<? extends T>)visitor).visitDims(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DimsContext dims() throws RecognitionException {
		DimsContext _localctx = new DimsContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_dims);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(251); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(249);
				match(T__9);
				setState(250);
				match(T__10);
				}
				}
				setState(253); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==T__9 );
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PrimaVisitor ) return ((PrimaVisitor<? extends T>)visitor).visitVoidType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VoidTypeContext voidType() throws RecognitionException {
		VoidTypeContext _localctx = new VoidTypeContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_voidType);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(255);
			match(T__25);
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
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
	 
		public ExprContext() { }
		public void copyFrom(ExprContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class EXPRBinaryContext extends ExprContext {
		public ExprContext left;
		public Token op;
		public ExprContext right;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public EXPRBinaryContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PrimaListener ) ((PrimaListener)listener).enterEXPRBinary(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PrimaListener ) ((PrimaListener)listener).exitEXPRBinary(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PrimaVisitor ) return ((PrimaVisitor<? extends T>)visitor).visitEXPRBinary(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class EXPRUnaryContext extends ExprContext {
		public Token op;
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public EXPRUnaryContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PrimaListener ) ((PrimaListener)listener).enterEXPRUnary(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PrimaListener ) ((PrimaListener)listener).exitEXPRUnary(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PrimaVisitor ) return ((PrimaVisitor<? extends T>)visitor).visitEXPRUnary(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class EXPRReadCallContext extends ExprContext {
		public ReadCallContext readCall() {
			return getRuleContext(ReadCallContext.class,0);
		}
		public EXPRReadCallContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PrimaListener ) ((PrimaListener)listener).enterEXPRReadCall(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PrimaListener ) ((PrimaListener)listener).exitEXPRReadCall(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PrimaVisitor ) return ((PrimaVisitor<? extends T>)visitor).visitEXPRReadCall(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class EXPRFunctionCallContext extends ExprContext {
		public FunctionCallContext functionCall() {
			return getRuleContext(FunctionCallContext.class,0);
		}
		public EXPRFunctionCallContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PrimaListener ) ((PrimaListener)listener).enterEXPRFunctionCall(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PrimaListener ) ((PrimaListener)listener).exitEXPRFunctionCall(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PrimaVisitor ) return ((PrimaVisitor<? extends T>)visitor).visitEXPRFunctionCall(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class EXPRArrayGetterContext extends ExprContext {
		public ArrayGetterContext arrayGetter() {
			return getRuleContext(ArrayGetterContext.class,0);
		}
		public EXPRArrayGetterContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PrimaListener ) ((PrimaListener)listener).enterEXPRArrayGetter(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PrimaListener ) ((PrimaListener)listener).exitEXPRArrayGetter(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PrimaVisitor ) return ((PrimaVisitor<? extends T>)visitor).visitEXPRArrayGetter(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class EXPRVarNameContext extends ExprContext {
		public VariableNameContext variableName() {
			return getRuleContext(VariableNameContext.class,0);
		}
		public EXPRVarNameContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PrimaListener ) ((PrimaListener)listener).enterEXPRVarName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PrimaListener ) ((PrimaListener)listener).exitEXPRVarName(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PrimaVisitor ) return ((PrimaVisitor<? extends T>)visitor).visitEXPRVarName(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class EXPRParenthesisContext extends ExprContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public EXPRParenthesisContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PrimaListener ) ((PrimaListener)listener).enterEXPRParenthesis(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PrimaListener ) ((PrimaListener)listener).exitEXPRParenthesis(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PrimaVisitor ) return ((PrimaVisitor<? extends T>)visitor).visitEXPRParenthesis(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class EXPRLiteralContext extends ExprContext {
		public IntLiteralContext intLiteral() {
			return getRuleContext(IntLiteralContext.class,0);
		}
		public BoolLiteralContext boolLiteral() {
			return getRuleContext(BoolLiteralContext.class,0);
		}
		public StringLiteralContext stringLiteral() {
			return getRuleContext(StringLiteralContext.class,0);
		}
		public EXPRLiteralContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PrimaListener ) ((PrimaListener)listener).enterEXPRLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PrimaListener ) ((PrimaListener)listener).exitEXPRLiteral(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PrimaVisitor ) return ((PrimaVisitor<? extends T>)visitor).visitEXPRLiteral(this);
			else return visitor.visitChildren(this);
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
		int _startState = 58;
		enterRecursionRule(_localctx, 58, RULE_expr, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(273);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,18,_ctx) ) {
			case 1:
				{
				_localctx = new EXPRParenthesisContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(258);
				match(T__1);
				setState(259);
				expr(0);
				setState(260);
				match(T__2);
				}
				break;
			case 2:
				{
				_localctx = new EXPRLiteralContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(262);
				intLiteral();
				}
				break;
			case 3:
				{
				_localctx = new EXPRLiteralContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(263);
				boolLiteral();
				}
				break;
			case 4:
				{
				_localctx = new EXPRLiteralContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(264);
				stringLiteral();
				}
				break;
			case 5:
				{
				_localctx = new EXPRVarNameContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(265);
				variableName();
				}
				break;
			case 6:
				{
				_localctx = new EXPRArrayGetterContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(266);
				arrayGetter();
				}
				break;
			case 7:
				{
				_localctx = new EXPRUnaryContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(267);
				((EXPRUnaryContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==T__26 || _la==T__27) ) {
					((EXPRUnaryContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(268);
				expr(10);
				}
				break;
			case 8:
				{
				_localctx = new EXPRUnaryContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(269);
				((EXPRUnaryContext)_localctx).op = match(T__28);
				setState(270);
				expr(9);
				}
				break;
			case 9:
				{
				_localctx = new EXPRReadCallContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(271);
				readCall();
				}
				break;
			case 10:
				{
				_localctx = new EXPRFunctionCallContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(272);
				functionCall();
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(295);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,20,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(293);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,19,_ctx) ) {
					case 1:
						{
						_localctx = new EXPRBinaryContext(new ExprContext(_parentctx, _parentState));
						((EXPRBinaryContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(275);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(276);
						((EXPRBinaryContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__29) | (1L << T__30) | (1L << T__31))) != 0)) ) {
							((EXPRBinaryContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(277);
						((EXPRBinaryContext)_localctx).right = expr(9);
						}
						break;
					case 2:
						{
						_localctx = new EXPRBinaryContext(new ExprContext(_parentctx, _parentState));
						((EXPRBinaryContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(278);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(279);
						((EXPRBinaryContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__26 || _la==T__27) ) {
							((EXPRBinaryContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(280);
						((EXPRBinaryContext)_localctx).right = expr(8);
						}
						break;
					case 3:
						{
						_localctx = new EXPRBinaryContext(new ExprContext(_parentctx, _parentState));
						((EXPRBinaryContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(281);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(282);
						((EXPRBinaryContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__32) | (1L << T__33) | (1L << T__34) | (1L << T__35))) != 0)) ) {
							((EXPRBinaryContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(283);
						((EXPRBinaryContext)_localctx).right = expr(7);
						}
						break;
					case 4:
						{
						_localctx = new EXPRBinaryContext(new ExprContext(_parentctx, _parentState));
						((EXPRBinaryContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(284);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(285);
						((EXPRBinaryContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__36 || _la==T__37) ) {
							((EXPRBinaryContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(286);
						((EXPRBinaryContext)_localctx).right = expr(6);
						}
						break;
					case 5:
						{
						_localctx = new EXPRBinaryContext(new ExprContext(_parentctx, _parentState));
						((EXPRBinaryContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(287);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(288);
						((EXPRBinaryContext)_localctx).op = match(T__38);
						setState(289);
						((EXPRBinaryContext)_localctx).right = expr(5);
						}
						break;
					case 6:
						{
						_localctx = new EXPRBinaryContext(new ExprContext(_parentctx, _parentState));
						((EXPRBinaryContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(290);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(291);
						((EXPRBinaryContext)_localctx).op = match(T__39);
						setState(292);
						((EXPRBinaryContext)_localctx).right = expr(4);
						}
						break;
					}
					} 
				}
				setState(297);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,20,_ctx);
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

	public static class ArrayGetterContext extends ParserRuleContext {
		public Token name;
		public ExprContext expr;
		public List<ExprContext> indices = new ArrayList<ExprContext>();
		public TerminalNode Identifier() { return getToken(PrimaParser.Identifier, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public ArrayGetterContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arrayGetter; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PrimaListener ) ((PrimaListener)listener).enterArrayGetter(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PrimaListener ) ((PrimaListener)listener).exitArrayGetter(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PrimaVisitor ) return ((PrimaVisitor<? extends T>)visitor).visitArrayGetter(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArrayGetterContext arrayGetter() throws RecognitionException {
		ArrayGetterContext _localctx = new ArrayGetterContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_arrayGetter);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(298);
			((ArrayGetterContext)_localctx).name = match(Identifier);
			setState(303); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(299);
					match(T__9);
					setState(300);
					((ArrayGetterContext)_localctx).expr = expr(0);
					((ArrayGetterContext)_localctx).indices.add(((ArrayGetterContext)_localctx).expr);
					setState(301);
					match(T__10);
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(305); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,21,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PrimaVisitor ) return ((PrimaVisitor<? extends T>)visitor).visitFunctionCallStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctionCallStatementContext functionCallStatement() throws RecognitionException {
		FunctionCallStatementContext _localctx = new FunctionCallStatementContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_functionCallStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(307);
			functionCall();
			setState(308);
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
		public Token name;
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PrimaVisitor ) return ((PrimaVisitor<? extends T>)visitor).visitFunctionCall(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctionCallContext functionCall() throws RecognitionException {
		FunctionCallContext _localctx = new FunctionCallContext(_ctx, getState());
		enterRule(_localctx, 64, RULE_functionCall);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(310);
			((FunctionCallContext)_localctx).name = match(Identifier);
			setState(311);
			match(T__1);
			setState(313);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__1) | (1L << T__15) | (1L << T__16) | (1L << T__17) | (1L << T__26) | (1L << T__27) | (1L << T__28) | (1L << B) | (1L << Z) | (1L << STRING) | (1L << Identifier))) != 0)) {
				{
				setState(312);
				argumentList();
				}
			}

			setState(315);
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PrimaVisitor ) return ((PrimaVisitor<? extends T>)visitor).visitArgumentList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArgumentListContext argumentList() throws RecognitionException {
		ArgumentListContext _localctx = new ArgumentListContext(_ctx, getState());
		enterRule(_localctx, 66, RULE_argumentList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(317);
			expr(0);
			setState(322);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__4) {
				{
				{
				setState(318);
				match(T__4);
				setState(319);
				expr(0);
				}
				}
				setState(324);
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PrimaVisitor ) return ((PrimaVisitor<? extends T>)visitor).visitIntLiteral(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IntLiteralContext intLiteral() throws RecognitionException {
		IntLiteralContext _localctx = new IntLiteralContext(_ctx, getState());
		enterRule(_localctx, 68, RULE_intLiteral);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(325);
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PrimaVisitor ) return ((PrimaVisitor<? extends T>)visitor).visitBoolLiteral(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BoolLiteralContext boolLiteral() throws RecognitionException {
		BoolLiteralContext _localctx = new BoolLiteralContext(_ctx, getState());
		enterRule(_localctx, 70, RULE_boolLiteral);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(327);
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

	public static class StringLiteralContext extends ParserRuleContext {
		public TerminalNode STRING() { return getToken(PrimaParser.STRING, 0); }
		public StringLiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stringLiteral; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PrimaListener ) ((PrimaListener)listener).enterStringLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PrimaListener ) ((PrimaListener)listener).exitStringLiteral(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PrimaVisitor ) return ((PrimaVisitor<? extends T>)visitor).visitStringLiteral(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StringLiteralContext stringLiteral() throws RecognitionException {
		StringLiteralContext _localctx = new StringLiteralContext(_ctx, getState());
		enterRule(_localctx, 72, RULE_stringLiteral);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(329);
			match(STRING);
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

	public static class VariableNameContext extends ParserRuleContext {
		public Token name;
		public TerminalNode Identifier() { return getToken(PrimaParser.Identifier, 0); }
		public VariableNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variableName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PrimaListener ) ((PrimaListener)listener).enterVariableName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PrimaListener ) ((PrimaListener)listener).exitVariableName(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PrimaVisitor ) return ((PrimaVisitor<? extends T>)visitor).visitVariableName(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VariableNameContext variableName() throws RecognitionException {
		VariableNameContext _localctx = new VariableNameContext(_ctx, getState());
		enterRule(_localctx, 74, RULE_variableName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(331);
			((VariableNameContext)_localctx).name = match(Identifier);
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
		case 29:
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\63\u0150\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\3\2\3\2\6\2Q\n\2\r\2\16\2"+
		"R\3\3\3\3\3\4\3\4\3\4\3\4\3\5\3\5\3\5\5\5^\n\5\3\5\3\5\3\5\3\5\3\6\3\6"+
		"\3\6\7\6g\n\6\f\6\16\6j\13\6\3\7\3\7\3\7\3\7\3\b\3\b\7\br\n\b\f\b\16\b"+
		"u\13\b\3\b\3\b\3\t\3\t\5\t{\n\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3"+
		"\n\3\n\5\n\u0088\n\n\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3"+
		"\r\6\r\u0096\n\r\r\r\16\r\u0097\3\r\3\r\3\r\3\r\3\16\3\16\3\16\3\16\3"+
		"\16\3\16\3\16\5\16\u00a5\n\16\3\17\3\17\3\17\5\17\u00aa\n\17\3\17\3\17"+
		"\3\17\3\17\5\17\u00b0\n\17\3\17\3\17\3\17\3\20\3\20\5\20\u00b7\n\20\3"+
		"\21\3\21\3\22\3\22\3\22\3\22\3\22\3\22\3\23\3\23\3\23\3\23\3\24\3\24\5"+
		"\24\u00c7\n\24\3\24\3\24\5\24\u00cb\n\24\3\24\3\24\3\24\3\25\3\25\3\25"+
		"\3\25\3\26\3\26\3\26\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27"+
		"\3\27\3\27\3\27\3\27\5\27\u00e5\n\27\3\30\3\30\3\30\3\30\3\30\6\30\u00ec"+
		"\n\30\r\30\16\30\u00ed\3\31\3\31\3\31\3\32\3\32\5\32\u00f5\n\32\3\33\3"+
		"\33\3\34\3\34\3\34\3\35\3\35\6\35\u00fe\n\35\r\35\16\35\u00ff\3\36\3\36"+
		"\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37"+
		"\3\37\3\37\5\37\u0114\n\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37"+
		"\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\7\37\u0128\n\37\f\37\16"+
		"\37\u012b\13\37\3 \3 \3 \3 \3 \6 \u0132\n \r \16 \u0133\3!\3!\3!\3\"\3"+
		"\"\3\"\5\"\u013c\n\"\3\"\3\"\3#\3#\3#\7#\u0143\n#\f#\16#\u0146\13#\3$"+
		"\3$\3%\3%\3&\3&\3\'\3\'\3\'\2\3<(\2\4\6\b\n\f\16\20\22\24\26\30\32\34"+
		"\36 \"$&(*,.\60\62\64\668:<>@BDFHJL\2\b\3\2\22\24\3\2\31\33\3\2\35\36"+
		"\3\2 \"\3\2#&\3\2\'(\2\u0156\2P\3\2\2\2\4T\3\2\2\2\6V\3\2\2\2\bZ\3\2\2"+
		"\2\nc\3\2\2\2\fk\3\2\2\2\16o\3\2\2\2\20z\3\2\2\2\22\u0087\3\2\2\2\24\u0089"+
		"\3\2\2\2\26\u008c\3\2\2\2\30\u0090\3\2\2\2\32\u009d\3\2\2\2\34\u00a6\3"+
		"\2\2\2\36\u00b6\3\2\2\2 \u00b8\3\2\2\2\"\u00ba\3\2\2\2$\u00c0\3\2\2\2"+
		"&\u00c6\3\2\2\2(\u00cf\3\2\2\2*\u00d3\3\2\2\2,\u00e4\3\2\2\2.\u00e6\3"+
		"\2\2\2\60\u00ef\3\2\2\2\62\u00f4\3\2\2\2\64\u00f6\3\2\2\2\66\u00f8\3\2"+
		"\2\28\u00fd\3\2\2\2:\u0101\3\2\2\2<\u0113\3\2\2\2>\u012c\3\2\2\2@\u0135"+
		"\3\2\2\2B\u0138\3\2\2\2D\u013f\3\2\2\2F\u0147\3\2\2\2H\u0149\3\2\2\2J"+
		"\u014b\3\2\2\2L\u014d\3\2\2\2NQ\5\4\3\2OQ\5\6\4\2PN\3\2\2\2PO\3\2\2\2"+
		"QR\3\2\2\2RP\3\2\2\2RS\3\2\2\2S\3\3\2\2\2TU\5*\26\2U\5\3\2\2\2VW\7\3\2"+
		"\2WX\5\b\5\2XY\5\16\b\2Y\7\3\2\2\2Z[\7/\2\2[]\7\4\2\2\\^\5\n\6\2]\\\3"+
		"\2\2\2]^\3\2\2\2^_\3\2\2\2_`\7\5\2\2`a\7\6\2\2ab\5\20\t\2b\t\3\2\2\2c"+
		"h\5\f\7\2de\7\7\2\2eg\5\f\7\2fd\3\2\2\2gj\3\2\2\2hf\3\2\2\2hi\3\2\2\2"+
		"i\13\3\2\2\2jh\3\2\2\2kl\7/\2\2lm\7\6\2\2mn\5\62\32\2n\r\3\2\2\2os\7\b"+
		"\2\2pr\5\22\n\2qp\3\2\2\2ru\3\2\2\2sq\3\2\2\2st\3\2\2\2tv\3\2\2\2us\3"+
		"\2\2\2vw\7\t\2\2w\17\3\2\2\2x{\5\62\32\2y{\5:\36\2zx\3\2\2\2zy\3\2\2\2"+
		"{\21\3\2\2\2|\u0088\5\60\31\2}\u0088\5\16\b\2~\u0088\5*\26\2\177\u0088"+
		"\5\30\r\2\u0080\u0088\5\24\13\2\u0081\u0088\5\32\16\2\u0082\u0088\5\""+
		"\22\2\u0083\u0088\5\34\17\2\u0084\u0088\5&\24\2\u0085\u0088\5(\25\2\u0086"+
		"\u0088\5@!\2\u0087|\3\2\2\2\u0087}\3\2\2\2\u0087~\3\2\2\2\u0087\177\3"+
		"\2\2\2\u0087\u0080\3\2\2\2\u0087\u0081\3\2\2\2\u0087\u0082\3\2\2\2\u0087"+
		"\u0083\3\2\2\2\u0087\u0084\3\2\2\2\u0087\u0085\3\2\2\2\u0087\u0086\3\2"+
		"\2\2\u0088\23\3\2\2\2\u0089\u008a\5\26\f\2\u008a\u008b\7\n\2\2\u008b\25"+
		"\3\2\2\2\u008c\u008d\7/\2\2\u008d\u008e\7\13\2\2\u008e\u008f\5<\37\2\u008f"+
		"\27\3\2\2\2\u0090\u0095\7/\2\2\u0091\u0092\7\f\2\2\u0092\u0093\5<\37\2"+
		"\u0093\u0094\7\r\2\2\u0094\u0096\3\2\2\2\u0095\u0091\3\2\2\2\u0096\u0097"+
		"\3\2\2\2\u0097\u0095\3\2\2\2\u0097\u0098\3\2\2\2\u0098\u0099\3\2\2\2\u0099"+
		"\u009a\7\13\2\2\u009a\u009b\5<\37\2\u009b\u009c\7\n\2\2\u009c\31\3\2\2"+
		"\2\u009d\u009e\7\16\2\2\u009e\u009f\7\4\2\2\u009f\u00a0\5<\37\2\u00a0"+
		"\u00a1\7\5\2\2\u00a1\u00a4\5\16\b\2\u00a2\u00a3\7\17\2\2\u00a3\u00a5\5"+
		"\16\b\2\u00a4\u00a2\3\2\2\2\u00a4\u00a5\3\2\2\2\u00a5\33\3\2\2\2\u00a6"+
		"\u00a7\7\20\2\2\u00a7\u00a9\7\4\2\2\u00a8\u00aa\5\36\20\2\u00a9\u00a8"+
		"\3\2\2\2\u00a9\u00aa\3\2\2\2\u00aa\u00ab\3\2\2\2\u00ab\u00ac\7\n\2\2\u00ac"+
		"\u00ad\5<\37\2\u00ad\u00af\7\n\2\2\u00ae\u00b0\5 \21\2\u00af\u00ae\3\2"+
		"\2\2\u00af\u00b0\3\2\2\2\u00b0\u00b1\3\2\2\2\u00b1\u00b2\7\5\2\2\u00b2"+
		"\u00b3\5\16\b\2\u00b3\35\3\2\2\2\u00b4\u00b7\5\26\f\2\u00b5\u00b7\5,\27"+
		"\2\u00b6\u00b4\3\2\2\2\u00b6\u00b5\3\2\2\2\u00b7\37\3\2\2\2\u00b8\u00b9"+
		"\5\26\f\2\u00b9!\3\2\2\2\u00ba\u00bb\7\21\2\2\u00bb\u00bc\7\4\2\2\u00bc"+
		"\u00bd\5<\37\2\u00bd\u00be\7\5\2\2\u00be\u00bf\5\16\b\2\u00bf#\3\2\2\2"+
		"\u00c0\u00c1\t\2\2\2\u00c1\u00c2\7\4\2\2\u00c2\u00c3\7\5\2\2\u00c3%\3"+
		"\2\2\2\u00c4\u00c7\7\25\2\2\u00c5\u00c7\7\26\2\2\u00c6\u00c4\3\2\2\2\u00c6"+
		"\u00c5\3\2\2\2\u00c7\u00c8\3\2\2\2\u00c8\u00ca\7\4\2\2\u00c9\u00cb\5<"+
		"\37\2\u00ca\u00c9\3\2\2\2\u00ca\u00cb\3\2\2\2\u00cb\u00cc\3\2\2\2\u00cc"+
		"\u00cd\7\5\2\2\u00cd\u00ce\7\n\2\2\u00ce\'\3\2\2\2\u00cf\u00d0\7\27\2"+
		"\2\u00d0\u00d1\5<\37\2\u00d1\u00d2\7\n\2\2\u00d2)\3\2\2\2\u00d3\u00d4"+
		"\5,\27\2\u00d4\u00d5\7\n\2\2\u00d5+\3\2\2\2\u00d6\u00d7\7\30\2\2\u00d7"+
		"\u00d8\7/\2\2\u00d8\u00d9\7\6\2\2\u00d9\u00da\5\66\34\2\u00da\u00db\7"+
		"\13\2\2\u00db\u00dc\5.\30\2\u00dc\u00e5\3\2\2\2\u00dd\u00de\7\30\2\2\u00de"+
		"\u00df\7/\2\2\u00df\u00e0\7\6\2\2\u00e0\u00e1\5\64\33\2\u00e1\u00e2\7"+
		"\13\2\2\u00e2\u00e3\5<\37\2\u00e3\u00e5\3\2\2\2\u00e4\u00d6\3\2\2\2\u00e4"+
		"\u00dd\3\2\2\2\u00e5-\3\2\2\2\u00e6\u00eb\5\64\33\2\u00e7\u00e8\7\f\2"+
		"\2\u00e8\u00e9\5<\37\2\u00e9\u00ea\7\r\2\2\u00ea\u00ec\3\2\2\2\u00eb\u00e7"+
		"\3\2\2\2\u00ec\u00ed\3\2\2\2\u00ed\u00eb\3\2\2\2\u00ed\u00ee\3\2\2\2\u00ee"+
		"/\3\2\2\2\u00ef\u00f0\7+\2\2\u00f0\u00f1\7\n\2\2\u00f1\61\3\2\2\2\u00f2"+
		"\u00f5\5\64\33\2\u00f3\u00f5\5\66\34\2\u00f4\u00f2\3\2\2\2\u00f4\u00f3"+
		"\3\2\2\2\u00f5\63\3\2\2\2\u00f6\u00f7\t\3\2\2\u00f7\65\3\2\2\2\u00f8\u00f9"+
		"\5\64\33\2\u00f9\u00fa\58\35\2\u00fa\67\3\2\2\2\u00fb\u00fc\7\f\2\2\u00fc"+
		"\u00fe\7\r\2\2\u00fd\u00fb\3\2\2\2\u00fe\u00ff\3\2\2\2\u00ff\u00fd\3\2"+
		"\2\2\u00ff\u0100\3\2\2\2\u01009\3\2\2\2\u0101\u0102\7\34\2\2\u0102;\3"+
		"\2\2\2\u0103\u0104\b\37\1\2\u0104\u0105\7\4\2\2\u0105\u0106\5<\37\2\u0106"+
		"\u0107\7\5\2\2\u0107\u0114\3\2\2\2\u0108\u0114\5F$\2\u0109\u0114\5H%\2"+
		"\u010a\u0114\5J&\2\u010b\u0114\5L\'\2\u010c\u0114\5> \2\u010d\u010e\t"+
		"\4\2\2\u010e\u0114\5<\37\f\u010f\u0110\7\37\2\2\u0110\u0114\5<\37\13\u0111"+
		"\u0114\5$\23\2\u0112\u0114\5B\"\2\u0113\u0103\3\2\2\2\u0113\u0108\3\2"+
		"\2\2\u0113\u0109\3\2\2\2\u0113\u010a\3\2\2\2\u0113\u010b\3\2\2\2\u0113"+
		"\u010c\3\2\2\2\u0113\u010d\3\2\2\2\u0113\u010f\3\2\2\2\u0113\u0111\3\2"+
		"\2\2\u0113\u0112\3\2\2\2\u0114\u0129\3\2\2\2\u0115\u0116\f\n\2\2\u0116"+
		"\u0117\t\5\2\2\u0117\u0128\5<\37\13\u0118\u0119\f\t\2\2\u0119\u011a\t"+
		"\4\2\2\u011a\u0128\5<\37\n\u011b\u011c\f\b\2\2\u011c\u011d\t\6\2\2\u011d"+
		"\u0128\5<\37\t\u011e\u011f\f\7\2\2\u011f\u0120\t\7\2\2\u0120\u0128\5<"+
		"\37\b\u0121\u0122\f\6\2\2\u0122\u0123\7)\2\2\u0123\u0128\5<\37\7\u0124"+
		"\u0125\f\5\2\2\u0125\u0126\7*\2\2\u0126\u0128\5<\37\6\u0127\u0115\3\2"+
		"\2\2\u0127\u0118\3\2\2\2\u0127\u011b\3\2\2\2\u0127\u011e\3\2\2\2\u0127"+
		"\u0121\3\2\2\2\u0127\u0124\3\2\2\2\u0128\u012b\3\2\2\2\u0129\u0127\3\2"+
		"\2\2\u0129\u012a\3\2\2\2\u012a=\3\2\2\2\u012b\u0129\3\2\2\2\u012c\u0131"+
		"\7/\2\2\u012d\u012e\7\f\2\2\u012e\u012f\5<\37\2\u012f\u0130\7\r\2\2\u0130"+
		"\u0132\3\2\2\2\u0131\u012d\3\2\2\2\u0132\u0133\3\2\2\2\u0133\u0131\3\2"+
		"\2\2\u0133\u0134\3\2\2\2\u0134?\3\2\2\2\u0135\u0136\5B\"\2\u0136\u0137"+
		"\7\n\2\2\u0137A\3\2\2\2\u0138\u0139\7/\2\2\u0139\u013b\7\4\2\2\u013a\u013c"+
		"\5D#\2\u013b\u013a\3\2\2\2\u013b\u013c\3\2\2\2\u013c\u013d\3\2\2\2\u013d"+
		"\u013e\7\5\2\2\u013eC\3\2\2\2\u013f\u0144\5<\37\2\u0140\u0141\7\7\2\2"+
		"\u0141\u0143\5<\37\2\u0142\u0140\3\2\2\2\u0143\u0146\3\2\2\2\u0144\u0142"+
		"\3\2\2\2\u0144\u0145\3\2\2\2\u0145E\3\2\2\2\u0146\u0144\3\2\2\2\u0147"+
		"\u0148\7-\2\2\u0148G\3\2\2\2\u0149\u014a\7,\2\2\u014aI\3\2\2\2\u014b\u014c"+
		"\7.\2\2\u014cK\3\2\2\2\u014d\u014e\7/\2\2\u014eM\3\2\2\2\32PR]hsz\u0087"+
		"\u0097\u00a4\u00a9\u00af\u00b6\u00c6\u00ca\u00e4\u00ed\u00f4\u00ff\u0113"+
		"\u0127\u0129\u0133\u013b\u0144";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}