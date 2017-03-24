package com.educode.visitors;

import com.educode.nodes.base.CollectionNode;
import com.educode.nodes.expression.AdditionExpression;
import com.educode.nodes.expression.MultiplicationExpression;
import com.educode.nodes.expression.logic.*;
import com.educode.nodes.literal.BoolLiteralNode;
import com.educode.nodes.literal.IdentifierLiteralNode;
import com.educode.nodes.literal.NumberLiteralNode;
import com.educode.nodes.literal.StringLiteralNode;
import com.educode.nodes.method.MethodDeclarationNode;
import com.educode.nodes.method.MethodInvokationNode;
import com.educode.nodes.method.ParameterNode;
import com.educode.nodes.statement.AssignmentNode;
import com.educode.nodes.statement.ReturnNode;
import com.educode.nodes.statement.VariableDeclarationNode;
import com.educode.nodes.statement.conditional.ConditionNode;
import com.educode.nodes.statement.conditional.IfNode;
import com.educode.nodes.statement.conditional.RepeatWhileNode;
import com.educode.nodes.ungrouped.BlockNode;
import com.educode.nodes.ungrouped.ProgramNode;

/**
 * Created by zen on 3/24/17.
 */
public class SemanticVisitor extends VisitorBase
{
    @Override
    public Object visit(ProgramNode node)
    {
        return null;
    }

    @Override
    public Object visit(BlockNode node)
    {
        return null;
    }

    @Override
    public Object visit(CollectionNode node)
    {
        return null;
    }

    @Override
    public Object visit(MethodDeclarationNode node)
    {
        return null;
    }

    @Override
    public Object visit(MethodInvokationNode node)
    {
        return null;
    }

    @Override
    public Object visit(ParameterNode node)
    {
        return null;
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
        return null;
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
}
