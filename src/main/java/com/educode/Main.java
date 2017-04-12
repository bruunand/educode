package com.educode;

import com.educode.antlr.EduCodeLexer;
import com.educode.antlr.EduCodeParser;
import com.educode.nodes.base.Node;
import com.educode.visitors.*;
import com.educode.visitors.codegeneration.JavaBytecodeGenerationVisitor;
import com.educode.visitors.codegeneration.JavaCodeGenerationVisitor;
import com.educode.visitors.debug.DrawVisitor;
import com.educode.visitors.debug.PrettyPrintVisitor;
import com.educode.visitors.semantic.SemanticVisitor;
import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;

import java.io.IOException;
import java.util.List;

/**
 * Created by zen on 3/8/17.
 */
public class Main
{
    public static void main(String[] args) throws IOException
    {
        ANTLRInputStream stream = new ANTLRFileStream("test.educ");
        EduCodeLexer lexer = new EduCodeLexer(stream);
        CommonTokenStream tokenStream = new CommonTokenStream(lexer);
        EduCodeParser parser = new EduCodeParser(tokenStream);

        ASTBuilder builder = new ASTBuilder();
        Node root = builder.visit(parser.program());

        JavaCodeGenerationVisitor exampleVisitor = new JavaCodeGenerationVisitor("test.java");
        exampleVisitor.visit(root);
        PrettyPrintVisitor v = new PrettyPrintVisitor();
        v.visit(root);
        SemanticVisitor sem = new SemanticVisitor();
        sem.visit(root);
        sem.getSymbolTableHandler().printMessages();

        JavaBytecodeGenerationVisitor g = new JavaBytecodeGenerationVisitor();
        g.visit(root);

        DrawVisitor d = new DrawVisitor();
        System.out.println(d.visit(root));
    }
}