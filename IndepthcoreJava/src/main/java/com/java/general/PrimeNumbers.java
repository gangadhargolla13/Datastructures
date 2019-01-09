package com.java.general;

import java.util.Scanner;

public class PrimeNumbers {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the values to print prime numbers");
		int n = sc.nextInt();
		for(int i=2;i<=n;i++)
		{
			if(isPrime(i))
			{
				System.out.println(i);
			}
		}
	}
	
	public static boolean isPrime(int n){
		for(int i=2;i<n;i++ ){
			if(n%i==0)
			{
				return false;
			}
		}
		return true;

			
	}
}
