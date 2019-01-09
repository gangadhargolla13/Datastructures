package com.java.core.string;

import java.util.Arrays;

public class NLengthString {

	public static void main(String[] args) {
		String k = "ALGO";
		int n = 2;
		NLengthString i = new NLengthString();
		//i.print(n, k.toCharArray(), new char[n]);
		i.print(n, 3, new int[2]);
	}
	public void print(int n, char[] k, char[] A) {
		if(n<=0){
			System.out.println(String.valueOf(A)+" ");
		}else
		{
			for(int i=0;i<k.length;i++){
				A[n-1]=k[i];
				print(n-1,k,A);
			}
		}
	}
	
	public void print(int n,int k,int[] A){
		if (n <= 0) {
			System.out.println(Arrays.toString(A));
		} else {
			for (int i = 1; i <= k; i++) {
				A[n - 1] = i;
				print(n - 1, k, A);
			}
		}
	}
}
