package com.java.forloop;

public class RecursiveExample {

	public static void main(String[] args) {
         for(int i=1;i<=10;i++)
         {
        	 System.out.println(values(i));
         }
	}
	
	public static int values(int num)
	{
		if(num == 1 || num == 2)
		{
			return 	1;
		}
		return values(num-1)+values(num-2);
	}
}
