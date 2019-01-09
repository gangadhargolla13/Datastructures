package com.java.core.DPBK;

public class LongestSubStrings {
	public static void main(String[] args) {
		String A = "tutorialgahorizon";
		String B = "dynamictutorialgaProgramming";		
		System.out.println("LCS length : " + find(A.toCharArray(), B.toCharArray()));
	}
	
	public static int find(char[] a,char[] b)
	{
		int[][] LCS = new int[a.length+1][b.length+1];
		for(int i=0;i<b.length;i++){
			LCS[0][i]=0;
		}
		for(int i=0;i<a.length;i++){
			LCS[i][0]=0;
		}
		for(int i=1;i<=a.length;i++)
		{
			for(int j=1;j<=b.length;j++)
			{
				if(a[i-1]==b[j-1])
				{
					LCS[i][j]=LCS[i-1][j-1]+1;
				}
				else
					LCS[i][j]=0;
			}
		}
		int re =-1;
		for(int i=0;i<a.length;i++){
			for(int j=0;j<b.length;j++){
				if(re<LCS[i][j])
					re=LCS[i][j];
			}
		}
		return re;
	}
}
