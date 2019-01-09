package com.java.core.FinalAlgotithems;

public class PrintAllPaths {

	public static void findNoPath(int[][] a){
		int[][] result = new int[a.length][a[0].length];
		for(int i=0;i<a.length;i++)
			result[i][0]=1;
		for(int i=0;i<a[0].length;i++)
			result[0][i]=1;
		for(int i=1;i<a.length;i++)
		{
			for(int j=1;j<a[1].length;j++)
				result[i][j]=result[i-1][j]+result[i][j-1]+result[i-1][j-1];
		}
		System.out.println(result[a.length-1][a[0].length-1]);
	}
	
	// Find path when obstuction are there
	public static void findPath(int[][] a)
	{
		int[][] re = a;
		for(int i=1;i<re.length;i++)
		{
			for(int j=1;j<re[1].length;j++)
			{
				if(re[i][j]!=-1)
				{
					re[i][j]=0;
					if(re[i-1][j]>0)
					{
						re[i][j]+=re[i-1][j];
					}
					if(re[i][j-1]>0)
					{
						re[i][j]+=re[i][j-1];
					}
				}
			}
		}
		System.out.println(re[a.length-1][a[0].length-1]);
	}
	public static void main(String[] args) {
		int[][] a = { { 1, 2 }, { 4, 5 } };
		int arrA [][] = {{1,1,1},{1,-1,1},{1,1,1}};
		findNoPath(a);
		findPath(arrA);
	}
}
