package com.educode.visitors;

import com.educode.nodes.Typeable;
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
import com.educode.symboltable.Symbol;
import com.educode.symboltable.SymbolTableHandler;
import com.educode.types.ArithmeticOperator;
import com.educode.types.Type;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by zen on 4/5/17.
 */
public class ReturnVisitor extends VisitorBase
{
    private SymbolTableHandler _symbolTableHandler = new SymbolTableHandler();

    public SymbolTableHandler getSymbolTableHandler()
    {
        return _symbolTableHandler;
    }

    @Override
    public Object visit(ProgramNode node)
    {
        // Visit methods
        for (MethodDeclarationNode methodDecl : node.getMethodDeclarations())
        {
            visit(methodDecl);

            if (methodDecl.getType().Kind != Type.VOID && methodDecl.getType().Kind != Type.ERROR)
            {
                if (!methodDecl.getBlockNode().Returns)
                    _symbolTableHandler.error(node, String.format("Not all paths of method \"%s\" returns.", methodDecl.getIdentifier()));
            }
        }

        return null;
    }

    @Override
    public Object visit(BlockNode node)
    {
        boolean blockReturns = false;

        visitChildren(node);

        for (Node n: node.getChildren())
        {
            if(blockReturns)
                _symbolTableHandler.error(n, String.format("Line %i is unreacheable due to prior return.", n.getLineNumber()));

            if (n instanceof ReturnNode)
                blockReturns = true;

            else if(n instanceof IfNode)
            {
                boolean allPathsReturn = true;

                for (ConditionNode m: ((IfNode) n).getConditionBlocks()
                     )
                {
                    allPathsReturn = allPathsReturn && ((BlockNode)m.getRightChild()).Returns;
                }

                if (allPathsReturn)
                {
                    BlockNode elseBlock = ((IfNode) n).getElseBlock();
                    if (elseBlock == null)
                    {
                        allPathsReturn = false; // could do check to see if a condition is always hit?
                    } else
                        allPathsReturn = elseBlock.Returns;

                }

                blockReturns = blockReturns || allPathsReturn;
            }
        }
         node.Returns = blockReturns;
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
        return null;
    }

    @Override
    public Object visit(MethodDeclarationNode node)
    {
        // Visit block
        visit(node.getBlockNode());

        return null;
    }

    @Override
    public Object visit(MethodInvocationNode node) { return null; }

    @Override
    public Object visit(ParameterNode node) { return null; }

    @Override
    public Object visit(AssignmentNode node) { return null; }

    @Override
    public Object visit(VariableDeclarationNode node) { return null; }

    @Override
    public Object visit(IfNode node)
    {
        visitChildren(node);
        return null;
    }

    @Override
    public Object visit(ConditionNode node)
    {
        // Visit block
        visit(node.getRightChild());

        return null;
    }

    // Could maybe check if unconditional (always true) and then count inner returns?
    @Override
    public Object visit(RepeatWhileNode node) { return null; }

    @Override
    public Object visit(ReturnNode node) { return null; }

    @Override
    public Object visit(MultiplicationExpression node) { return null; }

    @Override
    public Object visit(AdditionExpression node) { return null; }

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
    public Object visit(IdentifierLiteralNode node) { return null; }

    @Override
    public Object visit(BoolLiteralNode node)
    {
        return null;
    }

    @Override
    public Object visit(OrExpressionNode node) { return null; }

    @Override
    public Object visit(AndExpressionNode node) { return null; }

    @Override
    public Object visit(RelativeExpressionNode node) { return null; }

    @Override
    public Object visit(EqualExpressionNode node) { return null; }

    @Override
    public Object visit(NegateNode node) { return null; }
}
