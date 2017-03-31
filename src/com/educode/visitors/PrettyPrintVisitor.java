package com.educode.visitors;

import com.educode.helper.OperatorTranslator;
import com.educode.nodes.base.ListNode;
import com.educode.nodes.base.NaryNode;
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

/**
 * Created by zen on 3/31/17.
 */
public class PrettyPrintVisitor extends VisitorBase
{
    private int depth = -1;

    private void print(String format, Object ... args)
    {
        for (int i = 0; i < depth; i++)
            System.out.print("  ");
        System.out.println(String.format("-> " + format, args));
    }

    @Override
    public Object visit(ProgramNode node)
    {
        depth++;

        print("Program '%s'", node.getIdentifier());

        for (Node child : node.getChildren())
            visit(child);

        depth--;

        return null;
    }

    @Override
    public Object visit(BlockNode node)
    {
        depth++;

        print("Block");
        visitChildren(node);

        depth--;

        return null;
    }

    @Override
    public Object visit(ListNode node)
    {
        depth++;

        print("List");

        for (Node child : node.getChildren())
            visit(child);

        depth--;

        return null;
    }

    @Override
    public Object visit(ObjectInstantiationNode node)
    {
        depth++;

        print("New instance of %s", OperatorTranslator.ToJava(node.getType()));

        depth--;

        return null;
    }

    @Override
    public Object visit(MethodDeclarationNode node)
    {
        depth++;

        System.out.println();
        print("Method '%s' returns %s", node.getIdentifier(), OperatorTranslator.ToJava(node.getType()));
        visitChildren(node);

        depth--;

        return null;
    }

    @Override
    public Object visit(MethodInvocationNode node)
    {
        depth++;

        print("Invoke method '%s'", node.getIdentifier());
        visitChild(node);
        
        depth--;

        return null;
    }

    @Override
    public Object visit(ParameterNode node)
    {
        depth++;

        print("Parameter '%s' of type %s", node.getIdentifier(), OperatorTranslator.ToJava(node.getType()));

        depth--;

        return null;
    }

    @Override
    public Object visit(AssignmentNode node)
    {
        depth++;

        print("Assign '%s' to:", node.getIdentifier());
        visit(node.getChild());

        depth--;

        return null;
    }

    @Override
    public Object visit(VariableDeclarationNode node)
    {
        depth++;

        print("Declare '%s' of type %s", node.getIdentifier(), OperatorTranslator.ToJava(node.getType()));
        visit(node.getChild());

        depth--;

        return null;
    }

    @Override
    public Object visit(IfNode node)
    {
        depth++;

        print("If-Statement");
        visitChildren(node);

        depth--;

        return null;
    }

    @Override
    public Object visit(ConditionNode node)
    {
        depth++;

        print("Condition");
        visitChildren(node);

        depth--;

        return null;
    }

    @Override
    public Object visit(RepeatWhileNode node)
    {
        depth++;

        print("Repeat-While");
        visitChild(node);

        depth--;

        return null;
    }

    @Override
    public Object visit(ReturnNode node)
    {
        depth++;

        print("Return");
        visitChild(node);

        depth--;

        return null;
    }

    @Override
    public Object visit(MultiplicationExpression node)
    {
        depth++;

        print("Multiplication expression");
        visitChildren(node);

        depth--;

        return null;
    }

    @Override
    public Object visit(AdditionExpression node)
    {
        depth++;

        print("Addition expression");
        visitChildren(node);

        depth--;

        return null;
    }

    @Override
    public Object visit(NumberLiteralNode node)
    {
        depth++;

        print("Number literal: %s", node.getValue());

        depth--;

        return null;
    }

    @Override
    public Object visit(StringLiteralNode node)
    {
        depth++;

        print("String literal: %s", node.getValue());

        depth--;

        return null;
    }

    @Override
    public Object visit(IdentifierLiteralNode node)
    {
        depth++;

        print("Identifier literal: %s", node.getIdentifier());

        depth--;

        return null;
    }

    @Override
    public Object visit(BoolLiteralNode node)
    {
        depth++;

        print("Boolean literal: %s", node.getValue());

        depth--;

        return null;
    }

    @Override
    public Object visit(OrExpressionNode node)
    {
        depth++;

        print("Or expression");
        visitChildren(node);

        depth--;

        return null;
    }

    @Override
    public Object visit(AndExpressionNode node)
    {
        depth++;

        print("And expression");
        visitChildren(node);

        depth--;

        return null;
    }

    @Override
    public Object visit(RelativeExpressionNode node)
    {
        depth++;

        print("Relative expression");
        visitChildren(node);

        depth--;

        return null;
    }

    @Override
    public Object visit(EqualExpressionNode node)
    {
        depth++;

        print("Equality expression");
        visitChildren(node);

        depth--;

        return null;
    }

    @Override
    public Object visit(NegateNode node)
    {
        depth++;

        print("Negation of:");
        visit(node.getChild());

        depth--;

        return null;
    }
}
