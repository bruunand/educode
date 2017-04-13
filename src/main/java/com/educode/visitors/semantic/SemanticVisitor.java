package com.educode.visitors.semantic;

import com.educode.nodes.Typeable;
import com.educode.nodes.base.ListNode;
import com.educode.nodes.base.Node;
import com.educode.nodes.expression.AdditionExpression;
import com.educode.nodes.expression.MultiplicationExpression;
import com.educode.nodes.expression.logic.*;
import com.educode.nodes.literal.*;
import com.educode.nodes.method.MethodDeclarationNode;
import com.educode.nodes.method.MethodInvocationNode;
import com.educode.nodes.method.ParameterNode;
import com.educode.nodes.statement.AssignmentNode;
import com.educode.nodes.statement.ForEachNode;
import com.educode.nodes.statement.ReturnNode;
import com.educode.nodes.statement.VariableDeclarationNode;
import com.educode.nodes.statement.conditional.ConditionNode;
import com.educode.nodes.statement.conditional.IfNode;
import com.educode.nodes.statement.conditional.RepeatWhileNode;
import com.educode.nodes.ungrouped.BlockNode;
import com.educode.nodes.ungrouped.ObjectInstantiationNode;
import com.educode.nodes.ungrouped.ProgramNode;
import com.educode.nodes.ungrouped.TypeCastNode;
import com.educode.symboltable.Symbol;
import com.educode.symboltable.SymbolTableHandler;
import com.educode.types.ArithmeticOperator;
import com.educode.types.Type;
import com.educode.visitors.VisitorBase;

/**
 * Created by zen on 4/5/17.
 */
public class SemanticVisitor extends VisitorBase
{
    private SymbolTableHandler _symbolTableHandler = new SymbolTableHandler();

    public SymbolTableHandler getSymbolTableHandler()
    {
        return _symbolTableHandler;
    }

    private void addDefaultMethod(String name, Type returnType, Type ... types)
    {
        ListNode parameterNodes = new ListNode();
        for (Type type : types)
            parameterNodes.addChild(new ParameterNode(null, type));

        _symbolTableHandler.enterSymbol(new MethodDeclarationNode(parameterNodes, null, name, returnType));
    }

    public SemanticVisitor()
    {
        addDefaultMethod("debug", Type.VoidType, Type.StringType);
        addDefaultMethod("wait", Type.VoidType, Type.NumberType);
        addDefaultMethod("toString", Type.StringType, Type.EntityType);

        // Add Minecraft related methods
        addDefaultMethod("say", Type.VoidType, Type.StringType);
        addDefaultMethod("getX", Type.NumberType);
        addDefaultMethod("getY", Type.NumberType);
        addDefaultMethod("getZ", Type.NumberType);
        addDefaultMethod("setTime", Type.VoidType, Type.NumberType);
        addDefaultMethod("getDistanceToEntity", Type.NumberType, Type.EntityType);
        addDefaultMethod("walkToEntity", Type.VoidType, Type.EntityType);
        addDefaultMethod("move", Type.VoidType, Type.StringType);
        addDefaultMethod("mine", Type.VoidType, Type.StringType);
        addDefaultMethod("getNearbyEntities", new Type(Type.EntityType));
        addDefaultMethod("getOwnerEntity", Type.EntityType);
        addDefaultMethod("explode", Type.VoidType, Type.NumberType);
    }

    @Override
    public Object visit(ProgramNode node)
    {
        _symbolTableHandler.openScope();

        // Call ReturnVisitor using same symbol table
        ReturnVisitor retVisitor = new ReturnVisitor(_symbolTableHandler);
        retVisitor.visit(node);

        // Add method declarations to symbol table
        boolean hasRunMethod = false;
        for (MethodDeclarationNode methodDecl : node.getMethodDeclarations())
        {
            _symbolTableHandler.enterSymbol(methodDecl);

            // Check if signature of method matches main method
            if (methodDecl.getIdentifier().equals("main") && methodDecl.getType().equals(Type.VoidType) && !methodDecl.hasParameterList())
                hasRunMethod = true;
        }

        // If no main method, log error
        if (!hasRunMethod)
            _symbolTableHandler.error(node, "Program has no method called 'main' with no return type and parameters.");

        // Visit methods
        for (MethodDeclarationNode methodDecl : node.getMethodDeclarations())
            visit(methodDecl);

        _symbolTableHandler.closeScope();

        return null;
    }

