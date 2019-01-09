package com.java.forloop;

import java.util.Scanner;

public class FloydsExample {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Range (Upto how many valued ? )");
		int range,i,j,k=1;
		range = sc.nextInt();
		System.out.print("Floyd's Triangle :\n");
		for(i=1;i<=range;i++){
			for(j=1;j<=i;j++,k++){
				System.out.print(k+" ");
			}
			System.out.println();
		}
		sc.close();
	}
}
