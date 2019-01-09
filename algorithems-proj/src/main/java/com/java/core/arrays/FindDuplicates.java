package com.java.core.arrays;

public class FindDuplicates {

	public static void main(String[] args) {
       int[] a = {1,5,6,2,1,6,4,3,2,5,3,4};
       int m = a[0];
       for(int i=1;i<a.length;i++){
    	   m ^=a[i];
       }
       System.out.println(m);
	}
}
