package com.java.core.recurtion;

public class RatInMaze {

	private int[][] a1;
	
	public RatInMaze(int n){
		a1=new int[n][n];
		for(int i=0;i<n;i++){
			for(int j=0;j<n;j++){
				a1[i][j]=0;
			}
		}
	}
	
	public void solveMaze(int[][] x,int n){
		if(findPath(x,0,0,n,"down")){
			print(a1,n);
		}
		else
			System.out.println("Path is found!");
	}
	
	public boolean findPath(int[][] a,int x,int y,int n,String name){
		if(x==n-1 && y==n-1){
			a1[x][y]=1;
			return true;
		}
		if(isSafePath(a,x,y,n)){
			a1[x][y]=1;
			if(name!="up"&&findPath(a,x+1,y,n,"down")){
				return true;
			}
			if(name!="left"&&findPath(a,x,y+1,n,"right")){
				return true;
			}
			if(name!="down"&&findPath(a,x-1,y,n,"up")){
				return true;
			}
			if(name!="right"&&findPath(a,x,y-1,n,"left")){
				return true;
			}
			a1[x][y]=0;
			return false;
		}
		return false;
	}
	
	public boolean isSafePath(int[][] a,int x,int y,int z){
		if(x>=0 && y>=0 && x<z && y<z && a[x][y]!=0)
			return true;
		else
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
		int N = 5;
		int[][] maze = { { 1, 0, 1, 1,1 }, { 1, 1, 1, 0,1 }, { 0, 0,0, 1, 1 },
				{ 0, 0, 0, 1,0 },{ 0, 0,0, 1, 1 } };
		RatInMaze r = new RatInMaze(N);
		r.solveMaze(maze, N);
	}
}
