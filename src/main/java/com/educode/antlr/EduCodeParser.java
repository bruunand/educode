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
		T__38=39, T__39=40, T__40=41, T__41=42, T__42=43, T__43=44, T__44=45, 
<<<<<<< Updated upstream
		T__45=46, T__46=47, T__47=48, T__48=49, T__49=50, T__50=51, T__51=52, 
		T__52=53, T__53=54, T__54=55, T__55=56, T__56=57, T__57=58, T__58=59, 
		T__59=60, NEWLINE=61, NUMBER_LITERAL=62, STRING_LITERAL=63, UNTERMINATED_STRING_LITERAL=64, 
		BOOL_LITERAL=65, NULL_LITERAL=66, IDENTIFIER=67, LPAREN=68, RPAREN=69, 
		WHITESPACE=70, LINECOMMENT=71;
=======
		T__45=46, T__46=47, T__47=48, ADDITIVE_OPERATOR=49, MULTIPLICATIVE_OPERATOR=50, 
		AND_OPERATOR=51, OR_OPERATOR=52, UNARY_OPERATOR=53, RELATIVE_OPERATOR=54, 
		EQUALITY_OPERATOR=55, NEWLINE=56, NUMBER_LITERAL=57, STRING_LITERAL=58, 
		UNTERMINATED_STRING_LITERAL=59, BOOL_LITERAL=60, NULL_LITERAL=61, IDENTIFIER=62, 
		LPAREN=63, RPAREN=64, WHITESPACE=65, LINECOMMENT=66;
>>>>>>> Stashed changes
	public static final int
		RULE_start = 0, RULE_usings = 1, RULE_program = 2, RULE_event_definition = 3, 
		RULE_method_declaration = 4, RULE_argument_list = 5, RULE_parameter_list = 6, 
		RULE_parameter = 7, RULE_statement_list = 8, RULE_statement = 9, RULE_call_statement = 10, 
		RULE_iterative_statement = 11, RULE_break_statement = 12, RULE_continue_statement = 13, 
		RULE_return_statement = 14, RULE_repeat_statement = 15, RULE_if_statement = 16, 
		RULE_foreach_statement = 17, RULE_variable_declaration = 18, RULE_declarator = 19, 
		RULE_expression = 20, RULE_assignment_expression = 21, RULE_logic_expression = 22, 
		RULE_or_expression = 23, RULE_and_expression = 24, RULE_equality_expression = 25, 
		RULE_relative_expression = 26, RULE_arithmetic_expression = 27, RULE_additive_expression = 28, 
		RULE_multiplicative_expression = 29, RULE_factor = 30, RULE_access = 31, 
		RULE_field_access = 32, RULE_element_access = 33, RULE_method_access = 34, 
		RULE_subfactor = 35, RULE_parenthesis_expression = 36, RULE_method_call = 37, 
		RULE_type_cast = 38, RULE_object_instantiation = 39, RULE_event_type = 40, 
		RULE_data_type = 41, RULE_literal = 42, RULE_string_literal = 43, RULE_coordinate_literal = 44, 
		RULE_number_literal = 45, RULE_bool_literal = 46, RULE_null_literal = 47, 
<<<<<<< Updated upstream
		RULE_identifier = 48, RULE_end_of_line = 49;
=======
		RULE_identifier = 48, RULE_end_of_line = 49, RULE_assignment_operator = 50;
>>>>>>> Stashed changes
	public static final String[] ruleNames = {
		"start", "usings", "program", "event_definition", "method_declaration", 
		"argument_list", "parameter_list", "parameter", "statement_list", "statement", 
		"call_statement", "iterative_statement", "break_statement", "continue_statement", 
		"return_statement", "repeat_statement", "if_statement", "foreach_statement", 
		"variable_declaration", "declarator", "expression", "assignment_expression", 
		"logic_expression", "or_expression", "and_expression", "equality_expression", 
		"relative_expression", "arithmetic_expression", "additive_expression", 
		"multiplicative_expression", "factor", "access", "field_access", "element_access", 
		"method_access", "subfactor", "parenthesis_expression", "method_call", 
		"type_cast", "object_instantiation", "event_type", "data_type", "literal", 
		"string_literal", "coordinate_literal", "number_literal", "bool_literal", 
<<<<<<< Updated upstream
		"null_literal", "identifier", "end_of_line"
=======
		"null_literal", "identifier", "end_of_line", "assignment_operator"
>>>>>>> Stashed changes
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'using'", "'program'", "'end program'", "'on event'", "'call'", 
		"'method'", "'returns'", "'end method'", "','", "'break'", "'continue'", 
		"'return'", "'repeat while'", "'end repeat'", "'if'", "'then'", "'else if'", 
<<<<<<< Updated upstream
		"'else'", "'end if'", "'foreach'", "'in'", "'end foreach'", "'='", "'+='", 
		"'-='", "'*='", "'/='", "'or'", "'and'", "'equals'", "'not equals'", "'greater than'", 
		"'less than'", "'greater than or equals'", "'less than or equals'", "'+'", 
		"'-'", "'/'", "'*'", "'modulo'", "'not'", "'.'", "'['", "']'", "'new'", 
		"'robotDeath'", "'robotAttacked'", "'entityDeath'", "'chatMessage'", "'stringMessageReceived'", 
		"'entityMessageReceived'", "'number'", "'bool'", "'coordinates'", "'string'", 
		"'Collection'", "'<'", "'>'", "'Entity'", "'Item'", null, null, null, 
=======
		"'else'", "'end if'", "'foreach'", "'in'", "'end foreach'", "'='", "'.'", 
		"'['", "']'", "'new'", "'robotDeath'", "'robotAttacked'", "'entityDeath'", 
		"'chatMessage'", "'stringMessageReceived'", "'entityMessageReceived'", 
		"'number'", "'bool'", "'coordinates'", "'string'", "'Collection'", "'<'", 
		"'>'", "'Block'", "'Entity'", "'Item'", "'Texture'", "'+='", "'-='", "'*='", 
		"'/='", null, null, "'and'", "'or'", null, null, null, null, null, null, 
>>>>>>> Stashed changes
		null, null, "'null'", null, "'('", "')'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
<<<<<<< Updated upstream
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, "NEWLINE", "NUMBER_LITERAL", "STRING_LITERAL", "UNTERMINATED_STRING_LITERAL", 
=======
		null, "ADDITIVE_OPERATOR", "MULTIPLICATIVE_OPERATOR", "AND_OPERATOR", 
		"OR_OPERATOR", "UNARY_OPERATOR", "RELATIVE_OPERATOR", "EQUALITY_OPERATOR", 
		"NEWLINE", "NUMBER_LITERAL", "STRING_LITERAL", "UNTERMINATED_STRING_LITERAL", 
>>>>>>> Stashed changes
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
<<<<<<< Updated upstream
			setState(101);
=======
			setState(103);
>>>>>>> Stashed changes
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__0) {
				{
<<<<<<< Updated upstream
				setState(100);
=======
				setState(102);
>>>>>>> Stashed changes
				((StartContext)_localctx).ulist = usings();
				}
			}

<<<<<<< Updated upstream
			setState(103);
=======
			setState(105);
>>>>>>> Stashed changes
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
<<<<<<< Updated upstream
			setState(105);
			match(T__0);
			setState(106);
			((UsingsContext)_localctx).identifier = identifier();
			((UsingsContext)_localctx).id.add(((UsingsContext)_localctx).identifier);
			setState(108); 
=======
			setState(107);
			match(T__0);
			setState(108);
			((UsingsContext)_localctx).identifier = identifier();
			((UsingsContext)_localctx).id.add(((UsingsContext)_localctx).identifier);
			setState(110); 
>>>>>>> Stashed changes
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
<<<<<<< Updated upstream
				setState(107);
				end_of_line();
				}
				}
				setState(110); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==NEWLINE );
			setState(121);
=======
				setState(109);
				end_of_line();
				}
				}
				setState(112); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==NEWLINE );
			setState(123);
>>>>>>> Stashed changes
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__0) {
				{
				{
<<<<<<< Updated upstream
				setState(112);
				match(T__0);
				setState(113);
				((UsingsContext)_localctx).identifier = identifier();
				((UsingsContext)_localctx).id.add(((UsingsContext)_localctx).identifier);
				setState(115); 
=======
				setState(114);
				match(T__0);
				setState(115);
				((UsingsContext)_localctx).identifier = identifier();
				((UsingsContext)_localctx).id.add(((UsingsContext)_localctx).identifier);
				setState(117); 
>>>>>>> Stashed changes
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
<<<<<<< Updated upstream
					setState(114);
					end_of_line();
					}
					}
					setState(117); 
=======
					setState(116);
					end_of_line();
					}
					}
					setState(119); 
>>>>>>> Stashed changes
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==NEWLINE );
				}
				}
<<<<<<< Updated upstream
				setState(123);
=======
				setState(125);
>>>>>>> Stashed changes
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
<<<<<<< Updated upstream
			setState(124);
			match(T__1);
			setState(125);
			((ProgramContext)_localctx).id = identifier();
			setState(127); 
=======
			setState(126);
			match(T__1);
			setState(127);
			((ProgramContext)_localctx).id = identifier();
			setState(129); 
>>>>>>> Stashed changes
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
<<<<<<< Updated upstream
				setState(126);
				end_of_line();
				}
				}
				setState(129); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==NEWLINE );
			setState(143);
=======
				setState(128);
				end_of_line();
				}
				}
				setState(131); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==NEWLINE );
			setState(145);
>>>>>>> Stashed changes
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__3) | (1L << T__5) | (1L << T__51) | (1L << T__52) | (1L << T__53) | (1L << T__54) | (1L << T__55) | (1L << T__58) | (1L << T__59))) != 0)) {
				{
				{
<<<<<<< Updated upstream
				setState(134);
=======
				setState(136);
>>>>>>> Stashed changes
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__3:
					{
<<<<<<< Updated upstream
					setState(131);
=======
					setState(133);
>>>>>>> Stashed changes
					((ProgramContext)_localctx).event_definition = event_definition();
					((ProgramContext)_localctx).el.add(((ProgramContext)_localctx).event_definition);
					}
					break;
				case T__5:
					{
<<<<<<< Updated upstream
					setState(132);
=======
					setState(134);
>>>>>>> Stashed changes
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
<<<<<<< Updated upstream
					setState(133);
=======
					setState(135);
>>>>>>> Stashed changes
					((ProgramContext)_localctx).variable_declaration = variable_declaration();
					((ProgramContext)_localctx).vl.add(((ProgramContext)_localctx).variable_declaration);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
<<<<<<< Updated upstream
				setState(137); 
=======
				setState(139); 
>>>>>>> Stashed changes
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
<<<<<<< Updated upstream
					setState(136);
					end_of_line();
					}
					}
					setState(139); 
=======
					setState(138);
					end_of_line();
					}
					}
					setState(141); 
>>>>>>> Stashed changes
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==NEWLINE );
				}
				}
<<<<<<< Updated upstream
				setState(145);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(146);
=======
				setState(147);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(148);
>>>>>>> Stashed changes
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
<<<<<<< Updated upstream
			setState(148);
			match(T__3);
			setState(149);
			((Event_definitionContext)_localctx).event = event_type();
			setState(150);
			match(T__4);
			setState(151);
=======
			setState(150);
			match(T__3);
			setState(151);
			((Event_definitionContext)_localctx).event = event_type();
			setState(152);
			match(T__4);
			setState(153);
>>>>>>> Stashed changes
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
<<<<<<< Updated upstream
			setState(153);
			match(T__5);
			setState(154);
			((Method_declarationContext)_localctx).id = identifier();
			setState(155);
			match(LPAREN);
			setState(157);
=======
			setState(155);
			match(T__5);
			setState(156);
			((Method_declarationContext)_localctx).id = identifier();
			setState(157);
			match(LPAREN);
			setState(159);
>>>>>>> Stashed changes
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__51) | (1L << T__52) | (1L << T__53) | (1L << T__54) | (1L << T__55) | (1L << T__58) | (1L << T__59))) != 0)) {
				{
<<<<<<< Updated upstream
				setState(156);
=======
				setState(158);
>>>>>>> Stashed changes
				((Method_declarationContext)_localctx).params = parameter_list();
				}
			}

<<<<<<< Updated upstream
			setState(159);
			match(RPAREN);
			setState(162);
=======
			setState(161);
			match(RPAREN);
			setState(164);
>>>>>>> Stashed changes
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__6) {
				{
<<<<<<< Updated upstream
				setState(160);
				match(T__6);
				setState(161);
=======
				setState(162);
				match(T__6);
				setState(163);
>>>>>>> Stashed changes
				((Method_declarationContext)_localctx).type = data_type();
				}
			}

<<<<<<< Updated upstream
			setState(165); 
=======
			setState(167); 
>>>>>>> Stashed changes
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
<<<<<<< Updated upstream
				setState(164);
				end_of_line();
				}
				}
				setState(167); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==NEWLINE );
			setState(169);
			((Method_declarationContext)_localctx).body = statement_list();
			setState(170);
=======
				setState(166);
				end_of_line();
				}
				}
				setState(169); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==NEWLINE );
			setState(171);
			((Method_declarationContext)_localctx).body = statement_list();
			setState(172);
>>>>>>> Stashed changes
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
<<<<<<< Updated upstream
			setState(172);
			((Argument_listContext)_localctx).expression = expression();
			((Argument_listContext)_localctx).exprs.add(((Argument_listContext)_localctx).expression);
			setState(177);
