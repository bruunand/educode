package com.educode.visitors;

import com.educode.antlr.EduCodeBaseVisitor;
import com.educode.antlr.EduCodeParser;
import com.educode.errorhandling.ErrorHandler;
import com.educode.events.EventTypeBase;
import com.educode.events.communication.ChatMessageEvent;
import com.educode.events.communication.EntityMessageReceivedEvent;
import com.educode.events.communication.StringMessageReceivedEvent;
import com.educode.events.entity.EntityDeathEvent;
import com.educode.events.entity.robot.RobotAttackedEvent;
import com.educode.events.entity.robot.RobotDeathEvent;
import com.educode.nodes.base.*;
import com.educode.nodes.expression.AdditionExpression;
import com.educode.nodes.expression.ArithmeticExpression;
import com.educode.nodes.expression.MultiplicationExpression;
import com.educode.nodes.expression.UnaryMinusNode;
import com.educode.nodes.expression.logic.*;
import com.educode.nodes.literal.*;
import com.educode.nodes.method.MethodDeclarationNode;
import com.educode.nodes.method.MethodInvocationNode;
import com.educode.nodes.method.ParameterNode;
import com.educode.nodes.referencing.ArrayReferencingNode;
import com.educode.nodes.referencing.IReference;
import com.educode.nodes.referencing.IdentifierReferencingNode;
import com.educode.nodes.referencing.StructReferencingNode;
import com.educode.nodes.statement.*;
import com.educode.nodes.statement.conditional.ConditionNode;
import com.educode.nodes.statement.conditional.IfNode;
import com.educode.nodes.statement.conditional.RepeatWhileNode;
import com.educode.nodes.ungrouped.*;
import com.educode.types.*;
import org.antlr.v4.runtime.ParserRuleContext;

import java.util.ArrayList;

/**
 * Created by Thomas Buhl on 10/05/2017.
 */
public class ASTBuilder extends EduCodeBaseVisitor<Node>
{
    private static int _currentLineNumber = 0;

    private static void updateLineNumber(ParserRuleContext fromCtx)
    {
        ASTBuilder._currentLineNumber = fromCtx.getStart().getLine();
    }

