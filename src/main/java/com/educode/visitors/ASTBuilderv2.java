package com.educode.visitors;

import com.educode.antlr.EduCodeBaseVisitor;
import com.educode.antlr.EduCodeParser;
import com.educode.events.EventTypeBase;
import com.educode.events.communication.ChatMessageEvent;
import com.educode.events.communication.EntityMessageReceivedEvent;
import com.educode.events.communication.StringMessageReceivedEvent;
import com.educode.events.entity.EntityDeathEvent;
import com.educode.events.entity.robot.RobotAttackedEvent;
import com.educode.events.entity.robot.RobotDeathEvent;
import com.educode.nodes.base.*;
import com.educode.nodes.literal.*;
import com.educode.nodes.ungrouped.*;
import com.educode.types.*;
import org.antlr.v4.runtime.ParserRuleContext;

/**
 * Created by Thomas Buhl on 10/05/2017.
 */
public class ASTBuilderv2 extends EduCodeBaseVisitor<Node> {
    private static int _currentLineNumber = 0;

    private static void updateLineNumber(ParserRuleContext fromCtx)
    {
        ASTBuilderv2._currentLineNumber = fromCtx.getStart().getLine();
        // ASTBuilderv2._currentCharPosition = fromCtx.getStart().getCharPositionInLine();
    }

    public static int getLineNumber()
    {
        return ASTBuilderv2._currentLineNumber;
    }

    private LogicalOperator getLogicalOperator(String operator)
    {
        switch (operator)
        {
            case "equals":
                return LogicalOperator.Equals;
            case "not equals":
                return LogicalOperator.NotEquals;
            case "less than":
                return LogicalOperator.LessThan;
            case "less than or equals":
                return LogicalOperator.LessThanOrEquals;
            case "greater than":
                return LogicalOperator.GreaterThan;
            case "greater than or equals":
                return LogicalOperator.GreaterThanOrEquals;
            default:
                return LogicalOperator.Error;
        }
    }

    private ArithmeticOperator getArithmeticOperator(String operator)
    {
        switch (operator)
        {
            case "+":
                return ArithmeticOperator.Addition;
            case "-":
                return ArithmeticOperator.Subtraction;
            case "/":
                return ArithmeticOperator.Division;
            case "*":
                return ArithmeticOperator.Multiplication;
            case "modulo":
                return ArithmeticOperator.Modulo;
            default:
                return ArithmeticOperator.Error;
        }
    }


    private EventTypeBase getEventType(EduCodeParser.Event_typeContext ctx)
    {
        switch (ctx.getChild(0).getText())
        {
            case "robotDeath":
                return new RobotDeathEvent();
            case "robotAttacked":
                return new RobotAttackedEvent();
            case "entityDeath":
                return new EntityDeathEvent();
            case "chatMessage":
                return new ChatMessageEvent();
            case "stringMessageReceived":
                return new StringMessageReceivedEvent((NumberLiteralNode) visit(ctx.number_literal()));
            case "entityMessageReceived":
                return new EntityMessageReceivedEvent((NumberLiteralNode) visit(ctx.number_literal()));
        }

        return null;
    }


    @Override
    public Node visitStart(EduCodeParser.StartContext ctx) {
        updateLineNumber(ctx);

        return new StartNode(visit(ctx.ulist), visit(ctx.pr));
    }

    @Override
    public Node visitUsings(EduCodeParser.UsingsContext ctx) {

        Nodes
        return new UsingsNode();
    }

    @Override
    public Node visitProgram(EduCodeParser.ProgramContext ctx) {
        return super.visitProgram(ctx);
    }

    @Override
    public Node visitEvent_definition(EduCodeParser.Event_definitionContext ctx) {
        return super.visitEvent_definition(ctx);
    }

    @Override
    public Node visitMethod_declaration(EduCodeParser.Method_declarationContext ctx) {
        return super.visitMethod_declaration(ctx);
    }

    @Override
    public Node visitArgument_list(EduCodeParser.Argument_listContext ctx) {
        return super.visitArgument_list(ctx);
    }

    @Override
    public Node visitParameter_list(EduCodeParser.Parameter_listContext ctx) {
        return super.visitParameter_list(ctx);
    }

    @Override
    public Node visitParameter(EduCodeParser.ParameterContext ctx) {
        return super.visitParameter(ctx);
    }

    @Override
    public Node visitStatement_list(EduCodeParser.Statement_listContext ctx) {
        return super.visitStatement_list(ctx);
    }

    @Override
    public Node visitStatement(EduCodeParser.StatementContext ctx) {
        return super.visitStatement(ctx);
    }

    @Override
    public Node visitIterative_statement(EduCodeParser.Iterative_statementContext ctx) {
        return super.visitIterative_statement(ctx);
    }

    @Override
    public Node visitBreak_statement(EduCodeParser.Break_statementContext ctx) {
        return super.visitBreak_statement(ctx);
    }

    @Override
    public Node visitContinue_statement(EduCodeParser.Continue_statementContext ctx) {
        return super.visitContinue_statement(ctx);
    }

    @Override
    public Node visitReturn_statement(EduCodeParser.Return_statementContext ctx) {
        return super.visitReturn_statement(ctx);
    }

