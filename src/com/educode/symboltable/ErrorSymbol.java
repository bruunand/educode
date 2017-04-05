package com.educode.symboltable;

/**
 * Created by Thomas Buhl on 04/04/2017.
 */
public class ErrorSymbol
{
    private Symbol duplicate;

    public ErrorSymbol(Symbol symbol)
    {
        this.duplicate = symbol;
    }
}
