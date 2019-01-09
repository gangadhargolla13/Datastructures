package com.java.core.trees;

public class BinaryTreeImpl<T> {

	public BTNode<T> root = null;
	public void insert(T data){
		root = insert(data,root);
	}
	
	public  BTNode<T> insert(T data, BTNode<T> node)
	{
		if(node==null)
		{
			return node;
		}
		else
		{
			if(node.getRight()==null)
			{
				node.right=insert(data,node.right);
			}else
			{
				node.left=insert(data,node.left);
			}
		}
		return node;
	}
	
	public int countNode()
	{
		return countNode(root);
	}
	
	public int countNode(BTNode<T> node)
	{
		if(node == null)
			return 0;
		else
		{
			int count = 1;
			count += countNode(node.left);
			count += countNode(node.right);
			return count;
		}
	}
	
	public boolean search(T data)
	{
		return search(data,root);
	}
	
	public boolean search(T data, BTNode<T> node) {
		if (node.getData() == data) {
			return true;
		}
		if (node.getLeft() != null) {
			if (search(data, node.getLeft())) {
				return true;
			}
		}

		if (node.getRight() != null) {
			if (search(data, node.getRight())) {
				return true;
			}
		}
		return false;
	}
	
	public void inorder()
	{
		inorder(root);
	}
	public void inorder(BTNode<T> node)
	{
		if(node!=null)
		{
			inorder(node.getLeft());
			System.out.println(node.getData()+" ");
			inorder(node.getRight());
		}
	}
	
	public void preorder()
	{
		preorder(root);
	}
	
	public void preorder(BTNode<T> node)
	{
		if(node!=null)
		{
			System.out.println(node.getData()+" ");
			preorder(node.getLeft());
			preorder(node.getRight());
		}
	}
	
	public void postorder()
	{
		postorder(root);
	}
	
	public void postorder(BTNode<T> node)
	{
		postorder(node.getLeft());
		postorder(node.getRight());
		System.out.println(node.getData()+" ");
	}
}

class BTNode<T>{
	T data;
	BTNode<T> left;
	BTNode<T> right;
	
	public BTNode(T data){
		this.data= data;
		this.left=null;
		this.left=null;
	}
	
	public BTNode<T> getRight()
	{
		return right;
	}
	
	public BTNode<T> getLeft()
	{
		return left;
	}
	public T getData()
	{
		return data;
	}
	public void setRight(BTNode<T> right)
	{
		this.right=right;
	}
	
	public void setLeft(BTNode<T> left)
	{
		this.left=left;
	}
	
	public void setData(T data)
	{
		this.data=data;
	}
}