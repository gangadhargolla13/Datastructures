package com.java.core.arrays;

public class StockSingleSell {

	public static void findMaxStack(int[] price){
		int shell=0;
		int buy=0;
		int in=-1;
		for(int i=0;i<price.length;i++){
			for(int j=i;j<price.length;j++){
				if(price[j]>price[i] && ((price[j]-price[i])>in))
				{
					in = price[j]-price[i];
					shell = j;
					buy= i;
				}
			}
		}
		System.out.println("Maximum Profit: " + in + ", buy date index: " + buy +
                ", sell date index: " + shell);
	}
	
	public static void maxProfit(int[]a)
	{
		int period= a.length;
		int buyDateIndex = 0;
        int tempIndex = 0;
        int sellDateIndex = 0;
        int current_profit = 0;
        int max_sell_price = a[period - 1];
        for(int i=period-2; i>0; i--)
        {
        	if(max_sell_price < a[i])
        	{
        		max_sell_price=a[i];
        		tempIndex=i;
        	}else if(max_sell_price > a[i])
        	{
        		if(current_profit < (max_sell_price -a[i]))
        		{
        			current_profit = max_sell_price - a[i];
                    buyDateIndex = i;
                    sellDateIndex = tempIndex;
        		}
        	}
        }
        System.out.println("Maximum Profit(DP): " + current_profit + ", buy date index: " + buyDateIndex +
                ", sell date index: " + sellDateIndex);
	}
	public static void main(String[] args) {
        int [] prices = { 200, 500, 1000, 700, 30, 400, 900, 400, 50};
       // findMaxStack(prices);
        maxProfit(prices);
    }
}
