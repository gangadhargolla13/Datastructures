package com.java.strings.v2;

public class Testings {

	public static void main(String[] args) {
		String ss = "EPSMASTER_vmy1739";
		String mm = ss.substring(0,ss.indexOf("_"));
		System.out.println(ss.indexOf("_"));
		String mm1 = ss.substring(ss.indexOf("_"),ss.length());
		System.out.println(mm+"===="+mm1);
	}
}
