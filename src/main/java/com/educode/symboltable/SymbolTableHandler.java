package com.educode.symboltable;

import com.educode.errorhandling.ErrorHandler;
import com.educode.nodes.IReferencing;
import com.educode.nodes.base.Node;
import com.educode.nodes.method.MethodDeclarationNode;
import com.educode.nodes.referencing.IReference;

/**
 * Created by User on 15-Apr-17.
 */
public class SymbolTableHandler extends ErrorHandler
{
    private SymbolTable _current;
    private MethodDeclarationNode _currentParentMethod;

    public SymbolTableHandler(SymbolTable base)
    {
        _current = base;
    }

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
            parserError("Attempted to close scope outside of a scope.");
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
            parserError("Attempted to enter symbol outside of a scope.");
            return;
        }

        // Check if node is referencing
        if (!(node instanceof IReferencing))
        {
            parserError(node, "Class %s is not a referencing instance.", node.getClass().getName());
            return;
        }

        // In scope - attempt to enter symbol
        IReference reference = ((IReferencing) node).getReference();
        Symbol existing = retrieveSymbol(node);

        if (existing == null)
            _current.insert(new Symbol(reference, node, getInputSource()));
        else
        {
            if (getInputSource()==existing.getInputSource())
                parserError(node, "Symbol %s previously declared at line %d.", reference, existing.getSourceNode().getLineNumber());
            else
                parserError(existing.getInputSource(), node, "Symbol %s previously declared at line %d", reference, existing.getSourceNode().getLineNumber());
        }

    }
}
