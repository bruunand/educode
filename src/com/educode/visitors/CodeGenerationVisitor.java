package com.educode.visitors;

import com.educode.helper.OperatorTranslator;
import com.educode.nodes.SingleLineStatement;
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
import com.educode.nodes.ungrouped.TypeCastNode;

import java.io.FileWriter;
import java.util.ArrayList;

/**
 * Created by zen on 3/24/17.
 */
public class CodeGenerationVisitor extends VisitorBase
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
        append(codeBuffer, "public class %s\n{\n", node.getIdentifier());

        // Visit method declarations
        for (MethodDeclarationNode methodDecl : node.getMethodDeclarations())
            append(codeBuffer, "%s", visit(methodDecl));

        // Append closing curly bracket
        append(codeBuffer,"}");

        // Write codeBuffer to file
        try
        {
            fw = new FileWriter("test.java");
            fw.append(codeBuffer);
            fw.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        return null;
    }

    public Object visitChildStatements(ArrayList<Node> children)
    {
        StringBuffer tmp = new StringBuffer();

        for (Node child : children)
        {
            append(tmp, "%s", visit(child));

            if (child instanceof SingleLineStatement)
                append(tmp, ";\n");

        }

        return tmp;
    }

    @Override
    public Object visit(BlockNode node)
    {
        StringBuffer tmp = new StringBuffer();

        // Block start
        append(tmp, "{\n");

        // Visit statements in block
        append(tmp, "%s", visitChildStatements(node.getChildren()));

        // Block end
        append(tmp, "}\n");

        return tmp;
    }

    @Override
    public Object visit(ListNode node)
    {
        return visitChildStatements(node.getChildren());
    }

    @Override
    public Object visit(ObjectInstantiationNode node)
    {
        return String.format("new %s(%s)", OperatorTranslator.toJava(node.getType()), getArguments(node.getChild()));
    }

    @Override
    public Object visit(MethodDeclarationNode node)
    {
        StringBuffer tmp = new StringBuffer();

        // Visit parameters
        append(tmp, "public %s %s(%s)\n", OperatorTranslator.toJava(node.getType()), node.getIdentifier(), getParameters(node.getParameterList()));

        // Visit block
        append(tmp, "%s", visit(node.getBlockNode()));

        return tmp;
    }

    @Override
    public Object visit(MethodInvocationNode node)
    {
        return String.format("%s(%s)", node.getIdentifier(), getArguments(node.getChild()));
    }

    @Override
    public Object visit(ParameterNode node)
    {
        return String.format("%s %s", OperatorTranslator.toJava(node.getType()), node.getIdentifier());
    }

    @Override
    public Object visit(AssignmentNode node)
    {
        return String.format("%s = %s", node.getIdentifier(), visit(node.getChild()));
    }

    @Override
    public Object visit(VariableDeclarationNode node)
    {
        StringBuffer tmp = new StringBuffer();

        append(tmp, "%s %s", OperatorTranslator.toJava(node.getType()), node.getIdentifier());
        if (node.getChild() != null)
        {
            AssignmentNode assignment = (AssignmentNode) node.getChild();

            append(tmp, " = %s", visit(assignment.getChild()));
        }

        return tmp;
    }

    @Override
    public Object visit(IfNode node)
    {
        StringBuffer tmp = new StringBuffer();
        ArrayList<ConditionNode> conditions = node.getConditionBlocks();

        int i = 0;
        for (ConditionNode condition : conditions)
        {
            if (i++ == 0)
                append(tmp, "if (%s)\n", visit(condition.getLeftChild()));
            else
                append(tmp, "else if (%s)\n", visit(condition.getLeftChild()));

            append(tmp, "%s", visit(condition.getRightChild()));
        }

        // Visit else block if any
        BlockNode elseBlock = node.getElseBlock();
        if (elseBlock != null)
        {
            append(tmp, "else\n");

            append(tmp, "%s", visit(elseBlock));
        }

        return tmp;
    }

    @Override
    public Object visit(ConditionNode node)
    {
        return null;
    }

    @Override
    public Object visit(RepeatWhileNode node)
    {
        StringBuffer tmp = new StringBuffer();
        ConditionNode condition = (ConditionNode) node.getChild();

        append(tmp, "while (%s)\n", visit(condition.getLeftChild()));
        append(tmp, "%s", visit(condition.getRightChild()));

        return tmp;
    }

    @Override
    public Object visit(ReturnNode node)
    {
        if (node.getChild() != null)
            return String.format("return %s", visit(node.getChild()));
        else
            return String.format("return");
    }

    @Override
    public Object visit(MultiplicationExpression node)
    {
        return String.format("(%s %s %s)", visit(node.getLeftChild()), OperatorTranslator.toJava(node.getOperator()), visit(node.getRightChild()));
    }

    @Override
    public Object visit(AdditionExpression node)
    {
        return String.format("(%s %s %s)", visit(node.getLeftChild()), OperatorTranslator.toJava(node.getOperator()), visit(node.getRightChild()));
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
        if (node.getChild() == null)
            return node.getIdentifier();
        else
            return String.format("%s[%s]", node.getIdentifier(), visit(node.getChild())); // does not work
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
        return String.format("%s %s %s", visit(node.getLeftChild()), OperatorTranslator.toJava(node.getOperator()), visit(node.getRightChild()));
    }

    @Override
    public Object visit(EqualExpressionNode node)
    {
        return String.format("%s %s %s", visit(node.getLeftChild()), OperatorTranslator.toJava(node.getOperator()), visit(node.getRightChild()));
    }

    @Override
    public Object visit(NegateNode node)
    {
        return String.format("!(%s)", visit(node.getChild()));
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

        for (Node child : ((ListNode)node).getChildren())
            parameters += visit(child) + ",";

        if (!parameters.isEmpty())
            parameters = parameters.substring(0, parameters.length() - 1);

        return parameters;
    }

    public String getArguments(Node node)
    {
        String arguments = "";
        if (node == null || !(node instanceof ListNode))
            return arguments;

        for (Node argNode : ((ListNode) node).getChildren())
            arguments += visit(argNode) + ",";

        // Remove last argument separator
        if (!arguments.isEmpty())
            arguments = arguments.substring(0, arguments.length() - 1);

        return arguments;
    }
}
