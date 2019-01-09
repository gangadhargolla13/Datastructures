package com.java.core.dp;

import java.util.HashMap;

public class MinimumJumps {
	 HashMap<Integer,Integer> map = new HashMap<Integer, Integer>();
	public static void main(String[] args) {
		int arr[] = {1,3,4,8,9};
		MinimumJumps j = new MinimumJumps();
		System.out.println(j.findJump(arr, 0));
		System.out.println(j.findJump1(arr, 0));
	}
	public int findJump1(int[] a,int index){
		if(index==a.length-1){
			return 0;
		}
		if(map.containsKey(index)){
            return map.get(index);
        }
		int size=a.length;
		int remain = size-index;
		if(remain<=a[index]){
			return 1;
		}
		if(a[index]==0){
			System.out.println("Can't move further!");
			return Integer.MAX_VALUE;
		}
		int jumps = Integer.MAX_VALUE;
		for(int i=1;i<=a[index];i++){
			int tmp=findJump(a,index+1);
			if(tmp!=Integer.MAX_VALUE)
			{
				jumps=Math.min(jumps,1+findJump1(a,index+1));
			}
		}
		map.put(index,jumps);
		return jumps;
	}
	
	public int findJump(int[] a,int index){
		if(index==a.length-1){
			return 0;
		}
		int size=a.length;
		int remain = size-index;
		if(remain<=a[index]){
			return 1;
		}
		if(a[index]==0){
			System.out.println("Can't move further!");
			return Integer.MAX_VALUE;
		}
		int jumps = Integer.MAX_VALUE;
		for(int i=1;i<=a[index];i++){
			int tmp=findJump(a,index+1);
			if(tmp!=Integer.MAX_VALUE)
			{
				jumps=Math.min(jumps,tmp+1);
			}
		}
		return jumps;
	}
}
