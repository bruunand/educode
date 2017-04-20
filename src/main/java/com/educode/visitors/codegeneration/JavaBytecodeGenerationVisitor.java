package com.educode.visitors.codegeneration;

import com.educode.helper.*;
import com.educode.nodes.base.*;
import com.educode.nodes.expression.*;
import com.educode.nodes.expression.logic.*;
import com.educode.nodes.literal.*;
import com.educode.nodes.method.*;
import com.educode.nodes.referencing.*;
import com.educode.nodes.statement.*;
import com.educode.nodes.statement.conditional.*;
import com.educode.nodes.ungrouped.*;
import com.educode.types.*;
import com.educode.visitors.VisitorBase;
import org.omg.PortableServer.POA;

import java.io.FileWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

/**
 * Created by theis on 4/10/17.
 */
public class JavaBytecodeGenerationVisitor extends VisitorBase
{
    private FileWriter fw;
    private int OffSet = 1;
    private int LabelCounter;
    private ProgramNode programNode = null;
    private Deque<Boolean> Stack = new ArrayDeque<Boolean>();
    private ArrayList<Tuple<IReference, Integer>> DeclaratoinOffsetTable = new ArrayList<Tuple<IReference, Integer>>();

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
        programNode = node;
        StringBuffer codeBuffer = new StringBuffer();

        append(codeBuffer, ".class public %s\n", node.getReference());
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
            fw = new FileWriter(node.getReference()+ ".j");
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
        int startSize = DeclaratoinOffsetTable.size();

        for (Node child : node.getChildren())
            append(codeBuffer, "%s",visitPop(child));

        while (startSize != DeclaratoinOffsetTable.size())
            offSetTableRemove();

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
        append(codeBuffer, "  dup\n");

        for (Node child:node.getActualArguments())
            append(codeBuffer, "%s", visit(child));

