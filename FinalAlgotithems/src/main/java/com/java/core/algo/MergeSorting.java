package com.java.core.algo;

import java.util.Arrays;

public class MergeSorting {
	int[] temp = null;
	int[] data = null;

	public void sorting(int[] data) {
		this.data = data;
		temp = new int[data.length];
		System.out.println(Arrays.toString(data));
		sort(0,data.length-1);
		System.out.println(Arrays.toString(data));
	}

	public void sort(int s, int e) {
		if (s < e) {
			int m = s + (e - s) / 2;
			sort(s, m);
			sort(m + 1, e);
			merge(s, e, m);
		}

	}

	public void merge(int s, int e, int m) {
		for (int i = s; i <= e; i++) {
           temp[i]=data[i];
		}
		int i= s;
		int k =s;
		int j=m+1;
		while(i<=j && j<=e)
		{
			if(temp[i]<=temp[j])
			{
				data[k] = temp[i];
				i++;
			}else
			{
				data[k] = temp[j];
				j++;
			}
			k++;
		}
		while(i<=m)
		{
			data[k]=temp[i];
			k++;
			i++;
		}
	}
}
