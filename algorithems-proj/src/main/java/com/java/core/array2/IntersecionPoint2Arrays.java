package com.java.core.array2;

public class IntersecionPoint2Arrays 
{
public static void main(String[] args) {
	int[] a={1, 2, 3, 6, 8, 10};
	int[] b = {4, 5, 6, 11, 15, 20};
	int x=0,y=0;
	while(x<a.length && y<b.length)
	{
		if(a[x]>b[y]){
			y++;
		} else if(a[x]<b[y]){
			x++;
		}else
		{
			System.out.println(a[x]);
			break;
		}
	}
}
}
