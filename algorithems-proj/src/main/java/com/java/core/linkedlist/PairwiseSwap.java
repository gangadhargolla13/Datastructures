package com.java.core.linkedlist;

public class PairwiseSwap {

	public static void main(String[] args) {
		Node head = new Node(1);
		head.next = new Node(2);
		head.next.next = new Node(3);
		head.next.next.next = new Node(4);
		head.next.next.next.next = new Node(5);
		head.next.next.next.next.next = new Node(6);
		head.next.next.next.next.next.next = new Node(7);
		System.out.println("\n Swapping again using Recursive method");
		Node n = swapNodeRecursive(head);
		display(n);
	}
	public static void display(Node head){
		//System.out.println("");
		Node currNode = head;
		while(currNode!=null){
			System.out.print("->" + currNode.data);
			currNode=currNode.next;
		}
	}
	public static Node swapNodeRecursive(Node head){
		if(head==null || head.next==null){
			return head;
		}
			Node ptrOne = head;
			Node ptrTwo = head.next;
			Node ptrTwoNext = ptrTwo.next;
			ptrTwo.next = head;
			Node newhead = ptrTwo;
			ptrOne.next = swapNodeRecursive(ptrTwoNext);
			return newhead;
	}
}
