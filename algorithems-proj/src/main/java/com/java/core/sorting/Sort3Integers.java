package com.java.core.sorting;

public class Sort3Integers {
	public static void main(String[] args) {
		int x = 4;
		int y = 1;
		int z = 9;
		Sort3Integers s = new Sort3Integers();
		s.sort(x, y, z);
	}
	
	public void sort(int x,int y,int z){
		int max,min,mid;
		max = Math.max(x, Math.max(y, z));
		min = -Math.max(-x, Math.max(-y, -z));
		mid = (x+y+z)-(max+min);
		System.out.println("Sorted order " + min + " " + mid + " " + max);
	}
}
