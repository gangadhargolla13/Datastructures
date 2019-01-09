package com.java.core.core;

public class VararguExample {

	public static void main(String[] args) {
		VararguExample v = new VararguExample();
		/*v.print("gangadhar");
		v.printNum(20f);*/
		try{
			System.out.println(v.testing());
			System.out.println("I am ganga");
		}catch(Exception e)
		{
			System.out.println(e.getMessage());
		}finally
		{
			System.out.println("I am gangadhar");
		}
	}
	
	public int  testing()
	{
		try
		{
			//int c = 10/0;
			return 3;
		}catch(ArithmeticException a)
		{
			throw new NullPointerException("I am so problamatic");
		}
		finally{
			System.out.println("I am master");
			//return 4;
		}
		
	}
	public void print(String ganga)
	{
		System.out.println("Direct "+ganga);
	}
	public void print(Object ganga)
	{
		System.out.println("Object "+ganga);
	}
	
	public void print(String... ga)
	{
		System.out.println("Varargue "+ga);
	}
	
	public void printNum(int v)
	{
		System.out.println("Direct "+v);
	}
	
	public void printNum(Number v)
	{
		System.out.println("Number "+v);
	}
	public void printNum(Object v)
	{
		System.out.println("Object "+v);
	}
	public void printNum(float... v)
	{
		System.out.println("Varargue "+v);
	}
	
}
