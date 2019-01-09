package com.java.core.recurtion;

public class CountAllPaths {

	int rc;
	int cc;
	int[][]a;
	
	public CountAllPaths(int[][]a){
		this.a=a;
		rc=a.length;
		cc=a[0].length;
	}
	
	public int crecution(int cr,int ccc){
		if(cr==rc-1)
			return 1;
		if(ccc==cc-1)
			return 1;
		int m = crecution(cr+1,ccc)+crecution(cr,ccc+1)+crecution(cr+1,ccc+1);
		return m;
	}
	
	public int cdyanmic(int[][] a1){
		int[][] result = new int[a1.length][a1[0].length];
		for(int i=0;i<a1.length;i++){
			result[i][0]=1;
		}
		for(int i=0;i<a1[1].length;i++)
			result[0][i]=1;
		for(int i=1;i<a1.length;i++){
			for(int j=1;j<a1[1].length;j++)
				result[i][j]=result[i-1][j]+result[i][j-1]+result[i-1][j-1];
		}
		return result[a1.length-1][a1[0].length-1];
	}
	
	public static void main(String[] args) {
		int[][] a = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		CountAllPaths path = new CountAllPaths(a);
		int m = path.cdyanmic(a);
		System.out.println(m);
		m = path.crecution(0, 0);
		System.out.println(m);
		
	}
}
