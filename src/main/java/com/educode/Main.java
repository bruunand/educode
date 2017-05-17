package com.educode;

import com.educode.antlr.EduCodeLexer;
import com.educode.antlr.EduCodeParser;
import com.educode.minecraft.compiler.CustomJavaCompiler;
import com.educode.nodes.base.Node;
import com.educode.nodes.ungrouped.StartNode;
import com.educode.visitors.ASTBuilder;
import com.educode.visitors.PrintVisitor;
import com.educode.visitors.UsingVisitor;
import com.educode.visitors.codegeneration.JavaBytecodeGenerationVisitor;
import com.educode.visitors.codegeneration.JavaCodeGenerationVisitor;
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
        ANTLRInputStream stream = new ANTLRFileStream("test.educ");
        EduCodeLexer lexer = new EduCodeLexer(stream);
        CommonTokenStream tokenStream = new CommonTokenStream(lexer);
        EduCodeParser parser = new EduCodeParser(tokenStream);

        ASTBuilder builder = new ASTBuilder();
        Node root = builder.visit(parser.start());
        System.out.println(root.accept(new PrintVisitor()));


        SemanticVisitor sv = new SemanticVisitor();
        if (root instanceof StartNode)
        {
            sv.getSymbolTableHandler().setInputSource((StartNode)root);
            ((StartNode) root).setInputSource("test.educ");
            ((StartNode) root).setIsMain(true);
        }

        sv.getSymbolTableHandler().openScope();
        root.accept(sv);
        sv.getSymbolTableHandler().closeScope();

        sv.getSymbolTableHandler().printMessages();

        if (sv.getSymbolTableHandler().hasErrors())
            return;

        //root.accept(new OptimizationVisitor());

        JavaBytecodeGenerationVisitor byteCodeVisitor = new JavaBytecodeGenerationVisitor();
        root.accept(byteCodeVisitor);

        System.out.println(root.accept(new PrintVisitor()));

        JavaCodeGenerationVisitor javaCodeVisitor = new JavaCodeGenerationVisitor("Test.java");
        root.accept(javaCodeVisitor);

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
