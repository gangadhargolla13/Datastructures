package com.java.core.algo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class SortByValues 
{

	public static void main(String[] args) {
		Map<String,Integer> map = new HashMap<>();
		map.put("India", 26);
		map.put("Japan", 3);
		map.put("China", 12);
		map.put("America", 1);
		Set<Map.Entry<String,Integer>> set = map.entrySet();
		List<Map.Entry<String,Integer>> list = new ArrayList<>(set);
		Collections.sort(list,new Comparator<Map.Entry<String, Integer>>(){
			public int compare(Map.Entry<String, Integer> obj1,Map.Entry<String, Integer> obj2)
			{
				return obj1.getValue().compareTo(obj2.getValue());
			}
		});
		for(Map.Entry<String, Integer> entry:list)
		{
			System.out.println(entry.getKey()+" "+entry.getValue());
		}
	}
}