    public static int getLineNumber()
    {
        return ASTBuilder._currentLineNumber;
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

    private AssignmentOperator getAssignmentOperator(String operator)
    {
        switch (operator)
        {
            case "=":
                return AssignmentOperator.None;
            case "+=":
                return AssignmentOperator.Addition;
            case "-=":
                return AssignmentOperator.Subtraction;
            case "/=":
                return AssignmentOperator.Division;
            case "*=":
                return AssignmentOperator.Multiplication;
            default:
                return AssignmentOperator.Error;
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

    private Type getType(EduCodeParser.Data_typeContext ctx)
    {
        if (ctx.data_type() != null)
            return new Type(getType(ctx.data_type()));
        else
        {
            switch (ctx.getText())
            {
                case "string":
                    return Type.StringType;
                case "bool":
                    return Type.BoolType;
                case "number":
                    return Type.NumberType;
                case "Entity":
                    return Type.EntityType;
                case "coordinates":
                    return Type.CoordinatesType;
                case "Item":
                    return Type.ItemType;
            }
        }

        return Type.VoidType;
    }


    @Override
    public Node visitStart(EduCodeParser.StartContext ctx)
    {
        updateLineNumber(ctx);

        return new StartNode(ctx.ulist!=null ? visit(ctx.ulist) : new UsingsNode(), visit(ctx.pr));
    }

    @Override
    public Node visitUsings(EduCodeParser.UsingsContext ctx)
    {
        updateLineNumber(ctx);
        ArrayList<Node> Nodes = new ArrayList<>();

        for (EduCodeParser.IdentifierContext i: ctx.id)
            Nodes.add(new ImportNode(visitIdentifier(i).toString()));

        return new UsingsNode(Nodes);
    }

    @Override
    public Node visitProgram(EduCodeParser.ProgramContext ctx)
    {
        updateLineNumber(ctx);

        ArrayList<Node> nodes = new ArrayList<>();

        // Add global variables
        for (EduCodeParser.Variable_declarationContext v : ctx.vl)
            nodes.add(visit(v));

        // Add event subscriptions
        for (EduCodeParser.Event_definitionContext e : ctx.el)
            nodes.add(visit(e));

        // Add method declarations
        for (EduCodeParser.Method_declarationContext m : ctx.ml)
            nodes.add(visit(m));

        return new ProgramNode(nodes, (IReference) visit(ctx.id));
    }

    @Override
    public Node visitEvent_definition(EduCodeParser.Event_definitionContext ctx)
    {
        return new EventDefinitionNode((IReference) visit(ctx.id), getEventType(ctx.event));
    }

    @Override
    public Node visitMethod_declaration(EduCodeParser.Method_declarationContext ctx)
    {
        updateLineNumber(ctx);

        Type returnType = Type.VoidType;
        if (ctx.type != null)
            returnType = getType(ctx.type);

        if (ctx.params != null)
            return new MethodDeclarationNode(visit(ctx.params), visit(ctx.body), (IReference) visit(ctx.id), returnType);
        else
            return new MethodDeclarationNode(null, visit(ctx.body), (IReference) visit(ctx.id), returnType);
    }

    @Override
    public Node visitArgument_list(EduCodeParser.Argument_listContext ctx)
    {
        updateLineNumber(ctx);

        ListNode node = new ListNode();
        for (EduCodeParser.ExpressionContext e : ctx.exprs)
            node.addChild(visit(e));

        return node;
    }

    @Override
    public Node visitParameter_list(EduCodeParser.Parameter_listContext ctx)
    {
        updateLineNumber(ctx);

        ListNode parameterCollection = new ListNode();

        for (EduCodeParser.ParameterContext p : ctx.params)
            parameterCollection.addChild(visit(p));

        return parameterCollection;
    }

    @Override
    public Node visitParameter(EduCodeParser.ParameterContext ctx)
    {
        updateLineNumber(ctx);

        return new ParameterNode((IReference) visit(ctx.id), getType(ctx.type));
    }

    @Override
    public Node visitStatement_list(EduCodeParser.Statement_listContext ctx)
    {
        updateLineNumber(ctx);

        ArrayList<Node> childStatements = new ArrayList<>();

        for (EduCodeParser.StatementContext statement : ctx.statements)
        {
            Node visitResult = visit(statement);

            // Some nodes (like variable declaration) will return a collection of nodes
            // Instead of adding the ListNode, we will add the contained nodes
            // We don't do this for NaryNode because some nodes (If-Node) can't be split up
            if (visitResult instanceof ListNode)
                childStatements.addAll(((NaryNode)visitResult).getChildren());
            else
                childStatements.add(visitResult);
        }

        return new BlockNode(childStatements);
    }

    @Override
    public Node visitStatement(EduCodeParser.StatementContext ctx)
    {
        updateLineNumber(ctx);

        return visit(ctx.getChild(0));
    }

    @Override
    public Node visitCall_statement(EduCodeParser.Call_statementContext ctx)
    {
        updateLineNumber(ctx);

        if (ctx.method_call() != null)
            return visit(ctx.method_call());
        else
            return new StructReferencingNode(visit(ctx.access()), visit(ctx.method_access()));
    }

    @Override
    public Node visitIterative_statement(EduCodeParser.Iterative_statementContext ctx)
    {
        updateLineNumber(ctx);

        return visit(ctx.getChild(0));
    }

    @Override
    public Node visitBreak_statement(EduCodeParser.Break_statementContext ctx)
    {
        updateLineNumber(ctx);

        return new BreakNode();
    }

    @Override
    public Node visitContinue_statement(EduCodeParser.Continue_statementContext ctx)
    {
        updateLineNumber(ctx);

        return new ContinueNode();
    }

    @Override
    public Node visitReturn_statement(EduCodeParser.Return_statementContext ctx)
    {
        updateLineNumber(ctx);

        if (ctx.expr != null)
            return new ReturnNode(visit(ctx.expr));
        else
            return new ReturnNode();
    }

    @Override
    public Node visitRepeat_statement(EduCodeParser.Repeat_statementContext ctx)
    {
        updateLineNumber(ctx);

        return new RepeatWhileNode(new ConditionNode(visit(ctx.predicate), visit(ctx.body)));
    }

    @Override
    public Node visitIf_statement(EduCodeParser.If_statementContext ctx)
    {
        updateLineNumber(ctx);

        IfNode ifNode = new IfNode();
        // Add a condition node for each predicate-body pair
        for (int i = 0; i < ctx.bodies.size(); i++)
            ifNode.addChild(new ConditionNode(visit(ctx.predicates.get(i)), visit(ctx.bodies.get(i))));

        // If there is an else block, add it finally without a ConditionNode
        if (ctx.elseBody != null)
            ifNode.addChild(visit(ctx.elseBody));

        return ifNode;
    }

    @Override
    public Node visitForeach_statement(EduCodeParser.Foreach_statementContext ctx)
    {        return new ForEachNode((IReference) visit(ctx.id), getType(ctx.type), visit(ctx.expr), visit(ctx.body));
    }

    @Override
    public Node visitVariable_declaration(EduCodeParser.Variable_declarationContext ctx)
    {
        updateLineNumber(ctx);

        ArrayList<Node> nodes = new ArrayList<>();

        Node current;

        for (EduCodeParser.DeclaratorContext decl: ctx.decls)
        {
            current = visit(decl);

            if (current instanceof AssignmentNode)
                nodes.add( new VariableDeclarationNode((AssignmentNode)current, getType(ctx.type)));
            else if (current instanceof IReference)
                nodes.add( new VariableDeclarationNode((IReference)current, getType(ctx.type)));
            else
                System.out.println("VarDeclError at line " + ctx.getStart().getLine());
        }

        return new ListNode(nodes);
    }

    @Override
    public Node visitDeclarator(EduCodeParser.DeclaratorContext ctx)
    {
        if (ctx.expr != null)
            return new AssignmentNode((IReference) visit(ctx.id), visit(ctx.expr));
        else
            return visit(ctx.id);
    }

    @Override
    public Node visitExpression(EduCodeParser.ExpressionContext ctx)
    {
        updateLineNumber(ctx);

        return super.visit(ctx.getChild(0));//visit(ctx.getChild(0));
    }

    @Override
    public Node visitAssignment_expression(EduCodeParser.Assignment_expressionContext ctx)
    {
        updateLineNumber(ctx);

        if (ctx.rhs != null) // Assign to expression
        {
            Node left  = visit(ctx.lhs);
            Node right = visit(ctx.rhs);

            AssignmentOperator operator = getAssignmentOperator(ctx.op.getText());

            switch (operator.getKind())
            {
                case AssignmentOperator.NONE:
                    return new AssignmentNode((IReference) left, right);
                case AssignmentOperator.ADDITION:
                    return new AssignmentNode((IReference) left, new AdditionExpression(ArithmeticOperator.Addition, left, right));
                case AssignmentOperator.SUBTRACTION:
                    return new AssignmentNode((IReference) left, new AdditionExpression(ArithmeticOperator.Subtraction, left, right));
                case AssignmentOperator.MULTIPLICATION:
                    return new AssignmentNode((IReference) left, new MultiplicationExpression(ArithmeticOperator.Multiplication, left, right));
                case AssignmentOperator.DIVISION:
                    return new AssignmentNode((IReference) left, new MultiplicationExpression(ArithmeticOperator.Division, left, right));
                default:
                    System.out.println("Unknown assignment operator at line " + ctx.getStart().getLine());
            }
        }

        System.out.println("AssignError at line " + ctx.getStart().getLine());
        System.out.println(ctx.getText());

        return null;
    }

    @Override
    public Node visitLogic_expression(EduCodeParser.Logic_expressionContext ctx)
    {
        updateLineNumber(ctx);

        return visit(ctx.getChild(0));//visit(ctx.getChild(0));
    }

    @Override
    public Node visitOr_expression(EduCodeParser.Or_expressionContext ctx)
    {
        updateLineNumber(ctx);

        if (ctx.getChildCount() == 1)
            return visit(ctx.right);
        else if (ctx.getChildCount() == 3)
            return new OrExpressionNode(visit(ctx.left), visit(ctx.right));

        System.out.println("Unexpected child count in or-expression " + ctx.getStart().getLine());

        return null;
    }

    @Override
    public Node visitAnd_expression(EduCodeParser.And_expressionContext ctx)
    {
        updateLineNumber(ctx);

        if (ctx.getChildCount() == 1)
            return visit(ctx.right);
        else if (ctx.getChildCount() == 3)
            return new AndExpressionNode(visit(ctx.left), visit(ctx.right));

        System.out.println("Unexpected child count in and-expression " + ctx.getStart().getLine());

        return null;
    }

    @Override
    public Node visitEquality_expression(EduCodeParser.Equality_expressionContext ctx)
    {
        if (ctx.getChildCount() == 1)
            return visit(ctx.right);
        else if (ctx.getChildCount() == 3)
            return new EqualExpressionNode(getLogicalOperator(ctx.op.getText()), visit(ctx.left), visit(ctx.right));

        System.out.println("Unexpected child count in equals-expression " + ctx.getStart().getLine());

        return null;
    }

    @Override
    public Node visitRelative_expression(EduCodeParser.Relative_expressionContext ctx)
    {
        updateLineNumber(ctx);

        if (ctx.getChildCount() == 1)
            return visit(ctx.right);
        else if (ctx.getChildCount() == 3)
            return new RelativeExpressionNode(getLogicalOperator(ctx.op.getText()), visit(ctx.left), visit(ctx.right));

        System.out.println("Unexpected child count in relative-expression " + ctx.getStart().getLine());

        return null;
    }

    @Override
    public Node visitArithmetic_expression(EduCodeParser.Arithmetic_expressionContext ctx)
    {
        updateLineNumber(ctx);

        return visit(ctx.getChild(0));
    }

    @Override
    public Node visitAdditive_expression(EduCodeParser.Additive_expressionContext ctx)
    {
        updateLineNumber(ctx);

        if (ctx.getChildCount() == 1)
            return visit(ctx.right);
        else if (ctx.getChildCount() == 3)
            return new AdditionExpression(getArithmeticOperator(ctx.op.getText()), visit(ctx.left), visit(ctx.right));

        System.out.println("AddError at line " + ctx.getStart().getLine());

        return null;
    }

    @Override
    public Node visitMultiplicative_expression(EduCodeParser.Multiplicative_expressionContext ctx)
    {
        updateLineNumber(ctx);

        if (ctx.getChildCount() == 1)
            return visit(ctx.right);
        else if (ctx.getChildCount() == 3)
            return new MultiplicationExpression(getArithmeticOperator(ctx.op.getText()), visit(ctx.left), visit(ctx.right));

        System.out.println("MultError at line " + ctx.getStart().getLine());

        return null;
    }

    @Override
    public Node visitFactor(EduCodeParser.FactorContext ctx)
    {
        updateLineNumber(ctx);

        if (ctx.literal() != null)
            return visit(ctx.literal());
        else if (ctx.access() != null)
            return visit(ctx.access());
        else if (ctx.factor() != null)
        {
            if (ctx.op.getText().equals("not"))
                return new NegateNode(visit(ctx.factor()));
            else if (ctx.op.getText().equals("-"))
                return  new UnaryMinusNode(visit(ctx.factor()));
        }
        else if (ctx.type_cast() != null)
            return visit(ctx.type_cast());
        else if (ctx.object_instantiation() != null)
            return visit(ctx.object_instantiation());

        System.out.println("FactError at line " + ctx.getStart().getLine());

        return null;
    }

    @Override
    public Node visitAccess(EduCodeParser.AccessContext ctx)
    {
        updateLineNumber(ctx);

        if (ctx.field_access() != null)
            return new StructReferencingNode(visit(ctx.rec), visit(ctx.field_access()));
        else if (ctx.element_access() != null)
            return new ArrayReferencingNode(visit(ctx.rec), visit(ctx.element_access()));
        else if (ctx.method_access() != null)
            return new StructReferencingNode(visit(ctx.rec), visit(ctx.method_access()));
        else if (ctx.sub != null)
            return visit(ctx.sub);

        System.out.println("AccessError at line " + ctx.getStart().getLine());
        return null;
    }

    @Override
    public Node visitField_access(EduCodeParser.Field_accessContext ctx)
    {
        updateLineNumber(ctx);

        return visit(ctx.id);
    }

    @Override
    public Node visitElement_access(EduCodeParser.Element_accessContext ctx)
    {
        updateLineNumber(ctx);

        return visit(ctx.index);
    }

    @Override
    public Node visitMethod_access(EduCodeParser.Method_accessContext ctx)
    {
        updateLineNumber(ctx);

        return visit(ctx.method);
    }

    @Override
    public Node visitSubfactor(EduCodeParser.SubfactorContext ctx)
    {
        updateLineNumber(ctx);

        return visit(ctx.getChild(0));
    }

    @Override
    public Node visitParenthesis_expression(EduCodeParser.Parenthesis_expressionContext ctx)
    {
        updateLineNumber(ctx);

        return visit(ctx.content);
    }

    @Override
    public Node visitMethod_call(EduCodeParser.Method_callContext ctx)
    {
        updateLineNumber(ctx);

        if (ctx.args != null)
            return new MethodInvocationNode((IReference) visit(ctx.id), visit(ctx.args));
        else
            return new MethodInvocationNode((IReference) visit(ctx.id), null);
    }

    @Override
    public Node visitType_cast(EduCodeParser.Type_castContext ctx)
    {
        updateLineNumber(ctx);

        return new TypeCastNode(getType(ctx.type), visit(ctx.fac));
    }

    @Override
    public Node visitObject_instantiation(EduCodeParser.Object_instantiationContext ctx)
    {
        updateLineNumber(ctx);
        Type classType = getType(ctx.type);

        if (ctx.args != null)
            return new ObjectInstantiationNode(visit(ctx.args), classType);
        else
            return new ObjectInstantiationNode(null, classType);
    }

    @Override
    public Node visitEvent_type(EduCodeParser.Event_typeContext ctx)
    {
        return null;
    }

    @Override
    public Node visitData_type(EduCodeParser.Data_typeContext ctx)
    {
        return null;
    }

    @Override
    public Node visitLiteral(EduCodeParser.LiteralContext ctx)
    {
        updateLineNumber(ctx);

        return visit(ctx.getChild(0));
    }

    @Override
    public Node visitString_literal(EduCodeParser.String_literalContext ctx)
    {
        updateLineNumber(ctx);

        return new StringLiteralNode(ctx.STRING_LITERAL().getText());
    }

    @Override
    public Node visitCoordinate_literal(EduCodeParser.Coordinate_literalContext ctx)
    {
        updateLineNumber(ctx);

        return new CoordinatesLiteralNode(visit(ctx.x), visit(ctx.y), visit(ctx.z));
    }

    @Override
    public Node visitNumber_literal(EduCodeParser.Number_literalContext ctx)
    {
        updateLineNumber(ctx);

        return new NumberLiteralNode(Float.parseFloat(ctx.NUMBER_LITERAL().getText()));
    }

    @Override
    public Node visitBool_literal(EduCodeParser.Bool_literalContext ctx)
    {
        updateLineNumber(ctx);

        return new BoolLiteralNode(ctx.BOOL_LITERAL().getText().equals("true"));
    }

    @Override
    public Node visitNull_literal(EduCodeParser.Null_literalContext ctx)
    {
        updateLineNumber(ctx);

        return new NullLiteralNode();
    }

    @Override
    public Node visitIdentifier(EduCodeParser.IdentifierContext ctx)
    {
        updateLineNumber(ctx);

        return new IdentifierReferencingNode(ctx.IDENTIFIER().getText());
    }

    @Override
    public Node visitEnd_of_line(EduCodeParser.End_of_lineContext ctx)
    {
        return null;
    }
}
