package com.educode;

import com.educode.antlr.EduCodeLexer;
import com.educode.antlr.EduCodeParser;
import com.educode.nodes.base.Node;
import com.educode.visitors.ASTBuilder;
import com.educode.visitors.PrintVisitor;
import com.educode.visitors.SemanticVisitor;
import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;

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
        // Go through print visitor

/*        PrettyPrintVisitor v = new PrettyPrintVisitor();
        v.visit(root);
        SemanticVisitor sem = new SemanticVisitor();
        sem.visit(root);
        sem.getSymbolTableHandler().printMessages();

        JavaBytecodeGenerationVisitor g = new JavaBytecodeGenerationVisitor();
        g.visit(root);

        DrawVisitor d = new DrawVisitor();
        System.out.println(d.visit(root));

        JavaCodeGenerationVisitor exampleVisitor = new JavaCodeGenerationVisitor("Test.java");
        exampleVisitor.visit(root);

        // Test code generation
        CustomJavaCompiler compiler = new CustomJavaCompiler();
        Class compiledClass = compiler.compile(new File("").getAbsolutePath() + File.separator, "Test");
        Object instance = compiledClass.newInstance();
        for (Method m : compiledClass.getDeclaredMethods())
        {
            if (m.getName().equals("main"))
                m.invoke(instance);
        }*/
    }
}
