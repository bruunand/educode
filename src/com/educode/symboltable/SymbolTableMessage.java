package com.educode.symboltable;

import com.educode.nodes.base.Node;

/**
 * Created by User on 05-Apr-17.
 */
public class SymbolTableMessage
{
    public enum MessageType
    {
        ERROR,
        WARNING
    }

    private Node _relatedNode;
    private String _errorDescription;
    private MessageType _type;

    public SymbolTableMessage(MessageType type, Node relatedNode, String errorDescription)
    {
        this._type = type;
        this._relatedNode = relatedNode;
        this._errorDescription = errorDescription;
    }

    @Override
    public String toString()
    {
        if (this._relatedNode != null)
            return String.format("%s at line %d, %d: %s", this.getTypeString(), this._relatedNode.getLineNumber(), this._relatedNode.getCharPosition(), this._errorDescription);
        else
            return String.format("%s: %s", this.getTypeString(), this._errorDescription);
    }

    public MessageType getType()
    {
        return this._type;
    }

    public String getTypeString()
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
}
