package com.educode.events;

import com.educode.nodes.method.MethodDeclarationNode;
import com.educode.nodes.method.ParameterNode;
import com.educode.types.Type;

import java.util.List;

/**
 * Created by zen on 4/26/17.
 */
public abstract class EventTypeBase
{
    public abstract List<Type> getRequiredParameters();
    public abstract String getName();

    public boolean matchesWithDeclaration(MethodDeclarationNode node)
    {
        List<Type> requiredTypes = getRequiredParameters();
        List<ParameterNode> parameters = node.getParameters();
        if (parameters.size() != requiredTypes.size())
            return false;

        // Check if types of parameters match
        for (int i = 0; i < parameters.size(); i++)
        {
            if (!parameters.get(i).isType(requiredTypes.get(i)))
                return false;
        }

        return true;
    }

    @Override
    public String toString()
    {
        return this.getName();
    }
}
