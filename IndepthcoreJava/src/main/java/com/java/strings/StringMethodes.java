package com.java.strings;

public class StringMethodes {

	public static void main(String[] args) {
		String str = "This is a String.";
		char[] arr = new char[str.length()];
		str.getChars(1, 10, arr, 1);
		System.out.println(arr);
		
		String str1 = "Missouri Florida Colorado Washington";
        String str2 = "washington colorado florida missouri";
        System.out.println(str1.length());
        boolean match1 = str1.regionMatches(true, 0, str2, 28, 6);
        boolean match2 = str1.regionMatches(true, 9, str2, 9, 8);
        System.out.println("str1[0 - 7] == str2[28 - 35]? " + match1);
        System.out.println("str1[9 - 15] == str2[9 - 15]? " + match2);
        String ganga = str1.substring(4, 12);
        System.out.println(ganga);
	}
}
