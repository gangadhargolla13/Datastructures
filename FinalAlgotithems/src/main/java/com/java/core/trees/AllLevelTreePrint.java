package com.java.core.trees;

import java.util.Stack;

public class AllLevelTreePrint {

	public void preOrder(Node root) {
		if (root != null) {
			System.out.print(root.data+" ");
			preOrder(root.left);
			preOrder(root.right);
		}
	}
	
	public void DFS(Node root) {
		Stack<Node> s = new Stack<Node>();
		s.add(root);
		while (s.isEmpty() == false) {
			Node x = s.pop();
			if(x.right!=null) s.add(x.right);
			if(x.left!=null) s.add(x.left);			
			System.out.print(" " + x.data);
		}
	}
}
