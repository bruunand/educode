package com.educode.symboltable;

/**
 * Created by Thomas Buhl on 31/03/2017.
 */
public class FuncSymbol extends Symbol{
    String type;
    String parameters;

    FuncSymbol(String name, String _type, String Parameters){
        super(name);
        type = _type;
        parameters = Parameters;
    }

}
