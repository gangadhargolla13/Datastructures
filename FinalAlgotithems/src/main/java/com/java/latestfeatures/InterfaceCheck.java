package com.java.latestfeatures;

public class InterfaceCheck {

	public static void main(String[] args) {
		//Class<Object> c = Class.forName("com.java.latestfeatures.Function3");
		//Function3 er = Function3.class.newInstance();
		ClassLoader load = Thread.currentThread().getContextClassLoader();
		
	}
}

// @FunctionalInterface
interface Function {
	default void testing() {
		System.out.println("I am gangadhar");
	}

	static String testing(String name) {
		System.out.println("I am gangadhar");
		return null;
	}
}

interface Function1 {
	default void testing() {
		System.out.println("I am gangadhar");
	}

	static String testing(String name) {
		System.out.println("I am ganesh");
		return null;
	}
}

interface Function2 extends Function1, Function {

	@Override
	default void testing() {
		Function.super.testing();
	}

}

class Function3 implements Function2, Function1, Function {

}