// Generated from /home/zen/Git/EduCode-P4/src/EduCode.g4 by ANTLR 4.6
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
		T__31=32, T__32=33, T__33=34, T__34=35, T__35=36, T__36=37, T__37=38, 
		T__38=39, T__39=40, T__40=41, TRUE=42, FALSE=43, ADDOP=44, MULTOP=45, 
		ANDOP=46, OROP=47, ULOP=48, RELOP=49, EQUALOP=50, NEWLINE=51, NUMLIT=52, 
		STRLIT=53, USTRLIT=54, IDENT=55, LPAREN=56, RPAREN=57, WHITESPACE=58, 
		LINECOMMENT=59;
	public static final int
		RULE_program = 0, RULE_eventDef = 1, RULE_method = 2, RULE_methodC = 3, 
		RULE_args = 4, RULE_params = 5, RULE_param = 6, RULE_stmts = 7, RULE_stmt = 8, 
		RULE_ret = 9, RULE_loopStmt = 10, RULE_ifStmt = 11, RULE_iterStmt = 12, 
		RULE_varDcl = 13, RULE_assign = 14, RULE_expr = 15, RULE_logicExpr = 16, 
		RULE_orExpr = 17, RULE_andExpr = 18, RULE_eqlExpr = 19, RULE_relExpr = 20, 
		RULE_boolLit = 21, RULE_arithExpr = 22, RULE_term = 23, RULE_factor = 24, 
		RULE_negation = 25, RULE_typeCast = 26, RULE_objInst = 27, RULE_eventType = 28, 
		RULE_dataType = 29, RULE_literal = 30, RULE_stringLit = 31, RULE_coordLit = 32, 
		RULE_numberLit = 33, RULE_eol = 34, RULE_reference = 35, RULE_ident = 36;
	public static final String[] ruleNames = {
		"program", "eventDef", "method", "methodC", "args", "params", "param", 
		"stmts", "stmt", "ret", "loopStmt", "ifStmt", "iterStmt", "varDcl", "assign", 
		"expr", "logicExpr", "orExpr", "andExpr", "eqlExpr", "relExpr", "boolLit", 
		"arithExpr", "term", "factor", "negation", "typeCast", "objInst", "eventType", 
		"dataType", "literal", "stringLit", "coordLit", "numberLit", "eol", "reference", 
		"ident"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'program'", "'end program'", "'on event'", "'call'", "'method'", 
		"'returns'", "'end method'", "'.'", "','", "'return'", "'repeat while'", 
		"'end repeat'", "'if'", "'then'", "'else if'", "'else'", "'end if'", "'foreach'", 
		"'in'", "'end foreach'", "'='", "'new'", "'robotDeath'", "'robotAttacked'", 
		"'entityDeath'", "'chatMessage'", "'stringMessageReceived'", "'entityMessageReceived'", 
		"'number'", "'bool'", "'Coordinates'", "'string'", "'Collection'", "'<'", 
		"'>'", "'Block'", "'Entity'", "'Item'", "'Texture'", "'['", "']'", "'true'", 
		"'false'", null, null, "'and'", "'or'", "'not'", null, null, null, null, 
		null, null, null, "'('", "')'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, "TRUE", "FALSE", "ADDOP", "MULTOP", 
		"ANDOP", "OROP", "ULOP", "RELOP", "EQUALOP", "NEWLINE", "NUMLIT", "STRLIT", 
		"USTRLIT", "IDENT", "LPAREN", "RPAREN", "WHITESPACE", "LINECOMMENT"
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
		public List<EolContext> eol() {
			return getRuleContexts(EolContext.class);
		}
		public EolContext eol(int i) {
			return getRuleContext(EolContext.class,i);
		}
		public List<EventDefContext> eventDef() {
			return getRuleContexts(EventDefContext.class);
		}
		public EventDefContext eventDef(int i) {
			return getRuleContext(EventDefContext.class,i);
		}
		public List<MethodContext> method() {
			return getRuleContexts(MethodContext.class);
		}
		public MethodContext method(int i) {
			return getRuleContext(MethodContext.class,i);
		}
		public List<VarDclContext> varDcl() {
			return getRuleContexts(VarDclContext.class);
		}
		public VarDclContext varDcl(int i) {
			return getRuleContext(VarDclContext.class,i);
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
			setState(74);
			match(T__0);
			setState(75);
			ident();
			setState(77); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(76);
				eol();
				}
				}
				setState(79); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==NEWLINE );
			setState(93);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__2) | (1L << T__4) | (1L << T__28) | (1L << T__29) | (1L << T__30) | (1L << T__31) | (1L << T__32) | (1L << T__35) | (1L << T__36) | (1L << T__37) | (1L << T__38))) != 0)) {
				{
				{
				setState(84);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__2:
					{
					setState(81);
					eventDef();
					}
					break;
				case T__4:
					{
					setState(82);
					method();
					}
					break;
				case T__28:
				case T__29:
				case T__30:
				case T__31:
				case T__32:
				case T__35:
				case T__36:
				case T__37:
				case T__38:
					{
					setState(83);
					varDcl();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(87); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(86);
					eol();
					}
					}
					setState(89); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==NEWLINE );
				}
				}
				setState(95);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(96);
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

	public static class EventDefContext extends ParserRuleContext {
		public EventTypeContext eventType() {
			return getRuleContext(EventTypeContext.class,0);
		}
		public IdentContext ident() {
			return getRuleContext(IdentContext.class,0);
		}
		public EventDefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_eventDef; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EduCodeVisitor ) return ((EduCodeVisitor<? extends T>)visitor).visitEventDef(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EventDefContext eventDef() throws RecognitionException {
		EventDefContext _localctx = new EventDefContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_eventDef);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(98);
			match(T__2);
			setState(99);
			eventType();
			setState(100);
			match(T__3);
			setState(101);
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
			setState(103);
			match(T__4);
			setState(104);
			ident();
			setState(105);
			match(LPAREN);
			setState(107);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__28) | (1L << T__29) | (1L << T__30) | (1L << T__31) | (1L << T__32) | (1L << T__35) | (1L << T__36) | (1L << T__37) | (1L << T__38))) != 0)) {
				{
				setState(106);
				params();
				}
			}

			setState(109);
			match(RPAREN);
			setState(112);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__5) {
				{
				setState(110);
				match(T__5);
				setState(111);
				dataType();
				}
			}

			setState(115); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(114);
				eol();
				}
				}
				setState(117); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==NEWLINE );
			setState(119);
			stmts();
			setState(120);
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
			setState(123);
			reference(0);
			setState(124);
			match(LPAREN);
			setState(126);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__21) | (1L << TRUE) | (1L << FALSE) | (1L << ULOP) | (1L << NUMLIT) | (1L << STRLIT) | (1L << IDENT) | (1L << LPAREN))) != 0)) {
				{
				setState(125);
				args();
				}
			}

			setState(128);
			match(RPAREN);
			}
			_ctx.stop = _input.LT(-1);
			setState(135);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new MethodCContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_methodC);
					setState(130);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(131);
					match(T__7);
					setState(132);
					methodC(2);
					}
					} 
				}
				setState(137);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
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
			setState(138);
			expr();
			setState(143);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__8) {
				{
				{
				setState(139);
				match(T__8);
				setState(140);
				expr();
				}
				}
				setState(145);
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
			setState(146);
			param();
			setState(151);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__8) {
				{
				{
				setState(147);
				match(T__8);
				setState(148);
				param();
				}
				}
				setState(153);
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
			setState(154);
			dataType();
			setState(155);
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
			setState(165);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__9) | (1L << T__10) | (1L << T__12) | (1L << T__17) | (1L << T__28) | (1L << T__29) | (1L << T__30) | (1L << T__31) | (1L << T__32) | (1L << T__35) | (1L << T__36) | (1L << T__37) | (1L << T__38) | (1L << IDENT))) != 0)) {
				{
				{
				setState(157);
				stmt();
				setState(159); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(158);
					eol();
					}
					}
					setState(161); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==NEWLINE );
				}
				}
				setState(167);
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
			setState(175);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(168);
				methodC(0);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(169);
				assign();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(170);
				varDcl();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(171);
				ifStmt();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(172);
				loopStmt();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(173);
				iterStmt();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(174);
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
			setState(177);
			match(T__9);
			setState(179);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__21) | (1L << TRUE) | (1L << FALSE) | (1L << ULOP) | (1L << NUMLIT) | (1L << STRLIT) | (1L << IDENT) | (1L << LPAREN))) != 0)) {
				{
				setState(178);
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
			setState(181);
			match(T__10);
			setState(182);
			logicExpr();
			setState(184); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(183);
				eol();
				}
				}
				setState(186); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==NEWLINE );
			setState(188);
			stmts();
			setState(189);
			match(T__11);
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
			setState(191);
			match(T__12);
			setState(192);
			logicExpr();
			setState(193);
			match(T__13);
			setState(195); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(194);
				eol();
				}
				}
				setState(197); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==NEWLINE );
			setState(199);
			stmts();
			setState(212);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__14) {
				{
				{
				setState(200);
				match(T__14);
				setState(201);
				logicExpr();
				setState(202);
				match(T__13);
				setState(204); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(203);
					eol();
					}
					}
					setState(206); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==NEWLINE );
				setState(208);
				stmts();
				}
				}
				setState(214);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(223);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__15) {
				{
				setState(215);
				match(T__15);
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
				}
			}

			setState(225);
			match(T__16);
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
			setState(227);
			match(T__17);
			setState(228);
			dataType();
			setState(229);
			ident();
			setState(230);
			match(T__18);
			setState(231);
			expr();
			setState(233); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(232);
				eol();
				}
				}
				setState(235); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==NEWLINE );
			setState(237);
			stmts();
			setState(238);
			match(T__19);
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
			setState(240);
			dataType();
			setState(243);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,22,_ctx) ) {
			case 1:
				{
				setState(241);
				ident();
				}
				break;
			case 2:
				{
				setState(242);
				assign();
				}
				break;
			}
			setState(252);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__8) {
				{
				{
				setState(245);
				match(T__8);
				setState(248);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,23,_ctx) ) {
				case 1:
					{
					setState(246);
					ident();
					}
					break;
				case 2:
					{
					setState(247);
					assign();
					}
					break;
				}
				}
				}
				setState(254);
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
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(255);
			reference(0);
			setState(256);
			match(T__20);
			setState(257);
			expr();
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
			setState(261);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,25,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(259);
				assign();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(260);
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
			setState(263);
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
			setState(266);
			andExpr(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(273);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,26,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new OrExprContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_orExpr);
					setState(268);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(269);
					match(OROP);
					setState(270);
					andExpr(0);
					}
					} 
				}
				setState(275);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,26,_ctx);
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
			setState(277);
			eqlExpr();
			}
			_ctx.stop = _input.LT(-1);
			setState(284);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,27,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new AndExprContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_andExpr);
					setState(279);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(280);
					match(ANDOP);
					setState(281);
					eqlExpr();
					}
					} 
				}
				setState(286);
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
			setState(292);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,28,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(287);
				relExpr();
				setState(288);
				match(EQUALOP);
				setState(289);
				relExpr();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(291);
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
			setState(299);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,29,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(294);
				arithExpr(0);
				setState(295);
				match(RELOP);
				setState(296);
				arithExpr(0);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(298);
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
			setState(301);
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
			setState(304);
			term(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(311);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,30,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new ArithExprContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_arithExpr);
					setState(306);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(307);
					match(ADDOP);
					setState(308);
					term(0);
					}
					} 
				}
				setState(313);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,30,_ctx);
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
			setState(315);
			factor();
			}
			_ctx.stop = _input.LT(-1);
			setState(322);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,31,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new TermContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_term);
					setState(317);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(318);
					match(MULTOP);
					setState(319);
					factor();
					}
					} 
				}
				setState(324);
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

	public static class FactorContext extends ParserRuleContext {
		public LiteralContext literal() {
			return getRuleContext(LiteralContext.class,0);
		}
		public ObjInstContext objInst() {
			return getRuleContext(ObjInstContext.class,0);
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
		public NegationContext negation() {
			return getRuleContext(NegationContext.class,0);
		}
		public TypeCastContext typeCast() {
			return getRuleContext(TypeCastContext.class,0);
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
			switch ( getInterpreter().adaptivePredict(_input,32,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(325);
				literal();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(326);
				objInst();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(327);
				boolLit();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(328);
				methodC(0);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(329);
				match(LPAREN);
				setState(330);
				logicExpr();
				setState(331);
				match(RPAREN);
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(333);
				negation();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(334);
				typeCast();
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

	public static class NegationContext extends ParserRuleContext {
		public TerminalNode ULOP() { return getToken(EduCodeParser.ULOP, 0); }
		public FactorContext factor() {
			return getRuleContext(FactorContext.class,0);
		}
		public NegationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_negation; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EduCodeVisitor ) return ((EduCodeVisitor<? extends T>)visitor).visitNegation(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NegationContext negation() throws RecognitionException {
		NegationContext _localctx = new NegationContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_negation);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(337);
			match(ULOP);
			setState(338);
			factor();
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

	public static class TypeCastContext extends ParserRuleContext {
		public TerminalNode LPAREN() { return getToken(EduCodeParser.LPAREN, 0); }
		public DataTypeContext dataType() {
			return getRuleContext(DataTypeContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(EduCodeParser.RPAREN, 0); }
		public FactorContext factor() {
			return getRuleContext(FactorContext.class,0);
		}
		public TypeCastContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeCast; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EduCodeVisitor ) return ((EduCodeVisitor<? extends T>)visitor).visitTypeCast(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeCastContext typeCast() throws RecognitionException {
		TypeCastContext _localctx = new TypeCastContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_typeCast);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(340);
			match(LPAREN);
			setState(341);
			dataType();
			setState(342);
			match(RPAREN);
			setState(343);
			factor();
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

	public static class ObjInstContext extends ParserRuleContext {
		public DataTypeContext dataType() {
			return getRuleContext(DataTypeContext.class,0);
		}
		public TerminalNode LPAREN() { return getToken(EduCodeParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(EduCodeParser.RPAREN, 0); }
		public ArgsContext args() {
			return getRuleContext(ArgsContext.class,0);
		}
		public ObjInstContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_objInst; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EduCodeVisitor ) return ((EduCodeVisitor<? extends T>)visitor).visitObjInst(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ObjInstContext objInst() throws RecognitionException {
		ObjInstContext _localctx = new ObjInstContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_objInst);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(345);
			match(T__21);
			setState(346);
			dataType();
			setState(347);
			match(LPAREN);
			setState(349);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__21) | (1L << TRUE) | (1L << FALSE) | (1L << ULOP) | (1L << NUMLIT) | (1L << STRLIT) | (1L << IDENT) | (1L << LPAREN))) != 0)) {
				{
				setState(348);
				args();
				}
			}

			setState(351);
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

	public static class EventTypeContext extends ParserRuleContext {
		public TerminalNode LPAREN() { return getToken(EduCodeParser.LPAREN, 0); }
		public NumberLitContext numberLit() {
			return getRuleContext(NumberLitContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(EduCodeParser.RPAREN, 0); }
		public EventTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_eventType; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EduCodeVisitor ) return ((EduCodeVisitor<? extends T>)visitor).visitEventType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EventTypeContext eventType() throws RecognitionException {
		EventTypeContext _localctx = new EventTypeContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_eventType);
		int _la;
		try {
			setState(362);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__22:
				enterOuterAlt(_localctx, 1);
				{
				setState(353);
				match(T__22);
				}
				break;
			case T__23:
				enterOuterAlt(_localctx, 2);
				{
				setState(354);
				match(T__23);
				}
				break;
			case T__24:
				enterOuterAlt(_localctx, 3);
				{
				setState(355);
				match(T__24);
				}
				break;
			case T__25:
				enterOuterAlt(_localctx, 4);
				{
				setState(356);
				match(T__25);
				}
				break;
			case T__26:
			case T__27:
				enterOuterAlt(_localctx, 5);
				{
				setState(357);
				_la = _input.LA(1);
				if ( !(_la==T__26 || _la==T__27) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(358);
				match(LPAREN);
				setState(359);
				numberLit();
				setState(360);
				match(RPAREN);
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
		enterRule(_localctx, 58, RULE_dataType);
		try {
			setState(377);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__28:
				enterOuterAlt(_localctx, 1);
				{
				setState(364);
				match(T__28);
				}
				break;
			case T__29:
				enterOuterAlt(_localctx, 2);
				{
				setState(365);
				match(T__29);
				}
				break;
			case T__30:
				enterOuterAlt(_localctx, 3);
				{
				setState(366);
				match(T__30);
				}
				break;
			case T__31:
				enterOuterAlt(_localctx, 4);
				{
				setState(367);
				match(T__31);
				}
				break;
			case T__32:
				enterOuterAlt(_localctx, 5);
				{
				setState(368);
				match(T__32);
				setState(369);
				match(T__33);
				setState(370);
				dataType();
				setState(371);
				match(T__34);
				}
				break;
			case T__35:
				enterOuterAlt(_localctx, 6);
				{
				setState(373);
				match(T__35);
				}
				break;
			case T__36:
				enterOuterAlt(_localctx, 7);
				{
				setState(374);
				match(T__36);
				}
				break;
			case T__37:
				enterOuterAlt(_localctx, 8);
				{
				setState(375);
				match(T__37);
				}
				break;
			case T__38:
				enterOuterAlt(_localctx, 9);
				{
				setState(376);
				match(T__38);
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
		enterRule(_localctx, 60, RULE_literal);
		try {
			setState(383);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IDENT:
				enterOuterAlt(_localctx, 1);
				{
				setState(379);
				reference(0);
				}
				break;
			case STRLIT:
				enterOuterAlt(_localctx, 2);
				{
				setState(380);
				stringLit();
				}
				break;
			case NUMLIT:
				enterOuterAlt(_localctx, 3);
				{
				setState(381);
				numberLit();
				}
				break;
			case LPAREN:
				enterOuterAlt(_localctx, 4);
				{
				setState(382);
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
		enterRule(_localctx, 62, RULE_stringLit);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(385);
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
		enterRule(_localctx, 64, RULE_coordLit);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(387);
			match(LPAREN);
			setState(388);
			logicExpr();
			setState(389);
			match(T__8);
			setState(390);
			logicExpr();
			setState(391);
			match(T__8);
			setState(392);
			logicExpr();
			setState(393);
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
		enterRule(_localctx, 66, RULE_numberLit);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(395);
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
		enterRule(_localctx, 68, RULE_eol);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(397);
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
		int _startState = 70;
		enterRecursionRule(_localctx, 70, RULE_reference, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(400);
			ident();
			}
			_ctx.stop = _input.LT(-1);
			setState(412);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,38,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(410);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,37,_ctx) ) {
					case 1:
						{
						_localctx = new ReferenceContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_reference);
						setState(402);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(403);
						match(T__7);
						setState(404);
						reference(4);
						}
						break;
					case 2:
						{
						_localctx = new ReferenceContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_reference);
						setState(405);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(406);
						match(T__39);
						setState(407);
						arithExpr(0);
						setState(408);
						match(T__40);
						}
						break;
					}
					} 
				}
				setState(414);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,38,_ctx);
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
		enterRule(_localctx, 72, RULE_ident);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(415);
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
		case 35:
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3=\u01a4\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\3\2\3\2\3\2\6\2P\n\2\r\2\16\2Q\3\2"+
		"\3\2\3\2\5\2W\n\2\3\2\6\2Z\n\2\r\2\16\2[\7\2^\n\2\f\2\16\2a\13\2\3\2\3"+
		"\2\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\5\4n\n\4\3\4\3\4\3\4\5\4s\n\4\3"+
		"\4\6\4v\n\4\r\4\16\4w\3\4\3\4\3\4\3\5\3\5\3\5\3\5\5\5\u0081\n\5\3\5\3"+
		"\5\3\5\3\5\3\5\7\5\u0088\n\5\f\5\16\5\u008b\13\5\3\6\3\6\3\6\7\6\u0090"+
		"\n\6\f\6\16\6\u0093\13\6\3\7\3\7\3\7\7\7\u0098\n\7\f\7\16\7\u009b\13\7"+
		"\3\b\3\b\3\b\3\t\3\t\6\t\u00a2\n\t\r\t\16\t\u00a3\7\t\u00a6\n\t\f\t\16"+
		"\t\u00a9\13\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\5\n\u00b2\n\n\3\13\3\13\5\13"+
		"\u00b6\n\13\3\f\3\f\3\f\6\f\u00bb\n\f\r\f\16\f\u00bc\3\f\3\f\3\f\3\r\3"+
		"\r\3\r\3\r\6\r\u00c6\n\r\r\r\16\r\u00c7\3\r\3\r\3\r\3\r\3\r\6\r\u00cf"+
		"\n\r\r\r\16\r\u00d0\3\r\3\r\7\r\u00d5\n\r\f\r\16\r\u00d8\13\r\3\r\3\r"+
		"\6\r\u00dc\n\r\r\r\16\r\u00dd\3\r\3\r\5\r\u00e2\n\r\3\r\3\r\3\16\3\16"+
		"\3\16\3\16\3\16\3\16\6\16\u00ec\n\16\r\16\16\16\u00ed\3\16\3\16\3\16\3"+
		"\17\3\17\3\17\5\17\u00f6\n\17\3\17\3\17\3\17\5\17\u00fb\n\17\7\17\u00fd"+
		"\n\17\f\17\16\17\u0100\13\17\3\20\3\20\3\20\3\20\3\21\3\21\5\21\u0108"+
		"\n\21\3\22\3\22\3\23\3\23\3\23\3\23\3\23\3\23\7\23\u0112\n\23\f\23\16"+
		"\23\u0115\13\23\3\24\3\24\3\24\3\24\3\24\3\24\7\24\u011d\n\24\f\24\16"+
		"\24\u0120\13\24\3\25\3\25\3\25\3\25\3\25\5\25\u0127\n\25\3\26\3\26\3\26"+
		"\3\26\3\26\5\26\u012e\n\26\3\27\3\27\3\30\3\30\3\30\3\30\3\30\3\30\7\30"+
		"\u0138\n\30\f\30\16\30\u013b\13\30\3\31\3\31\3\31\3\31\3\31\3\31\7\31"+
		"\u0143\n\31\f\31\16\31\u0146\13\31\3\32\3\32\3\32\3\32\3\32\3\32\3\32"+
		"\3\32\3\32\3\32\5\32\u0152\n\32\3\33\3\33\3\33\3\34\3\34\3\34\3\34\3\34"+
		"\3\35\3\35\3\35\3\35\5\35\u0160\n\35\3\35\3\35\3\36\3\36\3\36\3\36\3\36"+
		"\3\36\3\36\3\36\3\36\5\36\u016d\n\36\3\37\3\37\3\37\3\37\3\37\3\37\3\37"+
		"\3\37\3\37\3\37\3\37\3\37\3\37\5\37\u017c\n\37\3 \3 \3 \3 \5 \u0182\n"+
		" \3!\3!\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3#\3#\3$\3$\3%\3%\3%\3%\3%\3%"+
		"\3%\3%\3%\3%\3%\7%\u019d\n%\f%\16%\u01a0\13%\3&\3&\3&\2\b\b$&.\60H\'\2"+
		"\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\60\62\64\668:<>@BDFHJ\2"+
		"\4\3\2,-\3\2\35\36\u01bc\2L\3\2\2\2\4d\3\2\2\2\6i\3\2\2\2\b|\3\2\2\2\n"+
		"\u008c\3\2\2\2\f\u0094\3\2\2\2\16\u009c\3\2\2\2\20\u00a7\3\2\2\2\22\u00b1"+
		"\3\2\2\2\24\u00b3\3\2\2\2\26\u00b7\3\2\2\2\30\u00c1\3\2\2\2\32\u00e5\3"+
		"\2\2\2\34\u00f2\3\2\2\2\36\u0101\3\2\2\2 \u0107\3\2\2\2\"\u0109\3\2\2"+
		"\2$\u010b\3\2\2\2&\u0116\3\2\2\2(\u0126\3\2\2\2*\u012d\3\2\2\2,\u012f"+
		"\3\2\2\2.\u0131\3\2\2\2\60\u013c\3\2\2\2\62\u0151\3\2\2\2\64\u0153\3\2"+
		"\2\2\66\u0156\3\2\2\28\u015b\3\2\2\2:\u016c\3\2\2\2<\u017b\3\2\2\2>\u0181"+
		"\3\2\2\2@\u0183\3\2\2\2B\u0185\3\2\2\2D\u018d\3\2\2\2F\u018f\3\2\2\2H"+
		"\u0191\3\2\2\2J\u01a1\3\2\2\2LM\7\3\2\2MO\5J&\2NP\5F$\2ON\3\2\2\2PQ\3"+
		"\2\2\2QO\3\2\2\2QR\3\2\2\2R_\3\2\2\2SW\5\4\3\2TW\5\6\4\2UW\5\34\17\2V"+
		"S\3\2\2\2VT\3\2\2\2VU\3\2\2\2WY\3\2\2\2XZ\5F$\2YX\3\2\2\2Z[\3\2\2\2[Y"+
		"\3\2\2\2[\\\3\2\2\2\\^\3\2\2\2]V\3\2\2\2^a\3\2\2\2_]\3\2\2\2_`\3\2\2\2"+
		"`b\3\2\2\2a_\3\2\2\2bc\7\4\2\2c\3\3\2\2\2de\7\5\2\2ef\5:\36\2fg\7\6\2"+
		"\2gh\5J&\2h\5\3\2\2\2ij\7\7\2\2jk\5J&\2km\7:\2\2ln\5\f\7\2ml\3\2\2\2m"+
		"n\3\2\2\2no\3\2\2\2or\7;\2\2pq\7\b\2\2qs\5<\37\2rp\3\2\2\2rs\3\2\2\2s"+
		"u\3\2\2\2tv\5F$\2ut\3\2\2\2vw\3\2\2\2wu\3\2\2\2wx\3\2\2\2xy\3\2\2\2yz"+
		"\5\20\t\2z{\7\t\2\2{\7\3\2\2\2|}\b\5\1\2}~\5H%\2~\u0080\7:\2\2\177\u0081"+
		"\5\n\6\2\u0080\177\3\2\2\2\u0080\u0081\3\2\2\2\u0081\u0082\3\2\2\2\u0082"+
		"\u0083\7;\2\2\u0083\u0089\3\2\2\2\u0084\u0085\f\3\2\2\u0085\u0086\7\n"+
		"\2\2\u0086\u0088\5\b\5\4\u0087\u0084\3\2\2\2\u0088\u008b\3\2\2\2\u0089"+
		"\u0087\3\2\2\2\u0089\u008a\3\2\2\2\u008a\t\3\2\2\2\u008b\u0089\3\2\2\2"+
		"\u008c\u0091\5 \21\2\u008d\u008e\7\13\2\2\u008e\u0090\5 \21\2\u008f\u008d"+
		"\3\2\2\2\u0090\u0093\3\2\2\2\u0091\u008f\3\2\2\2\u0091\u0092\3\2\2\2\u0092"+
		"\13\3\2\2\2\u0093\u0091\3\2\2\2\u0094\u0099\5\16\b\2\u0095\u0096\7\13"+
		"\2\2\u0096\u0098\5\16\b\2\u0097\u0095\3\2\2\2\u0098\u009b\3\2\2\2\u0099"+
		"\u0097\3\2\2\2\u0099\u009a\3\2\2\2\u009a\r\3\2\2\2\u009b\u0099\3\2\2\2"+
		"\u009c\u009d\5<\37\2\u009d\u009e\5J&\2\u009e\17\3\2\2\2\u009f\u00a1\5"+
		"\22\n\2\u00a0\u00a2\5F$\2\u00a1\u00a0\3\2\2\2\u00a2\u00a3\3\2\2\2\u00a3"+
		"\u00a1\3\2\2\2\u00a3\u00a4\3\2\2\2\u00a4\u00a6\3\2\2\2\u00a5\u009f\3\2"+
		"\2\2\u00a6\u00a9\3\2\2\2\u00a7\u00a5\3\2\2\2\u00a7\u00a8\3\2\2\2\u00a8"+
		"\21\3\2\2\2\u00a9\u00a7\3\2\2\2\u00aa\u00b2\5\b\5\2\u00ab\u00b2\5\36\20"+
		"\2\u00ac\u00b2\5\34\17\2\u00ad\u00b2\5\30\r\2\u00ae\u00b2\5\26\f\2\u00af"+
		"\u00b2\5\32\16\2\u00b0\u00b2\5\24\13\2\u00b1\u00aa\3\2\2\2\u00b1\u00ab"+
		"\3\2\2\2\u00b1\u00ac\3\2\2\2\u00b1\u00ad\3\2\2\2\u00b1\u00ae\3\2\2\2\u00b1"+
		"\u00af\3\2\2\2\u00b1\u00b0\3\2\2\2\u00b2\23\3\2\2\2\u00b3\u00b5\7\f\2"+
		"\2\u00b4\u00b6\5 \21\2\u00b5\u00b4\3\2\2\2\u00b5\u00b6\3\2\2\2\u00b6\25"+
		"\3\2\2\2\u00b7\u00b8\7\r\2\2\u00b8\u00ba\5\"\22\2\u00b9\u00bb\5F$\2\u00ba"+
		"\u00b9\3\2\2\2\u00bb\u00bc\3\2\2\2\u00bc\u00ba\3\2\2\2\u00bc\u00bd\3\2"+
		"\2\2\u00bd\u00be\3\2\2\2\u00be\u00bf\5\20\t\2\u00bf\u00c0\7\16\2\2\u00c0"+
		"\27\3\2\2\2\u00c1\u00c2\7\17\2\2\u00c2\u00c3\5\"\22\2\u00c3\u00c5\7\20"+
		"\2\2\u00c4\u00c6\5F$\2\u00c5\u00c4\3\2\2\2\u00c6\u00c7\3\2\2\2\u00c7\u00c5"+
		"\3\2\2\2\u00c7\u00c8\3\2\2\2\u00c8\u00c9\3\2\2\2\u00c9\u00d6\5\20\t\2"+
		"\u00ca\u00cb\7\21\2\2\u00cb\u00cc\5\"\22\2\u00cc\u00ce\7\20\2\2\u00cd"+
		"\u00cf\5F$\2\u00ce\u00cd\3\2\2\2\u00cf\u00d0\3\2\2\2\u00d0\u00ce\3\2\2"+
		"\2\u00d0\u00d1\3\2\2\2\u00d1\u00d2\3\2\2\2\u00d2\u00d3\5\20\t\2\u00d3"+
		"\u00d5\3\2\2\2\u00d4\u00ca\3\2\2\2\u00d5\u00d8\3\2\2\2\u00d6\u00d4\3\2"+
		"\2\2\u00d6\u00d7\3\2\2\2\u00d7\u00e1\3\2\2\2\u00d8\u00d6\3\2\2\2\u00d9"+
		"\u00db\7\22\2\2\u00da\u00dc\5F$\2\u00db\u00da\3\2\2\2\u00dc\u00dd\3\2"+
		"\2\2\u00dd\u00db\3\2\2\2\u00dd\u00de\3\2\2\2\u00de\u00df\3\2\2\2\u00df"+
		"\u00e0\5\20\t\2\u00e0\u00e2\3\2\2\2\u00e1\u00d9\3\2\2\2\u00e1\u00e2\3"+
		"\2\2\2\u00e2\u00e3\3\2\2\2\u00e3\u00e4\7\23\2\2\u00e4\31\3\2\2\2\u00e5"+
		"\u00e6\7\24\2\2\u00e6\u00e7\5<\37\2\u00e7\u00e8\5J&\2\u00e8\u00e9\7\25"+
		"\2\2\u00e9\u00eb\5 \21\2\u00ea\u00ec\5F$\2\u00eb\u00ea\3\2\2\2\u00ec\u00ed"+
		"\3\2\2\2\u00ed\u00eb\3\2\2\2\u00ed\u00ee\3\2\2\2\u00ee\u00ef\3\2\2\2\u00ef"+
		"\u00f0\5\20\t\2\u00f0\u00f1\7\26\2\2\u00f1\33\3\2\2\2\u00f2\u00f5\5<\37"+
		"\2\u00f3\u00f6\5J&\2\u00f4\u00f6\5\36\20\2\u00f5\u00f3\3\2\2\2\u00f5\u00f4"+
		"\3\2\2\2\u00f6\u00fe\3\2\2\2\u00f7\u00fa\7\13\2\2\u00f8\u00fb\5J&\2\u00f9"+
		"\u00fb\5\36\20\2\u00fa\u00f8\3\2\2\2\u00fa\u00f9\3\2\2\2\u00fb\u00fd\3"+
		"\2\2\2\u00fc\u00f7\3\2\2\2\u00fd\u0100\3\2\2\2\u00fe\u00fc\3\2\2\2\u00fe"+
		"\u00ff\3\2\2\2\u00ff\35\3\2\2\2\u0100\u00fe\3\2\2\2\u0101\u0102\5H%\2"+
		"\u0102\u0103\7\27\2\2\u0103\u0104\5 \21\2\u0104\37\3\2\2\2\u0105\u0108"+
		"\5\36\20\2\u0106\u0108\5\"\22\2\u0107\u0105\3\2\2\2\u0107\u0106\3\2\2"+
		"\2\u0108!\3\2\2\2\u0109\u010a\5$\23\2\u010a#\3\2\2\2\u010b\u010c\b\23"+
		"\1\2\u010c\u010d\5&\24\2\u010d\u0113\3\2\2\2\u010e\u010f\f\4\2\2\u010f"+
		"\u0110\7\61\2\2\u0110\u0112\5&\24\2\u0111\u010e\3\2\2\2\u0112\u0115\3"+
		"\2\2\2\u0113\u0111\3\2\2\2\u0113\u0114\3\2\2\2\u0114%\3\2\2\2\u0115\u0113"+
		"\3\2\2\2\u0116\u0117\b\24\1\2\u0117\u0118\5(\25\2\u0118\u011e\3\2\2\2"+
		"\u0119\u011a\f\4\2\2\u011a\u011b\7\60\2\2\u011b\u011d\5(\25\2\u011c\u0119"+
		"\3\2\2\2\u011d\u0120\3\2\2\2\u011e\u011c\3\2\2\2\u011e\u011f\3\2\2\2\u011f"+
		"\'\3\2\2\2\u0120\u011e\3\2\2\2\u0121\u0122\5*\26\2\u0122\u0123\7\64\2"+
		"\2\u0123\u0124\5*\26\2\u0124\u0127\3\2\2\2\u0125\u0127\5*\26\2\u0126\u0121"+
		"\3\2\2\2\u0126\u0125\3\2\2\2\u0127)\3\2\2\2\u0128\u0129\5.\30\2\u0129"+
		"\u012a\7\63\2\2\u012a\u012b\5.\30\2\u012b\u012e\3\2\2\2\u012c\u012e\5"+
		".\30\2\u012d\u0128\3\2\2\2\u012d\u012c\3\2\2\2\u012e+\3\2\2\2\u012f\u0130"+
		"\t\2\2\2\u0130-\3\2\2\2\u0131\u0132\b\30\1\2\u0132\u0133\5\60\31\2\u0133"+
		"\u0139\3\2\2\2\u0134\u0135\f\3\2\2\u0135\u0136\7.\2\2\u0136\u0138\5\60"+
		"\31\2\u0137\u0134\3\2\2\2\u0138\u013b\3\2\2\2\u0139\u0137\3\2\2\2\u0139"+
		"\u013a\3\2\2\2\u013a/\3\2\2\2\u013b\u0139\3\2\2\2\u013c\u013d\b\31\1\2"+
		"\u013d\u013e\5\62\32\2\u013e\u0144\3\2\2\2\u013f\u0140\f\3\2\2\u0140\u0141"+
		"\7/\2\2\u0141\u0143\5\62\32\2\u0142\u013f\3\2\2\2\u0143\u0146\3\2\2\2"+
		"\u0144\u0142\3\2\2\2\u0144\u0145\3\2\2\2\u0145\61\3\2\2\2\u0146\u0144"+
		"\3\2\2\2\u0147\u0152\5> \2\u0148\u0152\58\35\2\u0149\u0152\5,\27\2\u014a"+
		"\u0152\5\b\5\2\u014b\u014c\7:\2\2\u014c\u014d\5\"\22\2\u014d\u014e\7;"+
		"\2\2\u014e\u0152\3\2\2\2\u014f\u0152\5\64\33\2\u0150\u0152\5\66\34\2\u0151"+
		"\u0147\3\2\2\2\u0151\u0148\3\2\2\2\u0151\u0149\3\2\2\2\u0151\u014a\3\2"+
		"\2\2\u0151\u014b\3\2\2\2\u0151\u014f\3\2\2\2\u0151\u0150\3\2\2\2\u0152"+
		"\63\3\2\2\2\u0153\u0154\7\62\2\2\u0154\u0155\5\62\32\2\u0155\65\3\2\2"+
		"\2\u0156\u0157\7:\2\2\u0157\u0158\5<\37\2\u0158\u0159\7;\2\2\u0159\u015a"+
		"\5\62\32\2\u015a\67\3\2\2\2\u015b\u015c\7\30\2\2\u015c\u015d\5<\37\2\u015d"+
		"\u015f\7:\2\2\u015e\u0160\5\n\6\2\u015f\u015e\3\2\2\2\u015f\u0160\3\2"+
		"\2\2\u0160\u0161\3\2\2\2\u0161\u0162\7;\2\2\u01629\3\2\2\2\u0163\u016d"+
		"\7\31\2\2\u0164\u016d\7\32\2\2\u0165\u016d\7\33\2\2\u0166\u016d\7\34\2"+
		"\2\u0167\u0168\t\3\2\2\u0168\u0169\7:\2\2\u0169\u016a\5D#\2\u016a\u016b"+
		"\7;\2\2\u016b\u016d\3\2\2\2\u016c\u0163\3\2\2\2\u016c\u0164\3\2\2\2\u016c"+
		"\u0165\3\2\2\2\u016c\u0166\3\2\2\2\u016c\u0167\3\2\2\2\u016d;\3\2\2\2"+
		"\u016e\u017c\7\37\2\2\u016f\u017c\7 \2\2\u0170\u017c\7!\2\2\u0171\u017c"+
		"\7\"\2\2\u0172\u0173\7#\2\2\u0173\u0174\7$\2\2\u0174\u0175\5<\37\2\u0175"+
		"\u0176\7%\2\2\u0176\u017c\3\2\2\2\u0177\u017c\7&\2\2\u0178\u017c\7\'\2"+
		"\2\u0179\u017c\7(\2\2\u017a\u017c\7)\2\2\u017b\u016e\3\2\2\2\u017b\u016f"+
		"\3\2\2\2\u017b\u0170\3\2\2\2\u017b\u0171\3\2\2\2\u017b\u0172\3\2\2\2\u017b"+
		"\u0177\3\2\2\2\u017b\u0178\3\2\2\2\u017b\u0179\3\2\2\2\u017b\u017a\3\2"+
		"\2\2\u017c=\3\2\2\2\u017d\u0182\5H%\2\u017e\u0182\5@!\2\u017f\u0182\5"+
		"D#\2\u0180\u0182\5B\"\2\u0181\u017d\3\2\2\2\u0181\u017e\3\2\2\2\u0181"+
		"\u017f\3\2\2\2\u0181\u0180\3\2\2\2\u0182?\3\2\2\2\u0183\u0184\7\67\2\2"+
		"\u0184A\3\2\2\2\u0185\u0186\7:\2\2\u0186\u0187\5\"\22\2\u0187\u0188\7"+
		"\13\2\2\u0188\u0189\5\"\22\2\u0189\u018a\7\13\2\2\u018a\u018b\5\"\22\2"+
		"\u018b\u018c\7;\2\2\u018cC\3\2\2\2\u018d\u018e\7\66\2\2\u018eE\3\2\2\2"+
		"\u018f\u0190\7\65\2\2\u0190G\3\2\2\2\u0191\u0192\b%\1\2\u0192\u0193\5"+
		"J&\2\u0193\u019e\3\2\2\2\u0194\u0195\f\5\2\2\u0195\u0196\7\n\2\2\u0196"+
		"\u019d\5H%\6\u0197\u0198\f\4\2\2\u0198\u0199\7*\2\2\u0199\u019a\5.\30"+
		"\2\u019a\u019b\7+\2\2\u019b\u019d\3\2\2\2\u019c\u0194\3\2\2\2\u019c\u0197"+
		"\3\2\2\2\u019d\u01a0\3\2\2\2\u019e\u019c\3\2\2\2\u019e\u019f\3\2\2\2\u019f"+
		"I\3\2\2\2\u01a0\u019e\3\2\2\2\u01a1\u01a2\79\2\2\u01a2K\3\2\2\2)QV[_m"+
		"rw\u0080\u0089\u0091\u0099\u00a3\u00a7\u00b1\u00b5\u00bc\u00c7\u00d0\u00d6"+
		"\u00dd\u00e1\u00ed\u00f5\u00fa\u00fe\u0107\u0113\u011e\u0126\u012d\u0139"+
		"\u0144\u0151\u015f\u016c\u017b\u0181\u019c\u019e";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}