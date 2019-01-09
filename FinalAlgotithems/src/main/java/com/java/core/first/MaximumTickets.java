package com.java.core.first;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MaximumTickets {

	public PriorityQueue<Integer> p;
	public MaximumTickets()
	{
		p=new PriorityQueue<>(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1,Integer o2)
			{
				return o2-o1;
			}
		
		});
	}
	public int calculate(int[] a,int k){
		int re=0;
		for(int i=0;i<a.length;i++){
			p.offer(a[i]);
		}
		
		while(k>0){
			int x = p.poll();
			re+=x;
			p.offer(--x);
			k--;
		}
		return re;
	}
	
	public static void main(String[] args) {
		MaximumTickets m = new MaximumTickets();
		int money = m.calculate(new int[]{ 5, 1, 7, 10, 11, 9 }, 5);
		System.out.println(money);
	}
}
