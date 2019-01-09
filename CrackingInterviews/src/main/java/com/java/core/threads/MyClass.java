package com.java.core.threads;

public class MyClass extends Thread {
	private String name;
	private MyObject myObj;
	
	public MyClass(MyObject obj, String n) {
		name = n;
		myObj = obj;
	}
	
	@Override
	public void run() {
		myObj.foo(name);
	}
}