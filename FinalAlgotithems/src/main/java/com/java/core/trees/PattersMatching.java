package com.java.core.trees;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Pattern;

public class PattersMatching {

	public static void main(String[] args) throws Exception{
		String pattern = "";
		Pattern pat = Pattern.compile(pattern);
		File f = new File("C:/Ganga123/checking");
		String[] listOfFiles = f.list();
		  SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
          Date dateObj = dateFormat.parse("2018-05-30");
          String timeStamp = dateFormat.format(dateObj);
          System.out.println(timeStamp);
		for (String file : listOfFiles) {
			int position = file.lastIndexOf("_");
			if (position != -1) {
				String datePattern = file.substring(position + 1, position + 8);
				//match the pattern
				System.out.println(datePattern);
				if(timeStamp.equalsIgnoreCase(datePattern))
				{
					System.out.println(file);
				}
			}

			// settings_20180509.csv
			// settings20180509.csv

			/*
			 * if(pat.matcher(dd).matches()) { System.out.println(dd); }
			 */
		}
	}
}
