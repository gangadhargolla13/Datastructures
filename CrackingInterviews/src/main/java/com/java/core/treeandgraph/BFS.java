package com.java.core.treeandgraph;

public class BFS {

	public static void main(String[] args) {
		System.out.println("*** Test BFS\n");
		GraphNode graphNode = GraphFunctions.createGraph();
		GraphFunctions.BFS(graphNode, 6); // searches for value 6
	}
}
