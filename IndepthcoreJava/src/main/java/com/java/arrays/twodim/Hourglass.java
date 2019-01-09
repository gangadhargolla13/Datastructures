package com.java.arrays.twodim;

import java.util.Scanner;

public class Hourglass {

	public static void main(String[] args) {
		try
		{
			Scanner sc = new Scanner(System.in);
					System.out.println("Plese enter eow size");
					int r= sc.nextInt();
					System.out.println("Plese enter eow size");
					int c = sc.nextInt();
					int[][] arr = new int[r][c];
					for(int i=0;i<r;i++)
						for(int j=0;j<c;j++)
							arr[i][j]=sc.nextInt();
					int max = -999990;
					for(int k=0;k<r-2;k++)
						for(int l=0;l<c-2;l++){
							 int tmp=arr[k][l]+arr[k][l+1]+arr[k][l+2]+arr[k+1][l+1]+arr[k+2][l]+arr[k+2][l+1]+arr[k+2][l+2];
		                max=Math.max(max,tmp);
						}
					System.out.println("The max value is "+max);
					sc.close();
		}catch(Exception e)
		{
			
		}finally
		{
			
		}
	}
}
