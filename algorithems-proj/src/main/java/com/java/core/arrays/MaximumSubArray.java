package com.java.core.arrays;

public class MaximumSubArray {

	public static int maxSub(int[] a){
		if(a.length==0){
			return 0;
		}
		else{
			return maxSub(a,0,a.length-1);
		}
	}
	public static int maxSub(int[] a,int s,int e){
		if(s == e){
			return a[s];
		}
		int m = s + (e-s)/2;
		int left = maxSub(a,s,m);
		int right = maxSub(a,m+1,e);
		int sum=0;
		int li =0;
		for(int i=m;i>=s;i--)
		{
			sum+=a[i];
			if(sum>li)
			{
				li= sum;
			}
		}
		
		sum=0;
		int ri=0;
		for(int i=m+1;i<=e;i++){
			sum+=a[i];
			if(sum>ri)
				ri= sum;
		}
		int cs=li+ri;
		int ma=Math.max(cs, Math.max(left,right));
		return ma;
	}
	 public static void main(String[] args) {
	        int [] A = {-12, 2, -5, 10, -1, 6, 4};
	        System.out.println("Maximum Sub Array sum is : " + maxSub(A));
	    }
}
