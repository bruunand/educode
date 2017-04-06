package com.educode.types;

/**
 * Created by zen on 3/24/17.
 */
public class ArithmeticOperator
{
    public final byte Kind;
    public final static byte ERROR = 0, ADDITION = 1, SUBTRACTION = 2, MULTIPLICATION = 3, DIVISION = 4, MODULO = 5;

    public ArithmeticOperator(byte kind)
    {
        this.Kind = kind;
    }

    @Override
    public boolean equals(Object o)
    {
        if (o instanceof ArithmeticOperator)
            return ((ArithmeticOperator)o).Kind == this.Kind;
        return false;
    }

    @Override
    public String toString()
    {
        switch (Kind)
        {
            case ArithmeticOperator.ADDITION:
                return "+";
            case ArithmeticOperator.SUBTRACTION:
                return "-";
            case ArithmeticOperator.DIVISION:
                return "/";
            case ArithmeticOperator.MODULO:
                return "MODULO";
            case ArithmeticOperator.MULTIPLICATION:
                return "*";
            default:
                return "UNDEFINED"; // Should not happen
        }
    }

    public static final ArithmeticOperator Addition = new ArithmeticOperator(ADDITION);
    public static final ArithmeticOperator Subtraction = new ArithmeticOperator(SUBTRACTION);
    public static final ArithmeticOperator Multiplication = new ArithmeticOperator(MULTIPLICATION);
    public static final ArithmeticOperator Division = new ArithmeticOperator(DIVISION);
    public static final ArithmeticOperator Modulo = new ArithmeticOperator(MODULO);

    public static final ArithmeticOperator Error = new ArithmeticOperator(ERROR);
}
