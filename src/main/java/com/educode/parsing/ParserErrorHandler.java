package com.educode.parsing;

import com.educode.errorhandling.ErrorHandler;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.ATNConfigSet;
import org.antlr.v4.runtime.dfa.DFA;

import java.util.BitSet;

/**
 * Created by zen on 5/17/17.
 */
public class ParserErrorHandler extends BailErrorStrategy
{
    static final ParserErrorHandler INSTANCE = new ParserErrorHandler();

    private ParserErrorHandler()
    {
        super();
    }

    @Override
    public void reportError(Parser recognizer, RecognitionException e)
    {
        throw e;
    }

    @Override
    protected void reportNoViableAlternative(Parser recognizer, NoViableAltException e)
    {
        throw e;
    }

    @Override
    protected void reportInputMismatch(Parser recognizer, InputMismatchException e)
    {
        throw e;
    }

    @Override
    protected void reportFailedPredicate(Parser recognizer, FailedPredicateException e)
    {
        throw e;
    }
}
