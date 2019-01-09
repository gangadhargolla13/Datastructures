package com.java.core.array2;

import java.util.Arrays;

public class ConstructTriangle {

	public static void main(String[] args) {
		int[] A = { 1, 2, 3, 4, 5 };
		ConstructTriangle c = new ConstructTriangle();
		c.Triangle(A);

	}
	public void Triangle(int[] A){
		if(A.length>=1){
			int[] tmp = new int[A.length-1];
			for(int i=0;i<A.length-1;i++){
				int x= A[i]+A[i+1];
				tmp[i]=x;
			}
			Triangle(tmp);
			System.out.println(Arrays.toString(A));
		}
		
	}
}
