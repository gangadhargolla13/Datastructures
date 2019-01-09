package com.java.core.arrays;

public class CheckDuplicates {

	public static void main(String[] args) {
		int a[] = {1, 6, 5, 2, 3, 3, 2};
		for(int i=0;i<a.length;i++){
			if(a[Math.abs(a[i])]<0)
			{
				System.out.println("Array has duplicates "+Math.abs(a[i]));
			} else{
				a[Math.abs(a[i])]=a[Math.abs(a[i])]*-1;
			}
		}
	}
}