    @Override
    public Object visit(BlockNode node)
    {
        _symbolTableHandler.openScope();

        visitChildren(node);

        _symbolTableHandler.closeScope();

        return null;
    }

    @Override
    public Object visit(ListNode node)
    {
        visitChildren(node);

        return null;
    }

    @Override
    public Object visit(ObjectInstantiationNode node)
    {
        // We need to visit children to ensure that actual parameters contain known variables
        visitChildren(node);

        // Only allow instantation of reference types
        if (!node.getType().isCollection())
            _symbolTableHandler.error(node, String.format("Cannot instantiate object of type %s.", node.getType()));
        else if (node.getType().isCollection())
        {
            Type collectionChildType = node.getType().getChildType();

            // Check if actual arguments are of the collection's child type
            for (Node actual : node.getActualArguments())
            {
                Type actualType = ((Typeable)actual).getType();
                if (!actualType.equals(collectionChildType))
                    _symbolTableHandler.error(node, String.format("Arguments in the instantiation of %s must be of type %s, but the argument was of type %s.", node.getType(), collectionChildType, actualType));
            }
        }

        return null;
    }

    @Override
    public Object visit(MethodDeclarationNode node)
    {
        _symbolTableHandler.openScope();

        // Set current method parent of symbol table handler
        _symbolTableHandler.setCurrentParent(node);

        // Visit parameters
        if (node.getParameterList() != null)
            visitChildren(node.getParameterList());

        // If method declaration has a non-void return type, check if it returns something on all paths
        if (!node.getType().equals(Type.VoidType))
        {
            // TODO
        }

        // Visit block
        visit(node.getBlockNode());

        _symbolTableHandler.closeScope();

        return null;
    }

    @Override
    public Object visit(MethodInvocationNode node)
    {
        // Visits parameters to get correct type of actual arguments
        visitChildren(node);

        Symbol methodSymbol = _symbolTableHandler.retreiveSymbol(node);

        if (methodSymbol == null)
        {
            String formalParameters = "";
            for (Node type : node.getActualArguments())
                formalParameters += ((Typeable)type).getType() + " ";

            _symbolTableHandler.error(node, String.format("No method '%s' exists with the formal parameters %s.", node.getIdentifier(), formalParameters.trim().replace(" ", ", ")));
            node.setType(Type.Error);
        }
        else
            node.setType(((Typeable)methodSymbol.getNode()).getType());

        return null;
    }

    @Override
    public Object visit(ParameterNode node)
    {
        _symbolTableHandler.enterSymbol(node);

        return null;
    }

    @Override
    public Object visit(AssignmentNode node)
    {
        visitChildren(node);

        // Get the symbol that corresponds to the left side
        Symbol leftSide = _symbolTableHandler.retreiveSymbol(node.getIdentifierNode());
        if (leftSide == null)
            _symbolTableHandler.error(node, String.format("Identifier %s is not declared.", node.getIdentifier()));
        else
        {
            // Set type of identifier node
            // Todo: Check if this makes sense :)
            if (leftSide.getNode() instanceof Typeable)
                node.getIdentifierNode().setType(((Typeable)leftSide.getNode()).getType());

            // Check if right side has a type
            if (node.hasChild() && node.getChild() instanceof Typeable)
            {
                Type leftSideType = ((Typeable) leftSide.getNode()).getType(); // todo: Not a good way of doing this..
                Type rightSideType = ((Typeable) node.getChild()).getType();

                // If type is void, it can not be assigned to anything
                // Otherwise check if type of sides are equal - they must be
                if (leftSideType.equals(Type.VoidType))
                    _symbolTableHandler.error(node, String.format("%s is of type %s, it can not be assigned.", node.getIdentifier(), leftSideType));
                else if (!leftSideType.equals(rightSideType))
                    _symbolTableHandler.error(node, String.format("%s is of type %s, can not be assigned to %s.", node.getIdentifier(), leftSideType, rightSideType));

            }
            else
                _symbolTableHandler.error(node, "Right side of the assignment does not have a type.");
        }

        return null;
    }

