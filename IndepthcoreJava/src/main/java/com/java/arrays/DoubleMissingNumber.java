package com.java.arrays;

public class DoubleMissingNumber {

	public static void main(String[] args) {
		int A[] = { 1, 2, 3,5,6 };
		int A1[] = { 60, 62,63,64,65,66,67,68,69 };
		int range = 10;
		System.out.println("MIssing No is :" + missingNo(A1, range));
		//System.out.println("MIssing No is :" + missingNo(A, range));
		//missingNo1(A, range);
	}
	public static int missingNo(int arrA[], int range) {
		int A = 0;
		int B = 0;
		for (int i = 1; i <= range; i++) {
			A = A ^ i;
			System.out.println(A);
		}
		for (int i = 0; i < arrA.length; i++) {
			B = B ^ arrA[i];
		}
		return A ^ B;
	}
	
	public static void missingNo1(int arrA[], int range) {
		int A = 0;
		int B = 0;
		for (int i = 1; i <= range; i++) {
			A = A ^ i;
		}
		for (int i = 0; i < arrA.length; i++) {
			B = B ^ arrA[i];
		}
		
		int m= A ^ B;
		System.out.println(m + " "+A+" "+B);
		int m1 = m & ~(m-1);
		System.out.println(m1);
		int x = 0, y = 0;
		for (int i = 0; i < range-2; i++)
	    {
	        if ((arrA[i]&m1) == m1)
	        {
	            x = x ^ arrA[i]; 
	        }else
	            y = y ^ arrA[i]; 
	    }
	    for (int i = 1; i <= range; i++)
	    {
	        if ((i&m1) == m1)
	            x = x ^ i; 
	        else
	            y = y ^ i; 
	    }
	    System.out.println("x: "+x+" "+"Y: "+y);
	}
}
