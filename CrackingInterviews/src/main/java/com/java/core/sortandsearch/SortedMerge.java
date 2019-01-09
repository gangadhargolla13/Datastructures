package com.java.core.sortandsearch;

import java.util.Arrays;

public class SortedMerge {
	public static void merge(int[] a, int[] b, int lastA, int lastB) { // lastA is index of last element in array. Same with lastB
		int curr = lastA + lastB + 1;
		while (lastA >= 0 && lastB >= 0) {
			if (a[lastA] > b[lastB]) {
				a[curr--] = a[lastA--];
			} else {
				a[curr--] = b[lastB--];
			}
		}

		// Copy Remaining Elements. No need to copy lastA elements since they're already in correct spot
		while (lastB >= 0) {
			a[curr--] = b[lastB--];
		}
	}
	public static void main(String[] args) {
		System.out.println("*** 10.1: Sorted Merge");
		test(new int[]{3, 6, 8, 9, 0, 0, 0, 0}, new int[]{1, 2, 4, 7}, 3, 3);
	}
	
	private static void test(int[] arrayA, int[] arrayB, int lastA, int lastB) {
		System.out.println("Original arrays: " + Arrays.toString(arrayA) + " " + Arrays.toString(arrayB));
		SortedMerge.merge(arrayA, arrayB, lastA, lastB);
		System.out.println("Merged: " + Arrays.toString(arrayA));
	}
}
