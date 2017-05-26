package com.educode.visitors.codegeneration;

import com.educode.helper.OperatorTranslator;
import com.educode.helper.Tuple;
import com.educode.minecraft.CompilerMod;
import com.educode.nodes.base.ListNode;
import com.educode.nodes.base.Node;
import com.educode.nodes.expression.AdditionExpressionNode;
import com.educode.nodes.expression.MultiplicationExpressionNode;
import com.educode.nodes.expression.logic.*;
import com.educode.nodes.literal.BoolLiteralNode;
import com.educode.nodes.literal.CoordinatesLiteralNode;
import com.educode.nodes.literal.NumberLiteralNode;
import com.educode.nodes.literal.StringLiteralNode;
import com.educode.nodes.method.MethodDeclarationNode;
import com.educode.nodes.method.MethodInvocationNode;
import com.educode.nodes.method.ParameterNode;
import com.educode.nodes.referencing.IReference;
import com.educode.nodes.referencing.IdentifierReferencingNode;
import com.educode.nodes.statement.AssignmentNode;
import com.educode.nodes.statement.ReturnNode;
import com.educode.nodes.statement.VariableDeclarationNode;
import com.educode.nodes.statement.conditional.ConditionNode;
import com.educode.nodes.statement.conditional.IfNode;
import com.educode.nodes.statement.conditional.RepeatWhileNode;
import com.educode.nodes.ungrouped.*;
import com.educode.types.ArithmeticOperator;
import com.educode.types.LogicalOperator;
import com.educode.types.Type;
import com.educode.visitors.VisitorBase;

import java.io.FileWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

/**
 * Created by theis on 4/10/17.
 */
public class JavaBytecodeGenerationVisitor extends VisitorBase
{
    private int _offSet = 1;
    private int _labelCounter;
    private Deque<Boolean> _stack = new ArrayDeque<Boolean>();
    private int _currentStackHeight;
    private int _maxStackHeight;
    private ArrayList<Tuple<IReference, Integer>> _declarationOffsetTable = new ArrayList<>();

    private void addStackHeight(int value)
    {
        _currentStackHeight += value;
        if (_currentStackHeight > _maxStackHeight)
            _maxStackHeight = _currentStackHeight;
    }

    private void addStackHeight(Node node)
    {
        if (node.getType() == Type.NumberType)
            addStackHeight(2);
        else if (node.getType() != Type.VoidType)
            addStackHeight(1);
    }

    private void subtractStackHeight(Node node)
    {
        if (node.getType() == Type.NumberType)
            subtractStackHeight(2);
        else
            subtractStackHeight(1);
    }

    private void subtractStackHeight(int value) { _currentStackHeight -= value; }

    private void append(StringBuffer buffer, String format, Object... args)
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


    public void visit(StartNode node)
    {
        visit(node.getRightChild());
    }
    
