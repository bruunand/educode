package com.educode.visitors;

import com.educode.helper.OperatorTranslator;
import com.educode.nodes.base.ListNode;
import com.educode.nodes.base.Node;
import com.educode.nodes.expression.ArithmeticExpressionNode;
import com.educode.nodes.expression.UnaryMinusNode;
import com.educode.nodes.expression.logic.*;
import com.educode.nodes.literal.*;
import com.educode.nodes.method.MethodDeclarationNode;
import com.educode.nodes.method.MethodInvocationNode;
import com.educode.nodes.method.ParameterNode;
import com.educode.nodes.referencing.ArrayReferencingNode;
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

/**
 * Created by User on 15-Apr-17.
 */
public class PrintVisitor extends VisitorBase
{
    private boolean _hasVisitedStartNode = false;

    @Override
    public Object defaultVisit(Node node)
    {
        System.out.println("No visitor for node:" + node.getClass().getName());

        return null;
    }

    public Object visit(StartNode node)
    {
        return String.format("[StartNode [%s][%s]]", visit(node.getLeftChild()), visit(node.getRightChild()));
    }

    public Object visit(ImportNode node)
    {
        if (node.getImportedNode() != null)
            return String.format("ImportNode %s", node.getText());
        else
            return "ImportNode N/A";
    }

    public Object visit(UsingsNode node)
    {
        StringBuilder content = new StringBuilder();
        for (Node child : node.getChildren())
            content.append(String.format("[%s]", visit(child)));

        return String.format("UsingsNode %s", content.toString());
    }

    public Object visit(ProgramNode node)
    {
        StringBuilder content = new StringBuilder();
        for (Node child : node.getChildren())
            content.append(String.format("[%s]", visit(child)));

        return String.format("ProgramNode [%s]%s", visit(node.getReference()), content.toString());
    }

    public Object visit(EventDefinitionNode node)
    {
        return String.format("EventDefinition [%s][%s]", node.getEventType().getName(), node.getReference());
    }

    public Object visit(BlockNode node)
    {
        String blockContent = "";
        for (Node child : node.getChildren())
            blockContent += "[" + visit(child) + "]";

        return String.format("BlockNode %s", blockContent);
    }

    public Object visit(ListNode node)
    {
        String listContent = "";
        for (Node child : node.getChildren())
            listContent += "[" + visit(child) + "]";

        return String.format("ListNode %s", listContent);
    }

    public Object visit(ObjectInstantiationNode node)
    {
        return String.format("ObjectInstantiation [%s][%s]", node.getType(), node.hasChild() ? visit(node.getChild()) : "null");
    }

    public Object visit(MethodInvocationNode node)
    {
        if (node.hasChild())
            return String.format("MethodInv [%s][%s]", visit(node.getReference()), visit(node.getChild()));
        else
            return String.format("MethodInv [%s]", visit(node.getReference()));
    }

    public Object visit(ParameterNode node)
    {
        return String.format("Parameter [%s %s]",  visit(node.getReference()), node.getType());
    }

    public Object visit(MethodDeclarationNode node)
    {
        if (node.hasParameterList())
            return String.format("MethodDeclaration [%s][%s][%s]", visit(node.getReference()), visit(node.getBlockNode()), visit(node.getParameterList()));
        else
            return String.format("MethodDeclaration [%s][%s]", visit(node.getReference()), visit(node.getBlockNode()));
    }

    public Object visit(VariableDeclarationNode node)
    {
        if (!node.hasChild())
            return String.format("Declare [%s] [Type %s]", visit(node.getReference()), node.getType());
        else
            return String.format("Decl/Assign [%s][Type %s][%s]", visit(node.getReference()), node.getType(), visit(node.getChild()));
    }

    public Object visit(IfNode node)
    {
        String print = "If";
        for (Node child : node.getChildren())
            print += String.format("[%s]", visit(child));

        return print;
    }

    public Object visit(ConditionNode node)
    {
        return String.format("Condition [%s][%s]", visit(node.getLeftChild()), visit(node.getRightChild()));
    }

    public Object visit(IdentifierReferencingNode node)
    {
        return String.format("Identifier %s", node.getText());
    }

    public Object visit(RepeatWhileNode node)
    {
        return String.format("RepeatWhile [%s]", visit(node.getChild()));
    }

    public Object visit(ForEachNode node)
    {
        return String.format("ForEach [%s][%s][%s][%s]", visit(node.getReference()), node.getType(), visit(node.getLeftChild()), visit(node.getRightChild()));
    }

    public Object visit(ReturnNode node)
    {
        if (node.getChild() != null)
            return String.format("Return [%s]", visit(node.getChild()));

        return "Return";
    }

    public Object visit(AssignmentNode node)
    {
        return String.format("Assign [%s][%s]", visit(node.getReference()), visit(node.getChild()));
    }

    public Object visit(ArithmeticExpressionNode node)
    {
        return String.format("Arithmetic [%s][Operator %s][%s]", visit(node.getLeftChild()), OperatorTranslator.toJava(node.getOperator()), visit(node.getRightChild()));
    }

    public Object visit(NumberLiteralNode node)
    {
        return String.format("NumLit [%s]", node.getValue());
    }

    public Object visit(StringLiteralNode node)
    {
        return "StringLit";
    }

    public Object visit(NullLiteralNode node)
    {
        return "null";
    }

    public Object visit(BoolLiteralNode node)
    {
        return String.format("BoolLit [%s]", node.getValue());
    }

    public Object visit(CoordinatesLiteralNode node)
    {
        return String.format("Coordinates [%s][%s][%s]", visit(node.getX()), visit(node.getY()), visit(node.getZ()));
    }

    public Object visit(StructReferencingNode node)
    {
        return String.format("StructReferencing [%s][%s]", visit(node.getLeftChild()), visit(node.getRightChild()));
    }

    public Object visit(ArrayReferencingNode node)
    {
        return String.format("ArrayReferencing [%s][%s]", visit(node.getLeftChild()), visit(node.getRightChild()));
    }

    public Object visit(LogicalExpressionNode node)
    {
        return String.format("%s [%s][%s]", node.getOperator(), visit(node.getLeftChild()), visit(node.getRightChild()));
    }

    public Object visit(NegateNode node)
    {
        return String.format("Negate [%s]", visit(node.getChild()));
    }

    public Object visit(UnaryMinusNode node)
    {
        return String.format("UnaryMinus [%s]", visit(node.getChild()));
    }

    public Object visit(TypeCastNode node)
    {
        return String.format("TypeCast [%s][%s]", node.getType(), visit(node.getChild()));
    }
}
