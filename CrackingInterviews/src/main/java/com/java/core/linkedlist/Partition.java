package com.java.core.linkedlist;

public class Partition {

	public static Node partition(Node head, int x) {
		Node curr = head;
		Node p = head;
		while (curr != null) {
			if (curr.data < x) {
				/* Swap DATA values */
				int temp = p.data;
				p.data = curr.data;
				curr.data = temp;

				p = p.next;
			}
			curr = curr.next;
		}
		return head;
	}

	/* Solution 2 */
	public static Node partition2(Node n, int x) {
		Node head1 = null;
		Node head2 = null;
		Node tail1 = null; // to walk list1
		Node tail2 = null; // to walk list2

		while (n != null) {
			if (n.data < x) {
				if (head1 == null) {
					head1 = n;
					tail1 = n;
				} else {
					tail1.next = n;
					tail1 = n;
				}
			} else {
				if (head2 == null) {
					head2 = n;
					tail2 = n;
				} else {
					tail2.next = n;
					tail2 = n;
				}
			}
			n = n.next;
		}

		if (tail2 != null) {
			tail2.next = null;
		}

		if (head1 == null) {
			return head2;
		} else {
			tail1.next = head2;
			return head1;
		}
	}
	
	public static void main(String[] args) {
		System.out.println("*** Test 2.4: Partition");
		test(new Node(new int[] { 6, 3, 4, 8, 2 }), 5);
		test(new Node(new int[] { 4, 8, 6, 7, 9, 2, 1 }), 3);
	}

	private static void test(Node head, int partitionValue) {
		System.out.print("\nOriginal List: ");
		ListFunctions.printList(head);
		System.out.print("Partition value: " + partitionValue + "\n");

		System.out.print("Solution 1: ");
		head = Partition.partition(head, partitionValue);
		ListFunctions.printList(head);

		System.out.print("Solution 2: ");
		head = Partition.partition2(head, partitionValue);
		ListFunctions.printList(head);
	}
}
