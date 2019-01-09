package com.java.threads.example2;

import java.util.HashSet;
import java.util.Set;

public class AccoliteInterview {
public static void main(String[] args) throws CloneNotSupportedException{
	Set<Employee> set = new HashSet<>();
	Employee e1 = new Employee(1);
	Employee e2 = new Employee(1);
	Employee e3=e2;
	Employee e4 = new Employee(1);
	Employee e5 = (Employee)e4.clone();
	System.out.println(e1.hashCode()+" "+e2.hashCode()+" "+e3.hashCode()+" "+e4.hashCode()+" "+e5.hashCode());
	set.add(e1);set.add(e2);set.add(e3);set.add(e4);
	System.out.println(set.size());
}
}

class Employee implements Cloneable
{
	private int id;
	public Employee(int id) {
		this.id=id;
	}
	
	public Object clone() throws CloneNotSupportedException
	{
		return super.clone();
	}
}