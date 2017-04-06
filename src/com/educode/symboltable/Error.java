package com.educode.symboltable;

import com.educode.nodes.base.Node;

/**
 * Created by User on 05-Apr-17.
 */
public class Error
{
    private Node _relatedNode;
    private String _errorDescription;

    public Error(Node relatedNode, String errorDescription)
    {
        this._relatedNode = relatedNode;
        this._errorDescription = errorDescription;
    }

    @Override
    public String toString()
    {
        if (this._relatedNode != null)
            return String.format("Error at line %d, %d: %s", this._relatedNode.getLineNumber(), this._relatedNode.getCharPosition(), this._errorDescription);
        else
            return String.format("Error: %s", this._errorDescription);
    }
}
