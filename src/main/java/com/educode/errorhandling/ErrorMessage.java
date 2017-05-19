package com.educode.errorhandling;

import com.educode.nodes.base.Node;
import com.educode.nodes.ungrouped.StartNode;

/**
 * Created by User on 05-Apr-17.
 */
public class ErrorMessage
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
    private StartNode _conflictingStart;

    public ErrorMessage(MessageType type, Node relatedNode, String errorDescription, StartNode relatedStart, StartNode conflictingStart)
    {
        this._type = type;
        this._relatedNode = relatedNode;
        this._errorDescription = errorDescription;
        this._relatedStart = relatedStart;
        this._conflictingStart = conflictingStart;
    }

    public ErrorMessage(MessageType type, Node relatedNode, String errorDescription, StartNode relatedStart)
    {
        this(type, relatedNode, errorDescription, relatedStart, null);
    }

    @Override
    public String toString()
    {
        if (this._relatedStart == null)
            return this._errorDescription;

        String sourceFile = (this._relatedStart.getInputSource() != null) ? String.format(" of %s", this._relatedStart.getInputSource()) : "";
        String conflictFile = (this._conflictingStart != null) ?String.format(" in %s.",this._conflictingStart.getInputSource()) : "";
        if (this._relatedNode != null)
            return String.format("%s at line %d%s: %s%s", this.getTypeString(), this._relatedNode.getLineNumber(), sourceFile, this._errorDescription, conflictFile);
        else
            return String.format("%s: %s", this.getTypeString(), this._errorDescription);
    }

    public MessageType getType()
    {
        return this._type;
    }

    private String getTypeString()
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
