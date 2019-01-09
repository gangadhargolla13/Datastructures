package com.java.core.algorithems_proj;

import java.util.Scanner;

public class FindHouses {
	public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String str = scan.nextLine();
        char[] c = str.toCharArray();
        int ih=0;
        int ch =0;
        char pre=' ';
        int count=0;
        for(int i=0;i<c.length;i++){
        	if(c[i] == 'I')
        	{
        		if(count>0 && pre==c[i])
        		{
        			ih+=count;
        			count=0;
        		}
        		ih++;
        		pre=c[i];
        	}else if(c[i] == 'C')
        	{
        		ch++;
        		pre=c[i];
        		if(count>0 && pre==c[i])
        		{
        			ih+=count;
        			count=0;
        		}
        	}else if(c[i] == '.' && (pre =='I' ||pre =='C')){
        		count++;
        	}
        }
        System.out.println(ih+","+ch);
	}
}
