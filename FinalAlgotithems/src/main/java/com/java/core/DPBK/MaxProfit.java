package com.java.core.DPBK;

public class MaxProfit {

	public static void getMaxProfit(int[] price){
		int p =price.length;
		int b=0,s=0,t=0,cp=0,ms=price[p-1];
		for(int i=p-2;i>0;i--)
		{
			if(ms<price[i])
			{
				ms=price[i];
				t=i;
			}else if(ms>price[i])
			{
				if(cp<ms-price[i]){
					cp=ms-price[i];
					b=i;
					s=t;		
				}
			}
		}
		System.out.println("Maximum Profit(DP): " + cp + ", buy date index: " + b +
                ", sell date index: " + s);
	}
	
	public static void main(String[] args) {
		int[] prices = {200, 500, 1000, 700, 30, 400, 900, 400, 50};
		getMaxProfit(prices);
	}
}
