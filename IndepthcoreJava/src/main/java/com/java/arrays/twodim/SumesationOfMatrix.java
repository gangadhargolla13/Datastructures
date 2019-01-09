package com.java.arrays.twodim;

import java.util.Scanner;

public class SumesationOfMatrix {

	public static void main(String[] args) throws Exception{
		SumesationOfMatrix d = (SumesationOfMatrix) Class.forName(SumesationOfMatrix.class.getName()).newInstance();
		Scanner sc = new Scanner(System.in);
		System.out.println("Please enter row size");
		int rc = sc.nextInt();
		System.out.println("Please enter column size");
		int cc = sc.nextInt();
		int[][] first = new int[rc][cc];
		int[][] second = new int[rc][cc];
		for(int m=0;m<2;m++)
		{
			System.out.println("Please enter name");
			String name = sc.next().trim().toUpperCase();
			System.out.println(name);
			switch(name) {
			case "FIRST":
				System.out.println("I am first");
				for(int i=0;i<rc;i++)
				{
					for(int j=0;j<cc;j++)
						first[i][j]=sc.nextInt();
				}
				break;
			case "SECOND":
				System.out.println("I am second");
				for(int i=0;i<rc;i++)
				{
					for(int j=0;j<cc;j++)
						second[i][j]=sc.nextInt();
				}
				break;
				default:
					System.out.println("I am completed");
					break;
			}
		}
		int[][] f = d.sumeOf(first, second);
		d.printArray(f);
		sc.close();
	}
	
	public void printArray(int[][] a)
	{
		for(int i=0;i<a.length;i++)
		{
			for(int j=0;j<a[i].length;j++)
			{
				System.out.print(a[i][j]);
			    System.out.print(" ");
			}
			System.out.println("\n");
		}
	}
	
	/*public <T> void printArray(T[][] a)
	{
		for(int i=0;i<a.length;i++)
		{
			for(int j=0;j<a[i].length;j++)
			{
				System.out.print("The elements "+a[i][j]);
			    System.out.print(" ");
			}
			System.out.println("\n");
		}
	}*/
	
	public int[][] sumeOf(int[][] a,int[][] b)
	{
        int[][] sum = new int[a.length][b.length];
        for(int x=0;x<a.length;x++)
        {
        	for(int y=0;y<a[x].length;y++)
        		sum[x][y]=a[x][y]+b[x][y];
        }
		return sum;
	}
	
	/*public <T> T sumOf(T[][] a, T[][] b)
	{
		T[][] ll = (T[][])new Object[a.length][b.length];
		for(int d=0;d<a.length;d++)
		{
			for(int e;e<a[d].length;e++)
				ll[d][e]= a[d][e] + b[d][e];
		}
		return null;
	}*/
}
