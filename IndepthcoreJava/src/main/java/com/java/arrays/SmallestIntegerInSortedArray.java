package com.java.arrays;

import java.util.Arrays;

public class SmallestIntegerInSortedArray {

	public static int findSmallValue(int[] sortArray) {
		int smallNumber = 1;
		for (int i = 0; i < sortArray.length; i++) {
			if (sortArray[i] <= smallNumber) {
				smallNumber += sortArray[i];
			} else {
				break;
			}
		}
		return smallNumber;
	}

	public static void main(String[] args) {
		int[] A = { 1, 1, 3, 4, 6, 7, 9 };
		System.out.println("Smallest number is " + findSmallValue(A));
		int[] B = { 1, 1, 1, 1, 1 };
		System.out.println("Smallest number is " + findSmallValue(B));
		int[] C = { 1, 2, 3, 4, 13 };
		System.out.println("Smallest number is " + findSmallValue(C));
		AlternatePosition po = new AlternatePosition();
		po.rearrange(new int[] { 1, 2, -3, -4, -5, 6, -7, -8, 9, 10, -11, -12,
				-13, 14 });
		po.findSubarray(new int[] { 25, 12, 14, 22, 19, 15, 10, 23 },55);
	}
}

class AlternatePosition {

	public void rearrange(int[] arrA) {
		int pivot = 0;
		int left = 0;
		int right = arrA.length - 1;
		while (right > left) {
			while (arrA[left] < 0 && left < right)
				left++;
			while (arrA[right] > 0 && left < right)
				right--;
			if (left < right) {

				int temp = arrA[left];
				arrA[left] = arrA[right];
				arrA[right] = temp;
				left++;
				right--;
			}
		}
		left = 1;
		int high = 0;
		while (arrA[high] < 0)
			high++;
		right = high;
		while (arrA[left] < 0 && right < arrA.length) {
			int temp = arrA[left];
			arrA[left] = arrA[right];
			arrA[right] = temp;
			left = left + 2;
			right++;
		}
		System.out.println(Arrays.toString(arrA));
	}
	
	public  void findSubarray(int[] array,int sum){
		int sumCurr = 0;
		int start = 0;
		
		for(int i = 0;i<array.length;i++){
			while(sumCurr > sum){
				sumCurr = sumCurr - array[start++];
			}
			if (sumCurr == sum) {
				System.out.println(sum + " is found between indexes " + start
						+ " and " + (i - 1));
				System.out.print("And Elements are : ");
				for (int j = start; j <= i - 1; j++) {
					System.out.print(" " + array[j]);
				}
				return;
			}
			if (i < array.length)
				sumCurr = sumCurr + array[i];
		}
	}
}