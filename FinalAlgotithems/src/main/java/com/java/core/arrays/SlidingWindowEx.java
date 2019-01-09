package com.java.core.arrays;

import java.util.Deque;
import java.util.LinkedList;

public class SlidingWindowEx {
	public static void findSlideWindow(int[] a,int k){
		Deque<Integer> de = new LinkedList<>();
		for(int i=0;i<k;i++)
		{
			while(de.isEmpty()== false && a[de.peekLast()]<a[i]){
				System.out.println(de.removeLast());
			}
			
			de.addLast(i);
			System.out.println(de);
		}
		
		for(int j=k;j<a.length;j++)
		{
			System.out.println(a[de.peekFirst()]+" ");
			while(de.isEmpty()== false && de.peekFirst()<j-k)
			{
				de.removeFirst();
			}
			System.out.println(de);
			while(de.isEmpty()== false && a[de.peekLast()]<a[j]){
				de.removeLast();
			}
			de.addLast(j);
		}
	}
	public static void main(String[] args) {
        int [] nums = {3,2,1, 2, 4, 1, 5, 6, 1};
        int k = 3;
        findSlideWindow(nums, k);
    }
}
