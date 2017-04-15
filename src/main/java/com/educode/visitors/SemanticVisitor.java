package com.educode.visitors;

import com.educode.nodes.base.Node;
import com.educode.nodes.method.MethodDeclarationNode;
import com.educode.nodes.referencing.ArrayReferencingNode;
import com.educode.nodes.referencing.IdentifierReferencing;
import com.educode.nodes.statement.AssignmentNode;
import com.educode.nodes.statement.VariableDeclarationNode;
import com.educode.nodes.ungrouped.BlockNode;
import com.educode.nodes.ungrouped.ProgramNode;
import com.educode.symboltable.Symbol;
import com.educode.symboltable.SymbolTableHandler;
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
        visitChildren(node);

        getSymbolTableHandler().closeScope();
    }

    public void visit(MethodDeclarationNode node)
    {
        getSymbolTableHandler().openScope();

        // Enter symbol
        getSymbolTableHandler().enterSymbol(node);
        visitChildren(node);

        getSymbolTableHandler().closeScope();
    }

    public void visit(BlockNode node)
    {
        getSymbolTableHandler().openScope();

        visitChildren(node);

        getSymbolTableHandler().closeScope();
    }

    public void visit(AssignmentNode node)
    {
        visit(node.getReference());
        visitChildren(node);

        // Get referencing symbol
        Symbol referencingSymbol = getSymbolTableHandler().getCurrent().retrieveSymbol(node.getReference());
        if (referencingSymbol == null)
            getSymbolTableHandler().error(node, "Reference %s is not declared.", node.getReference());
        else
        {
            // Symbol was found - now set the type of the reference to the type of the symbol we just found
            node.getReference().setType(referencingSymbol.getSourceNode().getType());

            // Check if left side types matches right side type
            if (!node.getReference().isType(node.getChild().getType()))
                getSymbolTableHandler().error(node, "Cannot assign %s, which is of type %s, to an expression of type %s.", node.getReference(), node.getReference().getType(), node.getChild().getType());
        }
    }

    public void visit(ArrayReferencingNode node)
    {
        visitChildren(node);

        // Left side must be a collection
        if (!node.getLeftChild().getType().isCollection())
            getSymbolTableHandler().error(node, "Left side of array reference must be a collection.");
    }

    public void visit(VariableDeclarationNode node)
    {
        if (!(node.getReference() instanceof IdentifierReferencing))
            getSymbolTableHandler().error(node, "A variable declaration cannot reference a struct or an array.");
        else
            getSymbolTableHandler().enterSymbol(node);
    }
}
