package com.java.core.DPBK;

public class DynamicPrgStrings {

	int findSubArray(char[] f,char[] s)
	{
		int[][] re = new int[f.length+1][s.length+1];
		for(int i=0;i<re.length;i++)
			re[0][i]=0;
		for(int i=0;i<re[0].length;i++)
			re[i][0]=0;
		for(int i=1;i<=f.length;i++)
		{
			for(int j=1;j<=s.length;j++)
			{
				if(f[i-1]==s[j-1])
				{
					re[i][j]=re[i-1][j-1]+1;
				}else
				{
					re[i][j]=0;
				}
			}
		}
		
		int result =-1;
		for(int i=0;i<f.length;i++)
		{
			for(int j=0;j<s.length;j++)
			{
				if(result<re[i][j])
				{
					result=re[i][j];
				}
			}
		}
		return result;
	}
	
	int longest(char[] f,char[] s)
	{
		int[][] re = new int[f.length+1][s.length+1];
		String[][] sol = new String[f.length+1][s.length+1];
		for(int i=0;i<re.length;i++){
			re[0][i]=0;
			sol[0][i]="0";
		}
		for(int i=0;i<re[0].length;i++)
		{
			re[i][0]=0;
			sol[i][0]="0";
		}
		for(int i=1;i<=f.length;i++)
		{
			for(int j=1;j<=s.length;j++)
			{
				if(f[i-1]==s[j-1])
				{
					re[i][j]=re[i-1][j-1]+1;
					sol[i][j]="diagonal";
				}else
				{
					re[i][j]=Math.max(re[i-1][j], re[i][j-1]);
					if(re[i][j]==re[i-1][j])
					{
						sol[i][j]="top";
					}
					else
					{
						sol[i][j]="left";
					}
				}
			}
		}
		
		return re[f.length][s.length];
	}
}
