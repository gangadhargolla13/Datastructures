package com.java.core.arrays;

public class Boyer_Moore {
	 public static void find(int [] arrA) {
	        int size = arrA.length;
	        if(size==0)
	            return;

	        int majorityElement = arrA[0];
	        int count = 1;
	        for (int i = 1; i <size ; i++) {
	        	System.out.println("majorityElement "+majorityElement);
	            if(majorityElement==arrA[i]){
	                count++;
	            }else if(count==0){
	                majorityElement = arrA[i];
	                count = 1;
	            }else {
	                count --;
	            }
	        }
	        //check if majorityElement is appearing more than n/2 times
	        count = 0;
	        for (int i = 0; i < size ; i++) {
	            if(arrA[i]==majorityElement){
	                count++;
	            }
	        }
	        if (count>size/2)
	            System.out.println("(Boyer_Moore)Element appearing more than n/2 times: " + majorityElement);
	        else
	            System.out.println("No element appearing more than n/2 times");
	    }

	    public static void main(String[] args) {
	        int [] arrA = {1,5,6,5,8,5,5,5};
	        find(arrA);
	    }
}
