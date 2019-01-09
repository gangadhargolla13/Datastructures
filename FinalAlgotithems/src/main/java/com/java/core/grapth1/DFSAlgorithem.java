/*package com.java.core.grapth1;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;

public class DFSAlgorithem {

	private int v;
	private LinkedList<Integer> adjList[];
	
	public DFSAlgorithem(int v)
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
	
	public void DFS(int s)
	{
		boolean[] boo = new boolean[v];
		Stack<Integer> queue = new Stack<Integer>();
		queue.push(s);
		while(!queue.isEmpty())
		{
			int a=queue.pop();
			if(!boo[a])
			{
				System.out.print(a+" ");
				boo[a]=true;
			}
			Iterator<Integer> ir = adjList[a].iterator();
			while(ir.hasNext())
			{
				int i = ir.next();
				if(!boo[i])
				{
					queue.push(i);
				}
			}
		}
	}
	
	public static void main(String[] args) {
		DFSAlgorithem g = new DFSAlgorithem(4);
		g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);
 
        System.out.println("Following is Breadth First Traversal "+
                           "(starting from vertex 2)");
 
        g.DFS(2);
	}
}
*/