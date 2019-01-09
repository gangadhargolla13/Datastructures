package com.java.core.DPBK;

public class SmallSquareRoot {

	public static void main(String[] args) {
		int val=26;
		findMinimal(val);
	}
	
	public static void findMinimal(int v){
		int m = (int)Math.sqrt(v);
		int[] mn = new int[v+1];
		int[] num = new int[m+1];
		for(int n=1;n<=v;n++){
			for(int j=0;j<=m;j++){
				num[j]=0;
			}
			for(int j=1;j<=m;j++){
				if(j*j<=n)
				{
					num[j]=mn[n-j*j]+1;
				}
			}
			mn[n]=-1;
			for(int j=1;j<num.length;j++)
			{
				if(num[j]>0 && (mn[n]==-1||mn[n]>num[j]))
				{
					mn[n]=num[j];
				}
			}
		}
		System.out.println(" "+mn[v]);
	}
}
