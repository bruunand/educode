package com.educode.helper;

import com.educode.runtime.types.ExtendedList;

import java.util.Collections;

/**
 * Created by zen on 5/2/17.
 */
public class StringHelper
{
    public static ExtendedList<String> splitString(String toSplit, String splitter)
    {
        ExtendedList<String> returnList = new ExtendedList<>();
        Collections.addAll(returnList, toSplit.split(splitter));

        return returnList;
    }
}