    @Override
    public Object visit(VariableDeclarationNode node)
    {
        _symbolTableHandler.enterSymbol(node);

        visitChildren(node);

        return null;
    }

    @Override
    public Object visit(IfNode node)
    {
        visitChildren(node);

        return null;
    }

    @Override
    public Object visit(ConditionNode node)
    {
        // Visit condition
        visit(node.getLeftChild());

        Type conditionType = Type.Error;
        if (node.getLeftChild() instanceof Typeable)
            conditionType = ((Typeable) node.getLeftChild()).getType();

        // Check if condition type is boolean
        if (!conditionType.equals(Type.BoolType))
            _symbolTableHandler.error(node, String.format("Condition must be of type %s, but is of type %s.", Type.BoolType, conditionType));

        // Visit block
        visit(node.getRightChild());

        return null;
    }

    @Override
    public Object visit(RepeatWhileNode node)
    {
        visitChildren(node);

        return null;
    }

    @Override
    public Object visit(ForEachNode node)
    {
        _symbolTableHandler.openScope();

        _symbolTableHandler.enterSymbol(node);

        visitChildren(node);

        // Get type of left child (expression)
        Type expressionType = ((Typeable) node.getLeftChild()).getType();

        if (!expressionType.isCollection())
            _symbolTableHandler.error(node, String.format("Expression of type %s is not applicable in a for-each statement.", expressionType));
        else if (!node.getType().equals(expressionType.getChildType()))
            _symbolTableHandler.error(node, String.format("Expression to iterate in for-each statement must be a collection of %s.", node.getType()));

        _symbolTableHandler.closeScope();

        return null;
    }

    @Override
    public Object visit(ReturnNode node)
    {
        visitChildren(node);

        Type parentType = _symbolTableHandler.getCurrentParent().getType();
        Type childType = Type.VoidType;
        if (node.hasChild() && node.getChild() instanceof Typeable)
            childType = ((Typeable) node.getChild()).getType();

        // Return type and parent method type should be equal
        if (!parentType.equals(childType))
            _symbolTableHandler.error(node, String.format("Can not return an expression of type %s when parent method returns %s.", childType, parentType));

        return null;
    }

    @Override
    public Object visit(MultiplicationExpression node)
    {
        visitChildren(node);

        Type leftType = ((Typeable)node.getLeftChild()).getType();
        Type rightType = ((Typeable)node.getRightChild()).getType();

        if (leftType.equals(Type.NumberType) && rightType.equals(Type.NumberType))
        {
            node.setType(Type.NumberType);

            // Check for divison by zero
            if (node.getOperator().equals(ArithmeticOperator.Division) && node.getRightChild() instanceof NumberLiteralNode)
            {
                if (((NumberLiteralNode) node.getRightChild()).getValue() == 0)
                    _symbolTableHandler.error(node, "Division by 0 is not allowed.");
            }
        }
        else
            _symbolTableHandler.error(node, String.format("%s operator cannot be used on %s and %s.", node.getOperator(), leftType, rightType));

        return null;
    }

    @Override
    public Object visit(AdditionExpression node)
    {
        visitChildren(node);

        Type leftType = ((Typeable)node.getLeftChild()).getType();
        Type rightType = ((Typeable)node.getRightChild()).getType();

        if (leftType.equals(Type.NumberType) && rightType.equals(Type.NumberType))
            node.setType(Type.NumberType);
        else if (leftType.equals(Type.StringType) || leftType.equals(Type.StringType))
            node.setType(Type.StringType);
        else if (leftType.equals(Type.CoordinatesType) && rightType.equals(Type.CoordinatesType))
            node.setType(Type.CoordinatesType);
        else
            _symbolTableHandler.error(node, String.format("%s operator cannot be used on %s and %s.", node.getOperator(), leftType, rightType));

        return null;
    }

