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

    private EventTypeBase getEventType(EduCodeParser.EventTypeContext ctx)
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
                return new StringMessageReceivedEvent((NumberLiteralNode) visit(ctx.numberLit()));
            case "entityMessageReceived":
                return new EntityMessageReceivedEvent((NumberLiteralNode) visit(ctx.numberLit()));
        }

        return null;
    }

    private Type getType(EduCodeParser.DataTypeContext ctx)
    {
        if (ctx.dataType() != null)
            return new Type(getType(ctx.dataType()));
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
    public Node visitParams(EduCodeParser.ParamsContext ctx)
    {
        updateLineNumber(ctx);

        ListNode parameterCollection = new ListNode();

        for (EduCodeParser.ParamContext p : ctx.param())
            parameterCollection.addChild(visit(p));

        return parameterCollection;
    }

    @Override
    public Node visitParam(EduCodeParser.ParamContext ctx)
    {
        updateLineNumber(ctx);

        return new ParameterNode((IReference) visit(ctx.ident()), getType(ctx.dataType()));
    }

    @Override
    public Node visitStmt(EduCodeParser.StmtContext ctx)
    {
        updateLineNumber(ctx);

        return super.visitStmt(ctx); // Will pass to an appropriate statement.
    }

    @Override
    public Node visitRet(EduCodeParser.RetContext ctx)
    {
        updateLineNumber(ctx);

        if (ctx.expr() != null)
            return new ReturnNode(visit(ctx.expr()));
        else
            return new ReturnNode();
    }

    @Override
    public Node visitLoopStmt(EduCodeParser.LoopStmtContext ctx)
    {
        updateLineNumber(ctx);

        return new RepeatWhileNode(new ConditionNode(visit(ctx.logicExpr()), visit(ctx.stmts())));
    }

    @Override
    public Node visitIfStmt(EduCodeParser.IfStmtContext ctx)
    {
        updateLineNumber(ctx);

        IfNode ifNode = new IfNode();

        // If there is an else block, skip the last block
        // There is an else block if there are fewer logical expressions than statements
        boolean hasElseBlock = ctx.logicExpr().size() < ctx.stmts().size();
        for (int i = 0; i < (hasElseBlock ? ctx.stmts().size() - 1 : ctx.stmts().size()); i++)
            ifNode.addChild(new ConditionNode(visit(ctx.logicExpr(i)), visit(ctx.stmts(i))));

        // If there is an else block, add it finally without a ConditionNode
        if (hasElseBlock)
            ifNode.addChild(visit(ctx.stmts(ctx.stmts().size() - 1)));

        return ifNode;
    }

    @Override
    public Node visitIterStmt(EduCodeParser.IterStmtContext ctx)
    {
        return new ForEachNode((IReference) visit(ctx.ident()), getType(ctx.dataType()), visit(ctx.expr()), visit(ctx.stmts()));
    }

    @Override
    public Node visitExpr(EduCodeParser.ExprContext ctx)
    {
        updateLineNumber(ctx);

        return super.visitExpr(ctx);//visit(ctx.getChild(0));
    }

    @Override
    public Node visitLogicExpr(EduCodeParser.LogicExprContext ctx)
    {
        updateLineNumber(ctx);

        return visit(ctx.orExpr());
    }

    @Override
    public Node visitOrExpr(EduCodeParser.OrExprContext ctx)
    {
        updateLineNumber(ctx);

        if (ctx.getChildCount() == 1)
            return visit(ctx.getChild(0));
        else if (ctx.getChildCount() == 3)
            return new OrExpressionNode(visit(ctx.getChild(0)), visit(ctx.getChild(2)));

        System.out.println("Unexpected child count in or-expression");

        return null;
    }

    @Override
    public Node visitAndExpr(EduCodeParser.AndExprContext ctx)
    {
        updateLineNumber(ctx);

        if (ctx.getChildCount() == 1)
            return visit(ctx.getChild(0));
        else if (ctx.getChildCount() == 3)
            return new AndExpressionNode(visit(ctx.getChild(0)), visit(ctx.getChild(2)));

        System.out.println("Unexpected child count in and-expression");

        return null;
    }

    @Override
    public Node visitEqlExpr(EduCodeParser.EqlExprContext ctx)
    {
        if (ctx.getChildCount() == 1)
            return visit(ctx.getChild(0));
        else if (ctx.getChildCount() == 3)
            return new EqualExpressionNode(getLogicalOperator(ctx.EQUALOP().getText()), visit(ctx.getChild(0)), visit(ctx.getChild(2)));

        System.out.println("Unexpected child count in equals-expression");

        return null;
    }

    @Override
    public Node visitRelExpr(EduCodeParser.RelExprContext ctx)
    {
        updateLineNumber(ctx);

        if (ctx.getChildCount() == 1)
            return visit(ctx.getChild(0));
        else if (ctx.getChildCount() == 3)
            return new RelativeExpressionNode(getLogicalOperator(ctx.RELOP().getText()), visit(ctx.getChild(0)), visit(ctx.getChild(2)));

        System.out.println("Unexpected child count in relative-expression");

        return null;
    }

    @Override
    public Node visitBoolLit(EduCodeParser.BoolLitContext ctx)
    {
        updateLineNumber(ctx);

        return new BoolLiteralNode(ctx.TRUE() != null);
    }

    @Override
    public Node visitDataType(EduCodeParser.DataTypeContext ctx)
    {
        return null;
    }

    @Override
    public Node visitEol(EduCodeParser.EolContext ctx)
    {
        return null;
    }

    @Override
    public Node visitReference(EduCodeParser.ReferenceContext ctx)
    {
        if (ctx.ident() != null)
            return visit(ctx.ident());
        else if (ctx.arithExpr() != null)
            return new ArrayReferencingNode(visit(ctx.reference(0)), visit(ctx.arithExpr()));
        else
            return new StructReferencingNode(visit(ctx.reference(0)), visit(ctx.reference(1)));
    }

    @Override
    public Node visitIdent(EduCodeParser.IdentContext ctx)
    {
        updateLineNumber(ctx);

        return new IdentifierReferencingNode(ctx.IDENT().getText());
    }

    @Override
    public Node visitProgram(EduCodeParser.ProgramContext ctx)
    {
        updateLineNumber(ctx);

        ArrayList<Node> nodes = new ArrayList<>();

        // Add global variables
        for (EduCodeParser.VarDclContext v : ctx.varDcl())
            nodes.add(visit(v));

        // Add event subscriptions
        for (EduCodeParser.EventDefContext e : ctx.eventDef())
            nodes.add(visit(e));

        // Add method declarations
        for (EduCodeParser.MethodContext m : ctx.method())
            nodes.add(visit(m));

        return new ProgramNode(nodes, (IReference) visit(ctx.ident()));
    }

    @Override
    public Node visitEventDef(EduCodeParser.EventDefContext ctx)
    {
        return new EventDefinitionNode((IReference) visit(ctx.ident()), getEventType(ctx.eventType()));
    }

    @Override
    public Node visitMethod(EduCodeParser.MethodContext ctx)
    {
        updateLineNumber(ctx);

        Type returnType = Type.VoidType;
        if (ctx.dataType() != null)
            returnType = getType(ctx.dataType());

        if (ctx.params() != null)
            return new MethodDeclarationNode(visit(ctx.params()), visit(ctx.stmts()), (IReference) visit(ctx.ident()), returnType);
        else
            return new MethodDeclarationNode(null, visit(ctx.stmts()), (IReference) visit(ctx.ident()), returnType);
    }

    @Override
    public Node visitStmts(EduCodeParser.StmtsContext ctx)
    {
        updateLineNumber(ctx);

        ArrayList<Node> childStatements = new ArrayList<>();

        for (EduCodeParser.StmtContext statement : ctx.stmt())
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
    public Node visitVarDcl(EduCodeParser.VarDclContext ctx)
    {
        updateLineNumber(ctx);

        ArrayList nodes = new ArrayList<>();

        // Add nodes without assignments.
        for (EduCodeParser.IdentContext i : ctx.ident())
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
        else if (ctx.dataType() != null) // Assign to instantiated object
        {
            Type classType = getType(ctx.dataType());

            if (ctx.args() != null)
                return new AssignmentNode((IReference) visit(ctx.reference()), new ObjectInstantiationNode(visit(ctx.args()), classType));
            else
                return new AssignmentNode((IReference) visit(ctx.reference()), new ObjectInstantiationNode(classType));
        }

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

        if (ctx.methodC().size() == 2)
            return new StructReferencingNode(visit(ctx.methodC(0)), visit(ctx.methodC(1)));
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

        if (ctx.logicExpr() != null)
            return visit(ctx.logicExpr());
        else if (ctx.literal() != null)
            return visit(ctx.literal());
        else if (ctx.methodC() != null)
            return visit(ctx.methodC());
        else if (ctx.ULOP() != null)
            return new NegateNode(visit(ctx.factor()));
        else if (ctx.boolLit() != null)
            return new BoolLiteralNode(Boolean.parseBoolean(ctx.getText()));
        else if (ctx.dataType() != null)
            return new TypeCastNode(getType(ctx.dataType()), visit(ctx.factor()));

        System.out.println("FactError at line " + ctx.getStart().getLine());

        return null;
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
