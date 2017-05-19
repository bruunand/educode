package com.educode.errorhandling;

import com.educode.nodes.base.Node;
import com.educode.nodes.ungrouped.StartNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zen on 5/18/17.
 */
public class ErrorHandler
{
    private final List<ErrorMessage> _messageList = new ArrayList<>();
    private StartNode _inputSource = null;

    public void setInputSource(StartNode source)
    {
        this._inputSource = source;
    }

    protected StartNode getInputSource()
    {
        return this._inputSource;
    }

    public boolean hasErrors()
    {
        for (ErrorMessage message : _messageList)
        {
            if (message.getType() == ErrorMessage.MessageType.ERROR)
                return true;
        }

        return false;
    }

    public void printMessages()
    {
        for (ErrorMessage message : _messageList)
            System.out.println(message);
    }

    public void parserError(String description, Object ... args)
    {
        parserError(null, description, args);
    }

    public void parserError(Node relatedNode, String description, Object ... args)
    {
        this._messageList.add(new SemanticErrorMessage(ErrorMessage.MessageType.ERROR, relatedNode, String.format(description, args), getInputSource()));
    }

    public void parserError(StartNode conflictSource, Node relatedNode, String description, Object ... args)
    {
        this._messageList.add(new SemanticErrorMessage(ErrorMessage.MessageType.ERROR, relatedNode, String.format(description, args), getInputSource(), conflictSource));
    }

    public void parserWarning(Node relatedNode, String description, Object ... args)
    {
        this._messageList.add(new SemanticErrorMessage(ErrorMessage.MessageType.WARNING, relatedNode, String.format(description, args), getInputSource()));
    }

    public void syntaxError(String fileName, String description, Object ... args)
    {
        this._messageList.add(new SyntaxErrorMessage(ErrorMessage.MessageType.ERROR, String.format(description, args), fileName));
    }

    public List<ErrorMessage> getMessages()
    {
        return this._messageList;
    }
}
