package com.java.strings;

public class SumationofStrings {

	public static void main(String[] args) {
		String str = "23sd87iu9";
		String str1 = "12 hi when 8 and 9";
		SumationofStrings sum = new SumationofStrings();
		int value = sum.sumString(str);
		System.out.println(value);
	}
	
	public int sumOfNum(String result){
		char[] ch = result.toCharArray();
		int sum = 0;
		for(char val:ch){
			if(Character.isDigit(val)){
				sum+=Character.getNumericValue(val);
			}
		}
		return sum;
	}
	
	public int sumString(String val){
		char[] ch = new char[val.length()];
		val.copyValueOf(ch, 5, 4);
		System.out.println(ch);
		val=val.replaceAll("[\\D]+"," ");
		String[] numbers=val.split(" ");
		System.out.println(val);
		int sum = 0;
		for(String s:numbers){
			sum+=Integer.parseInt(s);
		}
			return sum;
	}
}
