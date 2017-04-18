package com.educode.symboltable;

import com.educode.Referencing;
import com.educode.nodes.base.Node;
import com.educode.nodes.method.MethodDeclarationNode;
import com.educode.nodes.referencing.Reference;

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

    public MethodDeclarationNode getCurrentParentMethod()
    {
        return this._currentParentMethod;
    }

    public void setCurrentParentMethod(MethodDeclarationNode newParentMethod)
    {
        this._currentParentMethod = newParentMethod;
    }

    public void openScope()
    {
        _current = new SymbolTable(_current);
    }

    public void closeScope()
    {
        if (_current != null)
            _current = _current.getOuter();
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
        if (!(node instanceof Referencing))
        {
            error(node, "Class %s is not a referencing instance.", node.getClass().getName());
            return;
        }

        // In scope - attempt to enter symbol
        Reference reference = ((Referencing) node).getReference();
        Symbol existing = retrieveSymbol(node);

        if (existing == null)
            _current.insert(new Symbol(reference, node));
        else
            error(node, "Symbol %s previously declared at line %d.", reference, existing.getSourceNode().getLineNumber());
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
        this._messageList.add(new SymbolTableMessage(SymbolTableMessage.MessageType.ERROR, relatedNode, String.format(description, args)));
    }

    public void warning(Node relatedNode, String description, Object ... args)
    {
        this._messageList.add(new SymbolTableMessage(SymbolTableMessage.MessageType.WARNING, relatedNode, String.format(description, args)));
    }
}
