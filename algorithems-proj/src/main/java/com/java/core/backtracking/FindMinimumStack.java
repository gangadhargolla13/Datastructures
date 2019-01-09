package com.java.core.backtracking;

public class FindMinimumStack {

	public static void main(String[] args) {
		int[] prices = {200, 500, 1000, 700, 30, 400, 900, 400, 50};
        maxProfit(prices);
	}
	static void maxProfit(int[] prices){
		int maxshell = prices[prices.length-1];
		int cprofit =0;
		int bindex = 0;
		int sindex = 0;
		int tmp = 0;
		for(int i=prices.length-2;i>0;i--){
			if(maxshell < prices[i]){
				maxshell = prices[i];
				tmp=i;
			}
			else{
				if(cprofit<maxshell-prices[i]){
					cprofit = maxshell - prices[i];
					sindex=tmp;
					bindex = i;
				}
			}
		}
		System.out.println("Maximum Profit(DP): " + cprofit + ", buy date index: " + bindex +
                ", sell date index: " + sindex);
	}
}
