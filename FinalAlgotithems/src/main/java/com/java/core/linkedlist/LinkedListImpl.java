package com.java.core.linkedlist;

import java.util.HashSet;
import java.util.concurrent.atomic.AtomicInteger;

public class LinkedListImpl 
{

	public LNode root = null;
	public AtomicInteger in = new AtomicInteger();
	public void sorting(){
		root = nonRecuSorting(root);
	}
	public void removeDuplicates()
	{
		HashSet<Integer> hash = new HashSet<>();
		LNode next=root.next;
		hash.add(root.data);
		LNode prev = root;
		while(next!=null)
		{
			if(hash.contains(next.data))
			{
				prev.next=next.next;
				next = next.next;
			}else
			{
				hash.add(next.data);
				prev = next;
				next = next.next;
			}
		}
		print(root);
	}
	public void merge1(LNode node1,LNode node2){
		while(node1!=null && node2!=null)
		{
			LNode next1 = node1.next;
			LNode next2 = node2.next;
			node1.next=node2;
			node2.next=next1;
			node1=next1;
			node2 = next2;
		}
		print(node1);
	}
	public void swap()
	{
		swap(root);
	}
	private void swap(LNode node){
		LNode pre = node;
		LNode curr = node.next;
		node=curr;
		while(true){
			LNode next = curr.next;
			curr.next=pre;
			if(next== null || next.next==null){
				pre.next = next;
				break;
			}
			pre.next=next.next;
			pre=next;
			curr=pre.next;
		}
		root = node;
		print(node);
	}
	
	public void add1(int k){
		LNode n = new LNode(k);
		if(root==null){
			root=n;
		}
		else
		{
			LNode cu = root;
			while(cu.next!=null){
				cu=cu.next;
			}
			cu.next=n;
			n=null;
		}
	}
	
	public void add11(int k){
		LNode n = new LNode(k);
		if(root==null){
			root=n;
		}
		else
		{
			n.next=root;
			root=n;
			n=null;
		}
	}
	public void delete1(int d)
	{
		LNode cu= root;
		while(cu.next!=null)
		{
			if(cu.data==d){
				cu.data=cu.next.data;
				cu.next=cu.next.next;
			//	root=cu;
				break;
			}
			cu=cu.next;
		}
		print(cu);
	}
	
	public void reverse1()
	{
		LNode n=null;
		LNode p=null;
		LNode c=root;
		while(c!=null)
		{
			n=c.next;
			c.next=p;
			p=c;
			c=n;
			/*print(root);  // Here root always null value because we breaked next
			System.out.println("=========");*/
		}
		root=p;
		print(root);
	}
	private LNode nonRecuSorting(LNode node)
	{
		LNode oldNode = node;
		 int s = leanth(node);
		 int m = s/2;
		 System.out.println("The size is "+m);
		 while(m-1 > 0)
		 {
			 oldNode = oldNode.next;
			 m--;
		 }
		 LNode newNode = oldNode.next;
		 oldNode.next=null;
		 oldNode = node;
		 LNode t1 = nonRecuSorting(oldNode);
		 LNode t2 = nonRecuSorting(newNode);
		 return merge(t1,t2);
		 
	}
	
	private LNode merge(LNode node1,LNode node2)
	{
		LNode result = null;
		if(node1 == null)
			return node2;
		if(node2 == null)
		{
			return node1;
		}
		if(node1.data > node2.data)
		{
			result = node2;
			result.next=merge(node1,node2.next);
		}else
		{
			result = node1;
			result.next=merge(node1.next,node2);
		}
		return result;
	}
	private int leanth(LNode node){
		int size = 0;
		while(node.next!=null){
			node = node.next;
			size++;
		}
		return size;
	}
	public LNode recReverse(LNode curr, LNode prev)
	{
           if(curr.next == null)
           {
        	   root = curr;
        	   curr.next=prev;
        	   return root;
           }
           LNode l = curr.next;
           curr.next = prev;
           System.out.println(curr);
           recReverse(l,curr);
           return root;
	}
	
	public LNode nonRecuReverse(){
		LNode pre = null;
		LNode curr = root;
		LNode next = null;
		while(curr.next!=null){
			next = curr.next;
			curr.next=pre;
			pre=curr;
			curr = next;
		}
		curr.next=pre;
		root = curr;
		return root;
	}
	public void reverse()
	{
		//recReverse(root,null);
		nonRecuReverse();
	}
	private void reverse(LNode node)
	{
		if(node.next == null)
		{
			return ;
		}
		reverse(node.next);
		System.out.println(node.data);
	}
	
	public void add(int data){
		LNode node = new LNode(data);
		if(root!=null)
		{
			LNode pre = root;
			//System.out.println(pre.hashCode() +" "+root.hashCode());
			while(pre.next!=null)
			{
			   pre = pre.next;	
			}
			pre.next=node;
			/*System.out.println("Root printing");
			print(root);
			System.out.println("Pre printing");
			print(pre);*/
		}else
		{
			root = node;
			in.getAndIncrement();
		}
	}
	
	public void delete(int data){
		LNode ll = root;
		while(ll!=null)
		{
			if(ll.getData()==data)
			    break;
			ll = ll.next;
		}
		ll.data=ll.next.data;
		ll.next=ll.next.next;
	}
	void printList() { 
		LNode root1 = root;
        while (root1 != null) { 
            System.out.print(root1.getData() + " "); 
            root1 = root1.next; 
        } 
        System.out.println(""); 
	}
	public void print(LNode node)
	{
		while(node!=null)
		{
			System.out.print(node.getData()+",");
			node = node.next;
		}
		System.out.println();
	}
}
