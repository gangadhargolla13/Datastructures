package com.java.core.DPBK;

public class RateInMaze {

	public int[][] solution;
	
	RateInMaze(int n){
		solution = new int[n][n];
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<n;j++){
				solution[i][j]=0;
			}
		}
	}
	
	public void solve(int[][] m,int n)
	{
		/*if(findPath(m,0,0,n,"down")){
			print(solution,n);
		}*/
		
		if(findPath(m,0,0,n))
		{
			print(solution,n);
		}
	}
	
	// Allowing all directions
	public boolean findPath(int[][] mz,int x,int y,int n,String dir)
	{
		if(x==n-1&&y==n-1)
		{
			solution[x][y]=1;
			return true;
		}
		if(isSafeToGo(mz,x,y,n))
		{
			solution[x][y]=1;
			if(dir!="up"&& findPath(mz,x+1,y,n,"down"))
			return true;
			if(dir!="left"&& findPath(mz,x,y+1,n,"right"))
			return true;
			if(dir!="down"&& findPath(mz,x-1,y,n,"up"))
			return true;
			if(dir!="right"&& findPath(mz,x,y-1,n,"left"))
			return true;
			solution[x][y]=0;
			return false;
		}
		return false;
	}
	
	//Allowing only forward and down direction
	public boolean findPath(int[][] mz,int x,int y,int n)
	{
		if(x==n-1 && y==n-1)
		{
			solution[x][y]=1;
			return true;
		}
		
		if(isSafeToGo(mz,x,y,n))
		{
			solution[x][y]=1;
			if(findPath(mz,x+1,y,n))
				return true;
			if(findPath(mz,x,y+1,n))
			{
				return true;
			}
			solution[x][y]=0;
			return false;
		}
		return false;
	}
	public boolean isSafeToGo(int[][] maze, int x, int y, int N) {
		if (x >= 0 && y >= 0 && x < N  && y < N && maze[x][y] != 0) {
			return true;
		}
		return false;
	}
	public void print(int [][] solution, int N){
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(" " + solution[i][j]);
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		int n =4;
		int[][] maze = {{1, 0, 0, 0},
	            {1, 1, 0, 1},
	            {0, 1, 0, 0},
	            {1, 1, 1, 1}};
		RateInMaze mzz = new RateInMaze(n);
		mzz.solve(maze, n);
	}
}
