package com.java.core.trees;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class SizeOfTree {
	ArrayList<Integer> al = new ArrayList<>();
	public static boolean evenLevel = false;
	public static void main(String args[]){
		Node11 root = new Node11(20);
		root.left = new Node11(10);
		root.right = new Node11(30);
		root.left.left = new Node11(5);
		root.left.right = new Node11(15);
		root.right.left = new Node11(25);
		root.right.right = new Node11(35);		
		SizeOfTree t = new SizeOfTree();
		System.out.println("Size of the Tree is : " + t.getSize(root));
		System.out.println(t.isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE));
		t.levelOrderQueue(root);
		System.out.println(t.levelWidth(root));
		t.levelWidth(root, 2, 3);
		int [] path = new int [100];
		t.printPath(root, path, 0);
	}
	
	public int getSize(Node11 root){
		if(root==null)
			return 0;
		return 1+getSize(root.left)+getSize(root.right);
	}
	
	public boolean isBST(Node11 t,int min,int max){
		if(t!=null){
			if(t.data > max||t.data<min)
				return false;
			return isBST(t.left,min,t.data) && isBST(t.right,t.data,max);
		}
		else
			return true;
	}
	
	public void levelOrderQueue(Node11 root){
		Queue q = new LinkedList();
		int levelNodes =0;
		if(root==null) return;
		q.add(root);
		while(!q.isEmpty()){
			levelNodes = q.size();
			al.clear();
			while(levelNodes>0){
				Node11 n = (Node11)q.remove();
				al.add(n.data);
				//System.out.print(" " + n.data);
				if(n.left!=null) q.add(n.left);
				if(n.right!=null) q.add(n.right);
				levelNodes--;
			}
			if(evenLevel){
				System.out.print(al);
				evenLevel = !evenLevel;
			}else{
				Collections.reverse(al);
				System.out.print(al);
				evenLevel = !evenLevel;
			}
			System.out.println("");
		}
	}
	public static int maxWidth=0;
	public int levelWidth(Node11 n){
		Queue q = new LinkedList();
		int levelNode = 0;
		if(n==null)return 0;
		q.add(n);
		while(!q.isEmpty()){
			levelNode = q.size();
		if(levelNode>maxWidth)
			maxWidth = levelNode;
		while(levelNode>0){
			Node11 nnn = (Node11)q.remove();
			if(nnn.left!=null) q.add(nnn.left);
			if(nnn.right!=null) q.add(nnn.right);
			levelNode--;
		}
		}
		return maxWidth;
	}
	public static int culevel =1;
	public void levelWidth(Node11 n,int low,int high){
		Queue q = new LinkedList();
		int levelNode = 0;
		if(n==null)return ;
		q.add(n);
		while(!q.isEmpty()){
			levelNode = q.size();
		while(levelNode>0){
			Node11 nnn = (Node11)q.remove();
			if(culevel>=low && culevel<=high)
				System.out.print(" "+nnn.data);
			if(nnn.left!=null) q.add(nnn.left);
			if(nnn.right!=null) q.add(nnn.right);
			levelNode--;
		}
		if(culevel>=low && culevel<=high)
			System.out.println("");
		culevel++;

		}
	}
	
	int pathLen = 0;
	public void printPath(Node11 n,int[] path,int pathL){
		if(n==null)return ;
		path[pathL++]=n.data;
		if(n.left==null && n.right==null){
			print(path,pathL);
		}
		else{
			printPath(n.left,path,pathL);
			printPath(n.right,path,pathL);
		}
	}
	
	public void print(int[] p,int pl){
		for(int i=0;i<pl;i++){
			System.out.print(p[i]+ " ");
		}
		System.out.println();
	}
}
