package com.educode.parsing;

import com.educode.errorhandling.ErrorHandler;
import com.educode.symboltable.SymbolTableHandler;
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

    public ParserErrorListener(ErrorHandler existingErrorHandler)
    {
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
        getErrorHandler().error("Syntax error at line %d: %s", line, msg);
    }

    @Override
    public void reportAmbiguity(Parser recognizer, DFA dfa, int startIndex, int stopIndex, boolean exact, BitSet ambigAlts, ATNConfigSet configs)
    {
        getErrorHandler().error("Ambiguity at from index %d to %d.", startIndex, stopIndex);
    }

    @Override
    public void reportAttemptingFullContext(Parser recognizer, DFA dfa, int startIndex, int stopIndex, BitSet conflictingAlts, ATNConfigSet configs)
    {
        getErrorHandler().error("Attempting full context from index %d to %d.", startIndex, stopIndex);
    }

    @Override
    public void reportContextSensitivity(Parser recognizer, DFA dfa, int startIndex, int stopIndex, int prediction, ATNConfigSet configs)
    {
        getErrorHandler().error("Context sensitivity from index %d to %d.", startIndex, stopIndex);
    }
}
