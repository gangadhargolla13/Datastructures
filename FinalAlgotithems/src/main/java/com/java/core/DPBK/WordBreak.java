package com.java.core.DPBK;

import java.util.HashSet;

public class WordBreak {

	public static void main(String[] args) {
		HashSet<String> hs = new HashSet<String>();
		hs.add("this");
		hs.add("is");
		hs.add("sumit");
		hs.add("jain");
		hs.add("the");
		hs.add("problem");
		String s = "thisissumitjain";
		WordBreak wb = new WordBreak();
		HashSet<String> mem = new HashSet<String>();
		wb.findDp(hs, s, mem, "");
	}

	public boolean findDp(HashSet<String> d, String s, HashSet<String> m, String a) {
		if (s.length() == 0) {
			System.out.println(a);
		} else if (m.contains(s))
			return false;
		else {
			int in = 0;
			String word = "";
			while (in < s.length()) {
				word += s.charAt(in);
				if (d.contains(word)) {
					if (findDp(d, s.substring(in + 1), m, a + word + " ")) {
						return true;
					} else {
						in++;
					}
				} else
					in++;
			}
		}
		m.add(s);
		System.out.println(a);
		return false;
	}
}
