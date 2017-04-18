package com.educode.minecraft;

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
			_script.notify("Starting script...");
			_script.main();
		}
		catch (Exception e)
		{
			_script.notify("Script error: " + e.getMessage());
			e.printStackTrace();
		}
		finally
		{
			_script.notify("Ending script...");
			_script.selfDestruct();
		}
	}
}
