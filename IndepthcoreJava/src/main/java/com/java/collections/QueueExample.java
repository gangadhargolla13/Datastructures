package com.java.collections;

import java.util.PriorityQueue;
import java.util.Queue;

class QueueExample {

	public static void main(String[] args) {
		Queue<Integer> que = new PriorityQueue<>(2);
		que.add(Integer.valueOf(12));
		que.add(Integer.valueOf(84));
		que.add(Integer.valueOf(32));
		que.add(Integer.valueOf(3));
		que.add(Integer.valueOf(19));
		System.out.println(que);
		int val = que.poll();
		System.out.println(val);
		System.out.println(que);
		/*Queue<Player> que = new PriorityQueue<>(10,new ImplementsComparator());
		Player p = new Player("Grilcrist", 33, 178, 39.05f, "Austerlia");
		Player p1 = new Player("Pointing", 250, 164, 44.05f, "Austerlia");
		Player p2 = new Player("Haden", 250, 164, 44.05f, "Austerlia");
		Player p3 = new Player("Haden12", 250, 164, 44.05f, "Austerlia");
		que.add(p1);
		que.add(p);
		que.add(p2);
		System.out.println(que);*/
	}
}
