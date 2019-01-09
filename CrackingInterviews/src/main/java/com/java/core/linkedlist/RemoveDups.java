package com.java.core.linkedlist;

import java.util.HashSet;

public class RemoveDups {
	static void removeDuplicates(Node head) {
		HashSet<Integer> set = new HashSet<>();
		set.add(head.data);
		Node n = head;
		while (n.next != null) {
			if (set.contains(n.next.data)) {
				n.next = n.next.next;
			} else {
				set.add(n.next.data);
				n = n.next;
			}
		}
		return;
	}
	
	public static void main(String[] args) {
		System.out.println("*** Test 2.1: Remove Dups\n");
		test(new Node(new int[]{9,9,9,9}));
		test(new Node(new int[]{5,7,7,3,7,6,7,5}));
	}
	
	private static void test(Node head) {
		try
		{
			ListFunctions.printList(head);
			RemoveDups.removeDuplicates(head);
			ListFunctions.printList(head);
			System.out.println();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}