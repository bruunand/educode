package com.educode.nodes.ungrouped;

import com.educode.nodes.base.LeafNode;
import com.educode.visitors.VisitorBase;

/**
 * Created by Thomas Buhl on 17/05/2017.
 */
public class ImportNode extends LeafNode
{
    private String _identifier;
    private StartNode _importedNode;

    public ImportNode(String identifier)
    {
        this._identifier = identifier;
    }

    @Override
    public Object accept(com.educode.visitors.AbstractVisitor visitor)
    {
        return visitor.visit(this);
    }

    public String getText()
    {
        return this._identifier;
    }

    public StartNode getImportedNode()
    {
        return _importedNode;
    }

    public void setImportedNode(StartNode node)
    {
        _importedNode = node;
    }

    @Override
    public String toString()
    {
        return this.getText();
    }

    @Override
    public boolean equals(Object other)
    {
        if (other instanceof ImportNode)
            return ((ImportNode) other).getText().equals(this.getText());
        else
            return other instanceof String && other.equals(this.getText());
    }
}
