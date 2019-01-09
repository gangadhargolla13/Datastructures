package com.java.collection.linkedlist.v2;

public class FindMiddleLinkedList {
	public static void main(String[] args) {
		LinkedList list = new LinkedList();
		LinkedList.Node head = list.head();
		list.add(new LinkedList.Node("1"));
		list.add(new LinkedList.Node("2"));
		list.add(new LinkedList.Node("3"));
		list.add(new LinkedList.Node("4"));
		list.add(new LinkedList.Node("5"));
		LinkedList.Node current = head;
		int length = 0;
		LinkedList.Node middle = head;
		while(current.next()!=null)
		{
			length++;
			if(length%2==0)
			{
				middle=middle.next();
			}
			current =current.next();
		}
		if(length%2 == 1)
		{
			middle=middle.next();
		}
		System.out.println("length of LinkedList: " + length);
	      System.out.println("middle element of LinkedList : " + middle);

	}
}

class LinkedList {
	private Node head;
	private Node tail;

	public LinkedList() {
		this.head = new Node("head");
		tail = head;
	}

	public Node head() {
		return head;
	}

	public void add(Node node) {
		tail.next = node;
		tail = node;
	}

	public static class Node {
		private Node next;
		private String data;

		public Node(String name) {
			this.data = name;
		}

		public Node getHead() {
			return next;
		}

		public void setHead(Node head) {
			this.next = head;
		}

		public String getName() {
			return data;
		}

		public void setName(String name) {
			this.data = name;
		}
		 public Node next() {
	            return next;
	        }
		 public String toString(){
	            return this.data;
	        }
	}
}
