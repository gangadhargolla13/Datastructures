package com.java.core.moderate;

import java.util.Arrays;

public class SmallestDifference {

	public static int smallestDifference(int[] array1, int[] array2) {
		Arrays.sort(array1);
		Arrays.sort(array2);
		int minDifference = Integer.MAX_VALUE;
		int i = 0;
		int j = 0;
		while (i < array1.length && j < array2.length) {
			int difference = Math.abs(array1[i] - array2[j]);
			minDifference = Math.min(minDifference, difference);
			if (array1[i] == array2[j]) {
				return 0;
			}
			if (array1[i] < array2[j]) {
				i++;
			} else {
				j++;
			}
		}
		return minDifference;
	}
	
	public static void main(String[] args) {
		System.out.println("*** Test 16.6: Smallest Difference");
		test(new int[]{1, 3, 15, 11, 2}, new int[]{23, 127, 235, 19, 8});
	}
	
	private static void test(int[] array1, int[] array2) {
		System.out.println("\nArray 1: " + Arrays.toString(array1));
		System.out.println("Array 2: "   + Arrays.toString(array2));
        int difference = SmallestDifference.smallestDifference(array1, array2);
        System.out.println("Smallest difference = " + difference);
	}
}
