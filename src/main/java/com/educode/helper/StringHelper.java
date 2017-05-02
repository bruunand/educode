package com.educode.helper;

import com.educode.runtime.types.ExtendedCollection;

import java.util.Arrays;
import java.util.Collections;

/**
 * Created by zen on 5/2/17.
 */
public class StringHelper
{
    public static ExtendedCollection<String> splitString(String toSplit, String splitter)
    {
        ExtendedCollection<String> returnList = new ExtendedCollection<>();
        Collections.addAll(returnList, toSplit.split(splitter));

        return returnList;
    }
}
