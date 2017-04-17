package com.educode.symboltable;

import com.educode.Referencing;
import com.educode.antlr.EduCodeParser;
import com.educode.nodes.base.ListNode;
import com.educode.nodes.base.Node;
import com.educode.nodes.method.MethodDeclarationNode;
import com.educode.nodes.method.MethodInvocationNode;
import com.educode.nodes.method.ParameterNode;
import com.educode.nodes.referencing.IdentifierReferencing;
import com.educode.types.Type;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by User on 15-Apr-17.
 */
public class SymbolTable
{
    private SymbolTable _outer;

    private final List<Symbol> _symbolList = new ArrayList();

    public SymbolTable(SymbolTable outer)
    {
        this._outer = outer;
    }

    public SymbolTable getOuter()
    {
        return this._outer;
    }

    private Symbol retrieveIdentifierSymbol(IdentifierReferencing identifier)
    {
        for (Symbol symbol : this._symbolList)
        {
            if (!(symbol.getReference() instanceof IdentifierReferencing))
                continue;

            // Check if text matches
            IdentifierReferencing otherIdentifier = (IdentifierReferencing) symbol.getReference();
            if (identifier.getText().equals(otherIdentifier.getText()))
                return symbol;
        }

        return null;
    }

    private Symbol retrieveMethodDeclarationSymbol(MethodDeclarationNode node)
    {
        for (Symbol symbol : this._symbolList)
        {
            if (!(symbol.getSourceNode() instanceof MethodDeclarationNode))
                continue;

            if ((symbol.getSourceNode()).equals(node))
                return symbol;
        }

        return null;
    }

    private Symbol retrieveMethodDeclarationSymbol(MethodInvocationNode requestee)
    {
        for (Symbol symbol : this._symbolList)
        {
            if (!(symbol.getSourceNode() instanceof MethodDeclarationNode))
                continue;

            if (((MethodDeclarationNode) symbol.getSourceNode()).correspondsWith(requestee))
                return symbol;
        }

        return null;
    }

    public void addDefaultMethod(String name, Type returnType, Type ... parameterTypes)
    {
        ListNode parameterNodes = new ListNode();
        for (Type type : parameterTypes)
            parameterNodes.addChild(new ParameterNode(null, type));

        IdentifierReferencing reference = new IdentifierReferencing(name);
        MethodDeclarationNode node = new MethodDeclarationNode(parameterNodes, null, reference, returnType);

        this.insert(new Symbol(reference, node));
    }

    public void insert(Symbol symbol)
    {
        this._symbolList.add(symbol);
    }

    public Symbol retrieveSymbol(Node origin)
    {
        Symbol ans;

        if (origin instanceof IdentifierReferencing)
            ans = retrieveIdentifierSymbol((IdentifierReferencing) origin);
        else if (origin instanceof MethodDeclarationNode)
            ans = retrieveMethodDeclarationSymbol((MethodDeclarationNode) origin);
        else if (origin instanceof MethodInvocationNode)
            ans = retrieveMethodDeclarationSymbol((MethodInvocationNode) origin);
        else if (origin instanceof Referencing && ((Referencing) origin).getReference() instanceof IdentifierReferencing)
            ans = retrieveIdentifierSymbol((IdentifierReferencing) ((Referencing) origin).getReference());
        else
        {
            System.out.println("No retriever for " + origin.getClass().getName());
            return null;
        }

        // Look in outer symbol table, otherwise return null
        if (ans == null && getOuter() != null)
            return getOuter().retrieveSymbol(origin);
        else
            return ans;
    }
}