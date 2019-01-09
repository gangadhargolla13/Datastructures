package com.java.core.linkedlist;

public class DeleteMiddleNode {
	public static void main(String[] args) {
		System.out.println("*** Test 2.3: Delete Middle Node");
		test(new Node(new int[]{6,7,8,9}));
		test(new Node(new int[]{6,7,8,9,10,4,3}));
	}
	
	private static void test(Node head) {
		System.out.println();
		ListFunctions.printList(head);
		DeleteMiddleNode.deleteMid(head.next.next);
		ListFunctions.printList(head);
	}
	public static boolean deleteMid(Node n) {
		if (n == null || n.next == null) { 
			return false;			       
		}
		n.data = n.next.data;
		n.next = n.next.next;
		return true;
	}
}
