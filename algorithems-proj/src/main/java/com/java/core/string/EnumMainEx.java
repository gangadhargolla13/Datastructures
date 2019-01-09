package com.java.core.string;

public class EnumMainEx {

	public static void main(String[] args) {
		try
		{
			EnumExample ddd = EnumExample.getState("ganesh1");
			System.out.println(ddd);
		}catch(IllegalArgumentException ex)
		{
			System.out.println("I got error");
		}
	}
}
