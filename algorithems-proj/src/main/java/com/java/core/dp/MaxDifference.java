package com.java.core.dp;

public class MaxDifference {

	public static void main(String[] args) {
		int[]  element = {12, 5, 1, 7, 3, 9, 5};
		int max=element[element.length-1];
		int maxdiff = -1;
		for(int i=element.length-2;i>0;i--){
			if(max<element[i]){
				max=element[i];
			}else
			{
				maxdiff=Math.max(maxdiff, max-element[i]);
			}
		}
		System.out.println("Max element "+maxdiff);
	}
}
