package com.java.core.linkedlist;

public class DeleteMiddle {

	public static void main(String[] args) {
		Node n = new Node(1);
		n.next = new Node(2);
		n.next.next = new Node(8);
		n.next.next.next = new Node(3);
		Node mid = new Node(7);
		n.next.next.next.next = mid;
		n.next.next.next.next.next = new Node(0);
		n.next.next.next.next.next.next = new Node(4);
		//System.out.print("Original List : ");
		DeleteMiddle rm = new DeleteMiddle();
		//display(n);
		//System.out.print("\n Aftter Deleting the mid node : ");
		rm.deleteMiddle(mid);
		//display(n);
	}
	public static void display(Node head){
		Node n=head;
		while(n!=null){
			System.out.println( n.data);
			n=n.next;
		}
	}
	public void deleteMiddle(Node mid1){
		display(mid1);
		if(mid1.next==null){
			return;   // we cant delete the node if it is the last node in the linked list
		}
		Node curr = mid1;
		curr.data = curr.next.data;
		curr.next = curr.next.next;
	}
}
