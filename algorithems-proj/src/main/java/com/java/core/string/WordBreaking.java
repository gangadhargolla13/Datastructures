package com.java.core.string;

import java.util.HashSet;

public class WordBreaking {

	public static void main(String[] args) {
		String str = "thisissumitjain12this";
		HashSet<String> hs = new HashSet<String>();
hs.add("this");hs.add("is");hs.add("sumit");hs.add("jain");hs.add("the");hs.add("problem");
		WordBreaking break1 = new WordBreaking();
        //break1.wordBreak(str, hs);
		break1.findUsingDP(str, hs, new HashSet(), "");
	}

	public void wordBreak(String s, HashSet<String> hs) {
		if (find(s, hs, "")) {
			System.out.println("can break");
		} else {
			System.out.println("Cant Break");
		}
	}

	public boolean find(String s, HashSet<String> dict, String answer) {
		if (s.length() == 0) {
			System.out.println(answer);
			return true;
		} else {
			int index = 0;
			String word = "";
			while (index < s.length()) {
				word += s.charAt(index);
				if (dict.contains(word)) {
					if (find(s.substring(index + 1), dict, answer + word + " ")) {
						return true;
					} else
						index++;
				} else
					index++;
			}
			return false;
		}
	}
	
	public boolean findUsingDP(String s, HashSet<String> dict,
			HashSet<String> memory, String answer) {
		if (s.length() == 0) {
			System.out.println(answer);
			return true;
		} else if (memory.contains(s)) {
			return false;
		} else {
			int index = 0;
			String word = "";
			while (index < s.length()) {
				word += s.charAt(index);
				if (dict.contains(word)) {
					if (findUsingDP(s.substring(index + 1), dict, memory,
							answer + word + " ")) {
						return true;
					} else {
						System.out.println("backtrack");
						index++;
					}
				} else {					
					index++;
				}
			}
			memory.add(s);
			return false;
		}
	}
}
