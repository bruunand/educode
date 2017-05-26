package com.educode.visitors.semantic;

import com.educode.nodes.base.NaryNode;
import com.educode.nodes.base.Node;
import com.educode.nodes.method.MethodDeclarationNode;
import com.educode.nodes.statement.ForEachNode;
import com.educode.nodes.statement.ReturnNode;
import com.educode.nodes.statement.conditional.ConditionNode;
import com.educode.nodes.statement.conditional.IfNode;
import com.educode.nodes.statement.conditional.RepeatWhileNode;
import com.educode.nodes.ungrouped.BlockNode;
import com.educode.nodes.ungrouped.ProgramNode;
import com.educode.nodes.ungrouped.StartNode;
import com.educode.symboltable.SymbolTableHandler;
import com.educode.types.Type;
import com.educode.visitors.VisitorBase;

/**
 * Created by User on 16-Apr-17.
 */
public class ReturnCheckVisitor extends VisitorBase
{
    private final SymbolTableHandler _symbolTableHandler;

    private SymbolTableHandler getSymbolTableHandler()
    {
        return this._symbolTableHandler;
    }

    public ReturnCheckVisitor(SymbolTableHandler symbolTableHandler)
    {
        this._symbolTableHandler = symbolTableHandler;
    }

    public void visit(StartNode node)
    {
        visit(node.getRightChild());
    }

    public void visit(ProgramNode node)
    {
        // Visit methods
        for (MethodDeclarationNode methodDecl : node.getMethodDeclarations())
        {
            visit(methodDecl);

            if (!methodDecl.isType(Type.VoidType) && !methodDecl.isType(Type.Error) )
            {
                if (!methodDecl.getBlockNode().getDoesReturn())
                    _symbolTableHandler.semanticError(methodDecl, String.format("Not all paths of method '%s' return a value.", methodDecl.getReference()));
            }
        }
    }

    public void visit(MethodDeclarationNode node)
    {
        visit(node.getBlockNode());
    }

    public void visit(BlockNode node)
    {
        boolean blockReturns = false;

        visitChildren(node);

        for (Node child : node.getChildren())
        {
            if (blockReturns)
                _symbolTableHandler.semanticError(child, String.format("Line %d is unreacheable due to prior return.", child.getLineNumber()));

            if (child instanceof ReturnNode)
                blockReturns = true;
            else if (child instanceof IfNode)
            {
                boolean allPathsReturn = true;

                for (ConditionNode m: ((IfNode) child).getConditionBlocks())
                    allPathsReturn = allPathsReturn && ((BlockNode)m.getRightChild()).getDoesReturn();

                if (allPathsReturn)
                {
                    BlockNode elseBlock = ((IfNode) child).getElseBlock();
                    // could do check to see if a condition is always hit?
                    allPathsReturn = elseBlock != null && elseBlock.getDoesReturn();
                }

                blockReturns = blockReturns || allPathsReturn;
            }
        }

        node.setDoesReturn(blockReturns);
    }

    public void visit(IfNode node)
    {
        visitChildren(node);
    }

    public void visit(ConditionNode node)
    {
        visit(node.getRightChild());
    }

    public void visit(RepeatWhileNode node)
    {
        // TODO: // Could maybe check if unconditional (always true) and then count inner returns?
    }

    public void visit(ForEachNode node)
    {
        // TODO: Do we need to check this?
    }

    public void visit(NaryNode node)
    {
        visitChildren(node);
    }

    @Override
    public Object defaultVisit(Node node)
    {
        return null;
    }
}
