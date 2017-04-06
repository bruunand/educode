package com.educode.visitors;

import com.educode.antlr.EduCodeBaseVisitor;
import com.educode.antlr.EduCodeParser;
import com.educode.nodes.Identifiable;
import com.educode.nodes.base.ListNode;
import com.educode.nodes.base.NaryNode;
import com.educode.nodes.base.Node;
import com.educode.nodes.expression.AdditionExpression;
import com.educode.nodes.expression.MultiplicationExpression;
import com.educode.nodes.expression.logic.AndExpressionNode;
import com.educode.nodes.expression.logic.EqualExpressionNode;
import com.educode.nodes.expression.logic.NegateNode;
import com.educode.nodes.expression.logic.OrExpressionNode;
import com.educode.nodes.literal.BoolLiteralNode;
import com.educode.nodes.literal.IdentifierLiteralNode;
import com.educode.nodes.literal.NumberLiteralNode;
import com.educode.nodes.literal.StringLiteralNode;
import com.educode.nodes.method.MethodDeclarationNode;
import com.educode.nodes.method.MethodInvocationNode;
import com.educode.nodes.method.ParameterNode;
import com.educode.nodes.statement.AssignmentNode;
import com.educode.nodes.statement.ReturnNode;
import com.educode.nodes.statement.VariableDeclarationNode;
import com.educode.nodes.statement.conditional.ConditionNode;
import com.educode.nodes.statement.conditional.IfNode;
import com.educode.nodes.statement.conditional.RepeatWhileNode;
import com.educode.nodes.ungrouped.BlockNode;
import com.educode.nodes.ungrouped.ObjectInstantiationNode;
import com.educode.nodes.ungrouped.ProgramNode;
import com.educode.types.ArithmeticOperator;
import com.educode.types.LogicalOperator;
import com.educode.types.Type;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.Token;

import java.util.ArrayList;

/**
 * Created by zen on 3/8/17.
 */
public class ASTBuilder extends EduCodeBaseVisitor<Node>
{
    private static int _currentLineNumber = 0;
    private static int _currentCharPosition = 0;

    private static void updatePosition(ParserRuleContext fromCtx)
    {
        ASTBuilder._currentLineNumber = fromCtx.getStart().getLine();
        ASTBuilder._currentCharPosition = fromCtx.getStart().getCharPositionInLine();
    }

    public static int getLineNumber()
    {
        return ASTBuilder._currentLineNumber;
    }

    public static int getCharPosition()
    {
        return ASTBuilder._currentCharPosition;
    }

    private LogicalOperator getLogicalOperator(String operator)
    {
        switch (operator)
        {
            case "EQUALS":
                return LogicalOperator.Equals;
            case "NOT EQUALS":
                return LogicalOperator.NotEquals;
            case "LESS THAN":
                return LogicalOperator.LessThan;
            case "LESS THAN OR EQUALS":
                return LogicalOperator.LessThanOrEquals;
            case "GREATER THAN":
                return LogicalOperator.GreaterThan;
            case "GREATER THAN OR EQUALS":
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
            case "%":
                return ArithmeticOperator.Modulo;
            default:
                return ArithmeticOperator.Error;
        }
    }

    private Type getType(String type)
    {
        switch (type)
        {
            case "STRING":
                return Type.StringType;
            case "BOOL":
                return Type.BoolType;
            case "COORDINATES":
                return Type.CoordinatesType;
            case "NUMBER":
                return Type.NumberType;
            default:
                return Type.VoidType;
        }
    }

    @Override
    public Node visitParams(EduCodeParser.ParamsContext ctx)
    {
        updatePosition(ctx);

        ListNode parameterCollection = new ListNode();

        for (EduCodeParser.ParamContext p : ctx.param())
            parameterCollection.addChild(visit(p));

        return parameterCollection;
    }

    @Override
    public Node visitParam(EduCodeParser.ParamContext ctx)
    {
        updatePosition(ctx);

        return new ParameterNode(ctx.IDENT().getText(), getType(ctx.dataType().getText()));
    }

    @Override
    public Node visitStmt(EduCodeParser.StmtContext ctx)
    {
        updatePosition(ctx);

        return super.visitStmt(ctx); // Will pass to an appropriate statement.
    }

    @Override
    public Node visitRet(EduCodeParser.RetContext ctx)
    {
        updatePosition(ctx);

        if (ctx.expr() != null)
            return new ReturnNode(visit(ctx.expr()));
        else
            return new ReturnNode();
    }

    @Override
    public Node visitLoopStmt(EduCodeParser.LoopStmtContext ctx)
    {
        updatePosition(ctx);

        return new RepeatWhileNode(new ConditionNode(visit(ctx.logicExpr()), visit(ctx.stmts())));
    }

