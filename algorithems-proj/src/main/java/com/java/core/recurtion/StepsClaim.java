package com.java.core.recurtion;

public class StepsClaim {

	public int possible(int n,int[] dyn){
		if(n<1)
			return 0;
		if(dyn[n]>0)
			return dyn[n];
		dyn[n]=1+possible(n-1,dyn)+possible(n-2,dyn)+possible(n-3,dyn);
		return dyn[n];
	}
	
	public static void main(String[] args) {
		int n=3;
		StepsClaim c = new StepsClaim();
		int[] dyn = new int[n+1];
		System.out.println(c.possible(n, dyn));
		
	}
}
