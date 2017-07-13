package com.educode.visitors.interpreter;

import com.educode.events.EventInvocationRequest;
import com.educode.nodes.base.ListNode;
import com.educode.nodes.base.Node;
import com.educode.nodes.expression.AdditionExpressionNode;
import com.educode.nodes.expression.MultiplicationExpressionNode;
import com.educode.nodes.expression.RangeNode;
import com.educode.nodes.expression.UnaryMinusNode;
import com.educode.nodes.expression.logic.*;
import com.educode.nodes.literal.*;
import com.educode.nodes.method.MethodDeclarationNode;
import com.educode.nodes.method.MethodInvocationNode;
import com.educode.nodes.method.ParameterNode;
import com.educode.nodes.referencing.ArrayReferencingNode;
import com.educode.nodes.referencing.IdentifierReferencingNode;
import com.educode.nodes.referencing.StructReferencingNode;
import com.educode.nodes.statement.*;
import com.educode.nodes.statement.conditional.ConditionNode;
import com.educode.nodes.statement.conditional.IfNode;
import com.educode.nodes.statement.conditional.RepeatWhileNode;
import com.educode.nodes.ungrouped.BlockNode;
import com.educode.nodes.ungrouped.ObjectInstantiationNode;
import com.educode.nodes.ungrouped.ProgramNode;
import com.educode.nodes.ungrouped.StartNode;
import com.educode.runtime.NativeMethodsHelper;
import com.educode.runtime.ProgramBase;
import com.educode.runtime.types.Coordinates;
import com.educode.runtime.types.ExtendedList;
import com.educode.types.ArithmeticOperator;
import com.educode.types.LogicalOperator;
import com.educode.types.Type;
import com.educode.visitors.AbstractVisitor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by User on 20-Jun-17.
 */
public class InterpretationVisitor extends AbstractVisitor
{
    private final NativeMethodsHelper _helper = new NativeMethodsHelper();
    private HashMap<String, Object> _localVariables = new HashMap<>();
    private final HashMap<String, Object> _globalVariables = new HashMap<>();

    private final ProgramBase _program;

    // Flags
    private boolean _continue = false, _break = false;

    public InterpretationVisitor(ProgramBase program)
    {
        this._program = program;
        this._program.setInterpreter(this);
    }

    private Object callNative(MethodInvocationNode methodInvocation, Object instance, List<Node> argumentNodes)
    {
        MethodDeclarationNode methodDeclaration = methodInvocation.getReferencingDeclaration();
        String methodName = ((IdentifierReferencingNode) methodInvocation.getReference()).getText();

        // Evaluate arguments
        List<Object> argumentObjects = new ArrayList<>(argumentNodes.size());
        if (methodDeclaration.getUseHelper())
            argumentObjects.add(instance);
        for (Node argumentNode : argumentNodes)
            argumentObjects.add(visit(argumentNode));

        // Get class array
        List<ParameterNode> formalParameters = methodDeclaration.getParameters();
        Class[] classArray = new Class[argumentObjects.size()];
        for (int i = 0; i < argumentObjects.size(); i++)
        {
            Type currentType = formalParameters.get(i).getType();
            if (currentType.getIsGeneric())
                classArray[i] = Object.class;
            else if (currentType.equals(Type.NumberType))
                classArray[i] = Double.class;
            else if (currentType.equals(Type.BoolType))
                classArray[i] = Boolean.class;
            else
                classArray[i] = argumentObjects.get(i).getClass();
        }

        // Invoke method
        // Find the appropriate event and invoke it
        try
        {
            Object useInstance = methodInvocation.getReferencingDeclaration().getUseHelper() ? _helper : instance;
            return useInstance.getClass().getMethod(methodName, classArray).invoke(useInstance, argumentObjects.toArray());
        }
        catch (Exception e)
        {
            System.out.println("Error at invocation of native method " + methodName);
            e.printStackTrace();
            return null;
        }
    }

    public Object invokeEvent(EventInvocationRequest event)
    {
        return callLocal(event.getMethodDeclaration(), event.getArguments());
    }

