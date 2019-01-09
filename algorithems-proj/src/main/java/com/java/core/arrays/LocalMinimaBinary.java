package com.java.core.arrays;

public class LocalMinimaBinary {

	static int find(int[] a,int start,int end){
		int mid = start + (end-start)/2;
		int size = a.length;
		if((mid==0 || a[mid-1]>a[mid]) && (mid==size-1 || (a[mid]<a[mid+1]))){
			return a[mid];
		}
		else if(mid > 0 && a[mid]>a[mid-1])
		{
			return find(a,start,mid);
		}else
		{
			return find(a,mid+1,end);
		}
	}
	public static void main(String[] args) {
        LocalMinimaBinary l = new LocalMinimaBinary();
        int [] arrA = {11, 4, 2, 5, 11, 13, 5};
        System.out.println("Local Minima is: " + l.find(arrA,0,arrA.length));
    }
}
