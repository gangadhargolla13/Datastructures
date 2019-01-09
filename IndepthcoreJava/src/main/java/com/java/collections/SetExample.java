package com.java.collections;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class SetExample 
{

	public static void main(String[] args) {
		
		Set<Player> tset = new TreeSet<>(new ImplementsComparator());
		Player p = new Player("Grilcrist", 33, 178, 39.05f, "Austerlia");
		Player p1 = new Player("Pointing", 250, 164, 44.05f, "Austerlia");
		Player p2 = new Player("Haden", 250, 164, 44.05f, "Austerlia");
		tset.add(p2);
		tset.add(p1);
		tset.add(p);
		System.out.println(tset);
		Set<Player> lset = new LinkedHashSet<>();
		 p = new Player("Grilcrist", 33, 178, 39.05f, "Austerlia");
		 p1 = new Player("Pointing", 250, 164, 44.05f, "Austerlia");
		 p2 = new Player("Haden", 250, 164, 44.05f, "Austerlia");
		lset.add(p2);
		lset.add(p1);
		lset.add(p);
		System.out.println(lset);
		
		Set<Player> set = new HashSet<>();
		 p = new Player("Grilcrist", 33, 178, 39.05f, "Austerlia");
		 p1 = new Player("Pointing", 250, 164, 44.05f, "Austerlia");
		 p2 = new Player("Pointing", 250, 164, 44.05f, "Austerlia");
		
		set.add(p);
		set.add(p1);
		set.add(p2);
		set.removeAll(set);
		//System.out.println(set);
		System.out.println(p1.hashCode()+"  "+p2.hashCode());
		System.out.println(set.size());
		Player p3 = null;
		try{
			 p3 = p.clone();
		}catch(CloneNotSupportedException e){
			e.printStackTrace();
		}
		System.out.println(p3);
		
	}
}
