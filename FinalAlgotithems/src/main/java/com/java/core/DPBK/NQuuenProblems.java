package com.java.core.DPBK;

public class NQuuenProblems {

	public int[][] sol;
	NQuuenProblems(int n){
		sol = new int[n][n];
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<n;j++)
			{
				sol[i][j]=0;
			}
		}
	}
	
	void solve(int n)
	{
		if(placeQueens(0,n))
		{
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					System.out.print(" " + sol[i][j]);
				}
				System.out.println();
			}
		}else{
			System.out.println("NO SOLUTION EXISTS");
		}
	}
	
	public boolean placeQueens(int queen, int N) {
		if(queen==N){
			return true;
		}
		for(int row=0;row<N;row++)
		{
			if (canPlace(sol, row, queen)) {
				sol[row][queen] = 1;
				if(placeQueens(queen+1, N)){
					return true;
				}
				sol[row][queen]=0;
			}
		}
		return false;
	}
	
	public boolean canPlace(int[][] matrix, int row, int column){
		for (int i = 0; i < column; i++) {
			if (matrix[row][i] == 1) {
				return false;
			}
		}
		for (int i = row, j = column; i >= 0 && j >= 0; i--, j--) {
			if (matrix[i][j] == 1) {
				return false;
			}
		}
		for (int i = row, j = column; i < matrix.length && j >= 0; i++, j--) {
			if (matrix[i][j] == 1) {
				return false;
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
		int n=4;
		NQuuenProblems nn = new NQuuenProblems(n);
		nn.solve(n);
	}
}
