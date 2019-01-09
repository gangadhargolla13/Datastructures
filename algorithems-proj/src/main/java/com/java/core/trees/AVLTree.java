package com.java.core.trees;

public class AVLTree {
	public int getBalance(Node11 n) {
		if (n != null) {
			return (getHeight(n.left) - getHeight(n.right));
		}
		return 0;
	}

	public int getHeight(Node11 n) {
		if (n != null) {
			return n.height;
		}
		return 0;
	}

	public Node11 rightRotate(Node11 y) {
		Node11 x = y.left;
		Node11 T2 = x.right;

		// Rotation
		x.right = y;
		y.left = T2;

		// update their heights
		x.height = Math.max(getHeight(x.left), getHeight(x.right)) + 1;
		y.height = Math.max(getHeight(y.left), getHeight(y.right)) + 1;

		return x;
	}

	public Node11 leftRotate(Node11 x) {
		Node11 y = x.right;
		Node11 T2 = y.left;

		// Rotation
		y.left = x;
		x.right = T2;

		// update their heights
		x.height = Math.max(getHeight(x.left), getHeight(x.right)) + 1;
		y.height = Math.max(getHeight(y.left), getHeight(y.right)) + 1;

		return y;
	}

	public Node11 insert(Node11 node, int data) {
		if (node == null) {
			return (new Node11(data));
		}
		if (node.data > data) {
			node.left = insert(node.left, data);
		} else {
			node.right = insert(node.right, data);
		}
		// update the node height
		node.height = Math.max(getHeight(node.left), getHeight(node.right)) + 1;

		int balDiff = getBalance(node);

		// Left Rotate
		if (balDiff > 1 && data < node.left.data) {
			return rightRotate(node);
		}

		// Right Rotate
		if (balDiff < -1 && data > node.right.data) {
			return leftRotate(node);
		}

		// Left Right Rotate
		if (balDiff > 1 && data > node.left.data) {
			node.left = leftRotate(node.left);
			return rightRotate(node);
		}

		// Right Left Rotate
		if (balDiff < -1 && data < node.right.data) {
			node.right = rightRotate(node.right);
			return leftRotate(node);
		}

		return node;
	}

	public void inorder(Node11 root) {
		if (root != null) {
			inorder(root.left);
			System.out.print(" " + root.data);
			inorder(root.right);
		}
	}

	public static void main(String args[]) {
		Node11 root = null;
		AVLTree i = new AVLTree();
		root = i.insert(root, 4);
		root = i.insert(root, 2);
		root = i.insert(root, 1);
		root = i.insert(root, 5);
		root = i.insert(root, 6);
		root = i.insert(root, 9);
		root = i.insert(root, 14);
		root = i.insert(root, 11);
		root = i.insert(root, 10);
		root = i.insert(root, 20);
		System.out.print("Inorder Traversal of Constructed AVL Tree :");
		i.inorder(root);
		System.out.print("\n New Root of AVL Tree is : " + root.data);
	}
}

class Node11 {
	int data;
	Node11 left;
	Node11 right;
	int height;

	public Node11(int data) {
		this.data = data;
		height = 1;
	}
}