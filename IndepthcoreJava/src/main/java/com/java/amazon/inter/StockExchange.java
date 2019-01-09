package com.java.amazon.inter;

public class StockExchange {

	public static void maxProfit(int[] arr) throws Exception
	{
		int period = arr.length;
        int buyDateIndex = 0;
        int tempIndex = 0;
        int sellDateIndex = 0;
        int current_profit = 0;
        int max_sell_price = arr[period - 1];
        for (int i = period - 2; i > 0; i--) {
            if (max_sell_price < arr[i]) {
                max_sell_price = arr[i];
                tempIndex = i;
            } else if (max_sell_price > arr[i]) {
                if (current_profit < max_sell_price - arr[i]) {
                    current_profit = max_sell_price - arr[i];
                    buyDateIndex = i;
                    sellDateIndex = tempIndex;
                }
            }
        }
        System.out.println("Maximum Profit(DP): " + current_profit + ", buy date index: " + buyDateIndex +
                ", sell date index: " + sellDateIndex);
	}
	
	public static void main(String[] args) throws Exception{
        int[] prices = {200, 500, 1000, 700, 30, 400, 900, 400, 50};
        maxProfit(prices);
    }
}
