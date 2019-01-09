package com.java.core.array2;

import java.util.Arrays;
import java.util.Scanner;

public class OddEvenNumbers {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int s = sc.nextInt();
		int[] v = new int[s];
		for(int i=0;i<s;i++)
		{
			v[i]=sc.nextInt();
		}
		 for(int j=0;j<s;j++)
		 {
			 int m=j+1;
			 if(j==0||j%2==0)
			 {
				 if(v[j]%2==0)
				 {
					 continue;
				 }
				 else
				 {
					 def:
						 while(m<v.length)
					 {
						 if(v[m]%2 != 0)
						 {
							 int tmp=v[m];
							 v[m]=v[j];
							 v[j]=tmp;
							 break def;
						 }
						 m++;
					 }
				 }
				 
			 }
			 else
			 {
				 if(v[j]%2!=0)
				 {
					 continue;
				 }
				 else
				 {
					 def:while(m<v.length)
					 {
						 if(v[m]%2==0)
						 {
							 int tmp=v[m];
							 v[m]=v[j];
							 v[j]=tmp;
							 break def;
						 }
						 m++;
					 }
				 }
			 }
		 }
		 System.out.println(Arrays.toString(v));
		sc.close();
	}
}
