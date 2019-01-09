package com.java.core.trees;

public class PrintFromParent 
{

	public void print(Node root,int k)
	{
		if(root!=null)
		{
			if(k==0)
			{
				System.out.println(root.data);
			}
			print(root.left,--k);
			print(root.right,k);
		}
	}
	
	public int pathLen(Node root,int n1)
	{
		if(root!=null)
		{
			int x=0;
			if(root.data == n1 || (x = pathLen(root.left,n1)) > 0 ||(x=pathLen(root.right,n1))>0)
			{
				return x+1;
			}
			return 0;
		}
		return 0;
	}
	
	public Node LCA(Node root,Node n1,Node n2)
	{
		if(root==null)
		{
			return null;
		}
		if(root.data>n1.data && root.data > n2.data)
		{
			return LCA(root.left,n1,n2);
		} else if(root.data<=n1.data && root.data > n2.data)
		{
			return LCA(root.right,n1,n2);
		}
		return root;
	}
	
	// To find distance between two nodes distance(root,x)+distance(root,y)-2*(distance(root to LCA(x,y))
	
}
