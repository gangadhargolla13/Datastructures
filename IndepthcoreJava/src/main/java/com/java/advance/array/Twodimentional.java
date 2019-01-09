package com.java.advance.array;

import java.util.Arrays;

public class Twodimentional {

	public static void main(String[] args) {
		int[][] array = new int[3][4];
		int k=45;
		for(int i=0;i<array.length;i++){
			for(int j=0;j<array[i].length;j++){
				array[i][j]=k;
				k++;
			}
		}
		for(int i=0;i<array.length;i++){
			for(int j=0;j<array[i].length;j++){
				System.out.println(array[i][j]);
			}
		}
		System.out.println(Arrays.deepToString(array));
	}
}
