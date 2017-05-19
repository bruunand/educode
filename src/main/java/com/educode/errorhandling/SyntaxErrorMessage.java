package com.educode.errorhandling;

/**
 * Created by zen on 5/19/17.
 */
public class SyntaxErrorMessage extends ErrorMessage
{
    private String _fileName;

    public SyntaxErrorMessage(MessageType type, String errorDescription, String fileName)
    {
        super(type, errorDescription);
        this._fileName = fileName;
    }

    @Override
    public String toString()
    {
        return String.format("Syntax %s in file %s: %s", this.getTypeString().toLowerCase(), this._fileName, this.getErrorDescription());
    }
}
