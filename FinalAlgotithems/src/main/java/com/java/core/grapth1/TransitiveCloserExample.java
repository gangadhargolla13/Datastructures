/*package com.java.core.grapth1;

import java.util.concurrent.CopyOnWriteArrayList;

public class TransitiveCloserExample {

	private int v;
	private LinkedList<Integer> adjList;
	private int[][]	tc;
	
	public TransitiveCloserExample()
	{
		
	}
	
	public static void main(String[] args) {
		CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList<>();
		list.add("1");
		list.add("2");
		list.add("3");
		list.add("4");
		TransitiveCloserExample tr = new TransitiveCloserExample();
		while(!list.isEmpty())
		{
			tr.checkStatus(list);
		}
	}
	
	public boolean checkStatus(CopyOnWriteArrayList<String> list)
	{
        System.out.println(list.size());
        int s = list.size();
        list.remove(String.valueOf(s));
        System.out.println("after size "+list.size());
        return true;
	}
}
*/