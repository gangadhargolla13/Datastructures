package com.java.core.trees;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class ListAtDepth {

	public static Node11 n = null;
	public static boolean nodeFound = false;
	ArrayList<ListNode> al = new ArrayList<>();
	public void levelOrder(Node11 root){
		int h = height(root);
		for(int i=0;i<h;i++){
			printLevel(root,i);
			System.out.println("");
		}
	}
	
	public void printLevel(Node11 n,int i){
		if(n==null)return;
		if(i==1)System.out.println(" "+n.data);
		else{
			printLevel(n.left,i-1);
			printLevel(n.right,i-1);
		}
	}
	public int height(Node11 n){
		if(n == null)return 0;
		return (1+Math.max(height(n.left), height(n.right)));
	}
	public void display(ArrayList<ListNode> al){
		Iterator<ListNode> it = al.iterator();
		while(it.hasNext()){
			ListNode ln = it.next();
			while(ln!=null){
				System.out.print("->"+ln.data);
				ln = ln.next;
			}
			System.out.println("");
		}
	}
	
	public void levelOrderQueue(Node11 root){
		Queue q = new LinkedList();
		int level = 0;
		if(root == null)return;
		q.add(root);
		while(!q.isEmpty()){
			level = q.size();
			ListNode head = null;
			ListNode curr = null;
			while(level>0){
				Node11 n = (Node11)q.remove();
				ListNode ll = new ListNode(n.data);
				if(head==null){
					head = ll;
					curr = ll;
				}else{
					curr.next=ll;
					curr = curr.next;
				}
				if(n.left!=null)q.add(n.left);
				if(n.right != null) q.add(n.right);
				level--;
			}
			al.add(head);
		}
		display(al);
	}
	
	public Node11 convert(int[] a,int s,int e){
		if(s > e){
			return null;
		}
		int m = (s + e)/2;
		Node11 n = new Node11(a[m]);
		n.left=convert(a,s,m-1);
		n.right=convert(a,m+1,e);
		return n;
	}
	
	public void display(Node11 n){
		if(n!=null){
			display(n.left);
			System.out.print(" "+n.data);
			display(n.right);
		}
	}
	
	public Node11 inorderSucc(Node11 root,Node11 x){
		nodeFound=false;
		if(x.right!=null){
			Node11 tmp = leftSucc(x);
			System.out.println("The in order succesor is "+x.data+" "+tmp.data);
			return null;
		}
		return findSucc(root,x);
	}
	public Node11 leftSucc(Node11 nn){
		while(nn.left!=null){
			nn= nn.left;
		}
		nodeFound = true;
		return nn;
	}
	
	public Node11 findSucc(Node11 root,Node11 x){
		if(root==null)return null;
		if(n==x||(n=findSucc(root.left,x))!=null||(n=findSucc(root.right,x))!=null){
			if(n!=null){
				if(root.left==n){
					nodeFound = true;
					System.out.println("The In order successor for "+x.data+" "+root.data);
					return null;
				}
			}
			return root;
		}
		return null;
	}
	public static void main(String[] args) {
		Node11 root = new Node11(5);
		root.left = new Node11(10);
		root.right = new Node11(15);
		root.left.left = new Node11(20);
		root.left.right = new Node11(25);
		root.right.left = new Node11(30);
		root.right.right = new Node11(35);
        ListAtDepth l = new ListAtDepth();
        //l.levelOrder(root);
        		//l.levelOrderQueue(root);
        int [] arrA = {2,3,6,7,8,9,12,15,16,18,20};
        Node11 nn = l.convert(arrA, 0, arrA.length-1);
        l.display(nn);
	}
}

class ListNode {
	int data;
	ListNode next;
	
	public ListNode(int data){
		this.data=data;
		this.next=null;
	}
}