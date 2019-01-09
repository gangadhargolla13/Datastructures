package com.java.core.first;

import java.util.PriorityQueue;

public class ExampleQueue {

	static PriorityQueue<Integer> p = new PriorityQueue<>();
	
	public static void main(String[] args) {
		p.offer(12);
		p.offer(32);
		p.offer(2);
		p.offer(8);
		System.out.println(p);
		System.out.println(p.poll());
		System.out.println(p);
		p.add(1);
		System.out.println(p.peek());
	}
}
