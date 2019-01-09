package com.java.core.core;

public enum DAYS 
{
	SUNDAY(1),MONDAY(2),TUSDAY(3),WEDNESEDAY(4),TURDAY(5),FRIDAY(6),SATURDAY(7);
	private Integer val;
	private DAYS(Integer val)
	{
		System.out.println("I AM GANGADHAR");
		this.val=val;
	}
	
	public Integer getVal()
	{
		return val;
	}
	
	public static void  testing()
	{
		System.out.println("I am validating.");
		DAYS[] d = DAYS.values();
		for(DAYS d1:d)
		{
			System.out.println(d1.val );
		}
	}
	
}
