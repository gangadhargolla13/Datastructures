package com.java.core.moderate;

public class NumberMax {

	private static int flip(int bit) {
		return 1 ^ bit;
	}
	
	/* Returns 0 if a is negative, 1 if positive */
	public static int sign(int a) {
		return flip(a >>> 31); // >>> is unsigned right shift
	}
	
	/* Overflow of "a-b" will cause incorrect results */
	public static int max(int a, int b) {
		int k = sign(a - b);
		return k*a + flip(k)*b; // cool trick
	}

	/* This version solves overflow problem. From website solutions */
    public static int max2(int a, int b) {
        int difSigns = sign(a) ^ sign(b);
        int k = difSigns * sign(a) + flip(difSigns) * sign(a-b); // if a,b have different signs, we simply set k = sign(a)
        return k*a + flip(k)*b; 
    }
	public static void main(String[] args) {
		System.out.println("*** Test 16.7: Number Max\n");
		System.out.print("0 means negative, 1 means positive");
		
		testSign(-61);
		testSign(-252);
		testSign(61);
		testSign(252);
		System.out.println();
		
		testMax(-3, -5);
		testMax(0, 8);
		testMax(-3, 5);		
	}
	
	private static void testSign(int n) {
		System.out.format("\n%4d (Sign): %d", n, NumberMax.sign(n));
	}
	
	private static void testMax(int a, int b) {
		System.out.format("\nmax(%2d, %2d): %2d", a, b, NumberMax.max(a,  b));
	}
}
