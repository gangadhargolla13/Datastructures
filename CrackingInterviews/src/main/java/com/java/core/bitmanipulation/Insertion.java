package com.java.core.bitmanipulation;

public class Insertion {
	public static int insert_M_into_N(int N, int M, int i, int j) {
		/* Clear bits i to j in N */
		for (int index = i; index <= j; index++) {
			N = BitFunctions.clearBit(N, index);
		}
		
		M <<= i;      // shift M so that it lines up with bits i through j
		return M | N; // merge M and N
	}
	public static void main(String[] args) {
		System.out.println("*** Test 5.1: Insertion\n");
		int result = Insertion.insert_M_into_N(0b10000000000, 0b10011, 2, 6);
		System.out.println(Integer.toBinaryString(result));		
	}
}
