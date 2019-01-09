package com.java.core.trees;

public class BinarySreachTree 
{

	public static Node root = null;
	
	public boolean find(int n){
		Node current = root;
		while(current!=null){
			int d = current.data;
			if(d==n){
				return true;
			}else if(d>n){
				current =current.left;
			}else{
				current = current.right;
			}
		}
		return false;
	}
	
	public void insert(int d){
		Node n = new Node(d);
		if(root==null){
			root = n;
			return;
		}
		Node current = root;
		Node parent = null;
		while(true){
			parent = current;
			if(d<current.data)
			{
				current = current.left;
				if(current==null)
				{
					parent.left=n;
					return;
				}
			}else
			{
				current = current.right;
				if(current==null){
					parent.right=n;
					return;
				}
			}
		}
	}
	
	public void display(Node val)
	{
		if(val!=null){
			display(val.left);
			System.out.print(" "+val.data);
			display(val.right);
		}
	}
	
	public boolean delete(int d){
		Node parent =root;
		Node current = root;
		boolean isLeft = false;
		while(current.data!=d)
		{
			parent = current;
			if(current.data>d)
			{
				isLeft=true;
				current=current.left;
						
			}else 
			{
				isLeft=false;
				current=current.right;
			}
			if(current==null){
				return false;
			}
		}
		if(current.left==null && current.right==null)
		{
			if(current == root)
				root=null;
			if(isLeft)
				current.left=null;
			else
				current.right=null;
		}
		else if(current.right==null){
			if(current==root)
				root=current.left;
			else if(isLeft)
			{
				parent.left=current.left;
			}else{
				parent.right=current.left;
			}
		}
		else if(current.left==null){
			if(current==root)
				root=current.right;
			else if(isLeft)
			{
				parent.left=current.right;
			}else{
				parent.right=current.right;
			}
		}else if(current.left!=null && current.right!=null){
			Node su = getSuccessor(current);
			if(current==root)
				root=su;
			else if(isLeft){
				parent.left=su;
			}
			else{
				parent.right=su;
			}
			su.left=current.left;
		}
		return true;
	}
	
	public Node getSuccessor(Node deleteNode)
	{
		Node successor = null;
		Node successorParent = null;
		Node current = deleteNode.right;
		while(current!=null)
		{
			successorParent = successor;
			successor = current;
			current = current.left;
		}
		if(successor!=deleteNode.right){
			successorParent.left=successor.right;
			successor.right=deleteNode.right;
		}
		return successor;
	}
}
