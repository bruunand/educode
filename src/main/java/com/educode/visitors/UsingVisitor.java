package com.educode.visitors;

import com.educode.antlr.EduCodeLexer;
import com.educode.antlr.EduCodeParser;
import com.educode.nodes.base.Node;
import com.educode.nodes.referencing.IReference;
import com.educode.nodes.referencing.IdentifierReferencingNode;
import com.educode.nodes.ungrouped.ProgramNode;
import com.educode.nodes.ungrouped.StartNode;
import com.educode.nodes.ungrouped.UsingsNode;
import com.educode.symboltable.SymbolTableHandler;
import com.educode.visitors.semantic.SemanticVisitor;
import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Thomas Buhl on 16/05/2017.
 */
public class UsingVisitor extends VisitorBase{
    private final SymbolTableHandler _symbolTableHandler;
    private final List<String> subprograms;
    private final SemanticVisitor sv;
    private List<ProgramNode> subs = new LinkedList<ProgramNode>();
    private StartNode main = null;

    public UsingVisitor(String mainName)
    {
        sv = new SemanticVisitor();
        _symbolTableHandler = sv.getSymbolTableHandler();
        subprograms = new LinkedList<String>();
        subprograms.add(mainName);
        _symbolTableHandler.openScope();
    }

    public SymbolTableHandler getSymbolTableHandler()
    {
        return this._symbolTableHandler;
    }

    @Override
    public Object defaultVisit(Node node)
    {
        visitChildren(node);
        return null;
    }

    public void visit(StartNode node) throws Exception
    {
        if (main == null)
        {
            main = node;
        }

        visit(node.getLeftChild());


        node.getRightChild().accept(sv);

        if (node.equals(main))
        {
            ProgramNode mainProgram = (ProgramNode) main.getRightChild();
            for (ProgramNode n: subs)
            {
                for (Node decl: n.getChildren())
                {
                    mainProgram.addChild(decl);
                }
            }
        }
    }

    public void visit(UsingsNode node) throws Exception
    {
        for (Node i: node.getChildren())
        {
            String name = ((IdentifierReferencingNode)i).getText();
            if (subprograms.contains(name))
                continue;
            else
            {
                subprograms.add(name);
                Node sub = tempFunc(name);
                visit(sub);
                subs.add((ProgramNode)((StartNode)sub).getRightChild());
            }
        }
    }

    public Node tempFunc(String name) throws Exception
    {
        ANTLRInputStream stream = new ANTLRFileStream(name+".educ");
        EduCodeLexer lexer = new EduCodeLexer(stream);
        CommonTokenStream tokenStream = new CommonTokenStream(lexer);
        EduCodeParser parser = new EduCodeParser(tokenStream);

        ASTBuilder builder = new ASTBuilder();
        Node root = builder.visit(parser.program());
        System.out.println(root.accept(new PrintVisitor()));
        return root;

        /*
        SemanticVisitor sv = new SemanticVisitor();
        root.accept(sv);
        sv.getSymbolTableHandler().printMessages();

        if (sv.getSymbolTableHandler().hasErrors())
            return;
        */
    }

}
