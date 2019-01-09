package com.java.examples.IndepthcoreJava;

import java.util.ArrayList;

public class PrimaryNumber {

	public static void main(String[] args) {
		ArrayList<Object> set = new ArrayList<Object>();
		int j=2;
		for(int i = 1;i<50;i++){
			for( j = 2;j<i;j++){
				if( i%j == 0){
					break;
				}
			}
			if(i ==j){
				set.add(i);
			}
			
		}
		System.out.println(set);
	}
}
