package com.java.core.hard;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.HashSet;

public class WordTransformer {
	
	private static HashSet<String> dict = new HashSet<>();
	
	public static void setUpDict() {
		dict.add("DAMP");
		dict.add("LAMP");
		dict.add("LIMP");
		dict.add("LIME");
		dict.add("LIKE");
	}
	
	/* Uses BFS */
	public static ArrayDeque<String> convert(String start, String end) {
		if (start == null || end == null || start.length() != end.length()) {
			return null;
		}
		
		start = start.toUpperCase();
		end   = end.toUpperCase();
		
		ArrayDeque<String> deque             = new ArrayDeque<>(); // use deque as a queue
		HashSet<String> visited              = new HashSet<>();
		HashMap<String, String> backtrackMap = new HashMap<>();
		
		deque.add(start);
		visited.add(start);
		
		while (!deque.isEmpty()) {
			String currWord = deque.remove();
			if (currWord.equals(end)) {
				return buildSolution(backtrackMap, currWord);
			}
			for (String neighbor : getNeighbors(currWord)) {
				if (!visited.contains(neighbor)) {
					visited.add(neighbor);
					backtrackMap.put(neighbor, currWord);
					deque.add(neighbor);
				}
			}
		}
		return null;
	}
	
	/* Generates all possible neighbors of given String */
	private static HashSet<String> getNeighbors(String str) { // O(n) runtime where "n" is length of String
		HashSet<String> validWords = new HashSet<>();
		for (int i = 0; i < str.length(); i++) {
			char origChar = str.charAt(i);
			for (char currChar = 'A'; currChar <= 'Z'; currChar++) {
				if (currChar != origChar) {
					StringBuffer neighbor = new StringBuffer(str);
					neighbor.setCharAt(i, currChar);
					if (dict.contains(neighbor.toString())) {
						validWords.add(neighbor.toString());
					}
				}
			}
		}
		return validWords;
	}
	
	private static ArrayDeque<String> buildSolution(HashMap<String, String> backtrackMap, String currWord) {
		ArrayDeque<String> solution = new ArrayDeque<>();
		solution.add(currWord);
		while (backtrackMap.containsKey(currWord)) {
			currWord = backtrackMap.get(currWord);
			solution.addFirst(currWord);
		}
		return solution;
	}
	
	public static void main(String[] args) {
		System.out.println("*** Test 17.22: Word Transformer\n");
		WordTransformer.setUpDict();
		test("Damp", "Like");
	}
	
	private static void test(String s1, String s2) {
		ArrayDeque<String> solution = WordTransformer.convert(s1, s2);
		System.out.println(solution);
	}
}
