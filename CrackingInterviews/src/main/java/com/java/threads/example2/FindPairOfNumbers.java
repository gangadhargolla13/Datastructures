package com.java.threads.example2;

import java.util.HashSet;
import java.util.Set;

public class FindPairOfNumbers {

	public static void main(String[] args) {
		int[] a={1,0,0,1};
		int count=0;
		for(int i=0;i<a.length;i++){
			Set<Integer> s1 = new HashSet<>();
			for(int j=0;j<a.length;j++)
			{
				if(i!=j)
				{
				int m = a[i]-a[j];
				if(s1.contains(m))
				{
					count++;
				}else
				{
					s1.add(a[j]);
				}
				}
			}
		}
		System.out.println(count);
	}
}
