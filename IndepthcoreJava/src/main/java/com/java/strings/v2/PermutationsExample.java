package com.java.strings.v2;

import java.util.HashSet;
import java.util.Set;

public class PermutationsExample {
	public static void main(String[] args) {
		PermutationsExample e =new PermutationsExample();
		System.out.println(e.printPer("abc"));
	}
	public Set<String> printPer(String str) {
		Set<String> set = new HashSet<>();
		if (str == null)
			return null;
		else if (str.length() == 0) {
			set.add("");
			return set;
		}
		char c = str.charAt(0);
		String rem = str.substring(1);
		Set<String> word = printPer(rem);
		for (String s : word) {
			for (int i = 0; i <= s.length(); i++) {
              set.add(padd(s,c,i));
			}
		}
		return set;
	}
	
	public String padd(String s,char c,int j){
		return s.substring(0,j)+c+s.substring(j);
	}
}
