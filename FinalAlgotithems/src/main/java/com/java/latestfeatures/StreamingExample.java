package com.java.latestfeatures;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamingExample 
{

	public static void main(String[] args) {
		System.out.println("I am ganga");
		Stream<Integer> stream = Stream.of(23,56,89,32);
		List<Integer> list = stream.peek(ele -> System.out.println("Each element at "+ele)).collect(Collectors.toList());
		//Once stream consumes that can't reuseable 
		//List<Integer> list = stream.filter(ele -> ele%2==0).collect(Collectors.toList());
		//System.out.println(list);
		boolean bb=list.stream().allMatch(ele -> ele==45);
		System.out.println(bb);
		int com = 34;
		/*list.forEach(ele -> {
			System.out.println(ele+com);
		});*/
		Map<Integer,String> map = list.stream().collect(Collectors.toMap(ele -> ele, ele -> ele+" grms",(old,newval) -> newval,LinkedHashMap::new));
		//System.out.println(map);
		map.forEach((k,V) -> System.out.println("Key is "+k +" Value is "+V));
		/*List<Map.Entry<Integer, String>> list1 = map.entrySet().stream().sorted(Map.Entry.comparingByValue()).collect(Collectors.toList());
		list1.forEach(System.out::println);*/
		map.putIfAbsent(65, "76");
		
		map.computeIfPresent(65, (k,v)-> v.concat(" grms"));
		System.out.println(map);
	}
}
