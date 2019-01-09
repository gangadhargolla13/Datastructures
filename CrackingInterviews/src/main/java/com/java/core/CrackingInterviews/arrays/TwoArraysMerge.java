package com.java.core.CrackingInterviews.arrays;

import java.util.ArrayList;

public class TwoArraysMerge {

	public static void main(String[] args) {
		ArrayList<Integer> j = new ArrayList<>();
		j.add(12);
		j.add(13);
		j.add(14);
		j.add(15);

		ArrayList<Integer> j1 = new ArrayList<>();
		j1.add(21);
		j1.add(31);
		j1.add(41);
		j1.add(51);

		TwoArraysMerge ta = new TwoArraysMerge();
		//ta.mergeCollection(j, j1);
		
		int[] a = {2,4,6,7,4};
		int[] b = {2,4,6,7,4};
		ta.mergeArray(a, b);
	}

	public void mergeCollection(ArrayList<Integer> first, ArrayList<Integer> second) {
		first.addAll(second);
		System.out.println(first);
	}
	
	public void mergeArray(int[] a, int[] b){
		ArrayList<Integer> list = new ArrayList<>();
		for(int m:a){
			list.add(m);
		}
		for(int m : b){
			list.add(m);
		}
		Integer[] n = new Integer[list.size()];
		list.toArray(n);
		System.out.println(n.length);
	}
}
