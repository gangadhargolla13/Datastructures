package com.java.collection.linkedlist;

public class FindingLoopInList {

	private Node head;

	public FindingLoopInList() {
		this.head = new Node("head");
	}

	public Node head() {
		return head;
	}

	public void appendIntoTail(Node node) {
		Node current = head;
		while (current.next() != null) {
			current = current.next();
		}
		current.setNext(node);
	}

	public boolean isCyclic() {
		Node fast = head;
		Node slow = head;
		while (fast != null && fast.next != null) {
			fast = fast.next.next;
			slow = slow.next;
			if (fast == slow) {
				return true;
			}
		}
		return false;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		Node current = head.next();
		while (current != null) {
			sb.append(current).append("-->");
			current = current.next();
		}
		sb.delete(sb.length() - 3, sb.length());
		return sb.toString();
	}

	public static class Node {
		private Node next;
		private String data;

		public Node(String data) {
			this.data = data;
		}

		public String data() {
			return data;
		}

		public void setData(String data) {
			this.data = data;
		}

		public Node next() {
			return next;
		}

		public void setNext(Node next) {
			this.next = next;
		}

		@Override
		public String toString() {

			return this.data;
		}
	}

	public static void main(String[] args) throws Exception{
		
		FindingLoopInList list = new FindingLoopInList();
		list.appendIntoTail(new FindingLoopInList.Node("101"));
		list.appendIntoTail(new FindingLoopInList.Node("102"));
		list.appendIntoTail(new FindingLoopInList.Node("103"));
		list.appendIntoTail(new FindingLoopInList.Node("104"));
		list.appendIntoTail(new FindingLoopInList.Node("101"));
		list.appendIntoTail(new FindingLoopInList.Node("102"));
		System.out.println(list);
		if(list.isCyclic()){
			System.out.println("cycle is there");
		}
		else{
			System.out.println("List not having any cycles");
		}
		
	}
}
