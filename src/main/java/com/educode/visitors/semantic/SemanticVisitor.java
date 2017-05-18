package com.educode.visitors.semantic;

import com.educode.antlr.EduCodeLexer;
import com.educode.antlr.EduCodeParser;
import com.educode.errorhandling.ErrorHandler;
import com.educode.helper.InterfaceConverter;
import com.educode.nodes.base.NaryNode;
import com.educode.nodes.base.Node;
import com.educode.nodes.expression.AdditionExpression;
import com.educode.nodes.expression.MultiplicationExpression;
import com.educode.nodes.expression.logic.EqualExpressionNode;
import com.educode.nodes.expression.logic.LogicExpressionNode;
import com.educode.nodes.expression.logic.NegateNode;
import com.educode.nodes.expression.logic.RelativeExpressionNode;
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
import com.educode.runtime.types.IScriptBase;
import com.educode.symboltable.Symbol;
import com.educode.symboltable.SymbolTable;
import com.educode.symboltable.SymbolTableHandler;
import com.educode.types.ArithmeticOperator;
import com.educode.types.Type;
import com.educode.visitors.ASTBuilder;
import com.educode.visitors.VisitorBase;
import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;

import java.util.*;

/**
 * Created by User on 15-Apr-17.
 */
public class SemanticVisitor extends VisitorBase
{
    private StartNode _mainStartNode;
    private List<ImportNode> _imports = new LinkedList<>();
    private Hashtable<String, ImportNode> _imports2 = new Hashtable<String, ImportNode>();

    private final SymbolTableHandler _symbolTableHandler;
    private final List<EventDefinitionNode> _eventDefinitions = new ArrayList<>();
    private final Deque<Node> _iterativeNodes = new ArrayDeque<Node>();

    public SemanticVisitor()
    {
        // Adds methods like debug to the base symbol table
        _symbolTableHandler = new SymbolTableHandler(InterfaceConverter.getSymbolTableFromClass(null, IScriptBase.class));
    }

    public SymbolTableHandler getSymbolTableHandler()
    {
        return this._symbolTableHandler;
    }

    @Override
    public Object defaultVisit(Node node)
    {
        if (!(node instanceof ILiteral))
            System.out.printf("No visitor for node %s.\n", node.getClass().getName());

        return null;
    }


    public void visit(StartNode node)
    {
        if (node.getIsMain())
            _mainStartNode = node;

        visit(node.getLeftChild());
        getSymbolTableHandler().setInputSource(node);
        visit(node.getRightChild());

        gatherImports((ProgramNode)node.getRightChild());
    }

    private void gatherImports(ProgramNode target)
    {
        Enumeration<ImportNode> nodes = _imports2.elements();
        while (nodes.hasMoreElements())
        {
            ImportNode i = nodes.nextElement();
            StartNode s = i.getImportedNode();

            if (s != null && s.hasRightChild() && s.getRightChild() instanceof ProgramNode)
            {
                ProgramNode programNode = (ProgramNode) i.getImportedNode().getRightChild();
                for (Node child: programNode.getChildren())
                    target.addChild(child);
            }
        }
    }

    public void visit(UsingsNode node)
    {
        visitChildren(node);
    }

    public void visit(ImportNode node)
    {
        String name = String.format("%s.educ", node.getText());

        if (!_imports2.containsKey(name) && !name.equals(_mainStartNode.getInputSource()))
        {
            try
            {
                Node sub = getImportedStartNode(name);
                if (sub instanceof StartNode)
                {
                    ((StartNode) sub).setInputSource(name);
                    _imports2.put(name, node);
                    visit(sub);
                    node.setImportedNode(((StartNode) sub));
                    //_imports.add(node);
                }
                else
                    getSymbolTableHandler().error(sub, String.format("%s: AST root not StartNode", name));
            }
            catch (Exception e)
            {
                getSymbolTableHandler().error(node, String.format("Could not import %s: %s", name, e.getMessage()));
            }
        }
    }

    private Node getImportedStartNode(String name) throws Exception
    {
        // Parse subprogram with ANTLR
        ANTLRInputStream stream = new ANTLRFileStream(name);
        EduCodeLexer lexer = new EduCodeLexer(stream);
        CommonTokenStream tokenStream = new CommonTokenStream(lexer);
        EduCodeParser parser = new EduCodeParser(tokenStream);

        // Run ASTBuilder on the parse tree and return its start node
        return new ASTBuilder(new ErrorHandler()).visit(parser.start());
    }

