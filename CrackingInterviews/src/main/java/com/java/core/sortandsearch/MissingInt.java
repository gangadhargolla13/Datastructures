package com.java.core.sortandsearch;

import java.util.Arrays;

public class MissingInt {

	public static final long ONE_GB = 8000000000L; // 8 billion bits

	/* Can't test this function since needs 1 GB of memory */
	public static void findNumber(int[] input) {
		MyBitSet bitset = new MyBitSet(ONE_GB); // My implementation of BitSet
												// has constructor that takes a
												// long (java.util.BitSet
												// doesn't)
		
		/* Initialize bitfield to represent numbers we already have */
		for (int num : input) {
			bitset.set(num);
		}

		/* Find first bit that is 0 and print corresponding number */
		for (int i = 0; i < bitset.size(); i++) {
			boolean bit = bitset.get(i);
			if (!bit) {
				System.out.println("(Solution 1) First missing number = " + i);
				break;
			}
		}
	}

	/*********************/
	/***** Follow-up *****/
	/*********************/

	// - 1 billion numbers is less than 2^30. - We have 10 MB. 1 MB is 2^20
	// Bytes. So 10 MB is between 2^23 and 2^24 BYTES, which is between 2^26 and
	// 2^27 BITS. (I solve it with less than 2^19 bits)0
	public static void findNumber2(int[] input) {
		int partitionSize = (int) Math.pow(2, 18);
		int numBlocks = (int) Math.pow(2, 12);
		MyBitSet bitset = new MyBitSet(partitionSize); // this takes up 2^18 bits
		int[] blocks = new int[numBlocks]; // this takes up 2^12 * (2^5 bits in
											// int) = 2^17 bits


		/* Set up each block to have the count of numbers in that range */
		for (int num : input) {
			blocks[num / partitionSize]++;
		}
		
		/* Find 1st block that's missing a number */
		int lowerBound = -1;
		for (int i = 0; i < numBlocks; i++) {
			if (blocks[i] < partitionSize) {
				lowerBound = i * partitionSize;
				break;
			}
		}

		// The next 2 parts are very similar to part A of this problem.

		/* Do 2nd pass of file of numbers and record them into bitset */
		//scan = new Scanner(new FileReader("src/chapter10/numbers"));
		for (int num : input) {
			if (num >= lowerBound && num < lowerBound + partitionSize) {
				bitset.set(num - lowerBound);
			}
		}

		/* Loop through bitset and print the 1st missing number */
		for (int i = 0; i < bitset.size(); i++) {
			boolean bit = bitset.get(i);
			if (!bit) {
				System.out.println("(Solution 2) First missing number = " + i);
				break;
			}
		}
	}
	
	public static void main(String[] args) {
		System.out.println("*** Test 10.3: Missing Int");
		test(new int[]{22, 25, 0, 1, 2, 3, 4, 5, 6, 7, 8, 200, 201, 202});
		test(new int[]{5, 7, 0, 1, 2});
	}
	
	private static void test(int[] input) {
		System.out.println("\ninput: " + Arrays.toString(input));
		MissingInt.findNumber(input);
		MissingInt.findNumber2(input);
	}
}