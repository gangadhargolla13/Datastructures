/*package com.java.core.grapth1;

import java.util.Iterator;
import java.util.LinkedList;

public class BFSAlgorithem {

	private int v;
	private LinkedList<Integer> adjList[];
	
	public BFSAlgorithem(int v)
	{
		this.v=v;
		adjList = new LinkedList[v];
		for(int i=0;i<v;i++)
		{
			adjList[i]=new LinkedList<>();
		}
	}
	
	public void addEdge(int s,int d)
	{
		adjList[s].add(d);
	}
	
	public void BFS(int s)
	{
		boolean[] boo = new boolean[v];
		LinkedList<Integer> queue = new LinkedList<Integer>();
		boo[s]=true;
		queue.add(s);
		while(queue.size() != 0)
		{
			int a=queue.poll();
			System.out.print(a+" ");
			Iterator<Integer> ir = adjList[a].iterator();
			while(ir.hasNext())
			{
				int i = ir.next();
				if(!boo[i])
				{
					boo[i]=true;
					queue.add(i);
				}
			}
		}
	}
	
	public static void main(String[] args) {
		BFSAlgorithem g = new BFSAlgorithem(4);
		g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);
 
        System.out.println("Following is Breadth First Traversal "+
                           "(starting from vertex 2)");
 
        g.BFS(2);
	}
}
*/