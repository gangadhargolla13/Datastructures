package com.java.threads.example2;

import java.util.LinkedHashMap;
import java.util.Map;

public class BasicsExamples {
	/*
	 * static { Verification v1 = new Verification("first"); Verification v2 =
	 * new Verification("second"); v1.start(); v2.start(); }
	 */
	Runnable run = () -> System.out.println("I am called");

	public static void main(String[] args) {
		Map<String,Integer> map = new LinkedHashMap<>();
		System.out.println(Thread.currentThread().getName());
		Verification v1 = new Verification("first");
		Verification v2 = new Verification("second");
		v1.setPriority(Thread.MIN_PRIORITY);
		v1.setPriority(Thread.MAX_PRIORITY);
		v1.start();
		v2.start();
		/*
		 * try { System.out.println("Current Thread: " +
		 * Thread.currentThread().getName()); v1.join(); }
		 * 
		 * catch(Exception ex) { System.out.println("Exception has " +
		 * "been caught" + ex); }
		 */
		// v2.start();
		/*
		 * v1.run(); System.out.println(v1.isAlive());
		 * v1.getState().RUNNABLE.name();
		 */
		// v1.stop();
		// v1.resume();
	}
}

class Verification extends Thread {
	private String name;

	public Verification(String name) {
		this.name = name;
	}

	public void run() {
		// System.out.println(Thread.currentThread().getName()+" is executing");
		try {
			int m = 1;
			while (m <= 10) {
				Thread.sleep(500);
				System.out.println(name + " " + m);
				m++;
				Thread.yield();
			}
		} catch (Exception e) {

		}
	}
}

class Demonistation implements Runnable {

	static {
		System.out.println("I am fine");
	}

	@Override
	public void run() {
		calculations();
	}
	public static synchronized void calculations() {
		try {
			synchronized(Demonistation.class)
			{
				Thread.sleep(500);
			}
			System.out.println("It's a complete block chacking");
		} catch (Exception e) {
			System.out.println("I am very fine!");
		}
	}
	
	public static void calculations(String name ) {
		try {
			synchronized(Demonistation.class)
			{
				Thread.sleep(500);
			}
			System.out.println("It's a complete block chacking");
		} catch (Exception e) {
			System.out.println("I am very fine!");
		}
	}
	
	public  void calculations(int name ) {
		//this.wait();
		try {
			synchronized(this)
			{
				Thread.sleep(500);
			}
			System.out.println("It's a complete block chacking");
		} catch (Exception e) {
			System.out.println("I am very fine!");
		}
	}
	
	public synchronized void calculations(float name ) {
		try {
				Thread.sleep(500);
			System.out.println("It's a complete block chacking");
		} catch (Exception e) {
			System.out.println("I am very fine!");
		}
	}
}