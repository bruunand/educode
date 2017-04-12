package com.educode.minecraft;

public class Command
{
    private boolean _canExecute = false;
    private boolean _hasBeenExecuted = false;
    
    public synchronized void set_hasBeenExecuted(boolean state)
    {
        this._hasBeenExecuted = state;
        this.notify();
    }
    
    public synchronized void set_canExecute(boolean state)
    {
        this._canExecute = state;
        this.notify();
    }
    
    public synchronized void waitForCanExecute() throws InterruptedException
    {
        while (!this._canExecute) wait();
    }
    
    public synchronized void waitForHasBeenExecuted()  throws InterruptedException
    {
    	long now = System.currentTimeMillis();
        while (!this._hasBeenExecuted && (System.currentTimeMillis() - now) < 500) wait();
    }
}
