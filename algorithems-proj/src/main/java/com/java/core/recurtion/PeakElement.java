package com.java.core.recurtion;

public class PeakElement {

	public static void main(String args[]){
		PeakElement pe = new PeakElement();
		int arrA[] = { 1,2,3,4,0,1,5,4,3,2,1};
		int peakEle = pe.peak(arrA, 0, arrA.length-1, arrA.length);
		System.out.println("Peak Element is found at index [" + peakEle +"] = "+ arrA[peakEle]);
	}
	
	public int peak(int [] arrA,int low, int high, int size){
		int mid = (low+high)/2;
		if((mid==0||arrA[mid]>=arrA[mid-1]) && (arrA[mid]>=arrA[mid+1]||mid==size-1)){
			return mid;
		}
		else if(mid>0 && arrA[mid]<arrA[mid-1]) return peak(arrA,low,mid-1,size);
		else return peak(arrA,mid+1,high,size);
	}
}
