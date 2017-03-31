package com.educode.symboltable;

/**
 * Created by Thomas Buhl on 31/03/2017.
 */
public class VarSymbol extends Symbol{
    String type;
    VarSymbol(String name, String _type){
        super(name);
        type = _type;
    }
}
