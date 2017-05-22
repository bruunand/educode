package com.educode.parsing;

/**
 * Created by zen on 5/22/17.
 */
public class ParserException extends Exception
{
    ParserException(Exception inner)
    {
        this(inner.getMessage());
    }

    ParserException(String message)
    {
        super(message);
    }
}
