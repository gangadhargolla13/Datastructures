package com.java.core.sortandsearch;

import java.util.Arrays;

public class BinarySearch {
	public static Integer Iterative(int[] sortedArray, int value) {
		int start = 0;
		int end = sortedArray.length - 1;

		while (start <= end) {
			int mid = (start + end) / 2;
			if (sortedArray[mid] > value) {
				end = mid - 1;
			} else if (sortedArray[mid] < value) {
				start = mid + 1;
			} else {
				return mid;
			}
		}
		return null;
	}
	
	/*****************************/
	/* Binary Search - Recursive */
	/*****************************/
	public static Integer Recursive(int[] sortedArray, int value) {
		return RecursiveHelper(sortedArray, value, 0, sortedArray.length - 1);
	}
	
	/* Since this is tail-recursive, the compiler will optimize it to iterative code */
	private static Integer RecursiveHelper(int[] array, int value, int start, int end) {
		if (start > end) {
			return null;
		}
		int mid = (start + end) / 2; // to avoid integer overflow, can say: mid = start + ((end - start) / 2)
		if (array[mid] > value) {
			return RecursiveHelper(array, value, start, mid - 1);
		} else if (array[mid] < value) {
			return RecursiveHelper(array, value, mid + 1, end);
		} else {
			return mid;	// Returns index
		}
	}
	
	public static void main(String[] args) {
		System.out.println("*** Test Binary Search");
		test(new int[]{-3, -1, 0, 2, 9, 22, 23, 25, 53}, -1);
		test(new int[]{-5, -4, 0, 1, 2}, 2);
		
	}
	
	private static void test(int[] sortedArray, int value) {
		System.out.println("\nOriginal array: " + Arrays.toString(sortedArray));
		System.out.println(value + " is at index " + BinarySearch.Iterative(sortedArray, value));
		System.out.println(value + " is at index " + BinarySearch.Recursive(sortedArray, value));
	}
}
