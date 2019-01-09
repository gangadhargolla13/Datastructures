package com.java.core.backtracking;

import java.text.DecimalFormat;

public class KnightTour {

	public int[][] solution;
	public int path = 0;
	public KnightTour(int n){
		solution = new int[8][8];
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<n;j++){
				solution[i][j]=0;
			}
		}
	}
	public static void main(String[] args) {
		KnightTour k = new KnightTour(8);
		k.solve();
	}
	public void solve(){
		if(findPath(0,0,0,solution.length))
		{
			print();
		}else{
			System.out.println("NO PATH FOUND!");
		}
	}
	
	public void print()
	{
		DecimalFormat twodigits = new DecimalFormat("00");
		for (int i = 0; i < solution.length; i++) {
			for (int j = 0; j < solution.length; j++) {
				System.out.print("   " + twodigits.format(solution[i][j]));
			}
			System.out.println();
		}
	}
	
	public boolean findPath(int row,int column,int index,int N){
		if (solution[row][column] != 0) {
			return false;
		}
		solution[row][column] = path++;
		if (index == N * N - 1) {
			return true;
		}
		if (canMove(row + 2, column + 1, N)
				&& findPath(row + 2, column + 1, index + 1, N)) {
			return true;
		}
		if (canMove(row + 1, column + 2, N)
				&& findPath(row + 1, column + 2, index + 1, N)) {
			return true;
		}
		// go right and up
		if (canMove(row - 1, column + 2, N)
				&& findPath(row - 1, column + 2, index + 1, N)) {
			return true;
		}
		// go up and right
		if (canMove(row - 2, column + 1, N)
				&& findPath(row - 2, column + 1, index + 1, N)) {
			return true;
		}
		// go up and left
		if (canMove(row - 2, column - 1, N)
				&& findPath(row - 2, column - 1, index + 1, N)) {
			return true;
		}
		// go left and up
		if (canMove(row - 1, column - 2, N)
				&& findPath(row - 1, column - 2, index + 1, N)) {
			return true;
		}
		// go left and down
		if (canMove(row + 1, column - 2, N)
				&& findPath(row + 1, column - 2, index + 1, N)) {
			return true;
		}
		// go down and left
		if (canMove(row + 2, column - 1, N)
				&& findPath(row + 2, column - 1, index + 1, N)) {
			return true;
		}
		solution[row][column] = 0;
		path--;
		return false;
	}
	public boolean canMove(int row, int col, int N) {
		if (row >= 0 && col >= 0 && row < N && col < N) {
			return true;
		}
		return false;
	}
}
