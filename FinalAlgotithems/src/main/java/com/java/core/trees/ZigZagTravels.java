package com.java.core.trees;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class ZigZagTravels {

	public static void main(String[] args) {
		Node root = new Node(5);
		root.left = new Node(10);
		root.right = new Node(15);
		root.left.left = new Node(20);
		root.left.right = new Node(25);
		root.right.left = new Node(30);
		root.right.right = new Node(35);
		root.left.left.left = new Node(40);
		root.left.left.right = new Node(45);
		root.left.left.right.left = new Node(45);
		findDepth(root);
	}
	
	public static void printPath(Node root)
	{
       ArrayList al = new ArrayList();	
       Queue q = new LinkedList();
       boolean eventStatus = false;
       if(root==null)
    	   return ;
       q.add(root);
       while(!q.isEmpty()){
    	   int level = q.size();
    	   al.clear();
    	   while(level>0){
    		   Node n = (Node) q.poll();
    		   al.add(n.data);
    		   if(n.left!=null)
    			   q.add(n.left);
    		   if(n.right!=null)
    			   q.add(n.right);
    		   level--;
    	   }
    	   if(eventStatus)
    	   {
    		   System.out.println(al);
    		   eventStatus=!eventStatus;
    	   }else{
    		   Collections.reverse(al);
    		   System.out.println(al);
    		   eventStatus=!eventStatus;
    	   }
    	   System.out.println("");
       }
	}
	static int maxVal=0;
	public static void findDepth(Node root){
		if(root==null)
			return;
		Queue q = new LinkedList();
		q.add(root);
		int ln = 0;
		while(!q.isEmpty())
		{
			ln=q.size();
			if(ln>maxVal){
				maxVal = ln;
			}
			while(ln>0)
			{
				Node n = (Node)q.remove();
				   if(n.left!=null){
	    			   q.add(n.left);
				   }
	    		   if(n.right!=null){
	    			   q.add(n.right);
	    		   }
	    		   ln--;
			}
		}
		System.out.println("Max depth is "+maxVal);
	}
}
