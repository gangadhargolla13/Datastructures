package com.java.core.graph;

import java.util.LinkedList;
public class GraphPrintAllPaths {
public void print(Garph1 graph, int start, int end, String path, boolean[] visited){
    String newPath = path +  "->" + start;
    visited[start] = true;
    LinkedList<Nodes1> list = graph.adjacencyList[start];
    for (int i = 0; i <list.size() ; i++) {
        Nodes1 node = list.get(i);
        if(node.destination!=end && visited[node.destination]==false){
//            visited[node.destination] = true;
            print(graph,node.destination,end,newPath,visited);
        }else if(node.destination==end){
            System.out.println(newPath + "->" + node.destination);
        }
    }
    //remove from path
    visited[start] = false;
}

public void printAllPaths(Garph1 graph, int start, int end){
    boolean[] visited = new boolean[graph.vertices];
    visited[start] = true;
    print(graph, start, end, "", visited);
}

public static void main(String[] args) {
    int vertices = 6;
    Garph1 graph = new Garph1(vertices);
    graph.addEdge(0, 1);
    graph.addEdge(0, 2);
    graph.addEdge(1, 2);
    graph.addEdge(1, 3);
    graph.addEdge(3, 4);
    graph.addEdge(2, 3);
    graph.addEdge(4, 0);
    graph.addEdge(4, 1);
    graph.addEdge(4, 5);
    GraphPrintAllPaths p = new GraphPrintAllPaths();
    p.printAllPaths(graph,0,5);
}
}

class Garph1{
int vertices;
LinkedList<Nodes1> [] adjacencyList;

public Garph1(int vertices){
    this.vertices = vertices;
    adjacencyList = new LinkedList[vertices];
    for (int i = 0; i <vertices; i++) {
        adjacencyList[i] = new LinkedList<Nodes1>();
    }
}

public void addEdge(int source, int destination){
    Nodes1 node = new Nodes1(source, destination);
    //add edge
    adjacencyList[source].addLast(node);
}
}

class Nodes1{
int source;
int destination;

public Nodes1(int source, int destination) {
    this.source = source;
    this.destination = destination;
}
}
