/*package com.java.core.grapth1;

import java.util.LinkedList;

public class GraphAndRepresentation {

	static class Graph
	{
		int v;
		LinkedList<Integer> adjListArray[];
		
		public Graph(int n){
			this.v=n;
			adjListArray = new LinkedList[n];
			for(int i=0;i<n;i++)
			{
				adjListArray[i]=new LinkedList<>();
			}
		}
	}
	public static void addEdge(Graph g,int s,int d)
	{
		g.adjListArray[s].addFirst(d);
		g.adjListArray[d].addFirst(s);
	}
	
	public static void printGraph(Graph g)
	{
		for(int i=0;i<g.v;i++)
		{
			System.out.println("Adjacency list of vertex "+ i);
            System.out.print("head");
            for(Integer in:g.adjListArray[i])
            {
            	System.out.print("->"+in);
            }
            System.out.println();
		}
	}
	
	public static void main(String[] args) {
		int V = 5;
        Graph graph = new Graph(V);
        addEdge(graph, 0, 1);
        addEdge(graph, 0, 4);
        addEdge(graph, 1, 2);
        addEdge(graph, 1, 3);
        addEdge(graph, 1, 4);
        addEdge(graph, 2, 3);
        addEdge(graph, 3, 4);
        printGraph(graph);
	}
}
*/