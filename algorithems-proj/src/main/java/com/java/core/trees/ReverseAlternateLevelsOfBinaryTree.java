package com.java.core.trees;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class ReverseAlternateLevelsOfBinaryTree {

	public static ArrayList al;
	public void storeAlterNateLevels(Node11 root,int level){
		if(root!=null){
			storeAlterNateLevels(root.left,level+1);
			if(level%2!=0){
				al.add(root.data);
			}
			storeAlterNateLevels(root.right,level+1);
		}
	}

	public void reverseAlterNateLevels(Node11 root,int level){
		if(root!=null){
			reverseAlterNateLevels(root.left,level+1);
			if(level%2!=0){
				root.data = (Integer)al.remove(0);
			}
			reverseAlterNateLevels(root.right,level+1);
		}
	}
	public void levelOrderQueue(Node11 root){
		Queue q = new LinkedList();
		int levelNodes =0;
		if(root==null) return;
		q.add(root);

		while(!q.isEmpty()){
			levelNodes = q.size();
			while(levelNodes>0){
				Node11 n = (Node11)q.remove();
				System.out.print("" + n.data);
				if(n.left!=null) q.add(n.left);
				if(n.right!=null) q.add(n.right);
				levelNodes--;
			}
			System.out.println("");
		}
	}
	public void inorder(Node11 root){
		if(root!=null){
			inorder(root.left);
			System.out.print("" + root.data);
			inorder(root.right);
		}
	}
	public static void main (String[] args) throws java.lang.Exception
	{
		Node11 root = new Node11(1);
		root.left = new Node11 (2);
		root.right = new Node11 (3);
		root.left.left = new Node11 (4);
		root.left.right = new Node11 (5);
		root.right.left = new Node11 (6);
		root.right.right = new Node11 (7);
		root.left.left.left = new Node11 (8);
		root.left.left.right = new Node11 (9);
		root.left.right.left = new Node11 (10);
		root.left.right.right = new Node11 (11);

		root.right.left.left = new Node11 (12);
		root.right.left.right = new Node11 (13);
		root.right.right.left = new Node11 (14);
		root.right.right.right = new Node11 (15);

		ReverseAlternateLevelsOfBinaryTree i = new ReverseAlternateLevelsOfBinaryTree();
		al = new ArrayList();
		System.out.println("Orininal Tree");
		//i.inorder(root);
		i.levelOrderQueue(root);
		i.storeAlterNateLevels(root,0);
		// System.out.println("LIst " + al);
		Collections.reverse(al);

		i.reverseAlterNateLevels(root,0);
		System.out.println("\n New Tree, Alternate Levels Reversed..");
		//i.inorder(root);
		i.levelOrderQueue(root);
		
		i.maxSum(root,0);
		System.out.println("Maximum Sum Leaf to Root path " + maxSum);
		System.out.print("Path :");
		i.path(root,maxLeaf);
	}
	
	static int maxSum = -100000;
	static Node11 maxLeaf=null;
	static int currentSum =0;
	
	public void maxSum(Node11 root, int sum){
		if(root!=null){
			sum=sum+root.data;
			if(sum>maxSum && root.left==null && root.right==null){
				maxLeaf = root;
				maxSum = sum;
			}
		//	System.out.println("Sum " + sum);
			maxSum(root.left,sum);
			maxSum(root.right,sum);
		}
	}
	
	public Boolean path(Node11 root, Node11 leaf){
		if(root==null) return false;
		if ((root == leaf) || path(root.left, leaf) ||path(root.right, leaf) )
		{
			System.out.print(" " + root.data);
			return true;
		}
			return false;
	}
}
