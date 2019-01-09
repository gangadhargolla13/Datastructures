package com.java.core.trees;

public class SortedLLToBST {

	public static Node1 head = null;
	public static void main (String[] args) throws java.lang.Exception
	{
		head = new Node1(1);
		head.next = new Node1(2);
		head.next.next = new Node1(3);
		head.next.next.next = new Node1(4);
		head.next.next.next.next = new Node1(5);
		Node1 tail = new Node1(6);
		head.next.next.next.next.next = tail;

		SortedLLToBST i = new SortedLLToBST();
		BSTNode x = i.LLToBST(1,i.getSize()) ;
		System.out.print("Constructed BST is :");
		i.inorder(x);

	}
	
	public void inorder(BSTNode root){
		if(root!=null){
			inorder(root.left);
			System.out.print(" " + root.data);
			inorder(root.right);
		}
	}
	
	public int getSize(){
		Node1 curr = head;
		int size =0;
		while(curr!=null){
			curr=curr.next;
			size++;
		}
		return size;
	}
	
	public BSTNode LLToBST(int start, int end){
		if(start>end)return null;
		int mid = (start+end)/2;
		BSTNode leftChild = LLToBST(start,mid-1);
		BSTNode root = new BSTNode(head.data);
		root.left = leftChild;
		head = head.next;
		root.right = LLToBST(mid+1,end);
		return root;
	}
}
class BSTNode{
	int data;
	BSTNode left;
	BSTNode right;
	public BSTNode(int data){
		this.data = data;
		left = null;
		right = null;
	}
}
class Node1{
	int data;
	Node1 next;
	public Node1(int data){
		this.data = data;
		next = null;
	}
}