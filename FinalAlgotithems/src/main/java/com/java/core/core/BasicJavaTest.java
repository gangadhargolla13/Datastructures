package com.java.core.core;

import java.util.LinkedList;
import java.util.List;

public class BasicJavaTest 
{
	public  String name ="ganga";
	public static void main(String[] args) 
	{
		//List<Integer> list = new ArrayList<>();
		List<Integer> list = new LinkedList<>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);
		list.add(6);
		System.out.println(list);
		list.remove(1);
		System.out.println(list);
//		BasicJava java = new BasicJavaExtend(20,"India");
//		java.template();
		
		/*BasicJava java1 = new BasicJava(20,"India");
		java1.template();*/
		
		/*DAYS[] d = DAYS.values();
		for(DAYS d1 : d)
		{
			System.out.println(d1.getVal());
		}*/
	}
}
