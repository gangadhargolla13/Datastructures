package com.java.strings;

import java.util.Arrays;

public class StringAnargam {

	public static void main(String[] args) throws Exception{
		
		String anargam = "army";
		String anargam1 = "mary";
		StringAnargam obj = (StringAnargam) Class.forName("com.java.strings.StringAnargam").newInstance();
		if(obj.isAnargam(anargam, anargam1)){
			System.out.println("Both stringas are anargams");
		}else{
			System.out.println("Both stringas are not anargams");
		}
	}
	public boolean isAnargam(String ana,String ana1){
		char[] first = ana.toCharArray();
		char[] second = ana1.toCharArray();
		Arrays.sort(first);
		Arrays.sort(second);
		return Arrays.equals(first, second);
	}
	public boolean checkAnargam(String ana,String ana1){
		if(ana.length()!=ana1.length()){
			return false;
		}
		
		char[] ch = ana.toCharArray();
		for(char c :ch){
			int index = ana1.indexOf(c);
			if(index != -1){
				ana1 = ana1.substring(0, index)+ana1.substring(index+1, ana1.length());
				System.out.println(ana1);
			}else{
				return false;
			}
		}
		return ana1.isEmpty();
	}
}
