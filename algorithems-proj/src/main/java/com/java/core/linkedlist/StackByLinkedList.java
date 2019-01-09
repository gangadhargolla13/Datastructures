package com.java.core.linkedlist;

public class StackByLinkedList {

	Node head= null;
    int size =0;
    public void push(int data){
        Node x = new Node(data);
        if(getSize()==0){
            head = x;
        }else{
            Node temp = head;
            x.next = temp;
            head = x;
        }
        System.out.println("Element "+ data + " is pushed into Stack");
        size++;
    }
    public int pop(){
        if(getSize()==0){
            System.out.println("Stack is Empty");
            return -1;
        }else{
            Node temp = head;
            head = head.next;
            size--;
            return temp.data;
        }

    }
    public void printStack(){
        Node curr = head;
        while(curr!=null){
            System.out.print(curr.data + " ");
            curr = curr.next;
        }
        System.out.println();
    }
    public int getSize(){
        return size;
    }
    
    public int peek()
    {
    	if(getSize()>0)
    		return head.data;
    	else
    		return -1;
    }
    public static void main(String[] args) {
    	StackByLinkedList stck = new StackByLinkedList();
        stck.push(1);
        stck.push(2);
        stck.push(4);
        stck.printStack();
        System.out.println("Peek the element "+stck.peek());
        System.out.println("Pop out element " + stck.pop());
        stck.printStack();
    }
}
