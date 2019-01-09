package com.java.core.linkedlist;

public class ReverseLinkedList {

	public static void main(String[] args) {
		Node n = new Node(1);
		n.next = new Node(2);
		n.next.next = new Node(8);
		n.next.next.next = new Node(3);
		n.next.next.next.next = new Node(7);
		n.next.next.next.next.next = new Node(0);
		n.next.next.next.next.next.next = new Node(4);
		DeleteMiddle.display(n);
		reverseIterative(n);
	}
	public static void reverseIterative(Node head){
		Node currNode = head;
		Node nextNode = null;
		Node prevNode = null;
		while(currNode!=null){
			nextNode = currNode.next;
			currNode.next = prevNode;
			prevNode = currNode;
			System.out.println("\n");
			currNode = nextNode;
		}
		head = prevNode;
		System.out.println("\n Reverse Through Iteration");
		DeleteMiddle.display(head);
	}
}
