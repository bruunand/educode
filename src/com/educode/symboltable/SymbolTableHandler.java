package com.educode.symboltable;

import com.educode.nodes.Identifiable;
import com.educode.nodes.base.Node;

import java.util.ArrayList;

/**
 * Created by Thomas Buhl on 31/03/2017.
 */
public class SymbolTableHandler
{
    public SymbolTable current = new SymbolTable();

    public void openScope()
    {
        current = new SymbolTable(current);
    }

    public void closeScope()
    {
        if(current.outer != null)
            current = current.outer;
        else
            error();
    }

    public void enterSymbol(Identifiable node)
    {
        boolean isNew = !current.contains(node);

        current.symbolList.add(new Symbol(node, isNew));
    }


    public Symbol retreiveSymbol(Node node)
    {
        return current.getSymbol(node);
    }


    //needs modification
    public boolean declaredLocally(Node node)
    {
        for (Symbol s : current.symbolList) {
            if (s.equals(node))
                return true;
        }
        return false;
    }

    // not yet implemented
    public void error(){}
}
