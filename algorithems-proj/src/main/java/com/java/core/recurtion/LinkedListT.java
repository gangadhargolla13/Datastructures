package com.java.core.recurtion;

public class LinkedListT {

	Node head;
	
	public LinkedListT(){
		head=null;
	}
	
	public void addAtBegin(int d){
       Node n = new Node(d);
       n.next=head;
       head=n;
	}
	
	public static void display(Node head){
		//
		Node currNode = head;
		while(currNode!=null){
			System.out.print("->" + currNode.data);
			currNode=currNode.next;
		}
	}
	
	public void addAtEnd(int d){
		Node n = new Node(d);
		if(head==null){
			n.next=null;
			head=n;
		}
		else{
			Node cnode=head;
			while(cnode.next!=null){
				cnode=cnode.next;
			}
			cnode.next=n;
		}
	}
	public void insertLoop(int index){
		Node endN=head;
		while(endN.next!=null){
			endN=endN.next;
		}
		Node inode =head;
		while(index!=0){
			inode=inode.next;
			index--;
		}
		endN.next=inode;
	}
	public void displayLoop(){
      System.out.println("");
      Node cnode = head;
      int c=15;
      while(c!=0){
    	  System.out.print("->"+cnode.data);
    	  cnode=cnode.next;
    	  c--;
      }
	}
}


