package com.java.amazon.inter;

import java.util.HashSet;


public class WordBreak {

	public boolean findUsingDp(String s,HashSet<String> set,HashSet<String> memory,String jans)
	{
		if (s.length() == 0) {
			System.out.println(jans);
			return true;
		} else if (memory.contains(s)) {
			return false;
		}else {
			int index = 0;
			String word = "";
			while(index < s.length()-1){
				word += s.charAt(index);
				if (set.contains(word)) {
					if (findUsingDp(s.substring(index + 1), set, memory,
							jans + word + " ")) {
						return true;
					} else {
						System.out.println("backtrack");
						index++;
					}
				} else {					
					index++;
				}
			}
			memory.add(s);// memoization for future;
			System.out.println(memory);
			return false;
		}
		
	}
	public static void main(String[] args) {
		HashSet<String> hs = new HashSet<String>();
		hs.add("this");
		hs.add("is");
		hs.add("sumit");
		hs.add("jain");
		hs.add("the");
		hs.add("problem");
		String s = "thisissumitjain";
		
		WordBreak ws = new WordBreak();
		HashSet<String> memoization = new HashSet<String>();
		boolean d = ws.findUsingDp(s, hs, memoization, "");
		System.out.println(d);
	}
}
