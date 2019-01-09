package com.java.threads.example;

public class DemonThreadExample {
	public static void main(String[] args) {
		DemonThreadExample d = new DemonThreadExample();
		//System.out.println(d.send());
		System.out.println("Gangadhar");
		String sss="Gangadhar";
		d.send1(sss);
		System.out.println(sss);
	}
	
	public void send1(String sss){
		String sss1 = sss;
		System.out.println("called method "+sss1);
		sss = "master";
		System.out.println(sss);
		System.out.println(sss1);
	}
	@SuppressWarnings("finally")
	public String send() {
		DemonThreadExample nn=null;
      try{
    	  nn.hashCode();
    	  return "try block";
      }catch(NullPointerException e){
    	  System.out.println("Gangadhar");
    	  return "NullPointer";
      }finally{
    	  return "Finally block";
      }
	}
}
