package com.educode.minecraft.command;

import com.educode.antlr.EduCodeLexer;
import com.educode.antlr.EduCodeParser;
import com.educode.minecraft.CompilerMod;
import com.educode.minecraft.ScriptRunner;
import com.educode.minecraft.compiler.CustomJavaCompiler;
import com.educode.nodes.base.Node;
import com.educode.nodes.ungrouped.ProgramNode;
import com.educode.runtime.ScriptBase;
import com.educode.symboltable.SymbolTableMessage;
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

import java.util.List;

public class CommandRun implements ICommand
{
    private final List<String> _aliases;
    
    public CommandRun()
    {
        _aliases = java.util.Arrays.asList("run", "runscript");;
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
        return _aliases;
    }

    @Override
    public void execute(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException
    {
        if (args.length < 1) return;
        final String scriptName = args[0];

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
            astRoot.accept(semanticVisitor);
            if (semanticVisitor.getSymbolTableHandler().hasErrors())
            {
                for (SymbolTableMessage message : semanticVisitor.getSymbolTableHandler().getMessages())
                    sender.sendMessage(new TextComponentString(message.toString()));

                return;
            }

            // Generate Java code
            JavaCodeGenerationVisitor javaVisitor = new JavaCodeGenerationVisitor(CompilerMod.SCRIPTS_LOCATION + scriptName + ".java");
            astRoot.accept(javaVisitor);

            // Compile and main Java
            Class<?> compiledClass = new CustomJavaCompiler().compile(CompilerMod.SCRIPTS_LOCATION, scriptName);
            
            // Determine amount of instances to run
            int instances = 1;
            if (args.length > 1)
                instances = Integer.parseInt(args[1]);

            // Run all instances of scripts
            for (int i = 0; i < instances; i++)
            {
                ScriptBase script = (ScriptBase) compiledClass.newInstance();
                script.init(server.getEntityWorld(), (EntityPlayer) sender, semanticVisitor.getEventDefinitions());

                // Run script in separate thread
                new ScriptRunner(script).start();

                // Add to running scripts
                synchronized (CompilerMod.RUNNING_SCRIPTS)
                {
                    CompilerMod.RUNNING_SCRIPTS.add(script);
                }
            }
        }
        catch (Exception e)
        {
            sender.sendMessage(new TextComponentString(TextFormatting.RED + "[Error]" + TextFormatting.RESET + " " + e.getMessage()));

            e.printStackTrace();
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
