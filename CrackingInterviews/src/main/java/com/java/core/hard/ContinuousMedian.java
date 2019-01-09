package com.java.core.hard;

import java.util.Collections;
import java.util.PriorityQueue;

public class ContinuousMedian {
	private static PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder()); // maxHeap contains all SMALL elements
	private static PriorityQueue<Integer> minHeap = new PriorityQueue<>();						     // minHeap contains all LARGE elements
	  
	public static void addNum(int n) {
		if (maxHeap.isEmpty()) {
            maxHeap.add(n);
		} else if (maxHeap.size() == minHeap.size()) {
            if (n < minHeap.peek()) {
                maxHeap.add(n);
            } else {
                minHeap.add(n);
                maxHeap.add(minHeap.remove());
            }
        } else if (maxHeap.size() > minHeap.size()) {
	        if (n > maxHeap.peek()) {
	        	minHeap.add(n);
	        } else {
	            maxHeap.add(n);
	        	minHeap.add(maxHeap.remove());
	        }
	    }
		// maxHeap will never be smaller size than minHeap
	}
	    
	public static double getMedian() {
		if (maxHeap.isEmpty()) {
			return 0;
        } else if (maxHeap.size() == minHeap.size()) {
        	return (maxHeap.peek() + minHeap.peek()) / 2.0;
        } else {
        	return maxHeap.peek();
        }
    }
	
	public static void main(String[] args) {
		System.out.println("*** Test 17.20: Continuous Median\n");
        for (int i = 0; i < 5; i++) {
            ContinuousMedian.addNum(i);
            System.out.println("Add " + i + " to data structure.  Median = " + ContinuousMedian.getMedian());
        }
	}
}