    @Override
    public Object visit(NumberLiteralNode node)
    {
        return null;
    }

    @Override
    public Object visit(StringLiteralNode node)
    {
        return null;
    }

    @Override
    public Object visit(IdentifierLiteralNode node)
    {
        Symbol s = _symbolTableHandler.retreiveSymbol(node);

        if (s != null)
            if (s.getNode() instanceof Typeable)
                node.setType(((Typeable)s.getNode()).getType());
            else
                _symbolTableHandler.error(node, "Invalid variable type."); //Should not happen.
        else
            _symbolTableHandler.error(node, String.format("Variable %s has not been declared.", node.getIdentifier()));

        return null;
    }

    @Override
    public Object visit(BoolLiteralNode node)
    {
        return null;
    }

    @Override
    public Object visit(CoordinatesLiteralNode node)
    {
        return null;
    }

    @Override
    public Object visit(OrExpressionNode node)
    {
        visitLogicExpression(node);

        return null;
    }

    @Override
    public Object visit(AndExpressionNode node)
    {
        visitLogicExpression(node);

        return null;
    }

    private void visitLogicExpression(LogicExpressionNode node)
    {
        visitChildren(node);

        Type leftType = ((Typeable)node.getLeftChild()).getType();
        Type rightType = ((Typeable)node.getRightChild()).getType();

        if (!leftType.equals(Type.BoolType) || !rightType.equals(Type.BoolType))
            _symbolTableHandler.error(node, String.format("Both sides of the %s expression must be of type %s, but are of type %s and %s.", node.getOperator(), Type.BoolType, leftType, rightType));
    }

    @Override
    public Object visit(RelativeExpressionNode node)
    {
        visitChildren(node);

        Type leftType = ((Typeable)node.getLeftChild()).getType();
        Type rightType = ((Typeable)node.getRightChild()).getType();

        boolean isNumberComparison = leftType.equals(Type.NumberType) && rightType.equals(Type.NumberType);
        boolean isStringComparison = leftType.equals(Type.StringType) && rightType.equals(Type.StringType);

        // Only number and string comparisons are allowed
        if (!isNumberComparison && !isStringComparison)
            _symbolTableHandler.error(node, String.format("Logical operator %s can not be used for types %s and %s.", node.getOperator(), leftType, rightType));

        return null;
    }

    @Override
    public Object visit(EqualExpressionNode node)
    {
        visitChildren(node);

        Type leftType = ((Typeable)node.getLeftChild()).getType();
        Type rightType = ((Typeable)node.getRightChild()).getType();

        // Only same type comparisons allowed
        // Unless either side is string, in which case any non-string will be cast to string
        if (leftType != rightType)
            _symbolTableHandler.error(node, String.format("Logical operator %s can not be used for types %s and %s.", node.getOperator(), leftType, rightType));

        return null;
    }

    @Override
    public Object visit(NegateNode node)
    {
        visitChildren(node);

        if (node.getChild() instanceof Typeable)
        {
            if(!((Typeable)node.getChild()).getType().equals(Type.BoolType))
                _symbolTableHandler.error(node, "Negated expression was not of boolean type.");
        }
        else
            _symbolTableHandler.error(node, "Negated expression did not have a type."); // should not happen..

        return null;
    }

    @Override
    public Object visit(TypeCastNode node)
    {
        visitChildren(node);

        if (node.getChild() instanceof Typeable)
        {
            Type fromType = ((Typeable)node.getChild()).getType();
            Type toType   = node.getType();

            if (fromType.equals(toType))
                _symbolTableHandler.warning(node, String.format("Redundant cast from %s to %s", fromType, toType));
            else if (!isExplicitCastAllowed(fromType, toType))
                _symbolTableHandler.error(node, String.format("Type %s cannot be cast to type %s.", fromType, toType));
        }
        else
            _symbolTableHandler.error(node, "Child of type cast did not have a type."); // should not happen

        return null;
    }

    private boolean isExplicitCastAllowed(Type fromType, Type toType)
    {
        if (toType.equals(Type.StringType))
            return true;

        return false;
    }
}
