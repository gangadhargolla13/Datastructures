package com.java.core.arrays;

public class MaxDifference {

	public static int maxDiff(int[] a){
		int max=-1;
		for(int i=0;i<a.length;i++)
		{
			for(int j=0;j<a.length;j++)
			{
				if(a[j]>a[i]&& max<(a[j]-a[i]))
					max=a[j]-a[i];
			}
		}
		return max;
	}
	
	public static int maxDiff1(int[]a)
	{
		int size = a.length;
		int maxDiff= -1;
		int max = a[size-1];
		for(int i=size-2;i>0;i--)
		{
			if(max<a[i]){
				max=a[i];
			}else if(max>a[i])
			{
				maxDiff = Math.max(maxDiff, max-a[i]);
			}
		}
		return maxDiff;
	}
	
	public static void main(String[] args) {
		 int [] A = { 2, 5, 1, 7, 3, 4, 9, 4, 5};
		int x= maxDiff1(A);
		System.out.println(x);
	}
}
