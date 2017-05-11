package com.educode.visitors;

import com.educode.antlr.EduCodeBaseVisitor;
import com.educode.antlr.EduCodeParser;
import com.educode.events.*;
import com.educode.events.communication.ChatMessageEvent;
import com.educode.events.communication.EntityMessageReceivedEvent;
import com.educode.events.communication.StringMessageReceivedEvent;
import com.educode.events.entity.EntityDeathEvent;
import com.educode.events.entity.robot.RobotAttackedEvent;
import com.educode.events.entity.robot.RobotDeathEvent;
import com.educode.nodes.base.ListNode;
import com.educode.nodes.base.NaryNode;
import com.educode.nodes.base.Node;
import com.educode.nodes.expression.AdditionExpression;
import com.educode.nodes.expression.MultiplicationExpression;
import com.educode.nodes.expression.logic.*;
import com.educode.nodes.literal.*;
import com.educode.nodes.method.MethodDeclarationNode;
import com.educode.nodes.method.MethodInvocationNode;
import com.educode.nodes.method.ParameterNode;
import com.educode.nodes.referencing.ArrayReferencingNode;
import com.educode.nodes.referencing.IReference;
import com.educode.nodes.referencing.IdentifierReferencingNode;
import com.educode.nodes.referencing.StructReferencingNode;
import com.educode.nodes.statement.AssignmentNode;
import com.educode.nodes.statement.ForEachNode;
import com.educode.nodes.statement.ReturnNode;
import com.educode.nodes.statement.VariableDeclarationNode;
import com.educode.nodes.statement.conditional.ConditionNode;
import com.educode.nodes.statement.conditional.IfNode;
import com.educode.nodes.statement.conditional.RepeatWhileNode;
import com.educode.nodes.ungrouped.*;
import com.educode.types.ArithmeticOperator;
import com.educode.types.LogicalOperator;
import com.educode.types.Type;
import org.antlr.v4.runtime.ParserRuleContext;

import java.util.ArrayList;

/**
 * Created by zen on 3/8/17.
 */
public class ASTBuilder extends EduCodeBaseVisitor<Node>
{
    private static int _currentLineNumber = 0;

    private static void updateLineNumber(ParserRuleContext fromCtx)
    {
        ASTBuilder._currentLineNumber = fromCtx.getStart().getLine();
        // ASTBuilder._currentCharPosition = fromCtx.getStart().getCharPositionInLine();
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

    private EventTypeBase getEventType(EduCodeParser.Event_typeContext ctx)
    {
        switch (ctx.type.getText())
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
                return new StringMessageReceivedEvent((NumberLiteralNode) visit(ctx.param));
            case "entityMessageReceived":
                return new EntityMessageReceivedEvent((NumberLiteralNode) visit(ctx.param));
        }

        return null;
    }

