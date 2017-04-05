package com.educode.symboltable;

/**
 * Created by Thomas Buhl on 31/03/2017.
 */
public class FuncSymbol extends Symbol
{
    private String type;
    private String parameters;

    public FuncSymbol(String name, String type, String parameters)
    {
        super(name, type);
        this.parameters = parameters;
    }

    public boolean Equals(Symbol other)
    {
        if (other instanceof FuncSymbol)
            return getName().equals(other.getName()) && parameters.equals(((FuncSymbol) other).parameters);
        else
            return false;
    }
}
