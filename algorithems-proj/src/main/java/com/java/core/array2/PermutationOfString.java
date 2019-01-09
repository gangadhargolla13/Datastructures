package com.java.core.array2;

public class PermutationOfString {

	char[] a;
	public void permutation(char[] arr,int left,int size){
		int x;
		if(left==size){
			for(int i=0;i<arr.length;i++){
				System.out.print(arr[i]);
			}
			System.out.println(" ");
		}else{
			for(x=left;x<size;x++){
				swap(arr,left,x);
				permutation(arr,left+1,size);
				swap(arr,left,x);
			}
		}
	}
	public void swap(char[] arr,int i,int j){
		char c = arr[i];
		arr[i]= arr[j];
		arr[j]= c;
	}
	
	public static void main(String[] args) {
		String s = "abcd";
		char[] arrCh = s.toCharArray();
		PermutationOfString i = new PermutationOfString();
		i.permutation(arrCh, 0, arrCh.length);
	}
}
