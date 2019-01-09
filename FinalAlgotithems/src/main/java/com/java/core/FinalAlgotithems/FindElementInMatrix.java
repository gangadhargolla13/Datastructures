package com.java.core.FinalAlgotithems;

public class FindElementInMatrix {

	public static boolean findNumber(int[][] a,int n)
	{
		int row=0;
		int col = a[0].length-1;
		boolean numFound = false;
		while(numFound==false)
		{
			int ele = a[row][col];
			System.out.print(ele+"->");
			if(ele==n)
				return true;
			else if(ele>n)
				col--;
			else if(ele<n)
				row++;
			if(row>a[0].length-1 || col<0)
				return false;
		}
		return false;
	}
	public static void main(String[] args) {
		int[][] a = {{ 1, 2, 3, 4 }, { 6, 7, 8, 9 }, { 13, 14, 15, 16 },{ 17, 18, 19, 20 }, { 22, 23, 24, 26 }};
		int nu = 15;
		System.out.println(findNumber(a,nu));
	}
}
