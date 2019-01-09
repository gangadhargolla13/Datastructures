package com.java.collection.linkedlist;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class StackImplementation {
	public static void main(String[] args) {
		try {
			BufferedReader obj = new BufferedReader(new InputStreamReader(
					System.in));
			int ch, temp;
			StackExample example = new StackExample();
			do {
				System.out.println("##MENU##");
				System.out.println("1.Insert an element in stack");
				System.out.println("2.Remove an element");
				System.out.println("3.Peek element");
				System.out.println("4.Display Stack");
				System.out.println("5.Exit");
				System.out.println("Enter Choice");
				ch = Integer.parseInt(obj.readLine());
				switch (ch) {
				case 1:
					System.out.println("Enter element to be inseted");
					temp = Integer.parseInt(obj.readLine());
					example.push(temp);
					break;
				case 2:
					temp = example.pop();
					System.out.println("Popped element is " + temp);
					break;
				case 3:
					temp = example.peek();
					System.out.println("Peeked element is " + temp);
					break;
				case 4:
					example.display();
				}
			} while (ch != 5);

		} catch (Exception e) {

		}
	}
}

class Node {
	int data;
	Node next;

	public Node(int d) {
		data = d;
		next = null;
	}
}

class StackExample {
	Node top = null;

	public boolean isEmpty() {
		if (top == null) {
			return true;
		}
		return false;
	}

	public void push(int x) {
		if (isEmpty() == true) {
			Node p = new Node(x);
			top = p;
		} else {
			Node p = new Node(x);
			p.next = top;
			top = p;
		}
	}

	public int pop() {
		if (isEmpty() == true) {
			System.out.println("No element is found");
			return -1;
		} else {
			int x = top.data;
			top = top.next;
			return x;
		}
	}

	public int peek() {
		if (isEmpty() == true) {
			System.out.println("Stack is empty!");
			return -1;
		} else {
			return top.data;
		}
	}

	public void display() {
		if (isEmpty() == true) {
			System.out.println("Stack is empty");
		} else {
			Node current = top;
			while (current != null) {
				System.out.println(current.data);
				current = top.next;
			}
		}
	}
}
