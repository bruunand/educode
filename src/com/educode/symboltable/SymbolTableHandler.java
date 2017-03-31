package com.educode.symboltable;

/**
 * Created by Thomas Buhl on 31/03/2017.
 */
public class SymbolTableHandler {
    public SymbolTable current = new SymbolTable();

    public void openScope(){
        current = new SymbolTable(current);
    }

    public void closeScope(){
        if(current.outer != null)
            current = current.outer;
        else
            error();

    }

    // cant handle overloading yet
    public void enterSymbol(Symbol symbol){
        Symbol t = retreiveSymbol(symbol.name);
        
        if (t == null)
            current.symbolList.add(symbol);
        else
            error();
    }

    public Symbol retreiveSymbol(String name){
        return current.getSymbol(name);
    }

    public boolean declaredLocally(String name){
        for (Symbol s : current.symbolList) {
            if (s.name.equals(name))
                return true;
        }
        return false;
    }

    public void error(){}
}
