package com.java.core.CrackingInterviews.arrays;

import java.util.HashSet;

public class FindUniqueChar {

	public static void main(String[] args) {
		String str = "I am gangadhar how are";
		HashSet<Character> set = new HashSet<>();
		for(int i=0;i<str.length();i++){
			if(set.contains(str.charAt(i)))
			{
				continue;
			}
			else
				set.add(str.charAt(i));
		}
		System.out.println(set);
	}
}
