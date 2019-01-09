package com.java.core.recurtion;

public class StringPermutations {
	public void permutation(char[] ch,int left,int size){
		int x;
         if(left==size){
        	 for(int i=0;i<size;i++){
        		 System.out.print(ch[i]);
        	 }
        	 System.out.println("");
         }
         else{
        	 for( x=left;x<size;x++){
        		 swap(ch,left,x);
        		 permutation(ch,left+1,size);
        		 System.out.println("i am "+x);
        		 swap(ch,left,x);
        	 }
         }
	}
	
	public void swap(char[] c,int i,int j){
		char t = c[i];
		c[i]=c[j];
		c[j]=t;
	
	}
	public static void main(String[] args) {
		String s = "abc";
		char[] arrCh = s.toCharArray();
		StringPermutations i = new StringPermutations();
		i.permutation(arrCh, 0, arrCh.length);
	}
}
