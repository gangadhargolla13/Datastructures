package com.java.collections;

import java.util.LinkedList;
import java.util.List;

public class LinkedListexample {

	public static void main(String[] args) {
		List<Player> list = new LinkedList<>();
		Player p = new Player("Grilcrist", 33, 178, 39.05f, "Austerlia");
		Player p1 = new Player("Pointing", 250, 164, 44.05f, "Austerlia");
		Player p2 = new Player("Haden", 250, 164, 44.05f, "Austerlia");
		Player p3 = new Player("Haden12", 250, 164, 44.05f, "Austerlia");
		list.add(p);
		list.add(p1);
		list.add(p2);
		list.add(null);
		System.out.println(list);
	}
}
