package com.educode.symboltable;

/**
 * Created by Thomas Buhl on 31/03/2017.
 */
public class FuncSymbol extends Symbol{
    String type;
    String parameters;

    FuncSymbol(String _name, String _type, String _parameters){
        super(_name, _type);
        parameters = _parameters;
    }

    public boolean Equals(Symbol other){
        if (other instanceof FuncSymbol)
            return name.equals(other.name) && parameters.equals(((FuncSymbol) other).parameters);
        else
            return false;
    }
}