    @Override
    public Node visitRepeat_statement(EduCodeParser.Repeat_statementContext ctx) {
        return super.visitRepeat_statement(ctx);
    }

    @Override
    public Node visitIf_statement(EduCodeParser.If_statementContext ctx) {
        return super.visitIf_statement(ctx);
    }

    @Override
    public Node visitForeach_statement(EduCodeParser.Foreach_statementContext ctx) {
        return super.visitForeach_statement(ctx);
    }

    @Override
    public Node visitVariable_declaration(EduCodeParser.Variable_declarationContext ctx) {
        return super.visitVariable_declaration(ctx);
    }

    @Override
    public Node visitDeclarator(EduCodeParser.DeclaratorContext ctx) {
        return super.visitDeclarator(ctx);
    }

    @Override
    public Node visitExpression(EduCodeParser.ExpressionContext ctx) {
        return super.visitExpression(ctx);
    }

    @Override
    public Node visitAssignment_expression(EduCodeParser.Assignment_expressionContext ctx) {
        return super.visitAssignment_expression(ctx);
    }

    @Override
    public Node visitLogic_expression(EduCodeParser.Logic_expressionContext ctx) {
        return super.visitLogic_expression(ctx);
    }

    @Override
    public Node visitOr_expression(EduCodeParser.Or_expressionContext ctx) {
        return super.visitOr_expression(ctx);
    }

    @Override
    public Node visitAnd_expression(EduCodeParser.And_expressionContext ctx) {
        return super.visitAnd_expression(ctx);
    }

    @Override
    public Node visitEquality_expression(EduCodeParser.Equality_expressionContext ctx) {
        return super.visitEquality_expression(ctx);
    }

    @Override
    public Node visitRelative_expression(EduCodeParser.Relative_expressionContext ctx) {
        return super.visitRelative_expression(ctx);
    }

    @Override
    public Node visitArithmetic_expression(EduCodeParser.Arithmetic_expressionContext ctx) {
        return super.visitArithmetic_expression(ctx);
    }

    @Override
    public Node visitAdditive_expression(EduCodeParser.Additive_expressionContext ctx) {
        return super.visitAdditive_expression(ctx);
    }

    @Override
    public Node visitMultiplicative_expression(EduCodeParser.Multiplicative_expressionContext ctx) {
        return super.visitMultiplicative_expression(ctx);
    }

    @Override
    public Node visitFactor(EduCodeParser.FactorContext ctx) {
        return super.visitFactor(ctx);
    }

    @Override
    public Node visitAccess(EduCodeParser.AccessContext ctx) {
        return super.visitAccess(ctx);
    }

    @Override
    public Node visitField_access(EduCodeParser.Field_accessContext ctx) {
        return super.visitField_access(ctx);
    }

    @Override
    public Node visitElement_access(EduCodeParser.Element_accessContext ctx) {
        return super.visitElement_access(ctx);
    }

    @Override
    public Node visitMethod_access(EduCodeParser.Method_accessContext ctx) {
        return super.visitMethod_access(ctx);
    }

    @Override
    public Node visitSubfactor(EduCodeParser.SubfactorContext ctx) {
        return super.visitSubfactor(ctx);
    }

    @Override
    public Node visitParenthesis_expression(EduCodeParser.Parenthesis_expressionContext ctx) {
        return super.visitParenthesis_expression(ctx);
    }

    @Override
    public Node visitMethod_call(EduCodeParser.Method_callContext ctx) {
        return super.visitMethod_call(ctx);
    }

    @Override
    public Node visitType_cast(EduCodeParser.Type_castContext ctx) {
        return super.visitType_cast(ctx);
    }

    @Override
    public Node visitObject_instantiation(EduCodeParser.Object_instantiationContext ctx) {
        return super.visitObject_instantiation(ctx);
    }

    @Override
    public Node visitEvent_type(EduCodeParser.Event_typeContext ctx) {
        return super.visitEvent_type(ctx);
    }

    @Override
    public Node visitData_type(EduCodeParser.Data_typeContext ctx) {
        return super.visitData_type(ctx);
    }

    @Override
    public Node visitLiteral(EduCodeParser.LiteralContext ctx) {
        return super.visitLiteral(ctx);
    }

    @Override
    public Node visitString_literal(EduCodeParser.String_literalContext ctx) {
        return super.visitString_literal(ctx);
    }

    @Override
    public Node visitCoordinate_literal(EduCodeParser.Coordinate_literalContext ctx) {
        return super.visitCoordinate_literal(ctx);
    }

    @Override
    public Node visitNumber_literal(EduCodeParser.Number_literalContext ctx) {
        return super.visitNumber_literal(ctx);
    }

    @Override
    public Node visitBool_literal(EduCodeParser.Bool_literalContext ctx) {
        return super.visitBool_literal(ctx);
    }

    @Override
    public Node visitNull_literal(EduCodeParser.Null_literalContext ctx) {
        return super.visitNull_literal(ctx);
    }

    @Override
    public Node visitIdentifier(EduCodeParser.IdentifierContext ctx) {
        return super.visitIdentifier(ctx);
    }

    @Override
    public Node visitEnd_of_line(EduCodeParser.End_of_lineContext ctx) {
        return super.visitEnd_of_line(ctx);
    }
}
