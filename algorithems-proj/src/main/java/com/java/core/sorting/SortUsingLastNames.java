package com.java.core.sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class SortUsingLastNames {

	public void sortLastName(ArrayList<String> list){
		Collections.sort(list,new Comparator<String>() {
			public int compare(String s1,String s2){
				String ln1 = s1.split(" ")[1];
				String ln2 = s2.split(" ")[1];
				if(ln1.compareTo(ln2) > 0)
					return 1;
				else
					return -1;
			}
		});
	}
	public static void main(String[] args) {
		ArrayList<String> al = new ArrayList<String>();
		al.add("Daenerys Targaryen");
		al.add("Jon Show");
		al.add("Tyrion Lannister");
		al.add("Joffrey Baratheon");
		System.out.println(al);
		SortUsingLastNames name = new SortUsingLastNames();
		name.sortLastName(al);
		System.out.println(al);
		
	}
}
