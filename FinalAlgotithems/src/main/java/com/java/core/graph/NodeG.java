package com.java.core.graph;

import java.util.ArrayList;
import java.util.List;

public class NodeG {

	int data;
	List<NodeG> list;
	boolean visited;

	public NodeG(int data) {
		this.data = data;
		list = new ArrayList<>();
	}

	public void addNeighboors(NodeG ne) {
		this.list.add(ne);
	}

	public List<NodeG> gerNeighbours() {
		return this.list;
	}

	public void setNeighbours(List<NodeG> ne) {
		this.list = ne;
	}
}
