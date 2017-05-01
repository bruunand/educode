package com.educode.visitors.codegeneration;

import com.educode.helper.OperatorTranslator;
import com.educode.nodes.ISingleLineStatement;
import com.educode.nodes.base.ListNode;
import com.educode.nodes.base.NaryNode;
import com.educode.nodes.base.Node;
import com.educode.nodes.expression.AdditionExpression;
import com.educode.nodes.expression.MultiplicationExpression;
import com.educode.nodes.expression.logic.*;
import com.educode.nodes.literal.*;
import com.educode.nodes.method.MethodDeclarationNode;
import com.educode.nodes.method.MethodInvocationNode;
import com.educode.nodes.method.ParameterNode;
import com.educode.nodes.referencing.ArrayReferencingNode;
import com.educode.nodes.referencing.IdentifierReferencingNode;
import com.educode.nodes.referencing.StructReferencingNode;
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
import com.educode.types.LogicalOperator;
import com.educode.types.Type;
import com.educode.visitors.VisitorBase;

import java.io.FileWriter;
import java.util.ArrayList;
import java.util.StringJoiner;

/**
 * Created by Andreas on 10-04-2017.
 */
public class JavaCodeGenerationVisitor extends VisitorBase
{
    private String _destinationFile;

    public JavaCodeGenerationVisitor(String destinationFile)
    {
        super();
        this._destinationFile = destinationFile;
    }

