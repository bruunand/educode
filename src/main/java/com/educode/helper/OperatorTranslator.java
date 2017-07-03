package com.educode.helper;

import com.educode.types.ArithmeticOperator;
import com.educode.types.AssignmentOperator;
import com.educode.types.LogicalOperator;
import com.educode.types.Type;

/**
 * Created by zen on 3/24/17.
 */
public class OperatorTranslator
{
    public static String toJava(Type type)
    {
        switch (type.getKind())
        {
            case Type.NUMBER:
                return "Double";
            case Type.STRING:
                return "String";
            case Type.BOOL:
                return "Boolean";
            case Type.COORDINATES:
                return "Coordinates";
            case Type.VOID:
                return "void";
            case Type.LIST:
                return String.format("ExtendedList<%s>", toJava(type.getChildType()));
            case Type.ENTITY:
                return "MinecraftEntity";
            case Type.ITEM:
                return "MinecraftItem";
        }

        System.out.println(String.format("Warning: Could not determine Java translation for type %s.", type));

        return null;
    }

    public static String toJava(LogicalOperator operator)
    {
        switch (operator.getKind())
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

        System.out.println(String.format("Warning: Could not determine Java translation for logical operator %s.", operator));

        return null;
    }

    public static String toJava(ArithmeticOperator operator)
    {
        switch (operator.getKind())
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

        System.out.println(String.format("Warning: Could not determine Java translation for arithmetic operator %s.", operator));

        return null;
    }

    public static String toJava(AssignmentOperator operator)
    {
        switch (operator.getKind())
        {
            case AssignmentOperator.NONE:
                return "=";
            case AssignmentOperator.ADDITION:
                return "+=";
            case AssignmentOperator.SUBTRACTION:
                return "-=";
            case AssignmentOperator.MULTIPLICATION:
                return "*=";
            case AssignmentOperator.DIVISION:
                return "/=";
        }

        System.out.println(String.format("Warning: Could not determine Java translation for assignment operator %s.", operator));

        return null;
    }

    public static String toBytecode(Type type)
    {
        switch (type.getKind())
        {
            case Type.NUMBER:
                return "D";
            case Type.STRING:
                return "Ljava.lang.String;";
            case Type.BOOL:
                return "I";
            case Type.COORDINATES:
                return "L<NotImplemented>;";
            case Type.VOID:
                return "V";
            default:
                if (type.isReferenceType())
                    return String.format("L%s;", type.toString());
        }

        System.out.println(String.format("Warning: Could not determine bytecode translation for type %s.", type));

        return null;
    }
}
