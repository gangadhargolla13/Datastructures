package com.java.core.trees;

public class BinarySearchTree {

	public static Node11 root;
	
	public BinarySearchTree(){
		this.root=null;
	}
	
	public boolean find(int d){
		if(root==null)
			return false;
		Node11 current = root;
		
		while(current!=null){
			if(current.data==d)
				return true;
			else if(current.data>d)
				current = current.left;
			else
				current = current.right;
		}
		return false;
	}
	
	public void insert(int d){
		Node11 n = new Node11(d);
		if(root==null){
			root=n;
			return;
		}
		Node11 current = root;
		Node11 parent = null;
		while(true){
			parent = current;
			if(d<current.data){
				current = current.left;
				if(current == null){
					parent.left=n;
					return;
				}
				
			}else{
				current = current.right;
				if(current == null){
					parent.right=n;
					return;
				}
						
			}
		}
	}
	
	public boolean delete(int d){
		Node11 curr = root;
		Node11 par = null;
		boolean isLeft = false;
		while(curr.data!=d){
			par = curr;
			if(curr.data>d){
				isLeft = true;
				curr = curr.left;
			}else{
				isLeft = false;
				curr = curr.right;
			}
			if(curr == null){
				return false;
			}
		}
		if(curr.left==null && curr.right==null){
			if(curr == root){
				root = null;
			}
			if(isLeft){
				par.left=null;
			}else{
				par.right=null;
			}
		}else if(curr.right==null){
			if(curr == root)
				root = curr.left;
			else if(isLeft)
				par.left=curr.left;
			else
				par.right=curr.left;
		}else if(curr.left==null){
			if(curr == root)
				root = curr.right;
			else if(isLeft)
				par.left=curr.right;
			else
				par.right=curr.right;
		}else if(curr.left!=null && curr.right!=null){
			Node11 succ = getSucc(curr);
			if(curr==root)
				root=succ;
			else if (isLeft)
				par.left=succ;
			else
				par.right=succ;
			succ.left=curr.left;
		}
		return true;
	}
	
	public Node11 getSucc(Node11 curr){
		Node11 succ = null;
		Node11 succPa = null;
		Node11 cu = curr.right;
		while(cu!=null){
			succPa=succ;
			succ=cu;
			cu=cu.left;
		}
		if(succ!=curr.right){
			succPa.left=succ.right;
			succ.right=curr.right;
		}
		return succ;
	}
	public void display(Node11 root){
		if(root!=null){
			display(root.left);
			System.out.print(" "+root.data);
			display(root.right);
		}
	}
	
	public int heightOfTree(Node11 n){
		if(n==null)return 0;
		return (1+Math.max(heightOfTree(n.left), heightOfTree(n.right)));
	}
	public static void main(String[] args) {
		BinarySearchTree b = new BinarySearchTree();
		b.insert(3);b.insert(8);
		b.insert(1);b.insert(4);b.insert(6);b.insert(2);b.insert(10);b.insert(9);
		b.insert(20);b.insert(25);b.insert(15);b.insert(16);
		System.out.println("Original Tree : ");
		b.display(b.root);	
		System.out.println(b.heightOfTree(root));
		System.out.println("--------");
		System.out.println("");
		System.out.println("Check whether Node with value 4 exists : " + b.find(4));
		System.out.println("Delete Node with no children (2) : " + b.delete(2));		
		b.display(root);
		System.out.println("\n Delete Node with one child (4) : " + b.delete(4));		
		b.display(root);
		System.out.println("\n Delete Node with Two children (10) : " + b.delete(10));		
		b.display(root);
	}
	
}
