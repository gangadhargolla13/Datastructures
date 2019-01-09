package com.java.arrays.v2;

public class ReverseArray {

	public static void main(String[] args) {
		int[] a = {1,4,3,8,9,5,7};
		int n = a.length/2;
		System.out.println(n);
		for(int i=0,j=a.length-1;i<n;i++,j--)
		{
			System.out.println("i "+i+" j "+j);
			int tmp = a[i];
			a[i] = a[j];
			a[j] = tmp;
		}
		for(int m : a)
			System.out.println(m);
	}
}
