package com.java.collections;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ListValidation {

	public static void main(String[] args) {/*
		Map<String,List<Pojo>> map = new HashMap<String,List<Pojo>>();
		List<String> ftable = new ArrayList<String>();
		List<String> ftable1 = new ArrayList<String>();
		List<String> ftable2 = new ArrayList<String>();
		List[] alist = new List[3];
		ftable.add("event1");
		ftable.add("event2");
		ftable.add("event3");
		ftable1.add("event1");
		ftable1.add("event2");
		ftable1.add("event3");
		ftable2.add("event1");
		ftable2.add("event2");
		ftable2.add("event3");
		alist[0]=ftable;
		alist[1]=ftable1;
		alist[2]=ftable2;
		for(int i=0;i<alist.hashCode();i++){
			List<String> ll = alist[i];
			for(String st: ll){
				
			}
		}
		Pojo p = new Pojo();
		p.setRollNo(1);
		p.setTableName("Events1");
		System.out.println(map);
	*/
	Map<String, List<String>> testMap =new HashMap<String, List<String>>();
	testMap.put("test1", new ArrayList<String>());
	testMap.get("test1").add("1");
	testMap.get("test1").add("2");
	testMap.get("test1").add("3");
	System.out.println(testMap);
	List<String> name=testMap.get("test1");
	List<String> ll = getList(name);
	System.out.println(ll);
	ll.add("gan");
	System.out.println(ll);
	System.out.println(name);
	name = null;
	System.out.println(ll);
	System.out.println(name);
	String name11 = "Gangadhar";
	String name1=name11;
	System.out.println(name11+"--->"+name1);
	name11="mallik";
	System.out.println(name11+"--->"+name1);
	name1 = "hh";
	System.out.println(name11+"--->"+name1);
	String ss = getStr(name11);
	System.out.println(ss);
	ss ="jjj";
			System.out.println(ss);		
	}
	
	
public static String getStr(String name11){
	String name1 = name11;
	System.out.println(name11+"--->"+name1);
	name1 = "rao";
	System.out.println(name11+"--->"+name1);
	name11="hshds";
	System.out.println(name11+"--->"+name1);
	return name11;
}
	
	public static List<String> getList(List<String> name){
		List<String> name1 = name;
		System.out.println(name1);
		System.out.println(name);
		name1.add("Gangadhar");
		System.out.println(name1);
		System.out.println(name);
		return name1;
	}
}


class Pojo implements Cloneable{
	private String tableName;
	private String validation;
	private int rollNo;
	
	public String getTableName() {
		return tableName;
	}
	public void setTableName(String tableName) {
		this.tableName = tableName;
	}
	public String getValidation() {
		return validation;
	}
	public void setValidation(String validation) {
		this.validation = validation;
	}
	public int getRollNo() {
		return rollNo;
	}
	public void setRollNo(int rollNo) {
		this.rollNo = rollNo;
	}
	
	@Override
	public String toString() {
		return "Pojo [tableName=" + tableName + ", validation=" + validation
				+ ", rollNo=" + rollNo + "]";
	}
	
}