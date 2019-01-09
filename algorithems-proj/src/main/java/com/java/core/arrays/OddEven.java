package com.java.core.arrays;

import java.util.Arrays;

public class OddEven {

	public static int[] arrange(int[] a)
	{
		int left=0;
		int right = a.length-1;
		while(left<right){
			if(a[left]%2==0)
			{
				left++;
			}else if(a[right]%2==1){
				right--;
			}else
			{
				int temp = a[left];
				a[left]=a[right];
				a[right]=temp;
				left++;
				right --;
			}
		}
		return a;
	}
	
	public static void main(String[] args) {
		int[] f = arrange(new int[]{1,2,3,4,6,8,7,12});
		System.out.println(Arrays.toString(f));
	}
}
