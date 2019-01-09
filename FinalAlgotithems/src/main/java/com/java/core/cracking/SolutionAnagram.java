package com.java.core.cracking;

import java.util.Arrays;
import java.util.Scanner;

public class SolutionAnagram {
	static int al =26;
    public static int numberNeeded(String first, String second) {
      int[] aa1=getSize(first);
      int[] aa2=getSize(second);
        return fi(aa1,aa2);
    }
    public static int fi(int[] a1,int[] a2)
    {
        int delta=0;
        if(a1.length!=a2.length)
        {
            return -1;
        }
        for(int i=0;i<a1.length;i++){
            int diff = Math.abs(a1[i]-a2[i]);
            delta+=diff;
        }
        return delta;
    }
  public static int[] getSize(String f)
  {
      int[] c = new int[al];
      for(int i=0;i<f.length();i++)
      {
          char c1 = f.charAt(i);
          int off = (int) 'a';
          int code= c1-off;
          c[code]++;
      }
      System.out.println(Arrays.toString(c));
      return c;
  }
    public static void main(String[] args) {
    	String g ="gan.ga-dha_r";
    	String[] ss = g.split("\\.|\\-|\\_");
    	System.out.println(Arrays.toString(ss));
    	int a=7;
    	System.out.println(Integer.toBinaryString(a));
    	//System.out.println(Integer.toBinaryString(a<<1));
    	System.out.println(Integer.toBinaryString(a>>1));
    	//System.out.println(a<<1);
       /* Scanner in = new Scanner(System.in);
        String a = in.next();
        String b = in.next();
        System.out.println(numberNeeded(a, b));*/
    }
}
