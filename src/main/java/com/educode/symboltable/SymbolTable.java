package com.educode.symboltable;

import com.educode.IReferencing;
import com.educode.nodes.base.ListNode;
import com.educode.nodes.base.Node;
import com.educode.nodes.method.MethodDeclarationNode;
import com.educode.nodes.method.ParameterNode;
import com.educode.nodes.referencing.IReference;
import com.educode.nodes.referencing.IdentifierReferencingNode;
import com.educode.nodes.statement.VariableDeclarationNode;
import com.educode.types.Type;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by User on 15-Apr-17.
 */
public class SymbolTable
{
    private SymbolTable _outer;
    private int _maxDeclaredVariables = 0;
    private int _declaredVariableCounter = 0;

    private final List<Symbol> _symbolList = new ArrayList();


    public SymbolTable(SymbolTable outer)
    {
        this._outer = outer;
    }

    public SymbolTable getOuter()
    {
        return this._outer;
    }

    private Symbol retrieveIdentifierSymbol(IdentifierReferencingNode identifier)
    {
        for (Symbol symbol : this._symbolList)
        {
            if (symbol.getSourceNode() instanceof MethodDeclarationNode || !(symbol.getReference() instanceof IdentifierReferencingNode))
                continue;

            // Check if text matches
            IdentifierReferencingNode otherIdentifier = (IdentifierReferencingNode) symbol.getReference();
            if (identifier.getText().equals(otherIdentifier.getText()))
                return symbol;
        }

        return null;
    }

    private Symbol retrieveMethodSymbol(MethodDeclarationNode node)
    {
        for (Symbol symbol : this._symbolList)
        {
            if (!(symbol.getSourceNode() instanceof MethodDeclarationNode))
                continue;

            if ((symbol.getSourceNode()).equals(node))
                return symbol;
        }

        return null;
    }

    public int getMaxDeclaredVariableCounter() { return _maxDeclaredVariables; }
    public void setMaxDeclaredVariables(int value) { _maxDeclaredVariables = value; }

    public void addDeclaredVariableCounter(int value)
    {
        _declaredVariableCounter += value;
        if (_declaredVariableCounter > _maxDeclaredVariables)
            _maxDeclaredVariables = _declaredVariableCounter;
    }

    public int getDeclaredVariableCounter() { return _declaredVariableCounter; }

    public Symbol retrieveMethodSymbol(IReference reference, List<Type> actualArguments)
    {
        for (Symbol symbol : this._symbolList)
        {
            if (!(symbol.getSourceNode() instanceof MethodDeclarationNode))
                continue;

            if (((MethodDeclarationNode) symbol.getSourceNode()).correspondsWith(reference, actualArguments))
                return symbol;
        }

        if (getOuter() != null)
            return getOuter().retrieveMethodSymbol(reference, actualArguments);
        else
            return null;
    }

    public void insert(Symbol symbol)
    {
        this._symbolList.add(symbol);
    }

    public Symbol retrieveSymbol(Node origin)
    {
        Symbol ans;

        if (origin instanceof IdentifierReferencingNode)
            ans = retrieveIdentifierSymbol((IdentifierReferencingNode) origin);
        else if (origin instanceof MethodDeclarationNode)
            ans = retrieveMethodSymbol((MethodDeclarationNode) origin);
        else if (origin instanceof IReferencing && ((IReferencing) origin).getReference() instanceof IdentifierReferencingNode)
            ans = retrieveIdentifierSymbol((IdentifierReferencingNode) ((IReferencing) origin).getReference());
        else
        {
            System.out.println("No retriever for " + origin.getClass().getName());
            return null;
        }

        // Look in outer symbol table, otherwise return null
        if (ans == null && getOuter() != null)
            return getOuter().retrieveSymbol(origin);
        else
            return ans;
    }

    public void addDefaultField(String name, Type type)
    {
        IdentifierReferencingNode reference = new IdentifierReferencingNode(name);
        VariableDeclarationNode node = new VariableDeclarationNode(reference, type);

        this.insert(new Symbol(reference, node));
    }

    public Symbol addDefaultMethod(String name, Type returnType, Type ... parameterTypes)
    {
        return addDefaultMethod(name, returnType, Arrays.asList(parameterTypes));
    }

    public Symbol addDefaultMethod(String name, Type returnType, List<Type> parameterTypes)
    {
        ListNode parameterNodes = new ListNode();
        for (Type type : parameterTypes)
            parameterNodes.addChild(new ParameterNode(null, type));

        IdentifierReferencingNode reference = new IdentifierReferencingNode(name);
        MethodDeclarationNode node = new MethodDeclarationNode(parameterNodes, null, reference, returnType);

        Symbol toInsert = new Symbol(reference, node);
        this.insert(toInsert);
        return toInsert;
    }
}