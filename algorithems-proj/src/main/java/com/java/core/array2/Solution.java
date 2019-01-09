package com.java.core.array2;

import java.util.Set;
import java.util.TreeSet;

public class Solution {

	public static void main(String[] args) {
		String s ="ganga5";
		String s1="ganga"+"5";
		String s2 = new String("ganga5");
		String s3 = new String("ganga"+"5");
		System.out.println(s==s1);
		System.out.println(s2==s3);
		System.out.println(s2.equals(s3));
		/*Set s = new TreeSet();
		boolean[] b = new boolean[5];
		b[0]=s.add("a");
		b[1]=s.add(new Integer(42));
		b[2]=s.add("b");
		b[3]=s.add("a");
		b[4]=s.add(new Object());
		for(int i=0;i<b.length;i++)
		{
			System.out.print(b[i]+" ");
		}*/
	}
}
