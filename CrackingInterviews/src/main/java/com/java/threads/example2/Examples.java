package com.java.threads.example2;

import java.util.ArrayList;
import java.util.List;

public class Examples {
	static String str="hi";
	static List<String> list = new ArrayList<>();
	protected int x,y;
	public static void main(String[] args) {
		int x=10;
		int m= x/0;
		call(str,list);
		System.out.println(str.hashCode());
		Examples ex = new Examples();
		System.out.println(ex.x+" "+ex.y);
	}
	
	public static void call(String s,List<String> al)
	{
		s="hello";
		al.add("i am ok");
		System.out.println(str+" "+al.size());
		System.out.println(s.hashCode());
	}
}
