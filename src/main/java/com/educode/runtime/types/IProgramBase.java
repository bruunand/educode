package com.educode.runtime.types;

/**
 * Created by zen on 5/2/17.
 */
public interface IProgramBase
{
    void debug(String string);

    double random(Double a, Double b);

    void wait(Double time) throws InterruptedException;

    void waitForTick() throws InterruptedException;

    Double time();
}
