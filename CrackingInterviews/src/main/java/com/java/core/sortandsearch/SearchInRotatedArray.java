package com.java.core.sortandsearch;

import java.util.Arrays;

public class SearchInRotatedArray {
	public static Integer search(int[] rotatedArray, int x) {
		return search(rotatedArray, x, 0, rotatedArray.length - 1);
	}
	
	public static Integer search(int[] rotatedArray, int x, int start, int end) {
		if (start > end) {
			return null;
		}
		int midIndex   = (start + end) / 2;
		int midValue   = rotatedArray[midIndex];
		
		int leftValue  = rotatedArray[start];
		int rightValue = rotatedArray[end];
		
		if (midValue == x) {
			return midIndex;
		} else if (leftValue < midValue) { // in this case, left CANNOT have inflection point, thus is ordered correctly
			if (leftValue <= x && x < midValue) {
				return search(rotatedArray, x, start, midIndex - 1);
			} else {
				return search(rotatedArray, x, midIndex + 1, end);
			}
		} else if (leftValue > midValue) { // in this case, left MUST have inflection point, and thus is not ordered correctly
			if (midValue < x && x <= rightValue) {
				return search(rotatedArray, x, midIndex + 1, end);
			} else {
				return search(rotatedArray, x, start, midIndex - 1);
			}
		} else { // leftValue == midValue
			if (midValue == rightValue) { // leftValue == midValue == rightValue, so we must search both halves of array since either half could have inflection point
				Integer result = search(rotatedArray, x, start, midIndex - 1);
				if (result == null) {
					result = search(rotatedArray, x, midIndex + 1, end);
				}
				return result;
			} else { // in this case, inflection point is on right side of array
				return search(rotatedArray, x, midIndex + 1, end);
			}
		}
	}
	
	public static void main(String[] args) {
		System.out.println("*** 10.3: Search in Rotated Array");
		int[] rotatedArray = {15, 16, 19, 20, 25, 1, 3, 4, 5, 7, 10, 14};
		System.out.println("Rotated Array: " + Arrays.toString(rotatedArray));
		for (int num : rotatedArray) {
			test(rotatedArray, num);
		}
	}
	
	private static void test(int[] rotatedArray, int num) {
		System.out.format("%n%2d is at index: %2d", num, SearchInRotatedArray.search(rotatedArray, num));
	}
}
