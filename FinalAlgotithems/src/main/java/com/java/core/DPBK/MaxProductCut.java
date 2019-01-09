package com.java.core.DPBK;

public class MaxProductCut {

	public static void maxCut(int n)
	{
		int[] mp = new int[n+1];
		mp[1]=0;
		for(int i=2;i<n+1;i++){
			int t =Integer.MIN_VALUE;
			for(int j=1;j<i;j++)
			{
				t=Math.max(t, Math.max(j*mp[i-j], j*(i-j)));
			}
			mp[i]=t;
		}
		System.out.println(mp[n]);
	}
	
	public static void maxSubArraySum(int[] a){
		int[] s = new int[a.length+1];
		s[0]=0;
		for(int j=1;j<s.length;j++){
			s[j]=Math.max(s[j-1]+a[j-1], a[j-1]);
		}
		int r=s[0];
		for(int j=1;j<s.length;j++)
		{
			if(r<s[j])
				r=s[j];
		}
		System.out.println(r);
	}
	public static void main(String[] args) {
		maxCut(10);
		int arrA[] = { 1, 2, -3, -4, 2, 7, -2, 3 };
		maxSubArraySum(arrA);
	}
}
