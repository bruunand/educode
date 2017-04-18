package com.educode.minecraft.compiler;

import java.io.File;

import com.educode.minecraft.Utility;

/* Why this is needed:
 * https://dzone.com/articles/java-classloader-handling
 */
public class CustomClassLoader extends ClassLoader
{
    public CustomClassLoader(ClassLoader parent)
    {
        super(parent);
    }
    
    public Class<?> loadClassFromFile(String className, File classFile) throws Exception
    {
        byte[] fileBuffer = Utility.readBytesFromFile(classFile);
        
        return defineClass(className, fileBuffer, 0, fileBuffer.length);
    }
}
