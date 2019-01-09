package com.java.core.moderate;

public class NumberSwapper {

	public static void swap1(int a,int b){
		a= a-b;
		b= a+b;
		a=b-a;
		System.out.println("Swapped (Solution 1): a = " + a + "  b = " + b);
	}
	
	public static void swap2(int a,int b){
		a = a^ b;
		b= a^ b;
		a= a^b;
		System.out.println("Swapped (Solution 2): a = " + a + "  b = " + b);
	}
	
	public static void main(String[] args) {
		test(2, 4);
		test(3,5);
	}
	
	private static void test(int a, int b) {
		System.out.println("\nOriginal: a = " + a + "  b = " + b);
		NumberSwapper.swap1(a, b);
		NumberSwapper.swap2(a, b);
	}
}
