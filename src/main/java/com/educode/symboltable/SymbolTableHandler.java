package com.educode.symboltable;

import com.educode.IReferencing;
import com.educode.nodes.base.Node;
import com.educode.nodes.method.MethodDeclarationNode;
import com.educode.nodes.referencing.IReference;
import com.educode.nodes.ungrouped.StartNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by User on 15-Apr-17.
 */
public class SymbolTableHandler
{
    private final List<SymbolTableMessage> _messageList = new ArrayList<>();
    private SymbolTable _current;
    private MethodDeclarationNode _currentParentMethod;
    private StartNode _inputSource = null;

    public SymbolTableHandler(SymbolTable base)
    {
        _current = base;
    }

    public MethodDeclarationNode getCurrentParentMethod()
    {
        return this._currentParentMethod;
    }

    public void setInputSource(StartNode source)
    {
        this._inputSource = source;
    }
    public StartNode getInputSource()
    {
        return this._inputSource;
    }

    public void setCurrentParentMethod(MethodDeclarationNode newParentMethod)
    {
        this._currentParentMethod = newParentMethod;
    }

    public void openScope()
    {
        _current = new SymbolTable(_current);
        _current.addDeclaredVariableCounter(_current.getOuter().getDeclaredVariableCounter());
    }

    public void closeScope()
    {
        if (_current != null)
        {
            _current.getOuter().setMaxDeclaredVariables(_current.getMaxDeclaredVariableCounter());
            _current = _current.getOuter();
        }
        else
            error("Attempted to close scope outside of a scope.");
    }

    public SymbolTable getCurrent()
    {
        return this._current;
    }

    public Symbol retrieveSymbol(Node origin)
    {
        return getCurrent().retrieveSymbol(origin);
    }

    public void enterSymbol(Node node)
    {
        if (_current == null)
        {
            error("Attempted to enter symbol outside of a scope.");
            return;
        }

        // Check if node is referencing
        if (!(node instanceof IReferencing))
        {
            error(node, "Class %s is not a referencing instance.", node.getClass().getName());
            return;
        }

        // In scope - attempt to enter symbol
        IReference reference = ((IReferencing) node).getReference();
        Symbol existing = retrieveSymbol(node);

        if (existing == null)
            _current.insert(new Symbol(reference, node, _inputSource));
        else
        {
            if (getInputSource()==existing.getInputSource())
                error(node, "Symbol %s previously declared at line %d.", reference, existing.getSourceNode().getLineNumber());
            else
                error(existing.getInputSource(), node, "Symbol %s previously declared at line %d", reference, existing.getSourceNode().getLineNumber());
        }

    }

    public boolean hasErrors()
    {
        for (SymbolTableMessage message : _messageList)
        {
            if (message.getType() == SymbolTableMessage.MessageType.ERROR)
                return true;
        }

        return false;
    }

    public void printMessages()
    {
        for (SymbolTableMessage message : _messageList)
            System.out.println(message);
    }

    private void error(String description, Object ... args)
    {
        error(null, description, args);
    }

    public void error(Node relatedNode, String description, Object ... args)
    {
        this._messageList.add(new SymbolTableMessage(SymbolTableMessage.MessageType.ERROR, relatedNode, String.format(description, args), getInputSource()));
    }

    public void error(StartNode conflictSource, Node relatedNode, String description, Object ... args)
    {
        this._messageList.add(new SymbolTableMessage(SymbolTableMessage.MessageType.ERROR, relatedNode, String.format(description, args), getInputSource(), conflictSource));
    }

    public void warning(Node relatedNode, String description, Object ... args)
    {
        this._messageList.add(new SymbolTableMessage(SymbolTableMessage.MessageType.WARNING, relatedNode, String.format(description, args), getInputSource()));
    }

    public List<SymbolTableMessage> getMessages()
    {
        return this._messageList;
    }
}
