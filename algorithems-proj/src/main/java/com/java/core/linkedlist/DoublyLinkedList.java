package com.java.core.linkedlist;

public class DoublyLinkedList {
	 int size =0;
	    Node1 head = null;
	    Node1 tail = null;
	    public Node1 addAtStart(int d)
	    {
	    	Node1 n = new Node1(d);
	    	if(size==0){
	    		head=n;
	    		tail=n;
	    	}else{
	    		n.next=head;
	    		head.previous=n;
	    		head=n;
	    	}
	    	size++;
	    	return n;
	    }
	    public void addAtEnd(int f){
	    	Node1 n = new Node1(f);
	    	if(size==0){
	            head = n;
	            tail = n;
	        }else{
	        	tail.next=n;
	        	n.previous=tail;
	        	tail=n;
	        
	        }
	    	size++;
	    }
	    public void addAfter(int f,Node1 pre)
	    {
	    	if(pre==null){
	    		System.out.println("Node after which new node to be added cannot be null");
	    	}else if(pre==tail)
	    	{
	    		addAtEnd(f);
	    	}else
	    	{
	    		Node1 n = new Node1(f);
	    		Node1 nextNode = pre.next;
	    		n.next = nextNode;
	    		pre.next = n;
	    		nextNode.previous = n;
	    		n.previous = pre;
	            size++;
	    	}
	    }
	    
	    public void deleteAtStart()
	    {
	    	if(size==0){
	            System.out.println("\nList is Empty");
	        }else{
	            System.out.println("\ndeleting node " + head.data + " from start");
	            head = head.next;
	            size--;
	        }
	    }
	    public void print(){
	        Node1 temp = head;
	        System.out.print("Doubly Linked List: ");
	        while(temp!=null){
	            System.out.print(" " + temp.data);
	            temp = temp.next;
	        }
	        System.out.println();
	    }
	    public int getSize(){
	        return size;
	    }
	    
	    public int elementAt(int i)
	    {
	    	if(i>size)
	    	{
	    		return -1;
	    		
	    	}
	    	Node1 n =head;
	    	while(i-1!=0){
	    		n=n.next;
	    		i--;
	    	}
	    	return n.data;
	    }
	    
	    public void deleteAtEnd()
	    {
	    	if(size==0){
	            System.out.println("\nList is Empty");
	        }else if(size==1){
	        	deleteAtStart();
	        }else{
	        	int x = tail.data;
	            Node1 prevTail = tail.previous;
	            tail = prevTail;
	            tail.next=null;
	            System.out.println("\ndeleting node " + x + " from end");
	            size--;
	        }
	    }
	    public static void main(String[] args) {
	        DoublyLinkedList d = new DoublyLinkedList();
	        Node1 x = d.addAtStart(2);
	        d.addAtStart(1);
	        d.print();
	        d.addAtEnd(3);
	        d.print();
	        d.addAfter(4,x);
	        d.print();
	        d.deleteAtStart();
	        d.print();
	        System.out.println("Element at index 2: "+d.elementAt(2));
	        d.addAtStart(1);
	        d.print();
	        d.deleteAtEnd();
	        d.print();
	        System.out.println("Size of the Linked List: " + d.getSize());
	    }
}

class Node1{
	int data;
    Node1 next;
    Node1 previous;
    public Node1(int data){
        this.data = data;
        next = null;
        previous = null;
    }
}