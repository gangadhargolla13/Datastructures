package com.java.core.string;

public class Permutations {

	void permutations(char[] a,int left,int size)
	{
		if(left == size){
			for(int i=0;i<size;i++){
				System.out.print(a[i]);
			}
			System.out.println(" ");
		}
		else {
			for(int x=left;x<size;x++){
				swap(a,left,x);
				permutations(a,left+1,size);
				swap(a,left,x);
			}
		}
	}
	
	public void swap(char[] w,int n,int m){
		char c = w[n];
		w[n]=w[m];
		w[m]=c;
	}
	
	boolean check(String s1,String s2){
		if(s1.length()!=s2.length())
			return false;
		else{
			String s=s1+s1;
			if(s.contains(s2))
				return true;
			else
				return false;
		}
	}
	public static void main(String[] args) {
		char[] ch = "abc".toCharArray();
		Permutations p = new  Permutations();
		//p.permutations(ch, 0, ch.length);
		System.out.println(p.check("sumitjain", "tjainsumi"));
	}
}
