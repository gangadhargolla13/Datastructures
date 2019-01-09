package com.java.core.trees;

public class TwoIdenticalBST {
public static void main(String[] args) {
	BinarySearchTree a = new BinarySearchTree();
	a.insert(2);a.insert(4);a.insert(1);a.insert(3);a.insert(5);
	BinarySearchTree b = new BinarySearchTree();
	b.insert(2);b.insert(4);b.insert(1);b.insert(3);b.insert(5);
	a.insert(11);b.insert(12);
	TwoIdenticalBST t = new TwoIdenticalBST();
	System.out.println(t.identicalBSTs(a.root, b.root));
	
	Node11 root = new Node11(1);
	Node11 x1 = new Node11(2);
	Node11 y1 = new Node11(3);
	root.left = x1;
	root.right = y1;
	root.left.left = new Node11(4);
	root.right.left = new Node11(6);
	Node11 x2 = new Node11(7);
	Node11 y2 = new Node11(9);
	root.right.left.left = new Node11(8);
	root.right.left.right = y2;
	root.left.left.left = x2;
	//System.out.println(t.sameParents(root, x1, y1));
	//System.out.println(t.sameParents(root, x2, y2));
	//t.rightView(root, 1);
	//t.leftView(root, 1);
	//System.out.println(t.maxPathSum(root));
	//t.printOnlyLeaves(root);
	t.mirror(root);
}

public boolean identicalBSTs(Node11 rootA, Node11 rootB){
	if((rootA==null)&&(rootB==null)){
		return true;
	}else if((rootA!=null && rootB==null)||(rootA==null && rootB!=null)){
		return false;
	}else if(rootA.data==rootB.data){
		return identicalBSTs(rootA.left, rootB.left) && identicalBSTs(rootA.right, rootB.right);
	}else{
		return false;
	}
 }

public boolean sameParents(Node11 root,Node11 x,Node11 y){
	if(root==null)
		return false;
	return ((root.left==x && root.right==y)||(root.right==y && root.left==x)||sameParents(root.left,x,y)|| sameParents(root.right,x,y));
}

int currLev = 0;
public void rightView(Node11 root,int nextLev){
	if(root==null)return ;
	if(currLev<nextLev){
		System.out.println(" "+root.data);
		currLev = nextLev;
	}
	rightView(root.right,nextLev+1);
	rightView(root.left,nextLev+1);
}

int currLev1 = 0;
public void leftView(Node11 root,int nextLev){
	if(root==null)return ;
	if(currLev1<nextLev){
		System.out.println(" "+root.data);
		currLev1 = nextLev;
	}
	leftView(root.left,nextLev+1);
	leftView(root.right,nextLev+1);
}

public static int maxSoFar =0;
public int maxPathSum(Node11 root){
    if(root!=null){
        int leftS = maxPathSum(root.left);
        int rightS = maxPathSum(root.right);
        int sumCurrent;
        if(leftS<0 && rightS<0){
            sumCurrent = root.data;
        }else{
            sumCurrent = Math.max(leftS+rightS+root.data , Math.max(leftS, rightS));
        }
        if(maxSoFar<sumCurrent){
            maxSoFar = sumCurrent;
        }
        return Math.max(leftS,rightS)+root.data;
    }
    else return 0;
}
public void printOnlyLeaves(Node11 root){
	if(root!=null){
		printOnlyLeaves(root.left);
		if((root.left==null) && (root.right!=null)){
			System.out.print(" " + root.right.data);
		}
		if((root.left!=null) && (root.right==null)){
			System.out.print(" " + root.left.data);
		}
		printOnlyLeaves(root.right);
	}
}

public void print(Node11 n){
	if(n!=null){
		print(n.left);
		System.out.println(" "+n.data);
		print(n.right);
	}
}
public void mirror(Node11 root){
	print(root);
	Node11 x = mirrorTree(root);
	System.out.print("\n Mirror Image ");
	print(x);
}
public Node11 mirrorTree(Node11 n){
	if(n!=null){
		Node11 t = n.left;
		n.left=n.right;
		n.right=t;
		mirrorTree(n.right);
		mirrorTree(n.left);
	}
	return n;
}
}

