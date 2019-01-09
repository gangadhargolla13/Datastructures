package com.java.core.graph;

public class InnerClassImpl {

	public static void main(String[] args) {
		InnerClassImpl im = new InnerClassImpl();
		im.checking(new Master(){

			@Override
			public void testing() {
				testing12();
              System.out.println("I am done of my house");				
			}
			
			public void testing12() {
	              System.out.println("I am not of my house");				
				}
		});
	}
	
	public void checking(Master m){
		System.out.println("I am checking with master!");
		m.testing();
	}
	
	public String checking(int m){
		System.out.println("I am checking with master!");
		//m.testing();
		return "";
	}
}
