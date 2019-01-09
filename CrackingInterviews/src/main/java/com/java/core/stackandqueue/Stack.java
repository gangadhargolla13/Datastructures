package com.java.core.stackandqueue;

import com.java.core.linkedlist.ListFunctions;
import com.java.core.linkedlist.Node;

public class Stack {
private Node top = null;
	
	public void push(int data) {
		Node n = new Node(data);
		n.next = top;
		top = n;
	}
	
	public Node pop() {
		if (top == null) {
			return null;
		} 
		Node n = top;
		top = top.next;
		n.next = null; // rips off the node from the Stack
		return n;
	}
	
	public Node peek() {
		return top;
	}
	public static void main(String[] args) {
		System.out.println("*** Test Stack\n");
		Stack s = new Stack();
		s.push(1);
		s.push(2);
		s.push(3);
		System.out.println("(top of stack printed first)\n");
		System.out.print("Stack after 3 pushes: ");
		ListFunctions.printList(s.peek());
		s.pop();
		System.out.print("Stack after pop     : ");
		ListFunctions.printList(s.peek());
	}
}
