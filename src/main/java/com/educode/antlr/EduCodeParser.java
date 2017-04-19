// Generated from C:/Users/User/Desktop/EduCode-P4/src\EduCode.g4 by ANTLR 4.6
package com.educode.antlr;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class EduCodeParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.6", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, T__23=24, 
		T__24=25, T__25=26, T__26=27, T__27=28, T__28=29, T__29=30, T__30=31, 
		T__31=32, T__32=33, TRUE=34, FALSE=35, ADDOP=36, MULTOP=37, ANDOP=38, 
		OROP=39, ULOP=40, RELOP=41, EQUALOP=42, NEWLINE=43, NUMLIT=44, STRLIT=45, 
		USTRLIT=46, IDENT=47, LPAREN=48, RPAREN=49, WHITESPACE=50, LINECOMMENT=51;
	public static final int
		RULE_program = 0, RULE_methods = 1, RULE_method = 2, RULE_methodC = 3, 
		RULE_args = 4, RULE_params = 5, RULE_param = 6, RULE_stmts = 7, RULE_stmt = 8, 
		RULE_ret = 9, RULE_loopStmt = 10, RULE_ifStmt = 11, RULE_iterStmt = 12, 
		RULE_varDcl = 13, RULE_assign = 14, RULE_expr = 15, RULE_logicExpr = 16, 
		RULE_orExpr = 17, RULE_andExpr = 18, RULE_eqlExpr = 19, RULE_relExpr = 20, 
		RULE_boolLit = 21, RULE_arithExpr = 22, RULE_term = 23, RULE_factor = 24, 
		RULE_dataType = 25, RULE_literal = 26, RULE_stringLit = 27, RULE_coordLit = 28, 
		RULE_numberLit = 29, RULE_eol = 30, RULE_reference = 31, RULE_ident = 32;
	public static final String[] ruleNames = {
		"program", "methods", "method", "methodC", "args", "params", "param", 
		"stmts", "stmt", "ret", "loopStmt", "ifStmt", "iterStmt", "varDcl", "assign", 
		"expr", "logicExpr", "orExpr", "andExpr", "eqlExpr", "relExpr", "boolLit", 
		"arithExpr", "term", "factor", "dataType", "literal", "stringLit", "coordLit", 
		"numberLit", "eol", "reference", "ident"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'program'", "'end program'", "'method'", "'returns'", "'end method'", 
		"'.'", "','", "'return'", "'repeat while'", "'end repeat'", "'if'", "'then'", 
		"'else if'", "'else'", "'end if'", "'foreach'", "'in'", "'end foreach'", 
		"'='", "'new'", "'number'", "'bool'", "'Coordinates'", "'string'", "'Collection'", 
		"'<'", "'>'", "'Block'", "'Entity'", "'Item'", "'Texture'", "'['", "']'", 
		"'true'", "'false'", null, null, "'and'", "'or'", "'not'", null, null, 
		null, null, null, null, null, "'('", "')'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, "TRUE", "FALSE", 
		"ADDOP", "MULTOP", "ANDOP", "OROP", "ULOP", "RELOP", "EQUALOP", "NEWLINE", 
		"NUMLIT", "STRLIT", "USTRLIT", "IDENT", "LPAREN", "RPAREN", "WHITESPACE", 
		"LINECOMMENT"
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
	public String getGrammarFileName() { return "EduCode.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public EduCodeParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class ProgramContext extends ParserRuleContext {
		public IdentContext ident() {
			return getRuleContext(IdentContext.class,0);
		}
		public MethodsContext methods() {
			return getRuleContext(MethodsContext.class,0);
		}
		public List<EolContext> eol() {
			return getRuleContexts(EolContext.class);
		}
		public EolContext eol(int i) {
			return getRuleContext(EolContext.class,i);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EduCodeVisitor ) return ((EduCodeVisitor<? extends T>)visitor).visitProgram(this);
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
			setState(66);
			match(T__0);
			setState(67);
			ident();
			setState(69); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(68);
				eol();
				}
				}
				setState(71); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==NEWLINE );
			setState(73);
			methods();
			setState(74);
			match(T__1);
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

	public static class MethodsContext extends ParserRuleContext {
		public List<MethodContext> method() {
			return getRuleContexts(MethodContext.class);
		}
		public MethodContext method(int i) {
			return getRuleContext(MethodContext.class,i);
		}
		public List<EolContext> eol() {
			return getRuleContexts(EolContext.class);
		}
		public EolContext eol(int i) {
			return getRuleContext(EolContext.class,i);
		}
		public MethodsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_methods; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EduCodeVisitor ) return ((EduCodeVisitor<? extends T>)visitor).visitMethods(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MethodsContext methods() throws RecognitionException {
		MethodsContext _localctx = new MethodsContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_methods);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(84);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__2) {
				{
				{
				setState(76);
				method();
				setState(78); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(77);
					eol();
					}
					}
					setState(80); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==NEWLINE );
				}
				}
				setState(86);
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

	public static class MethodContext extends ParserRuleContext {
		public IdentContext ident() {
			return getRuleContext(IdentContext.class,0);
		}
		public TerminalNode LPAREN() { return getToken(EduCodeParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(EduCodeParser.RPAREN, 0); }
		public StmtsContext stmts() {
			return getRuleContext(StmtsContext.class,0);
		}
		public ParamsContext params() {
			return getRuleContext(ParamsContext.class,0);
		}
		public DataTypeContext dataType() {
			return getRuleContext(DataTypeContext.class,0);
		}
		public List<EolContext> eol() {
			return getRuleContexts(EolContext.class);
		}
		public EolContext eol(int i) {
			return getRuleContext(EolContext.class,i);
		}
		public MethodContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_method; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EduCodeVisitor ) return ((EduCodeVisitor<? extends T>)visitor).visitMethod(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MethodContext method() throws RecognitionException {
		MethodContext _localctx = new MethodContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_method);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(87);
			match(T__2);
			setState(88);
			ident();
			setState(89);
			match(LPAREN);
			setState(91);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__20) | (1L << T__21) | (1L << T__22) | (1L << T__23) | (1L << T__24) | (1L << T__27) | (1L << T__28) | (1L << T__29) | (1L << T__30))) != 0)) {
				{
				setState(90);
				params();
				}
			}

			setState(93);
			match(RPAREN);
			setState(96);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__3) {
				{
				setState(94);
				match(T__3);
				setState(95);
				dataType();
				}
			}

			setState(99); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(98);
				eol();
				}
				}
				setState(101); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==NEWLINE );
			setState(103);
			stmts();
			setState(104);
			match(T__4);
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

	public static class MethodCContext extends ParserRuleContext {
		public ReferenceContext reference() {
			return getRuleContext(ReferenceContext.class,0);
		}
		public TerminalNode LPAREN() { return getToken(EduCodeParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(EduCodeParser.RPAREN, 0); }
		public ArgsContext args() {
			return getRuleContext(ArgsContext.class,0);
		}
		public List<MethodCContext> methodC() {
			return getRuleContexts(MethodCContext.class);
		}
		public MethodCContext methodC(int i) {
			return getRuleContext(MethodCContext.class,i);
		}
		public MethodCContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_methodC; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EduCodeVisitor ) return ((EduCodeVisitor<? extends T>)visitor).visitMethodC(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MethodCContext methodC() throws RecognitionException {
		return methodC(0);
	}

	private MethodCContext methodC(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		MethodCContext _localctx = new MethodCContext(_ctx, _parentState);
		MethodCContext _prevctx = _localctx;
		int _startState = 6;
		enterRecursionRule(_localctx, 6, RULE_methodC, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(107);
			reference(0);
			setState(108);
			match(LPAREN);
			setState(110);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << TRUE) | (1L << FALSE) | (1L << ULOP) | (1L << NUMLIT) | (1L << STRLIT) | (1L << IDENT) | (1L << LPAREN))) != 0)) {
				{
				setState(109);
				args();
				}
			}

			setState(112);
			match(RPAREN);
			}
			_ctx.stop = _input.LT(-1);
			setState(119);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new MethodCContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_methodC);
					setState(114);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(115);
					match(T__5);
					setState(116);
					methodC(2);
					}
					} 
				}
				setState(121);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
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

	public static class ArgsContext extends ParserRuleContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public ArgsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_args; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EduCodeVisitor ) return ((EduCodeVisitor<? extends T>)visitor).visitArgs(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArgsContext args() throws RecognitionException {
		ArgsContext _localctx = new ArgsContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_args);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(122);
			expr();
			setState(127);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__6) {
				{
				{
				setState(123);
				match(T__6);
				setState(124);
				expr();
				}
				}
				setState(129);
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

	public static class ParamsContext extends ParserRuleContext {
		public List<ParamContext> param() {
			return getRuleContexts(ParamContext.class);
		}
		public ParamContext param(int i) {
			return getRuleContext(ParamContext.class,i);
		}
		public ParamsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_params; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EduCodeVisitor ) return ((EduCodeVisitor<? extends T>)visitor).visitParams(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParamsContext params() throws RecognitionException {
		ParamsContext _localctx = new ParamsContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_params);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(130);
			param();
			setState(135);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__6) {
				{
				{
				setState(131);
				match(T__6);
				setState(132);
				param();
				}
				}
				setState(137);
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

	public static class ParamContext extends ParserRuleContext {
		public DataTypeContext dataType() {
			return getRuleContext(DataTypeContext.class,0);
		}
		public IdentContext ident() {
			return getRuleContext(IdentContext.class,0);
		}
		public ParamContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_param; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EduCodeVisitor ) return ((EduCodeVisitor<? extends T>)visitor).visitParam(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParamContext param() throws RecognitionException {
		ParamContext _localctx = new ParamContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_param);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(138);
			dataType();
			setState(139);
			ident();
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

	public static class StmtsContext extends ParserRuleContext {
		public List<StmtContext> stmt() {
			return getRuleContexts(StmtContext.class);
		}
		public StmtContext stmt(int i) {
			return getRuleContext(StmtContext.class,i);
		}
		public List<EolContext> eol() {
			return getRuleContexts(EolContext.class);
		}
		public EolContext eol(int i) {
			return getRuleContext(EolContext.class,i);
		}
		public StmtsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stmts; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EduCodeVisitor ) return ((EduCodeVisitor<? extends T>)visitor).visitStmts(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StmtsContext stmts() throws RecognitionException {
		StmtsContext _localctx = new StmtsContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_stmts);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(149);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__7) | (1L << T__8) | (1L << T__10) | (1L << T__15) | (1L << T__20) | (1L << T__21) | (1L << T__22) | (1L << T__23) | (1L << T__24) | (1L << T__27) | (1L << T__28) | (1L << T__29) | (1L << T__30) | (1L << IDENT))) != 0)) {
				{
				{
				setState(141);
				stmt();
				setState(143); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(142);
					eol();
					}
					}
					setState(145); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==NEWLINE );
				}
				}
				setState(151);
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

	public static class StmtContext extends ParserRuleContext {
		public MethodCContext methodC() {
			return getRuleContext(MethodCContext.class,0);
		}
		public AssignContext assign() {
			return getRuleContext(AssignContext.class,0);
		}
		public VarDclContext varDcl() {
			return getRuleContext(VarDclContext.class,0);
		}
		public IfStmtContext ifStmt() {
			return getRuleContext(IfStmtContext.class,0);
		}
		public LoopStmtContext loopStmt() {
			return getRuleContext(LoopStmtContext.class,0);
		}
		public IterStmtContext iterStmt() {
			return getRuleContext(IterStmtContext.class,0);
		}
		public RetContext ret() {
			return getRuleContext(RetContext.class,0);
		}
		public StmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stmt; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EduCodeVisitor ) return ((EduCodeVisitor<? extends T>)visitor).visitStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StmtContext stmt() throws RecognitionException {
		StmtContext _localctx = new StmtContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_stmt);
		try {
			setState(159);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(152);
				methodC(0);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(153);
				assign();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(154);
				varDcl();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(155);
				ifStmt();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(156);
				loopStmt();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(157);
				iterStmt();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(158);
				ret();
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

	public static class RetContext extends ParserRuleContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public RetContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ret; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EduCodeVisitor ) return ((EduCodeVisitor<? extends T>)visitor).visitRet(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RetContext ret() throws RecognitionException {
		RetContext _localctx = new RetContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_ret);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(161);
			match(T__7);
			setState(163);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << TRUE) | (1L << FALSE) | (1L << ULOP) | (1L << NUMLIT) | (1L << STRLIT) | (1L << IDENT) | (1L << LPAREN))) != 0)) {
				{
				setState(162);
				expr();
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

	public static class LoopStmtContext extends ParserRuleContext {
		public LogicExprContext logicExpr() {
			return getRuleContext(LogicExprContext.class,0);
		}
		public StmtsContext stmts() {
			return getRuleContext(StmtsContext.class,0);
		}
		public List<EolContext> eol() {
			return getRuleContexts(EolContext.class);
		}
		public EolContext eol(int i) {
			return getRuleContext(EolContext.class,i);
		}
		public LoopStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_loopStmt; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EduCodeVisitor ) return ((EduCodeVisitor<? extends T>)visitor).visitLoopStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LoopStmtContext loopStmt() throws RecognitionException {
		LoopStmtContext _localctx = new LoopStmtContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_loopStmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(165);
			match(T__8);
			setState(166);
			logicExpr();
			setState(168); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(167);
				eol();
				}
				}
				setState(170); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==NEWLINE );
			setState(172);
			stmts();
			setState(173);
			match(T__9);
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

	public static class IfStmtContext extends ParserRuleContext {
		public List<LogicExprContext> logicExpr() {
			return getRuleContexts(LogicExprContext.class);
		}
		public LogicExprContext logicExpr(int i) {
			return getRuleContext(LogicExprContext.class,i);
		}
		public List<StmtsContext> stmts() {
			return getRuleContexts(StmtsContext.class);
		}
		public StmtsContext stmts(int i) {
			return getRuleContext(StmtsContext.class,i);
		}
		public List<EolContext> eol() {
			return getRuleContexts(EolContext.class);
		}
		public EolContext eol(int i) {
			return getRuleContext(EolContext.class,i);
		}
		public IfStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ifStmt; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EduCodeVisitor ) return ((EduCodeVisitor<? extends T>)visitor).visitIfStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IfStmtContext ifStmt() throws RecognitionException {
		IfStmtContext _localctx = new IfStmtContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_ifStmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(175);
			match(T__10);
			setState(176);
			logicExpr();
			setState(177);
			match(T__11);
			setState(179); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(178);
				eol();
				}
				}
				setState(181); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==NEWLINE );
			setState(183);
			stmts();
			setState(196);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__12) {
				{
				{
				setState(184);
				match(T__12);
				setState(185);
				logicExpr();
				setState(186);
				match(T__11);
				setState(188); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(187);
					eol();
					}
					}
					setState(190); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==NEWLINE );
				setState(192);
				stmts();
				}
				}
				setState(198);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(207);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__13) {
				{
				setState(199);
				match(T__13);
				setState(201); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(200);
					eol();
					}
					}
					setState(203); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==NEWLINE );
				setState(205);
				stmts();
				}
			}

			setState(209);
			match(T__14);
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

	public static class IterStmtContext extends ParserRuleContext {
		public DataTypeContext dataType() {
			return getRuleContext(DataTypeContext.class,0);
		}
		public IdentContext ident() {
			return getRuleContext(IdentContext.class,0);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public StmtsContext stmts() {
			return getRuleContext(StmtsContext.class,0);
		}
		public List<EolContext> eol() {
			return getRuleContexts(EolContext.class);
		}
		public EolContext eol(int i) {
			return getRuleContext(EolContext.class,i);
		}
		public IterStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_iterStmt; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EduCodeVisitor ) return ((EduCodeVisitor<? extends T>)visitor).visitIterStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IterStmtContext iterStmt() throws RecognitionException {
		IterStmtContext _localctx = new IterStmtContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_iterStmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(211);
			match(T__15);
			setState(212);
			dataType();
			setState(213);
			ident();
			setState(214);
			match(T__16);
			setState(215);
			expr();
			setState(217); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(216);
				eol();
				}
				}
				setState(219); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==NEWLINE );
			setState(221);
			stmts();
			setState(222);
			match(T__17);
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

	public static class VarDclContext extends ParserRuleContext {
		public DataTypeContext dataType() {
			return getRuleContext(DataTypeContext.class,0);
		}
		public List<IdentContext> ident() {
			return getRuleContexts(IdentContext.class);
		}
		public IdentContext ident(int i) {
			return getRuleContext(IdentContext.class,i);
		}
		public List<AssignContext> assign() {
			return getRuleContexts(AssignContext.class);
		}
		public AssignContext assign(int i) {
			return getRuleContext(AssignContext.class,i);
		}
		public VarDclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_varDcl; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EduCodeVisitor ) return ((EduCodeVisitor<? extends T>)visitor).visitVarDcl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VarDclContext varDcl() throws RecognitionException {
		VarDclContext _localctx = new VarDclContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_varDcl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(224);
			dataType();
			setState(227);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,21,_ctx) ) {
			case 1:
				{
				setState(225);
				ident();
				}
				break;
			case 2:
				{
				setState(226);
				assign();
				}
				break;
			}
			setState(236);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__6) {
				{
				{
				setState(229);
				match(T__6);
				setState(232);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,22,_ctx) ) {
				case 1:
					{
					setState(230);
					ident();
					}
					break;
				case 2:
					{
					setState(231);
					assign();
					}
					break;
				}
				}
				}
				setState(238);
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

	public static class AssignContext extends ParserRuleContext {
		public ReferenceContext reference() {
			return getRuleContext(ReferenceContext.class,0);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public DataTypeContext dataType() {
			return getRuleContext(DataTypeContext.class,0);
		}
		public TerminalNode LPAREN() { return getToken(EduCodeParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(EduCodeParser.RPAREN, 0); }
		public ArgsContext args() {
			return getRuleContext(ArgsContext.class,0);
		}
		public AssignContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assign; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EduCodeVisitor ) return ((EduCodeVisitor<? extends T>)visitor).visitAssign(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AssignContext assign() throws RecognitionException {
		AssignContext _localctx = new AssignContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_assign);
		int _la;
		try {
			setState(253);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,25,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(239);
				reference(0);
				setState(240);
				match(T__18);
				setState(241);
				expr();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(243);
				reference(0);
				setState(244);
				match(T__18);
				setState(245);
				match(T__19);
				setState(246);
				dataType();
				setState(247);
				match(LPAREN);
				setState(249);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << TRUE) | (1L << FALSE) | (1L << ULOP) | (1L << NUMLIT) | (1L << STRLIT) | (1L << IDENT) | (1L << LPAREN))) != 0)) {
					{
					setState(248);
					args();
					}
				}

				setState(251);
				match(RPAREN);
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

	public static class ExprContext extends ParserRuleContext {
		public AssignContext assign() {
			return getRuleContext(AssignContext.class,0);
		}
		public LogicExprContext logicExpr() {
			return getRuleContext(LogicExprContext.class,0);
		}
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EduCodeVisitor ) return ((EduCodeVisitor<? extends T>)visitor).visitExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		ExprContext _localctx = new ExprContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_expr);
		try {
			setState(257);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,26,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(255);
				assign();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(256);
				logicExpr();
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

	public static class LogicExprContext extends ParserRuleContext {
		public OrExprContext orExpr() {
			return getRuleContext(OrExprContext.class,0);
		}
		public LogicExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_logicExpr; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EduCodeVisitor ) return ((EduCodeVisitor<? extends T>)visitor).visitLogicExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LogicExprContext logicExpr() throws RecognitionException {
		LogicExprContext _localctx = new LogicExprContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_logicExpr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(259);
			orExpr(0);
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

	public static class OrExprContext extends ParserRuleContext {
		public AndExprContext andExpr() {
			return getRuleContext(AndExprContext.class,0);
		}
		public OrExprContext orExpr() {
			return getRuleContext(OrExprContext.class,0);
		}
		public TerminalNode OROP() { return getToken(EduCodeParser.OROP, 0); }
		public OrExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_orExpr; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EduCodeVisitor ) return ((EduCodeVisitor<? extends T>)visitor).visitOrExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OrExprContext orExpr() throws RecognitionException {
		return orExpr(0);
	}

	private OrExprContext orExpr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		OrExprContext _localctx = new OrExprContext(_ctx, _parentState);
		OrExprContext _prevctx = _localctx;
		int _startState = 34;
		enterRecursionRule(_localctx, 34, RULE_orExpr, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(262);
			andExpr(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(269);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,27,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new OrExprContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_orExpr);
					setState(264);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(265);
					match(OROP);
					setState(266);
					andExpr(0);
					}
					} 
				}
				setState(271);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,27,_ctx);
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

	public static class AndExprContext extends ParserRuleContext {
		public EqlExprContext eqlExpr() {
			return getRuleContext(EqlExprContext.class,0);
		}
		public AndExprContext andExpr() {
			return getRuleContext(AndExprContext.class,0);
		}
		public TerminalNode ANDOP() { return getToken(EduCodeParser.ANDOP, 0); }
		public AndExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_andExpr; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EduCodeVisitor ) return ((EduCodeVisitor<? extends T>)visitor).visitAndExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AndExprContext andExpr() throws RecognitionException {
		return andExpr(0);
	}

	private AndExprContext andExpr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		AndExprContext _localctx = new AndExprContext(_ctx, _parentState);
		AndExprContext _prevctx = _localctx;
		int _startState = 36;
		enterRecursionRule(_localctx, 36, RULE_andExpr, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(273);
			eqlExpr();
			}
			_ctx.stop = _input.LT(-1);
			setState(280);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,28,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new AndExprContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_andExpr);
					setState(275);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(276);
					match(ANDOP);
					setState(277);
					eqlExpr();
					}
					} 
				}
				setState(282);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,28,_ctx);
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

	public static class EqlExprContext extends ParserRuleContext {
		public List<RelExprContext> relExpr() {
			return getRuleContexts(RelExprContext.class);
		}
		public RelExprContext relExpr(int i) {
			return getRuleContext(RelExprContext.class,i);
		}
		public TerminalNode EQUALOP() { return getToken(EduCodeParser.EQUALOP, 0); }
		public EqlExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_eqlExpr; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EduCodeVisitor ) return ((EduCodeVisitor<? extends T>)visitor).visitEqlExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EqlExprContext eqlExpr() throws RecognitionException {
		EqlExprContext _localctx = new EqlExprContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_eqlExpr);
		try {
			setState(288);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,29,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(283);
				relExpr();
				setState(284);
				match(EQUALOP);
				setState(285);
				relExpr();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(287);
				relExpr();
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

	public static class RelExprContext extends ParserRuleContext {
		public List<ArithExprContext> arithExpr() {
			return getRuleContexts(ArithExprContext.class);
		}
		public ArithExprContext arithExpr(int i) {
			return getRuleContext(ArithExprContext.class,i);
		}
		public TerminalNode RELOP() { return getToken(EduCodeParser.RELOP, 0); }
		public RelExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_relExpr; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EduCodeVisitor ) return ((EduCodeVisitor<? extends T>)visitor).visitRelExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RelExprContext relExpr() throws RecognitionException {
		RelExprContext _localctx = new RelExprContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_relExpr);
		try {
			setState(295);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,30,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(290);
				arithExpr(0);
				setState(291);
				match(RELOP);
				setState(292);
				arithExpr(0);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(294);
				arithExpr(0);
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

	public static class BoolLitContext extends ParserRuleContext {
		public TerminalNode TRUE() { return getToken(EduCodeParser.TRUE, 0); }
		public TerminalNode FALSE() { return getToken(EduCodeParser.FALSE, 0); }
		public BoolLitContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_boolLit; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EduCodeVisitor ) return ((EduCodeVisitor<? extends T>)visitor).visitBoolLit(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BoolLitContext boolLit() throws RecognitionException {
		BoolLitContext _localctx = new BoolLitContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_boolLit);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(297);
			_la = _input.LA(1);
			if ( !(_la==TRUE || _la==FALSE) ) {
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

	public static class ArithExprContext extends ParserRuleContext {
		public TermContext term() {
			return getRuleContext(TermContext.class,0);
		}
		public ArithExprContext arithExpr() {
			return getRuleContext(ArithExprContext.class,0);
		}
		public TerminalNode ADDOP() { return getToken(EduCodeParser.ADDOP, 0); }
		public ArithExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arithExpr; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EduCodeVisitor ) return ((EduCodeVisitor<? extends T>)visitor).visitArithExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArithExprContext arithExpr() throws RecognitionException {
		return arithExpr(0);
	}

	private ArithExprContext arithExpr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ArithExprContext _localctx = new ArithExprContext(_ctx, _parentState);
		ArithExprContext _prevctx = _localctx;
		int _startState = 44;
		enterRecursionRule(_localctx, 44, RULE_arithExpr, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(300);
			term(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(307);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,31,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new ArithExprContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_arithExpr);
					setState(302);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(303);
					match(ADDOP);
					setState(304);
					term(0);
					}
					} 
				}
				setState(309);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,31,_ctx);
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

	public static class TermContext extends ParserRuleContext {
		public FactorContext factor() {
			return getRuleContext(FactorContext.class,0);
		}
		public TermContext term() {
			return getRuleContext(TermContext.class,0);
		}
		public TerminalNode MULTOP() { return getToken(EduCodeParser.MULTOP, 0); }
		public TermContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_term; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EduCodeVisitor ) return ((EduCodeVisitor<? extends T>)visitor).visitTerm(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TermContext term() throws RecognitionException {
		return term(0);
	}

	private TermContext term(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		TermContext _localctx = new TermContext(_ctx, _parentState);
		TermContext _prevctx = _localctx;
		int _startState = 46;
		enterRecursionRule(_localctx, 46, RULE_term, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(311);
			factor();
			}
			_ctx.stop = _input.LT(-1);
			setState(318);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,32,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new TermContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_term);
					setState(313);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(314);
					match(MULTOP);
					setState(315);
					factor();
					}
					} 
				}
				setState(320);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,32,_ctx);
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

	public static class FactorContext extends ParserRuleContext {
		public LiteralContext literal() {
			return getRuleContext(LiteralContext.class,0);
		}
		public BoolLitContext boolLit() {
			return getRuleContext(BoolLitContext.class,0);
		}
		public MethodCContext methodC() {
			return getRuleContext(MethodCContext.class,0);
		}
		public TerminalNode LPAREN() { return getToken(EduCodeParser.LPAREN, 0); }
		public LogicExprContext logicExpr() {
			return getRuleContext(LogicExprContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(EduCodeParser.RPAREN, 0); }
		public TerminalNode ULOP() { return getToken(EduCodeParser.ULOP, 0); }
		public FactorContext factor() {
			return getRuleContext(FactorContext.class,0);
		}
		public DataTypeContext dataType() {
			return getRuleContext(DataTypeContext.class,0);
		}
		public FactorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_factor; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EduCodeVisitor ) return ((EduCodeVisitor<? extends T>)visitor).visitFactor(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FactorContext factor() throws RecognitionException {
		FactorContext _localctx = new FactorContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_factor);
		try {
			setState(335);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,33,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(321);
				literal();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(322);
				boolLit();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(323);
				methodC(0);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(324);
				match(LPAREN);
				setState(325);
				logicExpr();
				setState(326);
				match(RPAREN);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(328);
				match(ULOP);
				setState(329);
				factor();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(330);
				match(LPAREN);
				setState(331);
				dataType();
				setState(332);
				match(RPAREN);
				setState(333);
				factor();
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

	public static class DataTypeContext extends ParserRuleContext {
		public DataTypeContext dataType() {
			return getRuleContext(DataTypeContext.class,0);
		}
		public DataTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dataType; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EduCodeVisitor ) return ((EduCodeVisitor<? extends T>)visitor).visitDataType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DataTypeContext dataType() throws RecognitionException {
		DataTypeContext _localctx = new DataTypeContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_dataType);
		try {
			setState(350);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__20:
				enterOuterAlt(_localctx, 1);
				{
				setState(337);
				match(T__20);
				}
				break;
			case T__21:
				enterOuterAlt(_localctx, 2);
				{
				setState(338);
				match(T__21);
				}
				break;
			case T__22:
				enterOuterAlt(_localctx, 3);
				{
				setState(339);
				match(T__22);
				}
				break;
			case T__23:
				enterOuterAlt(_localctx, 4);
				{
				setState(340);
				match(T__23);
				}
				break;
			case T__24:
				enterOuterAlt(_localctx, 5);
				{
				setState(341);
				match(T__24);
				setState(342);
				match(T__25);
				setState(343);
				dataType();
				setState(344);
				match(T__26);
				}
				break;
			case T__27:
				enterOuterAlt(_localctx, 6);
				{
				setState(346);
				match(T__27);
				}
				break;
			case T__28:
				enterOuterAlt(_localctx, 7);
				{
				setState(347);
				match(T__28);
				}
				break;
			case T__29:
				enterOuterAlt(_localctx, 8);
				{
				setState(348);
				match(T__29);
				}
				break;
			case T__30:
				enterOuterAlt(_localctx, 9);
				{
				setState(349);
				match(T__30);
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

	public static class LiteralContext extends ParserRuleContext {
		public ReferenceContext reference() {
			return getRuleContext(ReferenceContext.class,0);
		}
		public StringLitContext stringLit() {
			return getRuleContext(StringLitContext.class,0);
		}
		public NumberLitContext numberLit() {
			return getRuleContext(NumberLitContext.class,0);
		}
		public CoordLitContext coordLit() {
			return getRuleContext(CoordLitContext.class,0);
		}
		public LiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_literal; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EduCodeVisitor ) return ((EduCodeVisitor<? extends T>)visitor).visitLiteral(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LiteralContext literal() throws RecognitionException {
		LiteralContext _localctx = new LiteralContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_literal);
		try {
			setState(356);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IDENT:
				enterOuterAlt(_localctx, 1);
				{
				setState(352);
				reference(0);
				}
				break;
			case STRLIT:
				enterOuterAlt(_localctx, 2);
				{
				setState(353);
				stringLit();
				}
				break;
			case NUMLIT:
				enterOuterAlt(_localctx, 3);
				{
				setState(354);
				numberLit();
				}
				break;
			case LPAREN:
				enterOuterAlt(_localctx, 4);
				{
				setState(355);
				coordLit();
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

	public static class StringLitContext extends ParserRuleContext {
		public TerminalNode STRLIT() { return getToken(EduCodeParser.STRLIT, 0); }
		public StringLitContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stringLit; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EduCodeVisitor ) return ((EduCodeVisitor<? extends T>)visitor).visitStringLit(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StringLitContext stringLit() throws RecognitionException {
		StringLitContext _localctx = new StringLitContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_stringLit);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(358);
			match(STRLIT);
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

	public static class CoordLitContext extends ParserRuleContext {
		public TerminalNode LPAREN() { return getToken(EduCodeParser.LPAREN, 0); }
		public List<LogicExprContext> logicExpr() {
			return getRuleContexts(LogicExprContext.class);
		}
		public LogicExprContext logicExpr(int i) {
			return getRuleContext(LogicExprContext.class,i);
		}
		public TerminalNode RPAREN() { return getToken(EduCodeParser.RPAREN, 0); }
		public CoordLitContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_coordLit; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EduCodeVisitor ) return ((EduCodeVisitor<? extends T>)visitor).visitCoordLit(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CoordLitContext coordLit() throws RecognitionException {
		CoordLitContext _localctx = new CoordLitContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_coordLit);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(360);
			match(LPAREN);
			setState(361);
			logicExpr();
			setState(362);
			match(T__6);
			setState(363);
			logicExpr();
			setState(364);
			match(T__6);
			setState(365);
			logicExpr();
			setState(366);
			match(RPAREN);
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

	public static class NumberLitContext extends ParserRuleContext {
		public TerminalNode NUMLIT() { return getToken(EduCodeParser.NUMLIT, 0); }
		public NumberLitContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_numberLit; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EduCodeVisitor ) return ((EduCodeVisitor<? extends T>)visitor).visitNumberLit(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NumberLitContext numberLit() throws RecognitionException {
		NumberLitContext _localctx = new NumberLitContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_numberLit);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(368);
			match(NUMLIT);
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

	public static class EolContext extends ParserRuleContext {
		public TerminalNode NEWLINE() { return getToken(EduCodeParser.NEWLINE, 0); }
		public EolContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_eol; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EduCodeVisitor ) return ((EduCodeVisitor<? extends T>)visitor).visitEol(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EolContext eol() throws RecognitionException {
		EolContext _localctx = new EolContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_eol);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(370);
			match(NEWLINE);
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

	public static class ReferenceContext extends ParserRuleContext {
		public IdentContext ident() {
			return getRuleContext(IdentContext.class,0);
		}
		public List<ReferenceContext> reference() {
			return getRuleContexts(ReferenceContext.class);
		}
		public ReferenceContext reference(int i) {
			return getRuleContext(ReferenceContext.class,i);
		}
		public ArithExprContext arithExpr() {
			return getRuleContext(ArithExprContext.class,0);
		}
		public ReferenceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_reference; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EduCodeVisitor ) return ((EduCodeVisitor<? extends T>)visitor).visitReference(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ReferenceContext reference() throws RecognitionException {
		return reference(0);
	}

	private ReferenceContext reference(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ReferenceContext _localctx = new ReferenceContext(_ctx, _parentState);
		ReferenceContext _prevctx = _localctx;
		int _startState = 62;
		enterRecursionRule(_localctx, 62, RULE_reference, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(373);
			ident();
			}
			_ctx.stop = _input.LT(-1);
			setState(385);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,37,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(383);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,36,_ctx) ) {
					case 1:
						{
						_localctx = new ReferenceContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_reference);
						setState(375);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(376);
						match(T__5);
						setState(377);
						reference(4);
						}
						break;
					case 2:
						{
						_localctx = new ReferenceContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_reference);
						setState(378);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(379);
						match(T__31);
						setState(380);
						arithExpr(0);
						setState(381);
						match(T__32);
						}
						break;
					}
					} 
				}
				setState(387);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,37,_ctx);
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

	public static class IdentContext extends ParserRuleContext {
		public TerminalNode IDENT() { return getToken(EduCodeParser.IDENT, 0); }
		public IdentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ident; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EduCodeVisitor ) return ((EduCodeVisitor<? extends T>)visitor).visitIdent(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IdentContext ident() throws RecognitionException {
		IdentContext _localctx = new IdentContext(_ctx, getState());
		enterRule(_localctx, 64, RULE_ident);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(388);
			match(IDENT);
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
		case 3:
			return methodC_sempred((MethodCContext)_localctx, predIndex);
		case 17:
			return orExpr_sempred((OrExprContext)_localctx, predIndex);
		case 18:
			return andExpr_sempred((AndExprContext)_localctx, predIndex);
		case 22:
			return arithExpr_sempred((ArithExprContext)_localctx, predIndex);
		case 23:
			return term_sempred((TermContext)_localctx, predIndex);
		case 31:
			return reference_sempred((ReferenceContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean methodC_sempred(MethodCContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean orExpr_sempred(OrExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 1:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean andExpr_sempred(AndExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 2:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean arithExpr_sempred(ArithExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 3:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean term_sempred(TermContext _localctx, int predIndex) {
		switch (predIndex) {
		case 4:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean reference_sempred(ReferenceContext _localctx, int predIndex) {
		switch (predIndex) {
		case 5:
			return precpred(_ctx, 3);
		case 6:
			return precpred(_ctx, 2);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\65\u0189\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\3\2\3\2\3\2\6\2H\n\2\r\2\16\2I\3\2\3\2\3\2\3\3\3\3\6\3Q\n"+
		"\3\r\3\16\3R\7\3U\n\3\f\3\16\3X\13\3\3\4\3\4\3\4\3\4\5\4^\n\4\3\4\3\4"+
		"\3\4\5\4c\n\4\3\4\6\4f\n\4\r\4\16\4g\3\4\3\4\3\4\3\5\3\5\3\5\3\5\5\5q"+
		"\n\5\3\5\3\5\3\5\3\5\3\5\7\5x\n\5\f\5\16\5{\13\5\3\6\3\6\3\6\7\6\u0080"+
		"\n\6\f\6\16\6\u0083\13\6\3\7\3\7\3\7\7\7\u0088\n\7\f\7\16\7\u008b\13\7"+
		"\3\b\3\b\3\b\3\t\3\t\6\t\u0092\n\t\r\t\16\t\u0093\7\t\u0096\n\t\f\t\16"+
		"\t\u0099\13\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\5\n\u00a2\n\n\3\13\3\13\5\13"+
		"\u00a6\n\13\3\f\3\f\3\f\6\f\u00ab\n\f\r\f\16\f\u00ac\3\f\3\f\3\f\3\r\3"+
		"\r\3\r\3\r\6\r\u00b6\n\r\r\r\16\r\u00b7\3\r\3\r\3\r\3\r\3\r\6\r\u00bf"+
		"\n\r\r\r\16\r\u00c0\3\r\3\r\7\r\u00c5\n\r\f\r\16\r\u00c8\13\r\3\r\3\r"+
		"\6\r\u00cc\n\r\r\r\16\r\u00cd\3\r\3\r\5\r\u00d2\n\r\3\r\3\r\3\16\3\16"+
		"\3\16\3\16\3\16\3\16\6\16\u00dc\n\16\r\16\16\16\u00dd\3\16\3\16\3\16\3"+
		"\17\3\17\3\17\5\17\u00e6\n\17\3\17\3\17\3\17\5\17\u00eb\n\17\7\17\u00ed"+
		"\n\17\f\17\16\17\u00f0\13\17\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3"+
		"\20\3\20\5\20\u00fc\n\20\3\20\3\20\5\20\u0100\n\20\3\21\3\21\5\21\u0104"+
		"\n\21\3\22\3\22\3\23\3\23\3\23\3\23\3\23\3\23\7\23\u010e\n\23\f\23\16"+
		"\23\u0111\13\23\3\24\3\24\3\24\3\24\3\24\3\24\7\24\u0119\n\24\f\24\16"+
		"\24\u011c\13\24\3\25\3\25\3\25\3\25\3\25\5\25\u0123\n\25\3\26\3\26\3\26"+
		"\3\26\3\26\5\26\u012a\n\26\3\27\3\27\3\30\3\30\3\30\3\30\3\30\3\30\7\30"+
		"\u0134\n\30\f\30\16\30\u0137\13\30\3\31\3\31\3\31\3\31\3\31\3\31\7\31"+
		"\u013f\n\31\f\31\16\31\u0142\13\31\3\32\3\32\3\32\3\32\3\32\3\32\3\32"+
		"\3\32\3\32\3\32\3\32\3\32\3\32\3\32\5\32\u0152\n\32\3\33\3\33\3\33\3\33"+
		"\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\5\33\u0161\n\33\3\34\3\34"+
		"\3\34\3\34\5\34\u0167\n\34\3\35\3\35\3\36\3\36\3\36\3\36\3\36\3\36\3\36"+
		"\3\36\3\37\3\37\3 \3 \3!\3!\3!\3!\3!\3!\3!\3!\3!\3!\3!\7!\u0182\n!\f!"+
		"\16!\u0185\13!\3\"\3\"\3\"\2\b\b$&.\60@#\2\4\6\b\n\f\16\20\22\24\26\30"+
		"\32\34\36 \"$&(*,.\60\62\64\668:<>@B\2\3\3\2$%\u019f\2D\3\2\2\2\4V\3\2"+
		"\2\2\6Y\3\2\2\2\bl\3\2\2\2\n|\3\2\2\2\f\u0084\3\2\2\2\16\u008c\3\2\2\2"+
		"\20\u0097\3\2\2\2\22\u00a1\3\2\2\2\24\u00a3\3\2\2\2\26\u00a7\3\2\2\2\30"+
		"\u00b1\3\2\2\2\32\u00d5\3\2\2\2\34\u00e2\3\2\2\2\36\u00ff\3\2\2\2 \u0103"+
		"\3\2\2\2\"\u0105\3\2\2\2$\u0107\3\2\2\2&\u0112\3\2\2\2(\u0122\3\2\2\2"+
		"*\u0129\3\2\2\2,\u012b\3\2\2\2.\u012d\3\2\2\2\60\u0138\3\2\2\2\62\u0151"+
		"\3\2\2\2\64\u0160\3\2\2\2\66\u0166\3\2\2\28\u0168\3\2\2\2:\u016a\3\2\2"+
		"\2<\u0172\3\2\2\2>\u0174\3\2\2\2@\u0176\3\2\2\2B\u0186\3\2\2\2DE\7\3\2"+
		"\2EG\5B\"\2FH\5> \2GF\3\2\2\2HI\3\2\2\2IG\3\2\2\2IJ\3\2\2\2JK\3\2\2\2"+
		"KL\5\4\3\2LM\7\4\2\2M\3\3\2\2\2NP\5\6\4\2OQ\5> \2PO\3\2\2\2QR\3\2\2\2"+
		"RP\3\2\2\2RS\3\2\2\2SU\3\2\2\2TN\3\2\2\2UX\3\2\2\2VT\3\2\2\2VW\3\2\2\2"+
		"W\5\3\2\2\2XV\3\2\2\2YZ\7\5\2\2Z[\5B\"\2[]\7\62\2\2\\^\5\f\7\2]\\\3\2"+
		"\2\2]^\3\2\2\2^_\3\2\2\2_b\7\63\2\2`a\7\6\2\2ac\5\64\33\2b`\3\2\2\2bc"+
		"\3\2\2\2ce\3\2\2\2df\5> \2ed\3\2\2\2fg\3\2\2\2ge\3\2\2\2gh\3\2\2\2hi\3"+
		"\2\2\2ij\5\20\t\2jk\7\7\2\2k\7\3\2\2\2lm\b\5\1\2mn\5@!\2np\7\62\2\2oq"+
		"\5\n\6\2po\3\2\2\2pq\3\2\2\2qr\3\2\2\2rs\7\63\2\2sy\3\2\2\2tu\f\3\2\2"+
		"uv\7\b\2\2vx\5\b\5\4wt\3\2\2\2x{\3\2\2\2yw\3\2\2\2yz\3\2\2\2z\t\3\2\2"+
		"\2{y\3\2\2\2|\u0081\5 \21\2}~\7\t\2\2~\u0080\5 \21\2\177}\3\2\2\2\u0080"+
		"\u0083\3\2\2\2\u0081\177\3\2\2\2\u0081\u0082\3\2\2\2\u0082\13\3\2\2\2"+
		"\u0083\u0081\3\2\2\2\u0084\u0089\5\16\b\2\u0085\u0086\7\t\2\2\u0086\u0088"+
		"\5\16\b\2\u0087\u0085\3\2\2\2\u0088\u008b\3\2\2\2\u0089\u0087\3\2\2\2"+
		"\u0089\u008a\3\2\2\2\u008a\r\3\2\2\2\u008b\u0089\3\2\2\2\u008c\u008d\5"+
		"\64\33\2\u008d\u008e\5B\"\2\u008e\17\3\2\2\2\u008f\u0091\5\22\n\2\u0090"+
		"\u0092\5> \2\u0091\u0090\3\2\2\2\u0092\u0093\3\2\2\2\u0093\u0091\3\2\2"+
		"\2\u0093\u0094\3\2\2\2\u0094\u0096\3\2\2\2\u0095\u008f\3\2\2\2\u0096\u0099"+
		"\3\2\2\2\u0097\u0095\3\2\2\2\u0097\u0098\3\2\2\2\u0098\21\3\2\2\2\u0099"+
		"\u0097\3\2\2\2\u009a\u00a2\5\b\5\2\u009b\u00a2\5\36\20\2\u009c\u00a2\5"+
		"\34\17\2\u009d\u00a2\5\30\r\2\u009e\u00a2\5\26\f\2\u009f\u00a2\5\32\16"+
		"\2\u00a0\u00a2\5\24\13\2\u00a1\u009a\3\2\2\2\u00a1\u009b\3\2\2\2\u00a1"+
		"\u009c\3\2\2\2\u00a1\u009d\3\2\2\2\u00a1\u009e\3\2\2\2\u00a1\u009f\3\2"+
		"\2\2\u00a1\u00a0\3\2\2\2\u00a2\23\3\2\2\2\u00a3\u00a5\7\n\2\2\u00a4\u00a6"+
		"\5 \21\2\u00a5\u00a4\3\2\2\2\u00a5\u00a6\3\2\2\2\u00a6\25\3\2\2\2\u00a7"+
		"\u00a8\7\13\2\2\u00a8\u00aa\5\"\22\2\u00a9\u00ab\5> \2\u00aa\u00a9\3\2"+
		"\2\2\u00ab\u00ac\3\2\2\2\u00ac\u00aa\3\2\2\2\u00ac\u00ad\3\2\2\2\u00ad"+
		"\u00ae\3\2\2\2\u00ae\u00af\5\20\t\2\u00af\u00b0\7\f\2\2\u00b0\27\3\2\2"+
		"\2\u00b1\u00b2\7\r\2\2\u00b2\u00b3\5\"\22\2\u00b3\u00b5\7\16\2\2\u00b4"+
		"\u00b6\5> \2\u00b5\u00b4\3\2\2\2\u00b6\u00b7\3\2\2\2\u00b7\u00b5\3\2\2"+
		"\2\u00b7\u00b8\3\2\2\2\u00b8\u00b9\3\2\2\2\u00b9\u00c6\5\20\t\2\u00ba"+
		"\u00bb\7\17\2\2\u00bb\u00bc\5\"\22\2\u00bc\u00be\7\16\2\2\u00bd\u00bf"+
		"\5> \2\u00be\u00bd\3\2\2\2\u00bf\u00c0\3\2\2\2\u00c0\u00be\3\2\2\2\u00c0"+
		"\u00c1\3\2\2\2\u00c1\u00c2\3\2\2\2\u00c2\u00c3\5\20\t\2\u00c3\u00c5\3"+
		"\2\2\2\u00c4\u00ba\3\2\2\2\u00c5\u00c8\3\2\2\2\u00c6\u00c4\3\2\2\2\u00c6"+
		"\u00c7\3\2\2\2\u00c7\u00d1\3\2\2\2\u00c8\u00c6\3\2\2\2\u00c9\u00cb\7\20"+
		"\2\2\u00ca\u00cc\5> \2\u00cb\u00ca\3\2\2\2\u00cc\u00cd\3\2\2\2\u00cd\u00cb"+
		"\3\2\2\2\u00cd\u00ce\3\2\2\2\u00ce\u00cf\3\2\2\2\u00cf\u00d0\5\20\t\2"+
		"\u00d0\u00d2\3\2\2\2\u00d1\u00c9\3\2\2\2\u00d1\u00d2\3\2\2\2\u00d2\u00d3"+
		"\3\2\2\2\u00d3\u00d4\7\21\2\2\u00d4\31\3\2\2\2\u00d5\u00d6\7\22\2\2\u00d6"+
		"\u00d7\5\64\33\2\u00d7\u00d8\5B\"\2\u00d8\u00d9\7\23\2\2\u00d9\u00db\5"+
		" \21\2\u00da\u00dc\5> \2\u00db\u00da\3\2\2\2\u00dc\u00dd\3\2\2\2\u00dd"+
		"\u00db\3\2\2\2\u00dd\u00de\3\2\2\2\u00de\u00df\3\2\2\2\u00df\u00e0\5\20"+
		"\t\2\u00e0\u00e1\7\24\2\2\u00e1\33\3\2\2\2\u00e2\u00e5\5\64\33\2\u00e3"+
		"\u00e6\5B\"\2\u00e4\u00e6\5\36\20\2\u00e5\u00e3\3\2\2\2\u00e5\u00e4\3"+
		"\2\2\2\u00e6\u00ee\3\2\2\2\u00e7\u00ea\7\t\2\2\u00e8\u00eb\5B\"\2\u00e9"+
		"\u00eb\5\36\20\2\u00ea\u00e8\3\2\2\2\u00ea\u00e9\3\2\2\2\u00eb\u00ed\3"+
		"\2\2\2\u00ec\u00e7\3\2\2\2\u00ed\u00f0\3\2\2\2\u00ee\u00ec\3\2\2\2\u00ee"+
		"\u00ef\3\2\2\2\u00ef\35\3\2\2\2\u00f0\u00ee\3\2\2\2\u00f1\u00f2\5@!\2"+
		"\u00f2\u00f3\7\25\2\2\u00f3\u00f4\5 \21\2\u00f4\u0100\3\2\2\2\u00f5\u00f6"+
		"\5@!\2\u00f6\u00f7\7\25\2\2\u00f7\u00f8\7\26\2\2\u00f8\u00f9\5\64\33\2"+
		"\u00f9\u00fb\7\62\2\2\u00fa\u00fc\5\n\6\2\u00fb\u00fa\3\2\2\2\u00fb\u00fc"+
		"\3\2\2\2\u00fc\u00fd\3\2\2\2\u00fd\u00fe\7\63\2\2\u00fe\u0100\3\2\2\2"+
		"\u00ff\u00f1\3\2\2\2\u00ff\u00f5\3\2\2\2\u0100\37\3\2\2\2\u0101\u0104"+
		"\5\36\20\2\u0102\u0104\5\"\22\2\u0103\u0101\3\2\2\2\u0103\u0102\3\2\2"+
		"\2\u0104!\3\2\2\2\u0105\u0106\5$\23\2\u0106#\3\2\2\2\u0107\u0108\b\23"+
		"\1\2\u0108\u0109\5&\24\2\u0109\u010f\3\2\2\2\u010a\u010b\f\4\2\2\u010b"+
		"\u010c\7)\2\2\u010c\u010e\5&\24\2\u010d\u010a\3\2\2\2\u010e\u0111\3\2"+
		"\2\2\u010f\u010d\3\2\2\2\u010f\u0110\3\2\2\2\u0110%\3\2\2\2\u0111\u010f"+
		"\3\2\2\2\u0112\u0113\b\24\1\2\u0113\u0114\5(\25\2\u0114\u011a\3\2\2\2"+
		"\u0115\u0116\f\4\2\2\u0116\u0117\7(\2\2\u0117\u0119\5(\25\2\u0118\u0115"+
		"\3\2\2\2\u0119\u011c\3\2\2\2\u011a\u0118\3\2\2\2\u011a\u011b\3\2\2\2\u011b"+
		"\'\3\2\2\2\u011c\u011a\3\2\2\2\u011d\u011e\5*\26\2\u011e\u011f\7,\2\2"+
		"\u011f\u0120\5*\26\2\u0120\u0123\3\2\2\2\u0121\u0123\5*\26\2\u0122\u011d"+
		"\3\2\2\2\u0122\u0121\3\2\2\2\u0123)\3\2\2\2\u0124\u0125\5.\30\2\u0125"+
		"\u0126\7+\2\2\u0126\u0127\5.\30\2\u0127\u012a\3\2\2\2\u0128\u012a\5.\30"+
		"\2\u0129\u0124\3\2\2\2\u0129\u0128\3\2\2\2\u012a+\3\2\2\2\u012b\u012c"+
		"\t\2\2\2\u012c-\3\2\2\2\u012d\u012e\b\30\1\2\u012e\u012f\5\60\31\2\u012f"+
		"\u0135\3\2\2\2\u0130\u0131\f\3\2\2\u0131\u0132\7&\2\2\u0132\u0134\5\60"+
		"\31\2\u0133\u0130\3\2\2\2\u0134\u0137\3\2\2\2\u0135\u0133\3\2\2\2\u0135"+
		"\u0136\3\2\2\2\u0136/\3\2\2\2\u0137\u0135\3\2\2\2\u0138\u0139\b\31\1\2"+
		"\u0139\u013a\5\62\32\2\u013a\u0140\3\2\2\2\u013b\u013c\f\3\2\2\u013c\u013d"+
		"\7\'\2\2\u013d\u013f\5\62\32\2\u013e\u013b\3\2\2\2\u013f\u0142\3\2\2\2"+
		"\u0140\u013e\3\2\2\2\u0140\u0141\3\2\2\2\u0141\61\3\2\2\2\u0142\u0140"+
		"\3\2\2\2\u0143\u0152\5\66\34\2\u0144\u0152\5,\27\2\u0145\u0152\5\b\5\2"+
		"\u0146\u0147\7\62\2\2\u0147\u0148\5\"\22\2\u0148\u0149\7\63\2\2\u0149"+
		"\u0152\3\2\2\2\u014a\u014b\7*\2\2\u014b\u0152\5\62\32\2\u014c\u014d\7"+
		"\62\2\2\u014d\u014e\5\64\33\2\u014e\u014f\7\63\2\2\u014f\u0150\5\62\32"+
		"\2\u0150\u0152\3\2\2\2\u0151\u0143\3\2\2\2\u0151\u0144\3\2\2\2\u0151\u0145"+
		"\3\2\2\2\u0151\u0146\3\2\2\2\u0151\u014a\3\2\2\2\u0151\u014c\3\2\2\2\u0152"+
		"\63\3\2\2\2\u0153\u0161\7\27\2\2\u0154\u0161\7\30\2\2\u0155\u0161\7\31"+
		"\2\2\u0156\u0161\7\32\2\2\u0157\u0158\7\33\2\2\u0158\u0159\7\34\2\2\u0159"+
		"\u015a\5\64\33\2\u015a\u015b\7\35\2\2\u015b\u0161\3\2\2\2\u015c\u0161"+
		"\7\36\2\2\u015d\u0161\7\37\2\2\u015e\u0161\7 \2\2\u015f\u0161\7!\2\2\u0160"+
		"\u0153\3\2\2\2\u0160\u0154\3\2\2\2\u0160\u0155\3\2\2\2\u0160\u0156\3\2"+
		"\2\2\u0160\u0157\3\2\2\2\u0160\u015c\3\2\2\2\u0160\u015d\3\2\2\2\u0160"+
		"\u015e\3\2\2\2\u0160\u015f\3\2\2\2\u0161\65\3\2\2\2\u0162\u0167\5@!\2"+
		"\u0163\u0167\58\35\2\u0164\u0167\5<\37\2\u0165\u0167\5:\36\2\u0166\u0162"+
		"\3\2\2\2\u0166\u0163\3\2\2\2\u0166\u0164\3\2\2\2\u0166\u0165\3\2\2\2\u0167"+
		"\67\3\2\2\2\u0168\u0169\7/\2\2\u01699\3\2\2\2\u016a\u016b\7\62\2\2\u016b"+
		"\u016c\5\"\22\2\u016c\u016d\7\t\2\2\u016d\u016e\5\"\22\2\u016e\u016f\7"+
		"\t\2\2\u016f\u0170\5\"\22\2\u0170\u0171\7\63\2\2\u0171;\3\2\2\2\u0172"+
		"\u0173\7.\2\2\u0173=\3\2\2\2\u0174\u0175\7-\2\2\u0175?\3\2\2\2\u0176\u0177"+
		"\b!\1\2\u0177\u0178\5B\"\2\u0178\u0183\3\2\2\2\u0179\u017a\f\5\2\2\u017a"+
		"\u017b\7\b\2\2\u017b\u0182\5@!\6\u017c\u017d\f\4\2\2\u017d\u017e\7\"\2"+
		"\2\u017e\u017f\5.\30\2\u017f\u0180\7#\2\2\u0180\u0182\3\2\2\2\u0181\u0179"+
		"\3\2\2\2\u0181\u017c\3\2\2\2\u0182\u0185\3\2\2\2\u0183\u0181\3\2\2\2\u0183"+
		"\u0184\3\2\2\2\u0184A\3\2\2\2\u0185\u0183\3\2\2\2\u0186\u0187\7\61\2\2"+
		"\u0187C\3\2\2\2(IRV]bgpy\u0081\u0089\u0093\u0097\u00a1\u00a5\u00ac\u00b7"+
		"\u00c0\u00c6\u00cd\u00d1\u00dd\u00e5\u00ea\u00ee\u00fb\u00ff\u0103\u010f"+
		"\u011a\u0122\u0129\u0135\u0140\u0151\u0160\u0166\u0181\u0183";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}