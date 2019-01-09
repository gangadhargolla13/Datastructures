package com.java.core.maths;

public class PrimaryNumbers {

	public static void main(String[] args) {
		printPrime();
	}
	
	public static boolean isPrime(int num)
	{
		int sqar = (int)Math.sqrt(num)+1;
		for(int i=2;i<sqar;i++)
		{
			if(num%i==0)
			{
				return false;
			}
		}
		return true;
	}
	
	public static boolean isnPrime1(int num)
	{
		if(num==2||num==3)
		{
			return true;
		}
		if(num%2==0)
		{
			return true;
		}
		int s = (int)Math.sqrt(num)+1;
		for(int i=3;i<s;i +=2)
		{
			if(num%i==0)
				return false;
		}
		return true;
	}
	
	public static void isBinary(int num)
	{
		boolean status = true;
		while(true)
		{
			if(num==0)
			{
				break;
			}
			else
			{
				int tmp = num%10;
				if(tmp > 1)
				{
					status = false;
					break;
				}
				num = num/10;
			}
		}
	}
	public static void printPrime()
	{
		for(int i=2;i<=50;i++){
			int count = 0;
			for(int num=2; num<i; num++)
			{
				if(i%num == 0)
				{
					count++;
					break;
				}
			}
			if(count==0)
			{
				System.out.print(i+" ");
			}
		}
	}
}
