package com.java.core.general;

import java.util.TreeSet;

public class GenericExample {
	public static Days d= null;
	public static void main(String[] args) {
		TreeSet<Integer> set = new TreeSet<>();
		set.add(5);
		set.add(4);
		set.add(3);
		System.out.println("Always give a meaningful name when ever required");
		d=Days.MONDAY;
		System.out.println(d.daysVal());
		for(int n:set)
		{
			System.out.println(Days.getDays(n).toString());
		}
			
	}
}
