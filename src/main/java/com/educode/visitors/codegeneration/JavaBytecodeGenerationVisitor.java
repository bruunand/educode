package com.educode.visitors.codegeneration;

import com.educode.helper.OperatorTranslator;
import com.educode.helper.Tuple;
import com.educode.nodes.base.ListNode;
import com.educode.nodes.base.Node;
import com.educode.nodes.expression.AdditionExpression;
import com.educode.nodes.expression.MultiplicationExpression;
import com.educode.nodes.expression.logic.*;
import com.educode.nodes.literal.*;
import com.educode.nodes.method.MethodDeclarationNode;
import com.educode.nodes.method.MethodInvocationNode;
import com.educode.nodes.method.ParameterNode;
import com.educode.nodes.statement.AssignmentNode;
import com.educode.nodes.statement.ForEachNode;
import com.educode.nodes.statement.ReturnNode;
import com.educode.nodes.statement.VariableDeclarationNode;
import com.educode.nodes.statement.conditional.ConditionNode;
import com.educode.nodes.statement.conditional.IfNode;
import com.educode.nodes.statement.conditional.RepeatWhileNode;
import com.educode.nodes.ungrouped.BlockNode;
import com.educode.nodes.ungrouped.ObjectInstantiationNode;
import com.educode.nodes.ungrouped.ProgramNode;
import com.educode.nodes.ungrouped.TypeCastNode;
import com.educode.types.Type;
import com.educode.visitors.VisitorBase;

import java.io.FileWriter;
import java.util.ArrayList;

/**
 * Created by theis on 4/10/17.
 */
public class JavaBytecodeGenerationVisitor extends VisitorBase
{
    private int OffSet;
    private int LabelCounter;
    private ArrayList<Tuple<IdentifierLiteralNode, Integer>> DeclarationOffsetTable = new ArrayList<Tuple<IdentifierLiteralNode, Integer>>();

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
        append(codeBuffer, ".method public <init>()V\n" );
        append(codeBuffer, "  aload_0\n");
        append(codeBuffer, "  invokespecial java/lang/Object/<init>()V\n");
        append(codeBuffer, "  return\n");
        append(codeBuffer, ".end method\n\n");

        // Visit method declarations
        for (MethodDeclarationNode methodDecl : node.getMethodDeclarations())
            append(codeBuffer, "%s", visit(methodDecl));

        // Write codeBuffer to file
        try
        {
            FileWriter fw = new FileWriter(node.getIdentifier() + ".j");
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
        int StartOffset = OffSet;

        for (Node child : node.getChildren())
            append(codeBuffer, "%s",visit(child));

        for (int i = 0; i < OffSet - StartOffset; i++)
            DeclarationOffsetTable.remove(--OffSet);

        OffSet = StartOffset;
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

        for (Node child:node.getActualArguments())
            append(codeBuffer, "%s", visit(child));

        append(codeBuffer, "  invokespecial %s\n", node.getType());

        return null;
    }

    @Override
    public Object visit(MethodDeclarationNode node)
    {
        StringBuffer codeBuffer = new StringBuffer();

        OffSet = 0;
        LabelCounter = 0;

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
        StringBuffer codeBuffer = new StringBuffer();

        append(codeBuffer, "  aload_0\n");

        for (Node child:node.getActualArguments())
            append(codeBuffer, "%s", visit(child));

        append(codeBuffer, "  invokespecial Namespace\n"); //TODO: Get namespace

        return codeBuffer;
    }

    @Override
    public Object visit(ParameterNode node)
    {
        return null;
    }

    @Override
    public Object visit(AssignmentNode node)
    {
        StringBuffer codeBuffer = new StringBuffer();

        append(codeBuffer, "%s", visit(node.getChild()));
        append(codeBuffer, "  dup\n");

        switch (node.getIdentifierNode().getType().Kind)
        {
            case Type.NUMBER:
                append(codeBuffer, "  dstore %s\n", getOffSetByNode(node.getIdentifierNode()));
                break;
            case Type.BOOL:
                append(codeBuffer, "  istore %s\n", getOffSetByNode(node.getIdentifierNode()));
                break;
            default:
                if (node.getIdentifierNode().getType().isReferenceType())
                    append(codeBuffer, "  astore %s\n", getOffSetByNode(node.getIdentifierNode()));
                break;
                //TODO:ERROR
        }

        return codeBuffer;
    }

