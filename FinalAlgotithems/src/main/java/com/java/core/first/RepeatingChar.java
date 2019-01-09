package com.java.core.first;

import java.util.Arrays;
import java.util.HashMap;

public class RepeatingChar {

	public static void printVal(String s){
		HashMap<Character,Integer> map = new HashMap<>();
		for(int i=0;i<s.length();i++){
			Character ch = s.charAt(i);
			if(map.containsKey(ch))
			{
				map.put(ch, map.get(ch)+1);
			}
			else
			{
				map.put(ch, 1);
			}
		}
		
		for(int i=s.length()-1;i>=0;i--)
		{
			if(map.get(s.charAt(i))==1)
			{
				System.out.println(s.charAt(i));
				break;
			}
		}
	}
	
	//Find duplicate in O(n) and O(1)
	public static void arrayDup(int[] a)
	{
		for(int i=0;i<a.length;i++)
		{
			if(a[Math.abs(a[i])]<0)
			{
				System.out.println(Math.abs(a[i]));
			}
			else
				a[Math.abs(a[i])] = a[Math.abs(a[i])]*-1;
		}
	}
	
	public static void makeReverse(int[] a){
		int s=0;
		int e = a.length-1;
		while(s<=e)
		{
			int t = a[s];
			a[s]=a[e];
			a[e]=t;
			s++;
			e--;
		}
		System.out.println(Arrays.toString(a));
	}
	
	public static void makeReveByRec(int[] a,int s,int e)
	{
		if(s<=e)
		{
			int t = a[s];
			a[e]=a[s];
			a[s]=t;
			s++;
			e--;
			makeReveByRec(a,s,e);
		}
	}
	public static void main(String[] args) {
		String input = "algorithms tutorial";
		printVal(input);
		
		 int a[] = {1, 6, 5, 2, 3, 3, 2};
		 int a1[] = {1, 6, 5, 2, 3, 3, 2};
		 arrayDup(a);
		makeReverse(a1);
	}
}
