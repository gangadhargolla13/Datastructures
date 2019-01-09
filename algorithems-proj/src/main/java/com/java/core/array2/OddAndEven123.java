package com.java.core.array2;

import java.util.Arrays;
import java.util.Scanner;

public class OddAndEven123 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int s = sc.nextInt();
		int[] arr = new int[s];
		for(int i=0;i<s;i++)
		{
			arr[i]=sc.nextInt();
		}
		int oddInd = 1;
	    int evenInd = 0;
	    while (true)
	    {
	        while (evenInd < s && arr[evenInd] % 2 == 0)
	            evenInd += 2;
	             
	        while (oddInd < s && arr[oddInd] % 2 == 1)
	            oddInd += 2;
	             
	        if (evenInd < s && oddInd < s)
	            {
	                int temp = arr[evenInd];
	                arr[evenInd] = arr[oddInd];
	                arr[oddInd] = temp;
	            }
	             
	        else
	            break;
	    }
	    System.out.println(Arrays.toString(arr));
	}
}
