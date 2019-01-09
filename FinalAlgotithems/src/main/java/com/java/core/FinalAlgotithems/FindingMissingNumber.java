package com.java.core.FinalAlgotithems;

public class FindingMissingNumber {

	//By formula
	public int findMissing(int[] a,int n){
		int val = n*(n+1)/2;
		int m = 0;
		for(int v:a)
			m+=v;
		return val-m;
	}
	//By xor gate
	public int findMissing(int[] a){
		int val = a.length+1;
		int miss = a[0];
        for(int in=1;in<=val;in++)
        {
        	if(in<a.length)
        	{
        		miss ^=a[in];
        	}
        	miss ^=in;
        }
        return miss;
	}
	public int findMissing1(int[] a,int n){
		int val = a.length+1;
		int miss = a[0];
        for(int in=1;in<=val;in++)
        {
        	if(in<a.length)
        	{
        		miss ^=a[in];
        	}
        	miss ^=in;
        }
        return miss;
	}
	//Find missing number from {51,52,53,54,55,57,58,59,60}
	public int check(int[] a)
	{
		int f=a[0]-1;
		int f1 = (f*a[0])/2;
		int l = a[a.length-1]*(a[a.length-1]+1)/2;
		System.out.println(f1 +" "+l);
		int m = l-f1;
		int s=0;
		for(int d:a)
			s+=d;
		System.out.println(s);
		return m-s;
	}
	public static void main(String[] args) throws Exception{
		FindingMissingNumber cls = (FindingMissingNumber)Class.forName(FindingMissingNumber.class.getName()).newInstance();
		System.out.println(cls.findMissing(new int[]{4,6,8,5,1,7,3,2,10},10));
		//System.out.println(cls.findMissing1(new int[]{4,6,8,5,1,7,3,9,10},10));
		System.out.println(cls.check(new int[]{51,52,53,54,56,57,58,59,60}));
		int a=5;
		int b=5;
		Integer g = new Integer(5);
		Integer h = new Integer(5);
		System.out.println(a==b);
		System.out.println(g.equals(h));
		StringBuffer ddd = new StringBuffer("Hello world");
		System.out.println(ddd.indexOf("world"));
		ddd.insert(6, "Gangadhar");
		System.out.println(ddd.toString());
	}
}
