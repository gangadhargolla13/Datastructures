package com.java.generic.example;

import java.util.ArrayList;
import java.util.List;

public class GenericExample1 
{
    public static void main(String[] args) 
    {
		List<> list = new ArrayList<>();
		list.add(null);
		list.add("Ganga");
		list.add("Sujatha");
		list.add(123);
		list.add(8976l);
		list.add(84750.9f);
		String s = list.get(1);
	}
}
