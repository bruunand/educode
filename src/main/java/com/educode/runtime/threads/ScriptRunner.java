package com.educode.runtime.threads;

import com.educode.runtime.ScriptBase;

/* This class ensures that any exceptions will be caught and that the entity is removed in the end */
public class ScriptRunner extends Thread
{
	private final ScriptBase _script;
	
	public ScriptRunner(ScriptBase script)
	{
	    this.setName("ScriptRunner");
		this._script = script;
	}
	
	public void run()
	{
		try
		{
			_script.say("Script compiled successfully!");
			_script.main();
		}
		catch (InterruptedException e)
		{
			// Script interrupted - this will happen if the script is waiting and forcefully stopped
            System.out.println("Script thread interrupted.");
		}
		catch (Exception e)
		{
			// TODO: Move to robot.say
			System.out.println("Unexpected runtime error: " + e.getMessage());
			e.printStackTrace();
		}
	}
}
