package com.java.arrays;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class FindPairvalues {

}

class Example {
	public static int[] getRandom(int count){
		int[] values = new int[count];
		for(int i=0;i<count;i++){
			values[i]=(int)Math.random()*15;
		}
		return values;
	}
	public static void prettyPrint(int[] array,int k){
		System.out.println("The values "+Arrays.toString(array));
		//By default takes (n^2) time
		
	}
	
	public static void typeOfn2(int[] array,int count){
		for(int i=0;i<array.length;i++){
			int first = array[i];
			for(int j=i+1;j<array.length;j++){
				int sum = first+array[j];
				if(sum == count){
					System.out.printf("(%d, %d) %n",first,array[j]);
				}
			}
		}
	}
	
	public static void typeofN(int[] array,int count){
		if(array.length < 2){
			return ;
		}
		
		Set set = new HashSet(array.length);
		for(int ele:array){
			int require = count - ele;
			if(!set.contains(require)){
				set.add(ele);
			}else{
				System.out.printf("(%d, %d) %n", ele, require);
			}
		}
	}
	
	public static void typeOflogn(int[] array,int count){
		if(array.length < 2){
			return ;
		}
		Arrays.sort(array);
		int left = 0;
		int right = array.length;
		while(left < right){
			int sum = array[left]+array[right];
			if(sum == count){
				System.out.printf("(%d, %d) %n", array[left], array[right]);
			}else if(sum < count){
				left = left+1;
			}else if(sum > count){
				right = right-1;
			}
		}
	}
}