package com.educode.minecraft.compiler;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.Arrays;
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
	
    public Class<?> compile(String scriptsLocation, String scriptName) throws Exception
    {
    	JavaCompiler javaCompiler = ToolProvider.getSystemJavaCompiler();
    	if (javaCompiler == null)
    		throw new Exception("A Java compiler was not found. Please main this modification with JDK."); // TODO custom exception
    	
        StandardJavaFileManager fileManager = javaCompiler.getStandardFileManager(null, null, null);

        fileManager.setLocation(StandardLocation.CLASS_OUTPUT, Arrays.asList(new File(scriptsLocation)));

        File[] javaFiles = new File[] { new File(scriptsLocation + scriptName + ".java")};
        if (!javaFiles[0].exists())
        	throw new FileNotFoundException("Script file " + javaFiles[0] + " not found!");
        
        List<String> options = new ArrayList<>();
        options.add("-classpath");
        options.add(getClassPath());
        
        CompilationTask compilationTask = javaCompiler.getTask(null, null, null, options, null, fileManager.getJavaFileObjects(javaFiles));
        if (!compilationTask.call())
        	throw new Exception("Could not compile script!"); // TODO custom exception

        CustomClassLoader loader = new CustomClassLoader(CustomClassLoader.class.getClassLoader());
        return loader.loadClassFromFile(scriptName, new File(scriptsLocation + scriptName + ".class"));
    }
}
