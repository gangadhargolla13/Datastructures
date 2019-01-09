package com.java.core.linkedlist;

import java.util.HashSet;

public class DeleteMiddleOfLinkedList 
{

	public void display(LNode head)
	{
		LNode curr = head;
		while(curr!=null)
		{
			System.out.print(curr.data+"-->");
			curr=curr.next;
		}
		System.out.println();
	}
	
	public  void deleteMiddle(LNode head)
	{
		if(head==null)
		{
			return;
		}
		LNode curr = head;
		curr.data=curr.next.data;
		curr.next=curr.next.next;
	}
	
	public int kthElement(LNode root,int k)
	{
		if(root==null)
		{
		return 0;	
		}
		LNode curr = root;
		while(k>0)
		{
			curr=curr.next;
			k--;
		}
		LNode sec=root;
		while(curr!=null)
		{
			curr=curr.next;
			sec=sec.next;
		}
		return sec.data;
	}
	
	public void removeDuplicates(LNode head)
	{
		if(head==null)
			return;
		HashSet<Integer> set = new HashSet<>();
		LNode curr = head.next;
		LNode pre = head;
		LNode tmp;
		while(curr!=null)
		{
			int data = curr.data;
			if(set.contains(data))
			{
				pre.next=curr.next;
				tmp =curr;
				curr=curr.next;
				tmp.next=null;
			}else
			{
				pre=curr;
				curr=curr.next;
				set.add(data);
			}
		}
	}
}