=======
			setState(174);
			((Argument_listContext)_localctx).expression = expression();
			((Argument_listContext)_localctx).exprs.add(((Argument_listContext)_localctx).expression);
			setState(179);
>>>>>>> Stashed changes
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__8) {
				{
				{
<<<<<<< Updated upstream
				setState(173);
				match(T__8);
				setState(174);
=======
				setState(175);
				match(T__8);
				setState(176);
>>>>>>> Stashed changes
				((Argument_listContext)_localctx).expression = expression();
				((Argument_listContext)_localctx).exprs.add(((Argument_listContext)_localctx).expression);
				}
				}
<<<<<<< Updated upstream
				setState(179);
=======
				setState(181);
>>>>>>> Stashed changes
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
<<<<<<< Updated upstream
			setState(180);
			((Parameter_listContext)_localctx).parameter = parameter();
			((Parameter_listContext)_localctx).params.add(((Parameter_listContext)_localctx).parameter);
			setState(185);
=======
			setState(182);
			((Parameter_listContext)_localctx).parameter = parameter();
			((Parameter_listContext)_localctx).params.add(((Parameter_listContext)_localctx).parameter);
			setState(187);
>>>>>>> Stashed changes
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__8) {
				{
				{
<<<<<<< Updated upstream
				setState(181);
				match(T__8);
				setState(182);
=======
				setState(183);
				match(T__8);
				setState(184);
>>>>>>> Stashed changes
				((Parameter_listContext)_localctx).parameter = parameter();
				((Parameter_listContext)_localctx).params.add(((Parameter_listContext)_localctx).parameter);
				}
				}
<<<<<<< Updated upstream
				setState(187);
=======
				setState(189);
>>>>>>> Stashed changes
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
<<<<<<< Updated upstream
			setState(188);
			((ParameterContext)_localctx).type = data_type();
			setState(189);
=======
			setState(190);
			((ParameterContext)_localctx).type = data_type();
			setState(191);
>>>>>>> Stashed changes
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
<<<<<<< Updated upstream
			setState(199);
=======
			setState(201);
>>>>>>> Stashed changes
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (((((_la - 10)) & ~0x3f) == 0 && ((1L << (_la - 10)) & ((1L << (T__9 - 10)) | (1L << (T__10 - 10)) | (1L << (T__11 - 10)) | (1L << (T__12 - 10)) | (1L << (T__14 - 10)) | (1L << (T__19 - 10)) | (1L << (T__36 - 10)) | (1L << (T__40 - 10)) | (1L << (T__44 - 10)) | (1L << (T__51 - 10)) | (1L << (T__52 - 10)) | (1L << (T__53 - 10)) | (1L << (T__54 - 10)) | (1L << (T__55 - 10)) | (1L << (T__58 - 10)) | (1L << (T__59 - 10)) | (1L << (NUMBER_LITERAL - 10)) | (1L << (STRING_LITERAL - 10)) | (1L << (BOOL_LITERAL - 10)) | (1L << (NULL_LITERAL - 10)) | (1L << (IDENTIFIER - 10)) | (1L << (LPAREN - 10)))) != 0)) {
				{
				{
<<<<<<< Updated upstream
				setState(191);
				((Statement_listContext)_localctx).statement = statement();
				((Statement_listContext)_localctx).statements.add(((Statement_listContext)_localctx).statement);
				setState(193); 
=======
				setState(193);
				((Statement_listContext)_localctx).statement = statement();
				((Statement_listContext)_localctx).statements.add(((Statement_listContext)_localctx).statement);
				setState(195); 
>>>>>>> Stashed changes
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
<<<<<<< Updated upstream
					setState(192);
					end_of_line();
					}
					}
					setState(195); 
=======
					setState(194);
					end_of_line();
					}
					}
					setState(197); 
>>>>>>> Stashed changes
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==NEWLINE );
				}
				}
<<<<<<< Updated upstream
				setState(201);
=======
				setState(203);
>>>>>>> Stashed changes
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
<<<<<<< Updated upstream
			setState(210);
=======
			setState(212);
>>>>>>> Stashed changes
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
<<<<<<< Updated upstream
				setState(202);
=======
				setState(204);
>>>>>>> Stashed changes
				call_statement();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
<<<<<<< Updated upstream
				setState(203);
=======
				setState(205);
>>>>>>> Stashed changes
				assignment_expression();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
<<<<<<< Updated upstream
				setState(204);
=======
				setState(206);
>>>>>>> Stashed changes
				variable_declaration();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
<<<<<<< Updated upstream
				setState(205);
=======
				setState(207);
>>>>>>> Stashed changes
				if_statement();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
<<<<<<< Updated upstream
				setState(206);
=======
				setState(208);
>>>>>>> Stashed changes
				iterative_statement();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
<<<<<<< Updated upstream
				setState(207);
=======
				setState(209);
>>>>>>> Stashed changes
				return_statement();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
<<<<<<< Updated upstream
				setState(208);
=======
				setState(210);
>>>>>>> Stashed changes
				break_statement();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
<<<<<<< Updated upstream
				setState(209);
=======
				setState(211);
>>>>>>> Stashed changes
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
<<<<<<< Updated upstream
			setState(216);
=======
			setState(218);
>>>>>>> Stashed changes
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
<<<<<<< Updated upstream
				setState(212);
=======
				setState(214);
>>>>>>> Stashed changes
				method_call();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
<<<<<<< Updated upstream
				setState(213);
				access(0);
				setState(214);
=======
				setState(215);
				access(0);
				setState(216);
>>>>>>> Stashed changes
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
<<<<<<< Updated upstream
			setState(220);
=======
			setState(222);
>>>>>>> Stashed changes
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__12:
				enterOuterAlt(_localctx, 1);
				{
<<<<<<< Updated upstream
				setState(218);
=======
				setState(220);
>>>>>>> Stashed changes
				repeat_statement();
				}
				break;
			case T__19:
				enterOuterAlt(_localctx, 2);
				{
<<<<<<< Updated upstream
				setState(219);
=======
				setState(221);
>>>>>>> Stashed changes
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
<<<<<<< Updated upstream
			setState(222);
=======
			setState(224);
>>>>>>> Stashed changes
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
<<<<<<< Updated upstream
			setState(224);
=======
			setState(226);
>>>>>>> Stashed changes
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
		enterRule(_localctx, 28, RULE_return_statement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
<<<<<<< Updated upstream
			setState(226);
			match(T__11);
			setState(228);
=======
			setState(228);
			match(T__11);
			setState(230);
>>>>>>> Stashed changes
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((((_la - 37)) & ~0x3f) == 0 && ((1L << (_la - 37)) & ((1L << (T__36 - 37)) | (1L << (T__40 - 37)) | (1L << (T__44 - 37)) | (1L << (NUMBER_LITERAL - 37)) | (1L << (STRING_LITERAL - 37)) | (1L << (BOOL_LITERAL - 37)) | (1L << (NULL_LITERAL - 37)) | (1L << (IDENTIFIER - 37)) | (1L << (LPAREN - 37)))) != 0)) {
				{
<<<<<<< Updated upstream
				setState(227);
=======
				setState(229);
>>>>>>> Stashed changes
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
<<<<<<< Updated upstream
			setState(230);
			match(T__12);
			setState(231);
			((Repeat_statementContext)_localctx).predicate = logic_expression();
			setState(233); 
=======
			setState(232);
			match(T__12);
			setState(233);
			((Repeat_statementContext)_localctx).predicate = logic_expression();
			setState(235); 
>>>>>>> Stashed changes
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
<<<<<<< Updated upstream
				setState(232);
				end_of_line();
				}
				}
				setState(235); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==NEWLINE );
			setState(237);
			((Repeat_statementContext)_localctx).body = statement_list();
			setState(238);
=======
				setState(234);
				end_of_line();
				}
				}
				setState(237); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==NEWLINE );
			setState(239);
			((Repeat_statementContext)_localctx).bode = statement_list();
			setState(240);
>>>>>>> Stashed changes
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
<<<<<<< Updated upstream
			setState(240);
			match(T__14);
			setState(241);
			((If_statementContext)_localctx).logic_expression = logic_expression();
			((If_statementContext)_localctx).predicates.add(((If_statementContext)_localctx).logic_expression);
			setState(242);
			match(T__15);
			setState(244); 
=======
			setState(242);
			match(T__14);
			setState(243);
			((If_statementContext)_localctx).logic_expression = logic_expression();
			((If_statementContext)_localctx).predicate.add(((If_statementContext)_localctx).logic_expression);
			setState(244);
			match(T__15);
			setState(246); 
>>>>>>> Stashed changes
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
<<<<<<< Updated upstream
				setState(243);
				end_of_line();
				}
				}
				setState(246); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==NEWLINE );
			setState(248);
			((If_statementContext)_localctx).statement_list = statement_list();
			((If_statementContext)_localctx).bodies.add(((If_statementContext)_localctx).statement_list);
			setState(261);
=======
				setState(245);
				end_of_line();
				}
				}
				setState(248); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==NEWLINE );
			setState(250);
			((If_statementContext)_localctx).statement_list = statement_list();
			((If_statementContext)_localctx).body.add(((If_statementContext)_localctx).statement_list);
			setState(263);
>>>>>>> Stashed changes
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__16) {
				{
				{
<<<<<<< Updated upstream
				setState(249);
				match(T__16);
				setState(250);
				((If_statementContext)_localctx).logic_expression = logic_expression();
				((If_statementContext)_localctx).predicates.add(((If_statementContext)_localctx).logic_expression);
				setState(251);
				match(T__15);
				setState(253); 
=======
				setState(251);
				match(T__16);
				setState(252);
				((If_statementContext)_localctx).logic_expression = logic_expression();
				((If_statementContext)_localctx).predicate.add(((If_statementContext)_localctx).logic_expression);
				setState(253);
				match(T__15);
				setState(255); 
>>>>>>> Stashed changes
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
<<<<<<< Updated upstream
					setState(252);
					end_of_line();
					}
					}
					setState(255); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==NEWLINE );
				setState(257);
=======
					setState(254);
					end_of_line();
					}
					}
					setState(257); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==NEWLINE );
				setState(259);
>>>>>>> Stashed changes
				((If_statementContext)_localctx).statement_list = statement_list();
				((If_statementContext)_localctx).bodies.add(((If_statementContext)_localctx).statement_list);
				}
				}
<<<<<<< Updated upstream
				setState(263);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(272);
=======
				setState(265);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(274);
>>>>>>> Stashed changes
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__17) {
				{
<<<<<<< Updated upstream
				setState(264);
				match(T__17);
				setState(266); 
=======
				setState(266);
				match(T__17);
				setState(268); 
>>>>>>> Stashed changes
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
<<<<<<< Updated upstream
					setState(265);
					end_of_line();
					}
					}
					setState(268); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==NEWLINE );
				setState(270);
=======
					setState(267);
					end_of_line();
					}
					}
					setState(270); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==NEWLINE );
				setState(272);
>>>>>>> Stashed changes
				((If_statementContext)_localctx).elseBody = statement_list();
				}
			}

<<<<<<< Updated upstream
			setState(274);
=======
			setState(276);
>>>>>>> Stashed changes
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
		enterRule(_localctx, 34, RULE_foreach_statement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
<<<<<<< Updated upstream
			setState(276);
			match(T__19);
			setState(277);
			((Foreach_statementContext)_localctx).type = data_type();
			setState(278);
			((Foreach_statementContext)_localctx).id = identifier();
			setState(279);
			match(T__20);
			setState(280);
			((Foreach_statementContext)_localctx).expr = expression();
			setState(282); 
=======
			setState(278);
			match(T__19);
			setState(279);
			((Foreach_statementContext)_localctx).type = data_type();
			setState(280);
			((Foreach_statementContext)_localctx).id = identifier();
			setState(281);
			match(T__20);
			setState(282);
			((Foreach_statementContext)_localctx).expr = expression();
			setState(284); 
>>>>>>> Stashed changes
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
<<<<<<< Updated upstream
				setState(281);
				end_of_line();
				}
				}
				setState(284); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==NEWLINE );
			setState(286);
			((Foreach_statementContext)_localctx).body = statement_list();
			setState(287);
=======
				setState(283);
				end_of_line();
				}
				}
				setState(286); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==NEWLINE );
			setState(288);
			((Foreach_statementContext)_localctx).body = statement_list();
			setState(289);
