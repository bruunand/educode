package com.educode.nodes.method;

import com.educode.nodes.Identifiable;
import com.educode.nodes.Typeable;
import com.educode.nodes.base.BinaryNode;
import com.educode.nodes.base.ListNode;
import com.educode.nodes.base.Node;
import com.educode.nodes.base.UnaryNode;
import com.educode.nodes.ungrouped.BlockNode;
import com.educode.types.Type;
import com.educode.visitors.VisitorBase;

/**
 * Created by zen on 3/9/17.
 */
public class MethodDeclarationNode extends BinaryNode implements Identifiable, Typeable
{
    private String _identifier;
    private Type _returnType;

    public MethodDeclarationNode(Node leftChild, Node rightChild, String identifier, Type returnType)
    {
        super(leftChild, rightChild);
        this._identifier = identifier;
        this._returnType = returnType;
    }

    public ListNode getParameterList()
    {
        return (ListNode) this.getLeftChild();
    }

    public boolean hasParameterList()
    {
        return this.hasLeftChild();
    }

    public BlockNode getBlockNode()
    {
        return (BlockNode) this.getRightChild();
    }

    @Override
    public String getIdentifier()
    {
        return this._identifier;
    }

    @Override
    public Object accept(VisitorBase visitor)
    {
        return visitor.visit(this);
    }

    @Override
    public Type getType()
    {
        return this._returnType;
    }

    @Override
    public void setType(Type type)
    {
        if (_returnType != null)
            return;
        _returnType = type;
    }
}
