package com.educode.visitors;

import com.educode.nodes.expression.logic.*;
import com.educode.nodes.literal.BoolLiteralNode;
import com.educode.nodes.literal.IdentifierLiteralNode;
import com.educode.nodes.literal.NumberLiteralNode;
import com.educode.nodes.literal.StringLiteralNode;
import com.educode.nodes.method.MethodInvokationNode;
import com.educode.nodes.method.ParameterNode;
import com.educode.nodes.statement.ReturnNode;
import com.educode.nodes.statement.conditional.ConditionNode;
import com.educode.nodes.statement.conditional.IfNode;
import com.educode.nodes.statement.conditional.RepeatWhileNode;
import com.educode.nodes.ungrouped.BlockNode;
import com.educode.nodes.ungrouped.ProgramNode;
import com.educode.nodes.base.CollectionNode;
import com.educode.nodes.base.NaryNode;
import com.educode.nodes.base.Node;
import com.educode.nodes.expression.AdditionExpression;
import com.educode.nodes.expression.MultiplicationExpression;
import com.educode.nodes.method.MethodDeclarationNode;
import com.educode.nodes.statement.AssignmentNode;
import com.educode.nodes.statement.VariableDeclarationNode;

/**
 * Created by zen on 3/23/17.
 */
public class PrintVisitor extends VisitorBase
{
    @Override
    public String visit(ProgramNode node)
    {
        for (Node child : node.getChildren())
        {
            if (child instanceof NaryNode)
            {
                for (Node grandchild : ((NaryNode) child).getChildren())
                    visit(grandchild);
            }
            else
                visit(child);
        }

        return null;
    }

    @Override
    public String visit(MethodDeclarationNode node)
    {
        System.out.println("Declare: " + node.getIdentifier());

        visit(node.getLeftChild());

        return null;
    }

    @Override
    public Object visit(AssignmentNode node)
    {
        System.out.println("Assign " + node.getIdentifier() + " to " + node.getChild().getClass().getName());

        return null;
    }

    @Override
    public Object visit(VariableDeclarationNode node)
    {
        System.out.println("Declare: " + node.getIdentifier());
        if (node.getChild() != null)
            visit(node.getChild());

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
        System.out.println("ADD");

        return null;
    }

    @Override
    public Object visit(BlockNode node)
    {
        System.out.println("Visiting block");
        for (Node child : node.getChildren())
            visit(child);

        return null;
    }

    @Override
    public Object visit(CollectionNode node)
    {
        for (Node child : node.getChildren())
            visit(child);

        return null;
    }

    @Override
    public Object visit(MethodInvokationNode node)
    {
        System.out.println("Invoke method " + node.getIdentifier());

        if (node.getChild() != null)
            visit(node.getChild());

        return null;
    }

    @Override
    public Object visit(ParameterNode node)
    {
        return null;
    }

    @Override
    public Object visit(NumberLiteralNode node)
    {
        System.out.println("NUMBER LIT");

        return null;
    }

    @Override
    public Object visit(StringLiteralNode node)
    {
        System.out.println("STRING LIT");

        return null;
    }

    @Override
    public Object visit(IdentifierLiteralNode node)
    {
        System.out.println("IDENTIFIER LIT");

        return null;
    }

    @Override
    public Object visit(BoolLiteralNode node)
    {
        System.out.println("BOOL LIT");

        return null;
    }

    @Override
    public Object visit(IfNode node)
    {
        for (Node child : node.getChildren())
            visit(child);

        return null;
    }

    @Override
    public Object visit(ConditionNode node)
    {
        visit(node.getLeftChild());
        visit(node.getRightChild());

        return null;
    }

    @Override
    public Object visit(RepeatWhileNode node)
    {
        System.out.println("Repeat..");
        visit(node.getChild());

        return null;
    }

    @Override
    public Object visit(ReturnNode node)
    {
        return null;
    }

    @Override
    public Object visit(OrExpressionNode node)
    {
        System.out.println("OR");

        return null;
    }

    @Override
    public Object visit(AndExpressionNode node)
    {
        System.out.println("AND");

        return null;
    }

    @Override
    public Object visit(RelativeExpressionNode node)
    {
        System.out.println("REL");

        return null;
    }

    @Override
    public Object visit(EqualExpressionNode node)
    {
        System.out.println("EQL");

        visit(node.getLeftChild());
        visit(node.getRightChild());

        return null;
    }

    @Override
    public Object visit(NegateNode node)
    {
        System.out.println("NEGATE");

        return null;
    }
}
