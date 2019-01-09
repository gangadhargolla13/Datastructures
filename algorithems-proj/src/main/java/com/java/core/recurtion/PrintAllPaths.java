package com.java.core.recurtion;

public class PrintAllPaths {

	int rowCount;
	int columnCount;
	int[][] a;
	
	public PrintAllPaths(int row,int col,int[][] a){
		this.a=a;
		rowCount=row;
		columnCount=col;
	}
	
	public static void main(String[] args) {
		int[][] a = { { 1, 2, 3 }, { 4, 5, 6 },{7,8,9} };
		PrintAllPaths p = new PrintAllPaths(a.length,a[0].length,a);
		p.print(0, 0, "");
	}
	
	public void print(int crow,int ccol,String path){
		//System.out.println("crow "+crow +" ccol "+ccol);
		if(crow==rowCount-1){
			for(int i=ccol;i<columnCount;i++){
				path+="-"+a[crow][i];
			}
			System.out.println(path);
			return;
		}
		if(ccol==columnCount-1){
			for(int i=crow;i<rowCount;i++){
				path+="-"+a[i][ccol];
			}
			System.out.println(path);
			return;
		}
		
		path=path +"-"+a[crow][ccol];
		print(crow+1,ccol,path);
		print(crow,ccol+1,path);
		print(crow+1,ccol+1,path);
	}
}
