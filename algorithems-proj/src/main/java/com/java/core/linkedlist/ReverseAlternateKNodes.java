package com.java.core.linkedlist;

public class ReverseAlternateKNodes {
	public static void main(String[] args) throws java.lang.Exception {
        LinkedListT a = new LinkedListT();
        for (int i = 1; i <= 12; i++) {
            a.addAtEnd(i);
        }
        System.out.print("Original Link List 1 : ");
        a.display(a.head);
        int k = 2;
        System.out.println("\n Recursion with 2k nodes where k = " +k);
        Node n = a.reverseAlter2KNodes(a.head, k);
        a.display(n);
        LinkedListT b = new LinkedListT();
        for (int i = 1; i <= 12; i++) {
            b.addAtEnd(i);
        }
        System.out.print("\nOriginal Link List 2 : ");
        b.display(b.head);
        /*k=3;
        System.out.println("\n Recursion with k nodes where k=" +k);
        n = b.reverseAlterKNodes(b.head, k, true);
        b.display(n);*/
    }
}
class LinkedListT {
    public Node head;

    public LinkedListT() {
        head = null;
    }
    public Node reverseAlter2KNodes(Node head, int k) {
        //process 2K nodes at a time
        //reverse till k nodes and set the the pointer to k+1
        int x = k;
        Node moving = head;
        Node head_prev = null;
        Node head_next = null;
        while (x > 0 && moving != null) {
            head_next = moving.next;
            moving.next = head_prev;
            head_prev = moving;
            moving = head_next;
            x--;
        }
        if (head != null)
            head.next = moving;
        x = k;
        while (x > 1 && moving != null) {
            moving = moving.next;
            x--;
        }
        if (moving != null) {
            moving.next = reverseAlter2KNodes(moving.next, k);
        }

        return head_prev;
    }

    public void addAtEnd(int data) {
        Node n = new Node(data);

        if (head == null) {
            n.next = head;
            head = n;
        } else {
            Node currNode = head;
            while (currNode.next != null) {
                currNode = currNode.next;
            }
            currNode.next = n;
        }
    }

    public void display(Node head) {
        Node currNode = head;
        while (currNode != null) {
            System.out.print("->" + currNode.data);
            currNode = currNode.next;
        }
    }
}

