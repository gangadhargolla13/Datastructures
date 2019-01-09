package com.java.strings.v2;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class DateValues {
public static void main(String[] args) throws Exception{
	try
	{
		final SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss z");
        f.setTimeZone(TimeZone.getTimeZone("GMT"));
        System.out.println(f.format(new Date()));
		/*DateFormat gmtFormat = new SimpleDateFormat();
		TimeZone gmtTime = TimeZone.getTimeZone("GMT");
		gmtFormat.setTimeZone(gmtTime);
		System.out.println(new Date());
		System.out.println("Current DateTime in GMT : " + gmtFormat.format(new Date()));*/
		//DateFormat format = new SimpleDateFormat("EEE MMM d HH:mm:ss yyyy zzz");
		//format.setTimeZone(TimeZone.getTimeZone("CET"));
		//Date d = format.parse("Fri Jul 14 11:44:52 2017 CEST");
		//System.out.println(d.toGMTString());
		//System.out.println(format.format(format.parse("Fri Jul 14 11:44:52 2017 CEST")));
		/*String ss = "Jan 05 09:54:15 2018 CET";
		DateFormat format = new SimpleDateFormat("MMM d HH:mm:ss yyyy Z");
		Date date = format.parse(ss);
		System.out.println(date);*/
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	
}
}
