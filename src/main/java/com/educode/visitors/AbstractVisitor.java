package com.educode.visitors;

import com.educode.nodes.base.*;
import com.educode.nodes.expression.AdditionExpressionNode;
import com.educode.nodes.expression.MultiplicationExpressionNode;
import com.educode.nodes.expression.RangeNode;
import com.educode.nodes.expression.UnaryMinusNode;
import com.educode.nodes.expression.logic.*;
import com.educode.nodes.literal.*;
import com.educode.nodes.method.MethodDeclarationNode;
import com.educode.nodes.method.MethodInvocationNode;
import com.educode.nodes.method.ParameterNode;
import com.educode.nodes.referencing.ArrayReferencingNode;
import com.educode.nodes.referencing.IdentifierReferencingNode;
import com.educode.nodes.referencing.StructReferencingNode;
import com.educode.nodes.statement.*;
import com.educode.nodes.statement.conditional.ConditionNode;
import com.educode.nodes.statement.conditional.IfNode;
import com.educode.nodes.statement.conditional.RepeatWhileNode;
import com.educode.nodes.ungrouped.*;

/**
 * Created by zen on 3/23/17.
 */
public abstract class AbstractVisitor
{
    public abstract Object visit(StartNode node);
    public abstract Object visit(ProgramNode node);
    public abstract Object visit(BlockNode node);
    public abstract Object visit(ListNode node);
    public abstract Object visit(ObjectInstantiationNode node);

    // Methods
    public abstract Object visit(MethodDeclarationNode node);
    public abstract Object visit(MethodInvocationNode node);
    public abstract Object visit(ParameterNode node);

    // Statements
    public abstract Object visit(AssignmentNode node);
    public abstract Object visit(VariableDeclarationNode node);
    public abstract Object visit(IfNode node);
    public abstract Object visit(ConditionNode node);
    public abstract Object visit(RepeatWhileNode node);
    public abstract Object visit(ReturnNode node);
    public abstract Object visit(ContinueNode node);
    public abstract Object visit(BreakNode node);
    public abstract Object visit(ForEachNode node);

    // Literals
    public abstract Object visit(NumberLiteralNode node);
    public abstract Object visit(StringLiteralNode node);
    public abstract Object visit(BoolLiteralNode node);
    public abstract Object visit(CoordinatesLiteralNode node);
    public abstract Object visit(NullLiteralNode node);

    // References
    public abstract Object visit(ArrayReferencingNode node);
    public abstract Object visit(IdentifierReferencingNode node);
    public abstract Object visit(StructReferencingNode node);

    // Arithmetic
    public abstract Object visit(AdditionExpressionNode node);
    public abstract Object visit(MultiplicationExpressionNode node);
    public abstract Object visit(RangeNode node);
    public abstract Object visit(UnaryMinusNode node);

    // Logical
    public abstract Object visit(OrExpressionNode node);
    public abstract Object visit(AndExpressionNode node);
    public abstract Object visit(RelativeExpressionNode node);
    public abstract Object visit(EqualExpressionNode node);
    public abstract Object visit(NegateNode node);

    public Object visit(Node node)
    {
        return node.accept(this);
    }

    protected void visitChildren(UnaryNode node)
    {
        if (node.getChild() != null)
            node.getChild().accept(this);
    }

    protected void visitChildren(BinaryNode node)
    {
        if (node.getLeftChild() != null)
            node.getLeftChild().accept(this);
        if (node.getRightChild() != null)
            node.getRightChild().accept(this);
    }

    protected void visitChildren(NaryNode node)
    {
        for (Node child : node.getChildren())
            child.accept(this);
    }
}