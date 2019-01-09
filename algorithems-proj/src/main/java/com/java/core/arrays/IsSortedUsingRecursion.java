package com.java.core.arrays;

public class IsSortedUsingRecursion {
	public static boolean isShort(int[] a, int start) {
		if (start == a.length-1) {
			return true;
		}
		if (a[start] <= a[start + 1]) {
			return isShort(a, start + 1);
		} else {
			return false;
		}

	}
	
	public static void main(String[] args) {
		boolean d = isShort(new int[]{1,2,3,4,8,8,22,50},0);
		System.out.println(d);
	}
}
