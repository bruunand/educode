package com.educode.runtime.types;

/**
 * Created by zen on 5/2/17.
 */
public interface IProgramBase
{
    @SpecialJavaTranslation(formattedTranslation = "System.out.println(%s)")
    void debug(String string);

    double random(double a, double b);

    @SpecialJavaTranslation(formattedTranslation =  "java.lang.Math.abs(%s)")
    double abs(double input);

    void wait(double time);

    ExtendedList<Double> range(double start, double end);
}
