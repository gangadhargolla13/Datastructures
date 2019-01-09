package com.java.collections;

import java.util.Comparator;

public class ImplementsComparator implements Comparator<Player>{

	public int compare(Player ply1, Player ply2) {
		int val =  ply1.getName().compareTo(ply2.getName());
		if(val == 0){
			val = ply1.getCountry().compareTo(ply2.getCountry());
			if(val == 0){
				val = Integer.valueOf(ply1.getRank()).compareTo(ply2.getRank());
			}
		}
		return val;
	}

}
