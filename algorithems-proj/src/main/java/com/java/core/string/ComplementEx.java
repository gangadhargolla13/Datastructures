package com.java.core.string;

public class ComplementEx {

	public static void main(String[] args) {
		int i = 22;
		int ones = (Integer.highestOneBit(i) << 1) - 1;
	    int hh= i ^ ones;
	    System.out.println(hh);
		/*String binaryString = Integer.toBinaryString(100);
		String temp = "";
		for(char c: binaryString.toCharArray()){
		      if(c == '1'){
		          temp += "0";
		      }
		      else{
		          temp += "1";
		      }
		  }
		int base = 2;
		  int complement = Integer.parseInt(temp, base);
		  System.out.println(complement);*/
	}
}
