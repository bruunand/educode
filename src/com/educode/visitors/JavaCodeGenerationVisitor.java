package com.educode.visitors;
import com.educode.helper.OperatorTranslator;
import com.educode.nodes.SingleLineStatement;
import com.educode.nodes.base.ListNode;
import com.educode.nodes.base.NaryNode;
import com.educode.nodes.base.Node;
import com.educode.nodes.base.UnaryNode;
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

import java.io.FileWriter;
import java.util.ArrayList;

/**
 * Created by Andreas on 10-04-2017.
 */
public class JavaCodeGenerationVisitor extends VisitorBase{

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

    @Override
    public Object visit(BlockNode node) {

        StringBuffer codeBuffer = new StringBuffer();

        append(codeBuffer, "{\n");

        // Visit statements in body/block declarations
        for (Node childNode : node.getChildren())

            //this if statement is here in order to ensure that if statements does not have semicolon
            if(childNode instanceof SingleLineStatement)
                append(codeBuffer, "%s;\n", visit(childNode));
            else
                append(codeBuffer, "%s\n", visit(childNode));

        append(codeBuffer, "}\n");

        return codeBuffer;
    }

    @Override
    public Object visit(ListNode node) {
        StringBuffer codeBuffer = new StringBuffer();
        for (Node lol : node.getChildren())
            append(codeBuffer, "TEST(%s)", visit(lol));

        return codeBuffer;
    }

    @Override
    public Object visit(ObjectInstantiationNode node) {

        StringBuffer codeBuffer = new StringBuffer();
        append(codeBuffer, "new %s(%s); ", OperatorTranslator.toJava(node.getType()), node.getChild());

        return codeBuffer;
    }

    @Override
    public Object visit(MethodDeclarationNode node) {

        StringBuffer codeBuffer = new StringBuffer();
        append(codeBuffer, "public %s %s(", OperatorTranslator.toJava(node.getType()), node.getIdentifier());

        //visit parameters
        for (ParameterNode parameterNodeDecl : node.getParameters())
            append(codeBuffer, "%s,", visit(parameterNodeDecl));

        if (codeBuffer.charAt(codeBuffer.length() - 1) == ','){
            codeBuffer.deleteCharAt(codeBuffer.length() - 1);
        }

        append(codeBuffer, ")");

        //visit block
        append(codeBuffer,"%s", visit(node.getBlockNode()));

        return codeBuffer;
    }

    @Override
    public Object visit(MethodInvocationNode node) {

        StringBuffer codeBuffer = new StringBuffer();
        append(codeBuffer, "%s(", node.getIdentifier());

        for (Node parameterNodeDecl : ((ListNode) node.getChild()).getChildren())
            append(codeBuffer, "%s,", visit(parameterNodeDecl));

        if (codeBuffer.charAt(codeBuffer.length() - 1) == ','){
            codeBuffer.deleteCharAt(codeBuffer.length() - 1);
        }

        append(codeBuffer, ")");

        return codeBuffer;
    }

    @Override
    public Object visit(ParameterNode node) {

        //formal parameter node
        StringBuffer codeBuffer = new StringBuffer();
        append(codeBuffer, "%s %s", OperatorTranslator.toJava(node.getType()), node.getIdentifier());

        return codeBuffer;
    }

    @Override
    public Object visit(AssignmentNode node) {

        StringBuffer codeBuffer = new StringBuffer();
        append(codeBuffer, "%s = ", node.getIdentifier());

        append(codeBuffer, "%s", visit(node.getChild()));

        return codeBuffer;
    }

    @Override
    public Object visit(VariableDeclarationNode node) {

        StringBuffer codeBuffer = new StringBuffer();
        append(codeBuffer, "%s ", OperatorTranslator.toJava(node.getType()));

        if (node.getChild() != null){
            append(codeBuffer, "%s", visit(node.getChild()));
        }
        else{
            append(codeBuffer, "%s;", node.getIdentifier());
        }

        return codeBuffer;
    }

