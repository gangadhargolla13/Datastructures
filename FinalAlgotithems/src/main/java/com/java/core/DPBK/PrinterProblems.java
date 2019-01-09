package com.java.core.DPBK;

import java.util.HashMap;

public class PrinterProblems {

	public int printing(String str){
		int o=str.length();
		if(str == null || str.length()==0)
			return 0;
		int size = str.length();
		if(size==1)
			return 1;
		int s=0;
		int e=0;
		while(s<size)
		{
			int c = str.charAt(s);
			while(e<size && c==str.indexOf(e))
				e++;
			if(e>size)
				o=Math.min(o, printing(str.substring(0,s))+1);
			else
			{
				o=Math.min(o, printing(str.substring(0,e)+str.substring(e+1,size))+1);
			}
			s=e;
		}
		return o;
	}
	HashMap<Integer,Integer> map = new HashMap<>();
	int findJumps(int[] arr,int start)
	{
		if(arr.length==start)
			return 0;
		if(map.containsKey(start))
		{
			return map.get(start);
		}
		int remaining = arr.length - start;
		if(remaining<arr[start])
			return 1;
		if(arr[start]==0)
		{
			return Integer.MAX_VALUE;
		}
		int jump = Integer.MAX_VALUE;
		for(int m=1;m<arr.length;m++){
			int temp = findJumps(arr,start+m);
			if(temp!=Integer.MAX_VALUE)
			{
				jump = Math.max(jump, temp+1);
			}
		}
		map.put(start,jump);
		return jump;
	}
	
	int minimumCoin(int[] arr,int am)
	{
		int coins[] = new int[am+1];
		coins[0]=0;
		for(int i=1;i<=am;i++)
		{
			coins[i] = Integer.MAX_VALUE;
			for(int j=0;j<arr.length;j++)
			{
				if(coins[j]<=i)
				{
				coins[i]=Math.min(coins[i], coins[i-arr[j]]+1);
				}
			}
		}
		return coins[am];
	}
	
	// minimum numbers square sum
	
	int minimumNumber(int n,int option)
	{
		int mn[] = new int[n+1];
		int num[] = new int[option];
		mn[0]= 0;
		for(int number=1;number<=n;number++)
		{
			for(int j=0;j<num.length;j++)
				num[j]=0;
			for(int j=1;j<num.length;j++)
			{
				if(j*j<=number)
				{
					num[j]=mn[number - j*j]+1;
				}
			}
			mn[number]=-1;
			for(int j=1;j<num.length;j++)
			{
				if(num[j] > 0 && (mn[number]==-1||mn[number]>num[j]))
				{
					mn[number]=num[j];
				}
			}
		}
		return mn[n];
	}
	
	//count all paths 
	
//	recursively also we can do
	
	public int totalPath(int[][] arr)
	{
		int[][] result = new int[arr.length][arr[0].length];
		for(int i=0;i<result.length;i++)
			result[0][i]=1;
		for(int i=0;i<result.length;i++)
			result[i][0]=1;
		
		for(int i=1;i<arr.length;i++){
			for(int j=1;j<arr[1].length;j++)
			{
				result[i][j]=result[i][j-1]+result[i-1][j]+result[i-1][j-1];
			}
		}
		return result[arr.length][arr[0].length];
	}
	
	int possibleWays(int n, int[] dyn)
	{
		if(n<0)
			return 0;
		if(dyn[n]>0)
			return dyn[n];
		return 1+possibleWays(n-1,dyn)+possibleWays(n-2,dyn)+possibleWays(n-3,dyn);
	}
	
	int profitDP(int[] val,int len)
	{
		int[] profit = new int[len+1];
		profit[0]=0;
		for(int i=1;i<=len;i++)
		{
			int max =-1;
			for(int j=0;j<val.length;j++)
			{
				max=Math.max(max, val[j]+profit[i-(j+1)]);
			}
			profit[i]=max;
		}
		return profit[len];
	}
	
	int maxProductCutting(int n)
	{
		int[] mpc = new int[n+1];
		mpc[1]=1;
		for(int i=2;i<=n;i++){
			int mp=Integer.MIN_VALUE;
			for(int j=1;j<i;j++)
			{
				mp=Math.max(mp, Math.max(j*mpc[i-j], j*(i-j)));
			}
			mpc[i]=mp;
		}
		return mpc[n];
	}
}
