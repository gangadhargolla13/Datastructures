package com.java.core.hashtable;

import java.util.Arrays;

public class SumCloseToZero {
	 public int findSum(int [] a){
	        Arrays.sort(a);
	        int i=0;
	        int j = a.length-1;
	        int positiveClose = Integer.MAX_VALUE;
	        int negativeClose = Integer.MIN_VALUE;
	        while(i<j){
	            int temp = a[i] + a[j];
	            if(temp>0){
	                if(positiveClose>temp){
	                    positiveClose = temp;
	                }
	                j--;
	            }else if(temp<0){
	                if(negativeClose<temp){
	                    negativeClose = temp;
	                }
	                i++;
	            }else{
	                return 0;
	            }
	        }
	        return Math.min(Math.abs(positiveClose), Math.abs(negativeClose));
	    }
	    public static void main(String[] args) {
	        int a [] = {1, 4, -5, 3, -2, 10, -6, 20};
	        int closestSum = new SumCloseToZero().findSum(a);
	        System.out.println("Sum close to zero in the given array is : " + closestSum);
	    }
}
