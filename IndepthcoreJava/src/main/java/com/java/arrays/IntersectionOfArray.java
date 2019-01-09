package com.java.arrays;

import java.util.Arrays;

public class IntersectionOfArray {
	int[] first;
	int[] second;

	
	public static void main(String[] args) {
		IntersectionOfArray of= new IntersectionOfArray(new int[]{2,5,3,7,4,9},new int[]{5,2,9,0,1,4});
		of.intersection();
		int miss = of.exceptOne(new int[]{6,3,9,4,9,6,3,});
		System.out.println(miss);
		System.out.println("=================");
		int [] A = {1,2,3,4,5,6,7,8,9,10};
		int [] B = {1,3,5,6,7,8,12};
		int [] C = {2,3,4,5,8,9};
		of.commonElement(A, B, C);
	}

	public IntersectionOfArray(int[] value1, int[] value2) {
		first = value1;
		second = value2;
	}

	public void intersection() {
		int c = 0;
		System.out.println(Arrays.toString(first));
		System.out.println(Arrays.toString(second));
		int[] local = new int[first.length + second.length];
		for (int i = 0; i < first.length; i++) {
			for (int j = 0; j < second.length; j++) {
				if (first[i] == second[j]) {
					local[c] = first[i];
					c++;
				} else {
					continue;
				}
			}
		}
		int[] dest = new int[c];
		System.arraycopy(local, 0, dest, 0, c);
		System.out.println(Arrays.toString(dest));
	}
	
	public int exceptOne(int[] values){
		int result =0;
		for(int x:values){
			result = result ^ x;
		}
		return result;
	}
	
	public void commonElement(int[] a,int[]b,int[]c){
		int i=0,j=0,k=0;
		while(i<a.length&&j<b.length&&k<c.length){
			if((a[i]==b[j])&&(b[j]==c[k])){
				System.out.print(a[i]+" ");
				i++;j++;k++;
			}else if((a[i]<=b[j])&&(a[i]<=c[k])){
				i++;
			}else if((b[j]<=a[i])&&(b[j]<=c[k])){
				j++;
			}else{
				k++;
			}
		}
		
	}
}

class A{
	int a;
	A(int a){
		this.a=a;
	}
	public void setA(int a){
		this.a=a;
	}
	public String toString(){
		return String.valueOf(a);
	}
}
