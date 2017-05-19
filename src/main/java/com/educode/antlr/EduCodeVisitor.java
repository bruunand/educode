// Generated from C:/EduCode/EduCode-P4/src\EduCode.g4 by ANTLR 4.6
package com.educode.antlr;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link EduCodeParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface EduCodeVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link EduCodeParser#start}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStart(EduCodeParser.StartContext ctx);
	/**
	 * Visit a parse tree produced by {@link EduCodeParser#usings}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUsings(EduCodeParser.UsingsContext ctx);
	/**
	 * Visit a parse tree produced by {@link EduCodeParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(EduCodeParser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by {@link EduCodeParser#event_definition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEvent_definition(EduCodeParser.Event_definitionContext ctx);
	/**
	 * Visit a parse tree produced by {@link EduCodeParser#method_declaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethod_declaration(EduCodeParser.Method_declarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link EduCodeParser#argument_list}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArgument_list(EduCodeParser.Argument_listContext ctx);
	/**
	 * Visit a parse tree produced by {@link EduCodeParser#parameter_list}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParameter_list(EduCodeParser.Parameter_listContext ctx);
	/**
	 * Visit a parse tree produced by {@link EduCodeParser#parameter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParameter(EduCodeParser.ParameterContext ctx);
	/**
	 * Visit a parse tree produced by {@link EduCodeParser#statement_list}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement_list(EduCodeParser.Statement_listContext ctx);
	/**
	 * Visit a parse tree produced by {@link EduCodeParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement(EduCodeParser.StatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link EduCodeParser#call_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCall_statement(EduCodeParser.Call_statementContext ctx);
	/**
	 * Visit a parse tree produced by {@link EduCodeParser#iterative_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIterative_statement(EduCodeParser.Iterative_statementContext ctx);
	/**
	 * Visit a parse tree produced by {@link EduCodeParser#break_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBreak_statement(EduCodeParser.Break_statementContext ctx);
	/**
	 * Visit a parse tree produced by {@link EduCodeParser#continue_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitContinue_statement(EduCodeParser.Continue_statementContext ctx);
	/**
	 * Visit a parse tree produced by {@link EduCodeParser#return_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturn_statement(EduCodeParser.Return_statementContext ctx);
	/**
	 * Visit a parse tree produced by {@link EduCodeParser#repeat_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRepeat_statement(EduCodeParser.Repeat_statementContext ctx);
	/**
	 * Visit a parse tree produced by {@link EduCodeParser#if_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIf_statement(EduCodeParser.If_statementContext ctx);
	/**
	 * Visit a parse tree produced by {@link EduCodeParser#foreach_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForeach_statement(EduCodeParser.Foreach_statementContext ctx);
	/**
	 * Visit a parse tree produced by {@link EduCodeParser#variable_declaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariable_declaration(EduCodeParser.Variable_declarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link EduCodeParser#declarator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclarator(EduCodeParser.DeclaratorContext ctx);
	/**
	 * Visit a parse tree produced by {@link EduCodeParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression(EduCodeParser.ExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link EduCodeParser#assignment_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignment_expression(EduCodeParser.Assignment_expressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link EduCodeParser#logic_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLogic_expression(EduCodeParser.Logic_expressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link EduCodeParser#or_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOr_expression(EduCodeParser.Or_expressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link EduCodeParser#and_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAnd_expression(EduCodeParser.And_expressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link EduCodeParser#equality_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEquality_expression(EduCodeParser.Equality_expressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link EduCodeParser#relative_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRelative_expression(EduCodeParser.Relative_expressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link EduCodeParser#arithmetic_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArithmetic_expression(EduCodeParser.Arithmetic_expressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link EduCodeParser#additive_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAdditive_expression(EduCodeParser.Additive_expressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link EduCodeParser#multiplicative_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultiplicative_expression(EduCodeParser.Multiplicative_expressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link EduCodeParser#factor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFactor(EduCodeParser.FactorContext ctx);
	/**
	 * Visit a parse tree produced by {@link EduCodeParser#access}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAccess(EduCodeParser.AccessContext ctx);
	/**
	 * Visit a parse tree produced by {@link EduCodeParser#field_access}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitField_access(EduCodeParser.Field_accessContext ctx);
	/**
	 * Visit a parse tree produced by {@link EduCodeParser#element_access}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitElement_access(EduCodeParser.Element_accessContext ctx);
	/**
	 * Visit a parse tree produced by {@link EduCodeParser#method_access}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethod_access(EduCodeParser.Method_accessContext ctx);
	/**
	 * Visit a parse tree produced by {@link EduCodeParser#subfactor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSubfactor(EduCodeParser.SubfactorContext ctx);
	/**
	 * Visit a parse tree produced by {@link EduCodeParser#parenthesis_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParenthesis_expression(EduCodeParser.Parenthesis_expressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link EduCodeParser#method_call}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethod_call(EduCodeParser.Method_callContext ctx);
	/**
	 * Visit a parse tree produced by {@link EduCodeParser#type_cast}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitType_cast(EduCodeParser.Type_castContext ctx);
	/**
	 * Visit a parse tree produced by {@link EduCodeParser#object_instantiation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitObject_instantiation(EduCodeParser.Object_instantiationContext ctx);
	/**
	 * Visit a parse tree produced by {@link EduCodeParser#event_type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEvent_type(EduCodeParser.Event_typeContext ctx);
	/**
	 * Visit a parse tree produced by {@link EduCodeParser#data_type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitData_type(EduCodeParser.Data_typeContext ctx);
	/**
	 * Visit a parse tree produced by {@link EduCodeParser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLiteral(EduCodeParser.LiteralContext ctx);
	/**
	 * Visit a parse tree produced by {@link EduCodeParser#string_literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitString_literal(EduCodeParser.String_literalContext ctx);
	/**
	 * Visit a parse tree produced by {@link EduCodeParser#coordinate_literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCoordinate_literal(EduCodeParser.Coordinate_literalContext ctx);
	/**
	 * Visit a parse tree produced by {@link EduCodeParser#number_literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumber_literal(EduCodeParser.Number_literalContext ctx);
	/**
	 * Visit a parse tree produced by {@link EduCodeParser#bool_literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBool_literal(EduCodeParser.Bool_literalContext ctx);
	/**
	 * Visit a parse tree produced by {@link EduCodeParser#null_literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNull_literal(EduCodeParser.Null_literalContext ctx);
	/**
	 * Visit a parse tree produced by {@link EduCodeParser#identifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdentifier(EduCodeParser.IdentifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link EduCodeParser#end_of_line}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEnd_of_line(EduCodeParser.End_of_lineContext ctx);
}