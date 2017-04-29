package com.educode.runtime;

import com.educode.runtime.ScriptBase;

/* This class ensures that any exceptions will be caught and that the entity is removed in the end */
public class ScriptRunner extends Thread
{
	private final ScriptBase _script;
	
	public ScriptRunner(ScriptBase script)
	{
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
			e.printStackTrace();
		}
		catch (Exception e)
		{
			_script.say("Unexpected runtime error: " + e.getMessage());
			e.printStackTrace();
		}
	}
}
