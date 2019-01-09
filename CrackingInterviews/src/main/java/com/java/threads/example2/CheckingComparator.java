package com.java.threads.example2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CheckingComparator {
	public static void main(String[] args) {
       List<Checking> list = new ArrayList<>();
       Checking ch=new Checking(18);
       Checking ch1=new Checking(3);
       Checking ch2=new Checking(6);
       list.add(ch);
       list.add(ch1);
       list.add(ch2);
       Collections.sort(list);
       System.out.println(list);
	}
}

class Checking implements Comparable<Checking> {
    private int id;
    public Checking(int id)
    {
    	this.id=id;
    }
	@Override
	public int compareTo(Checking o) {
		if(this.id<o.id)
		{
			return 1;
		}else if(this.id>o.id)
		{
			return -1;
		}else
			return 0;
	}
	@Override
	public String toString()
	{
		return id+" ";
	}
}