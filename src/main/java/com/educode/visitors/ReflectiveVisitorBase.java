package com.educode.visitors;

import com.educode.nodes.base.Node;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by User on 15-Apr-17.
 */
public abstract class ReflectiveVisitorBase
{
    public abstract Object defaultVisit(Node node);

    public Object visit(Node node)
    {
        Method method = getMethodFor(node);

        // Attempt to invoke the method
        try
        {
            return method.invoke(this, node);
        }
        catch (IllegalAccessException e)
        {
            e.printStackTrace();
        }
        catch (InvocationTargetException e)
        {
            e.printStackTrace();
        }

        return null;
    }

    private Method getMethodFor(Node node)
    {
        Method ans = null;

        // Find a method which matches the class of the node
        Class currentClass = node.getClass();
        while (ans == null && currentClass != Object.class && currentClass != Node.class)
        {
            try
            {
                ans = this.getClass().getMethod("visit", currentClass);
            }
            catch (NoSuchMethodException e)
            {
                // This may happen if the implementation of the visitor does implement a visitor for all nodes
            }

            // If no appropriate method was found, look in its superclass
            if (ans == null)
                currentClass = currentClass.getSuperclass();
        }

        // If no method was found, return default method
        if (ans == null)
        {
            try
            {
                ans = this.getClass().getMethod("defaultVisit", Node.class);
            }
            catch (NoSuchMethodException e)
            {
                // Should not happen since defaultVisit is abstract and must be implemented
            }
        }

        return ans;
    }
}
