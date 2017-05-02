package com.educode.runtime.types;

/**
 * Created by zen on 5/2/17.
 */
public interface IScriptBase
{
    @SpecialJavaTranslation(formattedTranslation = "System.out.println(%s)")
    void debug(String string);

    Float random(Float a, Float b);

    @SpecialJavaTranslation(formattedTranslation =  "java.lang.Math.abs(%s)")
    Float abs(Float input);

    void wait(Float time);

    ExtendedCollection<Float> range(Float start, Float end);
}
