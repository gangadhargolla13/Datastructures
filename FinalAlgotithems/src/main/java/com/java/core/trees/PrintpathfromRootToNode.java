package com.java.core.trees;

import java.util.ArrayList;
import java.util.Collections;

public class PrintpathfromRootToNode {

	public static void main(String[] args) {
		Node root = new Node(4);
		root.left = new Node(2);
		root.right = new Node(6);
		root.left.left = new Node(1);
		root.left.right = new Node(3);
		root.right.left = new Node(5);
		root.right.right = new Node(7);
		/*Node root = new Node(1);
		root.left = new Node (2);
		root.right = new Node (3);
		Node n1 = new Node (4);
		root.left.left = n1;
		root.left.right = new Node (5);
		Node n2 = new Node (8);
		root.left.right.right = n2;
		root.left.right.left = new Node (7);*/
		PrintpathfromRootToNode n = new PrintpathfromRootToNode();
		n.print(root);
		n.mirrorTree(root);
		System.out.println();
		n.print(root);
		/*int m = n.getHg(root);
		System.out.println(m);*/
		/*n.printPath(root, n2);
		Collections.reverse(path);
		System.out.println(path);*/
	}
	public void print(Node root){
		if(root!=null){
			print(root.left);
			System.out.print("" + root.data);
			print(root.right);
		}
	}
	public Node mirrorTree(Node root){
		if(root!=null){
			Node t = root.left;
			root.left = root.right;
			root.right = t;
			mirrorTree(root.left);
			mirrorTree(root.right);
		}
		return root;
	}
	public static ArrayList<Integer> path = new ArrayList<>();
	public int getHg(Node root)
	{
		if(root==null)
			return 0;
		return 1+Math.max(getHg(root.left), getHg(root.right));
	}
	public Boolean printPath(Node root,Node dest)
	{
		if(root==null)
		{
			return false;
		}
		if(root==dest||printPath(root.left,dest)||printPath(root.right,dest))
		{
			path.add(root.data);
			return true;
		}
		return false;
	}
}
