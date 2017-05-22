package com.educode.parsing;

import com.educode.antlr.EduCodeLexer;
import com.educode.antlr.EduCodeParser;
import com.educode.minecraft.CompilerMod;
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
    public static StartNode parse(String fileName) throws ParserException
    {
        ANTLRInputStream stream;
        try
        {
            stream = new ANTLRFileStream(CompilerMod.EDUCODE_PROGRAMS_LOCATION + fileName);
        }
        catch (IOException e)
        {
            e.printStackTrace();
            throw new ParserException("Could not find program " + fileName);
        }

        // Create lexer from input file stream
        EduCodeLexer lexer = new EduCodeLexer(stream);

        // Create token stream from lexer to be used by parser
        CommonTokenStream tokenStream = new CommonTokenStream(lexer);

        // Create parser
        EduCodeParser parser = new EduCodeParser(tokenStream);
        parser.setErrorHandler(ParserErrorHandler.INSTANCE);

        // Use ASTBuilder to visit the parser's start
        try
        {
            ASTBuilder astBuilder = new ASTBuilder();
            Node rootNode = astBuilder.visit(parser.start());

            if (rootNode instanceof StartNode)
                return (StartNode) rootNode;
            throw new Exception("Root node was not an instance of StartNode.");
        }
        catch (Exception e)
        {
            throw new ParserException(e);
        }
    }
}
