package com.java.core.hashtable;

public class MaxRepeatingElement {
	public void MaxRepeatingElementInPlace(int [] arrA){
	 int size = arrA.length;
     int maxCount=0;
     int maxIndex=0;
     for (int i = 0; i <size ; i++) {
         int index = arrA[i]% size;
         arrA[index] = arrA[index] + size;
     }
     for (int i = 0; i <size ; i++) {
         if(arrA[i]/size>maxCount){
             maxCount=arrA[i]/size;
             maxIndex=i;
         }
     }
     System.out.println("Element repeating maximum no of times: " + maxIndex + ", maximum count: " + maxCount);
 }
	
	 public void hasDuplicates(int[] arrA) {

	        for (int i = 0; i < arrA.length; i++) {
	            if (arrA[Math.abs(arrA[i])] < 0) {
	                System.out.println("Array has duplicates : " + Math.abs(arrA[i]));
	            } else {
	                arrA[Math.abs(arrA[i])] = arrA[Math.abs(arrA[i])] * -1;
	            }
	        }
	    }
	
	public static void main(String[] args) {
        int [] arrA = {4, 1, 5, 2, 1, 5, 9, 8, 6, 5, 3, 2, 4, 7};
        MaxRepeatingElement m = new MaxRepeatingElement();
        m.MaxRepeatingElementInPlace(arrA);
        
        int a[] = {1, 6, 5, 2, 3, 3, 2};
        m.hasDuplicates(a);
    }
}
