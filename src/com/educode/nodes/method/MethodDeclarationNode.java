package com.educode.nodes.method;

import com.educode.nodes.Identifiable;
import com.educode.nodes.Typeable;
import com.educode.nodes.base.BinaryNode;
import com.educode.nodes.base.ListNode;
import com.educode.nodes.base.Node;
import com.educode.nodes.base.UnaryNode;
import com.educode.nodes.expression.ExpressionNode;
import com.educode.nodes.ungrouped.BlockNode;
import com.educode.types.Type;
import com.educode.visitors.VisitorBase;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

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

    public ArrayList<ParameterNode> getParameters()
    {
        ArrayList<ParameterNode> nodeList = new ArrayList<>();

        if (!hasParameterList())
            return nodeList; // Return an empty list

        // Add all parameter nodes from child
        for (Node grandchild : getParameterList().getChildren())
        {
            if (grandchild instanceof ParameterNode)
                nodeList.add((ParameterNode) grandchild);
        }

        return nodeList;
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

    // Check if declaration corresponds to an invocation
    public boolean corresponds(MethodInvocationNode invocationNode)
    {
        // Check if name matches
        if (!this.getIdentifier().equals(invocationNode.getIdentifier()))
            return false;

        // Get formal and actual arguments
        List<ParameterNode> formalParameters = this.getParameters();
        List<Node> actualArguments = invocationNode.getActualArguments();

        // Check if amount matches
        if (formalParameters.size() != actualArguments.size())
            return false;

        // Check parameter one by one to match type
        for (int i = 0; i < formalParameters.size(); i++)
        {
            Type formalType = formalParameters.get(0).getType();
            Type actualType = ((Typeable)actualArguments.get(0)).getType();

            if (!formalType.equals(actualType))
            {
                return false;
            }
        }

        return true;
    }

    @Override
    public boolean equals(Object other)
    {
        if (!(other instanceof MethodDeclarationNode))
            return false;
        else
        {
            MethodDeclarationNode otherNode = (MethodDeclarationNode) other;

            // Check if name matches
            if (!this.getIdentifier().equals(otherNode.getIdentifier()))
                return false;

            // Get list of parameters for each node
            List<ParameterNode> ownParameters = this.getParameters();
            List<ParameterNode> otherParameters = otherNode.getParameters();

            // Check if amount match
            if (ownParameters.size() != otherParameters.size())
                return false;

            // Amount of parameters match, now check if each parameter matches in same order
            for (int i = 0; i < ownParameters.size(); i++)
            {
                if (!ownParameters.get(i).equals(otherParameters.get(i)))
                    return false;
            }

            return true;
        }
    }

}
