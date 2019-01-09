package com.java.core.stackandqueue;
import java.util.Stack;
public class StackMin {
	/* Can alternatively use ArrayDeque (it's faster) */
	Stack<Integer> stack = new Stack<>();
	Stack<Integer> minStack = new Stack<>(); // keeps track of minimums

	/* Always push onto stack. If it's a minimum, also push it onto minStack */
	void push(int n) {
		stack.push(n);
		if (min() == null || n <= min()) {
			minStack.push(n);
		}
	}

	/*
	 * Pop off stack. If we popped a minimum, we gotta remove it from minStack
	 * also
	 */
	Integer pop() {
		if (stack.isEmpty()) {
			return null;
		}
		Integer n = stack.pop();
		if (n == minStack.peek()) {
			minStack.pop();
		}
		return n;
	}

	/* minStack gives us minimum in O(1) time */
	Integer min() {
		if (minStack.isEmpty()) {
			return null;
		} else {
			return minStack.peek();
		}
	}
	
	public static void main(String[] args) {
		System.out.println("*** Test 3.2: Stack Min\n");
		System.out.println("Building stack: 8 4 6 3 3\n");
		StackMin myStack = new StackMin();
		myStack.push(8);
		System.out.println("(after 1st push) Min = " + myStack.min());
		myStack.push(4);
		System.out.println("(after 2nd push) Min = " + myStack.min());
		myStack.push(6);
		System.out.println("(after 3rd push) Min = " + myStack.min());
		myStack.push(3);
		System.out.println("(after 4th push) Min = " + myStack.min());
		myStack.push(3);
		System.out.println("(after 5th push) Min = " + myStack.min());
		myStack.pop();
		System.out.println("(after 1st pop) Min = " + myStack.min());
		myStack.pop();
		System.out.println("(after 2nd pop) Min = " + myStack.min());
	}
}
