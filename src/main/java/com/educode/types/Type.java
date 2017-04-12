package com.educode.types;

/**
 * Created by zen on 3/10/17.
 */
public class Type
{
    private Type _childType = null;

    public final byte Kind;
    public static final byte VOID = 0, BOOL = 1, NUMBER = 2, COORDINATES = 3, STRING = 4, ERROR = 5, REFERENCE = 6, COLLECTION = 7;

    public Type(byte kind)
    {
        this.Kind = kind;
    }

    public Type(Type child)
    {
        this._childType = child;
        this.Kind = COLLECTION;
    }

    @Override
    public boolean equals(Object o)
    {
        if (o instanceof Type)
        {
            Type otherType = (Type) o;

            if (otherType.Kind == this.Kind)
            {
                if (this.getChildType() != null && otherType.getChildType() != null)
                    return this.getChildType().equals(otherType.getChildType());
                else
                    return true;
            }
        }

        return false;
    }

    public Type getChildType()
    {
        return this._childType;
    }

    public boolean isCollection()
    {
        return this.Kind == COLLECTION;
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
            case Type.COLLECTION:
                return "COLLECTION<" + this.getChildType() + ">";
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
