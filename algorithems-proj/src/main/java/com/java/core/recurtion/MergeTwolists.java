package com.java.core.recurtion;

public class MergeTwolists {

	private LinkedListT a;
	private LinkedListT b;
	
	public MergeTwolists(LinkedListT a,LinkedListT b){
		this.a=a;
		this.b=b;
	}
	
	public void display(Node head){
		System.out.println("");
		Node cnode = head;
		while(cnode.next!=null){
			System.out.print("->"+cnode.data);
			cnode = cnode.next;
		}
		System.out.println("");
	}
	public Node sort(Node aa,Node bb){
		Node result = null;
		if(aa==null)
			return bb;
		if(bb==null)
			return aa;
		if(aa.data<bb.data){
			result = aa;
			result.next=sort(aa.next,bb);
		}
		else{
			result = bb;
			result.next=sort(aa,bb.next);
		}
		
		return result;
	}
	
	public static void main(String[] args) {
		LinkedListT a = new LinkedListT();
		a.addAtBegin(8);
		a.addAtBegin(6);
		a.addAtBegin(5);
		LinkedListT b = new LinkedListT();
		b.addAtBegin(9);
		b.addAtBegin(7);
		b.addAtBegin(3);
		b.addAtBegin(1);
		MergeTwolists l = new MergeTwolists(a,b);
		Node r = l.sort(a.head,b.head);
		l.display(r);
	}
}



