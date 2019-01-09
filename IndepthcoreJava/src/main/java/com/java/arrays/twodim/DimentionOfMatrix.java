package com.java.arrays.twodim;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DimentionOfMatrix {
	public static void main(String[] arg){
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Please enter row size");
		int rc = sc.nextInt();
		System.out.println("Please enter column size");
		int cc = sc.nextInt();
		int[][] first = new int[rc][cc];
		for (int i = 0; i < rc; i++) {
			for (int j = 0; j < cc; j++)
				first[i][j] = sc.nextInt();
		}

		int sumOfDiagonal1 = 0;
		for (int i = 0, j = 0; i < rc && j < cc; i++, j++) {
			sumOfDiagonal1 = sumOfDiagonal1 + first[i][j];
		}
		
		int sumOfDiagonal2=0;
        for (int i=0,j=cc-1 ; i<rc && j>=0 ; i++, j--) {
               sumOfDiagonal2= sumOfDiagonal2 + first[i][j];
        }
		System.out.println(sumOfDiagonal1+"  "+sumOfDiagonal2);
		for(int i=0;i<rc;i++)
		{
			for(int j=0;j<cc;j++)
			{
				if(i<=j)
				{
					System.out.print(first[i][j]+" ");
				}
				else
					System.out.print("0 ");
			}
			System.out.println("\n");
		}
	}
}
