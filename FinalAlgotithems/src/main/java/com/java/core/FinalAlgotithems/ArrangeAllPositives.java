package com.java.core.FinalAlgotithems;

import java.util.Arrays;

public class ArrangeAllPositives {

	public int[] val;
	public ArrangeAllPositives(int[] val){
		this.val=val;
	}
	public void mergeGroups(int s,int e){
		if (s >= e)
			return;
		int m = (s+e)/2;
		mergeGroups(s,m);
		mergeGroups(m+1,e);
		merge(s,m,e);
	}
	
	public void merge(int s,int m,int e){
		int l=s;
		int k =m+1;
		while(l<=m&&val[l]<=0)
			l++;
		while(k<=e&&val[k]<=0)
			k++;
		reverse(l,m);
		reverse(m+1,k-1);
		reverse(l,k-1);
	}
	public void reverse(int x,int y)
	{
		while(y>x)
		{
			int tmp = val[x];
			val[x]=val[y];
			val[y]=tmp;
			x++;
			y--;
		}
	}
	public static int[] arr = {-12, 11, -13, -5, 6, -7, 5, -3, -6};
	public static void  sortTheArray()
	{
		int count =0,tmp;
		for(int i=0;i<arr.length;i++)
		{
			if(arr[i]<0)
			{
				tmp=arr[count];
				arr[count]=arr[i];
				arr[i]=tmp;
				count++;
			}
		}
	}
	
	public static void main(String[] args) {
		
		System.out.println(Arrays.toString(arr));
		sortTheArray();
		System.out.println(Arrays.toString(arr));
		/*ArrangeAllPositives a =new ArrangeAllPositives(arr); 
		a.mergeGroups(0, arr.length-1);
		System.out.println(Arrays.toString(a.val));*/
	}
}
