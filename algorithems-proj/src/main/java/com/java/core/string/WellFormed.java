package com.java.core.string;

import java.util.Arrays;

public class WellFormed {

	char[] A;

	public void wellFormed(String S) {
		A = S.toCharArray();
		permutation(A, 0);
	}
	public void permutation(char[] A, int left) {
		if (left == A.length) {
			if (isWellFormed(A)) {
				System.out.println(Arrays.toString(A));
			}
			return;
		}
		for (int i = left; i < A.length; i++) {
			swap(i, left);
			permutation(A, left + 1);
			swap(i, left); 
		}
	}
	public void swap(int a, int b) {
		char temp = A[a];
		A[a] = A[b];
		A[b] = temp;
	}

	public boolean isWellFormed(char[] A) {
		boolean wellFormed = true;
		for (int i = 0; i < A.length - 1; i++) {
			if (Character.toLowerCase(A[i]) > Character.toLowerCase(A[i + 1])) {
				wellFormed = false;
				break;
			}
		}
		return wellFormed;
	}

	public static void main(String[] args) {
		String S = "Interview";
		System.out.println("Given String - " + S);
		WellFormed i = new WellFormed();
		i.wellFormed(S);

	}
}
