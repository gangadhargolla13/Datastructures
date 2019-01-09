package com.java.strings;

public class StringManpulation {

	
	public static void main(String[] args) {
		String str = "gangadhar";
		String str2 = "gangadhar";
	    String str1 = str;
	    if(str1 == str2){
	    	System.out.println("both are matched");
	    }
	    System.out.println("str "+str+"  hashcode "+str.hashCode());
	    System.out.println("str1 "+str1+"  hashcode "+str1.hashCode());
	    System.out.println("str2 "+str2+"  hashcode "+str2.hashCode());
	    str = "mallikarjuna";
	    if(str == str2){
	    	System.out.println("both are matched");
	    }
	    
	    System.out.println("str1 "+str1+"  hashcode "+str1.hashCode());
	    System.out.println("str "+str+"  hashcode "+str.hashCode());
	    test(str);
	    System.out.println("str "+str+"  hashcode "+str.hashCode());
	    Runtime rt = Runtime.getRuntime();
	    System.out.println("Used: " + (rt.totalMemory() - rt.freeMemory()));
	    System.out.println("Free: " + rt.freeMemory());
	    System.out.println("Total: " + rt.totalMemory());
	    System.out.println(rt.maxMemory());
	}
	
	public static void test(String str){
		System.out.println("str "+str+"  hashcode "+str.hashCode());
		str ="gayathri";
		System.out.println("str "+str+"  hashcode "+str.hashCode());
	}
}
