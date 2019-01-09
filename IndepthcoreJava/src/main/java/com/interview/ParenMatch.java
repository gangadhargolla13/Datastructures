package com.interview;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ParenMatch {

	public static void main(String[] args) {
		System.out.println(parensMatch("(a[0] + b[2c[6]]) {24+53}"));
		assert parensMatch("(a[0] + b[2c[6]]) {24+53}");
		assert parensMatch("{[2}+3}");

	}

	public static boolean parensMatch(String parenString) {
		char[] str1 = parenString.toCharArray();
		Map<Character,Character> map = new HashMap<Character,Character>();
		map.put('[', ']');
		map.put('{', '}');
		map.put('(', ')');
		Stack<Character> stack = new Stack<>();
		for (char c : str1) {
			if ('[' == c || '{' == c || '(' == c) {
				stack.push(c);
			} 
			else if (']' == c || '}' == c || ')' == c) {
				char f = map.get(stack.peek());
				System.out.println(f);
				System.out.println(c);
				if (f == c) {
					stack.pop();
				}
				else {
					System.out.println(c);
					return false;
				}
			}
			if(stack.isEmpty())
				return false;
		}
		return true;
	}
}