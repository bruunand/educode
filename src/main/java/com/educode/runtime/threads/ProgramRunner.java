package com.educode.runtime.threads;

import com.educode.minecraft.handler.EventHandler;
import com.educode.runtime.ProgramBase;

/* This class ensures that any exceptions will be caught and that the entity is removed in the end */
public class ProgramRunner extends Thread
{
	private final ProgramBase _program;
	
	public ProgramRunner(ProgramBase program)
	{
		this._program = program;
	}
	
	public void run()
	{
		try
		{
			_program.say("Program compiled successfully!");
			_program.main();
		}
		catch (InterruptedException e)
		{
			// Program interrupted - this will happen if the program is waiting and forcefully stopped
            System.out.println("Program interrupted.");
            e.printStackTrace();
		}
		catch (Exception e)
		{
			EventHandler.queueServerExecutable(() -> _program.getRobot().sendMessageTo(_program.getPlayer(), "Unexpected runtime parserError: " + e.getMessage()));
			e.printStackTrace();
		}
	}
}
