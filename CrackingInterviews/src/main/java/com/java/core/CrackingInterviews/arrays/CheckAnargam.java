package com.java.core.CrackingInterviews.arrays;

public class CheckAnargam {

	public static void main(String[] args) {
		System.out.println(checkAnargam("hello", "olhel"));
		System.out.println(checkAnargam("james", "bean"));
	}
	public static boolean checkAnargam(String s,String s1){
		if (s1.length() != s.length()) {
			return false;
		}
		int[] letters = new int[256]; 
		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			letters[ch]++;
		}
		for (int i = 0; i < s1.length(); i++) {
			char ch = s1.charAt(i);
			if (--letters[ch] < 0) {
				return false;
			}
		}
		return true;
	}
	
}
