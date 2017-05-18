package com.educode.parsing;

import com.educode.errorhandling.ErrorHandler;
import com.educode.nodes.ungrouped.StartNode;

/**
 * Created by zen on 5/18/17.
 */
public class ParserResult
{
    private final StartNode _startNode;
    private final ErrorHandler _errorHandler;

    public ParserResult(StartNode startNode, ErrorHandler errorHandler)
    {
        this._startNode = startNode;
        this._errorHandler = errorHandler;
    }

    public StartNode getStartNode()
    {
        return this._startNode;
    }

    public ErrorHandler getErrorHandler()
    {
        return this._errorHandler;
    }
}
