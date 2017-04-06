package com.educode.symboltable;

import com.educode.nodes.Identifiable;
import com.educode.nodes.base.Node;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Thomas Buhl on 31/03/2017.
 */
public class SymbolTableHandler
{
    public SymbolTable current = new SymbolTable();
    private List<Error> _errorList = new ArrayList<>();

    public void openScope()
    {
        current = new SymbolTable(current);
    }

    public void closeScope()
    {
        if(current.outer != null)
            current = current.outer;
        else
            error("Can not close scope when not within a scope.");
    }

    public void enterSymbol(Identifiable node)
    {
        boolean isNew = !current.contains(node);

        current.symbolList.add(new Symbol(node, isNew));

        // Add an error for multiple declaration
        if (!isNew)
            error((Node) node, String.format("Identifier %s already declared.", node.getIdentifier()));
        // todo: Should not be identifiable in parameter, we need to know line number which is contained in node
    }

    public Symbol retreiveSymbol(Node node)
    {
        return current.getSymbol(node);
    }

    //needs modification
    public boolean declaredLocally(Node node)
    {
        for (Symbol s : current.symbolList)
        {
            if (s.equals(node))
                return true;
        }

        return false;
    }

    public void printErrors()
    {
        for (Error error : _errorList)
            System.out.println(error);
    }

    private void error(String description)
    {
        error(null, description);
    }

    public void error(Node relatedNode, String description)
    {
        this._errorList.add(new Error(relatedNode, description));
    }
}
