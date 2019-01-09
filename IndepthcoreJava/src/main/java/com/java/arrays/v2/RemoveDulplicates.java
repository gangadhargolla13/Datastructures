package com.java.arrays.v2;

public class RemoveDulplicates {

	public static void main(String[] args) {
		int[] input = {2,3,6,6,8,9,10,10,10,12,12};
		int j = 0;
        int i = 1;
        if(input.length < 2){
        }
        while(i < input.length){
        	System.out.println("i value "+i+"==="+"j value "+j);
            if(input[i] == input[j]){
                i++;
            }else{
                input[++j] = input[i++];
            }    
        }
        int[] output = new int[j+1];
        for(int k=0; k<output.length; k++){
            output[k] = input[k];
        }
        for(int ii : output)
        {
        	System.out.print(ii+",");
        }
	}
}
