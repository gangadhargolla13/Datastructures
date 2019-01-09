package com.java.core.moderate;

import java.util.HashMap;

public class MasterMind {

	public static Result estimate(String guess, String solution) {
		if (guess.length() != solution.length()) {
			return null;
		}
		guess    = guess.toLowerCase();
		solution = solution.toLowerCase();
		
		Result result = new Result();
		HashMap<Character, Integer> colorMap = new HashMap<>();
		
		/* Count direct hits, while saving non-directHit colors in a HashMap, which will later help us count pseudohits */
		for (int i = 0; i < solution.length(); i++) {
			char solChar = solution.charAt(i);
			char guessChar = guess.charAt(i);
			if (solChar == guessChar) {	// direct "hit"
				result.directHits++;
			} else {
				colorMap.merge(solChar, 1, Integer::sum);
			}
		}
		
		/* Count pseudohits in HashMap */
		for (int i = 0; i < guess.length(); i++) {
			char solChar   = solution.charAt(i);
			char guessChar = guess.charAt(i);
			if (solChar == guessChar) {
				continue;
			}
			if (colorMap.containsKey(guessChar)) {
				int count = colorMap.get(guessChar);
				if (count > 0) {
					result.pseudoHits++;
					colorMap.put(guessChar, count - 1);
				}
			}
		}
		return result;
	}
	public static void main(String[] args) {
		System.out.println("*** Test 16.15: Master Mind");
		test("RGBY", "GGRR");
		test("RRRG", "GGRR");
		test("YYBY", "BBBB");
	}
	
	private static void test(String s1, String s2) {
		System.out.format("\nSolution = %s\nGuess    = %s\n%s\n", s1, s2, MasterMind.estimate(s1, s2));
	}
}

class Result {
	int directHits = 0;
	int pseudoHits = 0;
	
	@Override
	public String toString() {
		return ("(Direct Hits, Pseudo Hits) = (" + directHits + "," + pseudoHits + ")");
	}
}
