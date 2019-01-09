package com.java.core.moderate;

import java.util.ArrayList;

public class DivingBoard {
	public static ArrayList<Integer> allLengths(int k, int shorter, int longer) {
		ArrayList<Integer> lengths = new ArrayList<>();
		for (int numShorter = 0; numShorter <= k; numShorter++) {
			int numLonger = k - numShorter;
			int length = numShorter * shorter + numLonger * longer;
			lengths.add(length);
		}
		return lengths;
	}
	public static void main(String[] args) {
		System.out.println("*** Test 16.11: Diving Board");
		test(12, 1, 3);
		test(5, 2, 6);
	}
	
	private static void test(int k, int shortLength, int longLength) {
		System.out.println("\n          k = " + k);
		System.out.println("shortLength = " +  shortLength);
		System.out.println(" longLength = " + longLength);
		ArrayList<Integer> lengths = DivingBoard.allLengths(k, shortLength, longLength);
		System.out.println("Possible lengths: " + lengths);
	}
}
