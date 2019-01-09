package com.java.core.FinalAlgotithems;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

public class Programming {
	 public static int magic(List<Integer> stones) {
	        while(stones.size()>1)
	        {
	        	HashMap<Integer,Integer> h = new HashMap<>();
	        	for(Integer i:stones)
	        	{
	        		if(h.containsKey(i))
	        		{
	        			h.put(i, h.get(i)+1);
	        		}
	        		else
	        		{
	        			h.put(i, 1);
	        		}
	        	}
	        	
	        	stones = new ArrayList<>();
	        	Set<Entry<Integer,Integer>> s = h.entrySet();
	        	for(Entry<Integer,Integer> n:s)
	        	{
	        		if(n.getValue() > 1){
	        			stones.add(n.getKey()+1);
	        		}else
	        		{
	        			stones.add(n.getKey());
	        		}
	        	}
	        
	    }
	        return stones.get(0);
	 }
	 
	 public static void main(String[] args) {
		ArrayList<Integer> al = new ArrayList<>();
		al.add(1);
		al.add(2);
		al.add(1);
		al.add(3);
		System.out.println(magic(al));
	}
}


