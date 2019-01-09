package com.java.core.arrays;

public class FindRepeating {

	public static void printRep(int[] a){
		int xor = a[0];
		for(int i=1;i<a.length;i++){
			xor ^=a[i];
		}
		System.out.println(~(xor));
		int right = xor & ~(xor-1);
		System.out.println(right);
		int c=0,b=0;
		for(int i=0;i<a.length;i++){
			int x= a[i];
			if((x&right)!=0)
			{
				System.out.println(x);
				b^=x;
			}
			else
			{
				c^=x;
			}
		}
		System.out.println(b+","+c);
	}
	
	public static void main(String[] args) {
		printRep(new int[]{4,5,4,5,3,2,9,3,9,8});
	}
}
