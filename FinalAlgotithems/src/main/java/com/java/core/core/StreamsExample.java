package com.java.core.core;

import java.util.ArrayList;
import java.util.List;

public class StreamsExample 
{

	
	public static void main(String[] args) {
		Checkable f = (i,name) -> System.out.println(i +" "+name);
		f.testing(14,"ganga");
		
		List<String> list = new ArrayList<>();
		list.add("India");
		list.add("China");
		list.add("USA");
		list.add("Russia");
		list.add("Singapore");
		list.forEach( s -> System.out.println(s.toUpperCase()));
	}
	
	public static int testing()
	{
		System.out.println("I am master");
		return 3;
	}
	
	interface Checkable
	{
		public void testing(int ro,String name);
	}
}
