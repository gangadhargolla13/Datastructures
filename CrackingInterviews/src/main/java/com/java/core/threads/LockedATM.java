package com.java.core.threads;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockedATM {

	private Lock lock;
	private int balance = 100;

	public LockedATM() {
		this.lock = new ReentrantLock();
	}

	public int withDraw(int value) {
		lock.lock();
		int temp = balance;
		try {
			Thread.sleep(100);
			temp = temp - value;
			Thread.sleep(100);
			balance = temp;
		} catch (InterruptedException ie) {

		}
		lock.unlock();
		return temp;
	}
	
	public int deposit(int value){
		lock.lock();
		int temp = balance;
		try{
			Thread.sleep(100);
			temp = temp+value;
			Thread.sleep(100);
			balance = temp;
		}catch(InterruptedException iw)
		{
			
		}
		lock.unlock();
		return temp;
	}
	
	public int getBalance()
	{
		return balance;
	}
}
