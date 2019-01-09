package com.java.core.moderate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class T9 {

	private static HashMap<Character, Character> letterToDigit = new HashMap<>();

	static { // static initializer block
		for (char ch = 'a'; ch <= 'c'; ch++)
			letterToDigit.put(ch, '2');
		for (char ch = 'd'; ch <= 'f'; ch++)
			letterToDigit.put(ch, '3');
		for (char ch = 'g'; ch <= 'i'; ch++)
			letterToDigit.put(ch, '4');
		for (char ch = 'j'; ch <= 'l'; ch++)
			letterToDigit.put(ch, '5');
		for (char ch = 'm'; ch <= 'o'; ch++)
			letterToDigit.put(ch, '6');
		for (char ch = 'p'; ch <= 's'; ch++)
			letterToDigit.put(ch, '7');
		for (char ch = 't'; ch <= 'v'; ch++)
			letterToDigit.put(ch, '8');
		for (char ch = 'w'; ch <= 'z'; ch++)
			letterToDigit.put(ch, '9');
	}

	public static HashMap<String, List<String>> buildMap(String[] words) {
		HashMap<String, List<String>> map = new HashMap<>();
		for (String word : words) {
			String number = getNumber(word);
			map.putIfAbsent(number, new ArrayList<>());
			List<String> listOfWords = map.get(number);
			listOfWords.add(word);
		}
		return map;
	}

	private static String getNumber(String str) {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < str.length(); i++) {
			char ch = letterToDigit.get(str.charAt(i));
			sb.append(ch);
		}
		return sb.toString();
	}

	private static String[] words = { "tree", "used", "ace", "bee", "bed", "tape", "mouse", "pan", "ran", "ninja",
			"ninjas" };

	public static void main(String[] args) {
		System.out.println("*** Test 16.20: T9 - HashMap Solution\n");
		HashMap<String, List<String>> map = T9.buildMap(words);
		System.out.println("Matching words: ");
		for (String word : map.get("8733")) {
			System.out.println(word);
		}
	}
}