    @Override
    public Object visit(IfNode node) {

        StringBuffer codeBuffer = new StringBuffer();
        ArrayList<ConditionNode> conditions = node.getConditionBlocks();

        // visit if and else if
        int i = 0;
        for (ConditionNode condition : conditions)
        {
            //visit if
            if (i++ == 0)
                append(codeBuffer, "if %s\n", visit(condition));
            //visit else if
            else
                append(codeBuffer, "else if %s\n", visit(condition));
        }

        // Visit else block (if any)
        BlockNode elseBlock = node.getElseBlock();
        if (elseBlock != null)
        {
            append(codeBuffer, "else\n");

            append(codeBuffer, "%s", visit(elseBlock));
        }

        return codeBuffer;

    }

    @Override
    public Object visit(ConditionNode node) {

        StringBuffer codeBuffer = new StringBuffer();
        append(codeBuffer, "(%s)%s", visit(node.getLeftChild()), visit(node.getRightChild()));
        return codeBuffer;
    }

    @Override
    public Object visit(RepeatWhileNode node) {

        StringBuffer codeBuffer = new StringBuffer();
        append(codeBuffer, "while %s",visit(node.getChild()));


        return codeBuffer;
    }

    @Override
    public Object visit(ReturnNode node) {

        StringBuffer codeBuffer = new StringBuffer();
        append(codeBuffer, "return %s", visit(node.getChild()));
        return codeBuffer;
    }

    @Override
    public Object visit(MultiplicationExpression node) {

        StringBuffer codeBuffer = new StringBuffer();
        append(codeBuffer, "(%s %s %s)", visit(node.getLeftChild()), OperatorTranslator.toJava(node.getOperator()), visit(node.getRightChild()));

        return codeBuffer;
    }

    @Override
    public Object visit(AdditionExpression node) {
        StringBuffer codeBuffer = new StringBuffer();
        append(codeBuffer, "(%s %s %s)", visit(node.getLeftChild()), OperatorTranslator.toJava(node.getOperator()), visit(node.getRightChild()));

        return codeBuffer;
    }

    @Override
    public Object visit(NumberLiteralNode node) {
        return node.getValue();
    }

    @Override
    public Object visit(StringLiteralNode node) {
        return node.getValue();
    }

    @Override
    public Object visit(IdentifierLiteralNode node) {
        return node.getIdentifier();
    }

    @Override
    public Object visit(BoolLiteralNode node) {
        return node.getValue();
    }

    @Override
    public Object visit(CoordinatesLiteralNode node)
    {
        return null;
    }

    @Override
    public Object visit(OrExpressionNode node)
    {
        StringBuffer codeBuffer = new StringBuffer();
        append(codeBuffer, "%s %s %s", visit(node.getLeftChild()), OperatorTranslator.toJava(node.getOperator()), visit(node.getRightChild()));

        return codeBuffer;
    }

    @Override
    public Object visit(AndExpressionNode node) {
        StringBuffer codeBuffer = new StringBuffer();
        append(codeBuffer, "%s %s %s", visit(node.getLeftChild()), OperatorTranslator.toJava(node.getOperator()), visit(node.getRightChild()));

        return codeBuffer;
    }

    @Override
    public Object visit(RelativeExpressionNode node) {

        StringBuffer codeBuffer = new StringBuffer();
        append(codeBuffer, "%s %s %s", visit(node.getLeftChild()), OperatorTranslator.toJava(node.getOperator()), visit(node.getRightChild()));

        return codeBuffer;
    }

    @Override
    public Object visit(EqualExpressionNode node) {
        StringBuffer codeBuffer = new StringBuffer();
        append(codeBuffer, "%s %s %s", visit(node.getLeftChild()), OperatorTranslator.toJava(node.getOperator()), visit(node.getRightChild()));

        return codeBuffer;
    }

    @Override
    public Object visit(NegateNode node) {

        StringBuffer codeBuffer = new StringBuffer();
        append(codeBuffer, "!(%s)", visit(node.getChild()));

        return codeBuffer;
    }

    @Override
    public Object visit(TypeCastNode node)
    {
        return null;
    }
}
