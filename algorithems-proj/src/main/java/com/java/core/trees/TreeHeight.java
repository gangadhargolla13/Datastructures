package com.java.core.trees;

import java.util.LinkedList;
import java.util.Queue;

public class TreeHeight {
	public int treeHeight(Node11 root){
		if(root==null)return 0;
		return (1+ Math.max(treeHeight(root.left),treeHeight(root.right)));
	}
	
	public int findHeight(Node11 root,Node11 x,int he){
		if(root == null)
			return 0;
		if(root == x)
			return he;
		int le = findHeight(root.left,x,he+1);
		if(le!=0)return le;
		return findHeight(root.right,x,he+1);
	}
	
	public boolean checkBalance(Node11 root){
		int result = isBalanced(root);
		if(result>0){
			return true;
		}else{
			return false;
		}
	}
	
	public int isBalanced(Node11 root){
		if(root==null){
			return 0;
		}
		int leftH = isBalanced(root.left);
		if(leftH==-1){
			return -1;
		}
		int rightH = isBalanced(root.right);
		if(rightH==-1){
			return -1;
		}
		int diff = leftH-rightH;
		if(Math.abs(diff)>1){
			return -1;
		}
		return 1 + Math.max(leftH, rightH);
	}
	
	public void levelOrderQueue(Node11 root){
		Queue<Node11> q = new LinkedList<Node11>();
		int level = 0;
		if(root==null) return ;
		q.add(root);
		while(!q.isEmpty()){
			level = q.size();
			while(level > 0){
				Node11 n = (Node11)q.remove();
				System.out.print(" " + n.data);
				if(n.left!=null) q.add(n.left);
				if(n.right!=null) q.add(n.right);
				level--;
			}
			System.out.println("");
		}
	}
	public static void main (String[] args) throws java.lang.Exception
	{
		Node11 root = new Node11(5);
		root.left = new Node11(10);
		root.right = new Node11(15);
		root.left.left = new Node11(20);		
		Node11 x = new Node11(25);
		root.left.right = x;
		root.left.right.left = new Node11(35);
		TreeHeight i  = new TreeHeight();
		//System.out.println(i.treeHeight(root));
		System.out.println(i.findHeight(root, x, 1));
		i.levelOrderQueue(root);
	}
}
