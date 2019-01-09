package com.java.core.FinalAlgotithems;

public class FindPeakElement {

	public int returnPeak(int[] a,int l,int h,int n)
	{
		int m = l+(h-l)/2;
		if((m==0||a[m]>=a[m-1])&&(a[m]>=a[m+1]||m==n-1))
			return a[m];
		else if (a[m]<a[m-1]) return returnPeak(a,l,m-1,n);
		else return returnPeak(a,m+1,h,n);
	}
	public static void main(String[] args) {
		int[] arrA = { 1,2,3,4,0,1,5,4,3,2,1 };
		FindPeakElement e = new FindPeakElement();
		int m =e.returnPeak(arrA, 0, arrA.length-1, arrA.length);
		System.out.println(m);
	}
}
