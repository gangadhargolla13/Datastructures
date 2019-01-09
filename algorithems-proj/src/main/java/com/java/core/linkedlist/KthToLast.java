package com.java.core.linkedlist;

public class KthToLast {
	public static void main(String args[]){
		Node n = new Node(1);
		n.next = new Node(2);
		n.next.next = new Node(8);
		n.next.next.next = new Node(3);
		n.next.next.next.next = new Node(7);
		n.next.next.next.next.next = new Node(0);
		n.next.next.next.next.next.next = new Node(4);
		System.out.print("Original List : ");
		KthToLast rm = new KthToLast();
		DeleteMiddle.display(n);		
		System.out.print("\n Recursion::3rd Element from the end is : ");
		rm.kthByRecursion(n, 3);
	}
	public int kthByRecursion(Node head, int k){
		if(head==null){
			return 0;
		}
		int i =  kthByRecursion(head.next, k)+1;
		System.out.println("---"+i);
		if(i==k){
			System.out.println(head.data);
		}
		return i;
	}
}
