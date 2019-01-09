package com.java.core.linkedlist;

public class MergeSortLinkedList {

	public static void main(String[] args) {
		Node a = new Node(9);
		a.next = new Node(3);
		a.next.next = new Node(4);
		a.next.next.next = new Node(2);
		a.next.next.next.next = new Node(5);
		a.next.next.next.next.next = new Node(1);
		MergeSortLinkedList m = new MergeSortLinkedList();
		display(a);
		Node r = m.mergeSort(a);
		System.out.println("\n");
		display(r);
	}
	
	public static void display(Node n){
		Node nn = n;
		while(nn!=null){
			System.out.print("->"+nn.data);
			nn=nn.next;
		}
	}
	
	public int getLength(Node m){
		int count=0;
		Node n=m;
		while(n != null){
			count++;
			n=n.next;
		}
		return count;
	}
	
	public Node MergeList(Node a,Node b){
		Node result= null;
		if(b==null)
			return a;
		if(a==null)
			return b;
		if(a.data>b.data){
			result=b;
			result.next=MergeList(a,b.next);
		}else{
			result=a;
			result.next=MergeList(a.next,b);
		}
		return result;
	}
	public Node mergeSort(Node a)
	{
		Node oldHead=a;
		int mid =  getLength(a) / 2;
		if(a.next==null)
			return a;
		while(mid-1>0){
			oldHead=oldHead.next;
			mid--;
		}
		Node newHead = oldHead.next;
		oldHead.next=null;
		oldHead=a;
		Node t1=mergeSort(oldHead);
		Node t2=mergeSort(newHead);
		return MergeList(t1,t2);
	}
}