    private Type getType(EduCodeParser.Data_typeContext ctx)
    {
        if (ctx.childType != null)
            return new Type(getType(ctx.childType));
        else
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
                case "Coordinates":
                    return Type.CoordinatesType;
                case "Item":
                    return Type.ItemType;
            }
        return Type.VoidType;
    }

    @Override
    public Node visitObject_instantiation(EduCodeParser.Object_instantiationContext ctx)
    {
        Type classType = getType(ctx.data_type());

        if (ctx.args != null)
            return new ObjectInstantiationNode(visit(ctx.args), classType);
        else
            return new ObjectInstantiationNode(null, classType);
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
    public Node visitStatement(EduCodeParser.StatementContext ctx)
    {
        updateLineNumber(ctx);

        return super.visitStatement(ctx); // Will pass to an appropriate statement.
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

        // If there is an else block, skip the last block
        // There is an else block if there are fewer logical expressions than statements
        boolean hasElseBlock = ctx.elseBody != null;
        for (int i = 0; i < (hasElseBlock ? ctx.bodies.size() - 1 : ctx.bodies.size()); i++)
            ifNode.addChild(new ConditionNode(visit(ctx.predicates.get(i)), visit(ctx.bodies.get(i))));

        // If there is an else block, add it finally without a ConditionNode
        if (hasElseBlock)
            ifNode.addChild(visit(ctx.elseBody));

        return ifNode;
    }

    @Override
    public Node visitForeach_statement(EduCodeParser.Foreach_statementContext ctx)
    {
        return new ForEachNode((IReference) visit(ctx.id), getType(ctx.type), visit(ctx.expr), visit(ctx.body));
    }

    @Override
    public Node visitExpression(EduCodeParser.ExpressionContext ctx)
    {
        updateLineNumber(ctx);

        return super.visitExpression(ctx);
    }

    @Override
    public Node visitLogic_expression(EduCodeParser.Logic_expressionContext ctx)
    {
        updateLineNumber(ctx);

        return visit(ctx.or);
    }

    @Override
    public Node visitOr_expression(EduCodeParser.Or_expressionContext ctx)
    {
        updateLineNumber(ctx);

        if (ctx.or != null)
            return new OrExpressionNode(visit(ctx.or), visit(ctx.and));
        else
            return visit(ctx.and);
    }

    @Override
    public Node visitAnd_expression(EduCodeParser.And_expressionContext ctx)
    {
        updateLineNumber(ctx);

        if (ctx.and != null)
            return new AndExpressionNode(visit(ctx.and), visit(ctx.eq));
        else
            return visit(ctx.eq);
    }

    @Override
    public Node visitEquality_expression(EduCodeParser.Equality_expressionContext ctx)
    {
        updateLineNumber(ctx);

        if (ctx.eq != null)
            return new EqualExpressionNode(getLogicalOperator(ctx.op.getText()), visit(ctx.eq), visit(ctx.rel));
        else
            return visit(ctx.rel);
    }

    @Override
    public Node visitRelative_expression(EduCodeParser.Relative_expressionContext ctx)
    {
        updateLineNumber(ctx);

        if (ctx.ae.size() == 2)
            return new RelativeExpressionNode(getLogicalOperator(ctx.op.getText()), visit(ctx.ae.get(0)), visit(ctx.ae.get(1));
        else
            return visit(ctx.ae.get(0));
    }

    @Override
    public Node visitBool_literal(EduCodeParser.Bool_literalContext ctx)
    {
        updateLineNumber(ctx);

        return new BoolLiteralNode(ctx.BOOL_LITERAL().getText().equals("true"));
    }

    @Override
    public Node visitData_type(EduCodeParser.Data_typeContext ctx)
    {
        return null;
    }

    @Override
    public Node visitEnd_of_line(EduCodeParser.End_of_lineContext ctx)
    {
        return null;
    }

    @Override
    public Node visitReference(EduCodeParser.AccessContext ctx)
    {
        if (ctx.ident() != null)
            return visit(ctx.ident());
        else if (ctx.arithExpr() != null)
            return new ArrayReferencingNode(visit(ctx.reference(0)), visit(ctx.arithExpr()));
        else
            return new StructReferencingNode(visit(ctx.reference(0)), visit(ctx.reference(1)));
    }

    @Override
    public Node visitIdentifier(EduCodeParser.IdentifierContext ctx)
    {
        updateLineNumber(ctx);

        return new IdentifierReferencingNode(ctx.id.getText());
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
    public Node visitEventDef(EduCodeParser.Event_definitionContext ctx)
    {
        return new EventDefinitionNode((IReference) visit(ctx.id), getEventType(ctx.event));
    }

    @Override
    public Node visitMethod(EduCodeParser.Method_declarationContext ctx)
    {
        updateLineNumber(ctx);

        Type returnType = Type.VoidType;
        if (ctx.type!= null)
            returnType = getType(ctx.type;

        if (ctx.params != null)
            return new MethodDeclarationNode(visit(ctx.params), visit(ctx.body), (IReference) visit(ctx.id), returnType);
        else
            return new MethodDeclarationNode(null, visit(ctx.body), (IReference) visit(ctx.id), returnType);
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
    public Node visitVarDcl(EduCodeParser.Variable_declarationContext ctx)
    {
        updateLineNumber(ctx);

        ArrayList nodes = new ArrayList<>();

        // Add nodes without assignments.
        for (EduCodeParser.IdentifierContext i : ctx.ident())
            nodes.add(new VariableDeclarationNode((IReference) visit(i), getType(ctx.dataType())));

        // Add nodes with assignments
        for (EduCodeParser.AssignContext a : ctx.assign())
            nodes.add(new VariableDeclarationNode((AssignmentNode) visit(a), getType(ctx.dataType())));

        return new ListNode(nodes);
    }

    @Override
    public Node visitAssign(EduCodeParser.AssignContext ctx)
    {
        updateLineNumber(ctx);

        if (ctx.expr() != null) // Assign to expression
            return new AssignmentNode((IReference) visit(ctx.reference()), visit(ctx.expr()));

        System.out.println("Error at line " + ctx.getStart().getLine());
        System.out.println(ctx.getText());

        return null;
    }

    @Override
    public Node visitArithExpr(EduCodeParser.ArithExprContext ctx)
    {
        updateLineNumber(ctx);

        if (ctx.getChildCount() == 1)
            return visit(ctx.term());
        else if (ctx.getChildCount() == 3)
            return new AdditionExpression(getArithmeticOperator(ctx.ADDOP().getText()), visit(ctx.arithExpr()), visit(ctx.term()));

        System.out.println("ArithError at line " + ctx.getStart().getLine());

        return null;
    }

    @Override
    public Node visitMethodC(EduCodeParser.MethodCContext ctx)
    {
        updateLineNumber(ctx);

        if (ctx.parExpr() != null)
            return new StructReferencingNode(visit(ctx.parExpr()), visit(ctx.methodC2()));
        else
            return visit(ctx.methodC2());
    }

    @Override
    public Node visitMethodC2(EduCodeParser.MethodC2Context ctx)
    {
        if (ctx.methodC2().size() == 2)
            return new StructReferencingNode(visit(ctx.methodC2(0)), visit(ctx.methodC2(1)));
        else
        {
            if (ctx.args() != null)
                return new MethodInvocationNode((IReference) visit(ctx.reference()), visit(ctx.args()));
            else
                return new MethodInvocationNode((IReference) visit(ctx.reference()), null);
        }
    }

    @Override
    public Node visitArgs(EduCodeParser.ArgsContext ctx)
    {
        updateLineNumber(ctx);

        ListNode node = new ListNode();
        for (EduCodeParser.ExprContext e : ctx.expr())
            node.addChild(visit(e));

        return node;
    }

    @Override
    public Node visitTerm(EduCodeParser.TermContext ctx)
    {
        updateLineNumber(ctx);

        if (ctx.getChildCount() == 1)
            return visit(ctx.factor());
        else if (ctx.getChildCount() == 3)
            return new MultiplicationExpression(getArithmeticOperator(ctx.MULTOP().getText()), visit(ctx.term()), visit(ctx.factor()));

        System.out.println("TermError at line " + ctx.getStart().getLine());

        return null;
    }

    @Override
    public Node visitFactor(EduCodeParser.FactorContext ctx)
    {
        updateLineNumber(ctx);

        if (ctx.parExpr() != null)
            return visit(ctx.parExpr());
        else if (ctx.literal() != null)
            return visit(ctx.literal());
        else if (ctx.methodC() != null)
            return visit(ctx.methodC());
        else if (ctx.negation() != null)
            return visit(ctx.negation());
        else if (ctx.boolLit() != null)
            return new BoolLiteralNode(Boolean.parseBoolean(ctx.getText()));
        else if (ctx.typeCast() != null)
            return visit(ctx.typeCast());
        else if (ctx.objInst() != null)
            return visit(ctx.objInst());

        System.out.println("FactError at line " + ctx.getStart().getLine());

        return null;
    }

    @Override
    public Node visitParExpr(EduCodeParser.ParExprContext ctx)
    {
        return visit(ctx.logicExpr());
    }

    @Override
    public Node visitNegation(EduCodeParser.NegationContext ctx)
    {
        return new NegateNode(visit(ctx.factor()));
    }

    @Override
    public Node visitTypeCast(EduCodeParser.TypeCastContext ctx)
    {
        return new TypeCastNode(getType(ctx.dataType()), visit(ctx.factor()));
    }

    @Override
    public Node visitCoordLit(EduCodeParser.CoordLitContext ctx)
    {
        return new CoordinatesLiteralNode(visit(ctx.logicExpr(0)), visit(ctx.logicExpr(1)), visit(ctx.logicExpr(2)));
    }

    @Override
    public Node visitStringLit(EduCodeParser.StringLitContext ctx)
    {
        return new StringLiteralNode(ctx.STRLIT().getText());
    }

    @Override
    public Node visitNumberLit(EduCodeParser.NumberLitContext ctx)
    {
        return new NumberLiteralNode(Float.parseFloat(ctx.getText()));
    }

    @Override
    public Node visitLiteral(EduCodeParser.LiteralContext ctx)
    {
        updateLineNumber(ctx);

        return visit(ctx.getChild(0));
    }
}
