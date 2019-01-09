package com.java.core.trees;

public class AllPrintMainClass {

	public static void main(String[] args) {
		AllLevelTreePrint print = new AllLevelTreePrint();
		Node root = new Node(1);
		root.left = new Node(2);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.right = new Node(3);
		root.right.left = new Node(6);
		root.right.right = new Node(7);
		print.preOrder(root);
	}
}