    public void visit(ProgramNode node)
    {
        // Add default methods and fields to symbol table
        getSymbolTableHandler().getCurrent().addDefaultField("robot", Type.RobotType);

        // Run return check visitor
        node.accept(new ReturnCheckVisitor(this.getSymbolTableHandler()));

        // Enter all method declarations
        boolean hasMainMethod = false;
        for (MethodDeclarationNode method : node.getMethodDeclarations())
        {
            getSymbolTableHandler().enterSymbol(method);

            // Check if signature of method matches main method
            if (method.getReference().toString().equals("main") && method.getType().equals(Type.VoidType) && !method.hasParameterList())
                hasMainMethod = true;
        }

        // If no main method and StartNode is main StartNode, log error
        if (!hasMainMethod && ((StartNode)node.getParent()).getIsMain())
            _symbolTableHandler.error(node, "Program has no method called 'main' with no return type and parameters.");

        // Visit children in correct order
        // Variable declarations must be visited before method declarations
        for (VariableDeclarationNode varDecl : node.getVariableDeclarations())
        {
            varDecl.setDeclaredGlobally(true);
            visit(varDecl);
        }

        // We can then visit event definitions
        // These require method symbols, but they have been declared previously
        for (EventDefinitionNode eventDef : node.getEventDefinitions())
            visit(eventDef);

        // We can also visit method declarations at this point
        for (MethodDeclarationNode methodDecl : node.getMethodDeclarations())
            visit(methodDecl);
    }

    public void visit(NaryNode node)
    {
        visitChildren(node);
    }

    public void visit(ConditionNode node)
    {
        // Visit condition
        visit(node.getLeftChild());

        Type conditionType = node.getLeftChild().getType();

        // Check if condition type is boolean
        if (!conditionType.equals(Type.BoolType))
            _symbolTableHandler.error(node, String.format("Condition must be of type %s, but is of type %s.", Type.BoolType, conditionType));

        // Visit block
        visit(node.getRightChild());
    }

    public void visit(RepeatWhileNode node)
    {
        _iterativeNodes.push(node);
        visitChildren(node);
        _iterativeNodes.pop();
    }

    public void visit(IfNode node)
    {
        visitChildren(node);
    }

    public void visit(EventDefinitionNode node)
    {
        // Retrieve matching method symbol
        Symbol methodSymbol = getSymbolTableHandler().getCurrent().retrieveMethodSymbol(node.getReference(), node.getEventType().getRequiredParameters());

        if (methodSymbol == null)
            getSymbolTableHandler().error(node, String.format("No method %s found matching the required parameters for event %s.", node.getReference(), node.getEventType().getName()));
        else
            _eventDefinitions.add(node);
    }

    public void visit(MethodDeclarationNode node)
    {
        getSymbolTableHandler().openScope();

        getSymbolTableHandler().setCurrentParentMethod(node);

        // Visit parameters
        if (node.getParameterList() != null)
            visitChildren(node.getParameterList());

        // Visit block
        visit(node.getBlockNode());

        node.setMaxDeclaredVariables(getSymbolTableHandler().getCurrent().getMaxDeclaredVariableCounter());

        getSymbolTableHandler().closeScope();
    }

    public void visit(ParameterNode node)
    {
        getSymbolTableHandler().enterSymbol(node);
        node.getReference().setType(node.getType()); // todo better solution

        if (node.getType() == Type.NumberType)
            getSymbolTableHandler().getCurrent().addDeclaredVariableCounter(2);
        else
            getSymbolTableHandler().getCurrent().addDeclaredVariableCounter(1);
    }

    public void visit(ForEachNode node)
    {
        _iterativeNodes.push(node);
        _symbolTableHandler.openScope();

        _symbolTableHandler.enterSymbol(node);

        visit(node.getReference());
        visitChildren(node);

        // Get type of left child (expression)
        Type expressionType = node.getLeftChild().getType();

        if (!expressionType.isCollection())
            getSymbolTableHandler().error(node, String.format("Expression of type %s is not applicable in a for-each statement.", expressionType));
        else if (!node.getReference().getType().equals(expressionType.getChildType()))
            getSymbolTableHandler().error(node, String.format("Expression to iterate in for-each statement must be a collection of %s.", node.getType()));

        _symbolTableHandler.closeScope();
        _iterativeNodes.pop();
    }

