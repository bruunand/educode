package com.educode.minecraft;

import com.educode.runtime.ScriptBase;

/* This class ensures that any exceptions will be caught and that the entity is removed in the end */
public class ScriptRunner extends Thread
{
	private final ScriptBase _script;
	
	public ScriptRunner(ScriptBase script)
	{
		this.setName(String.format("MAIN-%s's ROBOT", script.getOwner().getWrappedEntity().getName()));
	    this._script = script;
	}
	
	public void run()
	{
		try
		{
			_script.say("Starting script...");
			_script.main();
		}
		catch (Exception e)
		{
			_script.say("Script error: " + e.getMessage());
			e.printStackTrace();
		}
	}
}
