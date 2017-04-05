package com.educode.symboltable;

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

    public Symbol getSymbol(String name)
    {
        for (Symbol s:symbolList)
        {
            if(s.getName().equals(name))
                return s;
        }

        if(outer != null)
            return outer.getSymbol(name);

        return null;
    }

    public boolean contains(Symbol test)
    {
        for (Symbol s:symbolList)
        {
            if(s.Equals(test))
                return true;
        }

        if(outer != null)
            return outer.contains(test);

        return false;
    }


}
