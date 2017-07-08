package com.educode.runtime.threads;

import com.educode.minecraft.handler.EventHandler;
import com.educode.nodes.ungrouped.StartNode;
import com.educode.runtime.ProgramBase;
import com.educode.visitors.interpreter.InterpretationVisitor;

/* This class ensures that any exceptions will be caught and that the entity is removed in the end */
public class ProgramRunner extends Thread
{
	private final ProgramBase _program;
	private final StartNode _startNode;

	public ProgramRunner(ProgramBase program, StartNode startNode)
	{
		this._program = program;
		this._startNode = startNode;
	}
	
	public void run()
	{
		try
		{
			this._program.say("Program compiled successfully!");
			new InterpretationVisitor(this._program).visit(this._startNode);
		}
		catch (InterruptedException e)
		{
			// Program interrupted - this will happen if the program is waiting and forcefully stopped
            System.out.println("Program interrupted.");
            e.printStackTrace();
		}
		catch (Exception e)
		{
			EventHandler.queueServerExecutable(() -> _program.getRobot().sendMessageTo(_program.getPlayer(), "Unexpected runtime error: " + e.getMessage()));
			e.printStackTrace();
		}
	}
}
