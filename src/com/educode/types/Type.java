package com.educode.types;

/**
 * Created by zen on 3/10/17.
 */
public class Type
{
    public final byte Kind;
    public static final byte VOID = 0, BOOL = 1, NUMBER = 2, COORDINATES = 3, STRING = 4, ERROR = 5, REFERENCE = 6;

    public Type(byte kind)
    {
        this.Kind = kind;
    }

    @Override
    public boolean equals(Object o)
    {
        if (o instanceof Type)
            return ((Type)o).Kind == this.Kind;
        return false;
    }

    @Override
    public String toString()
    {
        switch (Kind)
        {
            case Type.NUMBER:
                return "NUMBER";
            case Type.STRING:
                return "STRING";
            case Type.BOOL:
                return "BOOLEAN";
            case Type.COORDINATES:
                return "COORDINATES";
            case Type.VOID:
                return "VOID";
            case Type.ERROR:
                return "ERROR";
            case Type.REFERENCE:
                return "REFERENCE";
            default:
                return "UNDEFINED"; // Should not happen
        }
    }

    public static final Type VoidType = new Type(VOID);
    public static final Type BoolType = new Type(BOOL);
    public static final Type NumberType = new Type(NUMBER);
    public static final Type CoordinatesType = new Type(COORDINATES);
    public static final Type StringType = new Type(STRING);
    public static final Type Error = new Type(ERROR);
    public static final Type Reference = new Type(REFERENCE);
}