    @Override
    public Node visitIfStmt(EduCodeParser.IfStmtContext ctx)
    {
        updatePosition(ctx);

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
    public Node visitExpr(EduCodeParser.ExprContext ctx)
    {
        updatePosition(ctx);

        return super.visitExpr(ctx);//visit(ctx.getChild(0));
    }

    @Override
    public Node visitLogicExpr(EduCodeParser.LogicExprContext ctx)
    {
        updatePosition(ctx);

        return visit(ctx.orExpr());
    }

    @Override
    public Node visitOrExpr(EduCodeParser.OrExprContext ctx)
    {
        updatePosition(ctx);

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
        updatePosition(ctx);

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
        updatePosition(ctx);

        if (ctx.getChildCount() == 1)
            return visit(ctx.getChild(0));
        else if (ctx.getChildCount() == 3)
            return new EqualExpressionNode(getLogicalOperator(ctx.RELOP().getText()), visit(ctx.getChild(0)), visit(ctx.getChild(2)));

        System.out.println("Unexpected child count in relative-expression");

        return null;
    }

    @Override
    public Node visitBoolLit(EduCodeParser.BoolLitContext ctx)
    {
        updatePosition(ctx);

        return new BoolLiteralNode(ctx.TRUE() != null);
    }

    @Override
    public Node visitDataType(EduCodeParser.DataTypeContext ctx)
    {
        updatePosition(ctx);

        System.out.println("datatype");
        return null;
    }

    @Override
    public Node visitEol(EduCodeParser.EolContext ctx)
    {
        return null;
    }

    @Override
    public Node visitIdent(EduCodeParser.IdentContext ctx)
    {
        updatePosition(ctx);

        if (ctx.arithExpr() != null)
            return new IdentifierLiteralNode(visit(ctx.arithExpr()), ctx.identName().getText());
        else
            return new IdentifierLiteralNode(null, ctx.identName().getText());
    }

    @Override
    public Node visitIdentName(EduCodeParser.IdentNameContext ctx)
    {
        return null;
    }

    @Override
    public Node visitProgram(EduCodeParser.ProgramContext ctx)
    {
        updatePosition(ctx);

        ArrayList<Node> nodes = new ArrayList<>();
        nodes.addAll(((NaryNode)visit(ctx.methods())).getChildren());

        return new ProgramNode(nodes, ctx.ident().getText());
    }

    @Override
    public Node visitMethods(EduCodeParser.MethodsContext ctx)
    {
        updatePosition(ctx);

        ArrayList<Node> childMethods = new ArrayList<>();

        for (EduCodeParser.MethodContext m : ctx.method())
            childMethods.add(visit(m));

        return new ListNode(childMethods);
    }

    @Override
    public Node visitMethod(EduCodeParser.MethodContext ctx)
    {
        updatePosition(ctx);

        Type returnType = Type.VoidType;
        if (ctx.dataType() != null)
            returnType = getType(ctx.dataType().getText());

        if (ctx.params() != null)
            return new MethodDeclarationNode(visit(ctx.params()), visit(ctx.stmts()), ctx.ident().getText(), returnType);
        else
            return new MethodDeclarationNode(null, visit(ctx.stmts()), ctx.ident().getText(), returnType);
    }

    @Override
    public Node visitStmts(EduCodeParser.StmtsContext ctx)
    {
        updatePosition(ctx);

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
        updatePosition(ctx);

        ArrayList nodes = new ArrayList<>();

        // Add nodes without assignments.
        for (EduCodeParser.IdentContext i : ctx.ident())
            nodes.add(new VariableDeclarationNode((IdentifierLiteralNode) visit(i), getType(ctx.dataType().getText())));

        // Add nodes with assignments
        for (EduCodeParser.AssignContext a : ctx.assign())
            nodes.add(new VariableDeclarationNode(getType(ctx.dataType().getText()), (AssignmentNode) visit(a)));

        return new ListNode(nodes);
    }

    @Override
    public Node visitAssign(EduCodeParser.AssignContext ctx)
    {
        updatePosition(ctx);

        if (ctx.expr() != null) // Assign to expression
            return new AssignmentNode((IdentifierLiteralNode) visit(ctx.ident()), visit(ctx.expr()));
        else if (ctx.dataType() != null) // Assign to instantiated object
        {
            Type classType = getType(ctx.dataType().getText());

            if (ctx.args() != null)
                return new AssignmentNode((IdentifierLiteralNode) visit(ctx.ident()), new ObjectInstantiationNode(visit(ctx.args()), classType));
            else
                return new AssignmentNode((IdentifierLiteralNode) visit(ctx.ident()), new ObjectInstantiationNode(classType));
        }

        System.out.println("Error at line " + ctx.getStart().getLine());
        System.out.println(ctx.getText());

        return null;
    }

    @Override
    public Node visitArithExpr(EduCodeParser.ArithExprContext ctx)
    {
        updatePosition(ctx);

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
        updatePosition(ctx);

        if (ctx.args() != null)
            return new MethodInvocationNode(visit(ctx.args()), ctx.ident().getText());
        else
            return new MethodInvocationNode(null, ctx.ident().getText());
    }

    @Override
    public Node visitArgs(EduCodeParser.ArgsContext ctx)
    {
        updatePosition(ctx);

        ListNode node = new ListNode();
        for (EduCodeParser.ExprContext e : ctx.expr())
            node.addChild(visit(e));

        return node;
    }

    @Override
    public Node visitTerm(EduCodeParser.TermContext ctx)
    {
        updatePosition(ctx);

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
        updatePosition(ctx);

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

        System.out.println("FactError at line " + ctx.getStart().getLine());

        return null;
    }

    @Override
    public Node visitLiteral(EduCodeParser.LiteralContext ctx)
    {
        updatePosition(ctx);

        if (ctx.NUMLIT() != null)
            return new NumberLiteralNode(Float.parseFloat(ctx.NUMLIT().getText())); // num literal
        else if (ctx.ident() != null)
            return visit(ctx.ident());
        else if (ctx.STRLIT() != null)
            return new StringLiteralNode(ctx.STRLIT().getText()); // string literal

        System.out.println("LitError at line " + ctx.getStart().getLine());

        return null;
    }
}
