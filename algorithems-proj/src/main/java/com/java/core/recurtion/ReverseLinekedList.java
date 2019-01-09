package com.java.core.recurtion;

public class ReverseLinekedList {

	public static void main(String[] args) {
		LinkedListT a = new LinkedListT();
		a.addAtBegin(5);
		a.addAtBegin(10);
		a.addAtBegin(15);
		a.addAtBegin(20);
		a.addAtBegin(25);
		a.addAtBegin(30);
		LinkedListT.display(a.head);
		System.out.println("\n");
		ReverseLinekedList l = new ReverseLinekedList();
		l.reverseRecursion(a.head, a.head.next, null);
		
	}
	
	public void reverseRecursion(Node ptrOne,Node ptrTwo, Node prevNode){
		
		if(ptrTwo!=null){
			if(ptrTwo.next!=null){
				Node t1 = ptrTwo;
				Node t2 = ptrTwo.next;
				ptrOne.next=prevNode;
				prevNode=ptrOne;
				reverseRecursion(t1,t2,prevNode);
			}else
			{
				ptrTwo.next=ptrOne;
				ptrOne.next=prevNode;
				LinkedListT.display(ptrTwo);
			}
		}else if(ptrOne!=null){
			LinkedListT.display(ptrOne);
		}
	}
}
