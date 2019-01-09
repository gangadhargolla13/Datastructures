package com.java.core.treeandgraph;

public class DFS {

	public static void main(String[] args) {
		System.out.println("*** Test DFS\n");
		GraphNode graphNode = GraphFunctions.createGraph();
		GraphFunctions.DFS(graphNode, 6); // searches for value 6
	}
}
