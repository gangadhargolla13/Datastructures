package com.java.core.recurtion;

import java.util.Arrays;

public class GC {
int [] a;
	public static void main(String[] args) {
		//System.out.println(gcd(156,282));
		GC f = new GC();
		f.a=new int[3];
		f.nbits(3);
	}
	
	public void nbits(int n){
		if(n<=0)
			System.out.println(Arrays.toString(a));
		else{
			a[n-1]=0;
		    nbits(n-1);
		    a[n-1]=1;
		    nbits(n-1);
		}
	}
	public static int gcd(int a,int b){
		if(b==0){
			return a;
		}
		return gcd(b,a%b);
	}
}
