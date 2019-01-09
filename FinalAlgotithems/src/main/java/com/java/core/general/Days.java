package com.java.core.general;

public enum Days {

	SUNDAY(1),MONDAY(2),THUSHDAY(3),WEDNSADAY(4),TUSHDAY(5),FRIDAY(6),SATURDAY(7);
	public int val;
	private Days(int val){
	  this.val=val;	
	}
	public int daysVal(){
		return val;
	}
	
	public static Days getDays(int n){
		Days[] d = Days.values();
		for(Days s:d){
			if(n == s.daysVal())
			{
				return s;
			}
		}
		return null;
	}
}
