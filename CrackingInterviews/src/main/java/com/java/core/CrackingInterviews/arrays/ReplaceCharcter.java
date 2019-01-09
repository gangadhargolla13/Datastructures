package com.java.core.CrackingInterviews.arrays;

public class ReplaceCharcter {

	public static void main(String[] args) {
		String str = "Ben is smart    ";
		char[] sentence = str.toCharArray();
		System.out.println(sentence);
		replace(sentence, 12);
		System.out.println(sentence);
	}
	
	public static void replace(char[] sentence,int length)
	{
		int numSpaces = 0;
		for (int i = 0; i < length; i++) {
			if (sentence[i] == ' ') {
				numSpaces++;
			}
		}
		if (numSpaces > 0) {
			int j = length - 1 + numSpaces * 2; // adds an additional 2 spots for each space.
			for (int i = length - 1; i >= 0; i--) {
				if (sentence[i] == ' ') {
					sentence[j-2] = '%';
					sentence[j-1] = '2';
					sentence[j]   = '0';
					j = j - 3;
				} else {
					sentence[j] = sentence[i];
					j--;
				}
			}
		}
	}
}
