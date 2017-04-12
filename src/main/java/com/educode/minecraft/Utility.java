package com.educode.minecraft;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class Utility
{
    public static byte[] readBytesFromFile(File file) throws IOException
    {
    	byte[] buffer = new byte[1024];
        FileInputStream inputStream = new FileInputStream(file);
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        
        try
        {
            int read;
            while ((read = inputStream.read(buffer)) != -1)
            {
            	outputStream.write(buffer, 0, read);
            }
            return outputStream.toByteArray();
        }
        finally
        {
            inputStream.close();
            outputStream.close();
        }
    }
}
