package com.java.core.algorithems_proj;

public class ConvertTree {
   public static Node<Integer> root;
	public static void main(String[] args) {
		System.out.println("I am gangadhar!");
		root = new Node<>(10);
		root.left=new Node<>(5);
		root.right=new Node<>(15);
		root.left.left=new Node<>(1);
		root.left.right=new Node<>(7);
		root.right.left=new Node<>(12);
		root.right.right=new Node<>(20);
		
		ConvertTree t= new ConvertTree();
		t.convert(root);
        System.out.println("Inorder Traversal: ");
        t.print(root);
        System.out.println("Operation is completed");
	}
	
	public void inorder(Node<Integer> nn,Node<Integer> mm)
	{
		if(nn==null)
		{
			return;
		}else{
		inorder(nn.right,mm);
		if(nn.right==null && mm!=null)
		{
			nn.right=mm;
			nn.rightThred=true;
		}
		inorder(nn.left,nn);
		}
	}
	
	public Node<Integer> leftNode(Node<Integer> node)
	{
		if(node==null)
		{
			return null;
		}else{
			while(node.left!=null){
				node=node.left;
			}
			return node;
		}
	}
	
	 public void convert(Node<Integer> root){
	        inorder(root, null);
	    }
	 
	 public void print(Node<Integer> node){
		 Node<Integer> current = leftNode(root);
		 while(current!=null){
	            System.out.print(" " + current.data);
	            if(current.rightThred)
	            {
	            	current=current.right;
	            }
	            else{
	            	current= leftNode(current.right);
	            }
		 }
		 System.out.println();
	 }
}

class Node<E>{
	Node<E> left;
	Node<E> right;
	E data;
	boolean rightThred;
	public Node(E data){
		this.data=data;
		rightThred=false;
	}
}