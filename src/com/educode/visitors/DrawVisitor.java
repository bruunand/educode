package com.educode.visitors;

import com.educode.helper.OperatorTranslator;
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
import com.educode.nodes.statement.ReturnNode;
import com.educode.nodes.statement.VariableDeclarationNode;
import com.educode.nodes.statement.conditional.ConditionNode;
import com.educode.nodes.statement.conditional.IfNode;
import com.educode.nodes.statement.conditional.RepeatWhileNode;
import com.educode.nodes.ungrouped.BlockNode;
import com.educode.nodes.ungrouped.ObjectInstantiationNode;
import com.educode.nodes.ungrouped.ProgramNode;
import com.educode.nodes.ungrouped.TypeCastNode;

/**
 * Created by zen on 3/31/17.
 */
public class DrawVisitor extends VisitorBase
{
    @Override
    public Object visit(ProgramNode node)
    {
        String content = "";
        for (Node child : node.getChildren())
            content += "[" + visit(child) + "]";

        return String.format("[%s %s]", node.getIdentifier(), content);
    }

    @Override
    public Object visit(BlockNode node)
    {
        String blockContent = " ";
        for (Node child : node.getChildren())
            blockContent += "[" + visit(child) + "]";

        return String.format("BlockNode %s", blockContent);
    }

    @Override
    public Object visit(ListNode node)
    {
        String listContent = " ";
        for (Node child : node.getChildren())
            listContent += "[" + visit(child) + "]";

        return String.format("ListNode %s", listContent);
    }

    @Override
    public Object visit(ObjectInstantiationNode node)
    {
        return String.format("ObjectInstantiation [%s][%s]", node.getType(), node.hasChild() ? visit(node.getChild()) : "null");
    }

    @Override
    public Object visit(MethodDeclarationNode node)
    {
        if (node.hasParameterList())
            return String.format("%s [%s][%s]", node.getIdentifier(), visit(node.getBlockNode()), visit(node.getParameterList()));
        else
            return String.format("%s [%s]", node.getIdentifier(), visit(node.getBlockNode()));
    }

    @Override
    public Object visit(MethodInvocationNode node)
    {
        return String.format("MethodInv [%s][%s]", node.getIdentifier(), visit(node.getChild()));
    }

    @Override
    public Object visit(ParameterNode node)
    {
        return String.format("Parameter [%s %s]", node.getIdentifier(), OperatorTranslator.toJava(node.getType()));
    }

    @Override
    public Object visit(AssignmentNode node)
    {
        return visit(node.getChild());
    }

    @Override
    public Object visit(VariableDeclarationNode node)
    {
        if (!node.hasChild())
            return String.format("Declare %s %s", node.getIdentifier(), node.getType());
        else
            return String.format("Decl/Assign [%s %s][%s]", node.getIdentifier(), node.getType(), visit(node.getChild()));
    }

    @Override
    public Object visit(IfNode node)
    {
        String print = "If";
        for (Node child : node.getChildren())
            print += String.format("[%s]", visit(child));

        return print;
    }

    @Override
    public Object visit(ConditionNode node)
    {
        return String.format("Condition [%s][%s]", visit(node.getLeftChild()), visit(node.getRightChild()));
    }

    @Override
    public Object visit(RepeatWhileNode node)
    {

        return String.format("RepeatWhile [%s]", visit(node.getChild()));
    }

    @Override
    public Object visit(ReturnNode node)
    {
        if (node.getChild() != null)
            return String.format("Return [%s]", visit(node.getChild()));

        return "Return";
    }

    @Override
    public Object visit(MultiplicationExpression node)
    {
        return String.format("Mulitiplication [%s][Operator %s][%s]", visit(node.getLeftChild()), OperatorTranslator.toJava(node.getOperator()), visit(node.getRightChild()));
    }

    @Override
    public Object visit(AdditionExpression node)
    {
        return String.format("Addition [%s][Operator %s][%s]", visit(node.getLeftChild()), OperatorTranslator.toJava(node.getOperator()), visit(node.getRightChild()));
    }

    @Override
    public Object visit(NumberLiteralNode node)
    {
        return String.format("NumLit [%s]", node.getValue());
    }

    @Override
    public Object visit(StringLiteralNode node)
    {
        return "StringLit";
    }

    @Override
    public Object visit(IdentifierLiteralNode node)
    {
        return String.format("Identifier [%s]", node.getIdentifier());
    }

    @Override
    public Object visit(BoolLiteralNode node)
    {
        return String.format("BoolLit [%s]", node.getValue());
    }

    @Override
    public Object visit(CoordinatesLiteralNode node)
    {
        return String.format("Coordinates [%s][%s][%s]", visit(node.getX()), visit(node.getY()), visit(node.getZ()));
    }

    @Override
    public Object visit(OrExpressionNode node)
    {
        return String.format("%s [%s][%s]", node.getOperator(), visit(node.getLeftChild()), visit(node.getRightChild()));
    }

    @Override
    public Object visit(AndExpressionNode node)
    {
        return String.format("%s [%s][%s]", node.getOperator(), visit(node.getLeftChild()), visit(node.getRightChild()));
    }

    @Override
    public Object visit(RelativeExpressionNode node)
    {
        return String.format("%s [%s][%s]", node.getOperator(), visit(node.getLeftChild()), visit(node.getRightChild()));
    }

    @Override
    public Object visit(EqualExpressionNode node)
    {
        return String.format("%s [%s][%s]", node.getOperator(), visit(node.getLeftChild()), visit(node.getRightChild()));
    }

    @Override
    public Object visit(NegateNode node)
    {
        return String.format("not [%s]",  visit(node.getChild()));
    }

    @Override
    public Object visit(TypeCastNode node)
    {
        return String.format("TypeCast [%s][%s]", node.getType(), visit(node.getChild()));
    }
}
