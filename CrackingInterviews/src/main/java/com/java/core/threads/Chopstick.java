package com.java.core.threads;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Chopstick {

	public Lock lock;
	
	public Chopstick(){
		this.lock= new ReentrantLock();
	}
	public boolean pickUp()
	{
		return lock.tryLock();
	}
	
	public void putDown()
	{
		lock.unlock();
	}

}
