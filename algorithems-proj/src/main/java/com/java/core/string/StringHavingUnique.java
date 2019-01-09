package com.java.core.string;

public class StringHavingUnique {
	private String ip;

	public StringHavingUnique(String ip) {
		this.ip = ip;
	}

	public Boolean UniqueCharSorting() {
		char[] a = ip.toCharArray();
		java.util.Arrays.sort(a);
		String tmp = new String(a);
		for (int i = 1; i < tmp.length(); i++) {
			char t = tmp.charAt(i - 1);
			if (t == tmp.charAt(i)) {
				return false;
			}
		}
		return true;
	}
	
	public Boolean isWellFormed(String strParentheses) {
		if (strParentheses == null) {
			return false;
		}
		
		int openParenCounter = 0;
		int closeParenCounter = 0;
		for (int i = 0; i < strParentheses.length(); i++) {
			char x = strParentheses.charAt(i);
			if (x == '{')
				openParenCounter++;
			else if (x == '}')
				closeParenCounter++;

			if (closeParenCounter > openParenCounter) {
				return false;
			}
		}
		if (openParenCounter == closeParenCounter)
			return true;
		else
			return false;
	}
	public static void main(String[] args) {
	String a = "Sumit_Jain";
	StringHavingUnique u = new StringHavingUnique(a);
	System.out.println("Method 2 : Does String ' " + a
			+ " ' has all unique characters :" + u.UniqueCharSorting());

	a = "Sumit";
	u = new StringHavingUnique(a);
	System.out.println("Method 2 : Does String ' " + a
			+ " ' has all unique characters :" + u.UniqueCharSorting());
	String x1 = "{{{{}}}}{}{}{}{}{}{}{}{}{}{}{{{}}}";
	String x2 = "{{{{}}}}{}{}{}{{}{}{}{}{}{}{}{{{}}}";
	String x3 = "{}{";
	String x4 = "}{";
	String x5 = "{{{{{{{{}}}}}}}}";
	
	System.out.println("Is " + x1 + " well formed ??? :"
			+ u.isWellFormed(x1));
	System.out.println("Is " + x2 + " well formed ??? :"
			+ u.isWellFormed(x2));
	}

}
