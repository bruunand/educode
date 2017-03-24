package com.educode.types;

/**
 * Created by zen on 3/24/17.
 */
public class LogicalOperator
{
    public final byte Kind;
    public static final byte ERROR = 0, EQUALS = 1, NOT_EQUALS = 2, LESS_THAN = 3, LESS_THAN_OR_EQUALS = 4, GREATER_THAN = 5, GREATER_THAN_OR_EQUALS = 6, OR = 7, AND = 8;

    public LogicalOperator(byte kind)
    {
        this.Kind = kind;
    }

    @Override
    public boolean equals(Object o)
    {
        if (o instanceof LogicalOperator)
            return ((LogicalOperator)o).Kind == this.Kind;
        return false;
    }

    public static LogicalOperator Equals = new LogicalOperator(EQUALS);
    public static LogicalOperator NotEquals = new LogicalOperator(NOT_EQUALS);

    public static LogicalOperator LessThan = new LogicalOperator(LESS_THAN);
    public static LogicalOperator LessThanOrEquals = new LogicalOperator(LESS_THAN_OR_EQUALS);

    public static LogicalOperator GreaterThan = new LogicalOperator(GREATER_THAN);
    public static LogicalOperator GreaterThanOrEquals = new LogicalOperator(GREATER_THAN_OR_EQUALS);

    public static LogicalOperator Or = new LogicalOperator(OR);
    public static LogicalOperator And = new LogicalOperator(AND);

    public static LogicalOperator Error = new LogicalOperator(ERROR);
}
