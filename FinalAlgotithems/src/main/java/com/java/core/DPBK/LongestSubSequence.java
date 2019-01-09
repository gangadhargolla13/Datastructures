package com.java.core.DPBK;

import java.util.Arrays;

public class LongestSubSequence {

	public static void main(String[] args) {
		int[] A = { 1, 12, 7, 0, 23, 11, 52, 31, 61, 69, 70, 2 };
		LongestSubSequence l = new LongestSubSequence();
		l.findIncreSequence(A);
	}
	
	public void findIncreSequence(int[] arrA)
	{
		int[] LIS = new int[arrA.length];
		for (int i = 0; i < arrA.length; i++) {
			int max = -1;
			for (int j = 0; j < i; j++) {
				if (arrA[i] > arrA[j]) {
					if (max == -1 || max < LIS[j] + 1) {
						max = 1 + LIS[j];
					}
				}
			}
			if (max == -1) {
				max = 1;
			}
			LIS[i] = max;
		}
		System.out.println(Arrays.toString(LIS));
		
		int result = -1;
		int index = -1;
		for (int i = 0; i < LIS.length; i++) {
			if (result < LIS[i]) {
				result = LIS[i];
				index = i;
			}
		}
		System.out.println(result +" "+index);
		String path =  arrA[index] + " ";
		int res = result-1;
		for (int i = index-1; i >= 0; i--) {
			if(LIS[i]==res){
				path =  arrA[i] + " " + path;
				res--;
			}			
		}
		System.out.println("Longest Increasing subsequence: " + result);
		System.out.println("Actual Elements: " + path);	
	}
}
