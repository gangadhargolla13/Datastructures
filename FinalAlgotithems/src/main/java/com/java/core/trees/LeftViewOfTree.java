package com.java.core.trees;

public class LeftViewOfTree {

	public static void main(String[] args) throws java.lang.Exception {
		Node root = new Node(5);
		root.left = new Node(10);
		root.right = new Node(15);
		root.left.left = new Node(20);
		root.left.right = new Node(25);
		root.right.left = new Node(30);
		root.right.right = new Node(35);
		root.left.right.right = new Node(45);

		LeftViewOfTree i = new LeftViewOfTree();
		System.out.println("METHOD 1: ");
		//i.leftViewRecur(root, 1);
		//System.out.println("\nMETHOD 2 : Using Level Order, Left view ");
		i.Method2_levelOrder(root);
	}
	
	public static int index = 0;

	public void Method2_levelOrder(Node root) {
		int h = height(root);
		for (int i = 1; i <= h; i++) {
			index = 1;
			printLevels(root, i);
			// System.out.println("");
		}

	}

	public void printLevels(Node root, int h) {
		if (root == null)
			return;
		if (h == 1 && index == 1) {
			System.out.print(" " + root.data);
			index++;
		} else {
			printLevels(root.right, h - 1);
			printLevels(root.left, h - 1);
			
		}
	}
	
	public int height(Node root)
	{
		if(root == null)
			return 0;
					return 1+ Math.max(height(root.left), height(root.right));
	}
}
