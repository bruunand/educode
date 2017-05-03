package com.educode.visitors.optimization;

import com.educode.nodes.base.INodeWithChildren;
import com.educode.nodes.base.Node;
import com.educode.nodes.expression.ArithmeticExpression;
import com.educode.nodes.expression.logic.LogicExpressionNode;
import com.educode.nodes.expression.logic.NegateNode;
import com.educode.nodes.expression.logic.RelativeExpressionNode;
import com.educode.nodes.literal.BoolLiteralNode;
import com.educode.nodes.literal.NumberLiteralNode;
import com.educode.types.ArithmeticOperator;
import com.educode.types.LogicalOperator;
import com.educode.visitors.VisitorBase;

/**
 * Created by zen on 5/3/17.
 */
public class ConstantFoldingVisitor extends VisitorBase
{
    @Override
    public Object defaultVisit(Node node)
    {
        visitChildren(node);

        return null;
    }

    public Float visit(NumberLiteralNode node)
    {
        return node.getValue();
    }
    
    public Boolean visit(BoolLiteralNode node)
    {
        return node.getValue();
    }

    private Boolean evaluateSubLogic(Boolean fromValue, LogicalOperator operator)
    {
        if (fromValue && operator.equals(LogicalOperator.Or))
            return true;
        else if (!fromValue && operator.equals(LogicalOperator.And))
            return false;

        return null;
    }

    private Boolean evaluateLogic(LogicExpressionNode node)
    {
        Object leftResult  = visit(node.getLeftChild());
        Object rightResult = visit(node.getRightChild());

        // Check for number comparison
        if (leftResult instanceof Float && rightResult instanceof Float)
        {
            Float left  = (Float) leftResult;
            Float right = (Float) rightResult;

            switch (node.getOperator().getKind())
            {
                case LogicalOperator.EQUALS:
                    return left.equals(right);
                case LogicalOperator.NOT_EQUALS:
                    return !left.equals(right);
            }

            return null;
        }

        // Check for boolean comparison
        if (leftResult instanceof Boolean && rightResult instanceof Boolean)
        {
            Boolean left  = (Boolean) leftResult;
            Boolean right = (Boolean) rightResult;

            // Calculate result based on operator
            switch (node.getOperator().getKind())
            {
                case LogicalOperator.EQUALS:
                    return left == right;
                case LogicalOperator.NOT_EQUALS:
                    return left != right;
                case LogicalOperator.OR:
                    return left || right;
                case LogicalOperator.AND:
                    return left && right;
            }
        }
        else if (leftResult instanceof Boolean)
            return evaluateSubLogic((Boolean) leftResult, node.getOperator());
        else if (rightResult instanceof Boolean)
            return evaluateSubLogic((Boolean) rightResult, node.getOperator());

        return null;
    }

    // This example differs a bit structurally from number constant folding.
    // This is because of short circuiting, i.e. if we know that one side evaluates to true and
    // that the operator used is OR, we will always return true.
    public Boolean visit(LogicExpressionNode node)
    {
        Object evaluation = evaluateLogic(node);

        // Replace child (self) with boolean literal
        if (evaluation != null && node.getParent() instanceof INodeWithChildren)
            ((INodeWithChildren) node.getParent()).replaceChildReference(node, new BoolLiteralNode((Boolean) evaluation));

        return (Boolean) evaluation;
    }

    public Boolean visit(RelativeExpressionNode node)
    {
        Object leftResult  = visit(node.getLeftChild());
        Object rightResult = visit(node.getRightChild());

        if (!(leftResult instanceof Float) || !(rightResult instanceof Float))
            return null;

        Float left  = (Float) leftResult;
        Float right = (Float) rightResult;
        Boolean result;

        switch (node.getOperator().getKind())
        {
            case LogicalOperator.GREATER_THAN:
                result = left > right;
                break;
            case LogicalOperator.GREATER_THAN_OR_EQUALS:
                result = left >= right;
                break;
            case LogicalOperator.LESS_THAN:
                result = left < right;
                break;
            case LogicalOperator.LESS_THAN_OR_EQUALS:
                result = left <= right;
                break;
            default:
                return null;
        }

        // Replace child (self) with boolean literal
        if (node.getParent() instanceof INodeWithChildren)
            ((INodeWithChildren) node.getParent()).replaceChildReference(node, new BoolLiteralNode(result));

        return null;
    }

    public Number visit(ArithmeticExpression node)
    {
        Object leftResult  = visit(node.getLeftChild());
        Object rightResult = visit(node.getRightChild());

        if (!(leftResult instanceof Float) || !(rightResult instanceof Float))
            return null;

        Float left = (Float) leftResult;
        Float right = (Float) rightResult;
        Float result;

        switch (node.getOperator().getKind())
        {
            case ArithmeticOperator.ADDITION:
                result = left + right;
                break;
            case ArithmeticOperator.SUBTRACTION:
                result = left - right;
                break;
            case ArithmeticOperator.DIVISION:
                result = left / right;
                break;
            case ArithmeticOperator.MODULO:
                result = left % right;
                break;
            case ArithmeticOperator.MULTIPLICATION:
                result = left * right;
                break;
            default:
                return null;
        }

        // Replace child (self) with number literal
        if (node.getParent() instanceof INodeWithChildren)
            ((INodeWithChildren) node.getParent()).replaceChildReference(node, new NumberLiteralNode(result));

        return result;
    }
}
