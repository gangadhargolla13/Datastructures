package com.java.core.DPBK;

public class WordMatrixEx {

	public int[][] sol;
	int path = 1;
	public WordMatrixEx(int n)
	{
		sol = new int[n][n];
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<n;j++)
			{
				sol[i][j]=0;
			}
		}
	}
	
	public boolean searchWord(char[][] matrix,String word)
	{
		int nn = matrix.length;
		for(int i=0;i<nn;i++)
		{
			for(int j=0;j<nn;j++)
			{
				if(search(matrix,word,i,j,0,nn))
				{
					return true;
				}
			}
		}
		return false;
	}
	
	public boolean search(char[][] m,String w,int row,int col,int in,int n)
	{
		if(sol[row][col] != 0 || w.charAt(in) != m[row][col])
		{
			return false;
		}
		if(in==w.length()-1)
		{
			sol[row][col]=path++;
			return true;
		}
		sol[row][col]=path++;
		if(row+1<n && search(m,w,row+1,col,in+1,n))
			return true;
		if(row-1>=0 && search(m,w,row-1,col,in+1,n))
			return true;
		if(col+1<n && search(m,w,row,col+1,in+1,n))
			return true;
		if(col-1>=0 && search(m,w,row,col-1,in+1,n))
			return true;
		if(col+1<n && search(m,w,row,col+1,in+1,n))
			return true;
		if(row-1>=0 && col+1<n&& search(m,w,row-1,col+1,in+1,n))
			return true;
		if(row-1>=0 && col-1>=0&& search(m,w,row-1,col-1,in+1,n))
			return true;
		if(row+1<n && col-1>=0&& search(m,w,row+1,col-1,in+1,n))
			return true;
		if(row+1<n && col+1<n&& search(m,w,row+1,col+1,in+1,n))
			return true;
		sol[row][col]=0;
		path--;
		return false;
	}
	
	public void print() {
		for (int i = 0; i < sol.length; i++) {
			for (int j = 0; j < sol.length; j++) {
				System.out.print(" " + sol[i][j]);
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		char[][] matrix = { { 't', 'z', 'x', 'c', 'd' },
				{ 'a', 'h', 'n', 'z', 'x' }, { 'h', 'w', 'o', 'i', 'o' },
				{ 'o', 'r', 'n', 'r', 'n' }, { 'a', 'b', 'r', 'i', 'n' } };
		WordMatrixEx ex = new WordMatrixEx(matrix.length);
		if(ex.searchWord(matrix, "horizon")){
			ex.print();
		}else
			System.out.println("Not found");
	}
}
