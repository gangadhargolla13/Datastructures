package com.java.core.trees;

import java.util.ArrayList;
import java.util.Collections;

public class CheckSubTree {

	public String inOrder(Node11 root, String i){
		if(root!=null){
			return inOrder(root.left,i) + "  " + root.data + "  " +inOrder(root.right,i);
		}
		return "";
	}
	
	public String postOrder(Node11 root, String i){
		if(root!=null){
			return  postOrder(root.left,i) + "  " + postOrder(root.right,i) + "  " + root.data;
		}
		return "";
	}
	
	public boolean checkSubtree(Node11 rootA, Node11 rootB){
		String inOrderA = inOrder(rootA,"");
		String inOrderB = inOrder(rootB,"");
		String postOrderA = postOrder(rootA,"");
		String postOrderB = postOrder(rootB,"");
		return (inOrderA.toLowerCase().contains(inOrderB.toLowerCase()) && postOrderA.toLowerCase().contains(postOrderB.toLowerCase()));
	}
	
	public void display(Node11 root){
		if(root!=null){
			display(root.left);
			System.out.print(" " + root.data);
			display(root.right);
		}
	}
	// Find path
	public static ArrayList path;
	public Boolean printPath(Node11 root, Node11 dest){
		if(root==null) return false;
		if(root==dest||printPath(root.left,dest)||printPath(root.right,dest)){
			path.add(root.data);
			return true;
		}
		return false;
	}
	public static void main (String[] args) throws java.lang.Exception
	{
		Node11 rootA = new Node11(1);
		rootA.left = new Node11(2);
		rootA.right = new Node11(4);
		rootA.left.left = new Node11(3); 
		rootA.right.right = new Node11(6);
		rootA.right.left = new Node11(5); 
		Node11 rootB = new Node11(4);
		rootB.left = new Node11(5);
		rootB.right = new Node11(6); 
		CheckSubTree i  = new CheckSubTree();
		
		Node11 root = new Node11(1);
		root.left = new Node11 (2);
		root.right = new Node11 (3);
		Node11 n1 = new Node11 (4);
		root.left.left = n1;
		root.left.right = new Node11 (5);
		Node11 n2 = new Node11 (8);
		root.left.right.right = n2;
		root.left.right.left = new Node11 (7);
		System.out.print(" Tree A : ");
		i.display(rootA);
		System.out.println();
		System.out.print(" Tree B : ");
		i.display(rootB);
		System.out.println();
		System.out.println(i.checkSubtree(rootA,rootB));
		
		path = new ArrayList();
		i.printPath(root,n2);
		Collections.reverse(path);
		System.out.println(" Path " + path);
	}
}
