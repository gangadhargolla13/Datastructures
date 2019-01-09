package com.java.core.arrays;

public class MergeSorting 
{
	private int[] tempMergArr;
	 public static int[] inputArr  = {45,23,11,89,77,98,4,28,65,43};
	 private int[] array;
	 public void sort(int[] arra)
	 {
		 array=arra;
		 sorting(0,array.length-1);
	 }
	public void sorting(int low,int high){
		if(low < high){
			int middle = low + (high-low)/2;
			sorting(low,middle);
			sorting(middle+1,high);
			mergePart(low,middle,high);
		}
	}
	
	public void mergePart(int l,int m,int h){
		for(int i=l;i<=h;i++)
		{
			tempMergArr[i]=array[i];
		}
		int i=l;
		int j=m+1;
		int k=l;
		while(i<=m&&j<=h)
		{
			if(tempMergArr[i]<tempMergArr[j])
			{
				array[k]=tempMergArr[i];
				i++;
			}else
			{
				array[k]=tempMergArr[j];
				j--;
			}
			k++;
		}
		while(i<=m)
		{
			array[k]=tempMergArr[i];
			i++;
			k++;
		}
	}
	public static void main(String[] args) {
		 
		MergeSorting sort = new MergeSorting();
		sort.tempMergArr = new int[inputArr.length];
		sort.sort(inputArr);
	}
}