    public void visit(BlockNode node)
    {
        getSymbolTableHandler().openScope();

        visitChildren(node);

        getSymbolTableHandler().closeScope();
    }


    public void visit(CoordinatesLiteralNode node)
    {
        visit(node.getX());
        visit(node.getY());
        visit(node.getZ());

        if (!node.getX().isType(Type.NumberType) || !node.getY().isType(Type.NumberType) || !node.getZ().isType(Type.NumberType))
            getSymbolTableHandler().error(node, "Coordinate values must evaluate to a number.");
    }

    public void visit(MethodInvocationNode node)
    {
        visitChildren(node);

        Symbol methodReference = getSymbolTableHandler().getCurrent().retrieveMethodSymbol(node.getReference(), node.getActualTypes());

        // Check if method was found
        if (methodReference == null)
            getSymbolTableHandler().error(node, "No method %s found with matching parameters.", node.getReference());
        else
        {
            MethodDeclarationNode referencingDeclaration = (MethodDeclarationNode) methodReference.getSourceNode();
            node.setType(referencingDeclaration.getType());
            node.setReferencingDeclaration(referencingDeclaration);
        }
    }

    public void visit(AssignmentNode node)
    {
        visit(node.getReference());
        visitChildren(node);

        // Check if left side types matches right side type
        // Reference types can be assigned to null
        if (node.getReference().isType(Type.RobotType))
            getSymbolTableHandler().error(node, "Cannot assign the special %s type to anything.");
        else if (node.getChild() instanceof NullLiteralNode)
        {
            // If we assign something to null, we set the type of the null literal to the type of the assigned node
            // This is necessary in cases such as x = y = null, where x and y are the same type
            if (!node.getReference().getType().isReferenceType())
                getSymbolTableHandler().error(node, "Cannot assign %s, which is not a reference type, to null.", node.getReference());
            else
                node.getChild().setType(node.getReference().getType());
        }
        else if (!node.getReference().isType(node.getChild().getType()))
            getSymbolTableHandler().error(node, "Cannot assign %s, which is of type %s, to an expression of type %s.", node.getReference(), node.getReference().getType(), node.getChild().getType());

        // Set the type of the assignment to have the same type as its right side
        // We need to do this because assignments can be used as expressions and not just single statements
        node.setType(node.getChild().getType());
    }

    public Symbol visit(IdentifierReferencingNode reference)
    {
        Symbol referencingSymbol = getSymbolTableHandler().retrieveSymbol(reference);

        if (referencingSymbol == null)
            getSymbolTableHandler().error(reference, "Identifier %s is not declared.", reference);
        else
        {
            // Symbol was found - now set the type of the reference to the type of the symbol we just found
            reference.setType(referencingSymbol.getSourceNode().getType());

            // If source node is a variable declaration, set this identifier referencing node to reference that variable declaration
            if (referencingSymbol.getSourceNode() instanceof VariableDeclarationNode)
                reference.setDeclaration((VariableDeclarationNode) referencingSymbol.getSourceNode());
        }

        return referencingSymbol;
    }

    public void visit(ArrayReferencingNode reference)
    {
        visitChildren(reference);

        // Left side must be a collection
        Type leftSideType = reference.getLeftChild().getType();
        if (!leftSideType.isCollection())
            getSymbolTableHandler().error(reference, "Left side of array reference must be a collection.");
        else
            reference.setType(leftSideType.getChildType());
    }

    public void visit(ObjectInstantiationNode node)
    {
        // We need to visit children to ensure that actual parameters contain known variables
        visitChildren(node);

        // Only allow instantiation of collections
        if (!node.getType().isCollection())
            getSymbolTableHandler().error(node, String.format("Cannot instantiate object of type %s.", node.getType()));
        else if (node.getType().isCollection())
        {
            Type collectionChildType = node.getType().getChildType();

            // Check if actual arguments are of the collection's child type
            for (Node actual : node.getActualArguments())
            {
                Type actualType = actual.getType();

                if (!actualType.equals(collectionChildType))
                    getSymbolTableHandler().error(node, String.format("Arguments in the instantiation of %s must be of type %s, but the argument was of type %s.", node.getType(), collectionChildType, actualType));
            }
        }
    }

