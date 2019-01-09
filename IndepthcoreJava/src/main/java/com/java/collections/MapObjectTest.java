package com.java.collections;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapObjectTest {

	public static void main(String[] args) {
		Map<String,Ganga> map = new HashMap<>();
		List<Integer> list = new ArrayList<>();
		List<Integer> list1 = new ArrayList<>();
		List<Integer> list2 = new ArrayList<>();
		list.add(123);
		list.add(231);
		list.add(312);
		list1.add(1234);
		list2.add(1235);
		list2.add(1236);
		Ganga g = new Ganga("elder",list);
		Ganga g1 = new Ganga("younger",list1);
		Ganga g2 = new Ganga("sister",list2);
		map.put("first", g);
		map.put("second", g1);
		map.put("thired", g2);
		for(String s : map.keySet()){
			System.out.println(s);
			Ganga  l = map.get(s);
			for(Integer l2 : l.getValues()){
				System.out.println(l2);
			}
		}
	}
}

class Ganga {
	private String name;
	private List<Integer> values;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Integer> getValues() {
		return values;
	}

	public void setValues(List<Integer> values) {
		this.values = values;
	}

	public Ganga(String name,List<Integer> values){
		this.name=name;
		this.values=values;
	}
}