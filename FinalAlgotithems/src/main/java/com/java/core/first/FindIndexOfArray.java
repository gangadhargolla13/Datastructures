package com.java.core.first;

public class FindIndexOfArray {

	public int findIndex(int[] a,int s,int e){
		if(a==null || a.length==0)
			return -1;
		if(s==e)
			return s;
		if(e==s+1 && a[s]>a[e])
		{
			return s;
		}
		if(e==s+1 && a[s]<a[e])
			return e;
		int m=s+(e-s)/2;
		if(a[m]>a[m-1] && a[m]>a[m+1])
			return m;
		else if(a[m]>a[m+1] && a[m]<a[m-1])
			return findIndex(a,s,m);
		else
			return findIndex(a,m+1,e);
	}
	
	public int findIndex0(int [] arrA, int start, int end)
	{
		if(start>end)
            return 0;
		if(start==end){
            if(arrA[start]==0)
                return start;
            if(arrA[start]==1)
                return -1;
        }		
		int mid = start + (end-start)/2;
        if(arrA[mid]==0 && arrA[mid-1]==1)
            return mid;
        else if(arrA[mid]==0 && arrA[mid-1]==0){
            return findIndex0(arrA,start,mid);
        }else //if(arrA[mid]==1){
            return findIndex0(arrA,mid+1,end);
        }
	public static void main(String[] args) {
//		int [] arrA = {1,2,4,6,11,15,19,20,21,31,41,51,55,46,35,24,18,14,13,12,11,4,2,1};
		int [] arrA = {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
		FindIndexOfArray dd = new FindIndexOfArray();
		//int index = dd.findIndex(arrA, 0, arrA.length-1);
		int index = dd.findIndex0(arrA, 0, arrA.length-1);
		System.out.println(index);
	}
}
