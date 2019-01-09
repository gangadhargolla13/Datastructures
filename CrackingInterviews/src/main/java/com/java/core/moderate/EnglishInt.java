package com.java.core.moderate;

public class EnglishInt {
	public static String[] digits = {"Zero", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};
	public static String[] teens  = {"Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
	public static String[] tens   = {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
	public static String[] bigs   = {"", "Thousand", "Million", "Billion"};
		
	public static String numToString(int num) {
		if (num < 0) {
			return "Negative " + numToString(-1 * num);
		} else if (num == 0) {
			return "Zero";
		}
		
		int bigsIndex = 0;
		StringBuffer sb = new StringBuffer();

		/* We create the string from right to left, inserting in the front. This makes code clean and scalability easier */
		while(num > 0) {
			if (num % 1000 != 0) {
				sb.insert(0, numToString100(num % 1000) + bigs[bigsIndex] + " ");
			}
			num /= 1000;
			bigsIndex++;
		}
		return sb.toString();
	}
	
	public static String numToString100(int num) {
		if (num < 0) {
			return "Negative " + numToString(-1 * num);
		} else if (num == 0) {
			return "Zero";
		} else if (num > 999) {
			return null;
		}
		
		StringBuffer sb = new StringBuffer();
		
		/* Hundreds */
		if (num >= 100) {
			int digit = num / 100;
			sb.append(digits[digit] + " Hundred ");
			num = num % 100; // now we have a 2-digit number
		}
		
		/* Tens */
		int tensDigit   = num / 10;
		int singleDigit = num % 10;
		
		if (num >= 10 && num <= 19) {
			sb.append(teens[singleDigit] + " ");
			return sb.toString();
		} else if (num >= 20) {
			sb.append(tens[tensDigit] + " ");
		}
		
		/* Single Digit */
		if (singleDigit != 0) {
			sb.append(digits[singleDigit] + " ");
		}
		
		return sb.toString();
	}
	public static void main(String[] args) {
		System.out.println("*** Test 16.8: English Int");
		for (int i = 0; i < 23; i++) {
			test(i);
		}
		test(1000);
		test(2998);
		test(253513);
		test(10090034);
	}
	
	private static void test(int n) {
		System.out.format("\n%d: %s", n, EnglishInt.numToString(n));
	}
}