    private Object callLocal(MethodDeclarationNode declaration, List<Object> arguments)
    {
        // Create new map of variables for method invocation
        HashMap<String, Object> newLocalVariables = new HashMap<>();

        // Put actual arguments onto HashMap
        if (declaration.hasParameterList())
        {
            List<Node> formalArguments = declaration.getParameterList().getChildren();

            // Evaluate actual arguments left to right
            for (int i = 0; i < formalArguments.size(); i++)
            {
                String argumentName = ((IdentifierReferencingNode)((ParameterNode) formalArguments.get(i)).getReference()).getText();
                newLocalVariables.put(argumentName, arguments.get(i));
            }
        }

        // Save old local variables while executing block
        HashMap<String, Object> oldLocalVariables = this._localVariables;
        this._localVariables = newLocalVariables;

        // Invoke the method by visiting its block
        Object visitResult = visit(declaration.getBlockNode());

        // Restore old local variables
        this._localVariables = oldLocalVariables;

        // If visit result is a return element, return its value
        if (visitResult instanceof ReturnFlag)
            return ((ReturnFlag) visitResult).getContained();

        return visitResult;
    }

    @Override
    public Object visit(ObjectInstantiationNode node)
    {
        if (node.getType().isList())
        {
            // Evaluate arguments
            List<Object> arguments = new ArrayList<>();
            for (Node argument : node.getActualArguments())
                arguments.add(visit(argument));

            // Create class array
            Class[] classArray = new Class[arguments.size()];
            for (int i = 0; i < classArray.length; i++)
                classArray[i] = Object.class;

            // Instantiate
            try
            {
                return ExtendedList.class.getConstructor(classArray).newInstance(arguments.toArray());
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }

        return null;
    }

    @Override
    public Object visit(MethodDeclarationNode node)
    {
        return null;
    }

    @Override
    public Object visit(NullLiteralNode node)
    {
        return null;
    }

    @Override
    public Object visit(StartNode node)
    {
        return visit(node.getRightChild());
    }

    @Override
    public Object visit(ProgramNode node)
    {
        // Register global variables
        for (VariableDeclarationNode variableDeclaration : node.getVariableDeclarations())
            visit(variableDeclaration);

        // Register robot (which is just a reference to the program)
        this._globalVariables.put("robot", _program);

        // Get and run main method's block
        for (MethodDeclarationNode methodDeclaration : node.getMethodDeclarations())
        {
            if (!methodDeclaration.getIsMainMethod())
                continue;

            visit(methodDeclaration.getBlockNode());
        }

        // Listen for events
        if (_program.getEventDefinitions() != null && !_program.getEventDefinitions().isEmpty())
        {
            while (true)
            {
                try
                {
                    invokeEvent(this._program.getInterpretedEventQueue().take());
                }
                catch (InterruptedException e)
                {
                    break;
                }
            }
        }

        return null;
    }

    @Override
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

    @Override
    public Object visit(OrExpressionNode node)
    {
        return ((boolean) visit(node.getLeftChild())) || ((boolean) visit(node.getRightChild()));
    }

    @Override
    public Object visit(AndExpressionNode node)
    {
        return ((boolean) visit(node.getLeftChild())) && ((boolean) visit(node.getRightChild()));
    }

    @Override
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

    @Override
    public Object visit(ConditionNode node)
    {
        return null;
    }

    @Override
    public Object visit(ContinueNode node)
    {
        this._continue = true;
        return null;
    }

    @Override
    public Object visit(BreakNode node)
    {
        this._break = true;
        return null;
    }

    @Override
    public Object visit(MethodInvocationNode node)
    {
        MethodDeclarationNode methodDeclaration = node.getReferencingDeclaration();
        // Handle native method call
        BlockNode blockNode = methodDeclaration.getBlockNode();
        if (blockNode == null)
            return callNative(node, _program, node.getActualArguments());

        // Create argument list
        List<Node> argumentNodes = node.getActualArguments();
        List<Object> argumentValues = new ArrayList<>(argumentNodes.size());
        for (Node argumentNode : argumentNodes)
            argumentValues.add(visit(argumentNode));

        return callLocal(methodDeclaration, argumentValues);
    }

    @Override
    public Object visit(ParameterNode node)
    {
        return null;
    }

    @Override
    public Object visit(RangeNode node)
    {
        ExtendedList<Double> ret = new ExtendedList<>();

        double min = (double) visit(node.getLeftChild());
        double max = (double) visit(node.getRightChild());

        for (double c = min; c <= max; c++)
            ret.addItem(c);

        return ret;
    }

    @Override
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

            // Check if there are any events waiting
            if (!this._program.getInterpretedEventQueue().isEmpty())
                invokeEvent(this._program.getInterpretedEventQueue().poll());
        }

