package com.java.core.FinalAlgotithems;

import java.util.Arrays;

public class PrintPairs {

	public static void printPairs(int[] a,int k)
	{
		if(a.length<2)
		{
			return;
		}
		Arrays.sort(a);
		int l =0, r=a.length-1;
		while(l<r)
		{
			int s = a[l]+a[r];
			if(s==k)
			{
				System.out.printf("(%d, %d) %n",a[l],a[r]);
				l = l+1;
				r= r-1;
			}else if(s<k)
				l=l+1;
			else if(s>k){
				r=r-1;
			}
		}
	}
	
	public static void main(String[] args) {
		printPairs(new int[] {12, 14, 17, 15, 19, 20, -11}, 9);
	}
}
