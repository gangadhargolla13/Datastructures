package com.java.colletions.tree;

class Node
{
	int data;
	Node left;
	Node right;
	public Node(int data){
		this.data=data;
		left=null;
		right=null;
	}
}

public class BinarySearchTree 
{
   public static Node root;
   public BinarySearchTree()
   {
	   this.root = null;
   }
   
   public boolean find(int d)
   {
	   Node current = root;
	   while(current!=null)
	   {
		   if(current.data==d){
			   return true;
		   }else if(current.data > d)
		   {
			   current = current.left;
		   }else{
			   current = current.right;
		   }
	   }
	   return false;
   }
   
   public void insert(int d)
   {
	   Node n = new Node(d);
	   if(root == null)
	   {
		   root = n;
		   return;
	   }
	   Node current = root;
	   Node parent = null;
	   while(true)
	   {
		   parent = current;
		   if(d < current.data)
		   {
			   current = current.left;
			   if(current == null)
			   {
				   parent.left=n;
				   return;
			   }
		   }else{
			   current = current.right;
			   if(current == null)
			   {
				   parent.right=n;
				   return;
			   }
		   }
	   }
   }
   
   public void disply(Node root)
   {
	   if(root!=null)
	   {
		   disply(root.left);
		   System.out.println(" "+root.data);
		   disply(root.right);
	   }
   }
   
   public boolean delete(int d){
	   Node parent = root;
	   Node current = root;
	   boolean isLeftChild = false;
	   while(current.data!=d)
	   {
		   parent=current;
		   if(current.data>d){
			   isLeftChild=true;
			   current = current.left;
		   }else{
			   isLeftChild= false;
			   current = current.right;
		   }
		   if(current == null)
		   {
			   return false;
		   }
	   }
	   if(current.left==null && current.right==null){
		   if(current==root)
		   {
			   root = null;
		   }
		   if(isLeftChild == true)
		   {
			   parent.left=null;
		   }else
		   {
			   parent.right=null;
		   }
	   }
	   else if(current.right==null){
		   if(current == root)
		   {
			   root = current.left;
		   }else if(isLeftChild)
		   {
			   parent.left=current.left;
		   }else{
			   parent.right=current.left;
		   }
	   }else if(current.left==null)
	   {
		   if(current == root){
			   root=current.right;
		   }else if(isLeftChild){
			   parent.left=current.right;
		   }else
		   {
			   parent.right = current.left;
		   }
	   }
	   else if(current.left!=null && current.right!=null)
	   {
		   Node succ = getSuccessor(current);
		   if(current == root)
		   {
			   root=succ;
		   }else if(isLeftChild){
			   parent.left=succ;
		   }else
		   {
			   parent.right=succ;
		   }
		   succ.left=current.left;
	   }
	   return true;
   }
   
   public Node getSuccessor(Node deleteNode)
   {
	    Node successor = null;
	    Node successorParent = null;
	    Node current = deleteNode;
	    while(current!=null)
	    {
	    	successorParent = successor;
	    	successor=current;
	    	current = current.left;
	    }
	    if(successor!=deleteNode.right)
	    {
	    	successorParent.left = successor.right;
	    	successor.right=deleteNode.right;
	    }
	    return successor;
   }
   public static void main(String[] args){
	   BinarySearchTree b = new BinarySearchTree();
	   b.insert(3);b.insert(8);
		b.insert(1);b.insert(4);b.insert(6);b.insert(2);b.insert(10);b.insert(9);
		b.insert(20);b.insert(25);b.insert(15);b.insert(16);
		System.out.println("Original Tree : ");
		b.disply(b.root);
		System.out.println("");
		System.out.println("Check whether Node with value 4 exists : " + b.find(5));
   }
}
