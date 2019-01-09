package com.java.core.sortandsearch;

import java.util.BitSet;

public class FindDuplicates {
	public static void checkDuplicates(int[] array) {
		BitSet bitset = new BitSet(32000);
		for (int i = 0; i < array.length; i++) {
			int num = array[i];
			if (bitset.get(num)) {
				System.out.print(num + " ");
			} else {
				bitset.set(num);
			}
		}
	}
	
	public static void main(String[] args) {
		System.out.println("*** Test 10.4: Find Duplicates");
		FindDuplicates.checkDuplicates(new int[]{3,4,4,4,1,6,1});
	}
}
