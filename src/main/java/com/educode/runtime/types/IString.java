package com.educode.runtime.types;

import com.educode.runtime.annotations.UseNativeMethodsHelper;

/**
 * Created by zen on 5/2/17.
 */
public interface IString
{
    @UseNativeMethodsHelper
    boolean contains(String string);

    String toUpperCase();
    String toLowerCase();

    @UseNativeMethodsHelper
    ExtendedList split(String string);
}
