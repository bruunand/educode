package com.educode.visitors;

import com.educode.helper.OperatorTranslator;
import com.educode.nodes.base.CollectionNode;
import com.educode.nodes.base.NaryNode;
import com.educode.nodes.base.Node;
import com.educode.nodes.expression.AdditionExpression;
import com.educode.nodes.expression.ArithmeticExpression;
import com.educode.nodes.expression.MultiplicationExpression;
import com.educode.nodes.expression.logic.*;
import com.educode.nodes.literal.BoolLiteralNode;
import com.educode.nodes.literal.IdentifierLiteralNode;
import com.educode.nodes.literal.NumberLiteralNode;
import com.educode.nodes.literal.StringLiteralNode;
import com.educode.nodes.method.MethodDeclarationNode;
import com.educode.nodes.method.MethodInvokationNode;
import com.educode.nodes.method.ParameterNode;
import com.educode.nodes.statement.AssignmentNode;
import com.educode.nodes.statement.ReturnNode;
import com.educode.nodes.statement.VariableDeclarationNode;
import com.educode.nodes.statement.conditional.ConditionNode;
import com.educode.nodes.statement.conditional.IfNode;
import com.educode.nodes.statement.conditional.RepeatWhileNode;
import com.educode.nodes.ungrouped.BlockNode;
import com.educode.nodes.ungrouped.ProgramNode;

import java.io.FileWriter;
import java.util.ArrayList;

/**
 * Created by zen on 3/24/17.
 */
public class CodeGenerationVisitor extends VisitorBase
{
    private StringBuffer _codeBuffer = new StringBuffer();

    private FileWriter fw;

    public void append(String format, Object ... args)
    {
        try
        {
            _codeBuffer.append(String.format(format, args));
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    @Override
    public Object visit(ProgramNode node)
    {
        append("public class %s {\n", node.getIdentifier());

        // Visit method declarations
        for (Node child : node.getChildren())
        {
            if (child instanceof NaryNode)
            {
                for (Node grandchild : ((NaryNode) child).getChildren())
                    visit(grandchild);
            }
            else
                visit(child);
        }

        // Append closing curly bracket
        append("}");

        // Write codeBuffer to file
        try
        {
            fw = new FileWriter("test.java");
            fw.append(_codeBuffer);
            fw.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public Object visit(BlockNode node)
    {
        append("{\n");

        // Visit statements in block
        for (Node child : node.getChildren())
            visit(child);

        append("}\n");

        return null;
    }

    @Override
    public Object visit(CollectionNode node)
    {
        for (Node child : node.getChildren())
            visit(child);

        return null;
    }

    @Override
    public Object visit(MethodDeclarationNode node)
    {
        String parameters = "";

        // Concatenate parameters
        if (node.getRightChild() != null)
        {
            for (Node child : ((CollectionNode)node.getRightChild()).getChildren())
            {
                parameters += visit(child) + ",";
            }

            if (!parameters.isEmpty())
                parameters = parameters.substring(0, parameters.length() - 1);
        }

        append("public %s %s(%s)\n", OperatorTranslator.ToJava(node.getType()), node.getIdentifier(), parameters);

        // Visit block
        visit(node.getLeftChild());

        return null;
    }

    @Override
    public Object visit(MethodInvokationNode node)
    {
        // Concatenate actual arguments
        String arguments = "";
        if (node.getChild() != null)
        {
            for (Node argNode : ((CollectionNode)node.getChild()).getChildren())
                arguments += visit(argNode) + ",";

            // Remove last argument separator
            if (!arguments.isEmpty())
                arguments = arguments.substring(0, arguments.length() - 1);
        }

        append("%s(%s);\n", node.getIdentifier(), arguments);

        return null;
    }

    @Override
    public Object visit(ParameterNode node)
    {
        return String.format("%s %s", OperatorTranslator.ToJava(node.getType()), node.getIdentifier());
    }

    @Override
    public Object visit(AssignmentNode node)
    {
        append("%s = %s;\n", node.getIdentifier(), visit(node.getChild()));

        return null;
    }

    @Override
    public Object visit(VariableDeclarationNode node)
    {
        append("%s %s;\n", OperatorTranslator.ToJava(node.getType()), node.getIdentifier());
        if (node.getChild() != null)
            visit(node.getChild());

        return null;
    }

    @Override
    public Object visit(IfNode node)
    {
        ArrayList<ConditionNode> conditions = node.getConditionBlocks();

        int i = 0;
        for (ConditionNode condition : conditions)
        {
            if (i++ == 0)
                append("if (%s)\n", visit(condition.getLeftChild()));
            else
                append("else if (%s)\n", visit(condition.getLeftChild()));

            visit(condition.getRightChild());
        }

        // Visit else block if any
        BlockNode elseBlock = node.getElseBlock();
        if (elseBlock != null)
        {
            append("else\n");

            visit(elseBlock);
        }
        return null;
    }

    @Override
    public Object visit(ConditionNode node)
    {
        return null;
    }

    @Override
    public Object visit(RepeatWhileNode node)
    {
        ConditionNode condition = (ConditionNode) node.getChild();

        append("while (%s)\n", visit(condition.getLeftChild()));
        visit(condition.getRightChild());

        return null;
    }

    @Override
    public Object visit(ReturnNode node)
    {
        if (node.getChild() != null)
            append("return %s;\n", visit(node.getChild()));
        else
            append("return;\n");

        return null;
    }

    @Override
    public Object visit(MultiplicationExpression node)
    {
        return String.format("(%s %s %s)", visit(node.getLeftChild()), OperatorTranslator.ToJava(node.getOperator()), visit(node.getRightChild()));
    }

    @Override
    public Object visit(AdditionExpression node)
    {
        return String.format("(%s %s %s)", visit(node.getLeftChild()), OperatorTranslator.ToJava(node.getOperator()), visit(node.getRightChild()));
    }

    @Override
    public Object visit(NumberLiteralNode node)
    {
        return node.getValue();
    }

    @Override
    public Object visit(StringLiteralNode node)
    {
        return node.getValue();
    }

    @Override
    public Object visit(IdentifierLiteralNode node)
    {
        return node.getIdentifier();
    }

    @Override
    public Object visit(BoolLiteralNode node)
    {
        return node.getValue();
    }

    @Override
    public Object visit(OrExpressionNode node)
    {
        return String.format("(%s || %s)", visit(node.getLeftChild()), visit(node.getRightChild()));
    }

    @Override
    public Object visit(AndExpressionNode node)
    {
        return String.format("(%s && %s)", visit(node.getLeftChild()), visit(node.getRightChild()));
    }

    @Override
    public Object visit(RelativeExpressionNode node)
    {
        return String.format("%s %s %s", visit(node.getLeftChild()), OperatorTranslator.ToJava(node.getOperator()), visit(node.getRightChild()));
    }

    @Override
    public Object visit(EqualExpressionNode node)
    {
        return String.format("%s %s %s", visit(node.getLeftChild()), OperatorTranslator.ToJava(node.getOperator()), visit(node.getRightChild()));
    }

    @Override
    public Object visit(NegateNode node)
    {
        return String.format("!(%s)", visit(node.getChild()));
    }
}
