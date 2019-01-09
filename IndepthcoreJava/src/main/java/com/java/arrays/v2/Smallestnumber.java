package com.java.arrays.v2;

public class Smallestnumber {

	public static void main(String[] args) {
		int[] a={1, 1, 1, 1};
		int res = 1;
		for (int i = 0; i < a.length && a[i] <= res; i++)
		       res = res + a[i];
		System.out.println(res);
	}
}
