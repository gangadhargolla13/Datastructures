package com.java.core.sortandsearch;

import java.util.Arrays;

public class PeaksAndValleys {
	public static void sortValleyPeak(int[] array) {
		for (int i = 1; i < array.length; i += 2) {
			if (array[i - 1] < array[i]) {
				swap(array, i - 1, i);
			} 
			if (i + 1 < array.length && array[i + 1] < array[i]) {
				swap(array, i + 1, i);
			}
		}
	}

	private static void swap(int[] array, int left, int right) {
		int temp = array[left];
		array[left] = array[right];
		array[right] = temp;
	}
	
	public static void main(String[] args) {
		System.out.println("*** 10.11: Peaks and Valleys");
		test(new int[]{5, 3, 1, 2, 3});
		test(new int[]{1, 2, 3, 4, 5});
	}
	
	private static void test(int[] array) {
		System.out.println("\nOriginal: " + Arrays.toString(array));
		PeaksAndValleys.sortValleyPeak(array);
		System.out.println("Altered:  " + Arrays.toString(array));

	}
}
