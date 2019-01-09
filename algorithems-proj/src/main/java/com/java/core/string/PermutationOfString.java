package com.java.core.string;

import java.util.Hashtable;
import java.util.Set;

public class PermutationOfString {

	boolean isPermutation(String s1,String s2){
		if(s1.length()!=s2.length()){
			return false;
		}
		Hashtable<Character,Integer> h = new Hashtable<>();
		for(int i=0;i<s1.length();i++){
			char c = s1.charAt(i);
			if(h.containsKey(c)){
				int v = h.get(c)+1;
				h.put(c, v);
			}else
			{
				h.put(c, 1);
			}
		}
		
		for(int i=0;i<s2.length();i++){
			char c = s2.charAt(i);
			if(h.containsKey(c)){
				int v = h.get(c);
				if(v==0)
					return false;
				v--;
				h.put(c, v);
			}else
				return false;
		}
		Set<Character> keys = h.keySet();
		for(Character k :keys ){
			if(h.get(k)!=0){
				return false;
			}
		}
		return true;
	}
	
	public static void main(String args[]){
		String s1 = "sumit";
		String s2 = "mtisu";
		PermutationOfString p = new PermutationOfString();
		System.out.println(s1 +" and "+ s2 + " are permutation of each other? " + p.isPermutation(s1, s2));
		s1 = "xyzab";
		s2 = "bayzxx";
		System.out.println(s1 +" and "+ s2 + " are permutation of each other? " + p.isPermutation(s1, s2));
	}
}
