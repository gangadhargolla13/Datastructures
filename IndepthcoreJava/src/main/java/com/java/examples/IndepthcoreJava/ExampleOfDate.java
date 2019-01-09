package com.java.examples.IndepthcoreJava;

import java.util.Calendar;

public class ExampleOfDate {

	public static void main(String[] args) {
		Calendar cal = Calendar.getInstance();
		cal.set(2014, 00, 11);
		Calendar cal2 =(Calendar) cal.clone();
		cal2.set(2015, 07, 02);
		//System.out.println(cal.getTime().toString());
		//System.out.println(cal2.getTime().toString());
		if(cal2.after(cal)){
			System.out.println("yes");
		}
		if(cal.before(cal2)){
			System.out.println("no");
		}
		if(cal2.compareTo(cal) == -1){
			System.out.println(cal2.getTime().toString());
		}else{
			System.out.println(cal.getTime().toString());
		}
	}
}
