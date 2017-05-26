package com.educode.visitors.optimisation;

import com.educode.nodes.base.INodeWithChildren;
import com.educode.nodes.base.NaryNode;
import com.educode.nodes.base.Node;
import com.educode.nodes.expression.ArithmeticExpressionNode;
import com.educode.nodes.expression.UnaryMinusNode;
import com.educode.nodes.expression.logic.LogicalExpressionNode;
import com.educode.nodes.expression.logic.NegateNode;
import com.educode.nodes.expression.logic.RelativeExpressionNode;
import com.educode.nodes.literal.BoolLiteralNode;
import com.educode.nodes.literal.ILiteral;
import com.educode.nodes.literal.NumberLiteralNode;
import com.educode.nodes.referencing.IdentifierReferencingNode;
import com.educode.nodes.statement.AssignmentNode;
import com.educode.nodes.statement.VariableDeclarationNode;
import com.educode.nodes.statement.conditional.ConditionNode;
import com.educode.nodes.statement.conditional.IfNode;
import com.educode.nodes.statement.conditional.RepeatWhileNode;
import com.educode.nodes.ungrouped.BlockNode;
import com.educode.types.ArithmeticOperator;
import com.educode.types.LogicalOperator;
import com.educode.visitors.VisitorBase;

import java.util.Dictionary;
import java.util.Hashtable;

/**
 * Created by zen on 5/3/17.
 */
public class OptimisationVisitor extends VisitorBase
{
    private final Dictionary<VariableDeclarationNode, Node> _constantDeclarations = new Hashtable<>();

    @Override
    public Object defaultVisit(Node node)
    {
        visitChildren(node);

        return null;
    }

    public Object visit(NegateNode node)
    {
        Object result = visit(node.getChild());

        if (!(result instanceof Boolean))
            return null;
        else
            return !((Boolean) result);
    }

    public Object visit(UnaryMinusNode node)
    {
        Object result = visit(node.getChild());

        if (!(result instanceof Double))
            return null;
        else
            return ((Double)result) * -1;
    }

    public void visit(RepeatWhileNode node)
    {
        // Repeat while nodes need to have their bodies visited first
        // We need to know if variables are assigned in the body, otherwise we might falsely fold the predicate for the condition node
        ConditionNode condition = (ConditionNode) node.getChild();
        visit(condition.getRightChild());
        Object predicateResult = visit(condition.getLeftChild());

        if (!(predicateResult instanceof Boolean))
            return;

        Boolean predicateBool = (Boolean) predicateResult;
        if (!predicateBool) // Repeat While node can be deleted safely if its predicate is always false
            ((INodeWithChildren) node.getParent()).replaceChildReference(node, null);
    }

    public void visit(IfNode node)
    {
        for (ConditionNode condition : node.getConditionBlocks())
        {
            Object visitResult = visit(condition.getLeftChild());
            visit(condition.getRightChild());
            if (!(visitResult instanceof Boolean))
                continue; // If visitResult is not a boolean, it may still evaluate to a boolean but we don't know its value as compile time

            Boolean booleanResult = (Boolean) visitResult;
            if (booleanResult)
            {
                ((INodeWithChildren) node.getParent()).replaceChildReference(node, condition.getRightChild());
                return;
            }
            else
                node.remove(condition);
        }

        // If there are no condition blocks left, replace if node with else block
        if (node.getConditionBlocks().size() == 0)
        {
            BlockNode elseBlock = node.getElseBlock();

            if (elseBlock != null)
            {
                visit(elseBlock);
                ((INodeWithChildren) node.getParent()).replaceChildReference(node, node.getElseBlock()); // No conditions are reachable but there is an else statement, so replace if node with block of else
            }
            else
                ((NaryNode) node.getParent()).replaceChildReference(node, null); // No conditions are reachable and there is no else statement, so if-node can be deleted
        }
    }

    public void visit(AssignmentNode node)
    {
        if (!(node.getReference() instanceof IdentifierReferencingNode))
            return;

        // Check if identifier referencing node has a declaration
        IdentifierReferencingNode reference = (IdentifierReferencingNode) node.getReference();
        if (reference.getDeclaration() == null)
            return;

        this._constantDeclarations.remove(reference.getDeclaration());

        // We need to wait with visiting the children in case the child uses the assigned variable
        // E.g. num = num - 1 could be optimised falsely.
        if (!node.hasChild() || node.getChild() instanceof ILiteral)
            return;

        Object result = visit(node.getChild());
        if (result instanceof Double)
            node.replaceChildReference(node.getChild(), new NumberLiteralNode((double) result));
        else if (result instanceof Boolean)
            node.replaceChildReference(node.getChild(), new BoolLiteralNode((boolean) result));
    }

    public void visit(VariableDeclarationNode node)
    {
        // Do not optimise variable declarations that are declared globally, because we don't know if they are set in other methods
        if (node.hasChild() && !node.isDeclaredGlobally())
        {
            AssignmentNode assignment = (AssignmentNode) node.getChild();
            visit(assignment);

            this._constantDeclarations.put(node, assignment.getChild());
        }
        else
            visitChildren(node);
    }

    public Object visit(IdentifierReferencingNode node)
    {
        VariableDeclarationNode declaration = node.getDeclaration();
        if (declaration == null)
            return null;

        Node constantContent = this._constantDeclarations.get(declaration);
        if (constantContent == null || !(constantContent instanceof ILiteral))
            return null;

        return ((ILiteral) constantContent).getValue();
    }

    public Double visit(NumberLiteralNode node)
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

    private Boolean evaluateLogic(LogicalExpressionNode node)
    {
        Object leftResult  = visit(node.getLeftChild());
        Object rightResult = visit(node.getRightChild());

        // Check for number comparison
        if (leftResult instanceof Double && rightResult instanceof Double)
        {
            Double left  = (Double) leftResult;
            Double right = (Double) rightResult;

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
    public Boolean visit(LogicalExpressionNode node)
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

        if (!(leftResult instanceof Double) || !(rightResult instanceof Double))
            return null;

        Double left  = (Double) leftResult;
        Double right = (Double) rightResult;
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

    public Number visit(ArithmeticExpressionNode node)
    {
        Object leftResult  = visit(node.getLeftChild());
        Object rightResult = visit(node.getRightChild());

        if (!(leftResult instanceof Double) || !(rightResult instanceof Double))
            return null;

        Double left = (Double) leftResult;
        Double right = (Double) rightResult;
        Double result;

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
