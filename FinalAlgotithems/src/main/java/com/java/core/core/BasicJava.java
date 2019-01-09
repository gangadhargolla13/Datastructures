package com.java.core.core;

import java.io.File;
import java.io.IOException;

public class BasicJava {

	public final int val;
	public final String name;
	
	public void wish()
	{
		System.out.println("I am wishing ganesh! "+val);
	}
	
	public void congrats()
	{
		System.out.println("Please say congrats to him! "+name);
	}
	
	public void bye()
	{
		System.out.println("Say bye to him!");
	}
	
	/*public void bye(int val)
	{
		System.out.println("I am gangadhar.");
	}*/
	public void template()
	{
		wish();
		congrats();
		bye();
	}
	
	public BasicJava(int val,String name)
	{
		this.val=val;
		this.name=name;
	}
	
	public void testing() throws IOException
	{
		File f = new File("/c/ganga.txt");
		System.out.println("I am gangadhar");
	}
	
	public void test1() throws NullPointerException
	{
		System.out.println("I am master of india!");
	}
	public void test()
	{
		try
		{
		testing();
		}catch(Throwable t)
		{
			
		}
		
		test1();
	}
}
