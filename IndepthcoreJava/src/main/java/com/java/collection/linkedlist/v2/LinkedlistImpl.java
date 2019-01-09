package com.java.collection.linkedlist.v2;

import java.util.Scanner;

public class LinkedlistImpl {
public static void main(String[] args) {
	Scanner scan = new Scanner(System.in);
	LinkedListEx list  = new LinkedListEx();
	System.out.println("Singly Linked List Test\n");          
    char ch;
    /*  Perform list operations  */
    do
    {
        System.out.println("\nSingly Linked List Operations\n");
        System.out.println("1. insert at begining");
        System.out.println("2. insert at end");
        System.out.println("3. insert at position");
        System.out.println("4. delete at position");
        System.out.println("5. check empty");
        System.out.println("6. get size");            
        int choice = scan.nextInt();            
        switch (choice)
        {
        case 1 : 
            System.out.println("Enter integer element to insert");
            list.insertAtstart( scan.nextInt() );                     
            break;                          
        case 2 : 
            System.out.println("Enter integer element to insert");
            list.insertAtend( scan.nextInt() );                     
            break;                         
        case 3 : 
            System.out.println("Enter integer element to insert");
            int num = scan.nextInt() ;
            System.out.println("Enter position");
            int pos = scan.nextInt() ;
            if (pos <= 1 || pos > list.size() )
                System.out.println("Invalid position\n");
            else
                list.insertAtpos(num, pos);
            break;                                          
        case 4 : 
            System.out.println("Enter position");
            int p = scan.nextInt() ;
            if (p < 1 || p > list.size() )
                System.out.println("Invalid position\n");
            else
                list.deletePos(p);
            break;
        case 5 : 
            System.out.println("Empty status = "+ list.isEmpty());
            break;                   
        case 6 : 
            System.out.println("Size = "+ list.size() +" \n");
            break;                         
         default : 
            System.out.println("Wrong Entry \n ");
            break;   
        }
        /*  Display List  */ 
        list.display();
        System.out.println("\nDo you want to continue (Type y or n) \n");
        ch = scan.next().charAt(0);                        
    } while (ch == 'Y'|| ch == 'y'); 
}
}
class LinkedListEx
{
	protected Node head;
	protected Node end;
	public int data;
	public LinkedListEx()
	{
		head = null;
		end = null;
		data = 0;
	}
	public boolean isEmpty()
	{
		return head == null;
	}
	
	public int size()
	{
		return data;
	}
	
	public void insertAtstart(int val)
	{
		Node n = new Node(val,null);
		data++;
		if(head == null)
		{
			head = n;
			end = head;
		}
		else
		{
			n.setLink(head);
			head = n;
		}
	}
	public void insertAtend(int val)
	{
		Node n = new Node(val,null);
		data++;
		if(head == null)
		{
		head= n;
		end = head;
		}
		else
		{
			end.setLink(n);
			end=n;
		}
	}
	public void insertAtpos(int val,int pos)
	{
		Node n = new Node(val,null);
		Node n1 = head;
		pos = pos-1;
		for(int i=0;i<data;i++)
		{
			if(i == pos)
			{
				Node nn = n1.getLink();
				n1.setLink(n);
				n.setLink(nn);
			}
			n1=head.getLink();
		}
		data++;
	}
	public void deletePos(int pos)
	{
		if(pos == 1)
		{
			Node n = head.getLink();
			data++;
			return ;
		}
		if(pos == data)
		{
			Node s = head;
			Node t = head;
			while(s != end){
				t=s;
			s=head.getLink();
			}
			end=t;
			end.setLink(null);
			data--;
			return ;
		}
        Node n = head;
        pos=pos-1;
        for(int i=0;i<data-1;i++)
        {
        if(i == pos){
        	Node tmp = n.getLink();
        	tmp = tmp.getLink();
        	n.setLink(tmp);
        	break;
        }
        n=head.getLink();
        }
        data --;
	}
	
	public void display()
	{
		System.out.println("\n Singly Linked List = ");
		if(data == 0)
		{
			System.out.println("empty\n");
			return ;
		}
		if(head.getLink() == null)
		{
			System.out.println(head.getData());
			return;
		}
		Node n = head;
		System.out.println(head.getData()+"->");
		n=head.getLink();
		while(n.getLink()!=null)
		{
			System.out.println(n.getData()+"->");
			n=n.getLink();
		}
		System.out.println(n.getData()+"\n");
		
	}
	
	public boolean isCyclic()
	{
		Node fast =head;
		Node slow=head;
		while(fast!=null && fast.link!=null)
		{
			fast=fast.link.link;
			slow=slow.link;
			if(fast==slow)
				return true;
		}
		return false;
	}
}
class Node
{
	protected int data;
	protected Node link;
	public Node()
	{
		this.data=0;
		this.link=null;
		
	}
	public Node(int val,Node values)
	{
		data=val;
		link=values;
	}
	public int getData() {
		return data;
	}
	public void setData(int data) {
		this.data = data;
	}
	public Node getLink() {
		return link;
	}
	public void setLink(Node link) {
		this.link = link;
	}
}
