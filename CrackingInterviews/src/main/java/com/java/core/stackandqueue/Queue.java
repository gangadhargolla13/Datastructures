package com.java.core.stackandqueue;

import com.java.core.linkedlist.ListFunctions;
import com.java.core.linkedlist.Node;

public class Queue {
	private Node head = null;
	private Node tail = null;
	
	public void enqueue(int data) {
		Node n = new Node(data);
		if (head == null) {
			head = n;
			tail = n;
		} else {
			tail.next = n;
			tail = n;
		}
	}

	public Node dequeue() {
		if (head == null) {
			return null;
		}
		Node front = head;
		head = head.next;
		if (head == null) {
			tail = null;
		}
		front.next = null; // rips the Node from the Queue
		return front;
	}
	
	public Node peek() {
		return head;
	}
	public static void main(String[] args) {
		System.out.println("*** Test Queue\n");
		Queue q = new Queue();
		q.enqueue(1);
		q.enqueue(2);
		q.enqueue(3);
		System.out.print("Queue after 3 enqueues: ");
		ListFunctions.printList(q.peek());
		q.dequeue();
		System.out.print("Queue after dequeue: ");	
		ListFunctions.printList(q.peek());
	}	
}