>>>>>>> Stashed changes
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
		enterRule(_localctx, 36, RULE_variable_declaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
<<<<<<< Updated upstream
			setState(289);
			((Variable_declarationContext)_localctx).type = data_type();
			setState(290);
			((Variable_declarationContext)_localctx).declarator = declarator();
			((Variable_declarationContext)_localctx).decl.add(((Variable_declarationContext)_localctx).declarator);
			setState(295);
=======
			setState(291);
			((Variable_declarationContext)_localctx).type = data_type();
			setState(292);
			((Variable_declarationContext)_localctx).declarator = declarator();
			((Variable_declarationContext)_localctx).decl.add(((Variable_declarationContext)_localctx).declarator);
			setState(297);
>>>>>>> Stashed changes
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__8) {
				{
				{
<<<<<<< Updated upstream
				setState(291);
				match(T__8);
				setState(292);
=======
				setState(293);
				match(T__8);
				setState(294);
>>>>>>> Stashed changes
				((Variable_declarationContext)_localctx).declarator = declarator();
				((Variable_declarationContext)_localctx).decl.add(((Variable_declarationContext)_localctx).declarator);
				}
				}
<<<<<<< Updated upstream
				setState(297);
=======
				setState(299);
>>>>>>> Stashed changes
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
<<<<<<< Updated upstream
			setState(298);
			((DeclaratorContext)_localctx).id = identifier();
			setState(301);
=======
			setState(300);
			((DeclaratorContext)_localctx).id = identifier();
			setState(303);
>>>>>>> Stashed changes
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__22) {
				{
<<<<<<< Updated upstream
				setState(299);
				match(T__22);
				setState(300);
=======
				setState(301);
				match(T__22);
				setState(302);
>>>>>>> Stashed changes
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
<<<<<<< Updated upstream
			setState(305);
=======
			setState(307);
>>>>>>> Stashed changes
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,28,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
<<<<<<< Updated upstream
				setState(303);
=======
				setState(305);
>>>>>>> Stashed changes
				assignment_expression();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
<<<<<<< Updated upstream
				setState(304);
=======
				setState(306);
>>>>>>> Stashed changes
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
		public Assignment_operatorContext op;
		public ExpressionContext rhs;
		public FactorContext factor() {
			return getRuleContext(FactorContext.class,0);
		}
<<<<<<< Updated upstream
=======
		public Assignment_operatorContext assignment_operator() {
			return getRuleContext(Assignment_operatorContext.class,0);
		}
>>>>>>> Stashed changes
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
<<<<<<< Updated upstream
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(307);
			((Assignment_expressionContext)_localctx).lhs = factor();
			setState(308);
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
			setState(309);
=======
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(309);
			((Assignment_expressionContext)_localctx).lhs = factor();
			setState(310);
			((Assignment_expressionContext)_localctx).op = assignment_operator();
			setState(311);
>>>>>>> Stashed changes
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
		public Or_expressionContext or;
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
		enterRule(_localctx, 44, RULE_logic_expression);
		try {
			enterOuterAlt(_localctx, 1);
			{
<<<<<<< Updated upstream
			setState(311);
			((Logic_expressionContext)_localctx).or = or_expression(0);
=======
			setState(313);
			or_expression(0);
>>>>>>> Stashed changes
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
		public Or_expressionContext or;
		public And_expressionContext and;
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
		int _startState = 46;
		enterRecursionRule(_localctx, 46, RULE_or_expression, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
<<<<<<< Updated upstream
			setState(314);
			((Or_expressionContext)_localctx).and = and_expression(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(321);
=======
			setState(316);
			and_expression(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(323);
>>>>>>> Stashed changes
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,29,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new Or_expressionContext(_parentctx, _parentState);
					_localctx.or = _prevctx;
					_localctx.or = _prevctx;
					pushNewRecursionContext(_localctx, _startState, RULE_or_expression);
<<<<<<< Updated upstream
					setState(316);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(317);
					((Or_expressionContext)_localctx).op = match(T__27);
					setState(318);
					((Or_expressionContext)_localctx).and = and_expression(0);
					}
					} 
				}
				setState(323);
=======
					setState(318);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(319);
					match(OR_OPERATOR);
					setState(320);
					and_expression(0);
					}
					} 
				}
				setState(325);
>>>>>>> Stashed changes
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

	public static class And_expressionContext extends ParserRuleContext {
		public And_expressionContext and;
		public Equality_expressionContext eq;
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
		int _startState = 48;
		enterRecursionRule(_localctx, 48, RULE_and_expression, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
<<<<<<< Updated upstream
			setState(325);
			((And_expressionContext)_localctx).eq = equality_expression(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(332);
=======
			setState(327);
			equality_expression(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(334);
>>>>>>> Stashed changes
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,30,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new And_expressionContext(_parentctx, _parentState);
					_localctx.and = _prevctx;
					_localctx.and = _prevctx;
					pushNewRecursionContext(_localctx, _startState, RULE_and_expression);
<<<<<<< Updated upstream
					setState(327);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(328);
					((And_expressionContext)_localctx).op = match(T__28);
					setState(329);
					((And_expressionContext)_localctx).eq = equality_expression(0);
					}
					} 
				}
				setState(334);
=======
					setState(329);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(330);
					match(AND_OPERATOR);
					setState(331);
					equality_expression(0);
					}
					} 
				}
				setState(336);
>>>>>>> Stashed changes
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

	public static class Equality_expressionContext extends ParserRuleContext {
		public Equality_expressionContext eq;
		public Relative_expressionContext rel;
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
		int _startState = 50;
		enterRecursionRule(_localctx, 50, RULE_equality_expression, _p);
<<<<<<< Updated upstream
		int _la;
=======
>>>>>>> Stashed changes
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
<<<<<<< Updated upstream
			setState(336);
			((Equality_expressionContext)_localctx).rel = relative_expression();
			}
			_ctx.stop = _input.LT(-1);
			setState(343);
=======
			setState(338);
			relative_expression();
			}
			_ctx.stop = _input.LT(-1);
			setState(345);
>>>>>>> Stashed changes
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,31,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new Equality_expressionContext(_parentctx, _parentState);
					_localctx.eq = _prevctx;
					_localctx.eq = _prevctx;
					pushNewRecursionContext(_localctx, _startState, RULE_equality_expression);
<<<<<<< Updated upstream
					setState(338);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(339);
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
					setState(340);
					((Equality_expressionContext)_localctx).rel = relative_expression();
					}
					} 
				}
				setState(345);
=======
					setState(340);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(341);
					match(EQUALITY_OPERATOR);
					setState(342);
					relative_expression();
					}
					} 
				}
				setState(347);
>>>>>>> Stashed changes
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

	public static class Relative_expressionContext extends ParserRuleContext {
		public Arithmetic_expressionContext arithmetic_expression;
		public List<Arithmetic_expressionContext> ae = new ArrayList<Arithmetic_expressionContext>();
		public Token op;
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
		enterRule(_localctx, 52, RULE_relative_expression);
<<<<<<< Updated upstream
		int _la;
		try {
			setState(351);
=======
		try {
			setState(353);
>>>>>>> Stashed changes
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,32,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
<<<<<<< Updated upstream
				setState(346);
				((Relative_expressionContext)_localctx).arithmetic_expression = arithmetic_expression();
				((Relative_expressionContext)_localctx).ae.add(((Relative_expressionContext)_localctx).arithmetic_expression);
				setState(347);
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
				setState(348);
				((Relative_expressionContext)_localctx).arithmetic_expression = arithmetic_expression();
				((Relative_expressionContext)_localctx).ae.add(((Relative_expressionContext)_localctx).arithmetic_expression);
=======
				setState(348);
				arithmetic_expression();
				setState(349);
				match(RELATIVE_OPERATOR);
				setState(350);
				arithmetic_expression();
>>>>>>> Stashed changes
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
<<<<<<< Updated upstream
				setState(350);
				((Relative_expressionContext)_localctx).arithmetic_expression = arithmetic_expression();
				((Relative_expressionContext)_localctx).ae.add(((Relative_expressionContext)_localctx).arithmetic_expression);
=======
				setState(352);
				arithmetic_expression();
>>>>>>> Stashed changes
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
		public Additive_expressionContext add;
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
		enterRule(_localctx, 54, RULE_arithmetic_expression);
		try {
			enterOuterAlt(_localctx, 1);
			{
<<<<<<< Updated upstream
			setState(353);
			((Arithmetic_expressionContext)_localctx).add = additive_expression(0);
=======
			setState(355);
			additive_expression(0);
>>>>>>> Stashed changes
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
		public Additive_expressionContext add;
		public Multiplicative_expressionContext mult;
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
		int _startState = 56;
		enterRecursionRule(_localctx, 56, RULE_additive_expression, _p);
<<<<<<< Updated upstream
		int _la;
=======
>>>>>>> Stashed changes
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
<<<<<<< Updated upstream
			setState(356);
			((Additive_expressionContext)_localctx).mult = multiplicative_expression(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(363);
=======
			setState(358);
			multiplicative_expression(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(365);
>>>>>>> Stashed changes
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,33,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new Additive_expressionContext(_parentctx, _parentState);
					_localctx.add = _prevctx;
					_localctx.add = _prevctx;
					pushNewRecursionContext(_localctx, _startState, RULE_additive_expression);
<<<<<<< Updated upstream
					setState(358);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(359);
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
					setState(360);
					((Additive_expressionContext)_localctx).mult = multiplicative_expression(0);
					}
					} 
				}
				setState(365);
=======
					setState(360);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(361);
					match(ADDITIVE_OPERATOR);
					setState(362);
					multiplicative_expression(0);
					}
					} 
				}
				setState(367);
>>>>>>> Stashed changes
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

	public static class Multiplicative_expressionContext extends ParserRuleContext {
		public Multiplicative_expressionContext mult;
		public FactorContext fac;
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
		int _startState = 58;
		enterRecursionRule(_localctx, 58, RULE_multiplicative_expression, _p);
<<<<<<< Updated upstream
		int _la;
=======
>>>>>>> Stashed changes
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
<<<<<<< Updated upstream
			setState(367);
			((Multiplicative_expressionContext)_localctx).fac = factor();
			}
			_ctx.stop = _input.LT(-1);
			setState(374);
=======
			setState(369);
			factor();
			}
			_ctx.stop = _input.LT(-1);
			setState(376);
>>>>>>> Stashed changes
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,34,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new Multiplicative_expressionContext(_parentctx, _parentState);
					_localctx.mult = _prevctx;
					_localctx.mult = _prevctx;
					pushNewRecursionContext(_localctx, _startState, RULE_multiplicative_expression);
<<<<<<< Updated upstream
					setState(369);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(370);
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
					setState(371);
					((Multiplicative_expressionContext)_localctx).fac = factor();
					}
					} 
				}
				setState(376);
=======
					setState(371);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(372);
					match(MULTIPLICATIVE_OPERATOR);
					setState(373);
					factor();
					}
					} 
				}
				setState(378);
>>>>>>> Stashed changes
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,34,_ctx);
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
		enterRule(_localctx, 60, RULE_factor);
<<<<<<< Updated upstream
		int _la;
		try {
			setState(383);
=======
		try {
			setState(385);
>>>>>>> Stashed changes
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,35,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
<<<<<<< Updated upstream
				setState(377);
=======
				setState(379);
>>>>>>> Stashed changes
				literal();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
<<<<<<< Updated upstream
				setState(378);
=======
				setState(380);
>>>>>>> Stashed changes
				object_instantiation();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
<<<<<<< Updated upstream
				setState(379);
				_la = _input.LA(1);
				if ( !(_la==T__36 || _la==T__40) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(380);
=======
				setState(381);
				match(UNARY_OPERATOR);
				setState(382);
>>>>>>> Stashed changes
				factor();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
<<<<<<< Updated upstream
				setState(381);
=======
				setState(383);
>>>>>>> Stashed changes
				type_cast();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
<<<<<<< Updated upstream
				setState(382);
=======
				setState(384);
>>>>>>> Stashed changes
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
		int _startState = 62;
		enterRecursionRule(_localctx, 62, RULE_access, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
<<<<<<< Updated upstream
			setState(386);
			((AccessContext)_localctx).sub = subfactor();
			}
			_ctx.stop = _input.LT(-1);
			setState(396);
=======
			setState(388);
			subfactor();
			}
			_ctx.stop = _input.LT(-1);
			setState(398);
>>>>>>> Stashed changes
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,37,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
<<<<<<< Updated upstream
					setState(394);
=======
					setState(396);
>>>>>>> Stashed changes
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,36,_ctx) ) {
					case 1:
						{
						_localctx = new AccessContext(_parentctx, _parentState);
						_localctx.rec = _prevctx;
						_localctx.rec = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_access);
<<<<<<< Updated upstream
						setState(388);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(389);
=======
						setState(390);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(391);
>>>>>>> Stashed changes
						field_access();
						}
						break;
					case 2:
						{
						_localctx = new AccessContext(_parentctx, _parentState);
						_localctx.rec = _prevctx;
						_localctx.rec = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_access);
<<<<<<< Updated upstream
						setState(390);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(391);
=======
						setState(392);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(393);
>>>>>>> Stashed changes
						element_access();
						}
						break;
					case 3:
						{
						_localctx = new AccessContext(_parentctx, _parentState);
						_localctx.rec = _prevctx;
						_localctx.rec = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_access);
<<<<<<< Updated upstream
						setState(392);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(393);
=======
						setState(394);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(395);
>>>>>>> Stashed changes
						method_access();
						}
						break;
					}
					} 
				}
<<<<<<< Updated upstream
				setState(398);
=======
				setState(400);
