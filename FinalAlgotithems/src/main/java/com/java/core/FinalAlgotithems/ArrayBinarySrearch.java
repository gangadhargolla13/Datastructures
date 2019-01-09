package com.java.core.FinalAlgotithems;

public class ArrayBinarySrearch {

	public int[] tmp;
	
	public ArrayBinarySrearch(int[] tmp)
	{
		this.tmp=tmp;
	}
	//By recursive approach
    public Boolean search(int a,int b,int s){
    	if(a>b)
    		return false;
    	int m = a+(b-a)/2;
    	if(tmp[m]==s){
    		return true;
    	}else if(tmp[m]>s)return search(a,m-1,s);
    	else return search(m+1,b,s);
    }
    //By iterative approach
    public Boolean search(int s)
    {
    	int l=0,r=tmp.length-1;
    	while(l<=r)
    	{
    		int m=l+(r-l)/2;
    		if(tmp[m]==s)
    		{
    			return true;
    		}
    		if(tmp[m]<s)
    			l=m+1;
    		else
    			r=m-1;
    	}
    	return false;
    }
    public static void main(String[] args) {
    	ArrayBinarySrearch se = new ArrayBinarySrearch(new int[]{7,19,24,37,49,61,78});
    	//Boolean ss = se.search(0, se.tmp.length-1, 48);
    	Boolean ss = se.search(49);
    	  System.out.println("Element is found! "+ss);
	}
}

