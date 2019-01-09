package com.java.threads.example;

import java.util.concurrent.CountDownLatch;

// A CountDownLatch is a concurrent operation that allows one or more threads waits for a set of operation to complete.
public class ExampleOfCoutDownLatch {

	public static void main(String[] args) throws Exception{
		CountDownLatch latch = new CountDownLatch(3);
		Waiter      waiter      = new Waiter(latch);
		Decrementer decrementer = new Decrementer(latch);

		new Thread(waiter)     .start();
		new Thread(decrementer).start();

		Thread.sleep(4000);
	}
}
class Waiter implements Runnable{

    CountDownLatch latch = null;

    public Waiter(CountDownLatch latch) {
        this.latch = latch;
    }

    public void run() {
        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Waiter Released");
    }
}

class Decrementer implements Runnable {

    CountDownLatch latch = null;

    public Decrementer(CountDownLatch latch) {
        this.latch = latch;
    }

    public void run() {

        try {
            Thread.sleep(1000);
            this.latch.countDown();

            Thread.sleep(1000);
            this.latch.countDown();

            Thread.sleep(1000);
            this.latch.countDown();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}