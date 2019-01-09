package com.java.core.moderate;

import java.util.Arrays;
import java.util.HashSet;

public class SumSwap {

	public static void toSwap(int[] arrayA, int[] arrayB) {
		int sum1 = Arrays.stream(arrayA).reduce(0, Integer::sum);
		int sum2 = Arrays.stream(arrayB).reduce(0, Integer::sum);
		if ((sum2 - sum1) % 2 != 0) {
			System.out.println("wont work");
			return;
		}
		int difference = (sum2 - sum1) / 2;
		HashSet<Integer> set = buildSet(arrayB);
		for (int numA : arrayA) {
			int neededNumB = numA + difference;
			if (set.contains(neededNumB)) {
				System.out.println("swap value " + numA + " from A\nwith value " + neededNumB + " from B");
				return;
			}
		}
		System.out.println("no solution");
	}
	
	private static HashSet<Integer> buildSet(int[] array) {
		HashSet<Integer> set = new HashSet<>();
		for (int num : array) {
			set.add(num);
		}
		return set;
	}
	
	public static void main(String[] args) {
		System.out.println("*** Test 16.21: Sum Swap\n");
		test(new int[]{4, 1, 2, 1, 1, 2}, new int[]{3, 6, 3, 3});
	}
	
	private static void test(int[] arrayA, int[] arrayB) {
		System.out.println("arrayA: " + Arrays.toString(arrayA));
		System.out.println("arrayB: " + Arrays.toString(arrayB));
		SumSwap.toSwap(arrayA, arrayB);
	}
}
