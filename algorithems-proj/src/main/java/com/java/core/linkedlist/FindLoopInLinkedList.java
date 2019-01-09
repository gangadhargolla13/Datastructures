package com.java.core.linkedlist;

public class FindLoopInLinkedList {
	static Node head;

	

	public static void main(String[] args) {
		FindLoopInLinkedList list = new FindLoopInLinkedList();
		list.head = new Node(50);
		list.head.next = new Node(20);
		list.head.next.next = new Node(15);
		list.head.next.next.next = new Node(4);
		list.head.next.next.next.next = new Node(10);

		head.next.next.next.next.next = head.next.next;
		//DeleteMiddle.display(head);
		list.detectAndRemoveLoop(head);
		System.out.println("Linked List after removing loop : ");
		list.printList(head);
	}

	void printList(Node node) {
		while (node != null) {
			System.out.print(node.data + " ");
			node = node.next;
		}
	}

	int detectAndRemoveLoop(Node node) {
		Node slow = node, fast = node;
		while (slow != null && fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if (slow == fast) {
				removeLoop(slow, node);
				return 1;
			}
		}
		return 0;
	}

	void removeLoop(Node loop, Node curr) {
		Node ptr1 = null, ptr2 = null;
		ptr1 = curr;
		
		while (1 == 1) {
			System.out.println("ptr1 "+ptr1.data);
			ptr2 = loop;
			while (ptr2.next != loop && ptr2.next != ptr1) {
				System.out.println(ptr2.data);
				System.out.println("ptr2  "+ptr2.data);
				ptr2 = ptr2.next;
			}
			if (ptr2.next == ptr1) {
				break;
			}
			ptr1 = ptr1.next;
		}
		ptr2.next = null;
	}
}
