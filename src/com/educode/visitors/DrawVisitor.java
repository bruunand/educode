package com.educode.visitors;

import com.educode.helper.OperatorTranslator;
import com.educode.nodes.base.ListNode;
import com.educode.nodes.base.Node;
import com.educode.nodes.expression.AdditionExpression;
import com.educode.nodes.expression.MultiplicationExpression;
import com.educode.nodes.expression.logic.*;
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

        return String.format("BlockNode %s", blockContent.trim());
    }

    @Override
    public Object visit(ListNode node)
    {
        String listContent = " ";
        for (Node child : node.getChildren())
            listContent += "[" + visit(child) + "]";

        return String.format("ListNode %s", listContent.trim());
    }

    @Override
    public Object visit(ObjectInstantiationNode node)
    {
        return null;
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
        return null;
    }

    @Override
    public Object visit(ParameterNode node)
    {
        return String.format("Parameter [%s %s]", node.getIdentifier(), OperatorTranslator.toJava(node.getType()));
    }

    @Override
    public Object visit(AssignmentNode node)
    {
        return null;
    }

    @Override
    public Object visit(VariableDeclarationNode node)
    {
        return null;
    }

    @Override
    public Object visit(IfNode node)
    {
        return null;
    }

    @Override
    public Object visit(ConditionNode node)
    {
        return null;
    }

    @Override
    public Object visit(RepeatWhileNode node)
    {
        return null;
    }

    @Override
    public Object visit(ReturnNode node)
    {
        if (node.getChild() != null)
            return String.format("ReturnNode " + visit(node.getChild()));

        return null;
    }

    @Override
    public Object visit(MultiplicationExpression node)
    {
        return null;
    }

    @Override
    public Object visit(AdditionExpression node)
    {
        return String.format("[Addition [%s][Operator %s][%s]]", visit(node.getLeftChild()), OperatorTranslator.toJava(node.getOperator()), visit(node.getRightChild()));
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
        return String.format("Identifier [%s]", node.getIdentifier());
    }

    @Override
    public Object visit(BoolLiteralNode node)
    {
        return null;
    }

    @Override
    public Object visit(OrExpressionNode node)
    {
        return null;
    }

    @Override
    public Object visit(AndExpressionNode node)
    {
        return null;
    }

    @Override
    public Object visit(RelativeExpressionNode node)
    {
        return null;
    }

    @Override
    public Object visit(EqualExpressionNode node)
    {
        return null;
    }

    @Override
    public Object visit(NegateNode node)
    {
        return null;
    }

    @Override
    public Object visit(TypeCastNode node)
    {
        return null;
    }
}
