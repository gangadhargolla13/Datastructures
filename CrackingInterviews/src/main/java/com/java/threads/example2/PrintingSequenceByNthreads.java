package com.java.threads.example2;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class PrintingSequenceByNthreads {
	public static void main(String[] args) {
	  Worker w1 = new Worker();
      Worker w2 = new Worker();
      Worker w3 = new Worker();
      w1.setNext(w2);
      w2.setNext(w3);
      w3.setNext(w1);
      Thread t1 = new Thread(w1, "Thread-1 - ");
      Thread t2 = new Thread(w2, "Thread-2 - ");
      Thread t3 = new Thread(w3, "Thread-3 - ");
      t1.start();
      t2.start();
      t3.start();
      w1.accept(1);
	}
}

class Worker implements Runnable {
	BlockingQueue<Integer> q = new LinkedBlockingQueue<Integer>();
	Worker next = null; // next worker in the chain

	public void setNext(Worker t) {
		this.next = t;
	}

	public void accept(int i) {
		q.add(i);
	}

	@Override
	public void run() {
		while (true) {
			try {
				int i = q.take();
				System.out.println(Thread.currentThread().getName() + " " + i);
				if (i > 10) {
					Thread.currentThread().stop();
					break;
				}
				Thread.sleep(1000);
				if (next != null) {
					next.accept(i + 1);
				}
			} catch (InterruptedException ie) {
                  System.out.println("The Exception is occured!");
			}
		}
	}
}
