package com.educode.visitors.semantic;

import com.educode.nodes.base.NaryNode;
import com.educode.nodes.base.Node;
import com.educode.nodes.expression.AdditionExpression;
import com.educode.nodes.expression.MultiplicationExpression;
import com.educode.nodes.expression.logic.EqualExpressionNode;
import com.educode.nodes.expression.logic.LogicExpressionNode;
import com.educode.nodes.expression.logic.NegateNode;
import com.educode.nodes.expression.logic.RelativeExpressionNode;
import com.educode.nodes.literal.NumberLiteralNode;
import com.educode.nodes.method.MethodDeclarationNode;
import com.educode.nodes.method.MethodInvocationNode;
import com.educode.nodes.method.ParameterNode;
import com.educode.nodes.referencing.ArrayReferencingNode;
import com.educode.nodes.referencing.IdentifierReferencing;
import com.educode.nodes.referencing.StructReferencingNode;
import com.educode.nodes.statement.AssignmentNode;
import com.educode.nodes.statement.ForEachNode;
import com.educode.nodes.statement.ReturnNode;
import com.educode.nodes.statement.VariableDeclarationNode;
import com.educode.nodes.ungrouped.BlockNode;
import com.educode.nodes.ungrouped.ObjectInstantiationNode;
import com.educode.nodes.ungrouped.ProgramNode;
import com.educode.nodes.ungrouped.TypeCastNode;
import com.educode.symboltable.Symbol;
import com.educode.symboltable.SymbolTable;
import com.educode.symboltable.SymbolTableHandler;
import com.educode.types.ArithmeticOperator;
import com.educode.types.Type;
import com.educode.visitors.VisitorBase;
import net.minecraftforge.client.model.animation.ModelBlockAnimation;

/**
 * Created by User on 15-Apr-17.
 */
public class SemanticVisitor extends VisitorBase
{
    private final SymbolTableHandler _symbolTableHandler = new SymbolTableHandler();

    public SymbolTableHandler getSymbolTableHandler()
    {
        return this._symbolTableHandler;
    }

    @Override
    public Object defaultVisit(Node node)
    {
        System.out.printf("No visitor for node %s.\n", node.getClass().getName());

        return null;
    }

    public void visit(ProgramNode node)
    {
        getSymbolTableHandler().openScope();

        getSymbolTableHandler().enterSymbol(node);

        // Run return check visitor
        node.accept(new ReturnCheckVisitor(this.getSymbolTableHandler()));

        // Add robot as a global variable
        getSymbolTableHandler().enterSymbol(new VariableDeclarationNode(new IdentifierReferencing("robot"), Type.RobotType));

        // Enter all method declarations
        for (MethodDeclarationNode method : node.getMethodDeclarations())
            getSymbolTableHandler().enterSymbol(method);

        // Visit all children, which includes method declarations
        visitChildren(node);

        getSymbolTableHandler().closeScope();
    }

    public void visit(NaryNode node)
    {
        visitChildren(node);
    }

    public void visit(MethodDeclarationNode node)
    {
        getSymbolTableHandler().openScope();

        getSymbolTableHandler().setCurrentParentMethod(node);

        // Visit parameters
        if (node.getParameterList() != null)
            visitChildren(node.getParameterList());

        // Visit block
        visit(node.getBlockNode());

        getSymbolTableHandler().closeScope();
    }

    public void visit(ParameterNode node)
    {
        getSymbolTableHandler().enterSymbol(node);
    }

    public void visit(ForEachNode node)
    {
        _symbolTableHandler.openScope();

        _symbolTableHandler.enterSymbol(node);

        visit(node.getReference());
        visitChildren(node);

        // Get type of left child (expression)
        Type expressionType = node.getLeftChild().getType();

        if (!expressionType.isCollection())
            _symbolTableHandler.error(node, String.format("Expression of type %s is not applicable in a for-each statement.", expressionType));
        else if (!node.getReference().getType().equals(expressionType.getChildType()))
            _symbolTableHandler.error(node, String.format("Expression to iterate in for-each statement must be a collection of %s.", node.getType()));

        _symbolTableHandler.closeScope();
    }

