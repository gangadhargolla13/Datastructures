package com.java.core.linkedlist;

public class MergeTwoList {
	public static void main(String[] args) throws java.lang.Exception {
		Node a = new Node(5);
		a.next = new Node(10);
		a.next.next = new Node(15);
		a.next.next.next = new Node(20);
		a.next.next.next.next = new Node(25);
		MergeTwoList i = new MergeTwoList();
		System.out.println("");
		Node b = new Node(3);
		b.next = new Node(6);
		b.next.next = new Node(9);
		b.next.next.next = new Node(12);
		b.next.next.next.next = new Node(15);
		b.next.next.next.next.next = new Node(18);
		i.alterMerge(a, b);
	}
	public void alterMerge(Node a,Node b){
		Node tmp=a;
		while( a!=null && b!=null ){
			System.out.println(tmp.hashCode());
			System.out.println(a.hashCode());
			Node a1=a.next;
			Node b1=b.next;
			a.next=b;
			b.next=a1;
			a=a1;
			b=b1;
		}
		System.out.println("\nAlternate Mergred List");
		MergeSortLinkedList.display(tmp);
		System.out.println("\nRemaining Second List");
		MergeSortLinkedList.display(b);
	}
}