    public void visit(ProgramNode node)
    {
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
            FileWriter fw = new FileWriter(CompilerMod.EDUCODE_PROGRAMS_LOCATION + node.getReference()+ ".j");
            fw.append(codeBuffer);
            fw.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    
    public Object visit(BlockNode node)
    {
        StringBuffer codeBuffer = new StringBuffer();
        int startSize = _declarationOffsetTable.size();
        Type temp;

        for (Node child : node.getChildren())
        {
            append(codeBuffer, "%s",visitPop(child));
            if (child instanceof MethodInvocationNode)
                if ((temp = ((MethodInvocationNode) child).getType()).getKind() != Type.VOID && temp.getKind() != Type.ERROR)
                {
                    if (temp.getKind() == Type.NUMBER)
                    {
                        subtractStackHeight(2);
                        append(codeBuffer, "  pop2\n");
                    }

                    else
                    {
                        subtractStackHeight(1);
                        append(codeBuffer, "  pop\n");
                    }
                }
        }

        while (startSize != _declarationOffsetTable.size())
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

        addStackHeight(1);
        append(codeBuffer, "  new %s\n", node.getType());
        addStackHeight(1);
        append(codeBuffer, "  dup\n");

        for (Node child:node.getActualArguments())
            append(codeBuffer, "%s", visit(child));

        subtractStackHeight(1);
        append(codeBuffer, "  invokespecial %s/<init>()V\n", node.getType()); //TODO:get class name

        return codeBuffer;
    }
    
    public Object visit(MethodDeclarationNode node)
    {
        StringBuffer codeBuffer = new StringBuffer();
        StringBuffer tempBuffer = new StringBuffer();

        _offSet = 1;
        _labelCounter = 0;
        _maxStackHeight = 0;
        _currentStackHeight = 0;

        // Visit parameters
        append(codeBuffer, ".method public %s(%s)%s\n", node.getReference(), getParameters(node.getParameters()),OperatorTranslator.toBytecode(node.getType()));

        // Visit block
        append(tempBuffer, "%s", visit(node.getBlockNode()));

        if (node.isType(Type.VoidType))
            append(tempBuffer, "  return\n");

        append(tempBuffer, ".end method\n\n");

        // Set limits
        append(codeBuffer, "  .limit stack %s\n", _maxStackHeight);     //TODO: calc
        append(codeBuffer, "  .limit locals %s\n", (node.getMaxDeclaredVariables() + 1));    //TODO: calc

        // Set blocks after limit
        append(codeBuffer, "%s", tempBuffer);

        return codeBuffer;
    }
    
    public Object visit(MethodInvocationNode node)
    {
        StringBuffer codeBuffer = new StringBuffer();
        String temp = "";

        if (node.getReference().toString().equals("debug"))
        {
            Node child = ((ListNode) node.getChild()).getChildren().get(0);
            addStackHeight(1);
            append(codeBuffer, "  getstatic java/lang/System/out Ljava/io/PrintStream;\n");

            append(codeBuffer, "%s", visit(child));
            temp = OperatorTranslator.toBytecode(child.getType());
            if (child.getType().getKind() == Type.BOOL)
            {
                int falseLabel = _labelCounter++;
                append(codeBuffer, "  ifeq L%s\n", falseLabel);
                append(codeBuffer, "  ldc \"true\"\n");
                append(codeBuffer, "  goto L%s\n", _labelCounter);
                append(codeBuffer, "L%s:\n", falseLabel);
                append(codeBuffer, "  ldc \"false\"\n");
                append(codeBuffer, "L%s:\n", _labelCounter++);
                append(codeBuffer, "  nop\n");
                temp = "Ljava/lang/String;";
            }

            subtractStackHeight(child);
            subtractStackHeight(1);

            append(codeBuffer,"  invokevirtual java/io/PrintStream/println(%s)V\n", temp);

        }
        else
        {
            addStackHeight(1);
            append(codeBuffer, "  aload_0\n");

            for (Node child:node.getActualArguments())
                append(codeBuffer, "%s", visit(child));

            for (Node child:node.getActualArguments())
            {
                subtractStackHeight(child);
                temp += OperatorTranslator.toBytecode(child.getType());
            }
            subtractStackHeight(1);
            addStackHeight(node);
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

        subtractStackHeight(node);
        append(codeBuffer, "  %sstore %s\n", getPrefix(node.getReference().getType()),getOffSetByNode(node.getReference()));

        if (node.getChild() instanceof AssignmentNode)
            _stack.pop();

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
        int endIfLabel = _labelCounter++;
        int jumpLabel= _labelCounter++;

        ArrayList<ConditionNode> conditionNodeList = node.getConditionBlocks();

        append(codeBuffer, "%s", visit(conditionNodeList.get(0).getLeftChild()));
        subtractStackHeight(1);
        append(codeBuffer, "  ifeq L%s\n", jumpLabel);
        append(codeBuffer, "%s", visit(conditionNodeList.get(0).getRightChild()));
        append(codeBuffer, "  goto L%s\n", endIfLabel);

        for (int i = 1; i < conditionNodeList.size(); i++)
        {
            append(codeBuffer, "L%s:\n", jumpLabel);
            append(codeBuffer, "%s", visit(conditionNodeList.get(i).getLeftChild()));
            subtractStackHeight(1);
            append(codeBuffer, "  ifeq L%s\n", jumpLabel = _labelCounter++);
            append(codeBuffer, "%s", visit(conditionNodeList.get(i).getRightChild()));
            append(codeBuffer, "  goto L%s\n", endIfLabel);
        }

        append(codeBuffer, "L%s:\n", jumpLabel);

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
        return null;
    }
    
    public Object visit(RepeatWhileNode node)
    {
        StringBuffer codeBuffer = new StringBuffer();
        StringBuffer temp = new StringBuffer();
        int conditionLabel = _labelCounter++;
        int loopLabel = _labelCounter++;

        append(temp, "%s", visit(((ConditionNode) node.getChild()).getLeftChild())); //1
        subtractStackHeight(1);
        append(temp, "  ifne L%s\n", loopLabel);

        append(codeBuffer, "  goto L%s\n", conditionLabel); //0
        append(codeBuffer, "L%s:\n", loopLabel);
        append(codeBuffer, "%s", visit(((ConditionNode) node.getChild()).getRightChild())); //0
        append(codeBuffer, "L%s:\n", conditionLabel);
        append(codeBuffer,"%s", temp);

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

        //Since nothing will be done after this point
        _currentStackHeight = 0;

        return codeBuffer;
    }
    
    public Object visit(MultiplicationExpressionNode node)
    {
        StringBuffer codeBuffer = new StringBuffer();

        append(codeBuffer, "%s", visit(node.getLeftChild()));
        append(codeBuffer, "%s", visit(node.getRightChild()));
        append(codeBuffer, "  dmul\n");
        subtractStackHeight(2);

        return codeBuffer;
    }
    
    public Object visit(AdditionExpressionNode node)
    {
        StringBuffer codeBuffer = new StringBuffer();

        if (node.getType().getKind()== Type.STRING && node.getOperator().getKind() == ArithmeticOperator.ADDITION)
        {
            Node child;
            String s = "java/lang/String";

            if ((child = node.getLeftChild()).getType().getKind() != Type.STRING || (child = node.getRightChild()).getType().getKind() != Type.STRING)
            {
                if (child.equals(node.getLeftChild()))
                    append(codeBuffer, "%s", visit(node.getLeftChild()));
                else
                {
                    append(codeBuffer, "%s", visit(node.getLeftChild()));
                    append(codeBuffer, "%s", visit(node.getRightChild()));
                }
                switch (child.getType().getKind())
                {
                    case Type.NUMBER:
                        append(codeBuffer, "  invokestatic java/lang/Double/toString(D)L%s;\n", s);
                        subtractStackHeight(2);
                        break;
                    case Type.BOOL:
                        int falseLabel = _labelCounter++;
                        append(codeBuffer, "  ifeq L%s\n", falseLabel);
                        append(codeBuffer, "  ldc \"true\"\n");
                        append(codeBuffer, "  goto L%s\n", _labelCounter);
                        append(codeBuffer, "L%s:\n", falseLabel);
                        append(codeBuffer, "  ldc \"false\"\n");
                        append(codeBuffer, "L%s:\n", _labelCounter++);
                        append(codeBuffer, "  nop\n");
                        break;
                }

                if (child.equals(node.getLeftChild()))
                    append(codeBuffer, "%s", visit(node.getRightChild()));

            }
            else
            {
                append(codeBuffer, "%s", visit(node.getLeftChild()));
                append(codeBuffer, "%s", visit(node.getRightChild()));
            }


            append(codeBuffer, "  invokevirtual %s/concat(L%s;)L%s;\n", s, s, s);
        }
        else if (node.getType().getKind() == Type.NUMBER)
        {
            append(codeBuffer, "%s", visit(node.getLeftChild()));
            append(codeBuffer, "%s", visit(node.getRightChild()));

            if (node.getOperator().getKind() == ArithmeticOperator.ADDITION)
                append(codeBuffer, "  dadd\n");
            else
                append(codeBuffer, "  dsub\n");

            subtractStackHeight(2);
        }
        else
            ;//TODO: ERROR NOT IMPLEMENTED

        return codeBuffer;
    }
    
    public Object visit(NumberLiteralNode node)
    {
        StringBuffer codeBuffer = new StringBuffer();

        addStackHeight(2);

        append(codeBuffer, "  ldc2_w %s\n", node.getValue());

        return codeBuffer;
    }
    
    public Object visit(StringLiteralNode node)
    {
        StringBuffer codeBuffer = new StringBuffer();

        addStackHeight(1);

        append(codeBuffer, "  ldc %s\n", node.getValue());

        return codeBuffer;
    }
    
    public Object visit(IdentifierReferencingNode node)
    {
        StringBuffer codeBuffer = new StringBuffer();

        addStackHeight(node);

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

        addStackHeight(1);

        return codeBuffer;
    }
    
    public Object visit(CoordinatesLiteralNode node)
    {
        return null;
    }
    
    public Object visit(OrExpressionNode node)
    {
        StringBuffer codeBuffer = new StringBuffer();
        int trueLabel = _labelCounter++;

        append(codeBuffer, "%s", visit(node.getLeftChild())); //0
        addStackHeight(1);
        append(codeBuffer, "  dup\n"); // 1
        subtractStackHeight(1);
        append(codeBuffer, "  ifne L%s\n", trueLabel); //0
        subtractStackHeight(1);
        append(codeBuffer, "  pop\n"); // -1
        append(codeBuffer, "%s", visit(node.getRightChild())); // 0
        append(codeBuffer, "L%s:\n", trueLabel);
        append(codeBuffer, "  nop\n");

        addStackHeight(1);
        subtractStackHeight(1);

        return codeBuffer;
    }
    
    public Object visit(AndExpressionNode node)
    {
        StringBuffer codeBuffer = new StringBuffer();
        int label =  _labelCounter++;
        append(codeBuffer, "%s", visit(node.getLeftChild())); //0
        addStackHeight(1);
        append(codeBuffer, "  dup\n"); // 1
        subtractStackHeight(1);
        append(codeBuffer, "  ifeq L%s\n", label);
        subtractStackHeight(1);
        append(codeBuffer, "  pop\n"); //-1
        append(codeBuffer, "%s", visit(node.getRightChild()));//0
        append(codeBuffer, "L%s:\n", label);
        append(codeBuffer, "  nop\n");

        addStackHeight(1);
        subtractStackHeight(1);

        return codeBuffer;
    }

    public Object visit(RelativeExpressionNode node)
    {
        StringBuffer codeBuffer = new StringBuffer();
        int trueLabel = _labelCounter++;
        int endLabel = _labelCounter++;

        append(codeBuffer, "%s", visit(node.getLeftChild()));
        append(codeBuffer, "%s", visit(node.getRightChild()));

        subtractStackHeight(3);
        append(codeBuffer, "  dcmpg\n");

        subtractStackHeight(1);
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

        addStackHeight(1);
        append(codeBuffer, "  iconst_0\n");
        append(codeBuffer, "  goto L%s\n", endLabel);
        append(codeBuffer, "L%s:\n", trueLabel);
        append(codeBuffer, "  iconst_1\n");
        append(codeBuffer, "L%s:\n", endLabel);
        append(codeBuffer, "  nop\n");

        return codeBuffer;
    }
    
    public Object visit(EqualExpressionNode node)
    {
        StringBuffer codeBuffer = new StringBuffer();

        int trueLabel = _labelCounter++;


        append(codeBuffer, "%s", visit(node.getLeftChild()));
        append(codeBuffer, "%s", visit(node.getRightChild())); //0

        if (node.getLeftChild().getType().getKind() == Type.NUMBER)
        {
            append(codeBuffer, "  dcmpg\n"); //-3
            append(codeBuffer, "  ifeq L%s\n", trueLabel); //-4
            subtractStackHeight(2);
        }
        else
            append(codeBuffer, "  if_icmpeq L%s\n", trueLabel);//-2

        append(codeBuffer, "  iconst_0\n"); // -3 / -1
        append(codeBuffer, "  goto L%s\n", _labelCounter);
        append(codeBuffer, "L%s:\n", trueLabel);
        append(codeBuffer, "  iconst_1\n");
        append(codeBuffer, "L%s:\n", _labelCounter++);
        append(codeBuffer, "  nop\n");

        subtractStackHeight(1);

        return codeBuffer;
    }

    public Object visit(NegateNode node)
    {
        StringBuffer codeBuffer = new StringBuffer();
        int falseLabel = _labelCounter++;

        append(codeBuffer, "%s", visit(node.getChild())); //0
        append(codeBuffer, "  ifeq L%s\n", falseLabel);  // -1
        append(codeBuffer, "  iconst_0\n"); //1
        append(codeBuffer, "  goto L%s\n", _labelCounter);
        append(codeBuffer, "L%s:\n", falseLabel);
        append(codeBuffer, "  iconst_1\n"); //1
        append(codeBuffer, "L%s:\n", _labelCounter++);
        append(codeBuffer, "  nop\n");

        addStackHeight(1);

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
            _stack.push(true);
            addStackHeight(2);
            return "  dup2\n";
        }
        else
        {
            _stack.push(false);
            addStackHeight(1);
            return "  dup\n";
        }
    }

    public String stackPop()
    {
        if (_stack.pop())
        {
            _currentStackHeight -= 2;
            return "  pop2\n";
        }
        else
        {
            _currentStackHeight--;
            return "  pop\n";
        }
    }

    public Object visitPop(Node node)
    {
        StringBuffer codeBuffer = new StringBuffer();
        int startSize = _stack.size();

        append(codeBuffer, "%s", visit(node));

        for (int i = _stack.size() - startSize; i > 0; i--)
        {
            if (_stack.pop())
            {
                subtractStackHeight(2);
                append(codeBuffer, "  pop2\n");
            }
            else
            {
                subtractStackHeight(1);
                append(codeBuffer, "  pop\n");
            }
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
                //TODO: Some semanticError
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
        _declarationOffsetTable.add(new Tuple<IReference, Integer>(reference, _offSet));
        if (reference.isType(Type.NumberType))
            _offSet = _offSet + 2;
        else
            _offSet++;
    }

    public void offSetTableRemove()
    {
        int index = _declarationOffsetTable.size() - 1;

        if (_declarationOffsetTable.get(index).x.isType(Type.NumberType))
            _offSet = _offSet - 2;
        else
            _offSet--;

        _declarationOffsetTable.remove(index);
    }

    public int getOffSetByNode(IReference node)
    {
        for (Tuple<IReference, Integer> tuple: _declarationOffsetTable)
        {
            if (tuple.x.toString().equals(node.toString()))
                return tuple.y;
        }

        return -1;
    }
}

