package com.java.core.hard;

public class AddWithoutPlus {
	public static int add(int a, int b) {
		if (b == 0) {
			return a;
		}
		int sum = a ^ b;
		System.out.println("sum ---> "+sum);
		int carry = (a & b) << 1;
		System.out.println("carry ---> "+carry);
		return add(sum, carry);
	}
	public static void main(String[] args) {
		System.out.println("*** Test 17.1: Add Without Plus\n");
		//test(17, 34);
		test(-17, 34);
	}
	private static void test(int a, int b) {
		System.out.format("%3d + %3d = %3d\n", a, b, AddWithoutPlus.add(a, b));
	}
}
