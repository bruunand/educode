package com.educode.errorhandling;

import com.educode.nodes.base.Node;
import com.educode.nodes.ungrouped.StartNode;

/**
 * Created by zen on 5/19/17.
 */
public class SemanticErrorMessage extends ErrorMessage
{
    private Node _relatedNode;
    private StartNode _relatedStart;
    private StartNode _conflictingStart;

    public SemanticErrorMessage(MessageType type, Node relatedNode, String errorDescription, StartNode relatedStart, StartNode conflictingStart)
    {
        super(type, errorDescription);
        this._relatedNode = relatedNode;
        this._relatedStart = relatedStart;
        this._conflictingStart = conflictingStart;
    }

    public SemanticErrorMessage(MessageType type, Node relatedNode, String errorDescription, StartNode relatedStart)
    {
        this(type, relatedNode, errorDescription, relatedStart, null);
    }

    @Override
    public String toString()
    {
        if (this._relatedStart == null)
            return this.getErrorDescription();

        String sourceFile = (this._relatedStart.getInputSource() != null) ? String.format(" of %s", this._relatedStart.getInputSource()) : "";
        String conflictFile = (this._conflictingStart != null) ? String.format(" in %s.",this._conflictingStart.getInputSource()) : "";
        if (this._relatedNode != null)
            return String.format("%s at line %d%s: %s%s", this.getTypeString(), this._relatedNode.getLineNumber(), sourceFile, this.getErrorDescription(), conflictFile);
        else
            return String.format("%s: %s", this.getTypeString(), this.getErrorDescription());
    }
}