        append(codeBuffer, "  invokespecial %s/<init>()V\n", node.getType()); //TODO:get class name
        return null;
    }
    
    public Object visit(MethodDeclarationNode node)
    {
        StringBuffer codeBuffer = new StringBuffer();

        OffSet = 1;
        LabelCounter = 0;

        // Visit parameters
        append(codeBuffer, ".method public %s(%s)%s\n", node.getReference(), getParameters(node.getParameters()),OperatorTranslator.toBytecode(node.getType()));

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
        String temp = new String();

        if (node.getReference().toString().equals("debug"))
        {
            Node child = ((ListNode) node.getChild()).getChildren().get(0);
            append(codeBuffer, "  getstatic java/lang/System/out Ljava/io/PrintStream;\n");
            append(codeBuffer, "%s", visit(child));
            temp = OperatorTranslator.toBytecode(child.getType());
            append(codeBuffer,"  invokevirtual java/io/PrintStream/println(%s)V\n", temp);
        }
        else
        {
            append(codeBuffer, "  aload_0\n");

            for (Node child:node.getActualArguments())
                append(codeBuffer, "%s", visit(child));

            for (Node child:node.getActualArguments())
                temp += OperatorTranslator.toBytecode(child.getType());

            append(codeBuffer, "  invokevirtual Test/%s(%s)%s\n", node.getReference().toString(), temp, OperatorTranslator.toBytecode(node.getType())); //TODO: Get namespace
        }

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
        append(codeBuffer, "%s", stackPush(node.getType()));

        append(codeBuffer, "  %sstore %s\n", getPrefix(node.getReference().getType()),getOffSetByNode(node.getReference()));

        if (node.getChild() instanceof AssignmentNode)
            Stack.pop();

        return codeBuffer;
    }
    
    public Object visit(VariableDeclarationNode node)
    {
        StringBuffer codeBuffer = new StringBuffer();
        offSetTableAdd(node.getReference());

        if (!node.hasChild())
            return "";

        append(codeBuffer, "%s", visit(((AssignmentNode) node.getChild())));
        append(codeBuffer,"%s", stackPop());

        return codeBuffer;
    }
    
    public Object visit(IfNode node)
    {
        StringBuffer codeBuffer = new StringBuffer();
        int endIfLabel = LabelCounter++;

        ArrayList<ConditionNode> conditionNodeList = node.getConditionBlocks();

        append(codeBuffer, "%s", visit(conditionNodeList.get(0)));
        append(codeBuffer, "  goto L%s\n", endIfLabel);

        for (int i = 1; i < conditionNodeList.size(); i++)
        {
            append(codeBuffer, "L%s:\n", LabelCounter++);
            append(codeBuffer, "%s", visit(conditionNodeList.get(i)));
            append(codeBuffer, "  goto L%s\n", endIfLabel);
        }

        append(codeBuffer, "L%s:\n", LabelCounter++);

        if (node.getElseBlock() != null)
            append(codeBuffer, "%s", visit(node.getElseBlock()));
        else
            append(codeBuffer, "  nop\n");

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
        int loopLabel = LabelCounter ++;

        append(codeBuffer, "  goto L%s\n", conditionLabel);
        append(codeBuffer, "L%s:\n", loopLabel);
        append(codeBuffer, "%s", visit(((ConditionNode) node.getChild()).getRightChild()));
        append(codeBuffer, "L%s:\n", conditionLabel);
        append(codeBuffer, "%s", visit(((ConditionNode) node.getChild()).getLeftChild()));
        append(codeBuffer, "  ifne L%s\n", loopLabel);

        return codeBuffer;
    }
    
    public Object visit(ReturnNode node)
    {
        StringBuffer codeBuffer = new StringBuffer();

        if (node.hasChild())
        {
            append(codeBuffer, "%s", visit(node.getChild()));
            append(codeBuffer, "  %sreturn\n", getPrefix(node.getType()));
        }
        else
            append(codeBuffer, "  return\n");

        return codeBuffer;
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

        if (node.getType().getKind()== Type.STRING && node.getOperator().getKind() == ArithmeticOperator.ADDITION)
        {
            String s = "java/lang/String";
            append(codeBuffer, "  invokevirtual %s/concat(L%s;)L%s;\n", s, s, s);
        }
        else if (node.getType().getKind() == Type.NUMBER)
        {
            if (node.getOperator().getKind() == ArithmeticOperator.ADDITION)
                append(codeBuffer, "  dadd\n");
            else
                append(codeBuffer, "  dsub\n");

        }
        else
            ;//TODO: ERROR NOT IMPLEMENTED

        return codeBuffer;
    }
    
    public Object visit(NumberLiteralNode node)
    {
        StringBuffer codeBuffer = new StringBuffer();

        append(codeBuffer, "  ldc2_w %s\n", node.getValue());

        return codeBuffer;
    }
    
    public Object visit(StringLiteralNode node)
    {
        StringBuffer codeBuffer = new StringBuffer();

        append(codeBuffer, "  ldc %s\n", node.getValue());

        return codeBuffer;
    }
    
    public Object visit(IdentifierReferencingNode node)
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
        append(codeBuffer, "  dup\n");
        append(codeBuffer, "  ifne L%s\n", LabelCounter);
        append(codeBuffer, "  pop\n");
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
        append(codeBuffer, "  dup\n");
        append(codeBuffer, "  ifeq L%s\n", label);
        append(codeBuffer, "  pop\n");
        append(codeBuffer, "%s", visit(node.getRightChild()));
        append(codeBuffer, "L%s:\n", label);
        append(codeBuffer, "  nop\n");

        return codeBuffer;
    }

    public Object visit(RelativeExpressionNode node)
    {
        StringBuffer codeBuffer = new StringBuffer();
        int trueLabel = LabelCounter++;

        append(codeBuffer, "%s", visit(node.getLeftChild()));
        append(codeBuffer, "%s", visit(node.getRightChild()));

        append(codeBuffer, "  dcmpg\n");

        switch (node.getOperator().getKind())
        {
            case LogicalOperator.GREATER_THAN:
                append(codeBuffer, "  ifgt L%s\n", trueLabel);
                break;
            case LogicalOperator.LESS_THAN:
                append(codeBuffer, "  iflt L%s\n", trueLabel);
                break;
            case LogicalOperator.GREATER_THAN_OR_EQUALS:
                append(codeBuffer, "  ifge L%s\n", trueLabel);
                break;
            case LogicalOperator.LESS_THAN_OR_EQUALS:
                append(codeBuffer, "  ifle L%s\n", trueLabel);
                break;
            default:
                //TODO: ERROR
                break;
        }

        append(codeBuffer, "  iconst_0\n");
        append(codeBuffer, "  goto L%s\n", LabelCounter);
        append(codeBuffer, "L%s:\n", trueLabel);
        append(codeBuffer, "  iconst_1\n");
        append(codeBuffer, "L%s:\n", LabelCounter++);
        append(codeBuffer, "  nop\n");

        return codeBuffer;
    }
    
    public Object visit(EqualExpressionNode node)
    {
        StringBuffer codeBuffer = new StringBuffer();

        int trueLabel = LabelCounter++;


        append(codeBuffer, "%s", visit(node.getLeftChild()));
        append(codeBuffer, "%s", visit(node.getRightChild()));

        if (node.getLeftChild().getType().getKind() == Type.NUMBER)
        {
            append(codeBuffer, "  dcmpg\n");
            append(codeBuffer, "  ifeq L%s\n", trueLabel);
        }
        else
            append(codeBuffer, "  if_icmpeq L%s\n", trueLabel);

        append(codeBuffer, "  iconst_0\n");
        append(codeBuffer, "  goto L%s\n", LabelCounter);
        append(codeBuffer, "L%s:\n", trueLabel);
        append(codeBuffer, "  iconst_1\n");

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

    public String stackPush(Type type)
    {
        if (Type.NUMBER == type.getKind())
        {
            Stack.push(true);
            return "  dup2\n";
        }
        else
        {
            Stack.push(false);
            return "  dup\n";
        }
    }

    public String stackPop()
    {
        if (Stack.pop())
            return "  pop2\n";
        else
            return "  pop\n";
    }

    public Object visitPop(Node node)
    {
        StringBuffer codeBuffer = new StringBuffer();
        int startSize = Stack.size();

        append(codeBuffer, "%s", visit(node));

        for (int i = Stack.size() - startSize; i > 0; i--)
        {
            if (Stack.pop())
                append(codeBuffer, "  pop2\n");
            else
                append(codeBuffer, "  pop\n");
        }

        return codeBuffer;
    }

    public String getPrefix(Type type)
    {
        String prefix = new String();
        switch (type.getKind())
        {
            case Type.NUMBER:
                prefix = "d";
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

    public String getParameters(ArrayList<ParameterNode> node)
    {
        String parameters = "";

        if (node == null)
            return parameters;

        for (ParameterNode child : node)
        {
            parameters += visit(child);
            offSetTableAdd(child.getReference());
        }

        return parameters;
    }

    public void offSetTableAdd(IReference reference)
    {
        DeclaratoinOffsetTable.add(new Tuple<IReference, Integer>(reference, OffSet));
        if (reference.isType(Type.NumberType))
            OffSet = OffSet + 2;
        else
            OffSet++;
    }

    public void offSetTableRemove()
    {
        int index = DeclaratoinOffsetTable.size() - 1;

        if (DeclaratoinOffsetTable.get(index).x.isType(Type.NumberType))
            OffSet = OffSet - 2;
        else
            OffSet--;

        DeclaratoinOffsetTable.remove(index);
    }

    public int getOffSetByNode(IReference node)
    {
        for (Tuple<IReference, Integer> tuple:DeclaratoinOffsetTable)
        {
            if (tuple.x.toString().equals(node.toString()))
                return tuple.y;
        }

        return -1;
    }
}

