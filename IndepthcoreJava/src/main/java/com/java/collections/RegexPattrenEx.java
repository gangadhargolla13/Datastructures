package com.java.collections;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexPattrenEx {

	public static void main(String[] args) {
		//String tableName = "event_t1_1";
		String tableName = "t1_1_event";
		//String pattren = "event(.*)";
		String pattren = "(.*)event";
		String indexTable = "customerIndex(.*)";
		System.out.println(indexTable.length());
		int val = indexTable.lastIndexOf("(.*)");
		System.out.println("LastIndex "+val);
		indexTable = indexTable.substring(0, val);
		//System.out.println(indexTable.substring(0, val));
		Pattern p = Pattern.compile(pattren);
		Matcher m = p.matcher(tableName);
		if(m.matches()){
			System.out.println(m.groupCount());
			String str = m.group(1);
			System.out.println(str);
			if(tableName.startsWith(str)){
				System.out.println("startIndex");
				System.out.println(str+indexTable);
			}else if(tableName.endsWith(str)){
				System.out.println("endIndex");
				System.out.println(indexTable+str);
			}
		}
	}
}
