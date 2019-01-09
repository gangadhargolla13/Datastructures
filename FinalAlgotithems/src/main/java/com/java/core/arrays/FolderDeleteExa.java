package com.java.core.arrays;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Properties;

public class FolderDeleteExa {

	public static void main(String[] args) throws Exception{
		Properties props = new Properties();
        FileOutputStream fos = new FileOutputStream("C:/project/resources/jobTemplate/jobName.properties");
      
        props.setProperty("jobName", "gangadhar");
      
        //writing properites into properties file from Java
        props.store(fos, "Properties file generated from Java program");
      
        fos.close();
		String path = "C:/project/resources/";
		String jobName = "gangadhar";
		File f = new File(path.concat(jobName));
		//recursiveDelete(f);
	}
	
	public static void recursiveDelete(File file) {
		if (!file.exists())
            return;
		if (file.isDirectory()) {
            for (File f : file.listFiles()) {
                recursiveDelete(f);
            }
        }
		file.delete();
	}
}
