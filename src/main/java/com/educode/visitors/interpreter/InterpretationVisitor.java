package com.educode.visitors.interpreter;

import com.educode.nodes.base.Node;
import com.educode.nodes.expression.AdditionExpressionNode;
import com.educode.nodes.expression.MultiplicationExpressionNode;
import com.educode.nodes.expression.RangeNode;
import com.educode.nodes.expression.UnaryMinusNode;
import com.educode.nodes.expression.logic.EqualExpressionNode;
import com.educode.nodes.expression.logic.NegateNode;
import com.educode.nodes.expression.logic.RelativeExpressionNode;
import com.educode.nodes.literal.BoolLiteralNode;
import com.educode.nodes.literal.CoordinatesLiteralNode;
import com.educode.nodes.literal.NumberLiteralNode;
import com.educode.nodes.literal.StringLiteralNode;
import com.educode.nodes.method.MethodDeclarationNode;
import com.educode.nodes.method.MethodInvocationNode;
import com.educode.nodes.method.ParameterNode;
import com.educode.nodes.referencing.IdentifierReferencingNode;
import com.educode.nodes.statement.*;
import com.educode.nodes.statement.conditional.ConditionNode;
import com.educode.nodes.statement.conditional.IfNode;
import com.educode.nodes.statement.conditional.RepeatWhileNode;
import com.educode.nodes.ungrouped.BlockNode;
import com.educode.nodes.ungrouped.ProgramNode;
import com.educode.nodes.ungrouped.StartNode;
import com.educode.runtime.ProgramBase;
import com.educode.runtime.ProgramImpl;
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
    private HashMap<String, Object> _globalVariables = new HashMap<>();

    private ProgramBase _program = new ProgramImpl();

    // Flags
    private boolean _continue = false, _break = false;

    public void visit(StartNode node)
    {
        visit(node.getRightChild());
    }

    public void visit(ProgramNode node)
    {
        // Register global variables, todo

        // Get main method
        for (MethodDeclarationNode methodDeclaration : node.getMethodDeclarations())
        {
            if (!methodDeclaration.getIsMainMethod())
                continue;

            visit(methodDeclaration.getBlockNode());
        }
    }

    public Object visit(MultiplicationExpressionNode node)
    {
        Object left  = visit(node.getLeftChild());
        Object right = visit(node.getRightChild());

        if (node.isType(Type.NumberType))
        {
            switch (node.getOperator().getKind())
            {
                case ArithmeticOperator.MULTIPLICATION:
                    return (double) left * (double) right;
                case ArithmeticOperator.DIVISION:
                    return (double) left / (double) right;
                case ArithmeticOperator.MODULO:
                    return (double) left % (double) right;
            }
        }

        return null;
    }

    public Object visit(IdentifierReferencingNode node)
    {
        String variableName = node.getText();

        if (this._localVariables.containsKey(variableName))
            return this._localVariables.get(variableName);
        else if (this._globalVariables.containsKey(variableName))
            return this._globalVariables.get(variableName);

        System.out.println("Could not find " + variableName);

        return null; // Should not happen in accordance with semantic visitor
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

    public void visit(ContinueNode node)
    {
        this._continue = true;
    }

    public void visit(BreakNode node)
    {
        this._break = true;
    }

    public Object visit(MethodInvocationNode node)
    {
        MethodDeclarationNode methodDeclaration = node.getReferencingDeclaration();
        BlockNode blockNode = methodDeclaration.getBlockNode();
        if (blockNode == null)
        {
            if (node.getReference().toString().equals("debug"))
                System.out.println("Interpreted: " + visit(node.getActualArguments().get(0)));

            return null;
        }

        // Create new map of variables for method invocation
        HashMap<String, Object> newLocalVariables = new HashMap<>();

        // Put actual arguments onto HashMap
        if (methodDeclaration.hasParameterList())
        {
            List<Node> formalArguments = methodDeclaration.getParameterList().getChildren();
            List<Node> actualArguments = node.getActualArguments();

            // Evaluate actual arguments left to right
            for (int i = 0; i < formalArguments.size(); i++)
            {
                String argumentName = ((IdentifierReferencingNode)((ParameterNode) formalArguments.get(i)).getReference()).getText();
                Object res = visit(actualArguments.get(i));
                newLocalVariables.put(argumentName, res);
            }
        }

        // Save old local variables while executing block
        HashMap oldLocalVariables = this._localVariables;
        this._localVariables = newLocalVariables;

        // Invoke the method by visiting its block
        Object visitResult = visit(blockNode);

        // Restore old local variables
        this._localVariables = oldLocalVariables;

        // If visit result is a return element, return its value
        if (visitResult instanceof ReturnFlag)
            return ((ReturnFlag) visitResult).getContained();

        return visitResult;
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
                return new ReturnFlag(visit(subNode));
            else if (subNode instanceof BreakNode || subNode instanceof ContinueNode)
            {
                visit(subNode);
                return new JumpFlag();
            }

            Object result = visit(subNode);
            if (result instanceof JumpFlag)
                return result;
        }

        return null;
    }

    public Object visit(NegateNode node)
    {
        return !((boolean) visit(node.getChild()));
    }

    public Object visit(UnaryMinusNode node)
    {
        Object childResult = visit(node.getChild());

        if (childResult instanceof Double)
            return ((Double) childResult) * -1;
        else if (childResult instanceof Coordinates)
        {
            Coordinates coordinates = (Coordinates) childResult;
            return new Coordinates(coordinates.getX() * -1, coordinates.getY() * -1, coordinates.getZ() * -1);
        }

        return null;
    }
    public Object visit(ReturnNode node)
    {
        if (node.hasChild())
            return visit(node.getChild());

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
        Object left  = visit(node.getLeftChild());
        Object right = visit(node.getRightChild());

        if (node.isType(Type.StringType))
            return left.toString() + right.toString();
        else if (node.isType(Type.CoordinatesType))
            return ((Coordinates) left).add((Coordinates) right, node.getOperator().equals(ArithmeticOperator.Subtraction));
        else if (node.isType(Type.NumberType))
        {
            switch (node.getOperator().getKind())
            {
                case ArithmeticOperator.ADDITION:
                    return (double) left + (double) right;
                case ArithmeticOperator.SUBTRACTION:
                    return (double) left - (double) right;
            }
        }

        return null;
    }

    public Object visit(ForEachNode node)
    {
        String localVariableName = ((IdentifierReferencingNode) node.getReference()).getText();

        ExtendedList<Object> list = (ExtendedList<Object>) visit(node.getLeftChild());
        for (Object object : list)
        {
            // Put object into local variable
            this._localVariables.put(localVariableName, object);

            // Visit block for this foreach node
            Object returnObject = visit(node.getRightChild());
            if (returnObject instanceof ReturnFlag)
            {
                return returnObject;
            }

            // Consume flags
            if (this._continue)
            {
                this._continue = false;
                continue;
            }
            else if (this._break)
            {
                this._break = false;
                break;
            }
        }

        // Remove local variable since it is not needed anymore
        this._localVariables.remove(localVariableName);

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

    public ReturnFlag visit(RepeatWhileNode node)
    {
        ConditionNode conditionNode = (ConditionNode) node.getChild();

        while (true)
        {
            // Check condition
            if (!(boolean) visit(conditionNode.getLeftChild()))
                break;

            // Visit block
            Object result = visit(conditionNode.getRightChild());
            if (result != null && result instanceof ReturnFlag)
                return (ReturnFlag) result;

            // Consume flags
            if (this._continue)
            {
                this._continue = false;
                continue;
            }
            else if (this._break)
            {
                this._break = false;
                break;
            }
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

