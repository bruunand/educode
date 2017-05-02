package com.educode.helper;

import com.educode.nodes.method.MethodDeclarationNode;
import com.educode.runtime.types.*;
import com.educode.symboltable.Symbol;
import com.educode.symboltable.SymbolTable;
import com.educode.types.Type;
import sun.reflect.generics.reflectiveObjects.TypeVariableImpl;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by zen on 4/25/17.
 */
// Helps with converting interface to type symbol tables that can be understood by the scripts
public class InterfaceConverter
{
    private static Type getTypeFromClass(java.lang.reflect.Type sourceType)
    {
        if (sourceType instanceof ParameterizedType)
        {
            // Return a list type for parameterized types
            ParameterizedType parameterizedType = (ParameterizedType) sourceType;
            return new Type(getTypeFromClass(parameterizedType.getActualTypeArguments()[0]));
        }
        else
        {
            Class<?> sourceClass = (Class<?>) sourceType;

            if (sourceClass.equals(String.class))
                return Type.StringType;
            else if (sourceClass.equals(float.class) || sourceClass.equals(Float.class))
                return Type.NumberType;
            else if (sourceClass.equals(MinecraftEntity.class))
                return Type.EntityType;
            else if (sourceClass.equals(MinecraftItem.class))
                return Type.ItemType;
            else if (sourceClass.equals(boolean.class))
                return Type.BoolType;
            else if (sourceClass.equals(Coordinates.class))
                return Type.CoordinatesType;
            else
                return Type.VoidType;
        }
    }

    public static SymbolTable getSymbolTableFromClass(SymbolTable baseTable, Class source)
    {
        SymbolTable newTable = new SymbolTable(baseTable);

        // Go through each declared method and add it
        for (Method method : source.getDeclaredMethods())
        {
            // Skip if return type is TypeVariableImpl (generic type)
            if (method.getGenericReturnType() instanceof TypeVariableImpl)
                continue;

            // Get EduCode type of return type
            Type returnType = getTypeFromClass(method.getGenericReturnType());

            List<Type> parameterTypes = new ArrayList<>();
            boolean skipMethod = false;
            for (java.lang.reflect.Type parameter : method.getGenericParameterTypes())
            {
                // Skip if parameter type is TypeVariableImpl (generic type)
                if (parameter instanceof TypeVariableImpl)
                {
                    skipMethod = true;
                    continue;
                }

                // Get EduCode type of parameter type and add it to local list
                parameterTypes.add(getTypeFromClass(parameter));
            }

            // Check if skipping method
            if (skipMethod)
                continue;

            // Insert symbol into symbol table
            Symbol inserted = newTable.addDefaultMethod(method.getName(), returnType, parameterTypes);

            // Check if method is annotated with special translation
            // If it is, pass it to the method declaration that was inserted into the symbol table
            Annotation annotation = method.getAnnotation(SpecialJavaTranslation.class);
            if (annotation != null)
                ((MethodDeclarationNode) inserted.getSourceNode()).setSpecialJavaTranslation((SpecialJavaTranslation) annotation);
        }

        return newTable;
    }
}
