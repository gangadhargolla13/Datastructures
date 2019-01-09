package com.java.amazon.inter;

public class MaxDifference {
  // by divided and concure approach
   public  int maxDifference(int[] arr,int start,int end)
   
   {
	   if(start >=end)
	   {
		   return -1;
	   }
	   int mid = start +  (end-start)/2;
	   int leftDiff = maxDifference(arr,start,mid);
       int rightDiff = maxDifference(arr,mid+1,end);
       int minLeft = getMin(arr, start, mid);
       int maxRight = getMax(arr, mid, end);
       int centerDiff = maxRight - minLeft;
       return Math.max(centerDiff, Math.max(leftDiff,rightDiff));
   }
   public int getMin(int [] A, int i, int j){
       int min = A[i];
       for (int k = i+1; k <=j ; k++) {
           if(A[k]<min)
               min = A[k];
       }
       return min;
   }
   public int getMax(int [] A, int i, int j){
       int max = A[i];
       for (int k = i+1; k <=j ; k++) {
           if(A[k]>max)
               max = A[k];
       }
       return max;
   }
   //By Dynamic programming
   public static int maxDifference(int [] A){
       int size = A.length;
       int maxDiff = -1;
       int max_so_far = A[size-1]; //assign the last element
       for (int i = size - 2 ; i >0 ; i--) {
           if(max_so_far<A[i])
               max_so_far = A[i];
           else if(max_so_far>A[i])
               maxDiff = Math.max(maxDiff,max_so_far-A[i]);
       }
       return maxDiff;
   }
   public static void main(String[] args) {
	   MaxDifference m = new MaxDifference();
       int [] A = { 2, 5, 1, 7, 3, 4, 9, 4, 5};
       int start = 0;
       int end = A.length-1;
       System.out.println("Maximum Difference between two elements A[i] and A[j] and where j > i: " +
               m.maxDifference(A, start, end));
   }
}
