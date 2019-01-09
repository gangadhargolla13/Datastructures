package com.java.core.first;

public class LocalMinimaBinary {

	public int find(int[] a,int s,int e){
		int m = s+(e-s)/2;
		if((m==0 || a[m] < a[m-1]) && (a[m]<a[m+1] || m==a.length))
			return a[m];
		else if(a[m]>a[m-1])
			return find(a,s,m);
		else
			return find(a,m+1,e);
	}
	
	public static void main(String[] args) {
		int [] arrA = {1,2,3,4};
		LocalMinimaBinary l = new LocalMinimaBinary();
		int s = l.find(arrA, 0, arrA.length);
		System.out.println(s);
	}
}
