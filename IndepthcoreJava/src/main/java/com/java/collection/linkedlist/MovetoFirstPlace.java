package com.java.collection.linkedlist;

public class MovetoFirstPlace {
	Node head;

	void moveToFront() {
		if (head == null || head.next == null)
			return;

		Node secLast = null;
		Node last = head;
		while (last.next != null) {
			secLast = last;
			last = last.next;
		}

		secLast.next = null;

		last.next = head;

		head = last;
	}

	public void push(int new_data) {
		Node new_node = new Node(new_data);
		new_node.next = head;
		head = new_node;
	}

	void printList() {
		Node temp = head;
		while (temp != null) {
			System.out.print(temp.data + " ");
			temp = temp.next;
		}
		System.out.println();
	}
	
	void pairWiseSwap()
    {
        Node temp = head;
 
        while (temp != null && temp.next != null) {
            int k = temp.data;
            temp.data = temp.next.data;
            temp.next.data = k;
            temp = temp.next.next;
         }
    }
	
	void deleteAlt()
    {
       if (head == null) 
          return;
 
       Node prev = head;
       Node now = head.next;
 
       while (prev != null && now != null) 
       {           
           /* Change next link of previus node */
           prev.next = now.next;
 
           /* Free node */
           now = null;
 
           /*Update prev and now */
           prev = prev.next;
           if (prev != null) 
              now = prev.next;
       }
    }                 
	
	public static void main(String[] args) {
		MovetoFirstPlace llist = new MovetoFirstPlace();
        llist.push(5);
        llist.push(4);
        llist.push(3);
        llist.push(2);
        llist.push(1);
         
        System.out.println("Linked List before moving last to front ");
        llist.printList();
         
        llist.moveToFront();
         
        System.out.println("Linked List after moving last to front ");
        llist.printList();
        llist.pairWiseSwap();
        llist.printList();
        llist.deleteAlt();
        llist.printList();
	}
}
