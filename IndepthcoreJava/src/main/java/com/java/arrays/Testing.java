package com.java.arrays;

public enum Testing {
	HIGH("name", 123), LOW("initial", 23), MEADIUM("latest", 34);
	String a;
	int val;

	Testing(String name, int age) {
		System.out.println("Constructor is called");
		this.a = name;
		this.val = age;
	}
	
	public static void main(String[] args) {
		for(Testing t : Testing.values())
		{
			System.out.println(t.a+"--->"+t.val);
		}
	}
}
