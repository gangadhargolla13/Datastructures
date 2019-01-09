package com.java.core.general;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class FormatExamples {

	public static void main(String[] args) throws Exception
	{
		String s = "2018-05-30";
		Date cal = Calendar.getInstance().getTime();
		System.out.println(new Date().toString());
		SimpleDateFormat simple = new SimpleDateFormat("yyyyMMdd");
		DateFormat f = simple.getDateInstance();
		System.out.println(f.parse(s));
		Date d = simple.parse(s);
		System.out.println(simple.format(d).toString());
	}
}
