package com.educode.runtime.types;

/**
 * Created by zen on 5/2/17.
 */
public interface IString
{
    @NativeMethodsHelperAnnotation(useHelper = true)
    boolean contains(String string);

    String toUpperCase();
    String toLowerCase();

    @NativeMethodsHelperAnnotation(useHelper =  true)
    ExtendedList<String> split(String string);
}
