package com.java.core.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Bfs1 {

	private Queue<NodeA> queue;
	static ArrayList<NodeA> nodes = new ArrayList<>();
	public Bfs1(){
		queue = new LinkedList<>();
	}
	
	public ArrayList<NodeA> getNeighbors(int am[][],NodeA node){
		int nI = -1;
		ArrayList<NodeA> neighbors = new ArrayList<>();
		for(int i=0;i<nodes.size();i++){
			if(nodes.get(i).equals(node)){
				nI=i;
				break;
			}
		}
		if(nI!=-1){
			for(int j=0;j<am[nI].length;j++){
				if(am[nI][j]==1){
					neighbors.add(nodes.get(j));
				}
			}
		}
		return neighbors;
	}
	
	public void bfs(int[][] am,NodeA node){
		queue.add(node);
		node.visited=true;
		while(!queue.isEmpty()){
			NodeA element =queue.remove();
			System.out.print(element.data+" \t");
			ArrayList<NodeA> neighbors = getNeighbors(am, element);
			for(int i=0;i<neighbors.size();i++){
				NodeA n = neighbors.get(i);
				if(n!=null && !n.visited){
					queue.add(n);
					n.visited=true;
				}
			}
		}
	}
	public static void main(String[] args) {
		
		NodeA node40 =new NodeA(40);
		NodeA node10 =new NodeA(10);
		NodeA node20 =new NodeA(20);
		NodeA node30 =new NodeA(30);
		NodeA node60 =new NodeA(60);
		NodeA node50 =new NodeA(50);
		NodeA node70 =new NodeA(70);
		
		nodes.add(node40);
		nodes.add(node10);
		nodes.add(node20);
		nodes.add(node30);
		nodes.add(node60);
		nodes.add(node50);
		nodes.add(node70);
		
		int adjacency_matrix[][] = {
				{0,1,1,0,0,0,0},  // Node 1: 40
				{0,0,0,1,0,0,0},  // Node 2 :10
				{0,1,0,1,1,1,0},  // Node 3: 20
				{0,0,0,0,1,0,0},  // Node 4: 30
				{0,0,0,0,0,0,1},  // Node 5: 60
				{0,0,0,0,0,0,1},  // Node 6: 50
				{0,0,0,0,0,0,0},  // Node 7: 70
		};
        Bfs1 b = new Bfs1();
        b.bfs(adjacency_matrix, node40);
	}
}
