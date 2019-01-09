package com.java.core.first;

import java.util.Arrays;
import java.util.HashSet;

//When ever to find out sum of three elements always better solution is O(n^2)
public class TripleSum {

	public void isAvailable(int[] a,int b){
		for(int i=0;i<a.length;i++){
			for(int j=i+1;j<a.length;j++){
				for(int k=j+1;k<a.length;k++){
					if(a[i]+a[j]+a[k]==b)
					{
						System.out.println("Elements are "+a[i]+","+a[j]+","+a[k]);
					}
				}
			}
		}
	}
	public void isAvailbleSort(int[] a,int b){
		Arrays.sort(a);
		for(int i=0; i<a.length; i++){
			int x = a[i];
			int m = b-x;
			int s = i + 1;
			int e = a.length-1;
			ganga : while(s < e)
			{
				int sum = a[s]+a[e];
				if(sum == m){
					System.out.println("Elemnets are "+a[i]+","+a[s]+","+a[e]);
					break ganga;
				}
				else if(sum<m)
					s++;
				else
					e--;
			}
		}
	}
	
	public void isAvailbleHash(int[] a,int b){
		for(int i=0;i<a.length;i++){
			int m = b-a[i];
			int s = i+1;
			int e = a.length-1;
			HashSet<Integer> set = new HashSet<>();
			for(int j=s;j<=e;j++)
			{
				int re = m-a[j];
				if(re>=0&&set.contains(re)==true)
				{
					System.out.println(a[i]+","+a[j]+","+re);
				}
				set.add(a[j]);
			}
		}
	}
	public static void main(String[] args) {
		TripleSum t = new TripleSum();
		int a [] = { 3,1,7,4,5,9,10};
        int k = 21;
        //t.isAvailable(a, k);
       // t.isAvailbleSort(a,k);
        t.isAvailbleHash(a, k);
	}
}
