package com.java.arrays;

import java.util.Arrays;

public class FindDuplicates {

	public static void main(String[] args) {
		
		FindDuplicates duplicate = new FindDuplicates();
		/*duplicate.duplicate(new int[]{23,7,45,3,23,89,41,7});
		int[] ll = duplicate.removeDuplicate(new int[]{23,7,45,3,23,89,41,7,89,80});
		for(int i:ll)
			System.out.println(i);*/
		String[] ss =(new String[]{"Lakshami","Koteswari","Gayathri","Sujatha"});
		if(duplicate.contains(ss,"Sujatha")){
			System.out.println("The value is existed in array "+45);
		}
		
	}
	public void duplicate(int[] list){
		for(int i=0;i<list.length;i++){
			for(int j=0;j<i;j++){
				if(list[i]==list[j]){
					System.out.println(list[i]);
				}
			}
		}
	}
	
	public int[] removeDuplicate(int[] list){
		for (int i = 0; i < list.length; i++)
        {
            System.out.print(list[i]+",");
        }
		System.out.println();
		int noOfUniqueElements = list.length;
		for (int i = 0; i < noOfUniqueElements; i++) 
        {
            for (int j = i+1; j < noOfUniqueElements; j++)
            {
            	if(list[i] == list[j])
                {
            		list[j] = list[noOfUniqueElements-1];
            		noOfUniqueElements--;
            		j--;
                }
            }
        }
		for (int i = 0; i < list.length; i++)
        {
            System.out.print(list[i]+",");
        }
		System.out.println();
		System.out.println("==============");
		System.out.println(noOfUniqueElements);
		int[] arrayWithoutDuplicates = Arrays.copyOf(list, noOfUniqueElements);
		for (int i = 0; i < arrayWithoutDuplicates.length; i++)
        {
            System.out.print(arrayWithoutDuplicates[i]+",");
        }
		System.out.println();
		return arrayWithoutDuplicates;
	}
	
	public <T> boolean contains(T[] array,T v){
		for(T e:array){
			if(e==v || v!=null && e.equals(v))
				return true;
		}
		return false;
	}
}
