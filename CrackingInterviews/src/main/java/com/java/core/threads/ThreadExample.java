package com.java.core.threads;

public class ThreadExample  extends Thread{

	public int count=0;
	
	public void run(){
		System.out.println("Thread example started");
		try{
			while(count < 5){
				Thread.sleep(500);
			}
		}catch(InterruptedException ie){
			System.out.println("Exception is occured");
		}
		System.out.println("Thread opetation is completd");
	}
}
