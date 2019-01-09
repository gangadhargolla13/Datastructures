package com.java.arrays;

import java.util.Arrays;

public class Findsubarray {
	public static void main(String[] args) {
		Findsubarray sub =new Findsubarray();
		sub.largestSumContiguousSubarray(new int[] {-1, 3, -5, 4, 6, -1, 2, -7, 13, -3});
		int arr[] = {1, 56, 58, 57, 90, 92, 94, 93, 91, 45};
        int n = arr.length;
		System.out.println(sub.findLength(arr,n));
	}

	private void largestSumContiguousSubarray(int arry[]) {
		int len = arry.length;
		int start,end,maxSum;
		int maxSumSoFar = -2147483648;
	    int curSum = 0;
	    int a =0, b =0, s =0, i = 0;
	    for( i = 0; i < len; i++ ) {
	        curSum += arry[i];
	        if ( curSum > maxSumSoFar ) {
	            maxSumSoFar = curSum;
	            a = s;
	            b = i;
	        }
	        if( curSum < 0 ) {
	            curSum = 0;
	            s = i + 1;
	        }
	    }
	    start = a;
	    end = b;
	    maxSum = maxSumSoFar;
		System.out.println("Max Sum is " + maxSum);
		System.out.println("Start index  is " + start + " End index "
				+ end);
	}
	
	int min(int x, int y) 
    {
        return (x < y) ? x : y;
    }
 
    int max(int x, int y) 
    {
        return (x > y) ? x : y;
    }
    
    int findLength(int arr[], int n) 
    {
        int max_len = 1;  
        for (int i = 0; i < n - 1; i++) 
        {
            int mn = arr[i], mx = arr[i];
 
            for (int j = i + 1; j < n; j++) 
            {
                mn = min(mn, arr[j]);
                mx = max(mx, arr[j]);
                if ((mx - mn) == j - i)
                    max_len = max(max_len, mx - mn + 1);
            }
        }
        return max_len; 
    }
    
    //merging two two arrays
    public int[] mergeArray(int[] a,int[] b){
    	int[] c = new int[a.length+b.length];
    	System.arraycopy(a, 0, c, 0, a.length);
    	System.arraycopy(b, 0, c, a.length, b.length);
    	return c;
    }
}