    @Override
    public Object visit(VariableDeclarationNode node)
    {
        StringBuffer codeBuffer = new StringBuffer();
        DeclarationOffsetTable.add(new Tuple<IdentifierLiteralNode, Integer>(node.getIdentifierNode(), ++OffSet));

        if (!node.hasChild())
            return "";

        append(codeBuffer, "%s", visit(((AssignmentNode) node.getChild()).getChild()));

        switch (node.getType().Kind)
        {
            case Type.NUMBER:
                append(codeBuffer, "  dstore %s\n", OffSet);
                break;
            case Type.BOOL:
                append(codeBuffer, "  istore %s\n", OffSet);
                break;
            default:
                if (node.getType().isReferenceType())
                    append(codeBuffer, "  astore %s\n", OffSet);

                //TODO: Some error if not reference
                break;
        }

        return codeBuffer;
    }

    @Override
    public Object visit(IfNode node) //TODO: MIGHT NOT BE CORRECT
    {
        StringBuffer codeBuffer = new StringBuffer();
        int EndIfLabel = LabelCounter++;
        boolean First = true;
        ArrayList<ConditionNode> ConditionNodeList = node.getConditionBlocks();
        if (ConditionNodeList.size() == 1)
        {
            append(codeBuffer, "%s", visit(ConditionNodeList.get(0).getLeftChild()));
            append(codeBuffer, "  ifeq L%s\n", EndIfLabel);
            append(codeBuffer, "%s", ConditionNodeList.get(0).getRightChild());
        }
        else
        {
            for (int i = 0; i < ConditionNodeList.size(); i++)
            {
                if (i != 0)
                {
                    append(codeBuffer, "L%s:\n", LabelCounter++);
                }

                if (i + 1 == ConditionNodeList.size())
                {
                    if (ConditionNodeList.get(i).hasLeftChild())
                    {
                        append(codeBuffer, "%s", visit(ConditionNodeList.get(i).getLeftChild()));
                        append(codeBuffer, "  ifeq L%s\n", EndIfLabel);
                    }

                    append(codeBuffer, "%s", ConditionNodeList.get(i).getRightChild());
                }
                else
                {
                    append(codeBuffer, "%s", visit(ConditionNodeList.get(i)));
                    append(codeBuffer, "  goto L%s\n", EndIfLabel);
                }



            }
        }

        append(codeBuffer, "L%s:\n", EndIfLabel);
        append(codeBuffer, "  nop\n");

        return codeBuffer;
    }

    @Override
    public Object visit(ConditionNode node)
    {
        StringBuffer codeBuffer = new StringBuffer();

        append(codeBuffer, "%s", visit(node.getLeftChild()));
        append(codeBuffer, "  ifeq L%s\n", LabelCounter);
        append(codeBuffer, "%s", node.getRightChild());

        return codeBuffer;
    }

    @Override
    public Object visit(RepeatWhileNode node)
    {
        StringBuffer codeBuffer = new StringBuffer();
        int  conditionLabel = LabelCounter++;

        append(codeBuffer, "  goto L%s\n", conditionLabel);
        append(codeBuffer, "L%s:\n", LabelCounter);
        append(codeBuffer, "%s", visit(((ConditionNode) node.getChild()).getRightChild()));
        append(codeBuffer, "L%s:\n", conditionLabel);
        append(codeBuffer, "%s", visit(((ConditionNode) node.getChild()).getLeftChild()));
        append(codeBuffer, "  ifne L%s\n", LabelCounter++);

        return codeBuffer;
    }

    @Override
    public Object visit(ForEachNode node)
    {
        // TODO
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
    public Object visit(CoordinatesLiteralNode node)
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

    @Override
    public Object visit(TypeCastNode node)
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

    public int getOffSetByNode(IdentifierLiteralNode node)
    {
        for (Tuple<IdentifierLiteralNode, Integer> tuple: DeclarationOffsetTable)
        {
            if (tuple._x.getIdentifier().equals(node.getIdentifier()))
                return tuple._y;
        }

        return -1;
    }
}

