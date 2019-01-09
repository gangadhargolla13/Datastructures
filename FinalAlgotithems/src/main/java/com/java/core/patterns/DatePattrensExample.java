package com.java.core.patterns;

import java.util.regex.Pattern;

public class DatePattrensExample {
	private static Pattern DATE_PATTERN = Pattern.compile("^.*\\d{4}-\\d{2}-\\d{2}.*");
	private int size;
	public static void main(String[] args) {
		String [] s ={"2017-12-31gangadhar", "2018-01-31", "0000-00-00", "1029-99-72"};
		for(String ss:s)
		System.out.println(matches(ss));
	}
	public static boolean matches(String date) {
        return DATE_PATTERN.matcher(date).matches();
    }
	public DatePattrensExample()
	{
		System.out.println("I am ok");
	}
	
	public DatePattrensExample(Integer val)
	{
		size = val;
	}
	
	public int getSize(){
	return size;
	}
}
