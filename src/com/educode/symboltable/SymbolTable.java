package com.educode.symboltable;

import java.*;
import java.util.ArrayList;

/**
 * Created by Thomas Buhl on 31/03/2017.
 */
public class SymbolTable {
    public SymbolTable outer;
    public ArrayList<Symbol> symbolList = new ArrayList<Symbol>();

    SymbolTable(SymbolTable _outer){
        outer = _outer;
    }
    SymbolTable(){
        outer = null;
    }

    Symbol getSymbol(String name){
        for (Symbol s:symbolList) {
            if(s.name.equals(name))
                return s;
        }
        if(outer != null)
            return outer.getSymbol(name);

        return null;
    }

}
