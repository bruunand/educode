package com.educode;

import com.educode.antlr.EduCodeLexer;
import com.educode.antlr.EduCodeParser;
import com.educode.minecraft.compiler.CustomJavaCompiler;
import com.educode.nodes.base.Node;
import com.educode.nodes.ungrouped.StartNode;
import com.educode.parsing.ParserHelper;
import com.educode.parsing.ParserResult;
import com.educode.visitors.ASTBuilder;
import com.educode.visitors.PrintVisitor;
import com.educode.visitors.codegeneration.JavaBytecodeGenerationVisitor;
import com.educode.visitors.codegeneration.JavaCodeGenerationVisitor;
import com.educode.visitors.optimization.OptimizationVisitor;
import com.educode.visitors.semantic.SemanticVisitor;
import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by zen on 3/8/17.
 */
public class Main
{
    public static void main(String[] args) throws Exception
    {
        ParserResult result = ParserHelper.parse("test");
        if (result.getErrorHandler().hasErrors())
        {
            result.getErrorHandler().printMessages();
            return;
        }

        // No syntax errors - setup semantic visitor
        StartNode startNode = result.getStartNode();
        SemanticVisitor sv = new SemanticVisitor();
        sv.getSymbolTableHandler().setInputSource(startNode);
        startNode.setInputSource("test.educ");
        startNode.setIsMain(true);

        // Perform semantic analysis
        sv.getSymbolTableHandler().openScope();
        startNode.accept(sv);
        sv.getSymbolTableHandler().closeScope();

        sv.getSymbolTableHandler().printMessages();

        if (sv.getSymbolTableHandler().hasErrors())
            return;

        startNode.accept(new OptimizationVisitor());

        System.out.println(startNode.accept(new PrintVisitor()));

        JavaBytecodeGenerationVisitor byteCodeVisitor = new JavaBytecodeGenerationVisitor();
        startNode.accept(byteCodeVisitor);

        JavaCodeGenerationVisitor javaCodeVisitor = new JavaCodeGenerationVisitor("Test.java");
        startNode.accept(javaCodeVisitor);

        // Test code generation
        System.out.println("Compiling Java code...");
        CustomJavaCompiler compiler = new CustomJavaCompiler();
        invokeMainInClass(compiler.compile(new File("").getAbsolutePath() + File.separator, "Test"));
        System.out.println();

        // Test bytecode generation
        System.out.println("Compiling bytecode using Jasmin...");
        jasmin.Main jasminMain = new jasmin.Main();
        jasminMain.assemble("Test.j");
        invokeMainInClass(CustomJavaCompiler.loadClass("Test", new File("").getAbsolutePath() + File.separator));
    }

    private static void invokeMainInClass(Class classToRun) throws InvocationTargetException, IllegalAccessException, InstantiationException, NoSuchMethodException
    {
        Object instance = classToRun.newInstance();

        Method mainMethod = classToRun.getMethod("main");
        mainMethod.invoke(instance);
    }
}
