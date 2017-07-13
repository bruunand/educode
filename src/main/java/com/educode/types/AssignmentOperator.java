package com.educode.types;

/**
 * Created by Thomas Buhl on 11/05/2017.
 */
public class AssignmentOperator {
    private final byte _kind;
    public final static byte ERROR = 0, NONE= 1, ADDITION = 2, SUBTRACTION = 3, MULTIPLICATION = 4, DIVISION = 5;

    private AssignmentOperator(byte kind)
    {
        this._kind = kind;
    }

    @Override
    public boolean equals(Object o)
    {
        return o instanceof AssignmentOperator && ((AssignmentOperator) o)._kind == this._kind;
    }

    @Override
    public String toString()
    {
        switch (_kind)
        {
            case AssignmentOperator.NONE:
                return "=";
            case AssignmentOperator.ADDITION:
                return "+=";
            case AssignmentOperator.SUBTRACTION:
                return "-=";
            case AssignmentOperator.DIVISION:
                return "/=";
            case AssignmentOperator.MULTIPLICATION:
                return "*=";
            default:
                return "UNDEFINED"; // Should not happen
        }
    }

    public byte getKind()
    {
        return _kind;
    }

    public static final AssignmentOperator None = new AssignmentOperator(NONE);
    public static final AssignmentOperator Addition = new AssignmentOperator(ADDITION);
    public static final AssignmentOperator Subtraction = new AssignmentOperator(SUBTRACTION);
    public static final AssignmentOperator Multiplication = new AssignmentOperator(MULTIPLICATION);
    public static final AssignmentOperator Division = new AssignmentOperator(DIVISION);
    public static final AssignmentOperator Error = new AssignmentOperator(ERROR);

}
