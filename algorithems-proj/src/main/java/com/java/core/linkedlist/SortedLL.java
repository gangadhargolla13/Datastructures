package com.java.core.linkedlist;

public class SortedLL {
	public static Node head;
	public static void main(String[] args) {
		head = new Node(1);
		head.next = new Node(2);
		head.next.next = new Node(3);
		head.next.next.next = new Node(4);
		head.next.next.next.next = new Node(5);
		Node tail = new Node(6);
		head.next.next.next.next.next = tail;
		SortedLL i = new SortedLL();
		BSTNode x = i.LLToBST(1,i.getSize()) ;
		System.out.print("Constructed BST is :");
		i.inorder(x);
	}
	public int getSize(){
		Node curr = head;
		int size =0;
		while(curr!=null){
			curr=curr.next;
			size++;
		}
		return size;
	}
	public void inorder(BSTNode root){
		if(root!=null){
			inorder(root.left);
			System.out.print(" " + root.data);
			inorder(root.right);
		}
	}
	public BSTNode LLToBST(int start, int end){
		if(start>end)return null;
		int mid = (start+end)/2;
		System.out.println("Call at left");
		BSTNode leftChild = LLToBST(start,mid-1);
		BSTNode root = new BSTNode(head.data);
		root.left = leftChild;
		head = head.next;
		System.out.println("Call at right");
		root.right = LLToBST(mid+1,end);
		return root;
	}
}

class BSTNode {
	int data;
	BSTNode left;
	BSTNode right;

	public BSTNode(int d) {
		this.data = d;
		this.left = null;
		this.right = null;
	}
}