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
    public static String toJava(Type type)
    {
        switch (type.Kind)
        {
            case Type.NUMBER:
                return "Float";
            case Type.STRING:
                return "String";
            case Type.BOOL:
                return "boolean";
            case Type.COORDINATES:
                return "Coordinates";
            case Type.VOID:
                return "void";
            case Type.COLLECTION:
                return String.format("List<%s>", toJava(type.getChildType()));
        }

        System.out.println(String.format("Warning: Could not determine Java translation for type %s.", type));

        return null;
    }

    public static String toJava(LogicalOperator operator)
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

        System.out.println(String.format("Warning: Could not determine Java translation for logical operator %s, exiting..", operator));

        return null;
    }

    public static String toJava(ArithmeticOperator operator)
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

        System.out.println(String.format("Warning: Could not determine Java translation for arithmetic operator %s, exiting..", operator));

        return null;
    }

    public static String toBytecode(Type type)
    {
        switch (type.Kind)
        {
            case Type.NUMBER:
                return "D";
            case Type.STRING:
                return "Ljava.lang.String;";
            case Type.BOOL:
                return "Z";
            case Type.COORDINATES:
                return "L<NotImplemented>;";
            case Type.VOID:
                return "V";
            case Type.REFERENCE:
                return String.format("L%s;", type.toString());
        }

        System.out.println(String.format("Warning: Could not determine bytecode translation for type %s, exiting..", type));

        return null;
    }
}