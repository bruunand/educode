package com.educode.helper;

import com.educode.types.ArithmeticOperator;
import com.educode.types.LogicalOperator;
import com.educode.types.Type;

import static com.educode.types.LogicalOperator.AND;
import static com.educode.types.LogicalOperator.OR;

/**
 * Created by zen on 3/24/17.
 */
public class OperatorTranslator
{
    public static String ToJava(Type type)
    {
        switch (type.Kind)
        {
            case Type.NUMBER:
                return "float";
            case Type.STRING:
                return "String";
            case Type.BOOL:
                return "boolean";
            case Type.VOID:
                return "void";
        }

        // Todo: Error handling

        return null;
    }

    public static String ToJava(LogicalOperator operator)
    {
        switch (operator.Kind)
        {
            case LogicalOperator.AND:
                return "&&";
            case LogicalOperator.OR:
                return "||";
            case LogicalOperator.EQUALS:
                return "==";
            case LogicalOperator.NOT_EQUALS:
                return "!=";
            case LogicalOperator.LESS_THAN:
                return "<";
            case LogicalOperator.LESS_THAN_OR_EQUALS:
                return "<=";
            case LogicalOperator.GREATER_THAN:
                return ">";
            case LogicalOperator.GREATER_THAN_OR_EQUALS:
                return ">=";
        }

        // Todo: Error handling

        return null;
    }

    public static String ToJava(ArithmeticOperator operator)
    {
        switch (operator.Kind)
        {
            case ArithmeticOperator.ADDITION:
                return "+";
            case ArithmeticOperator.SUBTRACTION:
                return "-";
            case ArithmeticOperator.DIVISION:
                return "/";
            case ArithmeticOperator.MODULO:
                return "%";
            case ArithmeticOperator.MULTIPLICATION:
                return "*";
        }

        // Todo: Error handling

        return null;
    }

}
