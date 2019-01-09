package com.java.strings;

import java.util.ArrayList;
import java.util.List;

public class Gangaresreay {

	private final String salary = "gangadhar";
	private final int value = 123;
	private final Family f1 = new Family(123, "gangadhar", 100f);
	public static void main(String[] args) {
		Gangaresreay ganga = new Gangaresreay();
		System.out.println(ganga.f1);
		ganga.f1.setId(456);
		System.out.println(ganga.f1);
		System.out.println(ganga.salary+"---"+ganga.salary.hashCode());
		System.out.println(ganga.value+"---"+Integer.valueOf(ganga.value).hashCode());
		Family f = new Family(123, "gangadhar", 100f);
		//ganga.f1 = f;
		List<String> list = new ArrayList<String>();
		list.add("ganga");
		list.add("ganga12");
		list.add("ganga12");
		System.out.println(list.hashCode());
		System.out.println(list+"---"+list.hashCode());
		//System.out.println(f.getName()+"==="+f.getName().hashCode());
		//System.out.println(f.getId()+"==="+Integer.valueOf(f.getId()).hashCode());
		//ganga.value = 345; ganga.salary= "dfkjkfj";
		//int val = ganga.value;
		//System.out.println(val);
		//val = 678;
		//System.out.println(val);
		System.out.println(ganga.value);
		ganga.getValue(list);
		System.out.println(list+"---"+list.hashCode());
		System.out.println(list.hashCode());
	}
	
	public void getValue(List<String> list){
		System.out.println(list.hashCode());
		list.add("ganga234");
		System.out.println(list+"  "+list.hashCode());
	}
}
class Family{
	private int id;
	private String name;
	private float rent;
	
	public Family(int id,String name,float rent){
		this.id= id;
		this.name = name;
		this.rent = rent;
	}
	public String toString(){
		return id+"---"+name+"---"+rent;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public float getRent() {
		return rent;
	}
	public void setRent(float rent) {
		this.rent = rent;
	}
}
