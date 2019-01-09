package com.java.core.CrackingInterviews.arrays;


public class RotateMatrix {
	public static void main(String[] args) {
		System.out.println("*** Test 1.7: Rotate Matrix\n");
		int[][] image1 = { { 1, 2 }, { 3, 4 } };

		int[][] image2 = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };

		int[][] image3 = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14, 15, 16 } };

		int[][] image4 = { { 1, 2, 3, 4, 5 }, { 6, 7, 8, 9, 10 }, { 11, 12, 13, 14, 15 }, { 16, 17, 18, 19, 20 },
				{ 21, 22, 23, 24, 25 } };

		test(image1);
		test(image2);
		test(image3);
		test(image4);
	}

	private static void test(int[][] image) {
		System.out.println("Original image");
		Functions.printImage(image);

		System.out.println("Rotated 90 degrees clockwise");
		RotateMatrix.rotate90clockwise(image);
		Functions.printImage(image);

		System.out.println("Rotated ANOTHER 180 degrees clockwise");
		RotateMatrix.rotate180(image); // this rotates the already 90-degree
										// rotated image.
		Functions.printImage(image);
		System.out.println();
	}
	
	public static void rotate90clockwise(int[][] image) {
		int n = image.length;
		for (int layer = 0; layer < n/2; layer++) {
			int first = layer;
			int last  = n - 1 - layer;
			for (int i = first; i < last ; i++) {
				int offset = i - first;
				/* 4-way swap */
				int temp                     = image[first][first + offset];
				image[first][first + offset] = image[last - offset][first];
				image[last - offset][first]  = image[last][last - offset];
				image[last][last - offset]   = image[first + offset][last];
				image[first + offset][last]  = temp;
			}
		}
	}
	
	/* For fun: I tried rotating image by 180 degrees */
	public static int[][] rotate180(int[][] image) {
		int n = image.length;
		for (int row = 0; row < n/2; row++) {
			for (int col = 0; col < n; col++) {
				swap(image, row, col, n-1-row, n-1-col); // 5-argument version of swap
			}
		}
		/* If n is odd, rotate middle row */
		if (n % 2 == 1) {
			int middleRow = n/2;
			for (int col = 0; col < n/2; col++) {
				swap(image, middleRow, col, middleRow, n-1-col);
			}
		}
		return image;
	}
	
	/* Swaps 2 elements in a 2-D array */
	private static void swap(int[][] image, int r1, int c1, int r2, int c2) {
		int temp      = image[r1][c1];
		image[r1][c1] = image[r2][c2];
		image[r2][c2] = temp;
	}
}
