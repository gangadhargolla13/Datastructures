package com.java.core.DPBK;

import java.util.HashMap;

public class RemoveBoxDP {

	HashMap<String,Integer> map = new HashMap<String, Integer>();
	public int removeBox(String input){
		int profit = 0;
		if(input==null || input.length()==0)
			return 0;
		if(map.containsKey(input)){
			return map.get(input);
		}
		if(input.length()==1)
			return 1;
		int start=0,end=0;
		while(start<input.length()){
			char c = input.charAt(start);
			int count = 0;
			while(end<input.length() && c==input.charAt(end)){
				end++;
				count++;
			}
			if(end>=input.length())
				profit = Math.max(profit, count*count);
			else
				profit = Math.max(profit, removeBox(input.substring(0, start)+input.substring(end,input.length()))+count*count);
			start=end;
		}
		map.put(input, profit);
		return profit;
	}
	
	public static void main(String[] args) {
		RemoveBoxDP dp = new RemoveBoxDP();
		String input = "123321";
		int val = dp.removeBox(input);
		System.out.println(val);
		System.out.println(dp.map);
	}
}
