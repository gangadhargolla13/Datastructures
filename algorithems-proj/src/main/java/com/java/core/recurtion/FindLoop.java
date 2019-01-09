package com.java.core.recurtion;

public class FindLoop {

	public LinkedListT a;
	public int len;
	
	public void createLoop(){
		a = new LinkedListT();
		a.addAtEnd(10);
		a.addAtEnd(20);
		a.addAtEnd(30);
		a.addAtEnd(40);
		a.addAtEnd(50);
		a.addAtEnd(60);
		a.insertLoop(2);
		a.displayLoop();
	}
	
	public static void main(String[] args) {
		FindLoop l = new FindLoop();
		l.createLoop();
	}
	
	public void findLoop(){
		Node one = a.head;
		Node two = a.head.next.next;
		while(one!=null){
			if(one!=two){
				one=one.next;
				two=two.next.next;
			}
			else{
				System.out.println("");
				System.out.println("Loop is found "+one.data);
				findLoopLength(one,two);
				breakLoop(one,two);
				break;
			}
		}
	}
	
	public void findLoopLength(Node on,Node tw){
		on=on.next;
		len=1;
		while(on!=tw){
			on=on.next;
			len++;
		}
	  System.out.println("Loop length "+len);
	}
	
	public void breakLoop(Node on,Node tw){
		on=on.next;
		while(on.next!=tw){
			on=on.next;
		}
		on.next=null;
		System.out.println("Loop breaks");
		a.display(a.head);
	}
}
