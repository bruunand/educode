package com.educode.minecraft.compiler;

import com.educode.minecraft.CompilerMod;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import javax.tools.JavaCompiler;
import javax.tools.JavaCompiler.CompilationTask;

import javax.tools.StandardJavaFileManager;
import javax.tools.StandardLocation;
import javax.tools.ToolProvider;

public class CustomJavaCompiler
{	
	private String getClassPath()
	{ 
		StringBuffer buffer = new StringBuffer();
		for (URL url : ((URLClassLoader) (Thread.currentThread().getContextClassLoader())).getURLs())
		{
			buffer.append(new File(url.getPath()));
			buffer.append(System.getProperty("path.separator"));
		}
		String classpath = buffer.toString();
		return classpath.substring(0, classpath.lastIndexOf(System.getProperty("path.separator")));
	} 
	
    public Class<?> compile(String programName) throws Exception
    {
    	JavaCompiler javaCompiler = ToolProvider.getSystemJavaCompiler();
    	if (javaCompiler == null)
    		throw new Exception("A Java compiler was not found. Please main this modification with JDK."); // TODO custom exception
    	
        StandardJavaFileManager fileManager = javaCompiler.getStandardFileManager(null, null, null);

        fileManager.setLocation(StandardLocation.CLASS_OUTPUT, Collections.singletonList(new File(CompilerMod.EDUCODE_PROGRAMS_LOCATION)));

        File[] javaFiles = new File[] { new File(CompilerMod.EDUCODE_PROGRAMS_LOCATION + programName + ".java")};
        if (!javaFiles[0].exists())
        	throw new FileNotFoundException("Program file " + javaFiles[0] + " not found!");
        
        List<String> options = new ArrayList<>();
        options.add("-classpath");
        options.add(getClassPath());
        
        CompilationTask compilationTask = javaCompiler.getTask(null, null, null, options, null, fileManager.getJavaFileObjects(javaFiles));
        if (!compilationTask.call())
		{
			throw new Exception("Could not compile program!"); // TODO custom exception
		}

		return loadClass(programName);
    }

    public static Class loadClass(String programName) throws Exception
	{
		CustomClassLoader loader = new CustomClassLoader(CustomClassLoader.class.getClassLoader());
		return loader.loadClassFromFile(programName, new File(CompilerMod.EDUCODE_PROGRAMS_LOCATION + programName + ".class"));
	}
}
