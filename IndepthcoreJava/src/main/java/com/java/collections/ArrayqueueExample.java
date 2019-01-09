package com.java.collections;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ArrayqueueExample {

	public static void main(String[] args) {
		BlockingQueue<Object> queue = new ArrayBlockingQueue<>(10);
		queue.add(Integer.valueOf(12));
		queue.add(Integer.valueOf(56));
		queue.add(Integer.valueOf(98));
		queue.add(Integer.valueOf(22));
		queue.add(Integer.valueOf(526));
		queue.add(Integer.valueOf(982));
		queue.add(Integer.valueOf(112));
		queue.add(Integer.valueOf(6));
		queue.add(Integer.valueOf(9));
		queue.add(Integer.valueOf(19));
		System.out.println(queue);
		Thread tr1 = new Thread(new Sequential());
		Thread tr2 = new Thread(new Sequential());
		tr1.start();
		tr2.start();
	}
}

class Sequential implements Runnable{

	@Override
	public void run() {
		
		
	}
	
}
