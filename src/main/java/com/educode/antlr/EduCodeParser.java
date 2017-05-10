// Generated from C:/EduCode/EduCode-P4/src\EduCode.g4 by ANTLR 4.7
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
		T__38=39, T__39=40, T__40=41, T__41=42, T__42=43, T__43=44, ASSIGNMENT_OPERATOR=45, 
		ADDITIVE_OPERATOR=46, MULTIPLICATIVE_OPERATOR=47, AND_OPERATOR=48, OR_OPERATOR=49, 
		UNARY_OPERATOR=50, RELATIVE_OPERATOR=51, EQUALITY_OPERATOR=52, NEWLINE=53, 
		NUMBER_LITERAL=54, STRING_LITERAL=55, UNTERMINATED_STRING_LITERAL=56, 
		BOOL_LITERAL=57, NULL_LITERAL=58, IDENTIFIER=59, LPAREN=60, RPAREN=61, 
		WHITESPACE=62, LINECOMMENT=63;
	public static final int
		RULE_start = 0, RULE_usings = 1, RULE_program = 2, RULE_event_definition = 3, 
		RULE_method_declaration = 4, RULE_argument_list = 5, RULE_parameter_list = 6, 
		RULE_parameter = 7, RULE_statement_list = 8, RULE_statement = 9, RULE_iterative_statement = 10, 
		RULE_break_statement = 11, RULE_continue_statement = 12, RULE_return_statement = 13, 
		RULE_repeat_statement = 14, RULE_if_statement = 15, RULE_foreach_statement = 16, 
		RULE_variable_declaration = 17, RULE_declarator = 18, RULE_expression = 19, 
		RULE_assignment_expression = 20, RULE_logic_expression = 21, RULE_or_expression = 22, 
		RULE_and_expression = 23, RULE_equality_expression = 24, RULE_relative_expression = 25, 
		RULE_arithmetic_expression = 26, RULE_additive_expression = 27, RULE_multiplicative_expression = 28, 
		RULE_factor = 29, RULE_access = 30, RULE_field_access = 31, RULE_element_access = 32, 
		RULE_method_access = 33, RULE_subfactor = 34, RULE_parenthesis_expression = 35, 
		RULE_method_call = 36, RULE_type_cast = 37, RULE_object_instantiation = 38, 
		RULE_event_type = 39, RULE_data_type = 40, RULE_literal = 41, RULE_string_literal = 42, 
		RULE_coordinate_literal = 43, RULE_number_literal = 44, RULE_bool_literal = 45, 
		RULE_null_literal = 46, RULE_identifier = 47, RULE_end_of_line = 48;
	public static final String[] ruleNames = {
		"start", "usings", "program", "event_definition", "method_declaration", 
		"argument_list", "parameter_list", "parameter", "statement_list", "statement", 
		"iterative_statement", "break_statement", "continue_statement", "return_statement", 
		"repeat_statement", "if_statement", "foreach_statement", "variable_declaration", 
		"declarator", "expression", "assignment_expression", "logic_expression", 
		"or_expression", "and_expression", "equality_expression", "relative_expression", 
		"arithmetic_expression", "additive_expression", "multiplicative_expression", 
		"factor", "access", "field_access", "element_access", "method_access", 
		"subfactor", "parenthesis_expression", "method_call", "type_cast", "object_instantiation", 
		"event_type", "data_type", "literal", "string_literal", "coordinate_literal", 
		"number_literal", "bool_literal", "null_literal", "identifier", "end_of_line"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'using'", "'program'", "'end program'", "'on event'", "'call'", 
		"'method'", "'returns'", "'end method'", "','", "'break'", "'continue'", 
		"'return'", "'repeat while'", "'end repeat'", "'if'", "'then'", "'else if'", 
		"'else'", "'end if'", "'foreach'", "'in'", "'end foreach'", "'='", "'.'", 
		"'['", "']'", "'new'", "'robotDeath'", "'robotAttacked'", "'entityDeath'", 
		"'chatMessage'", "'stringMessageReceived'", "'entityMessageReceived'", 
		"'number'", "'bool'", "'Coordinates'", "'string'", "'Collection'", "'<'", 
		"'>'", "'Block'", "'Entity'", "'Item'", "'Texture'", null, null, null, 
		"'and'", "'or'", null, null, null, null, null, null, null, null, "'null'", 
		null, "'('", "')'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, "ASSIGNMENT_OPERATOR", 
		"ADDITIVE_OPERATOR", "MULTIPLICATIVE_OPERATOR", "AND_OPERATOR", "OR_OPERATOR", 
		"UNARY_OPERATOR", "RELATIVE_OPERATOR", "EQUALITY_OPERATOR", "NEWLINE", 
		"NUMBER_LITERAL", "STRING_LITERAL", "UNTERMINATED_STRING_LITERAL", "BOOL_LITERAL", 
		"NULL_LITERAL", "IDENTIFIER", "LPAREN", "RPAREN", "WHITESPACE", "LINECOMMENT"
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
			setState(99);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__0) {
				{
				setState(98);
				((StartContext)_localctx).ulist = usings();
				}
			}

			setState(101);
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
			enterOuterAlt(_localctx, 1);
			{
			setState(103);
			match(T__0);
			setState(104);
			((UsingsContext)_localctx).identifier = identifier();
			((UsingsContext)_localctx).id.add(((UsingsContext)_localctx).identifier);
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
			setState(119);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__0) {
				{
				{
				setState(110);
				match(T__0);
				setState(111);
				((UsingsContext)_localctx).identifier = identifier();
				((UsingsContext)_localctx).id.add(((UsingsContext)_localctx).identifier);
				setState(113); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(112);
					end_of_line();
					}
					}
					setState(115); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==NEWLINE );
				}
				}
				setState(121);
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
			setState(122);
			match(T__1);
			setState(123);
			((ProgramContext)_localctx).id = identifier();
			setState(125); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(124);
				end_of_line();
				}
				}
				setState(127); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==NEWLINE );
			setState(141);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__3) | (1L << T__5) | (1L << T__33) | (1L << T__34) | (1L << T__35) | (1L << T__36) | (1L << T__37) | (1L << T__40) | (1L << T__41) | (1L << T__42) | (1L << T__43))) != 0)) {
				{
				{
				setState(132);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__3:
					{
					setState(129);
					((ProgramContext)_localctx).event_definition = event_definition();
					((ProgramContext)_localctx).el.add(((ProgramContext)_localctx).event_definition);
					}
					break;
				case T__5:
					{
					setState(130);
					((ProgramContext)_localctx).method_declaration = method_declaration();
					((ProgramContext)_localctx).ml.add(((ProgramContext)_localctx).method_declaration);
					}
					break;
				case T__33:
				case T__34:
				case T__35:
				case T__36:
				case T__37:
				case T__40:
				case T__41:
				case T__42:
				case T__43:
					{
					setState(131);
					((ProgramContext)_localctx).variable_declaration = variable_declaration();
					((ProgramContext)_localctx).vl.add(((ProgramContext)_localctx).variable_declaration);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(135); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(134);
					end_of_line();
					}
					}
					setState(137); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==NEWLINE );
				}
				}
				setState(143);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(144);
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
			setState(146);
			match(T__3);
			setState(147);
			((Event_definitionContext)_localctx).event = event_type();
			setState(148);
			match(T__4);
			setState(149);
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
			setState(151);
			match(T__5);
			setState(152);
			((Method_declarationContext)_localctx).id = identifier();
			setState(153);
			match(LPAREN);
			setState(155);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__33) | (1L << T__34) | (1L << T__35) | (1L << T__36) | (1L << T__37) | (1L << T__40) | (1L << T__41) | (1L << T__42) | (1L << T__43))) != 0)) {
				{
				setState(154);
				((Method_declarationContext)_localctx).params = parameter_list();
				}
			}

			setState(157);
			match(RPAREN);
			setState(160);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__6) {
				{
				setState(158);
				match(T__6);
				setState(159);
				((Method_declarationContext)_localctx).type = data_type();
				}
			}

			setState(163); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(162);
				end_of_line();
				}
				}
				setState(165); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==NEWLINE );
			setState(167);
			((Method_declarationContext)_localctx).body = statement_list();
			setState(168);
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
		public ExpressionContext expression;
		public List<ExpressionContext> exprs = new ArrayList<ExpressionContext>();
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
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
			setState(170);
			((Argument_listContext)_localctx).expression = expression();
			((Argument_listContext)_localctx).exprs.add(((Argument_listContext)_localctx).expression);
			setState(175);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__8) {
				{
				{
				setState(171);
				match(T__8);
				setState(172);
				((Argument_listContext)_localctx).expression = expression();
				((Argument_listContext)_localctx).exprs.add(((Argument_listContext)_localctx).expression);
				}
				}
				setState(177);
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
			setState(178);
			((Parameter_listContext)_localctx).parameter = parameter();
			((Parameter_listContext)_localctx).params.add(((Parameter_listContext)_localctx).parameter);
			setState(183);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__8) {
				{
				{
				setState(179);
				match(T__8);
				setState(180);
				((Parameter_listContext)_localctx).parameter = parameter();
				((Parameter_listContext)_localctx).params.add(((Parameter_listContext)_localctx).parameter);
				}
				}
				setState(185);
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
			setState(186);
			((ParameterContext)_localctx).type = data_type();
			setState(187);
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
			setState(197);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__14) | (1L << T__19) | (1L << T__26) | (1L << T__33) | (1L << T__34) | (1L << T__35) | (1L << T__36) | (1L << T__37) | (1L << T__40) | (1L << T__41) | (1L << T__42) | (1L << T__43) | (1L << UNARY_OPERATOR) | (1L << NUMBER_LITERAL) | (1L << STRING_LITERAL) | (1L << BOOL_LITERAL) | (1L << NULL_LITERAL) | (1L << IDENTIFIER) | (1L << LPAREN))) != 0)) {
				{
				{
				setState(189);
				((Statement_listContext)_localctx).statement = statement();
				((Statement_listContext)_localctx).statements.add(((Statement_listContext)_localctx).statement);
				setState(191); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(190);
					end_of_line();
					}
					}
					setState(193); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==NEWLINE );
				}
				}
				setState(199);
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
		public Method_callContext method_call() {
			return getRuleContext(Method_callContext.class,0);
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
			setState(208);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(200);
				method_call();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(201);
				assignment_expression();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(202);
				variable_declaration();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(203);
				if_statement();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(204);
				iterative_statement();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(205);
				return_statement();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(206);
				break_statement();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(207);
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
		enterRule(_localctx, 20, RULE_iterative_statement);
		try {
			setState(212);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__12:
				enterOuterAlt(_localctx, 1);
				{
				setState(210);
				repeat_statement();
				}
				break;
			case T__19:
				enterOuterAlt(_localctx, 2);
				{
				setState(211);
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
		enterRule(_localctx, 22, RULE_break_statement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(214);
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
		enterRule(_localctx, 24, RULE_continue_statement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(216);
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
		public ExpressionContext expr;
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
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
		enterRule(_localctx, 26, RULE_return_statement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(218);
			match(T__11);
			setState(220);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__26) | (1L << UNARY_OPERATOR) | (1L << NUMBER_LITERAL) | (1L << STRING_LITERAL) | (1L << BOOL_LITERAL) | (1L << NULL_LITERAL) | (1L << IDENTIFIER) | (1L << LPAREN))) != 0)) {
				{
				setState(219);
				((Return_statementContext)_localctx).expr = expression();
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
		public Statement_listContext bode;
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
		enterRule(_localctx, 28, RULE_repeat_statement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(222);
			match(T__12);
			setState(223);
			((Repeat_statementContext)_localctx).predicate = logic_expression();
			setState(225); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(224);
				end_of_line();
				}
				}
				setState(227); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==NEWLINE );
			setState(229);
			((Repeat_statementContext)_localctx).bode = statement_list();
			setState(230);
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
		public List<Logic_expressionContext> predicate = new ArrayList<Logic_expressionContext>();
		public Statement_listContext statement_list;
		public List<Statement_listContext> body = new ArrayList<Statement_listContext>();
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
		enterRule(_localctx, 30, RULE_if_statement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(232);
			match(T__14);
			setState(233);
			((If_statementContext)_localctx).logic_expression = logic_expression();
			((If_statementContext)_localctx).predicate.add(((If_statementContext)_localctx).logic_expression);
			setState(234);
			match(T__15);
			setState(236); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(235);
				end_of_line();
				}
				}
				setState(238); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==NEWLINE );
			setState(240);
			((If_statementContext)_localctx).statement_list = statement_list();
			((If_statementContext)_localctx).body.add(((If_statementContext)_localctx).statement_list);
			setState(253);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__16) {
				{
				{
				setState(241);
				match(T__16);
				setState(242);
				((If_statementContext)_localctx).logic_expression = logic_expression();
				((If_statementContext)_localctx).predicate.add(((If_statementContext)_localctx).logic_expression);
				setState(243);
				match(T__15);
				setState(245); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(244);
					end_of_line();
					}
					}
					setState(247); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==NEWLINE );
				setState(249);
				((If_statementContext)_localctx).statement_list = statement_list();
				((If_statementContext)_localctx).body.add(((If_statementContext)_localctx).statement_list);
				}
				}
				setState(255);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(264);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__17) {
				{
				setState(256);
				match(T__17);
				setState(258); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(257);
					end_of_line();
					}
					}
					setState(260); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==NEWLINE );
				setState(262);
				((If_statementContext)_localctx).elseBody = statement_list();
				}
			}

			setState(266);
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
		public ExpressionContext expr;
		public Statement_listContext body;
		public Data_typeContext data_type() {
			return getRuleContext(Data_typeContext.class,0);
		}
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
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
		enterRule(_localctx, 32, RULE_foreach_statement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(268);
			match(T__19);
			setState(269);
			((Foreach_statementContext)_localctx).type = data_type();
			setState(270);
			((Foreach_statementContext)_localctx).id = identifier();
			setState(271);
			match(T__20);
			setState(272);
			((Foreach_statementContext)_localctx).expr = expression();
			setState(274); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(273);
				end_of_line();
				}
				}
				setState(276); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==NEWLINE );
			setState(278);
			((Foreach_statementContext)_localctx).body = statement_list();
			setState(279);
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
		public List<DeclaratorContext> decl = new ArrayList<DeclaratorContext>();
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
		enterRule(_localctx, 34, RULE_variable_declaration);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(281);
			((Variable_declarationContext)_localctx).type = data_type();
			setState(282);
			((Variable_declarationContext)_localctx).declarator = declarator();
			((Variable_declarationContext)_localctx).decl.add(((Variable_declarationContext)_localctx).declarator);
			{
			setState(283);
			match(T__8);
			setState(284);
			((Variable_declarationContext)_localctx).declarator = declarator();
			((Variable_declarationContext)_localctx).decl.add(((Variable_declarationContext)_localctx).declarator);
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
		enterRule(_localctx, 36, RULE_declarator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(286);
			((DeclaratorContext)_localctx).id = identifier();
			setState(289);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__22) {
				{
				setState(287);
				match(T__22);
				setState(288);
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
		enterRule(_localctx, 38, RULE_expression);
		try {
			setState(293);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,26,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(291);
				assignment_expression();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(292);
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
		public FactorContext lhs;
		public Token op;
		public ExpressionContext rhs;
		public FactorContext factor() {
			return getRuleContext(FactorContext.class,0);
		}
		public TerminalNode ASSIGNMENT_OPERATOR() { return getToken(EduCodeParser.ASSIGNMENT_OPERATOR, 0); }
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
		enterRule(_localctx, 40, RULE_assignment_expression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(295);
			((Assignment_expressionContext)_localctx).lhs = factor();
			setState(296);
			((Assignment_expressionContext)_localctx).op = match(ASSIGNMENT_OPERATOR);
			setState(297);
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
		enterRule(_localctx, 42, RULE_logic_expression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(299);
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
		public And_expressionContext and_expression() {
			return getRuleContext(And_expressionContext.class,0);
		}
		public Or_expressionContext or_expression() {
			return getRuleContext(Or_expressionContext.class,0);
		}
		public TerminalNode OR_OPERATOR() { return getToken(EduCodeParser.OR_OPERATOR, 0); }
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
		int _startState = 44;
		enterRecursionRule(_localctx, 44, RULE_or_expression, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(302);
			and_expression(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(309);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,27,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new Or_expressionContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_or_expression);
					setState(304);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(305);
					match(OR_OPERATOR);
					setState(306);
					and_expression(0);
					}
					} 
				}
				setState(311);
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

	public static class And_expressionContext extends ParserRuleContext {
		public Equality_expressionContext equality_expression() {
			return getRuleContext(Equality_expressionContext.class,0);
		}
		public And_expressionContext and_expression() {
			return getRuleContext(And_expressionContext.class,0);
		}
		public TerminalNode AND_OPERATOR() { return getToken(EduCodeParser.AND_OPERATOR, 0); }
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
		int _startState = 46;
		enterRecursionRule(_localctx, 46, RULE_and_expression, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(313);
			equality_expression(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(320);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,28,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new And_expressionContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_and_expression);
					setState(315);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(316);
					match(AND_OPERATOR);
					setState(317);
					equality_expression(0);
					}
					} 
				}
				setState(322);
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

	public static class Equality_expressionContext extends ParserRuleContext {
		public Relative_expressionContext relative_expression() {
			return getRuleContext(Relative_expressionContext.class,0);
		}
		public Equality_expressionContext equality_expression() {
			return getRuleContext(Equality_expressionContext.class,0);
		}
		public TerminalNode EQUALITY_OPERATOR() { return getToken(EduCodeParser.EQUALITY_OPERATOR, 0); }
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
		int _startState = 48;
		enterRecursionRule(_localctx, 48, RULE_equality_expression, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(324);
			relative_expression();
			}
			_ctx.stop = _input.LT(-1);
			setState(331);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,29,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new Equality_expressionContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_equality_expression);
					setState(326);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(327);
					match(EQUALITY_OPERATOR);
					setState(328);
					relative_expression();
					}
					} 
				}
				setState(333);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,29,_ctx);
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
		public List<Arithmetic_expressionContext> arithmetic_expression() {
			return getRuleContexts(Arithmetic_expressionContext.class);
		}
		public Arithmetic_expressionContext arithmetic_expression(int i) {
			return getRuleContext(Arithmetic_expressionContext.class,i);
		}
		public TerminalNode RELATIVE_OPERATOR() { return getToken(EduCodeParser.RELATIVE_OPERATOR, 0); }
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
		enterRule(_localctx, 50, RULE_relative_expression);
		try {
			setState(339);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,30,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(334);
				arithmetic_expression();
				setState(335);
				match(RELATIVE_OPERATOR);
				setState(336);
				arithmetic_expression();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(338);
				arithmetic_expression();
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
		enterRule(_localctx, 52, RULE_arithmetic_expression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(341);
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
		public Multiplicative_expressionContext multiplicative_expression() {
			return getRuleContext(Multiplicative_expressionContext.class,0);
		}
		public Additive_expressionContext additive_expression() {
			return getRuleContext(Additive_expressionContext.class,0);
		}
		public TerminalNode ADDITIVE_OPERATOR() { return getToken(EduCodeParser.ADDITIVE_OPERATOR, 0); }
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
		int _startState = 54;
		enterRecursionRule(_localctx, 54, RULE_additive_expression, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(344);
			multiplicative_expression(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(351);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,31,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new Additive_expressionContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_additive_expression);
					setState(346);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(347);
					match(ADDITIVE_OPERATOR);
					setState(348);
					multiplicative_expression(0);
					}
					} 
				}
				setState(353);
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

	public static class Multiplicative_expressionContext extends ParserRuleContext {
		public FactorContext factor() {
			return getRuleContext(FactorContext.class,0);
		}
		public Multiplicative_expressionContext multiplicative_expression() {
			return getRuleContext(Multiplicative_expressionContext.class,0);
		}
		public TerminalNode MULTIPLICATIVE_OPERATOR() { return getToken(EduCodeParser.MULTIPLICATIVE_OPERATOR, 0); }
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
		int _startState = 56;
		enterRecursionRule(_localctx, 56, RULE_multiplicative_expression, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(355);
			factor();
			}
			_ctx.stop = _input.LT(-1);
			setState(362);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,32,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new Multiplicative_expressionContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_multiplicative_expression);
					setState(357);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(358);
					match(MULTIPLICATIVE_OPERATOR);
					setState(359);
					factor();
					}
					} 
				}
				setState(364);
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
		public Object_instantiationContext object_instantiation() {
			return getRuleContext(Object_instantiationContext.class,0);
		}
		public TerminalNode UNARY_OPERATOR() { return getToken(EduCodeParser.UNARY_OPERATOR, 0); }
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
		enterRule(_localctx, 58, RULE_factor);
		try {
			setState(371);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,33,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(365);
				literal();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(366);
				object_instantiation();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(367);
				match(UNARY_OPERATOR);
				setState(368);
				factor();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(369);
				type_cast();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(370);
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
		public SubfactorContext subfactor() {
			return getRuleContext(SubfactorContext.class,0);
		}
		public AccessContext access() {
			return getRuleContext(AccessContext.class,0);
		}
		public Field_accessContext field_access() {
			return getRuleContext(Field_accessContext.class,0);
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
		int _startState = 60;
		enterRecursionRule(_localctx, 60, RULE_access, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(374);
			subfactor();
			}
			_ctx.stop = _input.LT(-1);
			setState(384);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,35,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(382);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,34,_ctx) ) {
					case 1:
						{
						_localctx = new AccessContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_access);
						setState(376);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(377);
						field_access();
						}
						break;
					case 2:
						{
						_localctx = new AccessContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_access);
						setState(378);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(379);
						element_access();
						}
						break;
					case 3:
						{
						_localctx = new AccessContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_access);
						setState(380);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(381);
						method_access();
						}
						break;
					}
					} 
				}
				setState(386);
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

	public static class Field_accessContext extends ParserRuleContext {
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
		enterRule(_localctx, 62, RULE_field_access);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(387);
			match(T__23);
			setState(388);
			identifier();
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
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
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
		enterRule(_localctx, 64, RULE_element_access);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(390);
			match(T__24);
			setState(391);
			expression();
			setState(392);
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

	public static class Method_accessContext extends ParserRuleContext {
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
		enterRule(_localctx, 66, RULE_method_access);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(394);
			match(T__23);
			setState(395);
			method_call();
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
		enterRule(_localctx, 68, RULE_subfactor);
		try {
			setState(400);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,36,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(397);
				parenthesis_expression();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(398);
				identifier();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(399);
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
		public TerminalNode LPAREN() { return getToken(EduCodeParser.LPAREN, 0); }
		public Logic_expressionContext logic_expression() {
			return getRuleContext(Logic_expressionContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(EduCodeParser.RPAREN, 0); }
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
		enterRule(_localctx, 70, RULE_parenthesis_expression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(402);
			match(LPAREN);
			setState(403);
			logic_expression();
			setState(404);
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
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TerminalNode LPAREN() { return getToken(EduCodeParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(EduCodeParser.RPAREN, 0); }
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
		enterRule(_localctx, 72, RULE_method_call);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(406);
			identifier();
			setState(407);
			match(LPAREN);
			setState(409);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__26) | (1L << UNARY_OPERATOR) | (1L << NUMBER_LITERAL) | (1L << STRING_LITERAL) | (1L << BOOL_LITERAL) | (1L << NULL_LITERAL) | (1L << IDENTIFIER) | (1L << LPAREN))) != 0)) {
				{
				setState(408);
				argument_list();
				}
			}

			setState(411);
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
		public TerminalNode LPAREN() { return getToken(EduCodeParser.LPAREN, 0); }
		public Data_typeContext data_type() {
			return getRuleContext(Data_typeContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(EduCodeParser.RPAREN, 0); }
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
		enterRule(_localctx, 74, RULE_type_cast);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(413);
			match(LPAREN);
			setState(414);
			data_type();
			setState(415);
			match(RPAREN);
			setState(416);
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

	public static class Object_instantiationContext extends ParserRuleContext {
		public Data_typeContext data_type() {
			return getRuleContext(Data_typeContext.class,0);
		}
		public TerminalNode LPAREN() { return getToken(EduCodeParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(EduCodeParser.RPAREN, 0); }
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
		enterRule(_localctx, 76, RULE_object_instantiation);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(418);
			match(T__26);
			setState(419);
			data_type();
			setState(420);
			match(LPAREN);
			setState(422);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__26) | (1L << UNARY_OPERATOR) | (1L << NUMBER_LITERAL) | (1L << STRING_LITERAL) | (1L << BOOL_LITERAL) | (1L << NULL_LITERAL) | (1L << IDENTIFIER) | (1L << LPAREN))) != 0)) {
				{
				setState(421);
				argument_list();
				}
			}

			setState(424);
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
		public TerminalNode LPAREN() { return getToken(EduCodeParser.LPAREN, 0); }
		public Number_literalContext number_literal() {
			return getRuleContext(Number_literalContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(EduCodeParser.RPAREN, 0); }
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
		enterRule(_localctx, 78, RULE_event_type);
		int _la;
		try {
			setState(435);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__27:
				enterOuterAlt(_localctx, 1);
				{
				setState(426);
				match(T__27);
				}
				break;
			case T__28:
				enterOuterAlt(_localctx, 2);
				{
				setState(427);
				match(T__28);
				}
				break;
			case T__29:
				enterOuterAlt(_localctx, 3);
				{
				setState(428);
				match(T__29);
				}
				break;
			case T__30:
				enterOuterAlt(_localctx, 4);
				{
				setState(429);
				match(T__30);
				}
				break;
			case T__31:
			case T__32:
				enterOuterAlt(_localctx, 5);
				{
				setState(430);
				_la = _input.LA(1);
				if ( !(_la==T__31 || _la==T__32) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(431);
				match(LPAREN);
				setState(432);
				number_literal();
				setState(433);
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
		enterRule(_localctx, 80, RULE_data_type);
		try {
			setState(450);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__33:
				enterOuterAlt(_localctx, 1);
				{
				setState(437);
				match(T__33);
				}
				break;
			case T__34:
				enterOuterAlt(_localctx, 2);
				{
				setState(438);
				match(T__34);
				}
				break;
			case T__35:
				enterOuterAlt(_localctx, 3);
				{
				setState(439);
				match(T__35);
				}
				break;
			case T__36:
				enterOuterAlt(_localctx, 4);
				{
				setState(440);
				match(T__36);
				}
				break;
			case T__37:
				enterOuterAlt(_localctx, 5);
				{
				setState(441);
				match(T__37);
				setState(442);
				match(T__38);
				setState(443);
				data_type();
				setState(444);
				match(T__39);
				}
				break;
			case T__40:
				enterOuterAlt(_localctx, 6);
				{
				setState(446);
				match(T__40);
				}
				break;
			case T__41:
				enterOuterAlt(_localctx, 7);
				{
				setState(447);
				match(T__41);
				}
				break;
			case T__42:
				enterOuterAlt(_localctx, 8);
				{
				setState(448);
				match(T__42);
				}
				break;
			case T__43:
				enterOuterAlt(_localctx, 9);
				{
				setState(449);
				match(T__43);
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
		enterRule(_localctx, 82, RULE_literal);
		try {
			setState(457);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case BOOL_LITERAL:
				enterOuterAlt(_localctx, 1);
				{
				setState(452);
				bool_literal();
				}
				break;
			case STRING_LITERAL:
				enterOuterAlt(_localctx, 2);
				{
				setState(453);
				string_literal();
				}
				break;
			case NUMBER_LITERAL:
				enterOuterAlt(_localctx, 3);
				{
				setState(454);
				number_literal();
				}
				break;
			case LPAREN:
				enterOuterAlt(_localctx, 4);
				{
				setState(455);
				coordinate_literal();
				}
				break;
			case NULL_LITERAL:
				enterOuterAlt(_localctx, 5);
				{
				setState(456);
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
		enterRule(_localctx, 84, RULE_string_literal);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(459);
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
		public TerminalNode LPAREN() { return getToken(EduCodeParser.LPAREN, 0); }
		public List<Logic_expressionContext> logic_expression() {
			return getRuleContexts(Logic_expressionContext.class);
		}
		public Logic_expressionContext logic_expression(int i) {
			return getRuleContext(Logic_expressionContext.class,i);
		}
		public TerminalNode RPAREN() { return getToken(EduCodeParser.RPAREN, 0); }
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
		enterRule(_localctx, 86, RULE_coordinate_literal);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(461);
			match(LPAREN);
			setState(462);
			logic_expression();
			setState(463);
			match(T__8);
			setState(464);
			logic_expression();
			setState(465);
			match(T__8);
			setState(466);
			logic_expression();
			setState(467);
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
		enterRule(_localctx, 88, RULE_number_literal);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(469);
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
		enterRule(_localctx, 90, RULE_bool_literal);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(471);
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
		enterRule(_localctx, 92, RULE_null_literal);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(473);
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
		enterRule(_localctx, 94, RULE_identifier);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(475);
			match(IDENTIFIER);
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
		enterRule(_localctx, 96, RULE_end_of_line);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(477);
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
		case 22:
			return or_expression_sempred((Or_expressionContext)_localctx, predIndex);
		case 23:
			return and_expression_sempred((And_expressionContext)_localctx, predIndex);
		case 24:
			return equality_expression_sempred((Equality_expressionContext)_localctx, predIndex);
		case 27:
			return additive_expression_sempred((Additive_expressionContext)_localctx, predIndex);
		case 28:
			return multiplicative_expression_sempred((Multiplicative_expressionContext)_localctx, predIndex);
		case 30:
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3A\u01e2\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\3\2\5\2f\n\2\3\2"+
		"\3\2\3\3\3\3\3\3\6\3m\n\3\r\3\16\3n\3\3\3\3\3\3\6\3t\n\3\r\3\16\3u\7\3"+
		"x\n\3\f\3\16\3{\13\3\3\4\3\4\3\4\6\4\u0080\n\4\r\4\16\4\u0081\3\4\3\4"+
		"\3\4\5\4\u0087\n\4\3\4\6\4\u008a\n\4\r\4\16\4\u008b\7\4\u008e\n\4\f\4"+
		"\16\4\u0091\13\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\5\6\u009e"+
		"\n\6\3\6\3\6\3\6\5\6\u00a3\n\6\3\6\6\6\u00a6\n\6\r\6\16\6\u00a7\3\6\3"+
		"\6\3\6\3\7\3\7\3\7\7\7\u00b0\n\7\f\7\16\7\u00b3\13\7\3\b\3\b\3\b\7\b\u00b8"+
		"\n\b\f\b\16\b\u00bb\13\b\3\t\3\t\3\t\3\n\3\n\6\n\u00c2\n\n\r\n\16\n\u00c3"+
		"\7\n\u00c6\n\n\f\n\16\n\u00c9\13\n\3\13\3\13\3\13\3\13\3\13\3\13\3\13"+
		"\3\13\5\13\u00d3\n\13\3\f\3\f\5\f\u00d7\n\f\3\r\3\r\3\16\3\16\3\17\3\17"+
		"\5\17\u00df\n\17\3\20\3\20\3\20\6\20\u00e4\n\20\r\20\16\20\u00e5\3\20"+
		"\3\20\3\20\3\21\3\21\3\21\3\21\6\21\u00ef\n\21\r\21\16\21\u00f0\3\21\3"+
		"\21\3\21\3\21\3\21\6\21\u00f8\n\21\r\21\16\21\u00f9\3\21\3\21\7\21\u00fe"+
		"\n\21\f\21\16\21\u0101\13\21\3\21\3\21\6\21\u0105\n\21\r\21\16\21\u0106"+
		"\3\21\3\21\5\21\u010b\n\21\3\21\3\21\3\22\3\22\3\22\3\22\3\22\3\22\6\22"+
		"\u0115\n\22\r\22\16\22\u0116\3\22\3\22\3\22\3\23\3\23\3\23\3\23\3\23\3"+
		"\24\3\24\3\24\5\24\u0124\n\24\3\25\3\25\5\25\u0128\n\25\3\26\3\26\3\26"+
		"\3\26\3\27\3\27\3\30\3\30\3\30\3\30\3\30\3\30\7\30\u0136\n\30\f\30\16"+
		"\30\u0139\13\30\3\31\3\31\3\31\3\31\3\31\3\31\7\31\u0141\n\31\f\31\16"+
		"\31\u0144\13\31\3\32\3\32\3\32\3\32\3\32\3\32\7\32\u014c\n\32\f\32\16"+
		"\32\u014f\13\32\3\33\3\33\3\33\3\33\3\33\5\33\u0156\n\33\3\34\3\34\3\35"+
		"\3\35\3\35\3\35\3\35\3\35\7\35\u0160\n\35\f\35\16\35\u0163\13\35\3\36"+
		"\3\36\3\36\3\36\3\36\3\36\7\36\u016b\n\36\f\36\16\36\u016e\13\36\3\37"+
		"\3\37\3\37\3\37\3\37\3\37\5\37\u0176\n\37\3 \3 \3 \3 \3 \3 \3 \3 \3 \7"+
		" \u0181\n \f \16 \u0184\13 \3!\3!\3!\3\"\3\"\3\"\3\"\3#\3#\3#\3$\3$\3"+
		"$\5$\u0193\n$\3%\3%\3%\3%\3&\3&\3&\5&\u019c\n&\3&\3&\3\'\3\'\3\'\3\'\3"+
		"\'\3(\3(\3(\3(\5(\u01a9\n(\3(\3(\3)\3)\3)\3)\3)\3)\3)\3)\3)\5)\u01b6\n"+
		")\3*\3*\3*\3*\3*\3*\3*\3*\3*\3*\3*\3*\3*\5*\u01c5\n*\3+\3+\3+\3+\3+\5"+
		"+\u01cc\n+\3,\3,\3-\3-\3-\3-\3-\3-\3-\3-\3.\3.\3/\3/\3\60\3\60\3\61\3"+
		"\61\3\62\3\62\3\62\2\b.\60\628:>\63\2\4\6\b\n\f\16\20\22\24\26\30\32\34"+
		"\36 \"$&(*,.\60\62\64\668:<>@BDFHJLNPRTVXZ\\^`b\2\3\3\2\"#\2\u01f3\2e"+
		"\3\2\2\2\4i\3\2\2\2\6|\3\2\2\2\b\u0094\3\2\2\2\n\u0099\3\2\2\2\f\u00ac"+
		"\3\2\2\2\16\u00b4\3\2\2\2\20\u00bc\3\2\2\2\22\u00c7\3\2\2\2\24\u00d2\3"+
		"\2\2\2\26\u00d6\3\2\2\2\30\u00d8\3\2\2\2\32\u00da\3\2\2\2\34\u00dc\3\2"+
		"\2\2\36\u00e0\3\2\2\2 \u00ea\3\2\2\2\"\u010e\3\2\2\2$\u011b\3\2\2\2&\u0120"+
		"\3\2\2\2(\u0127\3\2\2\2*\u0129\3\2\2\2,\u012d\3\2\2\2.\u012f\3\2\2\2\60"+
		"\u013a\3\2\2\2\62\u0145\3\2\2\2\64\u0155\3\2\2\2\66\u0157\3\2\2\28\u0159"+
		"\3\2\2\2:\u0164\3\2\2\2<\u0175\3\2\2\2>\u0177\3\2\2\2@\u0185\3\2\2\2B"+
		"\u0188\3\2\2\2D\u018c\3\2\2\2F\u0192\3\2\2\2H\u0194\3\2\2\2J\u0198\3\2"+
		"\2\2L\u019f\3\2\2\2N\u01a4\3\2\2\2P\u01b5\3\2\2\2R\u01c4\3\2\2\2T\u01cb"+
		"\3\2\2\2V\u01cd\3\2\2\2X\u01cf\3\2\2\2Z\u01d7\3\2\2\2\\\u01d9\3\2\2\2"+
		"^\u01db\3\2\2\2`\u01dd\3\2\2\2b\u01df\3\2\2\2df\5\4\3\2ed\3\2\2\2ef\3"+
		"\2\2\2fg\3\2\2\2gh\5\6\4\2h\3\3\2\2\2ij\7\3\2\2jl\5`\61\2km\5b\62\2lk"+
		"\3\2\2\2mn\3\2\2\2nl\3\2\2\2no\3\2\2\2oy\3\2\2\2pq\7\3\2\2qs\5`\61\2r"+
		"t\5b\62\2sr\3\2\2\2tu\3\2\2\2us\3\2\2\2uv\3\2\2\2vx\3\2\2\2wp\3\2\2\2"+
		"x{\3\2\2\2yw\3\2\2\2yz\3\2\2\2z\5\3\2\2\2{y\3\2\2\2|}\7\4\2\2}\177\5`"+
		"\61\2~\u0080\5b\62\2\177~\3\2\2\2\u0080\u0081\3\2\2\2\u0081\177\3\2\2"+
		"\2\u0081\u0082\3\2\2\2\u0082\u008f\3\2\2\2\u0083\u0087\5\b\5\2\u0084\u0087"+
		"\5\n\6\2\u0085\u0087\5$\23\2\u0086\u0083\3\2\2\2\u0086\u0084\3\2\2\2\u0086"+
		"\u0085\3\2\2\2\u0087\u0089\3\2\2\2\u0088\u008a\5b\62\2\u0089\u0088\3\2"+
		"\2\2\u008a\u008b\3\2\2\2\u008b\u0089\3\2\2\2\u008b\u008c\3\2\2\2\u008c"+
		"\u008e\3\2\2\2\u008d\u0086\3\2\2\2\u008e\u0091\3\2\2\2\u008f\u008d\3\2"+
		"\2\2\u008f\u0090\3\2\2\2\u0090\u0092\3\2\2\2\u0091\u008f\3\2\2\2\u0092"+
		"\u0093\7\5\2\2\u0093\7\3\2\2\2\u0094\u0095\7\6\2\2\u0095\u0096\5P)\2\u0096"+
		"\u0097\7\7\2\2\u0097\u0098\5`\61\2\u0098\t\3\2\2\2\u0099\u009a\7\b\2\2"+
		"\u009a\u009b\5`\61\2\u009b\u009d\7>\2\2\u009c\u009e\5\16\b\2\u009d\u009c"+
		"\3\2\2\2\u009d\u009e\3\2\2\2\u009e\u009f\3\2\2\2\u009f\u00a2\7?\2\2\u00a0"+
		"\u00a1\7\t\2\2\u00a1\u00a3\5R*\2\u00a2\u00a0\3\2\2\2\u00a2\u00a3\3\2\2"+
		"\2\u00a3\u00a5\3\2\2\2\u00a4\u00a6\5b\62\2\u00a5\u00a4\3\2\2\2\u00a6\u00a7"+
		"\3\2\2\2\u00a7\u00a5\3\2\2\2\u00a7\u00a8\3\2\2\2\u00a8\u00a9\3\2\2\2\u00a9"+
		"\u00aa\5\22\n\2\u00aa\u00ab\7\n\2\2\u00ab\13\3\2\2\2\u00ac\u00b1\5(\25"+
		"\2\u00ad\u00ae\7\13\2\2\u00ae\u00b0\5(\25\2\u00af\u00ad\3\2\2\2\u00b0"+
		"\u00b3\3\2\2\2\u00b1\u00af\3\2\2\2\u00b1\u00b2\3\2\2\2\u00b2\r\3\2\2\2"+
		"\u00b3\u00b1\3\2\2\2\u00b4\u00b9\5\20\t\2\u00b5\u00b6\7\13\2\2\u00b6\u00b8"+
		"\5\20\t\2\u00b7\u00b5\3\2\2\2\u00b8\u00bb\3\2\2\2\u00b9\u00b7\3\2\2\2"+
		"\u00b9\u00ba\3\2\2\2\u00ba\17\3\2\2\2\u00bb\u00b9\3\2\2\2\u00bc\u00bd"+
		"\5R*\2\u00bd\u00be\5`\61\2\u00be\21\3\2\2\2\u00bf\u00c1\5\24\13\2\u00c0"+
		"\u00c2\5b\62\2\u00c1\u00c0\3\2\2\2\u00c2\u00c3\3\2\2\2\u00c3\u00c1\3\2"+
		"\2\2\u00c3\u00c4\3\2\2\2\u00c4\u00c6\3\2\2\2\u00c5\u00bf\3\2\2\2\u00c6"+
		"\u00c9\3\2\2\2\u00c7\u00c5\3\2\2\2\u00c7\u00c8\3\2\2\2\u00c8\23\3\2\2"+
		"\2\u00c9\u00c7\3\2\2\2\u00ca\u00d3\5J&\2\u00cb\u00d3\5*\26\2\u00cc\u00d3"+
		"\5$\23\2\u00cd\u00d3\5 \21\2\u00ce\u00d3\5\26\f\2\u00cf\u00d3\5\34\17"+
		"\2\u00d0\u00d3\5\30\r\2\u00d1\u00d3\5\32\16\2\u00d2\u00ca\3\2\2\2\u00d2"+
		"\u00cb\3\2\2\2\u00d2\u00cc\3\2\2\2\u00d2\u00cd\3\2\2\2\u00d2\u00ce\3\2"+
		"\2\2\u00d2\u00cf\3\2\2\2\u00d2\u00d0\3\2\2\2\u00d2\u00d1\3\2\2\2\u00d3"+
		"\25\3\2\2\2\u00d4\u00d7\5\36\20\2\u00d5\u00d7\5\"\22\2\u00d6\u00d4\3\2"+
		"\2\2\u00d6\u00d5\3\2\2\2\u00d7\27\3\2\2\2\u00d8\u00d9\7\f\2\2\u00d9\31"+
		"\3\2\2\2\u00da\u00db\7\r\2\2\u00db\33\3\2\2\2\u00dc\u00de\7\16\2\2\u00dd"+
		"\u00df\5(\25\2\u00de\u00dd\3\2\2\2\u00de\u00df\3\2\2\2\u00df\35\3\2\2"+
		"\2\u00e0\u00e1\7\17\2\2\u00e1\u00e3\5,\27\2\u00e2\u00e4\5b\62\2\u00e3"+
		"\u00e2\3\2\2\2\u00e4\u00e5\3\2\2\2\u00e5\u00e3\3\2\2\2\u00e5\u00e6\3\2"+
		"\2\2\u00e6\u00e7\3\2\2\2\u00e7\u00e8\5\22\n\2\u00e8\u00e9\7\20\2\2\u00e9"+
		"\37\3\2\2\2\u00ea\u00eb\7\21\2\2\u00eb\u00ec\5,\27\2\u00ec\u00ee\7\22"+
		"\2\2\u00ed\u00ef\5b\62\2\u00ee\u00ed\3\2\2\2\u00ef\u00f0\3\2\2\2\u00f0"+
		"\u00ee\3\2\2\2\u00f0\u00f1\3\2\2\2\u00f1\u00f2\3\2\2\2\u00f2\u00ff\5\22"+
		"\n\2\u00f3\u00f4\7\23\2\2\u00f4\u00f5\5,\27\2\u00f5\u00f7\7\22\2\2\u00f6"+
		"\u00f8\5b\62\2\u00f7\u00f6\3\2\2\2\u00f8\u00f9\3\2\2\2\u00f9\u00f7\3\2"+
		"\2\2\u00f9\u00fa\3\2\2\2\u00fa\u00fb\3\2\2\2\u00fb\u00fc\5\22\n\2\u00fc"+
		"\u00fe\3\2\2\2\u00fd\u00f3\3\2\2\2\u00fe\u0101\3\2\2\2\u00ff\u00fd\3\2"+
		"\2\2\u00ff\u0100\3\2\2\2\u0100\u010a\3\2\2\2\u0101\u00ff\3\2\2\2\u0102"+
		"\u0104\7\24\2\2\u0103\u0105\5b\62\2\u0104\u0103\3\2\2\2\u0105\u0106\3"+
		"\2\2\2\u0106\u0104\3\2\2\2\u0106\u0107\3\2\2\2\u0107\u0108\3\2\2\2\u0108"+
		"\u0109\5\22\n\2\u0109\u010b\3\2\2\2\u010a\u0102\3\2\2\2\u010a\u010b\3"+
		"\2\2\2\u010b\u010c\3\2\2\2\u010c\u010d\7\25\2\2\u010d!\3\2\2\2\u010e\u010f"+
		"\7\26\2\2\u010f\u0110\5R*\2\u0110\u0111\5`\61\2\u0111\u0112\7\27\2\2\u0112"+
		"\u0114\5(\25\2\u0113\u0115\5b\62\2\u0114\u0113\3\2\2\2\u0115\u0116\3\2"+
		"\2\2\u0116\u0114\3\2\2\2\u0116\u0117\3\2\2\2\u0117\u0118\3\2\2\2\u0118"+
		"\u0119\5\22\n\2\u0119\u011a\7\30\2\2\u011a#\3\2\2\2\u011b\u011c\5R*\2"+
		"\u011c\u011d\5&\24\2\u011d\u011e\7\13\2\2\u011e\u011f\5&\24\2\u011f%\3"+
		"\2\2\2\u0120\u0123\5`\61\2\u0121\u0122\7\31\2\2\u0122\u0124\5(\25\2\u0123"+
		"\u0121\3\2\2\2\u0123\u0124\3\2\2\2\u0124\'\3\2\2\2\u0125\u0128\5*\26\2"+
		"\u0126\u0128\5,\27\2\u0127\u0125\3\2\2\2\u0127\u0126\3\2\2\2\u0128)\3"+
		"\2\2\2\u0129\u012a\5<\37\2\u012a\u012b\7/\2\2\u012b\u012c\5(\25\2\u012c"+
		"+\3\2\2\2\u012d\u012e\5.\30\2\u012e-\3\2\2\2\u012f\u0130\b\30\1\2\u0130"+
		"\u0131\5\60\31\2\u0131\u0137\3\2\2\2\u0132\u0133\f\4\2\2\u0133\u0134\7"+
		"\63\2\2\u0134\u0136\5\60\31\2\u0135\u0132\3\2\2\2\u0136\u0139\3\2\2\2"+
		"\u0137\u0135\3\2\2\2\u0137\u0138\3\2\2\2\u0138/\3\2\2\2\u0139\u0137\3"+
		"\2\2\2\u013a\u013b\b\31\1\2\u013b\u013c\5\62\32\2\u013c\u0142\3\2\2\2"+
		"\u013d\u013e\f\4\2\2\u013e\u013f\7\62\2\2\u013f\u0141\5\62\32\2\u0140"+
		"\u013d\3\2\2\2\u0141\u0144\3\2\2\2\u0142\u0140\3\2\2\2\u0142\u0143\3\2"+
		"\2\2\u0143\61\3\2\2\2\u0144\u0142\3\2\2\2\u0145\u0146\b\32\1\2\u0146\u0147"+
		"\5\64\33\2\u0147\u014d\3\2\2\2\u0148\u0149\f\4\2\2\u0149\u014a\7\66\2"+
		"\2\u014a\u014c\5\64\33\2\u014b\u0148\3\2\2\2\u014c\u014f\3\2\2\2\u014d"+
		"\u014b\3\2\2\2\u014d\u014e\3\2\2\2\u014e\63\3\2\2\2\u014f\u014d\3\2\2"+
		"\2\u0150\u0151\5\66\34\2\u0151\u0152\7\65\2\2\u0152\u0153\5\66\34\2\u0153"+
		"\u0156\3\2\2\2\u0154\u0156\5\66\34\2\u0155\u0150\3\2\2\2\u0155\u0154\3"+
		"\2\2\2\u0156\65\3\2\2\2\u0157\u0158\58\35\2\u0158\67\3\2\2\2\u0159\u015a"+
		"\b\35\1\2\u015a\u015b\5:\36\2\u015b\u0161\3\2\2\2\u015c\u015d\f\3\2\2"+
		"\u015d\u015e\7\60\2\2\u015e\u0160\5:\36\2\u015f\u015c\3\2\2\2\u0160\u0163"+
		"\3\2\2\2\u0161\u015f\3\2\2\2\u0161\u0162\3\2\2\2\u01629\3\2\2\2\u0163"+
		"\u0161\3\2\2\2\u0164\u0165\b\36\1\2\u0165\u0166\5<\37\2\u0166\u016c\3"+
		"\2\2\2\u0167\u0168\f\3\2\2\u0168\u0169\7\61\2\2\u0169\u016b\5<\37\2\u016a"+
		"\u0167\3\2\2\2\u016b\u016e\3\2\2\2\u016c\u016a\3\2\2\2\u016c\u016d\3\2"+
		"\2\2\u016d;\3\2\2\2\u016e\u016c\3\2\2\2\u016f\u0176\5T+\2\u0170\u0176"+
		"\5N(\2\u0171\u0172\7\64\2\2\u0172\u0176\5<\37\2\u0173\u0176\5L\'\2\u0174"+
		"\u0176\5> \2\u0175\u016f\3\2\2\2\u0175\u0170\3\2\2\2\u0175\u0171\3\2\2"+
		"\2\u0175\u0173\3\2\2\2\u0175\u0174\3\2\2\2\u0176=\3\2\2\2\u0177\u0178"+
		"\b \1\2\u0178\u0179\5F$\2\u0179\u0182\3\2\2\2\u017a\u017b\f\5\2\2\u017b"+
		"\u0181\5@!\2\u017c\u017d\f\4\2\2\u017d\u0181\5B\"\2\u017e\u017f\f\3\2"+
		"\2\u017f\u0181\5D#\2\u0180\u017a\3\2\2\2\u0180\u017c\3\2\2\2\u0180\u017e"+
		"\3\2\2\2\u0181\u0184\3\2\2\2\u0182\u0180\3\2\2\2\u0182\u0183\3\2\2\2\u0183"+
		"?\3\2\2\2\u0184\u0182\3\2\2\2\u0185\u0186\7\32\2\2\u0186\u0187\5`\61\2"+
		"\u0187A\3\2\2\2\u0188\u0189\7\33\2\2\u0189\u018a\5(\25\2\u018a\u018b\7"+
		"\34\2\2\u018bC\3\2\2\2\u018c\u018d\7\32\2\2\u018d\u018e\5J&\2\u018eE\3"+
		"\2\2\2\u018f\u0193\5H%\2\u0190\u0193\5`\61\2\u0191\u0193\5J&\2\u0192\u018f"+
		"\3\2\2\2\u0192\u0190\3\2\2\2\u0192\u0191\3\2\2\2\u0193G\3\2\2\2\u0194"+
		"\u0195\7>\2\2\u0195\u0196\5,\27\2\u0196\u0197\7?\2\2\u0197I\3\2\2\2\u0198"+
		"\u0199\5`\61\2\u0199\u019b\7>\2\2\u019a\u019c\5\f\7\2\u019b\u019a\3\2"+
		"\2\2\u019b\u019c\3\2\2\2\u019c\u019d\3\2\2\2\u019d\u019e\7?\2\2\u019e"+
		"K\3\2\2\2\u019f\u01a0\7>\2\2\u01a0\u01a1\5R*\2\u01a1\u01a2\7?\2\2\u01a2"+
		"\u01a3\5<\37\2\u01a3M\3\2\2\2\u01a4\u01a5\7\35\2\2\u01a5\u01a6\5R*\2\u01a6"+
		"\u01a8\7>\2\2\u01a7\u01a9\5\f\7\2\u01a8\u01a7\3\2\2\2\u01a8\u01a9\3\2"+
		"\2\2\u01a9\u01aa\3\2\2\2\u01aa\u01ab\7?\2\2\u01abO\3\2\2\2\u01ac\u01b6"+
		"\7\36\2\2\u01ad\u01b6\7\37\2\2\u01ae\u01b6\7 \2\2\u01af\u01b6\7!\2\2\u01b0"+
		"\u01b1\t\2\2\2\u01b1\u01b2\7>\2\2\u01b2\u01b3\5Z.\2\u01b3\u01b4\7?\2\2"+
		"\u01b4\u01b6\3\2\2\2\u01b5\u01ac\3\2\2\2\u01b5\u01ad\3\2\2\2\u01b5\u01ae"+
		"\3\2\2\2\u01b5\u01af\3\2\2\2\u01b5\u01b0\3\2\2\2\u01b6Q\3\2\2\2\u01b7"+
		"\u01c5\7$\2\2\u01b8\u01c5\7%\2\2\u01b9\u01c5\7&\2\2\u01ba\u01c5\7\'\2"+
		"\2\u01bb\u01bc\7(\2\2\u01bc\u01bd\7)\2\2\u01bd\u01be\5R*\2\u01be\u01bf"+
		"\7*\2\2\u01bf\u01c5\3\2\2\2\u01c0\u01c5\7+\2\2\u01c1\u01c5\7,\2\2\u01c2"+
		"\u01c5\7-\2\2\u01c3\u01c5\7.\2\2\u01c4\u01b7\3\2\2\2\u01c4\u01b8\3\2\2"+
		"\2\u01c4\u01b9\3\2\2\2\u01c4\u01ba\3\2\2\2\u01c4\u01bb\3\2\2\2\u01c4\u01c0"+
		"\3\2\2\2\u01c4\u01c1\3\2\2\2\u01c4\u01c2\3\2\2\2\u01c4\u01c3\3\2\2\2\u01c5"+
		"S\3\2\2\2\u01c6\u01cc\5\\/\2\u01c7\u01cc\5V,\2\u01c8\u01cc\5Z.\2\u01c9"+
		"\u01cc\5X-\2\u01ca\u01cc\5^\60\2\u01cb\u01c6\3\2\2\2\u01cb\u01c7\3\2\2"+
		"\2\u01cb\u01c8\3\2\2\2\u01cb\u01c9\3\2\2\2\u01cb\u01ca\3\2\2\2\u01ccU"+
		"\3\2\2\2\u01cd\u01ce\79\2\2\u01ceW\3\2\2\2\u01cf\u01d0\7>\2\2\u01d0\u01d1"+
		"\5,\27\2\u01d1\u01d2\7\13\2\2\u01d2\u01d3\5,\27\2\u01d3\u01d4\7\13\2\2"+
		"\u01d4\u01d5\5,\27\2\u01d5\u01d6\7?\2\2\u01d6Y\3\2\2\2\u01d7\u01d8\78"+
		"\2\2\u01d8[\3\2\2\2\u01d9\u01da\7;\2\2\u01da]\3\2\2\2\u01db\u01dc\7<\2"+
		"\2\u01dc_\3\2\2\2\u01dd\u01de\7=\2\2\u01dea\3\2\2\2\u01df\u01e0\7\67\2"+
		"\2\u01e0c\3\2\2\2,enuy\u0081\u0086\u008b\u008f\u009d\u00a2\u00a7\u00b1"+
		"\u00b9\u00c3\u00c7\u00d2\u00d6\u00de\u00e5\u00f0\u00f9\u00ff\u0106\u010a"+
		"\u0116\u0123\u0127\u0137\u0142\u014d\u0155\u0161\u016c\u0175\u0180\u0182"+
		"\u0192\u019b\u01a8\u01b5\u01c4\u01cb";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}