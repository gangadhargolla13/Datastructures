package com.java.core.bitmanipulation;

import java.util.ArrayList;
import java.util.HashMap;

public class Testing
{

    public static void main(String[] args)
    {
        ArrayList<String> l = new ArrayList<>();
        System.out.println(l.hashCode());
        HashMap<String,ArrayList<String>> map = new HashMap<>();
        l.add("a");l.add("b");l.add("c");
        map.put("t1", l);
        l = new ArrayList<>();
        System.out.println(l.hashCode());
        l.add("e");l.add("f");l.add("g");
        map.put("t2", l);
        System.out.println(l);
        System.out.println(map.get("t1"));
        System.out.println(map.get("t2"));
        for(String s:map.keySet())
        {
        	map.get(s).add("3");
        }
        System.out.println(map);
    }
}
