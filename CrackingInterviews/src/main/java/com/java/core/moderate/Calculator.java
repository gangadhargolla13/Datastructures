package com.java.core.moderate;

import java.util.ArrayList;

public class Calculator {
	public static double evaluate(String str) {
		ArrayList<String> tokens = new ArrayList<>();

		/* Do multiplications and divisions first */
		for (int i = 0; i < str.length(); i++) {
			char op = str.charAt(i);
			if (op == '*' || op == '/') {
				int left  = Integer.valueOf(tokens.get(tokens.size() - 1));
				int right = Character.getNumericValue(str.charAt(i+1));
				String result;
				if (op == '*') {
					result = String.valueOf(left * right);
				} else {
					result = String.valueOf(left / right);
				}
				tokens.set(tokens.size() - 1, result);
				i++;
			} else {
				tokens.add(String.valueOf(op));
			}
		}

		/* Do additions and subtractions */
		double result = Double.valueOf(tokens.get(0));
		for (int i = 1; i < tokens.size(); i += 2) {
			String op = tokens.get(i);
			double left = result;
			int right   = Integer.valueOf(tokens.get(i+1));
			if (op.equals("-")) {
				result = left - right;
			} else {
				result = left + right;
			}
		}
		
		return result;
	}
	public static void main(String[] args) {
		System.out.println("*** Test 16.26: Calculator\n");
		test("2-6-7*8/2+5");
	}
	
	private static void test(String expression) {
		System.out.println(expression + " = " + Calculator.evaluate(expression));	
	}	
}
