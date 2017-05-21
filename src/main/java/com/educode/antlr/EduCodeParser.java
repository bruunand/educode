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
		T__31=32, T__32=33, T__33=34, T__34=35, T__35=36, T__36=37, T__37=38, 
		T__38=39, T__39=40, T__40=41, T__41=42, T__42=43, T__43=44, T__44=45, 
		T__45=46, T__46=47, T__47=48, T__48=49, T__49=50, T__50=51, T__51=52, 
		T__52=53, T__53=54, T__54=55, T__55=56, T__56=57, T__57=58, T__58=59, 
		T__59=60, NEWLINE=61, NUMBER_LITERAL=62, STRING_LITERAL=63, UNTERMINATED_STRING_LITERAL=64, 
		BOOL_LITERAL=65, NULL_LITERAL=66, IDENTIFIER=67, LPAREN=68, RPAREN=69, 
		WHITESPACE=70, LINECOMMENT=71;
	public static final int
		RULE_start = 0, RULE_usings = 1, RULE_program = 2, RULE_event_definition = 3, 
		RULE_method_declaration = 4, RULE_argument_list = 5, RULE_parameter_list = 6, 
		RULE_parameter = 7, RULE_statement_list = 8, RULE_statement = 9, RULE_call_statement = 10, 
		RULE_iterative_statement = 11, RULE_break_statement = 12, RULE_continue_statement = 13, 
		RULE_return_statement = 14, RULE_repeat_statement = 15, RULE_if_statement = 16, 
		RULE_foreach_statement = 17, RULE_variable_declaration = 18, RULE_declarator = 19, 
		RULE_expression = 20, RULE_assignment_expression = 21, RULE_left_hand_side = 22, 
		RULE_logic_expression = 23, RULE_or_expression = 24, RULE_and_expression = 25, 
		RULE_equality_expression = 26, RULE_relative_expression = 27, RULE_arithmetic_expression = 28, 
		RULE_additive_expression = 29, RULE_multiplicative_expression = 30, RULE_factor = 31, 
		RULE_access = 32, RULE_field_access = 33, RULE_element_access = 34, RULE_method_access = 35, 
		RULE_subfactor = 36, RULE_parenthesis_expression = 37, RULE_method_call = 38, 
		RULE_type_cast = 39, RULE_object_instantiation = 40, RULE_event_type = 41, 
		RULE_data_type = 42, RULE_literal = 43, RULE_string_literal = 44, RULE_coordinate_literal = 45, 
		RULE_number_literal = 46, RULE_bool_literal = 47, RULE_null_literal = 48, 
		RULE_identifier = 49, RULE_end_of_line = 50;
	public static final String[] ruleNames = {
		"start", "usings", "program", "event_definition", "method_declaration", 
		"argument_list", "parameter_list", "parameter", "statement_list", "statement", 
		"call_statement", "iterative_statement", "break_statement", "continue_statement", 
		"return_statement", "repeat_statement", "if_statement", "foreach_statement", 
		"variable_declaration", "declarator", "expression", "assignment_expression", 
		"left_hand_side", "logic_expression", "or_expression", "and_expression", 
		"equality_expression", "relative_expression", "arithmetic_expression", 
		"additive_expression", "multiplicative_expression", "factor", "access", 
		"field_access", "element_access", "method_access", "subfactor", "parenthesis_expression", 
		"method_call", "type_cast", "object_instantiation", "event_type", "data_type", 
		"literal", "string_literal", "coordinate_literal", "number_literal", "bool_literal", 
		"null_literal", "identifier", "end_of_line"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'using'", "'program'", "'end program'", "'on event'", "'call'", 
		"'method'", "'returns'", "'end method'", "','", "'break'", "'continue'", 
		"'return'", "'repeat while'", "'end repeat'", "'if'", "'then'", "'else if'", 
		"'else'", "'end if'", "'foreach'", "'in'", "'end foreach'", "'='", "'+='", 
		"'-='", "'*='", "'/='", "'or'", "'and'", "'equals'", "'not equals'", "'greater than'", 
		"'less than'", "'greater than or equals'", "'less than or equals'", "'+'", 
		"'-'", "'/'", "'*'", "'modulo'", "'not'", "'.'", "'['", "']'", "'new'", 
		"'robotDeath'", "'robotAttacked'", "'entityDeath'", "'chatMessage'", "'stringMessageReceived'", 
		"'entityMessageReceived'", "'number'", "'bool'", "'coordinates'", "'string'", 
		"'Collection'", "'<'", "'>'", "'Entity'", "'Item'", null, null, null, 
		null, null, "'null'", null, "'('", "')'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, "NEWLINE", "NUMBER_LITERAL", "STRING_LITERAL", "UNTERMINATED_STRING_LITERAL", 
		"BOOL_LITERAL", "NULL_LITERAL", "IDENTIFIER", "LPAREN", "RPAREN", "WHITESPACE", 
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
	public static class StartContext extends ParserRuleContext {
		public UsingsContext ulist;
		public ProgramContext pr;
		public ProgramContext program() {
			return getRuleContext(ProgramContext.class,0);
		}
		public List<End_of_lineContext> end_of_line() {
			return getRuleContexts(End_of_lineContext.class);
		}
		public End_of_lineContext end_of_line(int i) {
			return getRuleContext(End_of_lineContext.class,i);
		}
		public UsingsContext usings() {
			return getRuleContext(UsingsContext.class,0);
		}
		public StartContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_start; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EduCodeVisitor ) return ((EduCodeVisitor<? extends T>)visitor).visitStart(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StartContext start() throws RecognitionException {
		StartContext _localctx = new StartContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_start);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(103);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__0) {
				{
				setState(102);
				((StartContext)_localctx).ulist = usings();
				}
			}

			setState(106); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(105);
				end_of_line();
				}
				}
				setState(108); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==NEWLINE );
			setState(110);
			((StartContext)_localctx).pr = program();
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

	public static class UsingsContext extends ParserRuleContext {
		public IdentifierContext identifier;
		public List<IdentifierContext> id = new ArrayList<IdentifierContext>();
		public List<IdentifierContext> identifier() {
			return getRuleContexts(IdentifierContext.class);
		}
		public IdentifierContext identifier(int i) {
			return getRuleContext(IdentifierContext.class,i);
		}
		public List<End_of_lineContext> end_of_line() {
			return getRuleContexts(End_of_lineContext.class);
		}
		public End_of_lineContext end_of_line(int i) {
			return getRuleContext(End_of_lineContext.class,i);
		}
		public UsingsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_usings; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EduCodeVisitor ) return ((EduCodeVisitor<? extends T>)visitor).visitUsings(this);
			else return visitor.visitChildren(this);
		}
	}

	public final UsingsContext usings() throws RecognitionException {
		UsingsContext _localctx = new UsingsContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_usings);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(112);
			match(T__0);
			setState(113);
			((UsingsContext)_localctx).identifier = identifier();
			((UsingsContext)_localctx).id.add(((UsingsContext)_localctx).identifier);
			setState(115); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(114);
					end_of_line();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(117); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
			setState(128);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__0) {
				{
				{
				setState(119);
				match(T__0);
				setState(120);
				((UsingsContext)_localctx).identifier = identifier();
				((UsingsContext)_localctx).id.add(((UsingsContext)_localctx).identifier);
				setState(122); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(121);
						end_of_line();
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(124); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				}
				}
				setState(130);
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

	public static class ProgramContext extends ParserRuleContext {
		public IdentifierContext id;
		public Event_definitionContext event_definition;
		public List<Event_definitionContext> el = new ArrayList<Event_definitionContext>();
		public Method_declarationContext method_declaration;
		public List<Method_declarationContext> ml = new ArrayList<Method_declarationContext>();
		public Variable_declarationContext variable_declaration;
		public List<Variable_declarationContext> vl = new ArrayList<Variable_declarationContext>();
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public List<End_of_lineContext> end_of_line() {
			return getRuleContexts(End_of_lineContext.class);
		}
		public End_of_lineContext end_of_line(int i) {
			return getRuleContext(End_of_lineContext.class,i);
		}
		public List<Event_definitionContext> event_definition() {
			return getRuleContexts(Event_definitionContext.class);
		}
		public Event_definitionContext event_definition(int i) {
			return getRuleContext(Event_definitionContext.class,i);
		}
		public List<Method_declarationContext> method_declaration() {
			return getRuleContexts(Method_declarationContext.class);
		}
		public Method_declarationContext method_declaration(int i) {
			return getRuleContext(Method_declarationContext.class,i);
		}
		public List<Variable_declarationContext> variable_declaration() {
			return getRuleContexts(Variable_declarationContext.class);
		}
		public Variable_declarationContext variable_declaration(int i) {
			return getRuleContext(Variable_declarationContext.class,i);
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
		enterRule(_localctx, 4, RULE_program);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(131);
			match(T__1);
			setState(132);
			((ProgramContext)_localctx).id = identifier();
			setState(134); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(133);
				end_of_line();
				}
				}
				setState(136); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==NEWLINE );
			setState(150);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__3) | (1L << T__5) | (1L << T__51) | (1L << T__52) | (1L << T__53) | (1L << T__54) | (1L << T__55) | (1L << T__58) | (1L << T__59))) != 0)) {
				{
				{
				setState(141);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__3:
					{
					setState(138);
					((ProgramContext)_localctx).event_definition = event_definition();
					((ProgramContext)_localctx).el.add(((ProgramContext)_localctx).event_definition);
					}
					break;
				case T__5:
					{
					setState(139);
					((ProgramContext)_localctx).method_declaration = method_declaration();
					((ProgramContext)_localctx).ml.add(((ProgramContext)_localctx).method_declaration);
					}
					break;
				case T__51:
				case T__52:
				case T__53:
				case T__54:
				case T__55:
				case T__58:
				case T__59:
					{
					setState(140);
					((ProgramContext)_localctx).variable_declaration = variable_declaration();
					((ProgramContext)_localctx).vl.add(((ProgramContext)_localctx).variable_declaration);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(144); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(143);
					end_of_line();
					}
					}
					setState(146); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==NEWLINE );
				}
				}
				setState(152);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(153);
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

	public static class Event_definitionContext extends ParserRuleContext {
		public Event_typeContext event;
		public IdentifierContext id;
		public Event_typeContext event_type() {
			return getRuleContext(Event_typeContext.class,0);
		}
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public Event_definitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_event_definition; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EduCodeVisitor ) return ((EduCodeVisitor<? extends T>)visitor).visitEvent_definition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Event_definitionContext event_definition() throws RecognitionException {
		Event_definitionContext _localctx = new Event_definitionContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_event_definition);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(155);
			match(T__3);
			setState(156);
			((Event_definitionContext)_localctx).event = event_type();
			setState(157);
			match(T__4);
			setState(158);
			((Event_definitionContext)_localctx).id = identifier();
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

	public static class Method_declarationContext extends ParserRuleContext {
		public IdentifierContext id;
		public Parameter_listContext params;
		public Data_typeContext type;
		public Statement_listContext body;
		public TerminalNode LPAREN() { return getToken(EduCodeParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(EduCodeParser.RPAREN, 0); }
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public Statement_listContext statement_list() {
			return getRuleContext(Statement_listContext.class,0);
		}
		public List<End_of_lineContext> end_of_line() {
			return getRuleContexts(End_of_lineContext.class);
		}
		public End_of_lineContext end_of_line(int i) {
			return getRuleContext(End_of_lineContext.class,i);
		}
		public Parameter_listContext parameter_list() {
			return getRuleContext(Parameter_listContext.class,0);
		}
		public Data_typeContext data_type() {
			return getRuleContext(Data_typeContext.class,0);
		}
		public Method_declarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_method_declaration; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EduCodeVisitor ) return ((EduCodeVisitor<? extends T>)visitor).visitMethod_declaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Method_declarationContext method_declaration() throws RecognitionException {
		Method_declarationContext _localctx = new Method_declarationContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_method_declaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(160);
			match(T__5);
			setState(161);
			((Method_declarationContext)_localctx).id = identifier();
			setState(162);
			match(LPAREN);
			setState(164);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__51) | (1L << T__52) | (1L << T__53) | (1L << T__54) | (1L << T__55) | (1L << T__58) | (1L << T__59))) != 0)) {
				{
				setState(163);
				((Method_declarationContext)_localctx).params = parameter_list();
				}
			}

			setState(166);
			match(RPAREN);
			setState(169);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__6) {
				{
				setState(167);
				match(T__6);
				setState(168);
				((Method_declarationContext)_localctx).type = data_type();
				}
			}

			setState(172); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(171);
				end_of_line();
				}
				}
				setState(174); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==NEWLINE );
			setState(176);
			((Method_declarationContext)_localctx).body = statement_list();
			setState(177);
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

	public static class Argument_listContext extends ParserRuleContext {
		public Logic_expressionContext logic_expression;
		public List<Logic_expressionContext> exprs = new ArrayList<Logic_expressionContext>();
		public List<Logic_expressionContext> logic_expression() {
			return getRuleContexts(Logic_expressionContext.class);
		}
		public Logic_expressionContext logic_expression(int i) {
			return getRuleContext(Logic_expressionContext.class,i);
		}
		public Argument_listContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_argument_list; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EduCodeVisitor ) return ((EduCodeVisitor<? extends T>)visitor).visitArgument_list(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Argument_listContext argument_list() throws RecognitionException {
		Argument_listContext _localctx = new Argument_listContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_argument_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(179);
			((Argument_listContext)_localctx).logic_expression = logic_expression();
			((Argument_listContext)_localctx).exprs.add(((Argument_listContext)_localctx).logic_expression);
			setState(184);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__8) {
				{
				{
				setState(180);
				match(T__8);
				setState(181);
				((Argument_listContext)_localctx).logic_expression = logic_expression();
				((Argument_listContext)_localctx).exprs.add(((Argument_listContext)_localctx).logic_expression);
				}
				}
				setState(186);
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

	public static class Parameter_listContext extends ParserRuleContext {
		public ParameterContext parameter;
		public List<ParameterContext> params = new ArrayList<ParameterContext>();
		public List<ParameterContext> parameter() {
			return getRuleContexts(ParameterContext.class);
		}
		public ParameterContext parameter(int i) {
			return getRuleContext(ParameterContext.class,i);
		}
		public Parameter_listContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parameter_list; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EduCodeVisitor ) return ((EduCodeVisitor<? extends T>)visitor).visitParameter_list(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Parameter_listContext parameter_list() throws RecognitionException {
		Parameter_listContext _localctx = new Parameter_listContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_parameter_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(187);
			((Parameter_listContext)_localctx).parameter = parameter();
			((Parameter_listContext)_localctx).params.add(((Parameter_listContext)_localctx).parameter);
			setState(192);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__8) {
				{
				{
				setState(188);
				match(T__8);
				setState(189);
				((Parameter_listContext)_localctx).parameter = parameter();
				((Parameter_listContext)_localctx).params.add(((Parameter_listContext)_localctx).parameter);
				}
				}
				setState(194);
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

	public static class ParameterContext extends ParserRuleContext {
		public Data_typeContext type;
		public IdentifierContext id;
		public Data_typeContext data_type() {
			return getRuleContext(Data_typeContext.class,0);
		}
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public ParameterContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parameter; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EduCodeVisitor ) return ((EduCodeVisitor<? extends T>)visitor).visitParameter(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParameterContext parameter() throws RecognitionException {
		ParameterContext _localctx = new ParameterContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_parameter);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(195);
			((ParameterContext)_localctx).type = data_type();
			setState(196);
			((ParameterContext)_localctx).id = identifier();
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

	public static class Statement_listContext extends ParserRuleContext {
		public StatementContext statement;
		public List<StatementContext> statements = new ArrayList<StatementContext>();
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public List<End_of_lineContext> end_of_line() {
			return getRuleContexts(End_of_lineContext.class);
		}
		public End_of_lineContext end_of_line(int i) {
			return getRuleContext(End_of_lineContext.class,i);
		}
		public Statement_listContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement_list; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EduCodeVisitor ) return ((EduCodeVisitor<? extends T>)visitor).visitStatement_list(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Statement_listContext statement_list() throws RecognitionException {
		Statement_listContext _localctx = new Statement_listContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_statement_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(206);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (((((_la - 10)) & ~0x3f) == 0 && ((1L << (_la - 10)) & ((1L << (T__9 - 10)) | (1L << (T__10 - 10)) | (1L << (T__11 - 10)) | (1L << (T__12 - 10)) | (1L << (T__14 - 10)) | (1L << (T__19 - 10)) | (1L << (T__51 - 10)) | (1L << (T__52 - 10)) | (1L << (T__53 - 10)) | (1L << (T__54 - 10)) | (1L << (T__55 - 10)) | (1L << (T__58 - 10)) | (1L << (T__59 - 10)) | (1L << (IDENTIFIER - 10)) | (1L << (LPAREN - 10)))) != 0)) {
				{
				{
				setState(198);
				((Statement_listContext)_localctx).statement = statement();
				((Statement_listContext)_localctx).statements.add(((Statement_listContext)_localctx).statement);
				setState(200); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(199);
					end_of_line();
					}
					}
					setState(202); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==NEWLINE );
				}
				}
				setState(208);
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

	public static class StatementContext extends ParserRuleContext {
		public Call_statementContext call_statement() {
			return getRuleContext(Call_statementContext.class,0);
		}
		public Assignment_expressionContext assignment_expression() {
			return getRuleContext(Assignment_expressionContext.class,0);
		}
		public Variable_declarationContext variable_declaration() {
			return getRuleContext(Variable_declarationContext.class,0);
		}
		public If_statementContext if_statement() {
			return getRuleContext(If_statementContext.class,0);
		}
		public Iterative_statementContext iterative_statement() {
			return getRuleContext(Iterative_statementContext.class,0);
		}
		public Return_statementContext return_statement() {
			return getRuleContext(Return_statementContext.class,0);
		}
		public Break_statementContext break_statement() {
			return getRuleContext(Break_statementContext.class,0);
		}
		public Continue_statementContext continue_statement() {
			return getRuleContext(Continue_statementContext.class,0);
		}
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EduCodeVisitor ) return ((EduCodeVisitor<? extends T>)visitor).visitStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_statement);
		try {
			setState(217);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(209);
				call_statement();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(210);
				assignment_expression();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(211);
				variable_declaration();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(212);
				if_statement();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(213);
				iterative_statement();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(214);
				return_statement();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(215);
				break_statement();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(216);
				continue_statement();
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

	public static class Call_statementContext extends ParserRuleContext {
		public Method_callContext method_call() {
			return getRuleContext(Method_callContext.class,0);
		}
		public AccessContext access() {
			return getRuleContext(AccessContext.class,0);
		}
		public Method_accessContext method_access() {
			return getRuleContext(Method_accessContext.class,0);
		}
		public Call_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_call_statement; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EduCodeVisitor ) return ((EduCodeVisitor<? extends T>)visitor).visitCall_statement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Call_statementContext call_statement() throws RecognitionException {
		Call_statementContext _localctx = new Call_statementContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_call_statement);
		try {
			setState(223);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,17,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(219);
				method_call();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(220);
				access(0);
				setState(221);
				method_access();
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

	public static class Iterative_statementContext extends ParserRuleContext {
		public Repeat_statementContext repeat_statement() {
			return getRuleContext(Repeat_statementContext.class,0);
		}
		public Foreach_statementContext foreach_statement() {
			return getRuleContext(Foreach_statementContext.class,0);
		}
		public Iterative_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_iterative_statement; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EduCodeVisitor ) return ((EduCodeVisitor<? extends T>)visitor).visitIterative_statement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Iterative_statementContext iterative_statement() throws RecognitionException {
		Iterative_statementContext _localctx = new Iterative_statementContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_iterative_statement);
		try {
			setState(227);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__12:
				enterOuterAlt(_localctx, 1);
				{
				setState(225);
				repeat_statement();
				}
				break;
			case T__19:
				enterOuterAlt(_localctx, 2);
				{
				setState(226);
				foreach_statement();
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

	public static class Break_statementContext extends ParserRuleContext {
		public Break_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_break_statement; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EduCodeVisitor ) return ((EduCodeVisitor<? extends T>)visitor).visitBreak_statement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Break_statementContext break_statement() throws RecognitionException {
		Break_statementContext _localctx = new Break_statementContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_break_statement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(229);
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

	public static class Continue_statementContext extends ParserRuleContext {
		public Continue_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_continue_statement; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EduCodeVisitor ) return ((EduCodeVisitor<? extends T>)visitor).visitContinue_statement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Continue_statementContext continue_statement() throws RecognitionException {
		Continue_statementContext _localctx = new Continue_statementContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_continue_statement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(231);
			match(T__10);
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

	public static class Return_statementContext extends ParserRuleContext {
		public Logic_expressionContext expr;
		public Logic_expressionContext logic_expression() {
			return getRuleContext(Logic_expressionContext.class,0);
		}
		public Return_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_return_statement; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EduCodeVisitor ) return ((EduCodeVisitor<? extends T>)visitor).visitReturn_statement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Return_statementContext return_statement() throws RecognitionException {
		Return_statementContext _localctx = new Return_statementContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_return_statement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(233);
			match(T__11);
			setState(235);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((((_la - 37)) & ~0x3f) == 0 && ((1L << (_la - 37)) & ((1L << (T__36 - 37)) | (1L << (T__40 - 37)) | (1L << (T__44 - 37)) | (1L << (NUMBER_LITERAL - 37)) | (1L << (STRING_LITERAL - 37)) | (1L << (BOOL_LITERAL - 37)) | (1L << (NULL_LITERAL - 37)) | (1L << (IDENTIFIER - 37)) | (1L << (LPAREN - 37)))) != 0)) {
				{
				setState(234);
				((Return_statementContext)_localctx).expr = logic_expression();
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

	public static class Repeat_statementContext extends ParserRuleContext {
		public Logic_expressionContext predicate;
		public Statement_listContext body;
		public Logic_expressionContext logic_expression() {
			return getRuleContext(Logic_expressionContext.class,0);
		}
		public Statement_listContext statement_list() {
			return getRuleContext(Statement_listContext.class,0);
		}
		public List<End_of_lineContext> end_of_line() {
			return getRuleContexts(End_of_lineContext.class);
		}
		public End_of_lineContext end_of_line(int i) {
			return getRuleContext(End_of_lineContext.class,i);
		}
		public Repeat_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_repeat_statement; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EduCodeVisitor ) return ((EduCodeVisitor<? extends T>)visitor).visitRepeat_statement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Repeat_statementContext repeat_statement() throws RecognitionException {
		Repeat_statementContext _localctx = new Repeat_statementContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_repeat_statement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(237);
			match(T__12);
			setState(238);
			((Repeat_statementContext)_localctx).predicate = logic_expression();
			setState(240); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(239);
				end_of_line();
				}
				}
				setState(242); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==NEWLINE );
			setState(244);
			((Repeat_statementContext)_localctx).body = statement_list();
			setState(245);
			match(T__13);
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

	public static class If_statementContext extends ParserRuleContext {
		public Logic_expressionContext logic_expression;
		public List<Logic_expressionContext> predicates = new ArrayList<Logic_expressionContext>();
		public Statement_listContext statement_list;
		public List<Statement_listContext> bodies = new ArrayList<Statement_listContext>();
		public Statement_listContext elseBody;
		public List<Logic_expressionContext> logic_expression() {
			return getRuleContexts(Logic_expressionContext.class);
		}
		public Logic_expressionContext logic_expression(int i) {
			return getRuleContext(Logic_expressionContext.class,i);
		}
		public List<Statement_listContext> statement_list() {
			return getRuleContexts(Statement_listContext.class);
		}
		public Statement_listContext statement_list(int i) {
			return getRuleContext(Statement_listContext.class,i);
		}
		public List<End_of_lineContext> end_of_line() {
			return getRuleContexts(End_of_lineContext.class);
		}
		public End_of_lineContext end_of_line(int i) {
			return getRuleContext(End_of_lineContext.class,i);
		}
		public If_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_if_statement; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EduCodeVisitor ) return ((EduCodeVisitor<? extends T>)visitor).visitIf_statement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final If_statementContext if_statement() throws RecognitionException {
		If_statementContext _localctx = new If_statementContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_if_statement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(247);
			match(T__14);
			setState(248);
			((If_statementContext)_localctx).logic_expression = logic_expression();
			((If_statementContext)_localctx).predicates.add(((If_statementContext)_localctx).logic_expression);
			setState(249);
			match(T__15);
			setState(251); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(250);
				end_of_line();
				}
				}
				setState(253); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==NEWLINE );
			setState(255);
			((If_statementContext)_localctx).statement_list = statement_list();
			((If_statementContext)_localctx).bodies.add(((If_statementContext)_localctx).statement_list);
			setState(268);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__16) {
				{
				{
				setState(256);
				match(T__16);
				setState(257);
				((If_statementContext)_localctx).logic_expression = logic_expression();
				((If_statementContext)_localctx).predicates.add(((If_statementContext)_localctx).logic_expression);
				setState(258);
				match(T__15);
				setState(260); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(259);
					end_of_line();
					}
					}
					setState(262); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==NEWLINE );
				setState(264);
				((If_statementContext)_localctx).statement_list = statement_list();
				((If_statementContext)_localctx).bodies.add(((If_statementContext)_localctx).statement_list);
				}
				}
				setState(270);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(279);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__17) {
				{
				setState(271);
				match(T__17);
				setState(273); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(272);
					end_of_line();
					}
					}
					setState(275); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==NEWLINE );
				setState(277);
				((If_statementContext)_localctx).elseBody = statement_list();
				}
			}

			setState(281);
			match(T__18);
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

	public static class Foreach_statementContext extends ParserRuleContext {
		public Data_typeContext type;
		public IdentifierContext id;
		public Logic_expressionContext expr;
		public Statement_listContext body;
		public Data_typeContext data_type() {
			return getRuleContext(Data_typeContext.class,0);
		}
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public Logic_expressionContext logic_expression() {
			return getRuleContext(Logic_expressionContext.class,0);
		}
		public Statement_listContext statement_list() {
			return getRuleContext(Statement_listContext.class,0);
		}
		public List<End_of_lineContext> end_of_line() {
			return getRuleContexts(End_of_lineContext.class);
		}
		public End_of_lineContext end_of_line(int i) {
			return getRuleContext(End_of_lineContext.class,i);
		}
		public Foreach_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_foreach_statement; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EduCodeVisitor ) return ((EduCodeVisitor<? extends T>)visitor).visitForeach_statement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Foreach_statementContext foreach_statement() throws RecognitionException {
		Foreach_statementContext _localctx = new Foreach_statementContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_foreach_statement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(283);
			match(T__19);
			setState(284);
			((Foreach_statementContext)_localctx).type = data_type();
			setState(285);
			((Foreach_statementContext)_localctx).id = identifier();
			setState(286);
			match(T__20);
			setState(287);
			((Foreach_statementContext)_localctx).expr = logic_expression();
			setState(289); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(288);
				end_of_line();
				}
				}
				setState(291); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==NEWLINE );
			setState(293);
			((Foreach_statementContext)_localctx).body = statement_list();
			setState(294);
			match(T__21);
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

	public static class Variable_declarationContext extends ParserRuleContext {
		public Data_typeContext type;
		public DeclaratorContext declarator;
		public List<DeclaratorContext> decls = new ArrayList<DeclaratorContext>();
		public Data_typeContext data_type() {
			return getRuleContext(Data_typeContext.class,0);
		}
		public List<DeclaratorContext> declarator() {
			return getRuleContexts(DeclaratorContext.class);
		}
		public DeclaratorContext declarator(int i) {
			return getRuleContext(DeclaratorContext.class,i);
		}
		public Variable_declarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variable_declaration; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EduCodeVisitor ) return ((EduCodeVisitor<? extends T>)visitor).visitVariable_declaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Variable_declarationContext variable_declaration() throws RecognitionException {
		Variable_declarationContext _localctx = new Variable_declarationContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_variable_declaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(296);
			((Variable_declarationContext)_localctx).type = data_type();
			setState(297);
			((Variable_declarationContext)_localctx).declarator = declarator();
			((Variable_declarationContext)_localctx).decls.add(((Variable_declarationContext)_localctx).declarator);
			setState(302);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__8) {
				{
				{
				setState(298);
				match(T__8);
				setState(299);
				((Variable_declarationContext)_localctx).declarator = declarator();
				((Variable_declarationContext)_localctx).decls.add(((Variable_declarationContext)_localctx).declarator);
				}
				}
				setState(304);
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

	public static class DeclaratorContext extends ParserRuleContext {
		public IdentifierContext id;
		public ExpressionContext expr;
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public DeclaratorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declarator; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EduCodeVisitor ) return ((EduCodeVisitor<? extends T>)visitor).visitDeclarator(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DeclaratorContext declarator() throws RecognitionException {
		DeclaratorContext _localctx = new DeclaratorContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_declarator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(305);
			((DeclaratorContext)_localctx).id = identifier();
			setState(308);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__22) {
				{
				setState(306);
				match(T__22);
				setState(307);
				((DeclaratorContext)_localctx).expr = expression();
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

	public static class ExpressionContext extends ParserRuleContext {
		public Assignment_expressionContext assignment_expression() {
			return getRuleContext(Assignment_expressionContext.class,0);
		}
		public Logic_expressionContext logic_expression() {
			return getRuleContext(Logic_expressionContext.class,0);
		}
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EduCodeVisitor ) return ((EduCodeVisitor<? extends T>)visitor).visitExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		ExpressionContext _localctx = new ExpressionContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_expression);
		try {
			setState(312);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,29,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(310);
				assignment_expression();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(311);
				logic_expression();
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

	public static class Assignment_expressionContext extends ParserRuleContext {
		public Left_hand_sideContext lhs;
		public Token op;
		public ExpressionContext rhs;
		public Left_hand_sideContext left_hand_side() {
			return getRuleContext(Left_hand_sideContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public Assignment_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignment_expression; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EduCodeVisitor ) return ((EduCodeVisitor<? extends T>)visitor).visitAssignment_expression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Assignment_expressionContext assignment_expression() throws RecognitionException {
		Assignment_expressionContext _localctx = new Assignment_expressionContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_assignment_expression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(314);
			((Assignment_expressionContext)_localctx).lhs = left_hand_side();
			setState(315);
			((Assignment_expressionContext)_localctx).op = _input.LT(1);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__22) | (1L << T__23) | (1L << T__24) | (1L << T__25) | (1L << T__26))) != 0)) ) {
				((Assignment_expressionContext)_localctx).op = (Token)_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(316);
			((Assignment_expressionContext)_localctx).rhs = expression();
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

	public static class Left_hand_sideContext extends ParserRuleContext {
		public IdentifierContext id;
		public AccessContext acc;
		public Element_accessContext element;
		public Field_accessContext field;
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public AccessContext access() {
			return getRuleContext(AccessContext.class,0);
		}
		public Element_accessContext element_access() {
			return getRuleContext(Element_accessContext.class,0);
		}
		public Field_accessContext field_access() {
			return getRuleContext(Field_accessContext.class,0);
		}
		public Left_hand_sideContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_left_hand_side; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EduCodeVisitor ) return ((EduCodeVisitor<? extends T>)visitor).visitLeft_hand_side(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Left_hand_sideContext left_hand_side() throws RecognitionException {
		Left_hand_sideContext _localctx = new Left_hand_sideContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_left_hand_side);
		try {
			setState(325);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,30,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(318);
				((Left_hand_sideContext)_localctx).id = identifier();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(319);
				((Left_hand_sideContext)_localctx).acc = access(0);
				setState(320);
				((Left_hand_sideContext)_localctx).element = element_access();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(322);
				((Left_hand_sideContext)_localctx).acc = access(0);
				setState(323);
				((Left_hand_sideContext)_localctx).field = field_access();
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

	public static class Logic_expressionContext extends ParserRuleContext {
		public Or_expressionContext or_expression() {
			return getRuleContext(Or_expressionContext.class,0);
		}
		public Logic_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_logic_expression; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EduCodeVisitor ) return ((EduCodeVisitor<? extends T>)visitor).visitLogic_expression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Logic_expressionContext logic_expression() throws RecognitionException {
		Logic_expressionContext _localctx = new Logic_expressionContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_logic_expression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(327);
			or_expression(0);
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

	public static class Or_expressionContext extends ParserRuleContext {
		public Or_expressionContext left;
		public And_expressionContext right;
		public Token op;
		public And_expressionContext and_expression() {
			return getRuleContext(And_expressionContext.class,0);
		}
		public Or_expressionContext or_expression() {
			return getRuleContext(Or_expressionContext.class,0);
		}
		public Or_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_or_expression; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EduCodeVisitor ) return ((EduCodeVisitor<? extends T>)visitor).visitOr_expression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Or_expressionContext or_expression() throws RecognitionException {
		return or_expression(0);
	}

	private Or_expressionContext or_expression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		Or_expressionContext _localctx = new Or_expressionContext(_ctx, _parentState);
		Or_expressionContext _prevctx = _localctx;
		int _startState = 48;
		enterRecursionRule(_localctx, 48, RULE_or_expression, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(330);
			((Or_expressionContext)_localctx).right = and_expression(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(337);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,31,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new Or_expressionContext(_parentctx, _parentState);
					_localctx.left = _prevctx;
					_localctx.left = _prevctx;
					pushNewRecursionContext(_localctx, _startState, RULE_or_expression);
					setState(332);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(333);
					((Or_expressionContext)_localctx).op = match(T__27);
					setState(334);
					((Or_expressionContext)_localctx).right = and_expression(0);
					}
					} 
				}
				setState(339);
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

	public static class And_expressionContext extends ParserRuleContext {
		public And_expressionContext left;
		public Equality_expressionContext right;
		public Token op;
		public Equality_expressionContext equality_expression() {
			return getRuleContext(Equality_expressionContext.class,0);
		}
		public And_expressionContext and_expression() {
			return getRuleContext(And_expressionContext.class,0);
		}
		public And_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_and_expression; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EduCodeVisitor ) return ((EduCodeVisitor<? extends T>)visitor).visitAnd_expression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final And_expressionContext and_expression() throws RecognitionException {
		return and_expression(0);
	}

	private And_expressionContext and_expression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		And_expressionContext _localctx = new And_expressionContext(_ctx, _parentState);
		And_expressionContext _prevctx = _localctx;
		int _startState = 50;
		enterRecursionRule(_localctx, 50, RULE_and_expression, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(341);
			((And_expressionContext)_localctx).right = equality_expression(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(348);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,32,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new And_expressionContext(_parentctx, _parentState);
					_localctx.left = _prevctx;
					_localctx.left = _prevctx;
					pushNewRecursionContext(_localctx, _startState, RULE_and_expression);
					setState(343);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(344);
					((And_expressionContext)_localctx).op = match(T__28);
					setState(345);
					((And_expressionContext)_localctx).right = equality_expression(0);
					}
					} 
				}
				setState(350);
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

	public static class Equality_expressionContext extends ParserRuleContext {
		public Equality_expressionContext left;
		public Relative_expressionContext right;
		public Token op;
		public Relative_expressionContext relative_expression() {
			return getRuleContext(Relative_expressionContext.class,0);
		}
		public Equality_expressionContext equality_expression() {
			return getRuleContext(Equality_expressionContext.class,0);
		}
		public Equality_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_equality_expression; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EduCodeVisitor ) return ((EduCodeVisitor<? extends T>)visitor).visitEquality_expression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Equality_expressionContext equality_expression() throws RecognitionException {
		return equality_expression(0);
	}

	private Equality_expressionContext equality_expression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		Equality_expressionContext _localctx = new Equality_expressionContext(_ctx, _parentState);
		Equality_expressionContext _prevctx = _localctx;
		int _startState = 52;
		enterRecursionRule(_localctx, 52, RULE_equality_expression, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(352);
			((Equality_expressionContext)_localctx).right = relative_expression();
			}
			_ctx.stop = _input.LT(-1);
			setState(359);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,33,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new Equality_expressionContext(_parentctx, _parentState);
					_localctx.left = _prevctx;
					_localctx.left = _prevctx;
					pushNewRecursionContext(_localctx, _startState, RULE_equality_expression);
					setState(354);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(355);
					((Equality_expressionContext)_localctx).op = _input.LT(1);
					_la = _input.LA(1);
					if ( !(_la==T__29 || _la==T__30) ) {
						((Equality_expressionContext)_localctx).op = (Token)_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					setState(356);
					((Equality_expressionContext)_localctx).right = relative_expression();
					}
					} 
				}
				setState(361);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,33,_ctx);
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

	public static class Relative_expressionContext extends ParserRuleContext {
		public Arithmetic_expressionContext left;
		public Token op;
		public Arithmetic_expressionContext right;
		public List<Arithmetic_expressionContext> arithmetic_expression() {
			return getRuleContexts(Arithmetic_expressionContext.class);
		}
		public Arithmetic_expressionContext arithmetic_expression(int i) {
			return getRuleContext(Arithmetic_expressionContext.class,i);
		}
		public Relative_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_relative_expression; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EduCodeVisitor ) return ((EduCodeVisitor<? extends T>)visitor).visitRelative_expression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Relative_expressionContext relative_expression() throws RecognitionException {
		Relative_expressionContext _localctx = new Relative_expressionContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_relative_expression);
		int _la;
		try {
			setState(367);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,34,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(362);
				((Relative_expressionContext)_localctx).left = arithmetic_expression();
				setState(363);
				((Relative_expressionContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__31) | (1L << T__32) | (1L << T__33) | (1L << T__34))) != 0)) ) {
					((Relative_expressionContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(364);
				((Relative_expressionContext)_localctx).right = arithmetic_expression();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(366);
				((Relative_expressionContext)_localctx).right = arithmetic_expression();
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

	public static class Arithmetic_expressionContext extends ParserRuleContext {
		public Additive_expressionContext additive_expression() {
			return getRuleContext(Additive_expressionContext.class,0);
		}
		public Arithmetic_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arithmetic_expression; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EduCodeVisitor ) return ((EduCodeVisitor<? extends T>)visitor).visitArithmetic_expression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Arithmetic_expressionContext arithmetic_expression() throws RecognitionException {
		Arithmetic_expressionContext _localctx = new Arithmetic_expressionContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_arithmetic_expression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(369);
			additive_expression(0);
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

	public static class Additive_expressionContext extends ParserRuleContext {
		public Additive_expressionContext left;
		public Multiplicative_expressionContext right;
		public Token op;
		public Multiplicative_expressionContext multiplicative_expression() {
			return getRuleContext(Multiplicative_expressionContext.class,0);
		}
		public Additive_expressionContext additive_expression() {
			return getRuleContext(Additive_expressionContext.class,0);
		}
		public Additive_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_additive_expression; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EduCodeVisitor ) return ((EduCodeVisitor<? extends T>)visitor).visitAdditive_expression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Additive_expressionContext additive_expression() throws RecognitionException {
		return additive_expression(0);
	}

	private Additive_expressionContext additive_expression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		Additive_expressionContext _localctx = new Additive_expressionContext(_ctx, _parentState);
		Additive_expressionContext _prevctx = _localctx;
		int _startState = 58;
		enterRecursionRule(_localctx, 58, RULE_additive_expression, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(372);
			((Additive_expressionContext)_localctx).right = multiplicative_expression(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(379);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,35,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new Additive_expressionContext(_parentctx, _parentState);
					_localctx.left = _prevctx;
					_localctx.left = _prevctx;
					pushNewRecursionContext(_localctx, _startState, RULE_additive_expression);
					setState(374);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(375);
					((Additive_expressionContext)_localctx).op = _input.LT(1);
					_la = _input.LA(1);
					if ( !(_la==T__35 || _la==T__36) ) {
						((Additive_expressionContext)_localctx).op = (Token)_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					setState(376);
					((Additive_expressionContext)_localctx).right = multiplicative_expression(0);
					}
					} 
				}
				setState(381);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,35,_ctx);
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

	public static class Multiplicative_expressionContext extends ParserRuleContext {
		public Multiplicative_expressionContext left;
		public FactorContext right;
		public Token op;
		public FactorContext factor() {
			return getRuleContext(FactorContext.class,0);
		}
		public Multiplicative_expressionContext multiplicative_expression() {
			return getRuleContext(Multiplicative_expressionContext.class,0);
		}
		public Multiplicative_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_multiplicative_expression; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EduCodeVisitor ) return ((EduCodeVisitor<? extends T>)visitor).visitMultiplicative_expression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Multiplicative_expressionContext multiplicative_expression() throws RecognitionException {
		return multiplicative_expression(0);
	}

	private Multiplicative_expressionContext multiplicative_expression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		Multiplicative_expressionContext _localctx = new Multiplicative_expressionContext(_ctx, _parentState);
		Multiplicative_expressionContext _prevctx = _localctx;
		int _startState = 60;
		enterRecursionRule(_localctx, 60, RULE_multiplicative_expression, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(383);
			((Multiplicative_expressionContext)_localctx).right = factor();
			}
			_ctx.stop = _input.LT(-1);
			setState(390);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,36,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new Multiplicative_expressionContext(_parentctx, _parentState);
					_localctx.left = _prevctx;
					_localctx.left = _prevctx;
					pushNewRecursionContext(_localctx, _startState, RULE_multiplicative_expression);
					setState(385);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(386);
					((Multiplicative_expressionContext)_localctx).op = _input.LT(1);
					_la = _input.LA(1);
					if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__37) | (1L << T__38) | (1L << T__39))) != 0)) ) {
						((Multiplicative_expressionContext)_localctx).op = (Token)_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					setState(387);
					((Multiplicative_expressionContext)_localctx).right = factor();
					}
					} 
				}
				setState(392);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,36,_ctx);
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
		public Token op;
		public LiteralContext literal() {
			return getRuleContext(LiteralContext.class,0);
		}
		public Object_instantiationContext object_instantiation() {
			return getRuleContext(Object_instantiationContext.class,0);
		}
		public FactorContext factor() {
			return getRuleContext(FactorContext.class,0);
		}
		public Type_castContext type_cast() {
			return getRuleContext(Type_castContext.class,0);
		}
		public AccessContext access() {
			return getRuleContext(AccessContext.class,0);
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
		enterRule(_localctx, 62, RULE_factor);
		int _la;
		try {
			setState(399);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,37,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(393);
				literal();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(394);
				object_instantiation();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(395);
				((FactorContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==T__36 || _la==T__40) ) {
					((FactorContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(396);
				factor();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(397);
				type_cast();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(398);
				access(0);
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

	public static class AccessContext extends ParserRuleContext {
		public AccessContext rec;
		public SubfactorContext sub;
		public SubfactorContext subfactor() {
			return getRuleContext(SubfactorContext.class,0);
		}
		public Field_accessContext field_access() {
			return getRuleContext(Field_accessContext.class,0);
		}
		public AccessContext access() {
			return getRuleContext(AccessContext.class,0);
		}
		public Element_accessContext element_access() {
			return getRuleContext(Element_accessContext.class,0);
		}
		public Method_accessContext method_access() {
			return getRuleContext(Method_accessContext.class,0);
		}
		public AccessContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_access; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EduCodeVisitor ) return ((EduCodeVisitor<? extends T>)visitor).visitAccess(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AccessContext access() throws RecognitionException {
		return access(0);
	}

	private AccessContext access(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		AccessContext _localctx = new AccessContext(_ctx, _parentState);
		AccessContext _prevctx = _localctx;
		int _startState = 64;
		enterRecursionRule(_localctx, 64, RULE_access, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(402);
			((AccessContext)_localctx).sub = subfactor();
			}
			_ctx.stop = _input.LT(-1);
			setState(412);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,39,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(410);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,38,_ctx) ) {
					case 1:
						{
						_localctx = new AccessContext(_parentctx, _parentState);
						_localctx.rec = _prevctx;
						_localctx.rec = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_access);
						setState(404);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(405);
						field_access();
						}
						break;
					case 2:
						{
						_localctx = new AccessContext(_parentctx, _parentState);
						_localctx.rec = _prevctx;
						_localctx.rec = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_access);
						setState(406);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(407);
						element_access();
						}
						break;
					case 3:
						{
						_localctx = new AccessContext(_parentctx, _parentState);
						_localctx.rec = _prevctx;
						_localctx.rec = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_access);
						setState(408);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(409);
						method_access();
						}
						break;
					}
					} 
				}
				setState(414);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,39,_ctx);
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

	public static class Field_accessContext extends ParserRuleContext {
		public IdentifierContext id;
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public Field_accessContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_field_access; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EduCodeVisitor ) return ((EduCodeVisitor<? extends T>)visitor).visitField_access(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Field_accessContext field_access() throws RecognitionException {
		Field_accessContext _localctx = new Field_accessContext(_ctx, getState());
		enterRule(_localctx, 66, RULE_field_access);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(415);
			match(T__41);
			setState(416);
			((Field_accessContext)_localctx).id = identifier();
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

	public static class Element_accessContext extends ParserRuleContext {
		public Logic_expressionContext index;
		public Logic_expressionContext logic_expression() {
			return getRuleContext(Logic_expressionContext.class,0);
		}
		public Element_accessContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_element_access; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EduCodeVisitor ) return ((EduCodeVisitor<? extends T>)visitor).visitElement_access(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Element_accessContext element_access() throws RecognitionException {
		Element_accessContext _localctx = new Element_accessContext(_ctx, getState());
		enterRule(_localctx, 68, RULE_element_access);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(418);
			match(T__42);
			setState(419);
			((Element_accessContext)_localctx).index = logic_expression();
			setState(420);
			match(T__43);
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

	public static class Method_accessContext extends ParserRuleContext {
		public Method_callContext method;
		public Method_callContext method_call() {
			return getRuleContext(Method_callContext.class,0);
		}
		public Method_accessContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_method_access; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EduCodeVisitor ) return ((EduCodeVisitor<? extends T>)visitor).visitMethod_access(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Method_accessContext method_access() throws RecognitionException {
		Method_accessContext _localctx = new Method_accessContext(_ctx, getState());
		enterRule(_localctx, 70, RULE_method_access);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(422);
			match(T__41);
			setState(423);
			((Method_accessContext)_localctx).method = method_call();
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

	public static class SubfactorContext extends ParserRuleContext {
		public Parenthesis_expressionContext parenthesis_expression() {
			return getRuleContext(Parenthesis_expressionContext.class,0);
		}
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public Method_callContext method_call() {
			return getRuleContext(Method_callContext.class,0);
		}
		public SubfactorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_subfactor; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EduCodeVisitor ) return ((EduCodeVisitor<? extends T>)visitor).visitSubfactor(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SubfactorContext subfactor() throws RecognitionException {
		SubfactorContext _localctx = new SubfactorContext(_ctx, getState());
		enterRule(_localctx, 72, RULE_subfactor);
		try {
			setState(428);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,40,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(425);
				parenthesis_expression();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(426);
				identifier();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(427);
				method_call();
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

	public static class Parenthesis_expressionContext extends ParserRuleContext {
		public Logic_expressionContext content;
		public TerminalNode LPAREN() { return getToken(EduCodeParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(EduCodeParser.RPAREN, 0); }
		public Logic_expressionContext logic_expression() {
			return getRuleContext(Logic_expressionContext.class,0);
		}
		public Parenthesis_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parenthesis_expression; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EduCodeVisitor ) return ((EduCodeVisitor<? extends T>)visitor).visitParenthesis_expression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Parenthesis_expressionContext parenthesis_expression() throws RecognitionException {
		Parenthesis_expressionContext _localctx = new Parenthesis_expressionContext(_ctx, getState());
		enterRule(_localctx, 74, RULE_parenthesis_expression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(430);
			match(LPAREN);
			setState(431);
			((Parenthesis_expressionContext)_localctx).content = logic_expression();
			setState(432);
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

	public static class Method_callContext extends ParserRuleContext {
		public IdentifierContext id;
		public Argument_listContext args;
		public TerminalNode LPAREN() { return getToken(EduCodeParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(EduCodeParser.RPAREN, 0); }
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public Argument_listContext argument_list() {
			return getRuleContext(Argument_listContext.class,0);
		}
		public Method_callContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_method_call; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EduCodeVisitor ) return ((EduCodeVisitor<? extends T>)visitor).visitMethod_call(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Method_callContext method_call() throws RecognitionException {
		Method_callContext _localctx = new Method_callContext(_ctx, getState());
		enterRule(_localctx, 76, RULE_method_call);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(434);
			((Method_callContext)_localctx).id = identifier();
			setState(435);
			match(LPAREN);
			setState(437);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((((_la - 37)) & ~0x3f) == 0 && ((1L << (_la - 37)) & ((1L << (T__36 - 37)) | (1L << (T__40 - 37)) | (1L << (T__44 - 37)) | (1L << (NUMBER_LITERAL - 37)) | (1L << (STRING_LITERAL - 37)) | (1L << (BOOL_LITERAL - 37)) | (1L << (NULL_LITERAL - 37)) | (1L << (IDENTIFIER - 37)) | (1L << (LPAREN - 37)))) != 0)) {
				{
				setState(436);
				((Method_callContext)_localctx).args = argument_list();
				}
			}

			setState(439);
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

	public static class Type_castContext extends ParserRuleContext {
		public Data_typeContext type;
		public FactorContext fac;
		public TerminalNode LPAREN() { return getToken(EduCodeParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(EduCodeParser.RPAREN, 0); }
		public Data_typeContext data_type() {
			return getRuleContext(Data_typeContext.class,0);
		}
		public FactorContext factor() {
			return getRuleContext(FactorContext.class,0);
		}
		public Type_castContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type_cast; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EduCodeVisitor ) return ((EduCodeVisitor<? extends T>)visitor).visitType_cast(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Type_castContext type_cast() throws RecognitionException {
		Type_castContext _localctx = new Type_castContext(_ctx, getState());
		enterRule(_localctx, 78, RULE_type_cast);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(441);
			match(LPAREN);
			setState(442);
			((Type_castContext)_localctx).type = data_type();
			setState(443);
			match(RPAREN);
			setState(444);
			((Type_castContext)_localctx).fac = factor();
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

	public static class Object_instantiationContext extends ParserRuleContext {
		public Data_typeContext type;
		public Argument_listContext args;
		public TerminalNode LPAREN() { return getToken(EduCodeParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(EduCodeParser.RPAREN, 0); }
		public Data_typeContext data_type() {
			return getRuleContext(Data_typeContext.class,0);
		}
		public Argument_listContext argument_list() {
			return getRuleContext(Argument_listContext.class,0);
		}
		public Object_instantiationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_object_instantiation; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EduCodeVisitor ) return ((EduCodeVisitor<? extends T>)visitor).visitObject_instantiation(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Object_instantiationContext object_instantiation() throws RecognitionException {
		Object_instantiationContext _localctx = new Object_instantiationContext(_ctx, getState());
		enterRule(_localctx, 80, RULE_object_instantiation);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(446);
			match(T__44);
			setState(447);
			((Object_instantiationContext)_localctx).type = data_type();
			setState(448);
			match(LPAREN);
			setState(450);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((((_la - 37)) & ~0x3f) == 0 && ((1L << (_la - 37)) & ((1L << (T__36 - 37)) | (1L << (T__40 - 37)) | (1L << (T__44 - 37)) | (1L << (NUMBER_LITERAL - 37)) | (1L << (STRING_LITERAL - 37)) | (1L << (BOOL_LITERAL - 37)) | (1L << (NULL_LITERAL - 37)) | (1L << (IDENTIFIER - 37)) | (1L << (LPAREN - 37)))) != 0)) {
				{
				setState(449);
				((Object_instantiationContext)_localctx).args = argument_list();
				}
			}

			setState(452);
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

	public static class Event_typeContext extends ParserRuleContext {
		public Token type;
		public Number_literalContext param;
		public TerminalNode LPAREN() { return getToken(EduCodeParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(EduCodeParser.RPAREN, 0); }
		public Number_literalContext number_literal() {
			return getRuleContext(Number_literalContext.class,0);
		}
		public Event_typeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_event_type; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EduCodeVisitor ) return ((EduCodeVisitor<? extends T>)visitor).visitEvent_type(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Event_typeContext event_type() throws RecognitionException {
		Event_typeContext _localctx = new Event_typeContext(_ctx, getState());
		enterRule(_localctx, 82, RULE_event_type);
		int _la;
		try {
			setState(463);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__45:
				enterOuterAlt(_localctx, 1);
				{
				setState(454);
				((Event_typeContext)_localctx).type = match(T__45);
				}
				break;
			case T__46:
				enterOuterAlt(_localctx, 2);
				{
				setState(455);
				((Event_typeContext)_localctx).type = match(T__46);
				}
				break;
			case T__47:
				enterOuterAlt(_localctx, 3);
				{
				setState(456);
				((Event_typeContext)_localctx).type = match(T__47);
				}
				break;
			case T__48:
				enterOuterAlt(_localctx, 4);
				{
				setState(457);
				((Event_typeContext)_localctx).type = match(T__48);
				}
				break;
			case T__49:
			case T__50:
				enterOuterAlt(_localctx, 5);
				{
				setState(458);
				((Event_typeContext)_localctx).type = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==T__49 || _la==T__50) ) {
					((Event_typeContext)_localctx).type = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(459);
				match(LPAREN);
				setState(460);
				((Event_typeContext)_localctx).param = number_literal();
				setState(461);
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

	public static class Data_typeContext extends ParserRuleContext {
		public Data_typeContext childType;
		public Data_typeContext data_type() {
			return getRuleContext(Data_typeContext.class,0);
		}
		public Data_typeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_data_type; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EduCodeVisitor ) return ((EduCodeVisitor<? extends T>)visitor).visitData_type(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Data_typeContext data_type() throws RecognitionException {
		Data_typeContext _localctx = new Data_typeContext(_ctx, getState());
		enterRule(_localctx, 84, RULE_data_type);
		try {
			setState(476);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__51:
				enterOuterAlt(_localctx, 1);
				{
				setState(465);
				match(T__51);
				}
				break;
			case T__52:
				enterOuterAlt(_localctx, 2);
				{
				setState(466);
				match(T__52);
				}
				break;
			case T__53:
				enterOuterAlt(_localctx, 3);
				{
				setState(467);
				match(T__53);
				}
				break;
			case T__54:
				enterOuterAlt(_localctx, 4);
				{
				setState(468);
				match(T__54);
				}
				break;
			case T__55:
				enterOuterAlt(_localctx, 5);
				{
				setState(469);
				match(T__55);
				setState(470);
				match(T__56);
				setState(471);
				((Data_typeContext)_localctx).childType = data_type();
				setState(472);
				match(T__57);
				}
				break;
			case T__58:
				enterOuterAlt(_localctx, 6);
				{
				setState(474);
				match(T__58);
				}
				break;
			case T__59:
				enterOuterAlt(_localctx, 7);
				{
				setState(475);
				match(T__59);
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
		public Bool_literalContext bool_literal() {
			return getRuleContext(Bool_literalContext.class,0);
		}
		public String_literalContext string_literal() {
			return getRuleContext(String_literalContext.class,0);
		}
		public Number_literalContext number_literal() {
			return getRuleContext(Number_literalContext.class,0);
		}
		public Coordinate_literalContext coordinate_literal() {
			return getRuleContext(Coordinate_literalContext.class,0);
		}
		public Null_literalContext null_literal() {
			return getRuleContext(Null_literalContext.class,0);
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
		enterRule(_localctx, 86, RULE_literal);
		try {
			setState(483);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case BOOL_LITERAL:
				enterOuterAlt(_localctx, 1);
				{
				setState(478);
				bool_literal();
				}
				break;
			case STRING_LITERAL:
				enterOuterAlt(_localctx, 2);
				{
				setState(479);
				string_literal();
				}
				break;
			case NUMBER_LITERAL:
				enterOuterAlt(_localctx, 3);
				{
				setState(480);
				number_literal();
				}
				break;
			case LPAREN:
				enterOuterAlt(_localctx, 4);
				{
				setState(481);
				coordinate_literal();
				}
				break;
			case NULL_LITERAL:
				enterOuterAlt(_localctx, 5);
				{
				setState(482);
				null_literal();
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

	public static class String_literalContext extends ParserRuleContext {
		public TerminalNode STRING_LITERAL() { return getToken(EduCodeParser.STRING_LITERAL, 0); }
		public String_literalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_string_literal; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EduCodeVisitor ) return ((EduCodeVisitor<? extends T>)visitor).visitString_literal(this);
			else return visitor.visitChildren(this);
		}
	}

	public final String_literalContext string_literal() throws RecognitionException {
		String_literalContext _localctx = new String_literalContext(_ctx, getState());
		enterRule(_localctx, 88, RULE_string_literal);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(485);
			match(STRING_LITERAL);
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

	public static class Coordinate_literalContext extends ParserRuleContext {
		public Logic_expressionContext x;
		public Logic_expressionContext y;
		public Logic_expressionContext z;
		public TerminalNode LPAREN() { return getToken(EduCodeParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(EduCodeParser.RPAREN, 0); }
		public List<Logic_expressionContext> logic_expression() {
			return getRuleContexts(Logic_expressionContext.class);
		}
		public Logic_expressionContext logic_expression(int i) {
			return getRuleContext(Logic_expressionContext.class,i);
		}
		public Coordinate_literalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_coordinate_literal; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EduCodeVisitor ) return ((EduCodeVisitor<? extends T>)visitor).visitCoordinate_literal(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Coordinate_literalContext coordinate_literal() throws RecognitionException {
		Coordinate_literalContext _localctx = new Coordinate_literalContext(_ctx, getState());
		enterRule(_localctx, 90, RULE_coordinate_literal);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(487);
			match(LPAREN);
			setState(488);
			((Coordinate_literalContext)_localctx).x = logic_expression();
			setState(489);
			match(T__8);
			setState(490);
			((Coordinate_literalContext)_localctx).y = logic_expression();
			setState(491);
			match(T__8);
			setState(492);
			((Coordinate_literalContext)_localctx).z = logic_expression();
			setState(493);
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

	public static class Number_literalContext extends ParserRuleContext {
		public TerminalNode NUMBER_LITERAL() { return getToken(EduCodeParser.NUMBER_LITERAL, 0); }
		public Number_literalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_number_literal; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EduCodeVisitor ) return ((EduCodeVisitor<? extends T>)visitor).visitNumber_literal(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Number_literalContext number_literal() throws RecognitionException {
		Number_literalContext _localctx = new Number_literalContext(_ctx, getState());
		enterRule(_localctx, 92, RULE_number_literal);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(495);
			match(NUMBER_LITERAL);
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

	public static class Bool_literalContext extends ParserRuleContext {
		public TerminalNode BOOL_LITERAL() { return getToken(EduCodeParser.BOOL_LITERAL, 0); }
		public Bool_literalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bool_literal; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EduCodeVisitor ) return ((EduCodeVisitor<? extends T>)visitor).visitBool_literal(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Bool_literalContext bool_literal() throws RecognitionException {
		Bool_literalContext _localctx = new Bool_literalContext(_ctx, getState());
		enterRule(_localctx, 94, RULE_bool_literal);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(497);
			match(BOOL_LITERAL);
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

	public static class Null_literalContext extends ParserRuleContext {
		public TerminalNode NULL_LITERAL() { return getToken(EduCodeParser.NULL_LITERAL, 0); }
		public Null_literalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_null_literal; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EduCodeVisitor ) return ((EduCodeVisitor<? extends T>)visitor).visitNull_literal(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Null_literalContext null_literal() throws RecognitionException {
		Null_literalContext _localctx = new Null_literalContext(_ctx, getState());
		enterRule(_localctx, 96, RULE_null_literal);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(499);
			match(NULL_LITERAL);
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

	public static class IdentifierContext extends ParserRuleContext {
		public Token id;
		public TerminalNode IDENTIFIER() { return getToken(EduCodeParser.IDENTIFIER, 0); }
		public IdentifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_identifier; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EduCodeVisitor ) return ((EduCodeVisitor<? extends T>)visitor).visitIdentifier(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IdentifierContext identifier() throws RecognitionException {
		IdentifierContext _localctx = new IdentifierContext(_ctx, getState());
		enterRule(_localctx, 98, RULE_identifier);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(501);
			((IdentifierContext)_localctx).id = match(IDENTIFIER);
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

	public static class End_of_lineContext extends ParserRuleContext {
		public TerminalNode NEWLINE() { return getToken(EduCodeParser.NEWLINE, 0); }
		public End_of_lineContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_end_of_line; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EduCodeVisitor ) return ((EduCodeVisitor<? extends T>)visitor).visitEnd_of_line(this);
			else return visitor.visitChildren(this);
		}
	}

	public final End_of_lineContext end_of_line() throws RecognitionException {
		End_of_lineContext _localctx = new End_of_lineContext(_ctx, getState());
		enterRule(_localctx, 100, RULE_end_of_line);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(503);
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 24:
			return or_expression_sempred((Or_expressionContext)_localctx, predIndex);
		case 25:
			return and_expression_sempred((And_expressionContext)_localctx, predIndex);
		case 26:
			return equality_expression_sempred((Equality_expressionContext)_localctx, predIndex);
		case 29:
			return additive_expression_sempred((Additive_expressionContext)_localctx, predIndex);
		case 30:
			return multiplicative_expression_sempred((Multiplicative_expressionContext)_localctx, predIndex);
		case 32:
			return access_sempred((AccessContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean or_expression_sempred(Or_expressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean and_expression_sempred(And_expressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 1:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean equality_expression_sempred(Equality_expressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 2:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean additive_expression_sempred(Additive_expressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 3:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean multiplicative_expression_sempred(Multiplicative_expressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 4:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean access_sempred(AccessContext _localctx, int predIndex) {
		switch (predIndex) {
		case 5:
			return precpred(_ctx, 3);
		case 6:
			return precpred(_ctx, 2);
		case 7:
			return precpred(_ctx, 1);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3I\u01fc\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\3\2\5\2j\n\2\3\2\6\2m\n\2\r\2\16\2n\3\2\3\2\3\3\3\3\3\3\6\3v\n\3\r"+
		"\3\16\3w\3\3\3\3\3\3\6\3}\n\3\r\3\16\3~\7\3\u0081\n\3\f\3\16\3\u0084\13"+
		"\3\3\4\3\4\3\4\6\4\u0089\n\4\r\4\16\4\u008a\3\4\3\4\3\4\5\4\u0090\n\4"+
		"\3\4\6\4\u0093\n\4\r\4\16\4\u0094\7\4\u0097\n\4\f\4\16\4\u009a\13\4\3"+
		"\4\3\4\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\5\6\u00a7\n\6\3\6\3\6\3\6\5"+
		"\6\u00ac\n\6\3\6\6\6\u00af\n\6\r\6\16\6\u00b0\3\6\3\6\3\6\3\7\3\7\3\7"+
		"\7\7\u00b9\n\7\f\7\16\7\u00bc\13\7\3\b\3\b\3\b\7\b\u00c1\n\b\f\b\16\b"+
		"\u00c4\13\b\3\t\3\t\3\t\3\n\3\n\6\n\u00cb\n\n\r\n\16\n\u00cc\7\n\u00cf"+
		"\n\n\f\n\16\n\u00d2\13\n\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\5\13"+
		"\u00dc\n\13\3\f\3\f\3\f\3\f\5\f\u00e2\n\f\3\r\3\r\5\r\u00e6\n\r\3\16\3"+
		"\16\3\17\3\17\3\20\3\20\5\20\u00ee\n\20\3\21\3\21\3\21\6\21\u00f3\n\21"+
		"\r\21\16\21\u00f4\3\21\3\21\3\21\3\22\3\22\3\22\3\22\6\22\u00fe\n\22\r"+
		"\22\16\22\u00ff\3\22\3\22\3\22\3\22\3\22\6\22\u0107\n\22\r\22\16\22\u0108"+
		"\3\22\3\22\7\22\u010d\n\22\f\22\16\22\u0110\13\22\3\22\3\22\6\22\u0114"+
		"\n\22\r\22\16\22\u0115\3\22\3\22\5\22\u011a\n\22\3\22\3\22\3\23\3\23\3"+
		"\23\3\23\3\23\3\23\6\23\u0124\n\23\r\23\16\23\u0125\3\23\3\23\3\23\3\24"+
		"\3\24\3\24\3\24\7\24\u012f\n\24\f\24\16\24\u0132\13\24\3\25\3\25\3\25"+
		"\5\25\u0137\n\25\3\26\3\26\5\26\u013b\n\26\3\27\3\27\3\27\3\27\3\30\3"+
		"\30\3\30\3\30\3\30\3\30\3\30\5\30\u0148\n\30\3\31\3\31\3\32\3\32\3\32"+
		"\3\32\3\32\3\32\7\32\u0152\n\32\f\32\16\32\u0155\13\32\3\33\3\33\3\33"+
		"\3\33\3\33\3\33\7\33\u015d\n\33\f\33\16\33\u0160\13\33\3\34\3\34\3\34"+
		"\3\34\3\34\3\34\7\34\u0168\n\34\f\34\16\34\u016b\13\34\3\35\3\35\3\35"+
		"\3\35\3\35\5\35\u0172\n\35\3\36\3\36\3\37\3\37\3\37\3\37\3\37\3\37\7\37"+
		"\u017c\n\37\f\37\16\37\u017f\13\37\3 \3 \3 \3 \3 \3 \7 \u0187\n \f \16"+
		" \u018a\13 \3!\3!\3!\3!\3!\3!\5!\u0192\n!\3\"\3\"\3\"\3\"\3\"\3\"\3\""+
		"\3\"\3\"\7\"\u019d\n\"\f\"\16\"\u01a0\13\"\3#\3#\3#\3$\3$\3$\3$\3%\3%"+
		"\3%\3&\3&\3&\5&\u01af\n&\3\'\3\'\3\'\3\'\3(\3(\3(\5(\u01b8\n(\3(\3(\3"+
		")\3)\3)\3)\3)\3*\3*\3*\3*\5*\u01c5\n*\3*\3*\3+\3+\3+\3+\3+\3+\3+\3+\3"+
		"+\5+\u01d2\n+\3,\3,\3,\3,\3,\3,\3,\3,\3,\3,\3,\5,\u01df\n,\3-\3-\3-\3"+
		"-\3-\5-\u01e6\n-\3.\3.\3/\3/\3/\3/\3/\3/\3/\3/\3\60\3\60\3\61\3\61\3\62"+
		"\3\62\3\63\3\63\3\64\3\64\3\64\2\b\62\64\66<>B\65\2\4\6\b\n\f\16\20\22"+
		"\24\26\30\32\34\36 \"$&(*,.\60\62\64\668:<>@BDFHJLNPRTVXZ\\^`bdf\2\t\3"+
		"\2\31\35\3\2 !\3\2\"%\3\2&\'\3\2(*\4\2\'\'++\3\2\64\65\u020e\2i\3\2\2"+
		"\2\4r\3\2\2\2\6\u0085\3\2\2\2\b\u009d\3\2\2\2\n\u00a2\3\2\2\2\f\u00b5"+
		"\3\2\2\2\16\u00bd\3\2\2\2\20\u00c5\3\2\2\2\22\u00d0\3\2\2\2\24\u00db\3"+
		"\2\2\2\26\u00e1\3\2\2\2\30\u00e5\3\2\2\2\32\u00e7\3\2\2\2\34\u00e9\3\2"+
		"\2\2\36\u00eb\3\2\2\2 \u00ef\3\2\2\2\"\u00f9\3\2\2\2$\u011d\3\2\2\2&\u012a"+
		"\3\2\2\2(\u0133\3\2\2\2*\u013a\3\2\2\2,\u013c\3\2\2\2.\u0147\3\2\2\2\60"+
		"\u0149\3\2\2\2\62\u014b\3\2\2\2\64\u0156\3\2\2\2\66\u0161\3\2\2\28\u0171"+
		"\3\2\2\2:\u0173\3\2\2\2<\u0175\3\2\2\2>\u0180\3\2\2\2@\u0191\3\2\2\2B"+
		"\u0193\3\2\2\2D\u01a1\3\2\2\2F\u01a4\3\2\2\2H\u01a8\3\2\2\2J\u01ae\3\2"+
		"\2\2L\u01b0\3\2\2\2N\u01b4\3\2\2\2P\u01bb\3\2\2\2R\u01c0\3\2\2\2T\u01d1"+
		"\3\2\2\2V\u01de\3\2\2\2X\u01e5\3\2\2\2Z\u01e7\3\2\2\2\\\u01e9\3\2\2\2"+
		"^\u01f1\3\2\2\2`\u01f3\3\2\2\2b\u01f5\3\2\2\2d\u01f7\3\2\2\2f\u01f9\3"+
		"\2\2\2hj\5\4\3\2ih\3\2\2\2ij\3\2\2\2jl\3\2\2\2km\5f\64\2lk\3\2\2\2mn\3"+
		"\2\2\2nl\3\2\2\2no\3\2\2\2op\3\2\2\2pq\5\6\4\2q\3\3\2\2\2rs\7\3\2\2su"+
		"\5d\63\2tv\5f\64\2ut\3\2\2\2vw\3\2\2\2wu\3\2\2\2wx\3\2\2\2x\u0082\3\2"+
		"\2\2yz\7\3\2\2z|\5d\63\2{}\5f\64\2|{\3\2\2\2}~\3\2\2\2~|\3\2\2\2~\177"+
		"\3\2\2\2\177\u0081\3\2\2\2\u0080y\3\2\2\2\u0081\u0084\3\2\2\2\u0082\u0080"+
		"\3\2\2\2\u0082\u0083\3\2\2\2\u0083\5\3\2\2\2\u0084\u0082\3\2\2\2\u0085"+
		"\u0086\7\4\2\2\u0086\u0088\5d\63\2\u0087\u0089\5f\64\2\u0088\u0087\3\2"+
		"\2\2\u0089\u008a\3\2\2\2\u008a\u0088\3\2\2\2\u008a\u008b\3\2\2\2\u008b"+
		"\u0098\3\2\2\2\u008c\u0090\5\b\5\2\u008d\u0090\5\n\6\2\u008e\u0090\5&"+
		"\24\2\u008f\u008c\3\2\2\2\u008f\u008d\3\2\2\2\u008f\u008e\3\2\2\2\u0090"+
		"\u0092\3\2\2\2\u0091\u0093\5f\64\2\u0092\u0091\3\2\2\2\u0093\u0094\3\2"+
		"\2\2\u0094\u0092\3\2\2\2\u0094\u0095\3\2\2\2\u0095\u0097\3\2\2\2\u0096"+
		"\u008f\3\2\2\2\u0097\u009a\3\2\2\2\u0098\u0096\3\2\2\2\u0098\u0099\3\2"+
		"\2\2\u0099\u009b\3\2\2\2\u009a\u0098\3\2\2\2\u009b\u009c\7\5\2\2\u009c"+
		"\7\3\2\2\2\u009d\u009e\7\6\2\2\u009e\u009f\5T+\2\u009f\u00a0\7\7\2\2\u00a0"+
		"\u00a1\5d\63\2\u00a1\t\3\2\2\2\u00a2\u00a3\7\b\2\2\u00a3\u00a4\5d\63\2"+
		"\u00a4\u00a6\7F\2\2\u00a5\u00a7\5\16\b\2\u00a6\u00a5\3\2\2\2\u00a6\u00a7"+
		"\3\2\2\2\u00a7\u00a8\3\2\2\2\u00a8\u00ab\7G\2\2\u00a9\u00aa\7\t\2\2\u00aa"+
		"\u00ac\5V,\2\u00ab\u00a9\3\2\2\2\u00ab\u00ac\3\2\2\2\u00ac\u00ae\3\2\2"+
		"\2\u00ad\u00af\5f\64\2\u00ae\u00ad\3\2\2\2\u00af\u00b0\3\2\2\2\u00b0\u00ae"+
		"\3\2\2\2\u00b0\u00b1\3\2\2\2\u00b1\u00b2\3\2\2\2\u00b2\u00b3\5\22\n\2"+
		"\u00b3\u00b4\7\n\2\2\u00b4\13\3\2\2\2\u00b5\u00ba\5\60\31\2\u00b6\u00b7"+
		"\7\13\2\2\u00b7\u00b9\5\60\31\2\u00b8\u00b6\3\2\2\2\u00b9\u00bc\3\2\2"+
		"\2\u00ba\u00b8\3\2\2\2\u00ba\u00bb\3\2\2\2\u00bb\r\3\2\2\2\u00bc\u00ba"+
		"\3\2\2\2\u00bd\u00c2\5\20\t\2\u00be\u00bf\7\13\2\2\u00bf\u00c1\5\20\t"+
		"\2\u00c0\u00be\3\2\2\2\u00c1\u00c4\3\2\2\2\u00c2\u00c0\3\2\2\2\u00c2\u00c3"+
		"\3\2\2\2\u00c3\17\3\2\2\2\u00c4\u00c2\3\2\2\2\u00c5\u00c6\5V,\2\u00c6"+
		"\u00c7\5d\63\2\u00c7\21\3\2\2\2\u00c8\u00ca\5\24\13\2\u00c9\u00cb\5f\64"+
		"\2\u00ca\u00c9\3\2\2\2\u00cb\u00cc\3\2\2\2\u00cc\u00ca\3\2\2\2\u00cc\u00cd"+
		"\3\2\2\2\u00cd\u00cf\3\2\2\2\u00ce\u00c8\3\2\2\2\u00cf\u00d2\3\2\2\2\u00d0"+
		"\u00ce\3\2\2\2\u00d0\u00d1\3\2\2\2\u00d1\23\3\2\2\2\u00d2\u00d0\3\2\2"+
		"\2\u00d3\u00dc\5\26\f\2\u00d4\u00dc\5,\27\2\u00d5\u00dc\5&\24\2\u00d6"+
		"\u00dc\5\"\22\2\u00d7\u00dc\5\30\r\2\u00d8\u00dc\5\36\20\2\u00d9\u00dc"+
		"\5\32\16\2\u00da\u00dc\5\34\17\2\u00db\u00d3\3\2\2\2\u00db\u00d4\3\2\2"+
		"\2\u00db\u00d5\3\2\2\2\u00db\u00d6\3\2\2\2\u00db\u00d7\3\2\2\2\u00db\u00d8"+
		"\3\2\2\2\u00db\u00d9\3\2\2\2\u00db\u00da\3\2\2\2\u00dc\25\3\2\2\2\u00dd"+
		"\u00e2\5N(\2\u00de\u00df\5B\"\2\u00df\u00e0\5H%\2\u00e0\u00e2\3\2\2\2"+
		"\u00e1\u00dd\3\2\2\2\u00e1\u00de\3\2\2\2\u00e2\27\3\2\2\2\u00e3\u00e6"+
		"\5 \21\2\u00e4\u00e6\5$\23\2\u00e5\u00e3\3\2\2\2\u00e5\u00e4\3\2\2\2\u00e6"+
		"\31\3\2\2\2\u00e7\u00e8\7\f\2\2\u00e8\33\3\2\2\2\u00e9\u00ea\7\r\2\2\u00ea"+
		"\35\3\2\2\2\u00eb\u00ed\7\16\2\2\u00ec\u00ee\5\60\31\2\u00ed\u00ec\3\2"+
		"\2\2\u00ed\u00ee\3\2\2\2\u00ee\37\3\2\2\2\u00ef\u00f0\7\17\2\2\u00f0\u00f2"+
		"\5\60\31\2\u00f1\u00f3\5f\64\2\u00f2\u00f1\3\2\2\2\u00f3\u00f4\3\2\2\2"+
		"\u00f4\u00f2\3\2\2\2\u00f4\u00f5\3\2\2\2\u00f5\u00f6\3\2\2\2\u00f6\u00f7"+
		"\5\22\n\2\u00f7\u00f8\7\20\2\2\u00f8!\3\2\2\2\u00f9\u00fa\7\21\2\2\u00fa"+
		"\u00fb\5\60\31\2\u00fb\u00fd\7\22\2\2\u00fc\u00fe\5f\64\2\u00fd\u00fc"+
		"\3\2\2\2\u00fe\u00ff\3\2\2\2\u00ff\u00fd\3\2\2\2\u00ff\u0100\3\2\2\2\u0100"+
		"\u0101\3\2\2\2\u0101\u010e\5\22\n\2\u0102\u0103\7\23\2\2\u0103\u0104\5"+
		"\60\31\2\u0104\u0106\7\22\2\2\u0105\u0107\5f\64\2\u0106\u0105\3\2\2\2"+
		"\u0107\u0108\3\2\2\2\u0108\u0106\3\2\2\2\u0108\u0109\3\2\2\2\u0109\u010a"+
		"\3\2\2\2\u010a\u010b\5\22\n\2\u010b\u010d\3\2\2\2\u010c\u0102\3\2\2\2"+
		"\u010d\u0110\3\2\2\2\u010e\u010c\3\2\2\2\u010e\u010f\3\2\2\2\u010f\u0119"+
		"\3\2\2\2\u0110\u010e\3\2\2\2\u0111\u0113\7\24\2\2\u0112\u0114\5f\64\2"+
		"\u0113\u0112\3\2\2\2\u0114\u0115\3\2\2\2\u0115\u0113\3\2\2\2\u0115\u0116"+
		"\3\2\2\2\u0116\u0117\3\2\2\2\u0117\u0118\5\22\n\2\u0118\u011a\3\2\2\2"+
		"\u0119\u0111\3\2\2\2\u0119\u011a\3\2\2\2\u011a\u011b\3\2\2\2\u011b\u011c"+
		"\7\25\2\2\u011c#\3\2\2\2\u011d\u011e\7\26\2\2\u011e\u011f\5V,\2\u011f"+
		"\u0120\5d\63\2\u0120\u0121\7\27\2\2\u0121\u0123\5\60\31\2\u0122\u0124"+
		"\5f\64\2\u0123\u0122\3\2\2\2\u0124\u0125\3\2\2\2\u0125\u0123\3\2\2\2\u0125"+
		"\u0126\3\2\2\2\u0126\u0127\3\2\2\2\u0127\u0128\5\22\n\2\u0128\u0129\7"+
		"\30\2\2\u0129%\3\2\2\2\u012a\u012b\5V,\2\u012b\u0130\5(\25\2\u012c\u012d"+
		"\7\13\2\2\u012d\u012f\5(\25\2\u012e\u012c\3\2\2\2\u012f\u0132\3\2\2\2"+
		"\u0130\u012e\3\2\2\2\u0130\u0131\3\2\2\2\u0131\'\3\2\2\2\u0132\u0130\3"+
		"\2\2\2\u0133\u0136\5d\63\2\u0134\u0135\7\31\2\2\u0135\u0137\5*\26\2\u0136"+
		"\u0134\3\2\2\2\u0136\u0137\3\2\2\2\u0137)\3\2\2\2\u0138\u013b\5,\27\2"+
		"\u0139\u013b\5\60\31\2\u013a\u0138\3\2\2\2\u013a\u0139\3\2\2\2\u013b+"+
		"\3\2\2\2\u013c\u013d\5.\30\2\u013d\u013e\t\2\2\2\u013e\u013f\5*\26\2\u013f"+
		"-\3\2\2\2\u0140\u0148\5d\63\2\u0141\u0142\5B\"\2\u0142\u0143\5F$\2\u0143"+
		"\u0148\3\2\2\2\u0144\u0145\5B\"\2\u0145\u0146\5D#\2\u0146\u0148\3\2\2"+
		"\2\u0147\u0140\3\2\2\2\u0147\u0141\3\2\2\2\u0147\u0144\3\2\2\2\u0148/"+
		"\3\2\2\2\u0149\u014a\5\62\32\2\u014a\61\3\2\2\2\u014b\u014c\b\32\1\2\u014c"+
		"\u014d\5\64\33\2\u014d\u0153\3\2\2\2\u014e\u014f\f\4\2\2\u014f\u0150\7"+
		"\36\2\2\u0150\u0152\5\64\33\2\u0151\u014e\3\2\2\2\u0152\u0155\3\2\2\2"+
		"\u0153\u0151\3\2\2\2\u0153\u0154\3\2\2\2\u0154\63\3\2\2\2\u0155\u0153"+
		"\3\2\2\2\u0156\u0157\b\33\1\2\u0157\u0158\5\66\34\2\u0158\u015e\3\2\2"+
		"\2\u0159\u015a\f\4\2\2\u015a\u015b\7\37\2\2\u015b\u015d\5\66\34\2\u015c"+
		"\u0159\3\2\2\2\u015d\u0160\3\2\2\2\u015e\u015c\3\2\2\2\u015e\u015f\3\2"+
		"\2\2\u015f\65\3\2\2\2\u0160\u015e\3\2\2\2\u0161\u0162\b\34\1\2\u0162\u0163"+
		"\58\35\2\u0163\u0169\3\2\2\2\u0164\u0165\f\4\2\2\u0165\u0166\t\3\2\2\u0166"+
		"\u0168\58\35\2\u0167\u0164\3\2\2\2\u0168\u016b\3\2\2\2\u0169\u0167\3\2"+
		"\2\2\u0169\u016a\3\2\2\2\u016a\67\3\2\2\2\u016b\u0169\3\2\2\2\u016c\u016d"+
		"\5:\36\2\u016d\u016e\t\4\2\2\u016e\u016f\5:\36\2\u016f\u0172\3\2\2\2\u0170"+
		"\u0172\5:\36\2\u0171\u016c\3\2\2\2\u0171\u0170\3\2\2\2\u01729\3\2\2\2"+
		"\u0173\u0174\5<\37\2\u0174;\3\2\2\2\u0175\u0176\b\37\1\2\u0176\u0177\5"+
		"> \2\u0177\u017d\3\2\2\2\u0178\u0179\f\3\2\2\u0179\u017a\t\5\2\2\u017a"+
		"\u017c\5> \2\u017b\u0178\3\2\2\2\u017c\u017f\3\2\2\2\u017d\u017b\3\2\2"+
		"\2\u017d\u017e\3\2\2\2\u017e=\3\2\2\2\u017f\u017d\3\2\2\2\u0180\u0181"+
		"\b \1\2\u0181\u0182\5@!\2\u0182\u0188\3\2\2\2\u0183\u0184\f\3\2\2\u0184"+
		"\u0185\t\6\2\2\u0185\u0187\5@!\2\u0186\u0183\3\2\2\2\u0187\u018a\3\2\2"+
		"\2\u0188\u0186\3\2\2\2\u0188\u0189\3\2\2\2\u0189?\3\2\2\2\u018a\u0188"+
		"\3\2\2\2\u018b\u0192\5X-\2\u018c\u0192\5R*\2\u018d\u018e\t\7\2\2\u018e"+
		"\u0192\5@!\2\u018f\u0192\5P)\2\u0190\u0192\5B\"\2\u0191\u018b\3\2\2\2"+
		"\u0191\u018c\3\2\2\2\u0191\u018d\3\2\2\2\u0191\u018f\3\2\2\2\u0191\u0190"+
		"\3\2\2\2\u0192A\3\2\2\2\u0193\u0194\b\"\1\2\u0194\u0195\5J&\2\u0195\u019e"+
		"\3\2\2\2\u0196\u0197\f\5\2\2\u0197\u019d\5D#\2\u0198\u0199\f\4\2\2\u0199"+
		"\u019d\5F$\2\u019a\u019b\f\3\2\2\u019b\u019d\5H%\2\u019c\u0196\3\2\2\2"+
		"\u019c\u0198\3\2\2\2\u019c\u019a\3\2\2\2\u019d\u01a0\3\2\2\2\u019e\u019c"+
		"\3\2\2\2\u019e\u019f\3\2\2\2\u019fC\3\2\2\2\u01a0\u019e\3\2\2\2\u01a1"+
		"\u01a2\7,\2\2\u01a2\u01a3\5d\63\2\u01a3E\3\2\2\2\u01a4\u01a5\7-\2\2\u01a5"+
		"\u01a6\5\60\31\2\u01a6\u01a7\7.\2\2\u01a7G\3\2\2\2\u01a8\u01a9\7,\2\2"+
		"\u01a9\u01aa\5N(\2\u01aaI\3\2\2\2\u01ab\u01af\5L\'\2\u01ac\u01af\5d\63"+
		"\2\u01ad\u01af\5N(\2\u01ae\u01ab\3\2\2\2\u01ae\u01ac\3\2\2\2\u01ae\u01ad"+
		"\3\2\2\2\u01afK\3\2\2\2\u01b0\u01b1\7F\2\2\u01b1\u01b2\5\60\31\2\u01b2"+
		"\u01b3\7G\2\2\u01b3M\3\2\2\2\u01b4\u01b5\5d\63\2\u01b5\u01b7\7F\2\2\u01b6"+
		"\u01b8\5\f\7\2\u01b7\u01b6\3\2\2\2\u01b7\u01b8\3\2\2\2\u01b8\u01b9\3\2"+
		"\2\2\u01b9\u01ba\7G\2\2\u01baO\3\2\2\2\u01bb\u01bc\7F\2\2\u01bc\u01bd"+
		"\5V,\2\u01bd\u01be\7G\2\2\u01be\u01bf\5@!\2\u01bfQ\3\2\2\2\u01c0\u01c1"+
		"\7/\2\2\u01c1\u01c2\5V,\2\u01c2\u01c4\7F\2\2\u01c3\u01c5\5\f\7\2\u01c4"+
		"\u01c3\3\2\2\2\u01c4\u01c5\3\2\2\2\u01c5\u01c6\3\2\2\2\u01c6\u01c7\7G"+
		"\2\2\u01c7S\3\2\2\2\u01c8\u01d2\7\60\2\2\u01c9\u01d2\7\61\2\2\u01ca\u01d2"+
		"\7\62\2\2\u01cb\u01d2\7\63\2\2\u01cc\u01cd\t\b\2\2\u01cd\u01ce\7F\2\2"+
		"\u01ce\u01cf\5^\60\2\u01cf\u01d0\7G\2\2\u01d0\u01d2\3\2\2\2\u01d1\u01c8"+
		"\3\2\2\2\u01d1\u01c9\3\2\2\2\u01d1\u01ca\3\2\2\2\u01d1\u01cb\3\2\2\2\u01d1"+
		"\u01cc\3\2\2\2\u01d2U\3\2\2\2\u01d3\u01df\7\66\2\2\u01d4\u01df\7\67\2"+
		"\2\u01d5\u01df\78\2\2\u01d6\u01df\79\2\2\u01d7\u01d8\7:\2\2\u01d8\u01d9"+
		"\7;\2\2\u01d9\u01da\5V,\2\u01da\u01db\7<\2\2\u01db\u01df\3\2\2\2\u01dc"+
		"\u01df\7=\2\2\u01dd\u01df\7>\2\2\u01de\u01d3\3\2\2\2\u01de\u01d4\3\2\2"+
		"\2\u01de\u01d5\3\2\2\2\u01de\u01d6\3\2\2\2\u01de\u01d7\3\2\2\2\u01de\u01dc"+
		"\3\2\2\2\u01de\u01dd\3\2\2\2\u01dfW\3\2\2\2\u01e0\u01e6\5`\61\2\u01e1"+
		"\u01e6\5Z.\2\u01e2\u01e6\5^\60\2\u01e3\u01e6\5\\/\2\u01e4\u01e6\5b\62"+
		"\2\u01e5\u01e0\3\2\2\2\u01e5\u01e1\3\2\2\2\u01e5\u01e2\3\2\2\2\u01e5\u01e3"+
		"\3\2\2\2\u01e5\u01e4\3\2\2\2\u01e6Y\3\2\2\2\u01e7\u01e8\7A\2\2\u01e8["+
		"\3\2\2\2\u01e9\u01ea\7F\2\2\u01ea\u01eb\5\60\31\2\u01eb\u01ec\7\13\2\2"+
		"\u01ec\u01ed\5\60\31\2\u01ed\u01ee\7\13\2\2\u01ee\u01ef\5\60\31\2\u01ef"+
		"\u01f0\7G\2\2\u01f0]\3\2\2\2\u01f1\u01f2\7@\2\2\u01f2_\3\2\2\2\u01f3\u01f4"+
		"\7C\2\2\u01f4a\3\2\2\2\u01f5\u01f6\7D\2\2\u01f6c\3\2\2\2\u01f7\u01f8\7"+
		"E\2\2\u01f8e\3\2\2\2\u01f9\u01fa\7?\2\2\u01fag\3\2\2\2\60inw~\u0082\u008a"+
		"\u008f\u0094\u0098\u00a6\u00ab\u00b0\u00ba\u00c2\u00cc\u00d0\u00db\u00e1"+
		"\u00e5\u00ed\u00f4\u00ff\u0108\u010e\u0115\u0119\u0125\u0130\u0136\u013a"+
		"\u0147\u0153\u015e\u0169\u0171\u017d\u0188\u0191\u019c\u019e\u01ae\u01b7"+
		"\u01c4\u01d1\u01de\u01e5";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}