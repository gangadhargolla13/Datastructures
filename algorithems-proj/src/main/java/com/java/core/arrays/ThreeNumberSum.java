package com.java.core.arrays;

import java.util.HashSet;

import sun.applet.Main;

public class ThreeNumberSum {

	public static void findSum(int[] a,int k){
		for(int i=0;i<a.length;i++)
		{
			int m= k-a[i];
			int start = i+1;
			int end = a.length-1;
			HashSet<Integer> set = new HashSet<>();
			for(int j=start; j<=end;j++){
				int x= a[j];
				int rem = m-x;
				if(rem>0 && set.contains(rem)){
					System.out.println("The values "+a[i]+","+x+","+rem);
					return;
				}
				set.add(x);
			}
		}
	}
public static void main(String[] args) {
	int a [] = { 3,1,7,7,5,9,10};
    int k = 22;
    findSum(a,k);
}	
}
