package com.java.generic.example;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class SecondTime {

}


class Test<T> {
	T name;
	T value;
	
	public Test(T name,T value){
		this.name=name;
		this.value=value;
	}
	
	public void result(){
		System.out.println("I  am ganesh kumar");
		System.out.println("name ===>"+this.name+","+"value --->"+this.value);
		System.out.println("I am gopi jithendra");
	}
	
	public List<T> getWildCard(T a,T b){
		List<T> list = new ArrayList<>();
		list.add(a);
		list.add(b);
		return list;
	}
	
	public void getWildCard1(List<? extends Set<T>> list){
		System.out.println("Wild card method is called");
		Iterator<? extends Set<T>> ir = list.iterator();
		if(ir.hasNext()){
			System.out.println("The values are "+ir.next());
		}
		
		System.out.println("an operation is completed");
	}
	
	public  T getWildCard2(List<T> values){
		T check;
		if(values != null && !values.isEmpty() && values.size() == 1)
			check = values.get(0);
		else if(values != null && !values.isEmpty() && values.size() > 1)
			check=values.get(1);
		else
			check=this.name;
		return check;
	}
}