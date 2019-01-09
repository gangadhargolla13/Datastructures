package com.java.arrays.twodim;

import java.io.IOException;
import java.util.Scanner;

public class PrintvaluesOf2d {

	public static void main(String[] args) throws IOException{
		String[][] s = {
				{
					"Ganga","suji","ganesh"
				},
				{
					"Malli","lakshmi","gopi"
				},
				{
					"Raju","Gayathri","jahnavi","jannavi"
				}
		};
		for(int i=0;i<s.length;i++)
		{
			for(int j=0;j<s[i].length;j++){
				System.out.println(s[i][j]);
				
				//System.out.println("The elemsts location is array["+i+"]["+j+"] ----->"+s[i][j]);
			}
			break;
		}
		/*Scanner sc = new Scanner(System.in);
		System.out.println("Please enter row size");
		int rSize = sc.nextInt();
		System.out.println("The name is "+rSize);
		System.out.println("Please enter coloums size");
		int cSize = sc.nextInt();
		int[][] array = new int[rSize][cSize];
		for(int i=0;i<array.length;i++)
		{
			for(int j=0;j<array[i].length;j++){
				array[i][j] = sc.nextInt();
			}
		}
		System.out.println("Operation is comepleted");
		
		for(int i=0;i<array.length;i++)
		{
			for(int j=0;j<array[i].length;j++){
				System.out.println("The elemsts location is array["+i+"]["+j+"] ----->"+array[i][j]);
			}
		}*/
	}
}
