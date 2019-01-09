package com.java.latestfeatures;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class LatestFeaturesWithDate 
{
	public static void main(String[] args) throws Exception{
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy MMM dd HH:mm:ss");
		Calendar calendar = new GregorianCalendar(2018,11,28,20,14,05);
		System.out.println(sdf.format(calendar.getTime()));
		calendar.set(Calendar.MONTH, 4);
		System.out.println(sdf.format(calendar.getTime()));
		calendar.set(Calendar.MONTH, -4);
		System.out.println(sdf.format(calendar.getTime()));
		System.out.println(calendar.get(Calendar.HOUR));
		System.out.println(calendar.get(Calendar.MONTH));
		/*SimpleDateFormat format = new SimpleDateFormat("dd/M/yyyy");
		Date d = format.parse("26/11/2018");
		System.out.println(d.toString());
		SimpleDateFormat format1 = new SimpleDateFormat("dd-M-yyyy");
		String ss = format1.format(d);
		System.out.println(ss);
		Calendar cal = Calendar.getInstance();
		cal.setTime(d);
		cal.add(Calendar.DATE, 4);
		Date d2 = cal.getTime();
		System.out.println(format.format(d2));
		System.out.println(format.format(d));
		if(d.before(d2))
		{
			System.out.println("D1 is before to D2");
		}
		else
		{
			System.out.println("D1 isn't before to D2");
		}
		if(d.after(d2))
		{
			System.out.println("D1 after is D2");
		}else
		{
			System.out.println("D1 isn't after to D2");
		}
		if(d.compareTo(d2)==0)
		{
			System.out.println("Both are equal");
		}
		SimpleDateFormat format = new SimpleDateFormat("YYYY-mm-dd");
		Date d = format.parse("2018-11-26");
		String d1 = format.format(d);
		System.out.println(d1);
		Calendar cal = Calendar.getInstance();
		cal.set(2018, 11, 26);
		cal.setTimeZone(TimeZone.getDefault());
		System.out.println(cal.getFirstDayOfWeek());*/
	}
}
