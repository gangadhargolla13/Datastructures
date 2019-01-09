package com.java.core.array2;

public class FindDuplicatesByxor {

	public static void main(String[] args) {
		int[] arr = {1,5,6,3,9,8,4,2};
		int m=0;
		for(int i=1;i<=9;i++){
			m^=i;
		}
		int n =0;
		for(int j=0;j<arr.length;j++){
			n^=arr[j];
		}
		System.out.println(n^m);
	}
}
