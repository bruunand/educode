package com.educode.events;

import com.educode.nodes.method.MethodDeclarationNode;

import java.util.List;

/**
 * Created by zen on 7/8/17.
 */
public class EventInvocationRequest
{
    private final MethodDeclarationNode _methodDeclaration;
    private final List<Object> _arguments;

    public EventInvocationRequest(MethodDeclarationNode methodDeclaration, List<Object> arguments)
    {
        this._methodDeclaration = methodDeclaration;
        this._arguments = arguments;
    }

    public MethodDeclarationNode getMethodDeclaration()
    {
        return this._methodDeclaration;
    }

    public List<Object> getArguments()
    {
        return this._arguments;
    }
}
