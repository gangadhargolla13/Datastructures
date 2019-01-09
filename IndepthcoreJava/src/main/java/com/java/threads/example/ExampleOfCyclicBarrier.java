package com.java.threads.example;

public class ExampleOfCyclicBarrier {
public static void main(String[] args) {
	Ganga g1 = new Ganga(1,"golla");
	Ganga g2 = new Ganga(1,"golla");
	System.out.println(g1==g2);
	System.out.println(g1.equals(g2));
}
}


class Ganga{
	private int id;
	private String name;
	public Ganga(int id,String name){
		this.id=id;
		this.name=name;
	}
}