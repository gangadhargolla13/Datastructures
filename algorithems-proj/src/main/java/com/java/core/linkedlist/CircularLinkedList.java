package com.java.core.linkedlist;

public class CircularLinkedList {

	public int size;
	public Node head;
	public Node tail;

	public void addAtStart(int d) {
		Node n = new Node(d);
		if (size == 0) {
			head = n;
			tail = n;
			n.next = head;
		} else {
			Node tmp = head;
			n.next = tmp;
			head = n;
			tail.next = head;
		}
		size++;
	}

	public void addAtEnd(int d) {
		if (size == 0)
			addAtStart(d);
		else {
			Node n = new Node(d);
			tail.next = n;
			tail = n;
			n.next = head;
			size++;
		}
	}

	public void deleteAtEnd() {
		if (size == 0)
			System.out.println("List is empty!");
		else {
			head = head.next;
			tail.next = head;
			size--;
		}
	}

	public int elementAt(int i) {
		if (i > size) {
			return -1;
		}
		Node n = head;
		while (i - 1 != 0) {
			n = n.next;
			i--;
		}
		return n.data;
	}

	public int getSize() {
		return size;
	}

	public void print() {
		System.out.print("Circular Linked List:");
		Node temp = head;
		if (size <= 0) {
			System.out.print("List is empty");
		} else {
			do {
				System.out.print(" " + temp.data);
				temp = temp.next;
			} while (temp != head);
		}
		System.out.println();
	}
	public static void main(String[] args) {
        CircularLinkedList c = new CircularLinkedList();
        c.addAtStart(3);
        c.addAtStart(2);
        c.addAtStart(1);
        c.print();
        c.deleteAtEnd();
        c.print();
        c.addAtEnd(4);
        c.print();
        System.out.println("Size of linked list: "+ c.getSize());
        System.out.println("Element at 2nd position: "+ c.elementAt(2));
    }

}