    public void visit(BlockNode node)
    {
        getSymbolTableHandler().openScope();

        visitChildren(node);

        getSymbolTableHandler().closeScope();
    }

    public void visit(MethodInvocationNode node)
    {
        visitChildren(node);

        SymbolTable table = getSymbolTableHandler().getCurrent();
        Symbol methodReference = null;

        if (node.getReference() instanceof StructReferencingNode)
        {
            StructReferencingNode structReference = (StructReferencingNode) node.getReference();
            methodReference = structReference.getLeftChild().getType().getSymbolTable().retrieveSymbol(structReference.getFieldName());
        }
        else
            methodReference = getSymbolTableHandler().getCurrent().retrieveSymbol(node);

        if (methodReference == null)
            getSymbolTableHandler().error(node, "No method %s found with matching parameters.", node.getReference());
        else
            node.setType(methodReference.getSourceNode().getType());
    }

    public void visit(AssignmentNode node)
    {
        visit(node.getReference());
        visitChildren(node);

        // Check if left side types matches right side type
        if (!node.getReference().isType(node.getChild().getType()))
            getSymbolTableHandler().error(node, "Cannot assign %s, which is of type %s, to an expression of type %s.", node.getReference(), node.getReference().getType(), node.getChild().getType());
    }

    public Symbol visit(IdentifierReferencing reference)
    {
        Symbol referencingSymbol = getSymbolTableHandler().retrieveSymbol(reference);

        if (referencingSymbol == null)
            getSymbolTableHandler().error(reference, "Identifier %s is not declared.", reference);
        else
        {
            // Symbol was found - now set the type of the reference to the type of the symbol we just found
            reference.setType(referencingSymbol.getSourceNode().getType());
        }

        return referencingSymbol;
    }

    public void visit(ArrayReferencingNode reference)
    {
        visitChildren(reference);

        // Left side must be a collection
        Type leftSideType = reference.getLeftChild().getType();
        if (!leftSideType.isCollection())
            getSymbolTableHandler().error(reference, "Left side of array reference must be a collection.");
        else
            reference.setType(leftSideType.getChildType());
    }

    public void visit(ObjectInstantiationNode node)
    {
        // We need to visit children to ensure that actual parameters contain known variables
        visitChildren(node);

        // Only allow instantiation of reference types
        if (!node.getType().isCollection())
            _symbolTableHandler.error(node, String.format("Cannot instantiate object of type %s.", node.getType()));
        else if (node.getType().isCollection())
        {
            Type collectionChildType = node.getType().getChildType();

            // Check if actual arguments are of the collection's child type
            for (Node actual : node.getActualArguments())
            {
                Type actualType = actual.getType();

                if (!actualType.equals(collectionChildType))
                    _symbolTableHandler.error(node, String.format("Arguments in the instantiation of %s must be of type %s, but the argument was of type %s.", node.getType(), collectionChildType, actualType));
            }
        }
    }

    public void visit(StructReferencingNode reference)
    {
        // Only visit left child (object) - not right side (field)
        visit(reference.getLeftChild());

        // Retrieve field
        // Should not be called from MethodInvocation
        SymbolTable table = reference.getLeftChild().getType().getSymbolTable();
        Symbol symbol = table.retrieveSymbol(reference.getRightChild());

        if (symbol == null)
            getSymbolTableHandler().error(reference, "Struct does not contain field %s.", reference.getRightChild());
        else
            reference.setType(symbol.getReference().getType());
    }

    public void visit(VariableDeclarationNode node)
    {
        if (!(node.getReference() instanceof IdentifierReferencing))
            getSymbolTableHandler().error(node, "A variable declaration cannot reference a struct or an array.");
        else
            getSymbolTableHandler().enterSymbol(node);

        visitChildren(node);
    }

    public void visit(ReturnNode node)
    {
        visitChildren(node);

        Type parentType = getSymbolTableHandler().getCurrentParentMethod().getType();
        Type childType = Type.VoidType;
        if (node.hasChild())
            childType = node.getChild().getType();

        // Return type and parent method type should be equal
        if (!parentType.equals(childType))
            _symbolTableHandler.error(node, String.format("Can not return an expression of type %s when parent method returns %s.", childType, parentType));
    }

