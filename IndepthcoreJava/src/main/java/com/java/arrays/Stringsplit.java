package com.java.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Stringsplit {

	public static void main(String[] args) {
		String str="EPSINFRAevents";
		test();
		//String[] ss = get();
		//System.out.println(ss.length);
		//System.out.println(ss[0]);
	}
	 public static String[] get(){
		 List<String> ll = new ArrayList<>();
		 ll.add("ganga");
		 ll.add("ganga1");
		 ll.add("ganga2");
		 ll.add("ganga3");
		 ll.add("malli");
		 ll.add("ganesh");
		 System.out.println(ll);
		 Collections.sort(ll,Collections.reverseOrder());
		 for(int i=5;i<ll.size();i++){
			 System.out.println(ll.get(i));
		 }
		 System.out.println(ll);
		 return ll.toArray(new String[ll.size()]);
	 }
	 
	 public static void test(){
		 String ss = "20170302063526, 20170302072838, 20170302071513, 20170302063643, 20170302063447, 20170302063606";
		 List<String> ll = Arrays.asList(ss.split(","));
		 System.out.println(ll);
		 Collections.sort(ll, new Comparator<String>() {
			 public int compare(String o1, String o2){
			        //return  Integer.parseInt(o1.trim()).compareTo(Integer.parseInt(o2.trim()));
				 return o1.trim().compareTo(o2.trim());
			    }
		});
		 System.out.println(ll);
	 }
}
