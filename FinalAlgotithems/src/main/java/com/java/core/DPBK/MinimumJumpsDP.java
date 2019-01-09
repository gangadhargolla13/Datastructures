package com.java.core.DPBK;

import java.util.HashMap;

public class MinimumJumpsDP {

	 HashMap<Integer,Integer> map = new HashMap<Integer, Integer>();
	 public int findJumps(int[] arr,int start)
	 {
		 if(start==arr.length-1){
			 return 0;
		 }
		 if(map.containsKey(start)){
			 return map.get(start);
		 }
		 int size = arr.length;
		 int remaining = size-start;
		 if(remaining<=arr[start]){
			 return 1;
		 }
		 if(arr[start]==0){
			 return Integer.MAX_VALUE;
		 }
		 int jump = Integer.MAX_VALUE;
		 for(int i=1;i<=arr[start];i++)
		 {
			 int tmp = findJumps(arr,start+i);
			 if(tmp!=Integer.MAX_VALUE){
				 jump = Math.min(jump, tmp+1);
			 }
		 }
		 map.put(start, jump);
		 return jump;
	 }
	 
	 public static void main(String[] args) {
		 MinimumJumpsDP n = new MinimumJumpsDP();
		 int arr[] = {1, 3, 5, 3, 3,1,1,1,1,1,1,1,1,4};
		 int f = n.findJumps(arr, 0);
		 System.out.println(f);
		 System.out.println(n.map);
	}
}
