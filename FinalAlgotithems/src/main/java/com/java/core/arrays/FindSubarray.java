package com.java.core.arrays;

import java.util.HashMap;

public class FindSubarray {

	public static HashMap<Integer,Integer> map = new HashMap<>();
	public static void main(String[] args) {
		int[] a ={9, 2, -1, -3, 4,-2, 2, 4, 6, 0};
		findSubAray(a);
	}
	public static void findSubAray(int[] a)
	{
		int sum = 0;
		for(int i=0;i<a.length;i++)
		{
			sum +=a[i];
			if(sum==0)
			{
				printArray(a,0,i);
			}
			if(map.get(sum)!=null)
			{
				System.out.println(map);
				printArray(a,map.get(sum)+1,i);
			}else
				map.put(sum, i);
		}
		System.out.println(map);
	}
	
	public static void printArray(int[] a,int s,int end)
	{
		for(int i=s;i<=end;i++)
		{
			System.out.print(a[i]+" ");
		}
		System.out.println();
	}
}
