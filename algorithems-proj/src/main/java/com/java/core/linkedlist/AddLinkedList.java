package com.java.core.linkedlist;

public class AddLinkedList {
	public int carry=0;
    public Node newHead = null;
	public static void main(String args[]){
		AddLinkedList l = new AddLinkedList();
        Node h1 = new Node(1);
        h1.next= new Node(1);
        h1.next.next = new Node(1);
        h1.next.next.next = new Node(7);
        System.out.print("First Number : ");
        l.display(h1);
        Node h2 = new Node(9);
        h2.next= new Node(9);
        h2.next.next = new Node(9);
        h2.next.next.next = new Node(9);
        System.out.print("\n Second Number : ");
        l.display(h2);
        Node x = l.add(h1, h2);
        System.out.print("\n Addition : ");
        l.display(x);
    }
	
	public int getLength(Node head){
        int len=0;
        while(head!=null){
            len++;
            head = head.next;
        }
        return len;
    }
    public void display(Node head){
        Node currNode = head;
        while(currNode!=null){
            System.out.print("->" + currNode.data);
            currNode=currNode.next;
        }
    }
    public Node add(Node h1, Node h2){
        //first we will make sure that both the Linked list has same no of nodes
        // to ensure that we will append 0 in front of shorter list
        int h1Len = getLength(h1);
        int h2Len = getLength(h2);
        if(h1Len>h2Len){
            int diff = h1Len-h2Len;
            while(diff>0){
                Node n = new Node(0);
                n.next = h2;
                h2=n;
                diff--;
            }
        }
        if(h1Len<h2Len){
            int diff = h2Len-h1Len;
            while(diff>0){
                Node n = new Node(0);
                n.next = h1;
                h1=n;
                diff--;
            }
        }
        Node newHead = addBackRecursion(h1, h2);
        //check for the carry forward, if not 0 then we need to create another node for the end
        //example adding 1->1 and 9->9 then recursive function will return 0->0 and carry =1
        if(carry!=0){
            Node n = new Node(carry);
            n.next = newHead;
            newHead = n;
        }
        return newHead;
    }
    public Node addBackRecursion(Node h1, Node h2){
        if(h1==null && h2==null){
            return null;
        }
        addBackRecursion(h1.next, h2.next);
        int a = h1.data + h2.data + carry;
        carry=0;
        //System.out.println(a);
        if(a>=10){
            carry =1;
            a = a%10;
        }
        Node n = new Node(a);
        if(newHead==null){
            newHead =n;
        }else{
            n.next = newHead;
            newHead = n;
        }
        //carry=0;
        return newHead;
    }
}
