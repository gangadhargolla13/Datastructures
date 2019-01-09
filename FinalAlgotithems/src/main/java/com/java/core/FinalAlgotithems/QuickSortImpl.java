package com.java.core.FinalAlgotithems;

public class QuickSortImpl {

	public static int[] a = { 2,10,4,12,6 }; 
	public static void display()
	{
		for(int i=0;i<a.length;i++)
		{
			System.out.print(" "+a[i]);
		}
	}
	
	public static void quickSort(int low,int high)
	{
		int m = (low+high)/2;
		int left = low;
		int right = high;
		int pivot =a[m];
		while(left<=right)
		{
			while(a[left]<pivot)
				left++;
			while(a[right]>pivot)
				right--;
			
			if(left<=right)
			{
				int tmp = a[left];
				a[left] = a[right];
				a[right]=tmp;
				left++;
				right--;
			}
		}
		if(low<right)
			quickSort(low,right);
		if(left<high)
			quickSort(left,high);
	}
	
	public static void main(String[] args) {
	display();
	quickSort(0,a.length-1);
	System.out.println();
	display();
	}
}
