package com.educode;

import com.educode.minecraft.CompilerMod;
import com.educode.nodes.ungrouped.StartNode;
import com.educode.parsing.ParserHelper;
import com.educode.runtime.ProgramImpl;
import com.educode.visitors.interpreter.InterpretationVisitor;
import com.educode.visitors.semantic.SemanticVisitor;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by zen on 3/8/17.
 */
public class Main
{
    public static void main(String[] args) throws Exception
    {
        CompilerMod.createDirectory();

        // Parse test file
        StartNode startNode;
        try
        {
            startNode = ParserHelper.parse("Test.educ");
        }
        catch (Exception e)
        {
            System.out.println("Parsing error: " + e.getMessage());
            return;
        }

        // Setup semantic visitor
        SemanticVisitor sv = new SemanticVisitor();
        sv.getSymbolTableHandler().setInputSource(startNode);
        startNode.setInputSource("Test.educ");
        startNode.setIsMain(true);
        sv.visit(startNode);

        // Print any errors and warnings
        sv.getSymbolTableHandler().printMessages();

        // Pretty print
        // System.out.println(startNode.accept(new PrintVisitor()));

        // Interpret
        startNode.accept(new InterpretationVisitor(new ProgramImpl()));
        System.out.println("Done interpreting");
        System.exit(0);
    }

    private static void invokeMainInClass(Class classToRun) throws InvocationTargetException, IllegalAccessException, InstantiationException, NoSuchMethodException
    {
        Object instance = classToRun.newInstance();

        Method mainMethod = classToRun.getMethod("main");
        mainMethod.invoke(instance);
    }
}
