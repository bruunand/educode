package com.educode.errorhandling;

import com.educode.nodes.base.Node;
import com.educode.nodes.ungrouped.StartNode;

/**
 * Created by User on 05-Apr-17.
 */
public abstract class ErrorMessage
{
    public enum MessageType
    {
        ERROR,
        WARNING
    }

    private String _errorDescription;
    private MessageType _type;

    protected ErrorMessage(MessageType type, String errorDescription)
    {
        this._type = type;
        this._errorDescription = errorDescription;
    }

    public MessageType getType()
    {
        return this._type;
    }

    protected String getTypeString()
    {
        switch (getType())
        {
            case ERROR:
                return "Error";
            case WARNING:
                return "Warning";
            default:
                return "Unknown";
        }
    }

    protected String getErrorDescription()
    {
        return this._errorDescription;
    }
}
