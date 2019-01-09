package com.java.examples.IndepthcoreJava;

public class FibunocySeries {

	public static void main(String[] args) {
		int f1 = 0;
		//int f2 = 1;
		//int tmp = 0;
		StringBuilder build = new StringBuilder();
		for(int i=0;i<6;i++){
			int f = f1+i;
			f1=f;
			build.append(f+",");
		}
		String str = build.toString();
		str = str.substring(0,str.length()-1);
		System.out.println(str);
	}
}
