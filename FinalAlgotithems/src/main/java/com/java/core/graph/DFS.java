package com.java.core.graph;

import java.util.List;
import java.util.Stack;

public class DFS {

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
		
		node.visited=false;
		node1.visited=false;
		node2.visited=false;
		node3.visited=false;
		node4.visited=false;
		node5.visited=false;
		node6.visited=false;
		dfsAsStack(node);
		//dfs(node);
	}
	
	public static void dfsAsStack(NodeG node){
		Stack<NodeG> s = new Stack<>();
		s.push(node);
		node.visited=true;
		while(!s.isEmpty()){
			NodeG n = s.pop();
			System.out.print(n.data+" ");
			List<NodeG> l = n.gerNeighbours();
			for(NodeG g:l){
				if(g!=null && !g.visited){
					g.visited=true;
					s.push(g);
				}
			}
		}
	}
	
	public static void dfs(NodeG n){
		System.out.print(n.data+" ");
		List<NodeG> l = n.gerNeighbours();
		n.visited=true;
		for(NodeG g:l){
			if(g!=null && !g.visited){
				dfs(g);
			}
		}
	}
}

