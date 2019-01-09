package com.java.core.linkedlist;

public class SeperationOfList 
{
	public static void main(String[] args) {
		System.out.println("I am gangadhar");
		try
		{
		Integer.parseInt("8366794635833561000");
		}catch(NumberFormatException e)
		{
			Long.parseLong("8366794635833561000");
		}
	}
	/*static LNode nodeA;
	static LNode nodeB;
	static LNode head;
	public static void main(String[] args) {
		 head = new LNode(1);
		head.next= new LNode(2);
		head.next.next=new LNode(3);
		head.next.next.next=new LNode(4);
		head.next.next.next.next=new LNode(5);
		reference(head,null,null);
		print(nodeA);
		print(nodeB);
		LNode a=null; LNode b=null;
		alternative(head,a,b);
		LNode[] aa = AlternatingSplit(head);
		print(aa[0]);
		print(aa[1]);
	}*/
	
	static void print(LNode head){
		while(head!=null)
		{
			System.out.println(head.data);
			head=head.next;
		}
		System.out.println(head);
	}
	
	static void alternative(LNode head,LNode a,LNode b)
	{
		LNode cu = head;
		a=cu;
		b=cu.next;
		move(a,b);
		print(a);
		print(b);
	}
	
	static void move(LNode a,LNode b)
	{
		if(a==null || b==null)
		{
			return ;
		}
		if(a.next!=null)
		{
			a.next=a.next.next;
		}
		if(b.next!=null)
		{
			b.next=b.next.next;
		}
		move(a.next,b.next);
	}
	
	public static LNode[] AlternatingSplit(LNode source)
    {
        LNode a = null;
        LNode b = null;
        LNode current = source;

        while (current != null)
        {
            LNode newNode = current;    
            current = current.next;    

            newNode.next = a;        
            a = newNode;            

            if (current != null) {
               

                newNode = current;    
                current = current.next;    

                newNode.next = b;        
                b = newNode;            
            }
        }

        return new LNode[] { a, b };
    }
}
