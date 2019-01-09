package com.java.core.moderate;

public class FactorialZeros {

	public static int numTrailingZeros(int n) {
		if (n < 1) {
			return 0;
		}
		int fives = 0;
		for (int i = 5; i <= n; i *= 5) { // i is 5, 25, 125, 625 ...
			fives += n/i; // to count how many multiples of "i" are in range 1...n, we just do n/i
		}
		return fives;
	}
	
	public static void main(String[] args) {
		System.out.println("*** Test 16.5: Factorial Zeros");
		test(8);
		test(9);
		test(10);
		test(20);
	}
	
	private static void test(int n) {
		System.out.format("\n%2d! = %20d   # Trailing 0s = %d", n, calculateFactorial(n), FactorialZeros.numTrailingZeros(n));
	}
	
	private static long calculateFactorial(long num) {
		if (num > 20) {
			return -1; // since result may cause overflow
		}
		long result = 1;
		while (num > 1) {
			result *= num;
			num--;
		}
		return result;
	}
}
