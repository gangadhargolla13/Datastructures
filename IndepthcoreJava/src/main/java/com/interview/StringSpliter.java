package com.interview;

public class StringSpliter {

	public static void main(String[] args) {
		String input = "gan-ga.dhar-gol.la";
		String[] result = input.split("-|\\.");
		for(String s : result){
			//System.out.println(s);
		}
		String[] d = "Circle,Square,Rectangle,Hexagon".split(",");
		for(String f : d)
		{
			System.out.println(f);
		}
	}
}
