package com.educode.types;

/**
 * Created by zen on 3/10/17.
 */
public class Type
{
    private byte _kind;
    public static final byte VOID = 0, BOOL = 1, NUMBER = 2, COORDINATES = 3, STRING = 4, ERROR = 5;

    public Type(byte kind)
    {
        this._kind = kind;
    }

    @Override
    public boolean equals(Object o)
    {
        if (o instanceof Type)
            return ((Type)o)._kind == this._kind;
        return false;
    }

    public static final Type VoidType = new Type(VOID);
    public static final Type BoolType = new Type(BOOL);
    public static final Type NumberType = new Type(NUMBER);
    public static final Type CoordinatesType = new Type(COORDINATES);
    public static final Type StringType = new Type(STRING);
    public static final Type Error = new Type(ERROR);
}
