package com.java.core.stackandqueue;

import java.util.ArrayList;
import java.util.Stack;
public class StackOfPlates {
	private ArrayList<Stack<Integer>> stacks = new ArrayList<>();
	private int capacity = 3;
	
	/* Implemented to work like a standard push */
	public void push (int data) {
		Stack<Integer> lastStack = getLastStack();
		if (lastStack != null && lastStack.size() < capacity) {
			lastStack.push(data);
		} else {
			Stack<Integer> anotherStack = new Stack<>(); // crucial step. Stacks aren't magically created 4 u.
			anotherStack.push(data);
			stacks.add(anotherStack);
		}
	}
	
	/* Implemented to work like a standard pop */
	public Integer pop() {
		Stack<Integer> lastStack = getLastStack();
		if (lastStack == null) {
			return null;
		} else {
			Integer result = lastStack.pop();
			if (lastStack.isEmpty()) {
				stacks.remove(stacks.size() - 1);
			}
			return result;
		}
	}
	
	/* Helper function */
	public Stack<Integer> getLastStack() {
		if (stacks.isEmpty()) {
			return null;
		} else {
			return stacks.get(stacks.size() - 1);
		}
	}
	public static void main(String[] args) {
		System.out.println("*** Test 3.3: Stack of Plates\n");
		StackOfPlates stack = new StackOfPlates();
		for (int i = 1; i <= 5; i++) {
			System.out.println("Pushed " + i);
			stack.push(i);
		}
		for (int i = 1; i <= 5; i++) {
			System.out.println("Popped " + stack.pop());
		}
	}
}