package com.educode.nodes;

import com.educode.types.Type;

/**
 * Created by User on 15-Apr-17.
 */
public interface ITypeable
{
    Type getType();
    void setType(Type type);
    boolean isType(Type type);
}
