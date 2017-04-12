package com.educode.symboltable;

import com.educode.nodes.Identifiable;
import com.educode.nodes.base.Node;

import java.util.ArrayList;

/**
 * Created by Thomas Buhl on 31/03/2017.
 */
public class SymbolTable
{
    public SymbolTable outer;
    public ArrayList<Symbol> symbolList = new ArrayList<Symbol>();

    public SymbolTable(SymbolTable outer)
    {
        this.outer = outer;
    }

    public SymbolTable()
    {
        this(null);
    }

    public Symbol getSymbol(Node node)
    {
        for (Symbol s : symbolList)
        {
            if (s.corresponds(node))
                return s;
        }

        if (outer != null)
            return outer.getSymbol(node);

        return null;
    }

    public boolean contains(Identifiable node)
    {
        for (Symbol s : symbolList)
        {
            if(s.equals(node))
                return true;
        }

        if(outer != null)
            return outer.contains(node);

        return false;
    }


}
