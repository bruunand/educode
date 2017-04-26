package com.educode.helper;

import org.apache.commons.lang3.StringUtils;

/**
 * Created by Simon on 25/04/2017.
 */
public class ArrayHelper
{
    public static  int characterCountInArray(String character, String[] array)
    {
        int count = 0;

        for (String element : array)
        {
            if (element.contains(character))
            {
                count += StringUtils.countMatches(element, character);
            }
        }

        return count;
    }

    public static int indexOfNth(String element, String[] array, int n)
    {
        int i = 0, hits = 0;
        for (String index : array)
        {
            if (index.equals(element))
            {
                hits++;
                if (hits == n)
                {
                    break;
                }
            }
            i++;
            if (i == array.length)
            {
                return -1;
            }
        }
        return i;
    }

    public static int indexOfNth(char element, char[] array, int n)
    {
        int i = 0, hits = 0;
        for (char index : array)
        {
            if (index == element)
            {
                hits++;
                if (hits == n)
                {
                    break;
                }
            }
            i++;
            if (i == array.length)
            {
                return -1;
            }
        }
        return i;
    }
}
