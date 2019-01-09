package com.java.core.trees;

import java.util.Stack;

public class PreorderToTree {
	public int pIndex = 0;

	public Node11 constructTree(int[] preorder, int data, int min, int max) {
		if (pIndex < preorder.length) {
			if (preorder[pIndex] > min && preorder[pIndex] < max) {
				Node11 root = new Node11(data);
				pIndex++;
				if (pIndex < preorder.length) {
					// nodes lies between min and data will create left subtree
					root.left = constructTree(preorder, preorder[pIndex], min,
							data);
					// nodes lies between data and max will create right subtree
					root.right = constructTree(preorder, preorder[pIndex],
							data, max);
				}
				return root;
			}
		}
		return null;
	}
	public void displayTree(Node11 root) {
		if (root != null) {
			displayTree(root.left);
			System.out.print(" " + root.data);
			displayTree(root.right);
		}
	}

	public Node11 constcuctBSF(int[] preorder){
		Stack<Node11> s = new Stack<Node11>();
		Node11 root = new Node11(preorder[0]);
		s.add(root);
		for (int i = 1; i < preorder.length; i++) {
			Node11 x = null;
			while (!s.isEmpty() && preorder[i] > s.peek().data) {
				x = s.pop();
			}
			if (x != null) {
				x.right = new Node11(preorder[i]);
				s.push(x.right);
			} else {
				s.peek().left = new Node11(preorder[i]);
				s.push(s.peek().left);
			}
		}
		System.out.println("The sixe is "+s.size());
		return root;
	}
	public static void main(String args[]) {
		PreorderToTree p = new PreorderToTree();
		int[] preOrder = { 20, 10, 5, 1, 7, 15, 30, 25, 35, 32, 40 };
		//Node root = p.constructTree(preOrder, preOrder[0], Integer.MIN_VALUE,
		//		Integer.MAX_VALUE);
		System.out.println("Inorder Traversal of Constructed Tree : ");
		//p.displayTree(root);
		Node11 vv =p.constcuctBSF(preOrder);
		p.displayTree(vv);
	}
}
