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
import org.stringtemplate.v4.ST;

import java.io.FileWriter;
import java.net.Proxy;
import java.util.ArrayList;

/**
 * Created by theis on 4/10/17.
 */
public class JavaBytecodeGenerationVisitor extends VisitorBase
{
    private FileWriter fw;
    private int OffSet;
    private int LabelCounter;
    private ArrayList<Tuple<IdentifierLiteralNode, Integer>> DeclaratoinOffsetTable = new ArrayList<Tuple<IdentifierLiteralNode, Integer>>();

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

    public Object defaultVisit(Node node)
    {
        return "NOT IMPLEMENTED:" + node.getClass().getName();
    }
    
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

    
    public Object visit(BlockNode node)
    {
        StringBuffer codeBuffer = new StringBuffer();
        int StartOffset = OffSet;

        for (Node child : node.getChildren())
            append(codeBuffer, "%s",visit(child));

        for (int i = 0; i < OffSet - StartOffset; i++)
            DeclaratoinOffsetTable.remove(--OffSet);

        OffSet = StartOffset;
        return codeBuffer;
    }

    
    public Object visit(ListNode node)
    {
        return null;
    }

    
    public Object visit(ObjectInstantiationNode node)
    {
        StringBuffer codeBuffer = new StringBuffer();

        append(codeBuffer, "  new %s\n", node.getType());
        //append(codeBuffer, "  dup\n");

        for (Node child:node.getActualArguments())
            append(codeBuffer, "%s", visit(child));

        append(codeBuffer, "  invokespecial %s\n", node.getType());

        return null;
    }

    
    public Object visit(MethodDeclarationNode node)
    {
        StringBuffer codeBuffer = new StringBuffer();

        OffSet = 0;
        LabelCounter = 0;
        if (node.getIdentifier().equals("main"))
            append(codeBuffer, ".method public static main([Ljava/lang/String;)V\n");
        else
        {
            // Visit parameters
            append(codeBuffer, ".method public %s(%s)%s\n", node.getIdentifier(), getParameters(node.getParameterList()),OperatorTranslator.toBytecode(node.getType()));
        }

        append(codeBuffer, "  .limit stack 100\n");     //TODO: calc
        append(codeBuffer, "  .limit locals 100\n");    //TODO: calc

        // Visit block
        append(codeBuffer, "%s", visit(node.getBlockNode()));

        append(codeBuffer, ".end method\n\n");

        return codeBuffer;
    }

    
    public Object visit(MethodInvocationNode node)
    {
        StringBuffer codeBuffer = new StringBuffer();

        append(codeBuffer, "  aload_0\n");

        for (Node child:node.getActualArguments())
            append(codeBuffer, "%s", visit(child));

        append(codeBuffer, "  invokespecial Namespace\n"); //TODO: Get namespace

        return codeBuffer;
    }

    
    public Object visit(ParameterNode node)
    {
        return OperatorTranslator.toBytecode(node.getType());
    }

    
    public Object visit(AssignmentNode node)
    {
        StringBuffer codeBuffer = new StringBuffer();

        append(codeBuffer, "%s", visit(node.getChild()));
        //append(codeBuffer, "  dup\n");

        append(codeBuffer, "  %sstore %s\n", getPrefix(node.getIdentifierNode().getType()),getOffSetByNode(node.getIdentifierNode()));

        return codeBuffer;
    }

    
    public Object visit(VariableDeclarationNode node)
    {
        StringBuffer codeBuffer = new StringBuffer();
        DeclaratoinOffsetTable.add(new Tuple<IdentifierLiteralNode, Integer>(node.getIdentifierNode(), ++OffSet));

        if (!node.hasChild())
            return "";



        append(codeBuffer, "%s", visit(((AssignmentNode) node.getChild()).getChild()));

        append(codeBuffer, "  %sstore %s\n", getPrefix(node.getType()),getOffSetByNode(node.getIdentifierNode()));

        return codeBuffer;
    }

    
    public Object visit(IfNode node)
    {
        StringBuffer codeBuffer = new StringBuffer();
        int endIfLabel = LabelCounter++;
        int label;
        boolean first = true;
        ArrayList<ConditionNode> conditionNodeList = node.getConditionBlocks();

        append(codeBuffer, "%s", visit(conditionNodeList.get(0)));
        //append(codeBuffer, "  pop\n");
        append(codeBuffer, "  goto L%s\n", endIfLabel);

        for (int i = 1; i < conditionNodeList.size(); i++)
        {
            append(codeBuffer, "L%s:\n", LabelCounter++);
            append(codeBuffer, "%s", visit(conditionNodeList.get(i)));
            //append(codeBuffer, "  pop\n");
            append(codeBuffer, "  goto L%s\n", endIfLabel);
        }

        if (node.getElseBlock() != null)
        {
            append(codeBuffer, "L%s:\n", LabelCounter++);
            append(codeBuffer, "%s", visit(node.getElseBlock()));
        }
        else
        {
            append(codeBuffer, "L%s:\n", LabelCounter++);
            append(codeBuffer, "  nop\n");
        }

        append(codeBuffer, "L%s:\n", endIfLabel);
        append(codeBuffer, "  nop\n");

        return codeBuffer;
    }

    
    public Object visit(ConditionNode node)
    {
        StringBuffer codeBuffer = new StringBuffer();
        StringBuffer tempBuffer = new StringBuffer();

        append(codeBuffer, "%s", visit(node.getLeftChild()));
        append(tempBuffer, "%s", visit(node.getRightChild()));
        append(codeBuffer, "  ifeq L%s\n", LabelCounter);
        append(codeBuffer, "%s", tempBuffer);

        return codeBuffer;
    }

    
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

    
    public Object visit(ReturnNode node)
    {
        return "  return\n";
    }

    
    public Object visit(MultiplicationExpression node)
    {
        StringBuffer codeBuffer = new StringBuffer();

        append(codeBuffer, "%s", visit(node.getLeftChild()));
        append(codeBuffer, "%s", visit(node.getRightChild()));
        append(codeBuffer, "  dmul\n");

        return codeBuffer;
    }

    
    public Object visit(AdditionExpression node)
    {
        StringBuffer codeBuffer = new StringBuffer();

        append(codeBuffer, "%s", visit(node.getLeftChild()));
        append(codeBuffer, "%s", visit(node.getRightChild()));

        if (node.getType().Kind == Type.STRING)
        {
            String s = "java/lang/String";
            append(codeBuffer, "  invokevirtual %s/concat(L%s;)L%s;\n", s, s, s);
        }
        else if (node.getType().Kind == Type.NUMBER)
            append(codeBuffer, "  fadd\n");
        else
            ;//TODO: ERROR NOT IMPLEMENTED

        return codeBuffer;
    }

    
    public Object visit(NumberLiteralNode node)
    {
        StringBuffer codeBuffer = new StringBuffer();

        append(codeBuffer, "  ldc %s\n", node.getValue());

        return codeBuffer;
    }

    
    public Object visit(StringLiteralNode node)
    {
        StringBuffer codeBuffer = new StringBuffer();

        append(codeBuffer, "  ldc_string %s\n", node.getValue());

        return codeBuffer;
    }

    
    public Object visit(IdentifierLiteralNode node)
    {
        StringBuffer codeBuffer = new StringBuffer();

        append(codeBuffer, "  %sload %s\n", getPrefix(node.getType()),getOffSetByNode(node));

        return codeBuffer;
    }

    
    public Object visit(BoolLiteralNode node)
    {
        StringBuffer codeBuffer = new StringBuffer();

        if (node.getValue())
            append(codeBuffer, "  iconst_1\n");
        else
            append(codeBuffer, "  iconst_0\n");

        return codeBuffer;
    }

    
    public Object visit(CoordinatesLiteralNode node)
    {
        return null;
    }

    
    public Object visit(OrExpressionNode node)
    {
        StringBuffer codeBuffer = new StringBuffer();

        append(codeBuffer, "%s", visit(node.getLeftChild()));
        //append(codeBuffer, "  dup\n");
        append(codeBuffer, "  ifne L%s\n", LabelCounter);
        //append(codeBuffer, "  pop\n");
        append(codeBuffer, "%s", visit(node.getRightChild()));
        append(codeBuffer, "L%s:\n", LabelCounter++);
        append(codeBuffer, "  nop\n");

        return codeBuffer;
    }

    
    public Object visit(AndExpressionNode node)
    {
        StringBuffer codeBuffer = new StringBuffer();
        int label =  LabelCounter++;
        append(codeBuffer, "%s", visit(node.getLeftChild()));
        //append(codeBuffer, "  dup\n");
        append(codeBuffer, "  ifeq L%s\n", label);
        //append(codeBuffer, "  pop\n");
        append(codeBuffer, "%s", visit(node.getRightChild()));
        append(codeBuffer, "L%s:\n", label);
        append(codeBuffer, "  nop\n");

        return codeBuffer;
    }

    
    public Object visit(RelativeExpressionNode node)
    {
        return null;
    }

    
    public Object visit(EqualExpressionNode node)
    {
        StringBuffer codeBuffer = new StringBuffer();

        int trueLabel = LabelCounter++;

        append(codeBuffer, "%s", visit(node.getLeftChild()));
        append(codeBuffer, "%s", visit(node.getRightChild()));
        append(codeBuffer, "  if_icmpeq L%s\n", trueLabel);
        append(codeBuffer, "  ldc 0\n");
        append(codeBuffer, "  goto L%s\n", LabelCounter);
        append(codeBuffer, "L%s:\n", trueLabel);
        append(codeBuffer, "  ldc 1\n");
        append(codeBuffer, "L%s:\n", LabelCounter++);
        append(codeBuffer, "  nop\n");


        return codeBuffer;
    }

    
    public Object visit(NegateNode node)
    {
        StringBuffer codeBuffer = new StringBuffer();
        int falseLabel = LabelCounter++;
        append(codeBuffer, "%s", visit(node.getChild()));
        append(codeBuffer, "  ifeq L%s\n", falseLabel);
        append(codeBuffer, "  iconst_0\n");
        append(codeBuffer, "  goto L%s\n", LabelCounter);
        append(codeBuffer, "L%s:\n", falseLabel);
        append(codeBuffer, "  iconst_1\n");
        append(codeBuffer, "L%s:\n", LabelCounter++);
        append(codeBuffer, "  nop\n");

        return codeBuffer;
    }

    
    public Object visit(TypeCastNode node)
    {

        return null;
    }

    public String getPrefix(Type type)
    {
        String prefix = new String();
        switch (type.Kind)
        {
            case Type.NUMBER:
                prefix = "f";
                break;
            case Type.BOOL:
                prefix = "i";
                break;
            case Type.STRING:
                prefix = "a";
            default:
                //TODO: Some error
                break;
        }

        return prefix;
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
        for (Tuple<IdentifierLiteralNode, Integer> tuple:DeclaratoinOffsetTable)
        {
            if (tuple.x.getIdentifier().equals(node.getIdentifier()))
                return tuple.y;
        }

        return -1;
    }
}

