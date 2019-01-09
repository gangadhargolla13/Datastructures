package com.java.core.trees;

import java.util.PriorityQueue;
import java.util.Queue;

public class PriorityQueueE {
	public static void main(String[] args) {
		Queue<Integer> q = new PriorityQueue<>();
		q.add(12);
        q.add(3);
        for( Days1 d:Days1.values()){
        	System.out.println(d.getNum());
        }
	}
}

enum Days1 {
	SUNDAY(1),MONDAY(2),TUESDAY(3);
	
	private int num;
	 Days1(int n)
	{
		num=n;
	}
	 
	 public int getNum(){
		 return num;
	 }
	 
	 public Days1 getDay(int v){
		 for( Days1 d:Days1.values()){
	        	if(v==d.num)
	        		return d;
	        }
		 return null;
	 }
}