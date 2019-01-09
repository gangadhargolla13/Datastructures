package com.java.core.linkedlist;

public class ReturnKthToLast {
	public static Node kthLast(Node n, int k) {
		int size = ListFunctions.calculateSize(n);
		if (k <= 0 || k > size) {
			return null;
		}
		for (int i = 0; i < size - k; i++) {
			n = n.next;
		}
		return n;
	}
	public static void main(String[] args) {
		System.out.println("*** Test 2.2: Return Kth to Last\n");
		System.out.println("we count starting from 1 (not 0), so last element is element #1\n");
		test(new Node(new int[] { 5, 6, 4, 9 }), 3);
		test(new Node(new int[] { 6, 2, 1, 4 }), 5);
	}

	private static void test(Node head, int k) {
		ListFunctions.printList(head);
		Node m = ReturnKthToLast.kthLast(head, k);
		if (m != null) {
			System.out.format("Element %d from end = %d%n%n", k, m.data);
		} else {
			System.out.format("k = %d is outside of range%n", k);
		}
	}
}
