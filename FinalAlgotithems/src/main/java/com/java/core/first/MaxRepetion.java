package com.java.core.first;

import java.util.Arrays;

public class MaxRepetion {

	public static void repetetion(int[] a)
	{
		int s = a.length;
		int maxc= 0;
		int maxi = 0;
		for(int i=0;i<s;i++)
		{
			int in = a[i]%s;
			a[in]=a[in]+s;
		}
		System.out.println(Arrays.toString(a));
		for(int i=0;i<s;i++)
		{
			if(a[i]/s>maxc)
			{
				maxc=a[i]/s;
				maxi=i;
			}
		}
		System.out.println(maxi+" "+maxc);
	}
	
	public static void main(String[] args) {
		int [] arrA = {4, 1, 5, 2, 1, 5, 9, 8, 6, 5, 3, 2, 4, 7};
		repetetion(arrA);
	}
}
