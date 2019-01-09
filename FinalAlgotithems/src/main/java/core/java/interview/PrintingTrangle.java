package core.java.interview;

import java.util.Scanner;

public class PrintingTrangle {

	public static void main(String[] args) {
		System.out.println("I am not sure!");
		System.out.println("Please enter number");
		Scanner sc = new Scanner(System.in);
		int value = sc.nextInt();
		sc.close();
		for(int i=1;i<=value;i++)
		{
			for(int j=value;j>i;j--)
			{
				System.out.print(" ");
			}
			for(int k=1;k<=(2*i-1);k++)
			{
				System.out.print("*");
			}
			System.out.println();
		}
	}
}
