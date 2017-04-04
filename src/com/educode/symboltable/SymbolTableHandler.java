package com.educode.symboltable;

import java.util.ArrayList;

/**
 * Created by Thomas Buhl on 31/03/2017.
 */
public class SymbolTableHandler {
    public SymbolTable current = new SymbolTable();
    public ArrayList<ErrorSymbol> ErrorList = new ArrayList<ErrorSymbol>();

    public void openScope(){
        current = new SymbolTable(current);
    }

    public void closeScope(){
        if(current.outer != null)
            current = current.outer;
        else
            error();
    }

    public void enterSymbol(Symbol symbol){
        boolean symbolExists = current.contains(symbol);

        if (!symbolExists)
            current.symbolList.add(symbol);
        else
            ErrorList.add(new ErrorSymbol(symbol));
    }

    public Symbol retreiveSymbol(String name){
        return current.getSymbol(name);
    }

    //needs modification
    public boolean declaredLocally(String name){
        for (Symbol s : current.symbolList) {
            if (s.name.equals(name))
                return true;
        }
        return false;
    }

    // not yet implemented
    public void error(){}
}
