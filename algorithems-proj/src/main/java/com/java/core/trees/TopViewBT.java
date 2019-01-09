package com.java.core.trees;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.TreeMap;

public class TopViewBT {
	public static TreeMap<Integer, Integer> ht = new TreeMap<>();
	public void topView(Node11 root, int level) {
		if (root == null)
			return;
		Queue<QueuePack> queue = new LinkedList<>();
		queue.add(new QueuePack(level, root));
		while (!queue.isEmpty()) {
			QueuePack q = queue.remove();
			Node11 tnode = q.tnode;
			int lvl = q.level;
			if (ht.containsKey(lvl)) {
			} else {
				System.out.print(tnode.data + "   ");
				ht.put(lvl, tnode.data);
			}

			if (tnode.left != null) {
				queue.add(new QueuePack(lvl - 1, tnode.left));
			}
			if (tnode.right != null) {
				queue.add(new QueuePack(lvl + 1, tnode.right));
			}
		}
	}
	public static TreeMap<Integer, Integer> ht1 = new TreeMap<>();;
	public void bottomView(Node11 root,int level){
		if (root == null)
			return;
		
		Queue<QueuePack> queue = new LinkedList<>();
		queue.add(new QueuePack(level, root));
		while (!queue.isEmpty()) {
			QueuePack q = queue.remove();
			Node11 tnode = q.tnode;
			int lvl = q.level;

			ht1.put(lvl, tnode.data);

			if (tnode.left != null) {
				queue.add(new QueuePack(lvl - 1, tnode.left));
			}
			if (tnode.right != null) {
				queue.add(new QueuePack(lvl + 1, tnode.right));
			}
		}
	}
	
	public static void display() { // print the bottom view.
		Set<Integer> keys = ht1.keySet();
		for (Integer key : keys) {
			System.out.print(ht1.get(key) + " ");
		}

	}
	public static void main(String args[]) {
		Node11 root = new Node11(1);
		root.left = new Node11(2);
		root.right = new Node11(3);
		root.left.left = new Node11(4);
		root.left.left.left = new Node11(8);
		root.left.left.right = new Node11(9);
		root.left.right = new Node11(5);
		root.right.left = new Node11(6);
		root.right.right = new Node11(7);

		TopViewBT p = new TopViewBT();
		//p.topView(root, 0);
		p.bottomView(root, 0);
		p.display();
	}
}
class QueuePack {
	int level;
	Node11 tnode;

	public QueuePack(int level, Node11 tnode) {
		this.level = level;
		this.tnode = tnode;
	}
}