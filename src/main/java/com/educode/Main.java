package com.educode;

import com.educode.minecraft.CompilerMod;
import com.educode.minecraft.compiler.CustomJavaCompiler;
import com.educode.nodes.ungrouped.StartNode;
import com.educode.parsing.ParserHelper;
import com.educode.visitors.PrintVisitor;
import com.educode.visitors.codegeneration.JavaBytecodeGenerationVisitor;
import com.educode.visitors.codegeneration.JavaCodeGenerationVisitor;
import com.educode.visitors.interpreter.InterpretationVisitor;
import com.educode.visitors.optimisation.OptimisationVisitor;
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
        startNode.accept(sv);

        // Print any errors and warnings
        sv.getSymbolTableHandler().printMessages();
        /*if (sv.getSymbolTableHandler().hasErrors())
            return;*/

        // Perform optimisations - Disabled, optimises some constant variables falsely
        // startNode.accept(new OptimisationVisitor());

        // Pretty print
        System.out.println(startNode.accept(new PrintVisitor()));

        // Interpret
        startNode.accept(new InterpretationVisitor());
        System.out.println("Done interpreting");
        System.exit(0);

        // Generate bytecode
        JavaBytecodeGenerationVisitor byteCodeVisitor = new JavaBytecodeGenerationVisitor();
        startNode.accept(byteCodeVisitor);

        // Generate Java
        JavaCodeGenerationVisitor javaCodeVisitor = new JavaCodeGenerationVisitor();
        startNode.accept(javaCodeVisitor);

        // Test code generation
        System.out.println("Compiling Java code...");
        CustomJavaCompiler compiler = new CustomJavaCompiler();
        invokeMainInClass(compiler.compile("Test"));
        System.out.println();

        // Test bytecode generation
        System.out.println("Compiling bytecode using Jasmin...");
        jasmin.Main jasminMain = new jasmin.Main();
        jasminMain.assemble(CompilerMod.EDUCODE_PROGRAMS_LOCATION + "Test.j");
        invokeMainInClass(CustomJavaCompiler.loadClass("Test", "")); // For some reason, Jasmin likes to place the class file in the working dir
    }

    private static void invokeMainInClass(Class classToRun) throws InvocationTargetException, IllegalAccessException, InstantiationException, NoSuchMethodException
    {
        Object instance = classToRun.newInstance();

        Method mainMethod = classToRun.getMethod("main");
        mainMethod.invoke(instance);
    }
}
