package com.java.core.array2;

import java.util.Stack;

public class TrackMaxInStack {

	Stack<Integer> main = new Stack<>();
	Stack<Integer> track = new Stack<>();
	
	public void insert(int m){
		if(main.isEmpty()){
			main.add(m);
			track.add(m);
		}
		else{
			main.add(m);
			track.add(Math.max(m, track.peek()));
		}
	}
	public int remove() {
		if (!main.isEmpty()) { // pop the top elements
			track.pop();
			return main.pop();
		}
		return 0;
	}
	
	public int getMax() {
		return track.peek();
	}
	public static void main(String[] args) {
		TrackMaxInStack i = new TrackMaxInStack();
		i.insert(4);
		i.insert(2);
		i.insert(14);
		i.insert(1);
		i.insert(18);
		System.out.println("Max Element is " + i.getMax());
		System.out.println("Removing Element " + i.remove());
		System.out.println("Max Element is " + i.getMax());
	}

}
