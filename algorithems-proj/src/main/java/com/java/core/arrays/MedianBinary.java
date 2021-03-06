package com.java.core.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MedianBinary {

public float find(int [] a, int start_a, int end_a, int [] b, int start_b, int end_b){
        
        if(end_a-start_a+1==2 && end_b-start_b+1==2){
            float x = Math.max(a[start_a],b[start_b]);
            float y = Math.min(a[end_a],b[end_b]);
            return (x+y)/2;
        }

        float median_a = getMedian(a, start_a, end_a);
        float median_b = getMedian(b, start_b, end_b);

        int mid_a = (start_a+end_a)/2;
        int mid_b = (start_b+end_b)/2;
        if(median_a>median_b){
            return find(a,start_a,mid_a,b,mid_b,end_b);
        }else{
            return find(a,mid_a,end_a,b,start_b,mid_b);
        }

    }

    public float getMedian(int [] x, int start, int end){
        int size = end-start+1;
        double median;
        if(size%2==0){
            float m = x[start+(size/2)];
            float n = x[start+(size-1)/2];
            return (m+n)/2;
        }else{
            return  x[start+(size-1)/2];
        }
    }

    public static void main(String[] args) {
        MedianBinary m = new MedianBinary();
        Integer [] a = {2, 6, 9,13};
        Integer [] b = {1, 5, 7};
        findMedian(a,b);
        //float x = m.find(a,0,a.length-1,b,0,b.length-1);
        //System.out.println("Median of combined sorted array is: " + x);
    }
    
    public static void findMedian(Integer[] a,Integer[] b){
    	List<Integer> list = new ArrayList<>(Arrays.asList(a));
    	//System.out.println(list.size());
    	list.addAll(Arrays.asList(b));
    	Collections.sort(list);
    	if((list.size()%2)!=0)
    	{
    		System.out.println("not divisible by 2");
    		System.out.println(list.get(list.size()/2));
    	}
    	else
    	{
    		int x = list.size()/2;
    		System.out.println(x);
    		float g = (float)list.get(x-1);
    		System.out.println(g);
    		float h = (float)list.get(x);
    		System.out.println(h);
    		float ff = (g+h)/2;
    		System.out.println(ff);
    	}
    }
}
