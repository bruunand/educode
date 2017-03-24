package com.educode.types;

/**
 * Created by zen on 3/24/17.
 */
public class ArithmeticOperator
{
    private byte _kind;
    private static byte ERROR = 0, ADDITION = 1, SUBTRACTION = 2, MULTIPLICATION = 3, DIVISION = 4, MODULO = 5;

    public ArithmeticOperator(byte kind)
    {
        this._kind = kind;
    }

    @Override
    public boolean equals(Object o)
    {
        if (o instanceof ArithmeticOperator)
            return ((ArithmeticOperator)o)._kind == this._kind;
        return false;
    }

    public static final ArithmeticOperator AdditionOperator = new ArithmeticOperator(ADDITION);
    public static final ArithmeticOperator SubtactionOperator = new ArithmeticOperator(SUBTRACTION);
    public static final ArithmeticOperator MultiplicationOperator = new ArithmeticOperator(MULTIPLICATION);
    public static final ArithmeticOperator DivisonOperator = new ArithmeticOperator(DIVISION);
    public static final ArithmeticOperator ModuloOperator = new ArithmeticOperator(MODULO);
    public static final ArithmeticOperator Error = new ArithmeticOperator(ERROR);
}
