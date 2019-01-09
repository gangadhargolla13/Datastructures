package com.java.core.trees;

public class DeepestLeftLeaf {

	public int deepestLevel = 0;
	public int deepLeftNode;
	public int deepLeft(Node root) {
		find(root, 0, true);
		return deepLeftNode;
	}
	
	public void find(Node root, int level, boolean left) {
		if (root != null) {
			find(root.left, ++level, true);
			if (left && deepestLevel < level) {
				deepLeftNode = root.data; 
				deepestLevel = level;   
			}
			find(root.right, level, false);
		}
	}
	public int max(int a, int b, int c) {
		return (Math.max(a, Math.max(b, c)));
	}
	public int getMax(Node root) {
		if (root != null) {
			return max(root.data, getMax(root.left), getMax(root.right));
		}
		return 0;
	}

	public boolean checkMirror(Node root1,Node root2){
		if (root1 == null && root2 == null) {
			return true;
		}
                if(root1.data !=root2.data){
                        return false;
                }
                if ((root1 == null && root2 != null)
        				|| (root1 != null && root2 == null)) { 
        			return false;
        		}
        		return checkMirror(root1.left, root2.right)
        				&& checkMirror(root1.right, root2.left);
	}
	String path;
	public void hasPath(Node root,int sum,String path){
		if(root!=null){
			if(root.data>sum){
				return ;
			}
			else{
				path+=" " + root.data; 
				sum=sum-root.data;
				if(sum==0){
					System.out.println(path);
				}
				hasPath(root.left,sum,path);
				hasPath(root.right,sum,path);
			}
		}
	}
	public static void main(String args[]) {
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(7);
		root.left.right = new Node(5);
		root.right.left = new Node(6);
		root.right.right = new Node(7);
		DeepestLeftLeaf dp = new DeepestLeftLeaf();
		System.out.println("Deapest Left child is: " + dp.deepLeft(root));
		System.out.println(dp.getMax(root));
		
		Node root1 = new Node(1);
		root1.left = new Node(2);
		root1.left.right = new Node(3);
		root1.right = new Node(4);

		Node root2 = new Node(1);
		root2.right = new Node(2);
		root2.right.left = new Node(2);
		root2.left = new Node(4);
		System.out.println("Is Mirror Trees : " + dp.checkMirror(root1, root2));
		dp.hasPath(root, 10, "");
	}
}
