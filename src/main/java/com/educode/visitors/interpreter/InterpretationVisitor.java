package com.educode.visitors.interpreter;

import com.educode.nodes.base.Node;
import com.educode.nodes.expression.AdditionExpressionNode;
import com.educode.nodes.expression.RangeNode;
import com.educode.nodes.expression.logic.EqualExpressionNode;
import com.educode.nodes.expression.logic.RelativeExpressionNode;
import com.educode.nodes.literal.BoolLiteralNode;
import com.educode.nodes.literal.CoordinatesLiteralNode;
import com.educode.nodes.literal.NumberLiteralNode;
import com.educode.nodes.literal.StringLiteralNode;
import com.educode.nodes.method.MethodDeclarationNode;
import com.educode.nodes.method.MethodInvocationNode;
import com.educode.nodes.referencing.IdentifierReferencingNode;
import com.educode.nodes.statement.AssignmentNode;
import com.educode.nodes.statement.ReturnNode;
import com.educode.nodes.statement.VariableDeclarationNode;
import com.educode.nodes.statement.conditional.ConditionNode;
import com.educode.nodes.statement.conditional.IfNode;
import com.educode.nodes.statement.conditional.RepeatWhileNode;
import com.educode.nodes.ungrouped.BlockNode;
import com.educode.nodes.ungrouped.ProgramNode;
import com.educode.nodes.ungrouped.StartNode;
import com.educode.runtime.types.Coordinates;
import com.educode.runtime.types.ExtendedList;
import com.educode.types.ArithmeticOperator;
import com.educode.types.LogicalOperator;
import com.educode.types.Type;
import com.educode.visitors.VisitorBase;

import java.util.HashMap;
import java.util.List;

/**
 * Created by User on 20-Jun-17.
 */
public class InterpretationVisitor extends VisitorBase
{
    private HashMap<String, Object> _localVariables = new HashMap<>();

    public void visit(StartNode node)
    {
        visit(node.getRightChild());
    }

    public void visit(ProgramNode node)
    {
        // Register global variables

        // Get main method
        for (MethodDeclarationNode methodDeclaration : node.getMethodDeclarations())
        {
            if (!methodDeclaration.getIsMainMethod())
                continue;

            visit(methodDeclaration.getBlockNode());
        }
    }

    public Object visit(IdentifierReferencingNode node)
    {
        return this._localVariables.get(node.getText());
    }

    public Object visit(IfNode node)
    {
        List<ConditionNode> conditionNodes = node.getConditionBlocks();

        // Go through all conditions
        for (ConditionNode condition : conditionNodes)
        {
            boolean predicate = (boolean) visit(condition.getLeftChild());
            if (predicate)
                return visit(condition.getRightChild());
        }

        // If no returns are made, check for an else block
        BlockNode elseBlockNode = node.getElseBlock();
        if (elseBlockNode != null)
            return visit(elseBlockNode);

        // Nothing to return, no conditions or else-block was satisfied
        return null;
    }

    public Object visit(MethodInvocationNode node)
    {
        BlockNode blockNode = node.getReferencingDeclaration().getBlockNode();
        if (blockNode == null)
        {
            if (node.getReference().toString().equals("debug"))
                System.out.println("Interpreted: " + visit(node.getActualArguments().get(0)));

            return null;
        }

        return visit(blockNode);
    }

    public Object visit(RangeNode node)
    {
        ExtendedList<Double> ret = new ExtendedList<>();

        double min = (double) visit(node.getLeftChild());
        double max = (double) visit(node.getRightChild());

        for (double c = min; c <= max; c++)
            ret.addItem(c);

        return ret;
    }

    public Object visit(BlockNode node)
    {
        for (Node subNode : node.getChildren())
        {
            if (subNode instanceof ReturnNode)
                return new ReturnElement(visit(subNode));

            Object result = visit(subNode);
            if (result instanceof ReturnElement)
                return result;
        }

        return null;
    }

    public Object visit(ReturnNode node)
    {
        if (node.hasChild())
            return node.getChild();
        return null;
    }

    // not correct
    public Object visit(EqualExpressionNode node)
    {
        Object left  = visit(node.getLeftChild());
        Object right = visit(node.getRightChild());

        return left.equals(right);
    }

    public Object visit(AdditionExpressionNode node)
    {
        if (node.isType(Type.StringType))
            return visit(node.getLeftChild()).toString() + visit(node.getRightChild()).toString();
        else if (node.isType(Type.CoordinatesType))
            return ((Coordinates) visit(node.getLeftChild())).add((Coordinates) visit(node.getRightChild()), node.getOperator().equals(ArithmeticOperator.Subtraction));
        else if (node.isType(Type.NumberType))
            return ((double) visit(node.getLeftChild())) + ((double) visit(node.getRightChild()));

        return null;
    }

    public Object visit(VariableDeclarationNode node)
    {
        if (node.getReference() instanceof IdentifierReferencingNode)
            this._localVariables.put(((IdentifierReferencingNode) node.getReference()).getText(), null);

        if (node.hasChild())
            return visit(node.getChild());
        else
            return null;
    }

    public Object visit(AssignmentNode node)
    {
        Object expression = visit(node.getChild());
        if (node.getReference() instanceof IdentifierReferencingNode)
            this._localVariables.put(((IdentifierReferencingNode) node.getReference()).getText(), expression);

        return expression;
    }

    public Object visit(NumberLiteralNode node)
    {
        return node.getValue();
    }

    public Object visit(StringLiteralNode node)
    {
        String value = node.getValue();
        if (value != null && value.length() >= 2)
            return value.substring(1, value.length() - 1);
        return value;
    }

    public ReturnElement visit(RepeatWhileNode node)
    {
        ConditionNode conditionNode = (ConditionNode) node.getChild();

        while (true)
        {
            // Check condition
            if (!(boolean) visit(conditionNode.getLeftChild()))
                break;

            // Visit block
            Object result = visit(conditionNode.getRightChild());
            if (result != null && result instanceof ReturnElement)
                return (ReturnElement) result;
        }

        return null;
    }

    public Object visit(BoolLiteralNode node)
    {
        return node.getValue();
    }

    public Object visit(RelativeExpressionNode node)
    {
        double left  = (double) visit(node.getLeftChild());
        double right = (double) visit(node.getRightChild());

        switch (node.getOperator().getKind())
        {
            case LogicalOperator.LESS_THAN:
                return left < right;
            case LogicalOperator.LESS_THAN_OR_EQUALS:
                return left <= right;
            case LogicalOperator.GREATER_THAN:
                return left > right;
            case LogicalOperator.GREATER_THAN_OR_EQUALS:
                return left >= right;
        }

        return false;
    }

    public Object visit(CoordinatesLiteralNode node)
    {
        return new Coordinates((double) visit(node.getX()), (double) visit(node.getY()), (double) visit(node.getZ()));
    }

    @Override
    public Object defaultVisit(Node node)
    {
        System.out.println("No interpretation implemented: " + node.getClass());
        return null;
    }
}

