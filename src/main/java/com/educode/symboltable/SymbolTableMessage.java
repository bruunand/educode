package com.educode.symboltable;

import com.educode.nodes.base.Node;
import com.educode.nodes.ungrouped.StartNode;

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
    private StartNode _relatedStart;

    public SymbolTableMessage(MessageType type, Node relatedNode, String errorDescription, StartNode relatedStart)
    {
        this._type = type;
        this._relatedNode = relatedNode;
        this._errorDescription = errorDescription;
        this._relatedStart = relatedStart;
    }

    @Override
    public String toString()
    {
        if (this._relatedNode != null)
            return String.format("%s at line %d %s: %s", this.getTypeString(), (this._relatedStart.getInputSource() != null)?(" of " + this._relatedStart.getInputSource()):"",this._relatedNode.getLineNumber(), this._errorDescription);
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
