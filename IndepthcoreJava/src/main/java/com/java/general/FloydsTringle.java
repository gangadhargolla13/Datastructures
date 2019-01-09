package com.java.general;

import java.util.Scanner;

public class FloydsTringle {

	public static void main(String[] args) {
		int n,num=1,c,d;
	    Scanner sc = new Scanner(System.in);
	    System.out.println("Please enter input values:");
	    n=sc.nextInt();
	    ganga:
	    for(c=1; c<=n;c++)
	    {
	    	for(d=1;d<=c;d++)
	    	{
	    		if(num> n)
	    		{
	    			break ganga;
	    		}
	    		System.out.print(num+" ");
	    		num++;
	    	}
	    	System.out.println();
	    }
	    sc.close();
	}
}
