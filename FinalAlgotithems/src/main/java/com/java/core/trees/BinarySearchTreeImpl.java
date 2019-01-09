package com.java.core.trees;

public class BinarySearchTreeImpl {

	private static BTSNode root;

	public void insert(int data) {
		BTSNode node = new BTSNode(data);
		if (root == null) {
			root = node;
			return;
		}

		BTSNode current = root;
		BTSNode parent = null;
		while (true) {
			parent = current;
			if (data < parent.data) {
				current = current.left;
				if (current == null) {
					parent.left = node;
					return;
				}
			} else {
				current = current.right;
				if (current == null) {
					parent.right = node;
					return;
				}
			}
		}
	}

	public void display(BTSNode node) {
		if (node != null) {
			display(node.left);
			System.out.println(" " + node.data);
			display(node.right);
		}
	}

	public void find(int val) {
		BTSNode parent = root;
		while (parent != null) {
			if (val == parent.data) {
				System.out.println("The element is found");
				return;
			}
			if (val < parent.data) {
				parent = parent.left;
			} else {
				parent = parent.right;
			}
		}
	}

	public void deleteElement(int val) {
		BTSNode parent = root;
		BTSNode current = root;
		boolean isLeftChild = false;
		while (current.data != val) {
			parent = current;
			if (current.data > val) {
				isLeftChild = true;
				current = current.left;
			} else {
				isLeftChild = false;
				current = current.right;
			}
			if (current == null) {
				return;
			}
		}

		if (current.left == null && current.right == null) {
			if (current == root)
				root = null;
			if (isLeftChild) {
				parent.left = null;
			} else {
				parent.right = null;
			}
		}
		else if(current.right == null)
		{
			if(current == root)
			{
				root = current.left;
			}else if(isLeftChild)
			{
				parent.left=current.left;
			}else{
				parent.right= current.left;
			}
		}
		else if(current.left == null)
		{
			if(current == root)
			{
				root = current.right;
			}else if(isLeftChild)
			{
				parent.left = current.right;
			}
			else
				parent.right = current.right;
		}
		
		else if(current.left!=null && current.right!=null)
		{
               BTSNode node = getSuccessor(current);			
		}
	}
	
	public BTSNode getSuccessor(BTSNode node)
	{
		return null;
	}
}

class BTSNode {
	public int data;
	public BTSNode left;
	public BTSNode right;

	public BTSNode(int data) {
		this.data = data;
		this.left = null;
		this.right = null;
	}
}