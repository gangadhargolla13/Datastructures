package com.java.core.trees;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class SizezOfTree {

	public static int getSize(Node root){
		if(root!=null){
			int size = 0;
		Queue<Node> q = new LinkedList<>();
		q.add(root);
		while(!q.isEmpty()){
			size++;
			Node n = q.poll();
			if(n.left!=null){
				q.add(n.left);
			}
			if(n.right!=null){
				q.add(n.right);
			}
		}
		return size;
		}
		return 0;
	}
	
	public void preOder(Node root){
		if(root!=null){
			System.out.print(root.data+" ");
			preOder(root.left);
			preOder(root.right);
		}
	}
	public void postOder(Node root){
		if(root!=null){
			postOder(root.right);
			postOder(root.left);
			System.out.print(root.data+" ");
		}
	}
	
	public void inOder(Node root){
		if(root!=null){
			postOder(root.left);
			System.out.print(root.data+" ");
			postOder(root.right);
		}
	}

	public boolean isPresent(Node root,int x){
		if(root!=null){
			if(root.data==x)
				return true;
			else{
				return isPresent(root.left, x) || isPresent(root.right, x);
			}
		}
		return false;
	}
	
	public boolean findNode(Node root,int x){
		if(root!=null){
		Queue<Node> q = new LinkedList<>();
		q.add(root);
		while(!q.isEmpty()){
			Node n = q.poll();
			if(n.data==x)
				return true;
			if(n.left!=null){
			     q.add(n.left);
			}
			if(n.right!=null){
				q.add(n.right);
			}
		}
		}
		return false;
	}
	
	public Node deleteNode(Node root){
		if(root!=null){
			deleteNode(root.left);
			deleteNode(root.right);
			System.out.println("Deleting Node "+root.data);
			root= null;
			return root;
		}
		return null;
	}
	
	public void inorderInr(Node root){
		Stack<Node> st =new Stack<>();
		while(true){
			while(root!=null){
				st.push(root);
				root = root.left;
			}
			if(st.isEmpty())
				return;
			root = st.pop();
			System.out.print(root.data+" ");
			root = root.right;
		}
	}
	
	public void preorderInr(Node root){
		Stack<Node> st =new Stack<>();
		while(true){
			while(root!=null){
				System.out.print(root.data+" ");
				st.push(root);
				root = root.left;
			}
			if(st.isEmpty())
				return;
			root = st.pop();
			root = root.right;
		}
	}

	public void preOrderTrv(Node root){
		Stack<Node> s1 = new Stack<Node>();
		Stack<Node> s2 = new Stack<Node>();
		s1.push(root);
		while (s1.isEmpty() == false) {
			Node temp = s1.pop();
			s2.push(temp);
			if(temp.left!=null){
				s1.push(temp.left);
			}
			if(temp.right!=null){
				s1.push(temp.right);
			}
		}
		System.out.println("Preorder Traversal: ");
		while(s2.isEmpty()==false){
			System.out.print(s2.pop());
		}
	}
	public static void main(String[] args) {
		
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);

		System.out.println("Tree Size: " + getSize(root));
        SizezOfTree s = new SizezOfTree();
        s.inOder(root);
        System.out.println();
        s.preOder(root);
        System.out.println();
        s.postOder(root);
	}
}
