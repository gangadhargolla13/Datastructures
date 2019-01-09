package com.java.core.threads;

public class RunnableThreadExample implements Runnable {
public int count = 0;
	
	@Override
	public void run() {
		System.out.println("Runnable thread started");
		try {
              while(count < 5){
            	  Thread.sleep(250);
            	  count++;
              }
		} catch (InterruptedException ie) {

		}
		System.out.println("Runnable thread completed");
	}
}
