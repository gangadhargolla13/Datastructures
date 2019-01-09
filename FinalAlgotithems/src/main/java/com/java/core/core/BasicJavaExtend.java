package com.java.core.core;

public class BasicJavaExtend extends BasicJava{

	public BasicJavaExtend(int val,String name)
	{
		super(val,name);
	}
	
	/*public void bye()
	{
		System.out.println("I am gangadhar.");
	}*/
	public synchronized void bye(int val)
	{
		System.out.println("I am mallikarjuna.");
	}
}