        return null;
    }

    @Override
    public Object visit(ListNode node)
    {
        return null;
    }

    @Override
    public Object visit(NegateNode node)
    {
        return !((boolean) visit(node.getChild()));
    }

    @Override
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

    @Override
    public Object visit(ReturnNode node)
    {
        if (node.hasChild())
            return visit(node.getChild());

        return new JumpFlag();
    }

    // todo: verify correctness
    @Override
    public Object visit(EqualExpressionNode node)
    {
        Object left  = visit(node.getLeftChild());
        Object right = visit(node.getRightChild());

        switch (node.getOperator().getKind())
        {
            case LogicalOperator.EQUALS:
                return left.equals(right);
            case LogicalOperator.NOT_EQUALS:
                return !left.equals(right);
        }

        return false;
    }

    @Override
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

    @Override
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

    @Override
    public Object visit(ForEachNode node)
    {
        String localVariableName = ((IdentifierReferencingNode) node.getReference()).getText();

        ExtendedList list = (ExtendedList) visit(node.getLeftChild());
        for (Object object : list)
        {
            // Put object into local variable
            this._localVariables.put(localVariableName, object);

            // Visit block for this foreach node
            Object returnObject = visit(node.getRightChild());
            if (returnObject instanceof ReturnFlag)
                return returnObject;

            // Consume flags
            if (this._continue)
                this._continue = false;
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

    @Override
    public Object visit(ArrayReferencingNode node)
    {
        return ((ExtendedList) visit(node.getLeftChild())).getItemAt((double) visit(node.getRightChild()));
    }

    @Override
    public Object visit(StructReferencingNode node)
    {
        Object leftInstance = visit(node.getLeftChild());
        if (node.isMethodInvocation())
        {
            MethodInvocationNode invocation = (MethodInvocationNode) node.getRightChild();
            return callNative(invocation, leftInstance, invocation.getActualArguments());
        }
        else if (node.isFieldReference())
        {
            String fieldName = ((IdentifierReferencingNode) node.getRightChild()).getText();

            try
            {
                return leftInstance.getClass().getField(fieldName).get(leftInstance);
            }
            catch (Exception e)
            {
                System.out.println("Could not retrieve contents of field " + fieldName);
            }
        }

        return null;
    }

    @Override
    public Object visit(VariableDeclarationNode node)
    {
        if (node.getReference() instanceof IdentifierReferencingNode)
        {
            String variableName = ((IdentifierReferencingNode) node.getReference()).getText();
            if (node.isDeclaredGlobally())
                this._globalVariables.put(variableName, null);
            else
                this._localVariables.put(variableName, null);
        }

        if (node.hasChild())
            return visit(node.getChild());
        else
            return null;
    }

    @Override
    public Object visit(AssignmentNode node)
    {
        Object expression = visit(node.getChild());
        if (node.getReference() instanceof IdentifierReferencingNode)
        {
            String variableName = ((IdentifierReferencingNode) node.getReference()).getText();

            if (this._localVariables.containsKey(variableName))
                this._localVariables.put(variableName, expression);
            else if (this._globalVariables.containsKey(variableName))
                this._globalVariables.put(variableName, expression);
        }
        else if (node.getReference() instanceof StructReferencingNode)
        {
            Object leftInstance = visit(((StructReferencingNode) node.getReference()).getObjectName());
            String fieldName = ((IdentifierReferencingNode) visit(((StructReferencingNode) node.getReference()).getMemberName())).getText();

            try
            {
                leftInstance.getClass().getField(fieldName).set(leftInstance, expression);
            }
            catch (Exception e)
            {
                System.out.println("Unable to set contents of field " + fieldName);
                e.printStackTrace();
            }
        }
        else if (node.getReference() instanceof ArrayReferencingNode)
        {
            ExtendedList arrayObject = (ExtendedList) visit(((ArrayReferencingNode) node.getReference()).getLeftChild());
            arrayObject.set((int) visit(((ArrayReferencingNode) node.getReference()).getRightChild()), expression);
        }

        return expression;
    }

    @Override
    public Object visit(NumberLiteralNode node)
    {
        return node.getValue();
    }

    @Override
    public Object visit(StringLiteralNode node)
    {
        return node.getValue();
    }

    @Override
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
                this._continue = false;
            else if (this._break)
            {
                this._break = false;
                break;
            }
        }

        return null;
    }

    @Override
    public Object visit(BoolLiteralNode node)
    {
        return node.getValue();
    }

    @Override
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

    @Override
    public Object visit(CoordinatesLiteralNode node)
    {
        return new Coordinates((double) visit(node.getX()), (double) visit(node.getY()), (double) visit(node.getZ()));
    }
}

