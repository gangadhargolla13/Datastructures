package com.java.collection.linkedlist;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class QueueImplemantation {

	public static void main(String[] args) throws Exception{
		BufferedReader obj=new BufferedReader(new InputStreamReader(System.in));
        int ch,x;
        Queuemain que=new Queuemain();
        do
        {
            System.out.println("##MENU##");
            System.out.println("1.Insert element in queue");
            System.out.println("2.Remove element from queue");
            System.out.println("3.Peek Element in queue");
            System.out.println("4.Display queue");
            System.out.println("5.Exit");
            System.out.println("Enter your choice");
            ch=Integer.parseInt(obj.readLine());
            switch(ch)
            {
                case 1:System.out.println("Enter element to be inserted");
                    x=Integer.parseInt(obj.readLine());
                    que.enqueue(x);
                    break;
                case 2:System.out.println("Removed element:"+que.dequeue());
                    break;
                case 3:System.out.println("Peeked element:"+que.peek());
                    break;
                case 4:que.display();
                    break;
            }
        }while(ch!=5);
	}
}

class Node1
{
    int data;
    Node1 next;
    public Node1(int x)
    {
        data=x;
        next=null;
    }
}
class Queuemain
{
	Node1 f=null,l=null;
    public boolean isEmpty()
    {
        if (f==null || l==null)
            return true;
        else
            return false;
    }
    public void enqueue(int x)
    {
        if (isEmpty()==true)
        {
        	Node1 p=new Node1 (x);
            f=l=p;
        }
        else
        {
        	Node1 p=new Node1 (x);
            l.next=p;
            l=p;
        }
    }
    public int dequeue()
    {
        if(isEmpty()==true)
        {
            System.out.println("Queue is Empty");
            return -1;
        }
        else
        {
            int x=f.data;
            f=f.next;
            return x;
        }
    }
    public int peek()
    {
        if(isEmpty()==true)
        {
            System.out.println("Queue is Empty");
            return -1;
        }
        else
        {
            return(f.data);
        }
    }
    public void display()
    {
        if(isEmpty()==true)
        {
            System.out.println("Queue is Empty");
        }
        else
        {
        	Node1 temp=f;
            while (temp!=null)
            {
                System.out.print(temp.data+" ");
                temp=temp.next;
            }
        }
    }
}