    public void append(StringBuffer buffer, String format, Object... args)
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
        System.out.println("Please implement in Java CodeGen:" + node.getClass().getName());
        return "NOT IMPLEMENTED:" + node.getClass().getName();
    }

    public void visit(ProgramNode node)
    {
        StringBuffer codeBuffer = new StringBuffer();

        append(codeBuffer, "import java.util.*;\nimport com.educode.runtime.*;\nimport com.educode.runtime.types.*;\n\n");

        append(codeBuffer, "public class %s extends ScriptBase\n{\n", node.getReference());

        // Visit global variable declarations
        for (VariableDeclarationNode variableDecl : node.getVariableDeclarations())
            append(codeBuffer, "%s;\n", visit(variableDecl));

        // Visit method declarations
        for (MethodDeclarationNode methodDecl : node.getMethodDeclarations())
            append(codeBuffer, "%s", visit(methodDecl));

        // Append closing curly bracket
        append(codeBuffer, "}");

        // Write codeBuffer to file
        try
        {
            FileWriter fw = new FileWriter(this._destinationFile);
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

        append(codeBuffer, "{\n");

        // Visit statements in body/block declarations
        for (Node childNode : node.getChildren())
        {
            //this if statement is here in order to ensure that if statements does not have semicolon
            if (childNode instanceof ISingleLineStatement)
                append(codeBuffer, "%s;\n", visit(childNode));
            else
                append(codeBuffer, "%s\n", visit(childNode));
        }

        append(codeBuffer, "}\n");

        return codeBuffer;
    }

    public Object visit(ObjectInstantiationNode node)
    {
        // Join actual arguments
        StringJoiner argumentJoiner = new StringJoiner(", ");
        if (node.hasChild())
        {
            for (Node grandchild : ((NaryNode)node.getChild()).getChildren())
                argumentJoiner.add(visit(grandchild).toString());
        }

        // Object instantiation is handled differently for different types
        // This case is only used if collection is initialized with values
        if (node.getType().isCollection())
        {
            /*if (node.hasChild())
                return String.format("Arrays.asList(%s)", argumentJoiner);
            else*/
                return String.format("new ExtendedCollection<%s>(%s)", OperatorTranslator.toJava(node.getType().getChildType()), argumentJoiner);
        }
        else
            return String.format("new %s(%s)", OperatorTranslator.toJava(node.getType()), argumentJoiner);
    }


    public Object visit(MethodDeclarationNode node)
    {
        StringBuffer codeBuffer = new StringBuffer();

        // Visit parameters, join using string joiner
        StringJoiner parameterJoiner = new StringJoiner(",");
        for (ParameterNode parameterNodeDecl : node.getParameters())
            parameterJoiner.add(visit(parameterNodeDecl).toString());

        // Add declaration with joined parameters
        // All method calls can be interrupted at any time
        append(codeBuffer, String.format("public %s %s(%s) throws InterruptedException\n", OperatorTranslator.toJava(node.getType()), visit(node.getReference()), parameterJoiner));

        // Append block
        append(codeBuffer, "%s", visit(node.getBlockNode()));

        return codeBuffer;
    }


    public Object visit(MethodInvocationNode node)
    {
        StringJoiner actualArgumentsJoiner = new StringJoiner(", ");
        if (node.hasChild())
        {
            for (Node parameterNodeDecl : ((ListNode) node.getChild()).getChildren())
                actualArgumentsJoiner.add(visit(parameterNodeDecl).toString());
        }

        // Replace identifier if applicable
        // TODO: Use a dictionary or a better structure for this
        String methodIdentifier = (String) visit(node.getReference());
        if (methodIdentifier.equals("debug"))
            methodIdentifier = "System.out.println";

        return String.format("%s(%s)", methodIdentifier, actualArgumentsJoiner);
    }


    public Object visit(ParameterNode node)
    {
        //formal parameter node
        StringBuffer codeBuffer = new StringBuffer();
        append(codeBuffer, "%s %s", OperatorTranslator.toJava(node.getType()), visit(node.getReference()));

        return codeBuffer;
    }


    public Object visit(AssignmentNode node)
    {
        // Special case for array references.
        if (node.getReference() instanceof ArrayReferencingNode)
        {
            ArrayReferencingNode arrayReference = (ArrayReferencingNode) node.getReference();
            return String.format("%s.setItemAt(%s, %s)", visit(arrayReference.getLeftChild()), visit(arrayReference.getRightChild()), visit(node.getChild()));
        }

        return String.format("%s = %s",  visit(node.getReference()), visit(node.getChild()));
    }


    public Object visit(VariableDeclarationNode node)
    {
        StringBuffer codeBuffer = new StringBuffer();
        append(codeBuffer, "%s ", OperatorTranslator.toJava(node.getType()));

        if (node.getChild() != null)
            append(codeBuffer, "%s", visit(node.getChild()));
        else
            append(codeBuffer, "%s", visit(node.getReference()));

        return codeBuffer;
    }


    public Object visit(IfNode node)
    {
        StringBuffer codeBuffer = new StringBuffer();
        ArrayList<ConditionNode> conditions = node.getConditionBlocks();

        // visit if and else if
        int i = 0;
        for (ConditionNode condition : conditions)
        {
            if (i++ == 0) //visit if
                append(codeBuffer, "if%s", visit(condition));
            else //visit else if
                append(codeBuffer, "else if%s", visit(condition));
        }

        // Visit else block (if any)
        BlockNode elseBlock = node.getElseBlock();
        if (elseBlock != null)
            append(codeBuffer, "else\n%s", visit(elseBlock));

        return codeBuffer;

    }


    public Object visit(ConditionNode node)
    {
        StringBuffer codeBuffer = new StringBuffer();
        append(codeBuffer, "(%s)\n%s", visit(node.getLeftChild()), visit(node.getRightChild()));
        return codeBuffer;
    }


    public Object visit(RepeatWhileNode node)
    {
        StringBuffer codeBuffer = new StringBuffer();
        append(codeBuffer, "while %s", visit(node.getChild()));

        return codeBuffer;
    }

    public Object visit(ForEachNode node)
    {
        return String.format("for (%s %s : %s)\n%s", OperatorTranslator.toJava(node.getType()), visit(node.getReference()), visit(node.getLeftChild()), visit(node.getRightChild()));
    }

    public Object visit(ReturnNode node)
    {
        if (node.hasChild())
            return String.format("return %s", visit(node.getChild()));
        else
            return "return";
    }

    public Object visit(MultiplicationExpression node)
    {
        StringBuffer codeBuffer = new StringBuffer();
        append(codeBuffer, "(%s %s %s)", visit(node.getLeftChild()), OperatorTranslator.toJava(node.getOperator()), visit(node.getRightChild()));

        return codeBuffer;
    }

    public Object visit(AdditionExpression node)
    {
        StringBuffer codeBuffer = new StringBuffer();
        append(codeBuffer, "(%s %s %s)", visit(node.getLeftChild()), OperatorTranslator.toJava(node.getOperator()), visit(node.getRightChild()));

        return codeBuffer;
    }

    public Object visit(NumberLiteralNode node)
    {
        return String.format("%fF", node.getValue());
    }

    public Object visit(StringLiteralNode node)
    {
        return node.getValue();
    }

    public Object visit(BoolLiteralNode node)
    {
        return node.getValue();
    }

    public Object visit(CoordinatesLiteralNode node)
    {
        // Uses the Coordinates runtime type
        return String.format("new Coordinates(%s, %s, %s)", visit(node.getX()), visit(node.getY()), visit(node.getZ()));
    }

    public Object visit(OrExpressionNode node)
    {
        StringBuffer codeBuffer = new StringBuffer();
        append(codeBuffer, "(%s %s %s)", visit(node.getLeftChild()), OperatorTranslator.toJava(node.getOperator()), visit(node.getRightChild()));

        return codeBuffer;
    }

    public Object visit(AndExpressionNode node)
    {
        StringBuffer codeBuffer = new StringBuffer();
        append(codeBuffer, "(%s %s %s)", visit(node.getLeftChild()), OperatorTranslator.toJava(node.getOperator()), visit(node.getRightChild()));

        return codeBuffer;
    }

    public Object visit(RelativeExpressionNode node)
    {
        StringBuffer codeBuffer = new StringBuffer();
        append(codeBuffer, "(%s %s %s)", visit(node.getLeftChild()), OperatorTranslator.toJava(node.getOperator()), visit(node.getRightChild()));

        return codeBuffer;
    }

    public Object visit(EqualExpressionNode node)
    {
        // In theory, float and boolean comparison should use the ==/!= operators
        // However, we use wrappers (Float and Boolean) because lists in Java cannot contain primitive types
        String returnString = String.format("%s.equals(%s)", visit(node.getLeftChild()), visit(node.getRightChild()));

        // Return code, negate if operator is NOT EQUALS
        if (node.getOperator().equals(LogicalOperator.NotEquals))
            return String.format("!%s", returnString);
        else
            return returnString;
    }

    public Object visit(NegateNode node)
    {
        StringBuffer codeBuffer = new StringBuffer();
        append(codeBuffer, "!(%s)", visit(node.getChild()));

        return codeBuffer;
    }

    public Object visit(TypeCastNode node)
    {
        return String.format("(%s)(%s)", OperatorTranslator.toJava(node.getType()), visit(node.getChild()));
    }

    public Object visit(IdentifierReferencingNode node)
    {
        return node.getText();
    }

    public Object visit(ArrayReferencingNode node)
    {
        return String.format("%s.getItemAt(%s)", visit(node.getArrayName()), visit(node.getExpression()));
    }

    public Object visit(StructReferencingNode node)
    {
        return String.format("%s.%s", visit(node.getObjectName()), visit(node.getFieldName()));
    }
}
