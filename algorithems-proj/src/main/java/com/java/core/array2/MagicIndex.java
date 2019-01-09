package com.java.core.array2;

public class MagicIndex {
	public int search(int[] arr,int s,int e){
		if(s<=e){
			int m = s+(e-s)/2;
			if(m==arr[m]){
				return m;
			}
			if(m<arr[m]){
				return search(arr,s,m);
			}
			else
				return search(arr,m+1,e);
		}
		return -1;
	}
	public static void main(String[] args) {
		int[] A = { -1, 0, 1, 2, 4, 10 };
		MagicIndex m = new MagicIndex();
		System.out.println("Magic index " + m.search(A, 0, A.length - 1));
	}
	
}
