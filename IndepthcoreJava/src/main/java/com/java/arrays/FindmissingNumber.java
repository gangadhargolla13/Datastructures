package com.java.arrays;

import java.util.Arrays;
import java.util.BitSet;

public class FindmissingNumber {

	public static void main(String[] args) {
		FindmissingNumber num = new FindmissingNumber();
		FindmissingNumber.Missing mm = num.new Missing();
		System.out.println(mm.findValue(new int[]{1,2,3,4,5,7,8,9,10}, 10));
		//System.out.println(mm.printMissungNum(new int[]{1,2,3,4,5,7,8,9,10}, 10).toString());
		int[] check = mm.printMissungNum(new int[]{1,2,3,4,5,7,8,9,10}, 10);
		for(int g:check)
			System.out.println(g);
	}
	public class Missing{
		//By sum of N numbers formula
		public int findValue(int[] values,int count){
			int sum=0;
			for(int i=0;i<values.length;i++){
				sum+=values[i];
			}
			int total = (count * (count + 1)) / 2;
			System.out.println(total +" "+sum);
			return total-sum;
		}
		
		public int[] printMissungNum(int[] array,int count){
			int missingCount = count - array.length;
			 BitSet bitSet = new BitSet(count);
			 for (int number : array) { 
			 bitSet.set(number - 1); 
			 } 
			 System.out.println(bitSet);
			 int[] miss = new int[missingCount];
			 System.out.printf("Missing numbers in integer array %s, with total number %d is %n", Arrays.toString(array), count); 
			 int lastMissingIndex = 0;
			 for (int i = 0; i < missingCount; i++) { 
			 lastMissingIndex = bitSet.nextClearBit(lastMissingIndex);
			 System.out.println(lastMissingIndex);
			 miss[i]=++lastMissingIndex;
			 }
			 return miss;
		}
	}
}


