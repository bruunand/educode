package com.educode.parsing;

import com.educode.antlr.EduCodeLexer;
import com.educode.antlr.EduCodeParser;
import com.educode.errorhandling.ErrorHandler;
import com.educode.nodes.base.Node;
import com.educode.nodes.ungrouped.StartNode;
import com.educode.visitors.ASTBuilder;
import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;

import java.io.IOException;

/**
 * Created by zen on 5/18/17.
 */
public class ParserHelper
{
    public static ParserResult parse(String fileName) throws IOException
    {
        ParserErrorListener errorListener = new ParserErrorListener();
        ANTLRInputStream stream = new ANTLRFileStream(fileName + ".educ");

        // Create lexer from input file stream
        EduCodeLexer lexer = new EduCodeLexer(stream);
        lexer.removeErrorListeners();
        lexer.addErrorListener(new ParserErrorListener());

        // Create token stream from lexer to be used by parser
        CommonTokenStream tokenStream = new CommonTokenStream(lexer);

        // Create parser
        EduCodeParser parser = new EduCodeParser(tokenStream);
        parser.removeErrorListeners();
        parser.addErrorListener(errorListener);

        // Use ASTBuilder to visit the parser's start
        ASTBuilder astBuilder = new ASTBuilder(errorListener.getErrorHandler());
        Node rootNode = astBuilder.visit(parser.start());

        return new ParserResult((StartNode) rootNode, errorListener.getErrorHandler());
    }
}
