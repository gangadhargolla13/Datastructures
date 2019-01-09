package com.java.core.FinalAlgotithems;

import java.util.Arrays;

public class ArrangeZeros {

	public static int[] val = {2,0,4,3,8,0,9,11,0};
	public static void arrange(){
		int count = 0;
		for(int i=0;i<val.length;i++)
		{
			if(val[i]>0)
			{
				val[count]=val[i];
				count++;
			}
		}
		while(count<val.length){
			val[count]=0;
			count++;
		}
	}
	public static void main(String[] args) {
		System.out.println(Arrays.toString(val));
		arrange();
		System.out.println(Arrays.toString(val));
	}
}