>>>>>>> Stashed changes
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
		enterRule(_localctx, 64, RULE_field_access);
		try {
			enterOuterAlt(_localctx, 1);
			{
<<<<<<< Updated upstream
			setState(399);
			match(T__41);
			setState(400);
			((Field_accessContext)_localctx).id = identifier();
=======
			setState(401);
			match(T__23);
			setState(402);
			identifier();
>>>>>>> Stashed changes
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
		public Logic_expressionContext expr;
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
		enterRule(_localctx, 66, RULE_element_access);
		try {
			enterOuterAlt(_localctx, 1);
			{
<<<<<<< Updated upstream
			setState(402);
			match(T__42);
			setState(403);
			((Element_accessContext)_localctx).expr = logic_expression();
			setState(404);
			match(T__43);
=======
			setState(404);
			match(T__24);
			setState(405);
			expression();
			setState(406);
			match(T__25);
>>>>>>> Stashed changes
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
		enterRule(_localctx, 68, RULE_method_access);
		try {
			enterOuterAlt(_localctx, 1);
			{
<<<<<<< Updated upstream
			setState(406);
			match(T__41);
			setState(407);
			((Method_accessContext)_localctx).method = method_call();
=======
			setState(408);
			match(T__23);
			setState(409);
			method_call();
>>>>>>> Stashed changes
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
		enterRule(_localctx, 70, RULE_subfactor);
		try {
<<<<<<< Updated upstream
			setState(412);
=======
			setState(414);
>>>>>>> Stashed changes
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,38,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
<<<<<<< Updated upstream
				setState(409);
=======
				setState(411);
>>>>>>> Stashed changes
				parenthesis_expression();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
<<<<<<< Updated upstream
				setState(410);
=======
				setState(412);
>>>>>>> Stashed changes
				identifier();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
<<<<<<< Updated upstream
				setState(411);
=======
				setState(413);
>>>>>>> Stashed changes
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
		public Logic_expressionContext expr;
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
		enterRule(_localctx, 72, RULE_parenthesis_expression);
		try {
			enterOuterAlt(_localctx, 1);
			{
<<<<<<< Updated upstream
			setState(414);
			match(LPAREN);
			setState(415);
			((Parenthesis_expressionContext)_localctx).expr = logic_expression();
			setState(416);
=======
			setState(416);
			match(LPAREN);
			setState(417);
			logic_expression();
			setState(418);
>>>>>>> Stashed changes
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
		enterRule(_localctx, 74, RULE_method_call);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
<<<<<<< Updated upstream
			setState(418);
			((Method_callContext)_localctx).id = identifier();
			setState(419);
			match(LPAREN);
			setState(421);
=======
			setState(420);
			identifier();
			setState(421);
			match(LPAREN);
			setState(423);
>>>>>>> Stashed changes
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((((_la - 37)) & ~0x3f) == 0 && ((1L << (_la - 37)) & ((1L << (T__36 - 37)) | (1L << (T__40 - 37)) | (1L << (T__44 - 37)) | (1L << (NUMBER_LITERAL - 37)) | (1L << (STRING_LITERAL - 37)) | (1L << (BOOL_LITERAL - 37)) | (1L << (NULL_LITERAL - 37)) | (1L << (IDENTIFIER - 37)) | (1L << (LPAREN - 37)))) != 0)) {
				{
<<<<<<< Updated upstream
				setState(420);
				((Method_callContext)_localctx).args = argument_list();
				}
			}

			setState(423);
=======
				setState(422);
				argument_list();
				}
			}

			setState(425);
>>>>>>> Stashed changes
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
		enterRule(_localctx, 76, RULE_type_cast);
		try {
			enterOuterAlt(_localctx, 1);
			{
<<<<<<< Updated upstream
			setState(425);
			match(LPAREN);
			setState(426);
			((Type_castContext)_localctx).type = data_type();
			setState(427);
			match(RPAREN);
			setState(428);
			((Type_castContext)_localctx).fac = factor();
=======
			setState(427);
			match(LPAREN);
			setState(428);
			data_type();
			setState(429);
			match(RPAREN);
			setState(430);
			factor();
>>>>>>> Stashed changes
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
		enterRule(_localctx, 78, RULE_object_instantiation);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
<<<<<<< Updated upstream
			setState(430);
			match(T__44);
			setState(431);
			((Object_instantiationContext)_localctx).type = data_type();
			setState(432);
			match(LPAREN);
			setState(434);
=======
			setState(432);
			match(T__26);
			setState(433);
			data_type();
			setState(434);
			match(LPAREN);
			setState(436);
>>>>>>> Stashed changes
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((((_la - 37)) & ~0x3f) == 0 && ((1L << (_la - 37)) & ((1L << (T__36 - 37)) | (1L << (T__40 - 37)) | (1L << (T__44 - 37)) | (1L << (NUMBER_LITERAL - 37)) | (1L << (STRING_LITERAL - 37)) | (1L << (BOOL_LITERAL - 37)) | (1L << (NULL_LITERAL - 37)) | (1L << (IDENTIFIER - 37)) | (1L << (LPAREN - 37)))) != 0)) {
				{
<<<<<<< Updated upstream
				setState(433);
				((Object_instantiationContext)_localctx).args = argument_list();
				}
			}

			setState(436);
=======
				setState(435);
				argument_list();
				}
			}

			setState(438);
>>>>>>> Stashed changes
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
		enterRule(_localctx, 80, RULE_event_type);
		int _la;
		try {
<<<<<<< Updated upstream
			setState(447);
=======
			setState(449);
>>>>>>> Stashed changes
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__45:
				enterOuterAlt(_localctx, 1);
				{
<<<<<<< Updated upstream
				setState(438);
				((Event_typeContext)_localctx).type = match(T__45);
=======
				setState(440);
				match(T__27);
>>>>>>> Stashed changes
				}
				break;
			case T__46:
				enterOuterAlt(_localctx, 2);
				{
<<<<<<< Updated upstream
				setState(439);
				((Event_typeContext)_localctx).type = match(T__46);
=======
				setState(441);
				match(T__28);
>>>>>>> Stashed changes
				}
				break;
			case T__47:
				enterOuterAlt(_localctx, 3);
				{
<<<<<<< Updated upstream
				setState(440);
				((Event_typeContext)_localctx).type = match(T__47);
=======
				setState(442);
				match(T__29);
>>>>>>> Stashed changes
				}
				break;
			case T__48:
				enterOuterAlt(_localctx, 4);
				{
<<<<<<< Updated upstream
				setState(441);
				((Event_typeContext)_localctx).type = match(T__48);
=======
				setState(443);
				match(T__30);
>>>>>>> Stashed changes
				}
				break;
			case T__49:
			case T__50:
				enterOuterAlt(_localctx, 5);
				{
<<<<<<< Updated upstream
				setState(442);
				((Event_typeContext)_localctx).type = _input.LT(1);
=======
				setState(444);
>>>>>>> Stashed changes
				_la = _input.LA(1);
				if ( !(_la==T__49 || _la==T__50) ) {
					((Event_typeContext)_localctx).type = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
<<<<<<< Updated upstream
				setState(443);
				match(LPAREN);
				setState(444);
				((Event_typeContext)_localctx).param = number_literal();
				setState(445);
=======
				setState(445);
				match(LPAREN);
				setState(446);
				number_literal();
				setState(447);
>>>>>>> Stashed changes
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
		enterRule(_localctx, 82, RULE_data_type);
		try {
<<<<<<< Updated upstream
			setState(460);
=======
			setState(464);
>>>>>>> Stashed changes
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__51:
				enterOuterAlt(_localctx, 1);
				{
<<<<<<< Updated upstream
				setState(449);
				match(T__51);
=======
				setState(451);
				match(T__33);
>>>>>>> Stashed changes
				}
				break;
			case T__52:
				enterOuterAlt(_localctx, 2);
				{
<<<<<<< Updated upstream
				setState(450);
				match(T__52);
=======
				setState(452);
				match(T__34);
>>>>>>> Stashed changes
				}
				break;
			case T__53:
				enterOuterAlt(_localctx, 3);
				{
<<<<<<< Updated upstream
				setState(451);
				match(T__53);
=======
				setState(453);
				match(T__35);
>>>>>>> Stashed changes
				}
				break;
			case T__54:
				enterOuterAlt(_localctx, 4);
				{
<<<<<<< Updated upstream
				setState(452);
				match(T__54);
=======
				setState(454);
				match(T__36);
>>>>>>> Stashed changes
				}
				break;
			case T__55:
				enterOuterAlt(_localctx, 5);
				{
<<<<<<< Updated upstream
				setState(453);
				match(T__55);
				setState(454);
				match(T__56);
				setState(455);
				((Data_typeContext)_localctx).childType = data_type();
				setState(456);
				match(T__57);
=======
				setState(455);
				match(T__37);
				setState(456);
				match(T__38);
				setState(457);
				data_type();
				setState(458);
				match(T__39);
>>>>>>> Stashed changes
				}
				break;
			case T__58:
				enterOuterAlt(_localctx, 6);
				{
<<<<<<< Updated upstream
				setState(458);
				match(T__58);
=======
				setState(460);
				match(T__40);
>>>>>>> Stashed changes
				}
				break;
			case T__59:
				enterOuterAlt(_localctx, 7);
				{
<<<<<<< Updated upstream
				setState(459);
				match(T__59);
=======
				setState(461);
				match(T__41);
				}
				break;
			case T__42:
				enterOuterAlt(_localctx, 8);
				{
				setState(462);
				match(T__42);
				}
				break;
			case T__43:
				enterOuterAlt(_localctx, 9);
				{
				setState(463);
				match(T__43);
>>>>>>> Stashed changes
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
		enterRule(_localctx, 84, RULE_literal);
		try {
<<<<<<< Updated upstream
			setState(467);
=======
			setState(471);
>>>>>>> Stashed changes
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case BOOL_LITERAL:
				enterOuterAlt(_localctx, 1);
				{
<<<<<<< Updated upstream
				setState(462);
=======
				setState(466);
>>>>>>> Stashed changes
				bool_literal();
				}
				break;
			case STRING_LITERAL:
				enterOuterAlt(_localctx, 2);
				{
<<<<<<< Updated upstream
				setState(463);
=======
				setState(467);
>>>>>>> Stashed changes
				string_literal();
				}
				break;
			case NUMBER_LITERAL:
				enterOuterAlt(_localctx, 3);
				{
<<<<<<< Updated upstream
				setState(464);
=======
				setState(468);
>>>>>>> Stashed changes
				number_literal();
				}
				break;
			case LPAREN:
				enterOuterAlt(_localctx, 4);
				{
<<<<<<< Updated upstream
				setState(465);
=======
				setState(469);
>>>>>>> Stashed changes
				coordinate_literal();
				}
				break;
			case NULL_LITERAL:
				enterOuterAlt(_localctx, 5);
				{
<<<<<<< Updated upstream
				setState(466);
=======
				setState(470);
>>>>>>> Stashed changes
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
		enterRule(_localctx, 86, RULE_string_literal);
		try {
			enterOuterAlt(_localctx, 1);
			{
<<<<<<< Updated upstream
			setState(469);
=======
			setState(473);
>>>>>>> Stashed changes
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
		enterRule(_localctx, 88, RULE_coordinate_literal);
		try {
			enterOuterAlt(_localctx, 1);
			{
<<<<<<< Updated upstream
			setState(471);
			match(LPAREN);
			setState(472);
			((Coordinate_literalContext)_localctx).x = logic_expression();
			setState(473);
			match(T__8);
			setState(474);
			((Coordinate_literalContext)_localctx).y = logic_expression();
			setState(475);
			match(T__8);
			setState(476);
			((Coordinate_literalContext)_localctx).z = logic_expression();
			setState(477);
=======
			setState(475);
			match(LPAREN);
			setState(476);
			logic_expression();
			setState(477);
			match(T__8);
			setState(478);
			logic_expression();
			setState(479);
			match(T__8);
			setState(480);
			logic_expression();
			setState(481);
>>>>>>> Stashed changes
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
		enterRule(_localctx, 90, RULE_number_literal);
		try {
			enterOuterAlt(_localctx, 1);
			{
<<<<<<< Updated upstream
			setState(479);
=======
			setState(483);
>>>>>>> Stashed changes
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
		enterRule(_localctx, 92, RULE_bool_literal);
		try {
			enterOuterAlt(_localctx, 1);
			{
<<<<<<< Updated upstream
			setState(481);
=======
			setState(485);
>>>>>>> Stashed changes
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
		enterRule(_localctx, 94, RULE_null_literal);
		try {
			enterOuterAlt(_localctx, 1);
			{
<<<<<<< Updated upstream
			setState(483);
=======
			setState(487);
>>>>>>> Stashed changes
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
		enterRule(_localctx, 96, RULE_identifier);
		try {
			enterOuterAlt(_localctx, 1);
			{
<<<<<<< Updated upstream
			setState(485);
<<<<<<< HEAD
=======
			setState(489);
>>>>>>> Stashed changes
			match(IDENTIFIER);
=======
			((IdentifierContext)_localctx).id = match(IDENTIFIER);
>>>>>>> CFGupdate
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
		enterRule(_localctx, 98, RULE_end_of_line);
		try {
			enterOuterAlt(_localctx, 1);
			{
<<<<<<< Updated upstream
			setState(487);
=======
			setState(491);
>>>>>>> Stashed changes
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

	public static class Assignment_operatorContext extends ParserRuleContext {
		public Assignment_operatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignment_operator; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EduCodeVisitor ) return ((EduCodeVisitor<? extends T>)visitor).visitAssignment_operator(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Assignment_operatorContext assignment_operator() throws RecognitionException {
		Assignment_operatorContext _localctx = new Assignment_operatorContext(_ctx, getState());
		enterRule(_localctx, 100, RULE_assignment_operator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(493);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__22) | (1L << T__44) | (1L << T__45) | (1L << T__46) | (1L << T__47))) != 0)) ) {
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
		case 23:
			return or_expression_sempred((Or_expressionContext)_localctx, predIndex);
		case 24:
			return and_expression_sempred((And_expressionContext)_localctx, predIndex);
		case 25:
			return equality_expression_sempred((Equality_expressionContext)_localctx, predIndex);
		case 28:
			return additive_expression_sempred((Additive_expressionContext)_localctx, predIndex);
		case 29:
			return multiplicative_expression_sempred((Multiplicative_expressionContext)_localctx, predIndex);
		case 31:
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
<<<<<<< Updated upstream
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3I\u01ec\4\2\t\2\4"+
=======
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3D\u01f2\4\2\t\2\4"+
>>>>>>> Stashed changes
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
<<<<<<< Updated upstream
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\3\2\5\2"+
		"h\n\2\3\2\3\2\3\3\3\3\3\3\6\3o\n\3\r\3\16\3p\3\3\3\3\3\3\6\3v\n\3\r\3"+
		"\16\3w\7\3z\n\3\f\3\16\3}\13\3\3\4\3\4\3\4\6\4\u0082\n\4\r\4\16\4\u0083"+
		"\3\4\3\4\3\4\5\4\u0089\n\4\3\4\6\4\u008c\n\4\r\4\16\4\u008d\7\4\u0090"+
		"\n\4\f\4\16\4\u0093\13\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\5"+
		"\6\u00a0\n\6\3\6\3\6\3\6\5\6\u00a5\n\6\3\6\6\6\u00a8\n\6\r\6\16\6\u00a9"+
		"\3\6\3\6\3\6\3\7\3\7\3\7\7\7\u00b2\n\7\f\7\16\7\u00b5\13\7\3\b\3\b\3\b"+
		"\7\b\u00ba\n\b\f\b\16\b\u00bd\13\b\3\t\3\t\3\t\3\n\3\n\6\n\u00c4\n\n\r"+
		"\n\16\n\u00c5\7\n\u00c8\n\n\f\n\16\n\u00cb\13\n\3\13\3\13\3\13\3\13\3"+
		"\13\3\13\3\13\3\13\5\13\u00d5\n\13\3\f\3\f\3\f\3\f\5\f\u00db\n\f\3\r\3"+
		"\r\5\r\u00df\n\r\3\16\3\16\3\17\3\17\3\20\3\20\5\20\u00e7\n\20\3\21\3"+
		"\21\3\21\6\21\u00ec\n\21\r\21\16\21\u00ed\3\21\3\21\3\21\3\22\3\22\3\22"+
		"\3\22\6\22\u00f7\n\22\r\22\16\22\u00f8\3\22\3\22\3\22\3\22\3\22\6\22\u0100"+
		"\n\22\r\22\16\22\u0101\3\22\3\22\7\22\u0106\n\22\f\22\16\22\u0109\13\22"+
		"\3\22\3\22\6\22\u010d\n\22\r\22\16\22\u010e\3\22\3\22\5\22\u0113\n\22"+
		"\3\22\3\22\3\23\3\23\3\23\3\23\3\23\3\23\6\23\u011d\n\23\r\23\16\23\u011e"+
		"\3\23\3\23\3\23\3\24\3\24\3\24\3\24\7\24\u0128\n\24\f\24\16\24\u012b\13"+
		"\24\3\25\3\25\3\25\5\25\u0130\n\25\3\26\3\26\5\26\u0134\n\26\3\27\3\27"+
		"\3\27\3\27\3\30\3\30\3\31\3\31\3\31\3\31\3\31\3\31\7\31\u0142\n\31\f\31"+
		"\16\31\u0145\13\31\3\32\3\32\3\32\3\32\3\32\3\32\7\32\u014d\n\32\f\32"+
		"\16\32\u0150\13\32\3\33\3\33\3\33\3\33\3\33\3\33\7\33\u0158\n\33\f\33"+
		"\16\33\u015b\13\33\3\34\3\34\3\34\3\34\3\34\5\34\u0162\n\34\3\35\3\35"+
		"\3\36\3\36\3\36\3\36\3\36\3\36\7\36\u016c\n\36\f\36\16\36\u016f\13\36"+
		"\3\37\3\37\3\37\3\37\3\37\3\37\7\37\u0177\n\37\f\37\16\37\u017a\13\37"+
		"\3 \3 \3 \3 \3 \3 \5 \u0182\n \3!\3!\3!\3!\3!\3!\3!\3!\3!\7!\u018d\n!"+
		"\f!\16!\u0190\13!\3\"\3\"\3\"\3#\3#\3#\3#\3$\3$\3$\3%\3%\3%\5%\u019f\n"+
		"%\3&\3&\3&\3&\3\'\3\'\3\'\5\'\u01a8\n\'\3\'\3\'\3(\3(\3(\3(\3(\3)\3)\3"+
		")\3)\5)\u01b5\n)\3)\3)\3*\3*\3*\3*\3*\3*\3*\3*\3*\5*\u01c2\n*\3+\3+\3"+
		"+\3+\3+\3+\3+\3+\3+\3+\3+\5+\u01cf\n+\3,\3,\3,\3,\3,\5,\u01d6\n,\3-\3"+
		"-\3.\3.\3.\3.\3.\3.\3.\3.\3/\3/\3\60\3\60\3\61\3\61\3\62\3\62\3\63\3\63"+
		"\3\63\2\b\60\62\64:<@\64\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&("+
		"*,.\60\62\64\668:<>@BDFHJLNPRTVXZ\\^`bd\2\t\3\2\31\35\3\2 !\3\2\"%\3\2"+
		"&\'\3\2(*\4\2\'\'++\3\2\64\65\u01fc\2g\3\2\2\2\4k\3\2\2\2\6~\3\2\2\2\b"+
		"\u0096\3\2\2\2\n\u009b\3\2\2\2\f\u00ae\3\2\2\2\16\u00b6\3\2\2\2\20\u00be"+
		"\3\2\2\2\22\u00c9\3\2\2\2\24\u00d4\3\2\2\2\26\u00da\3\2\2\2\30\u00de\3"+
		"\2\2\2\32\u00e0\3\2\2\2\34\u00e2\3\2\2\2\36\u00e4\3\2\2\2 \u00e8\3\2\2"+
		"\2\"\u00f2\3\2\2\2$\u0116\3\2\2\2&\u0123\3\2\2\2(\u012c\3\2\2\2*\u0133"+
		"\3\2\2\2,\u0135\3\2\2\2.\u0139\3\2\2\2\60\u013b\3\2\2\2\62\u0146\3\2\2"+
		"\2\64\u0151\3\2\2\2\66\u0161\3\2\2\28\u0163\3\2\2\2:\u0165\3\2\2\2<\u0170"+
		"\3\2\2\2>\u0181\3\2\2\2@\u0183\3\2\2\2B\u0191\3\2\2\2D\u0194\3\2\2\2F"+
		"\u0198\3\2\2\2H\u019e\3\2\2\2J\u01a0\3\2\2\2L\u01a4\3\2\2\2N\u01ab\3\2"+
		"\2\2P\u01b0\3\2\2\2R\u01c1\3\2\2\2T\u01ce\3\2\2\2V\u01d5\3\2\2\2X\u01d7"+
		"\3\2\2\2Z\u01d9\3\2\2\2\\\u01e1\3\2\2\2^\u01e3\3\2\2\2`\u01e5\3\2\2\2"+
		"b\u01e7\3\2\2\2d\u01e9\3\2\2\2fh\5\4\3\2gf\3\2\2\2gh\3\2\2\2hi\3\2\2\2"+
		"ij\5\6\4\2j\3\3\2\2\2kl\7\3\2\2ln\5b\62\2mo\5d\63\2nm\3\2\2\2op\3\2\2"+
		"\2pn\3\2\2\2pq\3\2\2\2q{\3\2\2\2rs\7\3\2\2su\5b\62\2tv\5d\63\2ut\3\2\2"+
		"\2vw\3\2\2\2wu\3\2\2\2wx\3\2\2\2xz\3\2\2\2yr\3\2\2\2z}\3\2\2\2{y\3\2\2"+
		"\2{|\3\2\2\2|\5\3\2\2\2}{\3\2\2\2~\177\7\4\2\2\177\u0081\5b\62\2\u0080"+
		"\u0082\5d\63\2\u0081\u0080\3\2\2\2\u0082\u0083\3\2\2\2\u0083\u0081\3\2"+
		"\2\2\u0083\u0084\3\2\2\2\u0084\u0091\3\2\2\2\u0085\u0089\5\b\5\2\u0086"+
		"\u0089\5\n\6\2\u0087\u0089\5&\24\2\u0088\u0085\3\2\2\2\u0088\u0086\3\2"+
		"\2\2\u0088\u0087\3\2\2\2\u0089\u008b\3\2\2\2\u008a\u008c\5d\63\2\u008b"+
		"\u008a\3\2\2\2\u008c\u008d\3\2\2\2\u008d\u008b\3\2\2\2\u008d\u008e\3\2"+
		"\2\2\u008e\u0090\3\2\2\2\u008f\u0088\3\2\2\2\u0090\u0093\3\2\2\2\u0091"+
		"\u008f\3\2\2\2\u0091\u0092\3\2\2\2\u0092\u0094\3\2\2\2\u0093\u0091\3\2"+
		"\2\2\u0094\u0095\7\5\2\2\u0095\7\3\2\2\2\u0096\u0097\7\6\2\2\u0097\u0098"+
		"\5R*\2\u0098\u0099\7\7\2\2\u0099\u009a\5b\62\2\u009a\t\3\2\2\2\u009b\u009c"+
		"\7\b\2\2\u009c\u009d\5b\62\2\u009d\u009f\7F\2\2\u009e\u00a0\5\16\b\2\u009f"+
		"\u009e\3\2\2\2\u009f\u00a0\3\2\2\2\u00a0\u00a1\3\2\2\2\u00a1\u00a4\7G"+
		"\2\2\u00a2\u00a3\7\t\2\2\u00a3\u00a5\5T+\2\u00a4\u00a2\3\2\2\2\u00a4\u00a5"+
		"\3\2\2\2\u00a5\u00a7\3\2\2\2\u00a6\u00a8\5d\63\2\u00a7\u00a6\3\2\2\2\u00a8"+
		"\u00a9\3\2\2\2\u00a9\u00a7\3\2\2\2\u00a9\u00aa\3\2\2\2\u00aa\u00ab\3\2"+
		"\2\2\u00ab\u00ac\5\22\n\2\u00ac\u00ad\7\n\2\2\u00ad\13\3\2\2\2\u00ae\u00b3"+
		"\5*\26\2\u00af\u00b0\7\13\2\2\u00b0\u00b2\5*\26\2\u00b1\u00af\3\2\2\2"+
		"\u00b2\u00b5\3\2\2\2\u00b3\u00b1\3\2\2\2\u00b3\u00b4\3\2\2\2\u00b4\r\3"+
		"\2\2\2\u00b5\u00b3\3\2\2\2\u00b6\u00bb\5\20\t\2\u00b7\u00b8\7\13\2\2\u00b8"+
		"\u00ba\5\20\t\2\u00b9\u00b7\3\2\2\2\u00ba\u00bd\3\2\2\2\u00bb\u00b9\3"+
		"\2\2\2\u00bb\u00bc\3\2\2\2\u00bc\17\3\2\2\2\u00bd\u00bb\3\2\2\2\u00be"+
		"\u00bf\5T+\2\u00bf\u00c0\5b\62\2\u00c0\21\3\2\2\2\u00c1\u00c3\5\24\13"+
		"\2\u00c2\u00c4\5d\63\2\u00c3\u00c2\3\2\2\2\u00c4\u00c5\3\2\2\2\u00c5\u00c3"+
		"\3\2\2\2\u00c5\u00c6\3\2\2\2\u00c6\u00c8\3\2\2\2\u00c7\u00c1\3\2\2\2\u00c8"+
		"\u00cb\3\2\2\2\u00c9\u00c7\3\2\2\2\u00c9\u00ca\3\2\2\2\u00ca\23\3\2\2"+
		"\2\u00cb\u00c9\3\2\2\2\u00cc\u00d5\5\26\f\2\u00cd\u00d5\5,\27\2\u00ce"+
		"\u00d5\5&\24\2\u00cf\u00d5\5\"\22\2\u00d0\u00d5\5\30\r\2\u00d1\u00d5\5"+
		"\36\20\2\u00d2\u00d5\5\32\16\2\u00d3\u00d5\5\34\17\2\u00d4\u00cc\3\2\2"+
		"\2\u00d4\u00cd\3\2\2\2\u00d4\u00ce\3\2\2\2\u00d4\u00cf\3\2\2\2\u00d4\u00d0"+
		"\3\2\2\2\u00d4\u00d1\3\2\2\2\u00d4\u00d2\3\2\2\2\u00d4\u00d3\3\2\2\2\u00d5"+
		"\25\3\2\2\2\u00d6\u00db\5L\'\2\u00d7\u00d8\5@!\2\u00d8\u00d9\5F$\2\u00d9"+
		"\u00db\3\2\2\2\u00da\u00d6\3\2\2\2\u00da\u00d7\3\2\2\2\u00db\27\3\2\2"+
		"\2\u00dc\u00df\5 \21\2\u00dd\u00df\5$\23\2\u00de\u00dc\3\2\2\2\u00de\u00dd"+
		"\3\2\2\2\u00df\31\3\2\2\2\u00e0\u00e1\7\f\2\2\u00e1\33\3\2\2\2\u00e2\u00e3"+
		"\7\r\2\2\u00e3\35\3\2\2\2\u00e4\u00e6\7\16\2\2\u00e5\u00e7\5*\26\2\u00e6"+
		"\u00e5\3\2\2\2\u00e6\u00e7\3\2\2\2\u00e7\37\3\2\2\2\u00e8\u00e9\7\17\2"+
		"\2\u00e9\u00eb\5.\30\2\u00ea\u00ec\5d\63\2\u00eb\u00ea\3\2\2\2\u00ec\u00ed"+
		"\3\2\2\2\u00ed\u00eb\3\2\2\2\u00ed\u00ee\3\2\2\2\u00ee\u00ef\3\2\2\2\u00ef"+
		"\u00f0\5\22\n\2\u00f0\u00f1\7\20\2\2\u00f1!\3\2\2\2\u00f2\u00f3\7\21\2"+
		"\2\u00f3\u00f4\5.\30\2\u00f4\u00f6\7\22\2\2\u00f5\u00f7\5d\63\2\u00f6"+
		"\u00f5\3\2\2\2\u00f7\u00f8\3\2\2\2\u00f8\u00f6\3\2\2\2\u00f8\u00f9\3\2"+
		"\2\2\u00f9\u00fa\3\2\2\2\u00fa\u0107\5\22\n\2\u00fb\u00fc\7\23\2\2\u00fc"+
		"\u00fd\5.\30\2\u00fd\u00ff\7\22\2\2\u00fe\u0100\5d\63\2\u00ff\u00fe\3"+
		"\2\2\2\u0100\u0101\3\2\2\2\u0101\u00ff\3\2\2\2\u0101\u0102\3\2\2\2\u0102"+
		"\u0103\3\2\2\2\u0103\u0104\5\22\n\2\u0104\u0106\3\2\2\2\u0105\u00fb\3"+
		"\2\2\2\u0106\u0109\3\2\2\2\u0107\u0105\3\2\2\2\u0107\u0108\3\2\2\2\u0108"+
		"\u0112\3\2\2\2\u0109\u0107\3\2\2\2\u010a\u010c\7\24\2\2\u010b\u010d\5"+
		"d\63\2\u010c\u010b\3\2\2\2\u010d\u010e\3\2\2\2\u010e\u010c\3\2\2\2\u010e"+
		"\u010f\3\2\2\2\u010f\u0110\3\2\2\2\u0110\u0111\5\22\n\2\u0111\u0113\3"+
		"\2\2\2\u0112\u010a\3\2\2\2\u0112\u0113\3\2\2\2\u0113\u0114\3\2\2\2\u0114"+
		"\u0115\7\25\2\2\u0115#\3\2\2\2\u0116\u0117\7\26\2\2\u0117\u0118\5T+\2"+
		"\u0118\u0119\5b\62\2\u0119\u011a\7\27\2\2\u011a\u011c\5*\26\2\u011b\u011d"+
		"\5d\63\2\u011c\u011b\3\2\2\2\u011d\u011e\3\2\2\2\u011e\u011c\3\2\2\2\u011e"+
		"\u011f\3\2\2\2\u011f\u0120\3\2\2\2\u0120\u0121\5\22\n\2\u0121\u0122\7"+
		"\30\2\2\u0122%\3\2\2\2\u0123\u0124\5T+\2\u0124\u0129\5(\25\2\u0125\u0126"+
		"\7\13\2\2\u0126\u0128\5(\25\2\u0127\u0125\3\2\2\2\u0128\u012b\3\2\2\2"+
		"\u0129\u0127\3\2\2\2\u0129\u012a\3\2\2\2\u012a\'\3\2\2\2\u012b\u0129\3"+
		"\2\2\2\u012c\u012f\5b\62\2\u012d\u012e\7\31\2\2\u012e\u0130\5*\26\2\u012f"+
		"\u012d\3\2\2\2\u012f\u0130\3\2\2\2\u0130)\3\2\2\2\u0131\u0134\5,\27\2"+
		"\u0132\u0134\5.\30\2\u0133\u0131\3\2\2\2\u0133\u0132\3\2\2\2\u0134+\3"+
		"\2\2\2\u0135\u0136\5> \2\u0136\u0137\t\2\2\2\u0137\u0138\5*\26\2\u0138"+
		"-\3\2\2\2\u0139\u013a\5\60\31\2\u013a/\3\2\2\2\u013b\u013c\b\31\1\2\u013c"+
		"\u013d\5\62\32\2\u013d\u0143\3\2\2\2\u013e\u013f\f\4\2\2\u013f\u0140\7"+
		"\36\2\2\u0140\u0142\5\62\32\2\u0141\u013e\3\2\2\2\u0142\u0145\3\2\2\2"+
		"\u0143\u0141\3\2\2\2\u0143\u0144\3\2\2\2\u0144\61\3\2\2\2\u0145\u0143"+
		"\3\2\2\2\u0146\u0147\b\32\1\2\u0147\u0148\5\64\33\2\u0148\u014e\3\2\2"+
		"\2\u0149\u014a\f\4\2\2\u014a\u014b\7\37\2\2\u014b\u014d\5\64\33\2\u014c"+
		"\u0149\3\2\2\2\u014d\u0150\3\2\2\2\u014e\u014c\3\2\2\2\u014e\u014f\3\2"+
		"\2\2\u014f\63\3\2\2\2\u0150\u014e\3\2\2\2\u0151\u0152\b\33\1\2\u0152\u0153"+
		"\5\66\34\2\u0153\u0159\3\2\2\2\u0154\u0155\f\4\2\2\u0155\u0156\t\3\2\2"+
		"\u0156\u0158\5\66\34\2\u0157\u0154\3\2\2\2\u0158\u015b\3\2\2\2\u0159\u0157"+
		"\3\2\2\2\u0159\u015a\3\2\2\2\u015a\65\3\2\2\2\u015b\u0159\3\2\2\2\u015c"+
		"\u015d\58\35\2\u015d\u015e\t\4\2\2\u015e\u015f\58\35\2\u015f\u0162\3\2"+
		"\2\2\u0160\u0162\58\35\2\u0161\u015c\3\2\2\2\u0161\u0160\3\2\2\2\u0162"+
		"\67\3\2\2\2\u0163\u0164\5:\36\2\u01649\3\2\2\2\u0165\u0166\b\36\1\2\u0166"+
		"\u0167\5<\37\2\u0167\u016d\3\2\2\2\u0168\u0169\f\3\2\2\u0169\u016a\t\5"+
		"\2\2\u016a\u016c\5<\37\2\u016b\u0168\3\2\2\2\u016c\u016f\3\2\2\2\u016d"+
		"\u016b\3\2\2\2\u016d\u016e\3\2\2\2\u016e;\3\2\2\2\u016f\u016d\3\2\2\2"+
		"\u0170\u0171\b\37\1\2\u0171\u0172\5> \2\u0172\u0178\3\2\2\2\u0173\u0174"+
		"\f\3\2\2\u0174\u0175\t\6\2\2\u0175\u0177\5> \2\u0176\u0173\3\2\2\2\u0177"+
		"\u017a\3\2\2\2\u0178\u0176\3\2\2\2\u0178\u0179\3\2\2\2\u0179=\3\2\2\2"+
		"\u017a\u0178\3\2\2\2\u017b\u0182\5V,\2\u017c\u0182\5P)\2\u017d\u017e\t"+
		"\7\2\2\u017e\u0182\5> \2\u017f\u0182\5N(\2\u0180\u0182\5@!\2\u0181\u017b"+
		"\3\2\2\2\u0181\u017c\3\2\2\2\u0181\u017d\3\2\2\2\u0181\u017f\3\2\2\2\u0181"+
		"\u0180\3\2\2\2\u0182?\3\2\2\2\u0183\u0184\b!\1\2\u0184\u0185\5H%\2\u0185"+
		"\u018e\3\2\2\2\u0186\u0187\f\5\2\2\u0187\u018d\5B\"\2\u0188\u0189\f\4"+
		"\2\2\u0189\u018d\5D#\2\u018a\u018b\f\3\2\2\u018b\u018d\5F$\2\u018c\u0186"+
		"\3\2\2\2\u018c\u0188\3\2\2\2\u018c\u018a\3\2\2\2\u018d\u0190\3\2\2\2\u018e"+
		"\u018c\3\2\2\2\u018e\u018f\3\2\2\2\u018fA\3\2\2\2\u0190\u018e\3\2\2\2"+
		"\u0191\u0192\7,\2\2\u0192\u0193\5b\62\2\u0193C\3\2\2\2\u0194\u0195\7-"+
		"\2\2\u0195\u0196\5.\30\2\u0196\u0197\7.\2\2\u0197E\3\2\2\2\u0198\u0199"+
		"\7,\2\2\u0199\u019a\5L\'\2\u019aG\3\2\2\2\u019b\u019f\5J&\2\u019c\u019f"+
		"\5b\62\2\u019d\u019f\5L\'\2\u019e\u019b\3\2\2\2\u019e\u019c\3\2\2\2\u019e"+
		"\u019d\3\2\2\2\u019fI\3\2\2\2\u01a0\u01a1\7F\2\2\u01a1\u01a2\5.\30\2\u01a2"+
		"\u01a3\7G\2\2\u01a3K\3\2\2\2\u01a4\u01a5\5b\62\2\u01a5\u01a7\7F\2\2\u01a6"+
		"\u01a8\5\f\7\2\u01a7\u01a6\3\2\2\2\u01a7\u01a8\3\2\2\2\u01a8\u01a9\3\2"+
		"\2\2\u01a9\u01aa\7G\2\2\u01aaM\3\2\2\2\u01ab\u01ac\7F\2\2\u01ac\u01ad"+
		"\5T+\2\u01ad\u01ae\7G\2\2\u01ae\u01af\5> \2\u01afO\3\2\2\2\u01b0\u01b1"+
		"\7/\2\2\u01b1\u01b2\5T+\2\u01b2\u01b4\7F\2\2\u01b3\u01b5\5\f\7\2\u01b4"+
		"\u01b3\3\2\2\2\u01b4\u01b5\3\2\2\2\u01b5\u01b6\3\2\2\2\u01b6\u01b7\7G"+
		"\2\2\u01b7Q\3\2\2\2\u01b8\u01c2\7\60\2\2\u01b9\u01c2\7\61\2\2\u01ba\u01c2"+
		"\7\62\2\2\u01bb\u01c2\7\63\2\2\u01bc\u01bd\t\b\2\2\u01bd\u01be\7F\2\2"+
		"\u01be\u01bf\5\\/\2\u01bf\u01c0\7G\2\2\u01c0\u01c2\3\2\2\2\u01c1\u01b8"+
		"\3\2\2\2\u01c1\u01b9\3\2\2\2\u01c1\u01ba\3\2\2\2\u01c1\u01bb\3\2\2\2\u01c1"+
		"\u01bc\3\2\2\2\u01c2S\3\2\2\2\u01c3\u01cf\7\66\2\2\u01c4\u01cf\7\67\2"+
		"\2\u01c5\u01cf\78\2\2\u01c6\u01cf\79\2\2\u01c7\u01c8\7:\2\2\u01c8\u01c9"+
		"\7;\2\2\u01c9\u01ca\5T+\2\u01ca\u01cb\7<\2\2\u01cb\u01cf\3\2\2\2\u01cc"+
		"\u01cf\7=\2\2\u01cd\u01cf\7>\2\2\u01ce\u01c3\3\2\2\2\u01ce\u01c4\3\2\2"+
		"\2\u01ce\u01c5\3\2\2\2\u01ce\u01c6\3\2\2\2\u01ce\u01c7\3\2\2\2\u01ce\u01cc"+
		"\3\2\2\2\u01ce\u01cd\3\2\2\2\u01cfU\3\2\2\2\u01d0\u01d6\5^\60\2\u01d1"+
		"\u01d6\5X-\2\u01d2\u01d6\5\\/\2\u01d3\u01d6\5Z.\2\u01d4\u01d6\5`\61\2"+
		"\u01d5\u01d0\3\2\2\2\u01d5\u01d1\3\2\2\2\u01d5\u01d2\3\2\2\2\u01d5\u01d3"+
		"\3\2\2\2\u01d5\u01d4\3\2\2\2\u01d6W\3\2\2\2\u01d7\u01d8\7A\2\2\u01d8Y"+
		"\3\2\2\2\u01d9\u01da\7F\2\2\u01da\u01db\5.\30\2\u01db\u01dc\7\13\2\2\u01dc"+
		"\u01dd\5.\30\2\u01dd\u01de\7\13\2\2\u01de\u01df\5.\30\2\u01df\u01e0\7"+
		"G\2\2\u01e0[\3\2\2\2\u01e1\u01e2\7@\2\2\u01e2]\3\2\2\2\u01e3\u01e4\7C"+
		"\2\2\u01e4_\3\2\2\2\u01e5\u01e6\7D\2\2\u01e6a\3\2\2\2\u01e7\u01e8\7E\2"+
		"\2\u01e8c\3\2\2\2\u01e9\u01ea\7?\2\2\u01eae\3\2\2\2.gpw{\u0083\u0088\u008d"+
		"\u0091\u009f\u00a4\u00a9\u00b3\u00bb\u00c5\u00c9\u00d4\u00da\u00de\u00e6"+
		"\u00ed\u00f8\u0101\u0107\u010e\u0112\u011e\u0129\u012f\u0133\u0143\u014e"+
		"\u0159\u0161\u016d\u0178\u0181\u018c\u018e\u019e\u01a7\u01b4\u01c1\u01ce"+
		"\u01d5";
=======
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\3\2\5\2j\n\2\3\2\3\2\3\3\3\3\3\3\6\3q\n\3\r\3\16\3r\3\3\3\3\3\3\6"+
		"\3x\n\3\r\3\16\3y\7\3|\n\3\f\3\16\3\177\13\3\3\4\3\4\3\4\6\4\u0084\n\4"+
		"\r\4\16\4\u0085\3\4\3\4\3\4\5\4\u008b\n\4\3\4\6\4\u008e\n\4\r\4\16\4\u008f"+
		"\7\4\u0092\n\4\f\4\16\4\u0095\13\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\6\3\6"+
		"\3\6\3\6\5\6\u00a2\n\6\3\6\3\6\3\6\5\6\u00a7\n\6\3\6\6\6\u00aa\n\6\r\6"+
		"\16\6\u00ab\3\6\3\6\3\6\3\7\3\7\3\7\7\7\u00b4\n\7\f\7\16\7\u00b7\13\7"+
		"\3\b\3\b\3\b\7\b\u00bc\n\b\f\b\16\b\u00bf\13\b\3\t\3\t\3\t\3\n\3\n\6\n"+
		"\u00c6\n\n\r\n\16\n\u00c7\7\n\u00ca\n\n\f\n\16\n\u00cd\13\n\3\13\3\13"+
		"\3\13\3\13\3\13\3\13\3\13\3\13\5\13\u00d7\n\13\3\f\3\f\3\f\3\f\5\f\u00dd"+
		"\n\f\3\r\3\r\5\r\u00e1\n\r\3\16\3\16\3\17\3\17\3\20\3\20\5\20\u00e9\n"+
		"\20\3\21\3\21\3\21\6\21\u00ee\n\21\r\21\16\21\u00ef\3\21\3\21\3\21\3\22"+
		"\3\22\3\22\3\22\6\22\u00f9\n\22\r\22\16\22\u00fa\3\22\3\22\3\22\3\22\3"+
		"\22\6\22\u0102\n\22\r\22\16\22\u0103\3\22\3\22\7\22\u0108\n\22\f\22\16"+
		"\22\u010b\13\22\3\22\3\22\6\22\u010f\n\22\r\22\16\22\u0110\3\22\3\22\5"+
		"\22\u0115\n\22\3\22\3\22\3\23\3\23\3\23\3\23\3\23\3\23\6\23\u011f\n\23"+
		"\r\23\16\23\u0120\3\23\3\23\3\23\3\24\3\24\3\24\3\24\7\24\u012a\n\24\f"+
		"\24\16\24\u012d\13\24\3\25\3\25\3\25\5\25\u0132\n\25\3\26\3\26\5\26\u0136"+
		"\n\26\3\27\3\27\3\27\3\27\3\30\3\30\3\31\3\31\3\31\3\31\3\31\3\31\7\31"+
		"\u0144\n\31\f\31\16\31\u0147\13\31\3\32\3\32\3\32\3\32\3\32\3\32\7\32"+
		"\u014f\n\32\f\32\16\32\u0152\13\32\3\33\3\33\3\33\3\33\3\33\3\33\7\33"+
		"\u015a\n\33\f\33\16\33\u015d\13\33\3\34\3\34\3\34\3\34\3\34\5\34\u0164"+
		"\n\34\3\35\3\35\3\36\3\36\3\36\3\36\3\36\3\36\7\36\u016e\n\36\f\36\16"+
		"\36\u0171\13\36\3\37\3\37\3\37\3\37\3\37\3\37\7\37\u0179\n\37\f\37\16"+
		"\37\u017c\13\37\3 \3 \3 \3 \3 \3 \5 \u0184\n \3!\3!\3!\3!\3!\3!\3!\3!"+
		"\3!\7!\u018f\n!\f!\16!\u0192\13!\3\"\3\"\3\"\3#\3#\3#\3#\3$\3$\3$\3%\3"+
		"%\3%\5%\u01a1\n%\3&\3&\3&\3&\3\'\3\'\3\'\5\'\u01aa\n\'\3\'\3\'\3(\3(\3"+
		"(\3(\3(\3)\3)\3)\3)\5)\u01b7\n)\3)\3)\3*\3*\3*\3*\3*\3*\3*\3*\3*\5*\u01c4"+
		"\n*\3+\3+\3+\3+\3+\3+\3+\3+\3+\3+\3+\3+\3+\5+\u01d3\n+\3,\3,\3,\3,\3,"+
		"\5,\u01da\n,\3-\3-\3.\3.\3.\3.\3.\3.\3.\3.\3/\3/\3\60\3\60\3\61\3\61\3"+
		"\62\3\62\3\63\3\63\3\64\3\64\3\64\2\b\60\62\64:<@\65\2\4\6\b\n\f\16\20"+
		"\22\24\26\30\32\34\36 \"$&(*,.\60\62\64\668:<>@BDFHJLNPRTVXZ\\^`bdf\2"+
		"\4\3\2\"#\4\2\31\31/\62\2\u0203\2i\3\2\2\2\4m\3\2\2\2\6\u0080\3\2\2\2"+
		"\b\u0098\3\2\2\2\n\u009d\3\2\2\2\f\u00b0\3\2\2\2\16\u00b8\3\2\2\2\20\u00c0"+
		"\3\2\2\2\22\u00cb\3\2\2\2\24\u00d6\3\2\2\2\26\u00dc\3\2\2\2\30\u00e0\3"+
		"\2\2\2\32\u00e2\3\2\2\2\34\u00e4\3\2\2\2\36\u00e6\3\2\2\2 \u00ea\3\2\2"+
		"\2\"\u00f4\3\2\2\2$\u0118\3\2\2\2&\u0125\3\2\2\2(\u012e\3\2\2\2*\u0135"+
		"\3\2\2\2,\u0137\3\2\2\2.\u013b\3\2\2\2\60\u013d\3\2\2\2\62\u0148\3\2\2"+
		"\2\64\u0153\3\2\2\2\66\u0163\3\2\2\28\u0165\3\2\2\2:\u0167\3\2\2\2<\u0172"+
		"\3\2\2\2>\u0183\3\2\2\2@\u0185\3\2\2\2B\u0193\3\2\2\2D\u0196\3\2\2\2F"+
		"\u019a\3\2\2\2H\u01a0\3\2\2\2J\u01a2\3\2\2\2L\u01a6\3\2\2\2N\u01ad\3\2"+
		"\2\2P\u01b2\3\2\2\2R\u01c3\3\2\2\2T\u01d2\3\2\2\2V\u01d9\3\2\2\2X\u01db"+
		"\3\2\2\2Z\u01dd\3\2\2\2\\\u01e5\3\2\2\2^\u01e7\3\2\2\2`\u01e9\3\2\2\2"+
		"b\u01eb\3\2\2\2d\u01ed\3\2\2\2f\u01ef\3\2\2\2hj\5\4\3\2ih\3\2\2\2ij\3"+
		"\2\2\2jk\3\2\2\2kl\5\6\4\2l\3\3\2\2\2mn\7\3\2\2np\5b\62\2oq\5d\63\2po"+
		"\3\2\2\2qr\3\2\2\2rp\3\2\2\2rs\3\2\2\2s}\3\2\2\2tu\7\3\2\2uw\5b\62\2v"+
		"x\5d\63\2wv\3\2\2\2xy\3\2\2\2yw\3\2\2\2yz\3\2\2\2z|\3\2\2\2{t\3\2\2\2"+
		"|\177\3\2\2\2}{\3\2\2\2}~\3\2\2\2~\5\3\2\2\2\177}\3\2\2\2\u0080\u0081"+
		"\7\4\2\2\u0081\u0083\5b\62\2\u0082\u0084\5d\63\2\u0083\u0082\3\2\2\2\u0084"+
		"\u0085\3\2\2\2\u0085\u0083\3\2\2\2\u0085\u0086\3\2\2\2\u0086\u0093\3\2"+
		"\2\2\u0087\u008b\5\b\5\2\u0088\u008b\5\n\6\2\u0089\u008b\5&\24\2\u008a"+
		"\u0087\3\2\2\2\u008a\u0088\3\2\2\2\u008a\u0089\3\2\2\2\u008b\u008d\3\2"+
		"\2\2\u008c\u008e\5d\63\2\u008d\u008c\3\2\2\2\u008e\u008f\3\2\2\2\u008f"+
		"\u008d\3\2\2\2\u008f\u0090\3\2\2\2\u0090\u0092\3\2\2\2\u0091\u008a\3\2"+
		"\2\2\u0092\u0095\3\2\2\2\u0093\u0091\3\2\2\2\u0093\u0094\3\2\2\2\u0094"+
		"\u0096\3\2\2\2\u0095\u0093\3\2\2\2\u0096\u0097\7\5\2\2\u0097\7\3\2\2\2"+
		"\u0098\u0099\7\6\2\2\u0099\u009a\5R*\2\u009a\u009b\7\7\2\2\u009b\u009c"+
		"\5b\62\2\u009c\t\3\2\2\2\u009d\u009e\7\b\2\2\u009e\u009f\5b\62\2\u009f"+
		"\u00a1\7A\2\2\u00a0\u00a2\5\16\b\2\u00a1\u00a0\3\2\2\2\u00a1\u00a2\3\2"+
		"\2\2\u00a2\u00a3\3\2\2\2\u00a3\u00a6\7B\2\2\u00a4\u00a5\7\t\2\2\u00a5"+
		"\u00a7\5T+\2\u00a6\u00a4\3\2\2\2\u00a6\u00a7\3\2\2\2\u00a7\u00a9\3\2\2"+
		"\2\u00a8\u00aa\5d\63\2\u00a9\u00a8\3\2\2\2\u00aa\u00ab\3\2\2\2\u00ab\u00a9"+
		"\3\2\2\2\u00ab\u00ac\3\2\2\2\u00ac\u00ad\3\2\2\2\u00ad\u00ae\5\22\n\2"+
		"\u00ae\u00af\7\n\2\2\u00af\13\3\2\2\2\u00b0\u00b5\5*\26\2\u00b1\u00b2"+
		"\7\13\2\2\u00b2\u00b4\5*\26\2\u00b3\u00b1\3\2\2\2\u00b4\u00b7\3\2\2\2"+
		"\u00b5\u00b3\3\2\2\2\u00b5\u00b6\3\2\2\2\u00b6\r\3\2\2\2\u00b7\u00b5\3"+
		"\2\2\2\u00b8\u00bd\5\20\t\2\u00b9\u00ba\7\13\2\2\u00ba\u00bc\5\20\t\2"+
		"\u00bb\u00b9\3\2\2\2\u00bc\u00bf\3\2\2\2\u00bd\u00bb\3\2\2\2\u00bd\u00be"+
		"\3\2\2\2\u00be\17\3\2\2\2\u00bf\u00bd\3\2\2\2\u00c0\u00c1\5T+\2\u00c1"+
		"\u00c2\5b\62\2\u00c2\21\3\2\2\2\u00c3\u00c5\5\24\13\2\u00c4\u00c6\5d\63"+
		"\2\u00c5\u00c4\3\2\2\2\u00c6\u00c7\3\2\2\2\u00c7\u00c5\3\2\2\2\u00c7\u00c8"+
		"\3\2\2\2\u00c8\u00ca\3\2\2\2\u00c9\u00c3\3\2\2\2\u00ca\u00cd\3\2\2\2\u00cb"+
		"\u00c9\3\2\2\2\u00cb\u00cc\3\2\2\2\u00cc\23\3\2\2\2\u00cd\u00cb\3\2\2"+
		"\2\u00ce\u00d7\5\26\f\2\u00cf\u00d7\5,\27\2\u00d0\u00d7\5&\24\2\u00d1"+
		"\u00d7\5\"\22\2\u00d2\u00d7\5\30\r\2\u00d3\u00d7\5\36\20\2\u00d4\u00d7"+
		"\5\32\16\2\u00d5\u00d7\5\34\17\2\u00d6\u00ce\3\2\2\2\u00d6\u00cf\3\2\2"+
		"\2\u00d6\u00d0\3\2\2\2\u00d6\u00d1\3\2\2\2\u00d6\u00d2\3\2\2\2\u00d6\u00d3"+
		"\3\2\2\2\u00d6\u00d4\3\2\2\2\u00d6\u00d5\3\2\2\2\u00d7\25\3\2\2\2\u00d8"+
		"\u00dd\5L\'\2\u00d9\u00da\5@!\2\u00da\u00db\5F$\2\u00db\u00dd\3\2\2\2"+
		"\u00dc\u00d8\3\2\2\2\u00dc\u00d9\3\2\2\2\u00dd\27\3\2\2\2\u00de\u00e1"+
		"\5 \21\2\u00df\u00e1\5$\23\2\u00e0\u00de\3\2\2\2\u00e0\u00df\3\2\2\2\u00e1"+
		"\31\3\2\2\2\u00e2\u00e3\7\f\2\2\u00e3\33\3\2\2\2\u00e4\u00e5\7\r\2\2\u00e5"+
		"\35\3\2\2\2\u00e6\u00e8\7\16\2\2\u00e7\u00e9\5*\26\2\u00e8\u00e7\3\2\2"+
		"\2\u00e8\u00e9\3\2\2\2\u00e9\37\3\2\2\2\u00ea\u00eb\7\17\2\2\u00eb\u00ed"+
		"\5.\30\2\u00ec\u00ee\5d\63\2\u00ed\u00ec\3\2\2\2\u00ee\u00ef\3\2\2\2\u00ef"+
		"\u00ed\3\2\2\2\u00ef\u00f0\3\2\2\2\u00f0\u00f1\3\2\2\2\u00f1\u00f2\5\22"+
		"\n\2\u00f2\u00f3\7\20\2\2\u00f3!\3\2\2\2\u00f4\u00f5\7\21\2\2\u00f5\u00f6"+
		"\5.\30\2\u00f6\u00f8\7\22\2\2\u00f7\u00f9\5d\63\2\u00f8\u00f7\3\2\2\2"+
		"\u00f9\u00fa\3\2\2\2\u00fa\u00f8\3\2\2\2\u00fa\u00fb\3\2\2\2\u00fb\u00fc"+
		"\3\2\2\2\u00fc\u0109\5\22\n\2\u00fd\u00fe\7\23\2\2\u00fe\u00ff\5.\30\2"+
		"\u00ff\u0101\7\22\2\2\u0100\u0102\5d\63\2\u0101\u0100\3\2\2\2\u0102\u0103"+
		"\3\2\2\2\u0103\u0101\3\2\2\2\u0103\u0104\3\2\2\2\u0104\u0105\3\2\2\2\u0105"+
		"\u0106\5\22\n\2\u0106\u0108\3\2\2\2\u0107\u00fd\3\2\2\2\u0108\u010b\3"+
		"\2\2\2\u0109\u0107\3\2\2\2\u0109\u010a\3\2\2\2\u010a\u0114\3\2\2\2\u010b"+
		"\u0109\3\2\2\2\u010c\u010e\7\24\2\2\u010d\u010f\5d\63\2\u010e\u010d\3"+
		"\2\2\2\u010f\u0110\3\2\2\2\u0110\u010e\3\2\2\2\u0110\u0111\3\2\2\2\u0111"+
		"\u0112\3\2\2\2\u0112\u0113\5\22\n\2\u0113\u0115\3\2\2\2\u0114\u010c\3"+
		"\2\2\2\u0114\u0115\3\2\2\2\u0115\u0116\3\2\2\2\u0116\u0117\7\25\2\2\u0117"+
		"#\3\2\2\2\u0118\u0119\7\26\2\2\u0119\u011a\5T+\2\u011a\u011b\5b\62\2\u011b"+
		"\u011c\7\27\2\2\u011c\u011e\5*\26\2\u011d\u011f\5d\63\2\u011e\u011d\3"+
		"\2\2\2\u011f\u0120\3\2\2\2\u0120\u011e\3\2\2\2\u0120\u0121\3\2\2\2\u0121"+
		"\u0122\3\2\2\2\u0122\u0123\5\22\n\2\u0123\u0124\7\30\2\2\u0124%\3\2\2"+
		"\2\u0125\u0126\5T+\2\u0126\u012b\5(\25\2\u0127\u0128\7\13\2\2\u0128\u012a"+
		"\5(\25\2\u0129\u0127\3\2\2\2\u012a\u012d\3\2\2\2\u012b\u0129\3\2\2\2\u012b"+
		"\u012c\3\2\2\2\u012c\'\3\2\2\2\u012d\u012b\3\2\2\2\u012e\u0131\5b\62\2"+
		"\u012f\u0130\7\31\2\2\u0130\u0132\5*\26\2\u0131\u012f\3\2\2\2\u0131\u0132"+
		"\3\2\2\2\u0132)\3\2\2\2\u0133\u0136\5,\27\2\u0134\u0136\5.\30\2\u0135"+
		"\u0133\3\2\2\2\u0135\u0134\3\2\2\2\u0136+\3\2\2\2\u0137\u0138\5> \2\u0138"+
		"\u0139\5f\64\2\u0139\u013a\5*\26\2\u013a-\3\2\2\2\u013b\u013c\5\60\31"+
		"\2\u013c/\3\2\2\2\u013d\u013e\b\31\1\2\u013e\u013f\5\62\32\2\u013f\u0145"+
		"\3\2\2\2\u0140\u0141\f\4\2\2\u0141\u0142\7\66\2\2\u0142\u0144\5\62\32"+
		"\2\u0143\u0140\3\2\2\2\u0144\u0147\3\2\2\2\u0145\u0143\3\2\2\2\u0145\u0146"+
		"\3\2\2\2\u0146\61\3\2\2\2\u0147\u0145\3\2\2\2\u0148\u0149\b\32\1\2\u0149"+
		"\u014a\5\64\33\2\u014a\u0150\3\2\2\2\u014b\u014c\f\4\2\2\u014c\u014d\7"+
		"\65\2\2\u014d\u014f\5\64\33\2\u014e\u014b\3\2\2\2\u014f\u0152\3\2\2\2"+
		"\u0150\u014e\3\2\2\2\u0150\u0151\3\2\2\2\u0151\63\3\2\2\2\u0152\u0150"+
		"\3\2\2\2\u0153\u0154\b\33\1\2\u0154\u0155\5\66\34\2\u0155\u015b\3\2\2"+
		"\2\u0156\u0157\f\4\2\2\u0157\u0158\79\2\2\u0158\u015a\5\66\34\2\u0159"+
		"\u0156\3\2\2\2\u015a\u015d\3\2\2\2\u015b\u0159\3\2\2\2\u015b\u015c\3\2"+
		"\2\2\u015c\65\3\2\2\2\u015d\u015b\3\2\2\2\u015e\u015f\58\35\2\u015f\u0160"+
		"\78\2\2\u0160\u0161\58\35\2\u0161\u0164\3\2\2\2\u0162\u0164\58\35\2\u0163"+
		"\u015e\3\2\2\2\u0163\u0162\3\2\2\2\u0164\67\3\2\2\2\u0165\u0166\5:\36"+
		"\2\u01669\3\2\2\2\u0167\u0168\b\36\1\2\u0168\u0169\5<\37\2\u0169\u016f"+
		"\3\2\2\2\u016a\u016b\f\3\2\2\u016b\u016c\7\63\2\2\u016c\u016e\5<\37\2"+
		"\u016d\u016a\3\2\2\2\u016e\u0171\3\2\2\2\u016f\u016d\3\2\2\2\u016f\u0170"+
		"\3\2\2\2\u0170;\3\2\2\2\u0171\u016f\3\2\2\2\u0172\u0173\b\37\1\2\u0173"+
		"\u0174\5> \2\u0174\u017a\3\2\2\2\u0175\u0176\f\3\2\2\u0176\u0177\7\64"+
		"\2\2\u0177\u0179\5> \2\u0178\u0175\3\2\2\2\u0179\u017c\3\2\2\2\u017a\u0178"+
		"\3\2\2\2\u017a\u017b\3\2\2\2\u017b=\3\2\2\2\u017c\u017a\3\2\2\2\u017d"+
		"\u0184\5V,\2\u017e\u0184\5P)\2\u017f\u0180\7\67\2\2\u0180\u0184\5> \2"+
		"\u0181\u0184\5N(\2\u0182\u0184\5@!\2\u0183\u017d\3\2\2\2\u0183\u017e\3"+
		"\2\2\2\u0183\u017f\3\2\2\2\u0183\u0181\3\2\2\2\u0183\u0182\3\2\2\2\u0184"+
		"?\3\2\2\2\u0185\u0186\b!\1\2\u0186\u0187\5H%\2\u0187\u0190\3\2\2\2\u0188"+
		"\u0189\f\5\2\2\u0189\u018f\5B\"\2\u018a\u018b\f\4\2\2\u018b\u018f\5D#"+
		"\2\u018c\u018d\f\3\2\2\u018d\u018f\5F$\2\u018e\u0188\3\2\2\2\u018e\u018a"+
		"\3\2\2\2\u018e\u018c\3\2\2\2\u018f\u0192\3\2\2\2\u0190\u018e\3\2\2\2\u0190"+
		"\u0191\3\2\2\2\u0191A\3\2\2\2\u0192\u0190\3\2\2\2\u0193\u0194\7\32\2\2"+
		"\u0194\u0195\5b\62\2\u0195C\3\2\2\2\u0196\u0197\7\33\2\2\u0197\u0198\5"+
		"*\26\2\u0198\u0199\7\34\2\2\u0199E\3\2\2\2\u019a\u019b\7\32\2\2\u019b"+
		"\u019c\5L\'\2\u019cG\3\2\2\2\u019d\u01a1\5J&\2\u019e\u01a1\5b\62\2\u019f"+
		"\u01a1\5L\'\2\u01a0\u019d\3\2\2\2\u01a0\u019e\3\2\2\2\u01a0\u019f\3\2"+
		"\2\2\u01a1I\3\2\2\2\u01a2\u01a3\7A\2\2\u01a3\u01a4\5.\30\2\u01a4\u01a5"+
		"\7B\2\2\u01a5K\3\2\2\2\u01a6\u01a7\5b\62\2\u01a7\u01a9\7A\2\2\u01a8\u01aa"+
		"\5\f\7\2\u01a9\u01a8\3\2\2\2\u01a9\u01aa\3\2\2\2\u01aa\u01ab\3\2\2\2\u01ab"+
		"\u01ac\7B\2\2\u01acM\3\2\2\2\u01ad\u01ae\7A\2\2\u01ae\u01af\5T+\2\u01af"+
		"\u01b0\7B\2\2\u01b0\u01b1\5> \2\u01b1O\3\2\2\2\u01b2\u01b3\7\35\2\2\u01b3"+
		"\u01b4\5T+\2\u01b4\u01b6\7A\2\2\u01b5\u01b7\5\f\7\2\u01b6\u01b5\3\2\2"+
		"\2\u01b6\u01b7\3\2\2\2\u01b7\u01b8\3\2\2\2\u01b8\u01b9\7B\2\2\u01b9Q\3"+
		"\2\2\2\u01ba\u01c4\7\36\2\2\u01bb\u01c4\7\37\2\2\u01bc\u01c4\7 \2\2\u01bd"+
		"\u01c4\7!\2\2\u01be\u01bf\t\2\2\2\u01bf\u01c0\7A\2\2\u01c0\u01c1\5\\/"+
		"\2\u01c1\u01c2\7B\2\2\u01c2\u01c4\3\2\2\2\u01c3\u01ba\3\2\2\2\u01c3\u01bb"+
		"\3\2\2\2\u01c3\u01bc\3\2\2\2\u01c3\u01bd\3\2\2\2\u01c3\u01be\3\2\2\2\u01c4"+
		"S\3\2\2\2\u01c5\u01d3\7$\2\2\u01c6\u01d3\7%\2\2\u01c7\u01d3\7&\2\2\u01c8"+
		"\u01d3\7\'\2\2\u01c9\u01ca\7(\2\2\u01ca\u01cb\7)\2\2\u01cb\u01cc\5T+\2"+
		"\u01cc\u01cd\7*\2\2\u01cd\u01d3\3\2\2\2\u01ce\u01d3\7+\2\2\u01cf\u01d3"+
		"\7,\2\2\u01d0\u01d3\7-\2\2\u01d1\u01d3\7.\2\2\u01d2\u01c5\3\2\2\2\u01d2"+
		"\u01c6\3\2\2\2\u01d2\u01c7\3\2\2\2\u01d2\u01c8\3\2\2\2\u01d2\u01c9\3\2"+
		"\2\2\u01d2\u01ce\3\2\2\2\u01d2\u01cf\3\2\2\2\u01d2\u01d0\3\2\2\2\u01d2"+
		"\u01d1\3\2\2\2\u01d3U\3\2\2\2\u01d4\u01da\5^\60\2\u01d5\u01da\5X-\2\u01d6"+
		"\u01da\5\\/\2\u01d7\u01da\5Z.\2\u01d8\u01da\5`\61\2\u01d9\u01d4\3\2\2"+
		"\2\u01d9\u01d5\3\2\2\2\u01d9\u01d6\3\2\2\2\u01d9\u01d7\3\2\2\2\u01d9\u01d8"+
		"\3\2\2\2\u01daW\3\2\2\2\u01db\u01dc\7<\2\2\u01dcY\3\2\2\2\u01dd\u01de"+
		"\7A\2\2\u01de\u01df\5.\30\2\u01df\u01e0\7\13\2\2\u01e0\u01e1\5.\30\2\u01e1"+
		"\u01e2\7\13\2\2\u01e2\u01e3\5.\30\2\u01e3\u01e4\7B\2\2\u01e4[\3\2\2\2"+
		"\u01e5\u01e6\7;\2\2\u01e6]\3\2\2\2\u01e7\u01e8\7>\2\2\u01e8_\3\2\2\2\u01e9"+
		"\u01ea\7?\2\2\u01eaa\3\2\2\2\u01eb\u01ec\7@\2\2\u01ecc\3\2\2\2\u01ed\u01ee"+
		"\7:\2\2\u01eee\3\2\2\2\u01ef\u01f0\t\3\2\2\u01f0g\3\2\2\2.iry}\u0085\u008a"+
		"\u008f\u0093\u00a1\u00a6\u00ab\u00b5\u00bd\u00c7\u00cb\u00d6\u00dc\u00e0"+
		"\u00e8\u00ef\u00fa\u0103\u0109\u0110\u0114\u0120\u012b\u0131\u0135\u0145"+
		"\u0150\u015b\u0163\u016f\u017a\u0183\u018e\u0190\u01a0\u01a9\u01b6\u01c3"+
		"\u01d2\u01d9";
>>>>>>> Stashed changes
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}