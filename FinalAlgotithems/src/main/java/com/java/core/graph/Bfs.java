package com.java.core.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Bfs {

	private Queue<NodeG> queue;
	static ArrayList<NodeG> nodes = new ArrayList<>();
	public Bfs(){
		queue=new LinkedList<>();
	}
	
	public void bfs(NodeG node){
		queue.add(node);
		node.visited=true;
		while(!queue.isEmpty()){
			NodeG element = queue.remove();
			System.out.print(element.data+"\t");
			List<NodeG> l = element.gerNeighbours();
			for(int i=0;i<l.size();i++){
				NodeG n = l.get(i);
				if(n!=null && !n.visited){
					queue.add(n);
					n.visited=true;
				}
			}
		}
	}
	
	public static void main(String[] args) {
		NodeG node = new NodeG(40);
		NodeG node1 = new NodeG(10);
		NodeG node2 = new NodeG(20);
		NodeG node3 = new NodeG(30);
		NodeG node4 = new NodeG(60);
		NodeG node5 = new NodeG(50);
		NodeG node6 = new NodeG(70);
		
		node.addNeighboors(node1);
		node.addNeighboors(node2);
		node1.addNeighboors(node3);
		node2.addNeighboors(node1);
		node2.addNeighboors(node3);
		node2.addNeighboors(node4);
		node2.addNeighboors(node5);
		node3.addNeighboors(node4);
		node4.addNeighboors(node6);
		node5.addNeighboors(node6);
		Bfs bfs = new Bfs();
		bfs.bfs(node);
	}
}
