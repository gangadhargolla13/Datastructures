package com.java.core.recurtion;

public class BinarySearch {

	private int[] arr ;
	
	public BinarySearch(int[] arr){
		this.arr=arr;
	}
	public boolean checkSearch(int s,int e,int n){
		if(s>e)
			return false;
		int mid = s +((e-s)/2);
		if(arr[mid]==n)return true;
		else if(arr[mid]>n) return checkSearch(s,mid-1,n);
		else 
			return checkSearch(mid+1,e,n);
	}
	
	public static void main(String[] arrs){
		int[] a = {2,5,8,10,14,44,77,78,99};
		int num = 97;
		BinarySearch b = new BinarySearch(a);
		if(b.checkSearch(0,a.length, num)){
			System.out.println("Element is found");
		}else
			System.out.println("Element is not found");
	}
}
