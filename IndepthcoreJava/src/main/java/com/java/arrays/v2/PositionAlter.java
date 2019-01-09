package com.java.arrays.v2;

public class PositionAlter {

	public static void main(String[] args) {
		int[] arrA = { 1, 2, -3, -4, -5, 6, -7, -8, 9, 10, -11, -12, -13, 14 };
		rearrange(arrA);
	}
	
	public static void rearrange(int[] n)
	{
		int pivot = 0;
		int left = 0;
		int right = n.length - 1;
		while (right > left) {
			while (n[left] < 0 && left < right)
				left++;
			while (n[right] > 0 && left < right)
				right--;
			if (left < right) {

				int temp = n[left];
				n[left] = n[right];
				n[right] = temp;
				left++;
				right--;
			}
		}
		left = 1;
		int high = 0;
		while (n[high] < 0)
			high++;
		right = high;
		while (n[left] < 0 && right < n.length) {
			int temp = n[left];
			n[left] = n[right];
			n[right] = temp;
			left = left + 2;
			right++;
		}
		for (int i = 0; i < n.length; i++) {
			System.out.print("  " + n[i]);
		}
	}
}
