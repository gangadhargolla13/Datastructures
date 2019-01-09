package com.java.arrays.v2;

import java.util.HashMap;
import java.util.HashSet;

public class LongestConsecutiveSequence {
	 
	public static void main(String[] args) {
		int[] numbers = {100,4,5,1,2,3};
		longestForward(numbers);
		LongestConsecutiveSequence d = new LongestConsecutiveSequence();
		d.longestConsecutive(numbers);
		
		/*int len = findLongestConseqSubseq(numbers);
		System.out.println("Longest Subsequence length: "+len);*/
 
	}
 
	// Returns length of the longest consecutive subsequence
    static int findLongestConseqSubseq(int arr[]) {
        HashSet<Integer> set = new HashSet<Integer>();
        int maxLength = 0;
 
        // Hash all the array elements
        for (int i=0; i < arr.length; ++i)
            set.add(arr[i]);
 
        // check each possible sequence from the start then update optimal maxLength
        for (int i=0; i < arr.length; ++i) {
            // check if current element is the starting element of a sequence. 
        	//i.e check num-1 is not present, if not present then num is starting element
        	int num = arr[i];
            if (!set.contains(num - 1)) {
            	
                //If num is starting element in sequence then only check for next elements in the sequence
                int j = num;
                while (set.contains(j)){
                    j++;
                }
 
                // update optimal maxLength if this length is more
                if (maxLength < j - num){
                    maxLength = j - num;
                }
                
            }
        }
        return maxLength;
    }
    
    public int longestConsecutive(int[] num) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(num.length == 0) return 0;
        int max = 1;
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int d : num){
            if(!map.containsKey(d)){
                map.put(d, 1);
                if(map.containsKey(d-1)) max = Math.max(max, mergeInterval(map, d-1, d));
                if(map.containsKey(d+1)) max = Math.max(max, mergeInterval(map, d, d+1));
            }
        }
        return max;
    }
    public int mergeInterval(HashMap<Integer, Integer> map, int left, int right){

        int leftBorder = left - map.get(left) + 1;
        int rightBorder = right + map.get(right) - 1;
        int len = rightBorder - leftBorder + 1;
        map.put(leftBorder, len);
        map.put(rightBorder, len);
        return len;
    }
    
    public static void longestForward(int[] arr)
    {
        int subSeqLength = 1;
        int longest = 1;
        int indexStart = 0;
        int indexEnd = 0;

        for (int i = 0; i < arr.length - 1; i++)
        {
            if (arr[i] == arr[i + 1] - 1)//We need to check if the current is equal to the next
            {
                subSeqLength++;//if it is we increment
                if (subSeqLength > longest)//we assign the longest and new bounds
                {
                    longest = subSeqLength;
                    indexStart = i + 2 - subSeqLength;//make sure the index start is correct
                    indexEnd = i + 2;
                }

            } 
            else
                subSeqLength = 1;//else re-initiate the straight length
        }


        for (int i = indexStart; i < indexEnd; i++)//print the sequence
            System.out.println(arr[i] + ", ");        
    }
}