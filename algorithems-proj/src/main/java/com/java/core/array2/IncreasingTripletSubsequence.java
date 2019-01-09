package com.java.core.array2;

public class IncreasingTripletSubsequence {
	public void triplet(int[] arrA) {
		int[] Lmin = new int[arrA.length];
		int[] Rmax = new int[arrA.length];
		int leftMinIndex = 0;
		int leftMinValue = arrA[0];
		int rightMaxValue = arrA[arrA.length - 1];
		int rightMaxIndex = arrA.length - 1;

		for (int i = 0; i < arrA.length; i++) {
			if (leftMinValue > arrA[i]) {
				leftMinIndex = i;
				leftMinValue = arrA[i];
			}
			Lmin[i] = leftMinIndex;
		}
		for (int i = arrA.length - 1; i >= 0; i--) {
			if (rightMaxValue < arrA[i]) {
				rightMaxIndex = i;
				rightMaxValue = arrA[i];
			}
			Rmax[i] = rightMaxIndex;
		}

		for (int i = 0; i < arrA.length; i++) {
			if (arrA[Lmin[i]] < arrA[i] && arrA[Rmax[i]] > arrA[i]) {
				System.out.println("Triplet " + arrA[Lmin[i]] + "  " + arrA[i]
						+ "  " + arrA[Rmax[i]]);
			}
		}
	}

	public static void main(String[] args) {
		int arrA[] = { 10, 9, 4, 3, 2, 1, 7, 3, 1, 11, 2, 6, 9 };
		IncreasingTripletSubsequence i = new IncreasingTripletSubsequence();
		i.triplet(arrA);

	}
}
