package com.java.core.trees;

import java.util.ArrayList;
import java.util.Set;
import java.util.Stack;
import java.util.TreeMap;

public class VerticalOrder {

	public static TreeMap<Integer, ArrayList> ht= new TreeMap<>();
	public static int level;
	public ArrayList<Integer> al;
	public Node11 vertical(Node11 root, int level) {
		if (root == null) {
			return null;
		}
		Node11 y = vertical(root.left, --level);
		if (y == null) {
			level++;
		}
		if (ht.get(level) != null) {
			ArrayList x = ht.get(level);
			x.add(root.data);
			ht.put(level, x);
		} else {
			al = new ArrayList<>();
			al.add(root.data);
			ht.put(level, al);
		}
		return vertical(root.right, ++level);
	}
	
	public void printResult(TreeMap ht) {
		Set<Integer> i = ht.keySet();
		for (int keys : i) {
			System.out.println(ht.get(keys)+" "+keys);
		}
	}
	
	public static TreeMap<Integer, Integer> ht1 = new TreeMap<>();;
	public static int level1;
	public Node11 vertical1(Node11 root, int level1){
		if(root == null)
			return null;
		Node11 n = vertical(root.left,--level1);
		if(n==null)
			level1++;
		if(ht1.get(level1)!=null){
			int y = ht1.get(level1);
			ht1.put(level1, root.data + y);
		}
		else
		{
			ht1.put(level1, root.data);
		}
		return vertical(root.right, ++level1);
	}
	
	public int printLenth(Node11 root,int n){
		if(root!=null){
			int x=0;
			if(root.data==n||(x=printLenth(root.left,n))>0 || (x=printLenth(root.right,n))>0){
			return x+1;
			}
			else
				return 0;
		}
		return 0;
	}
	public Node11 findLCA(Node11 root,int n1,int n2){
		if(root!=null){
			if(root.data==n1 || root.data==n2)
				return root;
			Node11 left = findLCA(root.left,n1,n2);
			Node11 right = findLCA(root.right,n1,n2);
			if(left!=null && right!=null)
				return root;
			if(left!=null)
				return left;
			if(right!=null)
				return right;
		}
		return null;
	}
	
	public void print(Node11 root,int d){
		if(root!=null){
			if(d==0){
				System.out.print(" "+root.data);
			}
			print(root.left,--d);
			print(root.right,d);
		}
	}
	public int findDistance(Node11 root, int n1, int n2) {
		int x = printLenth(root, n1) - 1;
		int y = printLenth(root, n2) - 1;
		int lcaData = findLCA(root, n1, n2).data;
		int lcaDistance = printLenth(root, lcaData) - 1;
		return (x + y) - 2 * lcaDistance;
	}
	
	public void DFS(Node11 root){
		if(root!=null){
			Stack<Node11> s = new Stack<>();
			s.add(root);
			while(!s.isEmpty()){
				Node11 x = s.pop();
				if(x.right!=null) s.add(x.right);
				if(x.left!=null) s.add(x.left);			
				System.out.print(" " + x.data);
			}
		}
	}
	public static void main(String args[]) {
		Node11 root = new Node11(1);
		root.left = new Node11(2);
		root.right = new Node11(3);
		root.left.left = new Node11(4);
		root.left.right = new Node11(5);
		root.left.right.left = new Node11(6);
		root.left.right.right = new Node11(7);
		root.right.right = new Node11(8);
		root.right.right.right = new Node11(9);

		VerticalOrder p = new VerticalOrder();
		//p.vertical1(root, 0);
		//p.printResult(ht1);
		//System.out.println(p.findDistance(root, 45, 20));
        p.print(root, 3);
        System.out.println(" ");
        p.DFS(root);
	}
}

