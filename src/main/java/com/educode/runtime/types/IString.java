package com.educode.runtime.types;

/**
 * Created by zen on 5/2/17.
 */
public interface IString
{
    boolean contains(String string);

    String toUpperCase();
    String toLowerCase();

    @SpecialJavaTranslation(formattedTranslation = "StringHelper.splitString(%s)")
    ExtendedList<String> split(String string);
}
