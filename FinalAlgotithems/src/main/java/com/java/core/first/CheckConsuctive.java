package com.java.core.first;

public class CheckConsuctive {

	public int findMax(int[] a){
		int max=Integer.MIN_VALUE;
		for(int i=0;i<a.length;i++){
			if(max<a[i])
				max=a[i];
		}
		return max;
	}
	
	public int findMin(int[] a){
		int max=Integer.MIN_VALUE;
		for(int i=0;i<a.length;i++){
			if(max>a[i])
				max=a[i];
		}
		return max;
	}
	
	public boolean isConjus(int[] a){
		int max = findMax(a);
		int min = findMin(a);
		if(a.length!= max-min+1){ 
			return false;
		}
		for(int i=0;i<a.length;i++)
		{
			a[i]=a[i]-min+1;
		}
		for(int i=0;i<a.length;i++){
			int x = Math.abs(a[i]);
			if(a[x-1]>0)
			{
				a[x-1]=a[x-1]*-1;
			}
			else
				return false;
		}
		return true;
	}
}
