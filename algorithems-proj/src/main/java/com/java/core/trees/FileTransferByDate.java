package com.java.core.trees;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FileTransferByDate
{

    public static void main(String[] args) throws Exception
    {
    	  /*Configuration conf = new Configuration();
          FileSystem fs = FileSystem.get(conf);*/
    	String timeStamp = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
    	System.out.println(timeStamp);
        SimpleDateFormat sdf = new SimpleDateFormat("dd-M-yyyy");
        String dateInString = "31-08-1982";
        /*Date d = sdf.parse(dateInString);
        System.out.println(sdf.format(d));*/
        String s="C://ganga";
        File f = new File(s);
        File [] ss =f.listFiles();
        InputStream is = null;
        OutputStream os = null;
        for(File n:ss)
        {
            if(n.isFile() && n.getName().contains(dateInString))
            {
                System.out.println(n.getAbsolutePath());
                File f1 = new File("C://ganga/1982/08/31/");
                if(!f1.exists())
                {
                	f1.mkdirs();
                }
                f1 = new File("C://ganga/1982/08/31/"+n.getName());
                is = new FileInputStream(n);
                os = new FileOutputStream(f1);
                byte[] buffer = new byte[1024];
                int length;
                while ((length = is.read(buffer)) > 0) {
                    os.write(buffer, 0, length);
                }
            }
        }
    }
}

