package com.java.core.recurtion;

public class MaximumSubArray {

	public int maxSubArray(int [] A){
        if(A.length==0)//if length  = 0, return 0
            return 0;
        else
            return maxSubArray(A, 0, A.length-1);
    }
	
	public int maxSubArray(int [] A, int start, int end){
		if(start==end){
			return A[start];
		}
         int mid= start + (end-start)/2;
         int leftMaxSum=maxSubArray(A,start,mid);
         int rightMaxSum = maxSubArray(A,mid+1,end);
         int sum=0;
         int leftMidSum=0;
         for(int i=mid;i>=start;i--){
        	 sum+=A[i];
        	 if(sum>leftMidSum)
        		 leftMidSum=sum;
         }
         
         sum=0;
         int rightMidSum=0;
         for(int i=mid+1;i<=end;i++){
        	 sum+=A[i];
        	 if(sum>rightMidSum)
        		 rightMidSum=sum;
         }
         int csum = rightMidSum+leftMidSum;
         return Math.max(csum,Math.max(rightMaxSum, leftMaxSum));
	}
	public static void main(String[] args) {
		int [] A = {-2, 12, -5, 10, -1, -6, 4};
        MaximumSubArray m =  new MaximumSubArray();
        System.out.println("Maximum Sub Array sum is : " + m.maxSubArray(A));
	}
}