    public void visit(StructReferencingNode reference)
    {
        // Only visit left child (object) - not right side (field)
        visit(reference.getLeftChild());

        // Use type of left side as symbol table
        SymbolTable table = reference.getLeftChild().getType().getSymbolTable();
        if (table == null)
        {
            getSymbolTableHandler().error(reference, "Type %s does not have a symbol table.", reference.getLeftChild().getType());
            return;
        }

        // Fields and methods have different approaches for retrieval
        if (reference.getRightChild() instanceof IdentifierReferencingNode)
        {
            Symbol symbol = table.retrieveSymbol(reference.getRightChild());

            if (symbol == null)
                getSymbolTableHandler().error(reference, "Type %s does not contain field %s.", reference.getLeftChild().getType(), reference.getRightChild());
            else
                reference.setType(symbol.getSourceNode().getType());
        }
        else if (reference.getRightChild() instanceof MethodInvocationNode)
        {
            // We need to visit arguments to evaluate their actual type
            MethodInvocationNode methodInv = (MethodInvocationNode) reference.getRightChild();
            for (Node argument : methodInv.getActualArguments())
                visit(argument);

            // Retrieve symbol from this struct type
            Symbol symbol = table.retrieveMethodSymbol(methodInv.getReference(), methodInv.getActualTypes());

            if (symbol == null)
                getSymbolTableHandler().error(reference, "Type %s does not contain method %s.", reference.getLeftChild().getType(), methodInv.getReference());
            else
            {
                MethodDeclarationNode referencingDeclaration = (MethodDeclarationNode) symbol.getSourceNode();
                reference.setType(referencingDeclaration.getType());
                methodInv.setReferencingDeclaration(referencingDeclaration);
            }
        }
    }

    public void visit(VariableDeclarationNode node)
    {
        if (!(node.getReference() instanceof IdentifierReferencingNode))
            getSymbolTableHandler().error(node, "A variable declaration cannot reference a struct or an array.");
        else
            getSymbolTableHandler().enterSymbol(node);

        // Add default values if no assignment

        if (node.getChild() == null)
        {
            switch (node.getType().getKind())
            {
                case Type.NUMBER:
                    node.setAssignment(new NumberLiteralNode(0.0F));
                    break;
                case Type.COORDINATES:
                    node.setAssignment(new CoordinatesLiteralNode(new NumberLiteralNode(0.0F), new NumberLiteralNode(0.0F), new NumberLiteralNode(0.0F)));
                    break;
                case Type.BOOL:
                    node.setAssignment(new BoolLiteralNode(false));
                    break;
                case Type.STRING:
                    node.setAssignment(new StringLiteralNode(""));
                    break;
                default:
                    if (node.getType().isReferenceType())
                        node.setAssignment(new NullLiteralNode());
            }
        }

        visitChildren(node);

        if (node.getType() == Type.NumberType)
            getSymbolTableHandler().getCurrent().addDeclaredVariableCounter(2);
        else
            getSymbolTableHandler().getCurrent().addDeclaredVariableCounter(1);
    }

    public void visit(ReturnNode node)
    {
        visitChildren(node);

        Type parentType = getSymbolTableHandler().getCurrentParentMethod().getType();
        Type childType = Type.VoidType;
        if (node.hasChild())
            childType = node.getChild().getType();
        node.setType(childType);

        // Return type and parent method type should be equal
        if (!parentType.equals(childType))
            getSymbolTableHandler().error(node, String.format("Can not return an expression of type %s when parent method returns %s.", childType, parentType));
    }

    public void visit(MultiplicationExpression node)
    {
        visitChildren(node);

        Type leftType  = node.getLeftChild().getType();
        Type rightType = node.getRightChild().getType();

        if (leftType.equals(Type.NumberType) && rightType.equals(Type.NumberType))
        {
            node.setType(Type.NumberType);

            // Check for division by zero
            if (node.getOperator().equals(ArithmeticOperator.Division) && node.getRightChild() instanceof NumberLiteralNode)
            {
                if (((NumberLiteralNode) node.getRightChild()).getValue() == 0)
                    getSymbolTableHandler().error(node, "Division by 0 is not allowed.");
            }
        }
        else
            getSymbolTableHandler().error(node, String.format("%s operator cannot be used on %s and %s.", node.getOperator(), leftType, rightType));
    }

