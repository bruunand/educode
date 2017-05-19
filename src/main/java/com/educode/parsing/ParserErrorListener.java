package com.educode.parsing;

import com.educode.errorhandling.ErrorHandler;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.ATNConfigSet;
import org.antlr.v4.runtime.dfa.DFA;

import java.util.BitSet;

/**
 * Created by zen on 5/17/17.
 */
public class ParserErrorListener implements ANTLRErrorListener
{
    private final ErrorHandler _errorHandler;
    private final String _fileName;

    public ParserErrorListener(String fileName, ErrorHandler existingErrorHandler)
    {
        this._fileName = fileName;
        if (existingErrorHandler == null)
            this._errorHandler = new ErrorHandler();
        else
            this._errorHandler = existingErrorHandler;
    }

    public ErrorHandler getErrorHandler()
    {
        return this._errorHandler;
    }

    @Override
    public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol, int line, int charPositionInLine, String msg, RecognitionException e)
    {
        getErrorHandler().syntaxError(this._fileName, "%s at line %d.", msg, line);
    }

    @Override
    public void reportAmbiguity(Parser recognizer, DFA dfa, int startIndex, int stopIndex, boolean exact, BitSet ambigAlts, ATNConfigSet configs)
    {
        getErrorHandler().syntaxError(this._fileName, "Ambiguity from index %d to %d.", startIndex, stopIndex);
    }

    @Override
    public void reportAttemptingFullContext(Parser recognizer, DFA dfa, int startIndex, int stopIndex, BitSet conflictingAlts, ATNConfigSet configs)
    {
        // Called when an SLL conflict occurs and the parser is about to use the full context information to make an LL decision.
    }

    @Override
    public void reportContextSensitivity(Parser recognizer, DFA dfa, int startIndex, int stopIndex, int prediction, ATNConfigSet configs)
    {
        // Called by the parser when a full-context prediction has a unique result.
    }
}
