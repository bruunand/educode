package com.educode.symboltable;

import com.sun.org.apache.xpath.internal.operations.Equals;

/**
 * Created by Thomas Buhl on 31/03/2017.
 */
public abstract class Symbol
{
    private String name;
    private String type;

    public Symbol(String name, String type)
    {
        this.name = name;
        this.type = type;
    }

    public String getName()
    {
        return this.name;
    }

    public boolean Equals(Symbol other)
    {
        return this.equals(other);
    }
}
