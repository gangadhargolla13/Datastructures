package com.java.core.linkedlist;

import java.util.ArrayDeque;

public class Palindrome {
	public static void main(String[] args) {
		System.out.println("*** Test 2.6: Palindrome\n");
		test(new Node(new int[] { 1, 2, 3, 4 }));
		test(new Node(new int[] { 1, 2, 3, 4, 3, 2, 1 }));
		test(new Node(new int[] { 1, 2, 2, 1 }));
		test(new Node(new int[] { 1, 2, 2, 1, 8, 2, 1 }));
	}

	private static void test(Node head) {
		ListFunctions.printList(head);
		System.out.println("Palindrome? " + Palindrome.palindrome(head) + "\n");
	}
	
	public static boolean palindrome(Node head) {
		int size = ListFunctions.calculateSize(head);
		ArrayDeque<Integer> deque = new ArrayDeque<>();
		Node curr = head;
		/* Save 1st half of list */
		for (int i = 0; i < size / 2; i++) {
			deque.push(curr.data);
			curr = curr.next;
		}
		/* If list had odd number of elements -> skip middle element */
		if (size % 2 == 1) {
			curr = curr.next;
		}
		/* Compare 2nd half of list to 1st half of list */
		while (curr != null) {
			if (deque.pop() != curr.data) {
				return false;
			}
			curr = curr.next;
		}
		return true;
	}
}
