package com.java.strings;

import java.util.Random;
import java.util.Scanner;

public class GeneratingRandom {

	public static void main(String[] args) {
		int len,i,ran;
		Random random = new Random();
		Scanner sc = new Scanner(System.in);
		System.out.println("How many random numbers you want generate ?");
		len = sc.nextInt();
		System.out.print("\nGenerating " + len + " Random Numbers in the range 0...999 \n");
		for(i=0;i<len;i++){
			ran = random.nextInt(1000);
			System.out.println(ran+"  ");
		}
		sc.close();
	}
}
