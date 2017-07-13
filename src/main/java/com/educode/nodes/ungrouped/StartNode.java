package com.educode.nodes.ungrouped;

import com.educode.nodes.base.*;
import com.educode.visitors.VisitorBase;

import java.util.ArrayList;

/**
 * Created by Thomas Buhl on 10/05/2017.
 */
public class StartNode extends BinaryNode
{
    private String _inputSource;
    private boolean _isMain = false;

    public StartNode(Node leftChild, Node rightChild)
    {
        super(leftChild, rightChild);
    }

    public StartNode(String inputSource)
    {
        super(null, null);
        _inputSource = inputSource;
    }

    @Override
    public Object accept(com.educode.visitors.AbstractVisitor visitor)
    {
        return visitor.visit(this);
    }

    public void setInputSource(String source)
    {
        this._inputSource = source;
    }

    public String getInputSource()
    {
        return this._inputSource;
    }

    public void setIsMain(boolean value)
    {
        this._isMain = value;
    }

    public boolean getIsMain()
    {
        return this._isMain;
    }
}
