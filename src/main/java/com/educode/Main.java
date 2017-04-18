package com.educode;

import com.educode.antlr.EduCodeLexer;
import com.educode.antlr.EduCodeParser;
import com.educode.minecraft.compiler.CustomJavaCompiler;
import com.educode.nodes.base.Node;
import com.educode.visitors.ASTBuilder;
import com.educode.visitors.PrintVisitor;
import com.educode.visitors.codegeneration.JavaBytecodeGenerationVisitor;
import com.educode.visitors.codegeneration.JavaCodeGenerationVisitor;
import com.educode.visitors.semantic.SemanticVisitor;
import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;

import java.io.File;
import java.lang.reflect.Method;

/**
 * Created by zen on 3/8/17.
 */
public class Main
{
    public static void main(String[] args) throws Exception
    {
        // Reflective visitor test
        //new Test().visit(new ProgramNode(null, null));

        ANTLRInputStream stream = new ANTLRFileStream("test.educ");
        EduCodeLexer lexer = new EduCodeLexer(stream);
        CommonTokenStream tokenStream = new CommonTokenStream(lexer);
        EduCodeParser parser = new EduCodeParser(tokenStream);

        ASTBuilder builder = new ASTBuilder();
        Node root = builder.visit(parser.program());
        System.out.println(root.accept(new PrintVisitor()));
        SemanticVisitor sv = new SemanticVisitor();
        root.accept(sv);
        sv.getSymbolTableHandler().printMessages();

        JavaBytecodeGenerationVisitor byteCodeVisitor = new JavaBytecodeGenerationVisitor();
        root.accept(byteCodeVisitor);

        JavaCodeGenerationVisitor javaCodeVisitor = new JavaCodeGenerationVisitor("Test.java");
        root.accept(javaCodeVisitor);

        // Test code generation
        CustomJavaCompiler compiler = new CustomJavaCompiler();
        Class compiledClass = compiler.compile(new File("").getAbsolutePath() + File.separator, "Test");
        Object instance = compiledClass.newInstance();
        for (Method m : compiledClass.getDeclaredMethods())
        {
            if (m.getName().equals("main"))
                m.invoke(instance);
        }
    }
}