    public void visit(MultiplicationExpression node)
    {
        visitChildren(node);

        Type leftType  = node.getLeftChild().getType();
        Type rightType = node.getRightChild().getType();

        if (leftType.equals(Type.NumberType) && rightType.equals(Type.NumberType))
        {
            node.setType(Type.NumberType);

            // Check for division by zero
            if (node.getOperator().equals(ArithmeticOperator.Division) && node.getRightChild() instanceof NumberLiteralNode)
            {
                if (((NumberLiteralNode) node.getRightChild()).getValue() == 0)
                    _symbolTableHandler.error(node, "Division by 0 is not allowed.");
            }
        }
        else
            _symbolTableHandler.error(node, String.format("%s operator cannot be used on %s and %s.", node.getOperator(), leftType, rightType));
    }

    public void visit(AdditionExpression node)
    {
        visitChildren(node);

        Type leftType  = node.getLeftChild().getType();
        Type rightType = node.getRightChild().getType();

        if (leftType.equals(Type.NumberType) && rightType.equals(Type.NumberType))
            node.setType(Type.NumberType);
        else if (leftType.equals(Type.StringType) || leftType.equals(Type.StringType))
            node.setType(Type.StringType);
        else if (leftType.equals(Type.CoordinatesType) && rightType.equals(Type.CoordinatesType))
            node.setType(Type.CoordinatesType);
        else
            _symbolTableHandler.error(node, String.format("%s operator cannot be used on %s and %s.", node.getOperator(), leftType, rightType));
    }

    public void visit(LogicExpressionNode node)
    {
        visitChildren(node);

        Type leftType  =  node.getLeftChild().getType();
        Type rightType = node.getRightChild().getType();

        if (!leftType.equals(Type.BoolType) || !rightType.equals(Type.BoolType))
            _symbolTableHandler.error(node, String.format("Both sides of the %s expression must be of type %s, but are of type %s and %s.", node.getOperator(), Type.BoolType, leftType, rightType));
    }

    public void visit(RelativeExpressionNode node)
    {
        visitChildren(node);

        Type leftType  = node.getLeftChild().getType();
        Type rightType = node.getRightChild().getType();

        boolean isNumberComparison = leftType.equals(Type.NumberType) && rightType.equals(Type.NumberType);
        boolean isStringComparison = leftType.equals(Type.StringType) && rightType.equals(Type.StringType);

        // Only number and string comparisons are allowed
        if (!isNumberComparison && !isStringComparison)
            _symbolTableHandler.error(node, String.format("Logical operator %s can not be used for types %s and %s.", node.getOperator(), leftType, rightType));
    }

    public void visit(EqualExpressionNode node)
    {
        visitChildren(node);

        Type leftType  = node.getLeftChild().getType();
        Type rightType = node.getRightChild().getType();

        // Only same type comparisons allowed
        // Unless either side is string, in which case any non-string will be cast to string
        if (leftType != rightType)
            _symbolTableHandler.error(node, String.format("Logical operator %s can not be used for types %s and %s.", node.getOperator(), leftType, rightType));
    }

    public void visit(NegateNode node)
    {
        visitChildren(node);

        if(!node.getChild().getType().equals(Type.BoolType))
            _symbolTableHandler.error(node, "Negated expression was not of boolean type.");
    }

    public void visit(TypeCastNode node)
    {
        visitChildren(node);

        Type fromType = node.getChild().getType();
        Type toType   = node.getType();

        if (fromType.equals(toType))
            _symbolTableHandler.warning(node, String.format("Redundant cast from %s to %s", fromType, toType));
        else if (!isExplicitCastAllowed(fromType, toType))
            _symbolTableHandler.error(node, String.format("Type %s cannot be cast to type %s.", fromType, toType));
    }

    private boolean isExplicitCastAllowed(Type fromType, Type toType)
    {
        if (toType.equals(Type.StringType))
            return true;

        return false;
    }
}
