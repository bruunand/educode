package com.educode.events;

import com.educode.nodes.method.MethodDeclarationNode;
import com.educode.nodes.referencing.IdentifierReferencingNode;
import com.educode.nodes.ungrouped.EventDefinitionNode;
import com.educode.runtime.ProgramBase;

import java.lang.reflect.Method;
import java.util.List;

/**
 * Created by zen on 4/27/17.
 */
public class EventInvoker
{
    public static void invokeByType(ProgramBase program, Class<?> eventType, Object ... args)
    {
        List<EventDefinitionNode> eventDefinitions = program.getEventDefinitions();
        if (eventDefinitions == null)
            return;

        for (EventDefinitionNode eventDef : eventDefinitions)
        {
            if (eventDef.getEventType().getClass() != eventType)
                continue;

            invokeByName(program, eventDef.getMethodName(), eventDef.getEventType(), args);
            //invokeByName(program, eventDef.getMethodName(), args);
        }
    }

    static void invokeByName(ProgramBase program, String methodName, EventTypeBase eventType, Object ... args)
    {
        for (MethodDeclarationNode methodDeclaration : program.getMethodDeclarations())
        {
            String currentMethodName = ((IdentifierReferencingNode) methodDeclaration.getReference()).getText();
            if (!currentMethodName.equals(methodName) || !eventType.matchesWithDeclaration(methodDeclaration))
                continue;

            program.queueEvent(methodDeclaration, args);
        }
    }

    public static void invokeByName(ProgramBase program, String methodName, Object ... args)
    {
        // Gets class of each argument
        Class[] classArray = new Class[args.length];
        for (int i = 0; i < args.length; i++)
            classArray[i] = args[i].getClass();

        // Find the appropriate event and invoke it
        try
        {
            Method invokeMethod = program.getClass().getMethod(methodName, classArray);
            program.queueEvent(invokeMethod, args);
        }
        catch (NoSuchMethodException e)
        {
            e.printStackTrace();
        }
    }
}
