package com.educode;

import com.educode.antlr.EduCodeLexer;
import com.educode.antlr.EduCodeParser;
import com.educode.nodes.base.Node;
import com.educode.visitors.ASTBuilder;
import com.educode.visitors.PrintVisitor;
import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;

import java.io.IOException;

/**
 * Created by zen on 3/8/17.
 */
public class Main
{
    public static void main(String[] args) throws IOException
    {
        ANTLRInputStream stream = new ANTLRFileStream("test.code");
        EduCodeLexer lexer = new EduCodeLexer(stream);
        CommonTokenStream tokenStream = new CommonTokenStream(lexer);
        EduCodeParser parser = new EduCodeParser(tokenStream);

        ASTBuilder builder = new ASTBuilder();
        Node root = builder.visit(parser.program());

        PrintVisitor exampleVisitor = new PrintVisitor();
        exampleVisitor.visit(root);
    }
}
