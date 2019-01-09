package com.java.core.linkedlist;

public class LoopDetection {
	public static Node findBeginning(Node head) {
		Node slow = head; // moves at normal speed
		Node fast = head; // moves at double speed

		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if (slow == fast) { // they collided
				break;
			}
		}

		/*
		 * Error Check - Detects if no loop was found. Don't forget this step!
		 */
		if (fast == null || fast.next == null) {
			return null;
		}

		/*
		 * Put "slow2" at head of list. Move "slow" and "slow2" 1 step at a
		 * time. They collide at head of cycle
		 */
		Node slow2 = head;
		while (slow2 != slow) {
			slow = slow.next;
			slow2 = slow2.next;
		}
		return slow;
	}
	
	public static void main(String[] args) {
		System.out.println("*** Test 2.8: Loop Detection\n");
		Node a1 = new Node(1);
		Node a2 = new Node(2); // will be beginning of loop.
		Node a3 = new Node(3);
		Node a4 = new Node(4);
		a1.next = a2;
		a2.next = a3;
		a3.next = a4;
		a4.next = a2; // a4 points to beginning of loop (a2).
		test(a1);
	}

	private static void test(Node head) {
		Node loopBeginning = LoopDetection.findBeginning(head);
		System.out.println("Loop Beginning Value (Should be 2): " + loopBeginning.data);
	}
}
