package com.java.core.recurtion;

public class PrintAllSubArrays {

	public static void print(int[] a){
		int arrSize = a.length;
		for (int startPoint = 0; startPoint <arrSize ; startPoint++) {
            for (int grps = startPoint; grps <=arrSize ; grps++) {
            	for (int j = startPoint ; j < grps ; j++) {
                    System.out.print(a[j] + " ");
                }
                System.out.println();
            }
         }
	}
	public static void main(String[] args) {
		 int [] arrA = {1,2,3, 4};
		 print(arrA);
	}
}
