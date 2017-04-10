package com.educode.visitors;

import com.educode.helper.OperatorTranslator;
import com.educode.nodes.base.ListNode;
import com.educode.nodes.base.Node;
import com.educode.nodes.expression.AdditionExpression;
import com.educode.nodes.expression.MultiplicationExpression;
import com.educode.nodes.expression.logic.*;
import com.educode.nodes.literal.BoolLiteralNode;
import com.educode.nodes.literal.IdentifierLiteralNode;
import com.educode.nodes.literal.NumberLiteralNode;
import com.educode.nodes.literal.StringLiteralNode;
import com.educode.nodes.method.MethodDeclarationNode;
import com.educode.nodes.method.MethodInvocationNode;
import com.educode.nodes.method.ParameterNode;
import com.educode.nodes.statement.AssignmentNode;
import com.educode.nodes.statement.ReturnNode;
import com.educode.nodes.statement.VariableDeclarationNode;
import com.educode.nodes.statement.conditional.ConditionNode;
import com.educode.nodes.statement.conditional.IfNode;
import com.educode.nodes.statement.conditional.RepeatWhileNode;
import com.educode.nodes.ungrouped.BlockNode;
import com.educode.nodes.ungrouped.ObjectInstantiationNode;
import com.educode.nodes.ungrouped.ProgramNode;

import java.io.FileWriter;

/**
 * Created by theis on 4/10/17.
 */
public class JavaBytecodeGenerationVisitor extends VisitorBase
{
    private FileWriter fw;

    public void append(StringBuffer buffer, String format, Object ... args)
    {
        try
        {
            buffer.append(String.format(format, args));
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    @Override
    public Object visit(ProgramNode node)
    {
        StringBuffer codeBuffer = new StringBuffer();
        append(codeBuffer, ".class public %s\n", node.getIdentifier());
        append(codeBuffer, ".super java/lang/Object\n\n");
        append(codeBuffer,
                ".method public <init>()V\n" +
                "  aload_0\n"+
                "  invokespecial java/lang/Object/<init>()V\n" +
                "  return\n" +
                ".end method\n\n");

        // Visit method declarations
        for (MethodDeclarationNode methodDecl : node.getMethodDeclarations())
            append(codeBuffer, "%s", visit(methodDecl));

        // Write codeBuffer to file
        try
        {
            fw = new FileWriter(node.getIdentifier() + ".j");
            fw.append(codeBuffer);
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
        StringBuffer codeBuffer = new StringBuffer();

        for (Node child : node.getChildren())
            append(codeBuffer, "%s",visit(child));

        return codeBuffer;
    }

    @Override
    public Object visit(ListNode node)
    {
        return null;
    }

    @Override
    public Object visit(ObjectInstantiationNode node)
    {
        StringBuffer codeBuffer = new StringBuffer();

        append(codeBuffer, "  new %s\n  dup\n", node.getType());



        return null;
    }

    @Override
    public Object visit(MethodDeclarationNode node)
    {
        StringBuffer codeBuffer = new StringBuffer();

        // Visit parameters
        append(codeBuffer, ".method public %s(%s)%s\n", node.getIdentifier(), getParameters(node.getParameterList()),OperatorTranslator.toBytecode(node.getType()));

        append(codeBuffer, "  .limit stack 100\n");     //TODO: calc
        append(codeBuffer, "  .limit locals 100\n");    //TODO: calc

        // Visit block
        append(codeBuffer, "%s", visit(node.getBlockNode()));

        append(codeBuffer, ".end method\n\n");

        return codeBuffer;
    }

    @Override
    public Object visit(MethodInvocationNode node)
    {
        StringBuffer codebuffer = new StringBuffer();



        return null;
    }

    @Override
    public Object visit(ParameterNode node)
    {
        return null;
    }

    @Override
    public Object visit(AssignmentNode node)
    {
        return null;
    }

    @Override
    public Object visit(VariableDeclarationNode node)
    {
        return null;
    }

    @Override
    public Object visit(IfNode node)
    {
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
        return null;
    }

    @Override
    public Object visit(ReturnNode node)
    {
        return null;
    }

    @Override
    public Object visit(MultiplicationExpression node)
    {
        return null;
    }

    @Override
    public Object visit(AdditionExpression node)
    {
        return null;
    }

    @Override
    public Object visit(NumberLiteralNode node)
    {
        return null;
    }

    @Override
    public Object visit(StringLiteralNode node)
    {
        return null;
    }

    @Override
    public Object visit(IdentifierLiteralNode node)
    {
        return null;
    }

    @Override
    public Object visit(BoolLiteralNode node)
    {
        return null;
    }

    @Override
    public Object visit(OrExpressionNode node)
    {
        return null;
    }

    @Override
    public Object visit(AndExpressionNode node)
    {
        return null;
    }

    @Override
    public Object visit(RelativeExpressionNode node)
    {
        return null;
    }

    @Override
    public Object visit(EqualExpressionNode node)
    {
        return null;
    }

    @Override
    public Object visit(NegateNode node)
    {
        return null;
    }

    public String getParameters(Node node)
    {
        String parameters = "";

        if (node == null)
            return parameters;

        for (Node child : ((ListNode) node).getChildren())
            parameters += visit(child) + ",";

        if (!parameters.isEmpty())
            parameters = parameters.substring(0, parameters.length() - 1);

        return parameters;
    }
}
