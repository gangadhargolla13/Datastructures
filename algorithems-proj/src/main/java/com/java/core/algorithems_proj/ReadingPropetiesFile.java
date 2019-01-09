package com.java.core.algorithems_proj;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.Properties;

public class ReadingPropetiesFile {

	public static void main(String[] args) {
		 try
	        {
	            Properties prop = new Properties();
	            InputStream  input = new FileInputStream("C:/Ericsson-Softwares/snapshotJobconfig.properties");
	            prop.load(input);
	            Enumeration<?> e = prop.propertyNames();
	            while(e.hasMoreElements())
	            {
	                String key = (String) e.nextElement();
	                System.out.println(key);
	                String value = prop.getProperty(key);
	                String[] s = key.split("@");
	                if (null != s && s.length > 1)
	                {
	                    String type = s[0].trim().toUpperCase();

	                    switch (type)
	                    {
	                        case "BASELINE":
	                        	System.out.println(s[1]+" BASE  "+value);
	                            break;
	                        case "SNAPSHOT":
	                        	System.out.println(s[1].trim()+" SNAPSHOT  "+value.trim());
	                            break;
	                        case "ARCHIVE":
	                        	System.out.println(s[1].trim()+" ARCHIVE  "+value.trim());
	                            break;
	                        default:
	                            break;
	                    }
	                }
	            }
	        }catch(IOException  fne)
	        {
	            fne.printStackTrace();
	        }
	}
}
