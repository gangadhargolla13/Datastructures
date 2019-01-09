package com.java.arrays.twodim;

import java.util.Scanner;

public class TranformationOfMatrix {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Please enter row array size");
		int s = sc.nextInt();
		System.out.println("Please enter column size");
		int c = sc.nextInt();
		int[][] arr = new int[s][c];
		for(int i=0;i<s;i++){
			for(int j=0;j<c;j++)
				arr[i][j]=sc.nextInt();
		}
		System.out.println("Print the array elements");
		print(arr);
		System.out.println("Before transactions element");
		int[][] trs = trasposeMatrix(arr,s,c);
		print(trs);
		sc.close();
	}
	
	public static void print(int[][] a)
	{
		for(int k=0;k<a.length;k++)
		{
			for(int l=0;l<a[k].length;l++)
				System.out.println("The elemsts location is array["+k+"]["+l+"] ----->"+a[k][l]);
		}
	}
	
	public static int[][] trasposeMatrix(int[][] a,int rs,int cs)
	{
		int[][] tmp = new int[cs][rs];
		for(int i=0;i<rs;i++)
		{
			for (int j=0;j<cs;j++)
			{
				tmp[j][i]=a[i][j];
			}
		}
		
		return tmp;
	}
	
}
