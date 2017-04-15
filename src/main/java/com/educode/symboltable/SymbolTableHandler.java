package com.educode.symboltable;

import com.educode.Referencing;
import com.educode.nodes.base.Node;
import com.educode.nodes.referencing.IdentifierReferencing;
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

    public void enterSymbol(Node node)
    {
        if (_current == null)
        {
            error("Attempted to enter symbol outside of a scope.");
            return;
        }

        // In scope - attempt to enter symbol
        if (node instanceof Referencing)
        {
            Reference reference = ((Referencing) node).getReference();

            if (reference instanceof IdentifierReferencing)
            {
                Symbol previousSymbol = _current.retrieveSymbol(reference);
                if (previousSymbol == null)
                    _current.insert(new Symbol(reference, node));
                else
                    error(node, "Identifier %s previously declared at line %d.", reference, previousSymbol.getSourceNode().getLineNumber());
            }
        }
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
