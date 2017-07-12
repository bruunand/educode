package com.educode.runtime;

import com.educode.runtime.types.ExtendedList;

import java.util.Collections;

/**
 * Created by zen on 7/12/17.
 */
public class NativeMethodsHelper
{
    public static boolean contains(String first, String second)
    {
        return first.contains(second);
    }

    public static ExtendedList<String> split(String toSplit, String splitter)
    {
        ExtendedList<String> returnList = new ExtendedList<>();
        Collections.addAll(returnList, toSplit.split(splitter));

        return returnList;
    }
}
