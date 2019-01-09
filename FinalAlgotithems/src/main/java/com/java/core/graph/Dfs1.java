package com.java.core.graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Dfs1 {

	static List<NodeA> l= new ArrayList<>();
	
	public ArrayList<NodeA> getNeighbors(int[][] am,NodeA x){
		int nI = -1;
		ArrayList<NodeA> n = new ArrayList<>();
		for(int i=0;i<l.size();i++){
			if(l.get(i).equals(x)){
				nI=i;
				break;
			}
		}
		if(nI!=-1){
			for(int j=0;j<am[nI].length;j++){
				if(am[nI][j]==1){
					n.add(l.get(j));
				}
			}
		}
		return n;
	}
	public static void main(String[] args) {
		NodeA node40 =new NodeA(40);
		NodeA node10 =new NodeA(10);
		NodeA node20 =new NodeA(20);
		NodeA node30 =new NodeA(30);
		NodeA node60 =new NodeA(60);
		NodeA node50 =new NodeA(50);
		NodeA node70 =new NodeA(70);
		l.add(node40);
		l.add(node10);
		l.add(node20);
		l.add(node30);
		l.add(node60);
		l.add(node50);
		l.add(node70);
		
		int adjacency_matrix[][] = {
				{0,1,1,0,0,0,0},  // Node 1: 40
				{0,0,0,1,0,0,0},  // Node 2 :10
				{0,1,0,1,1,1,0},  // Node 3: 20
				{0,0,0,0,1,0,0},  // Node 4: 30
				{0,0,0,0,0,0,1},  // Node 5: 60
				{0,0,0,0,0,0,1},  // Node 6: 50
				{0,0,0,0,0,0,0},  // Node 7: 70
		};
		
		Dfs1 d = new Dfs1();
		//d.dfsStack(adjacency_matrix, node40);
		d.dfsRecu(adjacency_matrix, node40);
	}
	public void dfsRecu(int a[][],NodeA node)
	{
		System.out.print(node.data+" ");
		ArrayList<NodeA> aa = getNeighbors(a, node);
		node.visited=true;
		for(int i=0;i<aa.size();i++){
			NodeA nn = aa.get(i);
			if(nn!=null && !nn.visited){
				dfsRecu(a,nn);
			}
		}
	}
	
	public void dfsStack(int[][] am,NodeA node){
		Stack<NodeA> s = new Stack<>();
		s.push(node);
		node.visited=true;
		while(!s.isEmpty()){
			NodeA a = s.pop();
			System.out.print(a.data+" ");
			ArrayList<NodeA> ll = getNeighbors(am, a);
			for(int i=0;i<ll.size();i++){
				NodeA nn = ll.get(i);
				if(nn!=null && !nn.visited){
					s.push(nn);
					nn.visited=true;
				}
			}
		}
	}
}
