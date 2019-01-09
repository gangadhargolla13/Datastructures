package com.java.core.array2;

import java.util.HashSet;

public class FindFirstRepeateElement {

	public static void main(String[] args) {
		int [] a = {1,2,5,7,5,3,10,2};
		findRepeat(a);
	}
	private static void findRepeat(int[] a){
		int index= -1;
		HashSet<Integer> set = new HashSet<>();
		for(int i=a.length-1;i>=0;i--){
			if(set.contains(a[i]))
				index=i;
			else
				set.add(a[i]);
		}
		if(index!=-1)
			System.out.println(a[index]);
	}
}
