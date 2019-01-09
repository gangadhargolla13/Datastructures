package com.java.core.array2;

public class KthSmallestElements {

	public int findkthSmallestElement(int[] arrA, int k) {
		k = k - 1; // since array index starts with 0
		return kSmall(arrA, 0, arrA.length - 1, k);
	}
	public int kSmall(int[] arrA, int start, int end, int k) {
		int left = start;
		int right = end;
		int pivot = start;
		while(left<right){
			while(left<=right && arrA[left]<=arrA[pivot])
				left++;
			while(left<=right && arrA[right]>=arrA[pivot])
				right--;
			if(left<right){
				swap(arrA,left,right);
				left++;
				right--;
			}
		}
		swap(arrA,pivot,right);
		if(pivot==k)
		{
			return arrA[k];
		}
		else if(pivot<k)
		{
			return kSmall(arrA, pivot + 1, end, k);
		}
		else
			return kSmall(arrA, pivot - 1, end, k);
	}
	public void swap(int[] arrA, int a, int b) {
		int x = arrA[a];
		arrA[a] = arrA[b];
		arrA[b] = x;
	}
	
	public static void main(String args[]) {
		int[] arrA = { 2, 3, 11, 16, 27, 4, 15, 9, 8 };
		KthSmallestElements k = new KthSmallestElements();
		int a = 4;
		int x = k.findkthSmallestElement(arrA, a);
		System.out.print("The " + a + "th smallest element is : " + x);
	}
}
