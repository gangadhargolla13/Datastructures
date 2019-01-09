package com.java.core.first;

public class FindLangestSubstring {

	public int find(char[] ch1,char[] ch2)
	{
		int[][] LCS = new int[ch1.length+1][ch2.length+1];
		for(int i=0;i<=ch2.length;i++)
		{
			LCS[0][i]=0;
		}
		
		for(int j=0;j<=ch1.length;j++)
		{
			LCS[j][0]=0;
		}
		
		for(int i=1;i<=ch1.length;i++)
		{
			for(int j=1;j<=ch2.length;j++)
			{
				if(ch1[i-1]==ch2[j-1]){
					LCS[i][j]=1+LCS[i-1][j-1];
				}
				else
				{
					LCS[i][j]=0;
				}
			}
		}
		
		int re = -1;
		for(int i=0;i<=ch1.length;i++){
			for(int j=0;j<=ch2.length;j++){
				if(re<LCS[i][j])
					re=LCS[i][j];
			}
		}
		return re;
	}
	
	public static void main(String[] args) {
		String A = "tutorialhorizon";
		String B = "dynamictutorialProgramming";
		FindLangestSubstring f = new FindLangestSubstring();
		int ree = f.find(A.toCharArray(), B.toCharArray());
		System.out.println(ree);
	}
}
