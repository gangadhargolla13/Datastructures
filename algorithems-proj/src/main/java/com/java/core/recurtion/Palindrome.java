package com.java.core.recurtion;

public class Palindrome {

	public static void main(String[] args) {
		String S1 = "Sumit";
		String S4 = "Jain niaJ";
		Palindrome p = new Palindrome();
		System.out.println("Is " + S1 + " Palindrome ??? :"
				+ p.palindrome(S1));
		System.out.println("Is " + S4 + " Palindrome ??? :"
				+ p.palindrome(S4));
	}
	
	public  boolean palindrome(String x){
		if(x.length()<2)
			return true;
		if(x.charAt(0)==x.charAt(x.length()-1))
			return palindrome(x.substring(1, x.length()-1));
		else
			return false;
	}
}
