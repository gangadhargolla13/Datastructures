package com.java.core.patterns;

import java.io.File;
import java.io.IOException;

public class JavaGeneral {

	public  final Integer m=20;
	public final Person p = new Person(1,"Ganesh");
	public void testing() throws NullPointerException
	{
		p.setId(3);
	}
	public static void main(String[] args) {
		JavaGeneral j = new JavaGeneral();
		
		j.testing();
	}
	
	class Person{
		private int id;
		private String name;
		public Person(int id,String name)
		{
			this.id=id;
			this.name=name;
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
		
		public String toString()
		{
			return id+" "+name;
		}
	}
}
