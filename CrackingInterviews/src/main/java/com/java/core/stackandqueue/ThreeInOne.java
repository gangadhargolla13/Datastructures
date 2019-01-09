package com.java.core.stackandqueue;

public class ThreeInOne {
	private final int numStacks = 3;
	private final int stackSize = 100;
	private int[] array = new int[stackSize * numStacks];
	private int[] heads = { -1, -1, -1 };

	public void push(int value, int stackNum) throws Exception {
		if (stackNum < 0 || stackNum >= numStacks) {
			throw new Exception("stackNum out of range");
		}
		if (heads[stackNum] >= stackSize) {
			throw new Exception("Out of space");
		}
		heads[stackNum]++;
		int offset = arrayOffset(stackNum) + heads[stackNum];
		array[offset] = value;
	}

	public int pop(int stackNum) throws Exception {
		if (heads[stackNum] == -1) {
			throw new Exception("No elements to pop");
		}
		int offset = arrayOffset(stackNum) + heads[stackNum];
		heads[stackNum]--;
		return array[offset];
	}

	public int peek(int stackNum) throws Exception {
		if (heads[stackNum] == -1) {
			throw new Exception("No elements to pop");
		}
		int offset = arrayOffset(stackNum) + heads[stackNum];
		return array[offset];
	}

	public boolean isEmpty(int stackNum) {
		return (heads[stackNum] == -1);
	}

	private int arrayOffset(int stackNum) {
		return stackSize * stackNum;
	}

	/* Added for testing */
	public void print() {
		for (int stackNum = 0; stackNum <= 2; stackNum++) {
			System.out.print("\nStack #" + stackNum + ": ");
			for (int i = arrayOffset(stackNum); i <= arrayOffset(stackNum) + heads[stackNum]; i++) {
				System.out.print(array[i] + " ");
			}
		}
	}
	public static void main(String[] args) {
		System.out.print("*** Test 3.1: Three in One\n");
		ThreeInOne stacks = new ThreeInOne();
		try {
			stacks.push(1, 0);
			stacks.push(2, 0);
			stacks.push(3, 0);
			stacks.push(4, 1);
			stacks.push(5, 1);
			stacks.push(6, 1);
			stacks.push(7, 2);
			stacks.push(8, 2);
			stacks.push(9, 2);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		stacks.print();
	}

}
