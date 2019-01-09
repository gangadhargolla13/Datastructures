package com.java.core.moderate;

import java.util.Arrays;

public class ContiguousSequence {
	public static int maxSum(int[] array) {
		int runningSum = 0;
		int maxSum = 0;
		for (int i = 0; i < array.length; i++) {
			runningSum += array[i];
			if (runningSum < 0) {
				runningSum = 0;
			}
			maxSum = Math.max(maxSum, runningSum);
		}
		return maxSum;
	}
	public static void main(String[] args) {
		System.out.println("*** Test 16.18: Contiguous Sequence");
		test(new int[]{2, -8, 3, -2, 4, -10});
		test(new int[]{-6, -8, -3, -2, -4, -10});
	}
	
	private static void test(int[] array) {
		System.out.println("\nOriginal array: " + Arrays.toString(array));
		System.out.println("Max Subsequence = " + ContiguousSequence.maxSum(array));		
	}
}
