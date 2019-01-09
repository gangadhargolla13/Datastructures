package com.java.core.recurtion;

public class QuickSort {

	int [] a ;
	public QuickSort(int[] a){
		this.a=a;
	}
	public void quickS(int low,int high){
		int m = (low + high)/2;
		int l = low;
		int r = high;
		int p = a[m];
		while(l<=r){
			while(a[l]<p){
				l++;
			}
			while(a[r]>p){
				r--;
			}
			if(l<=r)
			{
				int t = a[l];
				a[l]=a[r];
				a[r]=t;
				l++;
				r--;
			}
		}
		if(low<r)
			quickS(low,r);
		if(l<high)
			quickS(l,high);
	}
	
	public void display() {
		for (int i = 0; i < a.length; i++) {
			System.out.print(" " + a[i]);
		}
	}
	
	public static void main(String[] args) {
		int a[] = { 6, 2, 4, 12, 10 };
		QuickSort i = new QuickSort(a);
		System.out.print("UnSorted : ");
		i.display();
		i.quickS(0, a.length - 1);
		System.out.println("");
		System.out.print("Quick Sorted : ");
		i.display();
	}
}
