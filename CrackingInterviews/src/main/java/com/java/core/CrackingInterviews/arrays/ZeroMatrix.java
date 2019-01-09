package com.java.core.CrackingInterviews.arrays;

public class ZeroMatrix {
	public static void zero(int[][] array) {
		int M = array.length;
		int N = array[0].length;

		/* Figure out which rows & columns should become 0 */
		boolean[] rows = new boolean[M];
		boolean[] cols = new boolean[N];
		for (int row = 0; row < M; row++) {
			for (int col = 0; col < N; col++) {
				if (array[row][col] == 0) {
					rows[row] = true;
					cols[col] = true;
				}
			}
		}

		/* Re-loop through 2-d matrix and set whichever entries are necessary to 0 */
		for (int row = 0; row < M; row++) {
			for (int col = 0; col < N; col++) {
				if (rows[row] == true || cols[col] == true) {
					array[row][col] = 0;
				}
			}
		}
	}
	public static void main(String[] args) {
		System.out.println("*** Test 1.8: Zero Matrix\n");
		int[][] matrix = {{1, 2, 3},
 	            		  {0, 5, 6}};
		
		int[][] matrix2 = {{1, 2, 3, 1},
			               {4, 5, 6, 0},
			               {0, 5, 3, 0}};
		
		testMatrix(matrix);
		testMatrix(matrix2);
	}
	
	private static void testMatrix(int[][] matrix) {
		System.out.println("Original matrix");
		Functions.printImage(matrix); // uses print function above in 1.6
		System.out.println("Zero out necessary rows/columns");
		ZeroMatrix.zero(matrix);
		Functions.printImage(matrix);
		System.out.println();
	}
}
