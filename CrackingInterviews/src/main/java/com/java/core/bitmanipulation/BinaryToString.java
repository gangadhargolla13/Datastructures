package com.java.core.bitmanipulation;

import java.util.ArrayList;

public class BinaryToString {
	/* Solution 1 - Uses the "multiply by 2" method I learned in CS 357: A well-known algo to turn decimal fractions into binary fractions */
	public static String printBinary(double num) {
		
		ArrayList<String> list = new ArrayList<>();
for(String na:list)
{
	if(na.contains(""))
	{
		list.
	}
}
		
		
		if (num >= 1 || num <= 0) {
			return "ERROR";
		}
		
		StringBuffer binary = new StringBuffer();
		binary.append(".");
		
		while (num > 0) {
			num *= 2;
			if (num >= 1) {
				binary.append(1); // automatically converts the int to a String
				num = num - 1;
			} else {
				binary.append(0);
			}
			if (binary.length() > 32) {
				return "ERROR";
			}
		}
		
		return binary.toString();
	}
	
	/* Solution 2 - Uses the method I usually use to do it in my head */
	public static String printBinary2(double num) {
		if (num >= 1 || num <= 0) {
			return "ERROR";
		}
		
		StringBuffer binary = new StringBuffer();
		binary.append(".");
		
		double frac = 0.5;
		while (num > 0) {
			if (binary.length() > 32) {
				return "ERROR";
			}
			if (num > frac) {
				binary.append(1);
				num = num - frac;
			} else {
				binary.append(0);
			}
			frac /= 2;
		}
		
		return binary.toString();
	}
	
	public static void main(String[] args) {
		System.out.println("*** Test 5.2: Binary to String\n");
		test(0.625);
		test(0.3);
	}
	
	private static void test(double decimal) {
		System.out.println("Decimal: " + decimal + "   Binary: " + BinaryToString.printBinary(decimal));
	}
}
