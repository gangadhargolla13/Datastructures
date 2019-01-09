package com.java.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class ArrayListExample {

	public static void main(String[] args) {
		Player p = new Player("Grilcrist", 33, 178, 39.05f, "Austerlia");
		Player p1 = new Player("Pointing", 250, 164, 44.05f, "Austerlia");
		Player p2 = new Player("Haden", 250, 164, 44.05f, "Austerlia");
		Player p3 = new Player("Haden12", 250, 164, 44.05f, "Austerlia");
		List<Player> list = new ArrayList<>();
		list.add(p1);
		list.add(p2);
		list.add(p);
		Player[] pla = {p,p1,p2,p3};
		List<Player> lp = Arrays.asList(pla);
		//System.out.println(lp);
		Player[] ap = new Player[lp.size()];
		ap = (Player[])lp.toArray();
		//System.out.println(Arrays.toString(ap));
		List<Player> ll =lp.subList(0, 4);
		//System.out.println(ll);
		if(lp.contains(p3)){
			System.out.println("object is exist");
		}
		Collections.sort(lp,new ImplementsComparator());
		System.out.println(lp);
		Collections.reverse(lp);
		System.out.println(lp);
	    /*Iterator<Player> ir = list.iterator();
	    int c=1;
	    while(ir.hasNext()){
	    	System.out.println(ir.next().getAvarage());
	    	//list.remove(2);
	    	
	    	System.out.println(list.get(c));
	    	c++;
	    }*/
		//System.out.println(list);
		/*System.out.println(list.size() +" "+list.hashCode());
		//checking(list);
		System.out.println(list.size() +" "+list.hashCode());
		String ss = "gangadhar";
		System.out.println(ss +" "+ss.hashCode());
		//checking(ss);
		System.out.println(ss +" "+ss.hashCode());*/
		
		/*StringBuffer buff = new StringBuffer("Gangadar");
		StringBuffer buff1 = buff;
		System.out.println(buff.hashCode()+" "+buff);
		System.out.println(buff1.hashCode()+" "+buff1);
		checking(buff);
		System.out.println(buff.hashCode()+" "+buff);
		System.out.println(buff1.hashCode()+" "+buff1);*/
		
		Integer in = new Integer(34);
		System.out.println(in.hashCode()+" "+in);
		checking(in);
		System.out.println(in.hashCode()+" "+in);
	}
	
	public static <T> T checking(T values){
		
		Integer in = (Integer)values;
		in=76;
		System.out.println(in.hashCode()+" "+in);
		
		/*StringBuffer bb = (StringBuffer)values;
		bb.append("malli");
		System.out.println(bb.hashCode()+" "+bb);*/
		//List<Player> kk = (List<Player>)values;
		
		//Player p2 = new Player("Betlee", 250, 164, 44.05f, "Austerlia");
		//kk.add(p2);
		//System.out.println(kk.size()+" "+kk.hashCode());
		/*String ll = (String)values;
		System.out.println(ll+" "+ll.hashCode());
		ll = "malli";
		System.out.println(ll+" "+ll.hashCode());*/
	  return values;
	}
}
