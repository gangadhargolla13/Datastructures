package com.java.innerclass;

public class InnerclassExample {

	public static void main(String[] args) {
		InnerclassExample ex =new InnerclassExample();
		ex. new Testing().valprint();
		Testing1.valprint();
	}
	
	private static int vals = 0;
	public class Testing {
		int v = vals;
		public void valprint(){
			System.out.println("The value of instance");
		}
	}
	
	public static class Testing1 {
		int v = vals;
		public static void valprint(){
			System.out.println("The values of static");
		}
	}
	
}
