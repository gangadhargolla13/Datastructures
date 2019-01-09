package com.java.core.recurtion;

public class MergeShort {

	private int asize;
	private int[] ainput;
	private int[] aaux;
	
	public MergeShort(int[] a){
		ainput = a;
		asize = a.length;
	    aaux = new int[asize];
	}
	
	public int[] mergeSort(){
		sort(0,asize-1);
		return ainput;
	}
	
	public void sort(int low , int high){
		if(low < high){
			int mid = low + ((high-low))/2;
			sort(low,mid);
			sort(mid+1,high);
			merge(low,mid,high);
		}
	}
	
	public void merge(int low ,int mid , int high){
		for(int i=low;i<=high;i++){
			aaux[i]= ainput[i];
		}
		int i = low;
		int j = mid+1;
		int k = low ;
		
		while(i<=mid&&j<=high){
			if(aaux[i]<=aaux[j]){
				ainput[k]= aaux[i];
				i++;
			}
			else{
				ainput[k]= aaux[j];
			j++;
			}
			k++;
		}
		while(i<=mid){
			ainput[k]= aaux[i];
			i++;
			k++;
		}
	}
	
	public void displayArray(int [] b){
		for(int i=0;i<b.length;i++){
			System.out.print(" " + b[i]);
		}
	}
	
	public static void main(String[] args) {
		int [] a = {2,1,6,3,9,4,5,10};
		MergeShort m = new MergeShort(a);
		int [] b = m.mergeSort();
		m.displayArray(b);
	}
}
