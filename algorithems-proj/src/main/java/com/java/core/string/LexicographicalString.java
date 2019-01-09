package com.java.core.string;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class LexicographicalString {

	public static void main(String[] args) throws IOException{
		
		/*String[] str = {"adcs","a","bcs","cds","abcd"};
		Set<String> set = new TreeSet<>();
		for(String s:str)
		set.add(s);
		String ss = "";
		for(String sss:set)
		{
			ss+=sss;
		}
		System.out.println(ss);*/
		/*Scanner sc = new Scanner(System.in);
        String inputString = sc.nextLine();
        int length = sc.nextInt();
        String smallest="";
        String largest="";
        for(int i = 0;i<=inputString.length()-length;i++){
            String subString = inputString.substring(i,i+length);
            System.out.println(subString);
            if(i == 0){
                smallest = subString;
            }
            if(subString.compareTo(largest)>0){
                largest = subString;
            }else if(subString.compareTo(smallest)<0)
                smallest = subString;
        }
        System.out.println(smallest);
        System.out.println(largest);*/
		String input ="CDAABD";
		int len = input.length();
		String conStr = input + input;
		System.out.println(conStr);
		String[] strArr=new String[len];
		for(int i=0;i<len;i++){
			strArr[i]=conStr.substring(i, len+i);
		}
		Arrays.sort(strArr);
		System.out.println(strArr[0]);
		
		String str="bbaaccaadd";
		String min=str;
		for(int i=0; i<str.length(); i++){
			str = str.substring(1) + str.charAt(0);
			if(str.compareTo(min) < 0)
				min=str;
		}
		System.out.println(min);
	}
}
