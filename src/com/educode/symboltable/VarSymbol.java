package com.educode.symboltable;

/**
 * Created by Thomas Buhl on 31/03/2017.
 */
public class VarSymbol extends Symbol{
    VarSymbol(String _name, String _type)
    {
        super(_name, _type);
    }


    public boolean Equals(Symbol other)
    {
        if (other instanceof VarSymbol)
            return getName().equals(other.getName());
        else
            return false;
    }

}
