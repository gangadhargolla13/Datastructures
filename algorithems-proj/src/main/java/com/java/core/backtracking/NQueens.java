package com.java.core.backtracking;

import java.util.Arrays;

public class NQueens {

	static int[] result;
	public boolean canPlace(int x2, int y2) {
		for (int i = 0; i < x2; i++) {
			if ((result[i] == y2)
					|| (Math.abs(i - x2) == Math.abs(result[i] - y2))) {
				return false;
			}
		}
		return true;
	}
	
	public void placeQueens(int x, int size) {
		for (int i = 0; i < size; i++) {
			if (canPlace(x, i)) {
				result[x] = i;
				if (x == size - 1) {
					System.out.println("Order of " + size + " queens"
							+ Arrays.toString(result));
				}
				placeQueens(x + 1, size);
			}
		}
	}
	public static void main(String[] args) {
		int n = 6;
		result = new int[n];
		NQueens i = new NQueens();
		i.placeQueens(0, n);
	}
}
