package com.educode.minecraft.command;

import java.util.ArrayList;
import java.util.List;

import com.educode.antlr.EduCodeLexer;
import com.educode.antlr.EduCodeParser;
import com.educode.minecraft.CompilerMod;
import com.educode.runtime.ScriptBase;
import com.educode.minecraft.ScriptRunner;
import com.educode.minecraft.compiler.CustomJavaCompiler;
import com.educode.nodes.base.Node;
import com.educode.visitors.ASTBuilder;
import com.educode.visitors.codegeneration.JavaCodeGenerationVisitor;
import com.educode.visitors.semantic.SemanticVisitor;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommand;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextFormatting;
import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;

public class CommandRun implements ICommand
{
    private final List<String> Aliases;
    
    public CommandRun()
    {
        Aliases = new ArrayList<String>();
        Aliases.add("run");
        Aliases.add("runscript");
    }
    
    @Override
    public int compareTo(ICommand arg0)
    {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public String getName()
    {
        return "run";
    }

    @Override
    public String getUsage(ICommandSender sender)
    {
        return "/run <name> [count]";
    }

    @Override
    public List<String> getAliases()
    {
        return Aliases;
    }
    
    
    @Override
    public void execute(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException
    {
        if (args.length < 1) return;
        final String scriptName = args[0];
        // Translate to Java first

        try
        {
            // Generate parse tree from code
            ANTLRInputStream stream = new ANTLRFileStream(CompilerMod.SCRIPTS_LOCATION + scriptName + ".educ");
            EduCodeLexer lexer = new EduCodeLexer(stream);
            CommonTokenStream tokenStream = new CommonTokenStream(lexer);
            EduCodeParser parser = new EduCodeParser(tokenStream);

            // Generate AST from parse tree
            ASTBuilder builder = new ASTBuilder();
            Node astRoot = builder.visit(parser.program());

            // Perform semantic checks
            SemanticVisitor semanticVisitor = new SemanticVisitor();
            semanticVisitor.visit(astRoot);
            if (semanticVisitor.getSymbolTableHandler().hasErrors())
            {
                semanticVisitor.getSymbolTableHandler().printMessages();
                throw new Exception("Could not translate source program.");
            }

            // Generate Java code
            JavaCodeGenerationVisitor javaVisitor = new JavaCodeGenerationVisitor(CompilerMod.SCRIPTS_LOCATION + scriptName + ".java");
            javaVisitor.visit(astRoot);

            // Compile and run Java
            Class<?> compiledClass = new CustomJavaCompiler().compile(CompilerMod.SCRIPTS_LOCATION, scriptName);
            ScriptBase script = (ScriptBase) compiledClass.newInstance();
            script.init(server.getEntityWorld(), (EntityPlayer) sender);
            new ScriptRunner(script).start();
        }
        catch (Exception e)
        {
            sender.sendMessage(new TextComponentString(TextFormatting.RED + "[Error]" + TextFormatting.RESET + " " + e.getMessage()));

            e.printStackTrace();

            return;
        }
    }

    @Override
    public boolean checkPermission(MinecraftServer server, ICommandSender sender)
    {
        return true;
    }

    @Override
    public List<String> getTabCompletions(MinecraftServer server, ICommandSender sender, String[] args, BlockPos targetPos)
    {
        return null;
    }

    @Override
    public boolean isUsernameIndex(String[] args, int index)
    {
        return false;
    }

}