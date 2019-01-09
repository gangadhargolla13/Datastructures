package com.java.core.maths;

import java.util.Scanner;

public class PrimeNumbersEx {

	public static boolean isPrime(int num) {
		if (num == 2 || num == 3) {
			return true;
		}
		if (num % 2 == 0 || num % 3 == 0) {
			return false;
		}
		for (int i = 3; i < Math.sqrt(num); i += 2) {
			if (num % i == 0 || num % Math.sqrt(num) == 0) {
				return false;
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Please enter how many numbers to print");
		int val = sc.nextInt();
		for(int i=2;i<=val;i++)
		{
			if(isPrime(i))
			{
				System.out.print(i+" ");
			}
		}
	   sc.close();
	}

}
