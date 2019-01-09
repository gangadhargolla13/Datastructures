package com.java.core.threads;

public class MyThread extends Thread {
	private String method;
	private CallInOrder foo;

	public MyThread(CallInOrder foo, String method) {
		this.method = method;
		this.foo = foo;
	}

	@Override
	public void run() {
		if (method == "first") {
			foo.first();
		} else if (method == "second") {
			foo.second();
		} else if (method == "third") {
			foo.third();
		}
	}
}
