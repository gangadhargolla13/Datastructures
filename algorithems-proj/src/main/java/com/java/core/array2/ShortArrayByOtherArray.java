package com.java.core.array2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Hashtable;
import java.util.Set;

public class ShortArrayByOtherArray {

	public static int[] ushingHash(int[] a,int[] b){
		int r = -1;
		Hashtable<Integer,Integer> h = new Hashtable<>();
		for(int i=0; i<=a.length-1; i++){
			System.out.println(i);
			if(h.containsKey(a[i])){
			int count = h.get(a[i]);
			count++;
			h.put(a[i], count);
			}else{
				h.put(a[i],1);
			}
		}
		System.out.println(h);
		for(int j=0;j<b.length;j++){
			if(h.containsKey(b[j])){
				int count = h.get(b[j]);
				while(count>0){
					a[++r]=b[j];
					count--;
				}
				h.remove(b[j]);
			}
		}
		ArrayList<Integer> l = new ArrayList<>();
		Set<Integer> s = h.keySet();
		for(Integer j :s){
			l.add(j);
		}
	Collections.sort(l);
	for(Integer d:l)
	{
		a[++r]=d;
	}
		return a;
	}
    public static void main(String[] args) {
    	int [] arrA = {2,6,9,1,4,4,2,1,10,13,5,7,8};
		int [] arrB = {1,2,4,6};
		int[] m = ushingHash(arrA, arrB);
		System.out.println(Arrays.toString(m));
	}
}
