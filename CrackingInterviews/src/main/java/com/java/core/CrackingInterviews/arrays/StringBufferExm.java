package com.java.core.CrackingInterviews.arrays;

public class StringBufferExm {

	public static void main(String[] args) {
		StringBufferExm ex = new StringBufferExm();
		ex.joinWord(new String[]{"Hi ", "there ", "Rob. ", "How ", "are ", "you?"});
	}
	public void joinWord(String[] str){
		StringBuffer sb = new StringBuffer();
		for(String s: str){
			sb.append(s);
			
		}
		System.out.println(sb.toString());
	}
}
