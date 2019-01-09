package com.java.core.trees;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTreeExamples {

	// Find Height of tree
	
	public int treeHeight(BTSNode node)
	{
		if(node == null)
			return 0;
		return (1+ Math.max(treeHeight(node.left), treeHeight(node.right)));
	}
	
	// Find the Height of Given node
	
	public int getHeight(BTSNode node,BTSNode x,int h){
		if(node == null) return 0;
		if(node == x) return h;
		int val = getHeight(node.left,x,1+h);
		if(val!=0) return val;
       return		 getHeight(node.right,x,1+h);
	}
	
	//Printting Level order of tree
	
	public void printLevel(BTSNode node)
	{
		Queue<BTSNode> qu = new LinkedList<>();
		int level =0;
		if(node == null) return; 
		qu.add(node);
		while(!qu.isEmpty())
		{
			level = qu.size();
			while(level > 0)
			{
				BTSNode n = (BTSNode) qu.remove();
				System.out.print(" "+n.data);
				if(n.left!=null) qu.add(n.left);
				if(n.right!=null) qu.add(n.right);
				level --;
			}
			System.out.println("");
		}
		
		
	}
	
	public BTSNode convert(int[] a,int start,int end)
	{
		if(start > end)
		{
			return null;
		}
		
		int mid = (start + end)/2;
		BTSNode n = new BTSNode(a[mid]);
		n.left = convert(a,start,mid-1);
		n.right = convert(a,mid+1,end);
		return n;
	}
	
	public void printOnlyLeaves(BTSNode node) {
		if (node != null) {
			printOnlyLeaves(node.left);
			if ((node.left == null) && (node.right != null)) {
				System.out.println(node.right.data);
			}
			if ((node.left != null) && (node.right == null)) {
				System.out.println(node.left.data);
			}
			printOnlyLeaves(node.right);
		}
	}
}
