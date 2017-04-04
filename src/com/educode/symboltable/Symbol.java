package com.educode.symboltable;

import com.sun.org.apache.xpath.internal.operations.Equals;

/**
 * Created by Thomas Buhl on 31/03/2017.
 */
public abstract class Symbol {
    String name;
    String type;

    Symbol(String _name, String _type){
        name = _name;
        type = _type;
    }

    public boolean Equals(Symbol other){return this.equals((Object)other);}
}
