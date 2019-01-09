package com.java.core.dp;

public class SnakeSequence {

	public void findSnakePath(int[][] a){
		int row = a.length;
		int col= a[0].length;
		int max = 1;
		int mrow=0,mcol=0;
		int[][] re = new int[row][col];
		for(int i=0;i<row;i++){
			for(int j=0;j<col;j++){
				re[i][j]=1;
			}
		}
		for(int i=0;i<row;i++){
			for(int j=0;j<col;j++){
				if(i!=0||j!=0){
					if(i>0 && Math.abs(a[i][j]-a[i-1][j])==1){
						re[i][j]=Math.max(re[i][j],re[i-1][j]+1);
						if(max<re[i][j]){
							max=re[i][j];
							mrow = i;
							mcol = j;
						}
					}
					
					if(j>0 && Math.abs(a[i][j]-a[i][j-1])==1){
						re[i][j]=Math.max(re[i][j],re[i][j-1]+1);
						if(max<re[i][j]){
							max=re[i][j];
							mrow = i;
							mcol = j;
						}
					}
				}
			}
		}
		System.out.println("Max length is "+max);
		print(a,re,max,mrow,mcol);
	}
	
	public void print(int[][] a,int[][] b,int le,int r,int c){
		while(le>=1){
			System.out.print("-"+a[r][c]);
			if(r>0&&Math.abs(b[r-1][c]-b[r][c])==1){
				r--;
			}else if(c>0 && Math.abs(b[r][c-1]-b[r][c])==1){
				c--;
			}
			le--;
		}
	}
	
	public static void main(String[] args) {
		 int arrA [][] = {{1, 2, 1, 2},
                 {7, 7, 2, 5},
                 {6, 4, 3, 4},
                 {1, 2, 2, 5}};
		 SnakeSequence s = new SnakeSequence();
		 s.findSnakePath(arrA);
	}
}