    public void visit(AdditionExpression node)
    {
        visitChildren(node);

        Type leftType  = node.getLeftChild().getType();
        Type rightType = node.getRightChild().getType();

        if (leftType.equals(Type.NumberType) && rightType.equals(Type.NumberType))
            node.setType(Type.NumberType);
        else if (leftType.equals(Type.StringType) || rightType.equals(Type.StringType))
            node.setType(Type.StringType);
        else if (leftType.equals(Type.CoordinatesType) && rightType.equals(Type.CoordinatesType))
            node.setType(Type.CoordinatesType);
        else
            getSymbolTableHandler().error(node, String.format("%s operator cannot be used on %s and %s.", node.getOperator(), leftType, rightType));
    }

    public void visit(LogicExpressionNode node)
    {
        visitChildren(node);

        Type leftType  =  node.getLeftChild().getType();
        Type rightType = node.getRightChild().getType();

        if (!leftType.equals(Type.BoolType) || !rightType.equals(Type.BoolType))
            getSymbolTableHandler().error(node, String.format("Both sides of the %s expression must be of type %s, but are of type %s and %s.", node.getOperator(), Type.BoolType, leftType, rightType));
    }

    public void visit(RelativeExpressionNode node)
    {
        visitChildren(node);

        Type leftType  = node.getLeftChild().getType();
        Type rightType = node.getRightChild().getType();

        boolean isNumberComparison = leftType.equals(Type.NumberType) && rightType.equals(Type.NumberType);
        boolean isStringComparison = leftType.equals(Type.StringType) && rightType.equals(Type.StringType);

        // Only number and string comparisons are allowed
        if (!isNumberComparison && !isStringComparison)
            getSymbolTableHandler().error(node, String.format("Logical operator %s can not be used for types %s and %s.", node.getOperator(), leftType, rightType));
    }

    public void visit(EqualExpressionNode node)
    {
        visitChildren(node);

        // Get the types of the children for conveniences
        Type leftType  = node.getLeftChild().getType();
        Type rightType = node.getRightChild().getType();

        // Check whether either of the children are null literals
        boolean isLeftNull  = node.getLeftChild() instanceof NullLiteralNode;
        boolean isRightNull = node.getRightChild() instanceof NullLiteralNode;

        // Check for null comparisons
        // In all other cases, check if the types of the sides are equal
        if (isLeftNull || isRightNull)
        {
            if (isLeftNull && isRightNull)
                getSymbolTableHandler().error(node, "Cannot compare two null literals.");
            else if ((isLeftNull && !node.getRightChild().getType().isReferenceType()) || (isRightNull && !node.getLeftChild().getType().isReferenceType()))
                getSymbolTableHandler().error(node, "Cannot compare non-references types to the null literal.");
        }
        else if (!leftType.equals(rightType))
            getSymbolTableHandler().error(node, String.format("Logical operator %s cannot be used for types %s and %s.", node.getOperator(), leftType, rightType));
    }

    public void visit(NegateNode node)
    {
        visitChildren(node);

        if(!node.getChild().getType().equals(Type.BoolType))
            getSymbolTableHandler().error(node, "Negated expression was not of boolean type.");
    }

    public void visit(TypeCastNode node)
    {
        visitChildren(node);

        Type fromType = node.getChild().getType();
        Type toType   = node.getType();

        if (fromType.equals(toType))
            _symbolTableHandler.warning(node, String.format("Redundant cast from %s to %s", fromType, toType));
        else if (!isExplicitCastAllowed(fromType, toType))
            getSymbolTableHandler().error(node, String.format("Type %s cannot be cast to type %s.", fromType, toType));
    }

    public void visit(ContinueNode node){
        if(_iterativeNodes.isEmpty())
            getSymbolTableHandler().error(node, "No enclosing loop to continue.");
        else
            node.setAffectingLoop(_iterativeNodes.peek());
    }

    public void visit(BreakNode node){
        if(_iterativeNodes.isEmpty())
            getSymbolTableHandler().error(node, "No enclosing loop to break.");
        else
            node.setAffectingLoop(_iterativeNodes.peek());
    }

    private boolean isExplicitCastAllowed(Type fromType, Type toType)
    {
        if (toType.equals(Type.StringType))
            return true;

        return false;
    }

    public List<EventDefinitionNode> getEventDefinitions()
    {
        return _eventDefinitions;
    }
}
