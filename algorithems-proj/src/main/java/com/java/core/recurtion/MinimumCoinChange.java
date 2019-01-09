package com.java.core.recurtion;

public class MinimumCoinChange {

	public int minCoin(int am,int[] coins){
		int[] co = new int[am+1];
		int[] cc = new int[coins.length];
		cc[0]=0;
		for(int amt=1;amt<am;amt++){
			for(int j=0;j<cc.length;j++){
				cc[j]=-1;
			}
			for(int j=0;j<coins.length;j++){
				if(coins[j]<=am){
					cc[j]=co[am-coins[j]]+1;
				}
			}
			co[amt]=-1;
			for(int j=1;j<cc.length;j++){
				if(cc[j]>0&&(co[amt])==-1||co[amt]>cc[j])
					co[amt]=cc[j];
			}
		}
		return co[am];
	}
	
	public static void main(String[] args) {
		int[] coins = { 1, 2, 3 };
		int amount = 20;
		MinimumCoinChange ch =new MinimumCoinChange();
		System.out.println(ch.minCoin(amount, coins));
	}
}
