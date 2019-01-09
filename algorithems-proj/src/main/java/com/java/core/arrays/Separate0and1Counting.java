package com.java.core.arrays;

import java.util.Arrays;

public class Separate0and1Counting {

	public static int[] seperate(int[] a){
		int count =0;
		for(int d:a){
			if(d==0)
				count++;
		}
System.out.println(count);
		for(int i=0;i<a.length;i++)
		{
			if(count>0)
			{
				a[i]=0;
				count--;
			}
			else
				a[i]=1;
		}
		return a;
	}
	
	public static void main(String[] args) {
		int [] arrA = {1,0,1,0,1,1,0,0,0,0,1};
        System.out.println("Rearranging arrays using counting..");
        arrA = seperate(arrA);
        System.out.println(Arrays.toString(arrA));
	}
}
