package com.educode.symboltable;

import com.educode.nodes.base.Node;
import com.educode.nodes.referencing.IdentifierReferencing;
import com.educode.nodes.referencing.Reference;
import org.apache.http.impl.io.IdentityInputStream;

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

    private Symbol retrieveSymbol(IdentifierReferencing identifier)
    {
        // Look for previous entry
        for (Symbol symbol : this._symbolList)
        {
            if (!(symbol.getReference() instanceof IdentifierReferencing))
                continue;

            // Check if text matches
            IdentifierReferencing otherIdentifier = (IdentifierReferencing) symbol.getReference();
            if (identifier.getText().equals(otherIdentifier.getText()))
                return symbol;
        }

        // Look in previous symbol table, otherwise return null
        if (getOuter() != null)
            return getOuter().retrieveSymbol(identifier);
        else
            return null;
    }

    public void insert(Symbol symbol)
    {
        this._symbolList.add(symbol);
    }

    public Symbol retrieveSymbol(Reference reference)
    {
        if (reference instanceof IdentifierReferencing)
            return retrieveSymbol((IdentifierReferencing) reference);
        else
            System.out.println("No retriever for " + reference.getClass().getName());

        return null;
    }
}