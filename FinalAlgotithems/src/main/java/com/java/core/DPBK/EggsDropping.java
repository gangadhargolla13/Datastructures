package com.java.core.DPBK;

import java.util.Arrays;

public class EggsDropping {

	public int getDrops(int eggs,int floors)
	{
		int [][] eggDrops = new int [eggs+1][floors+1];
		for (int i = 1; i <=eggs ; i++) {
            eggDrops[i][0] = 0;
            eggDrops[i][1] = 1;
        }
		for (int i = 1; i <=floors ; i++) {
            eggDrops[1][i] = i;
        }
		for (int i = 2; i <=eggs ; i++) {
            for (int j = 2; j <=floors ; j++) {
                eggDrops[i][j] = Integer.MAX_VALUE;
                int tempResult;
                for (int k = 1; k <=j ; k++) {
                    tempResult = 1 + Math.max(eggDrops[i-1][k-1], eggDrops[i][j-k]);
                    eggDrops[i][j] = Math.min(tempResult,eggDrops[i][j]);
                }
            }
        }
		System.out.println(Arrays.deepToString(eggDrops));
		return eggDrops[eggs][floors];
	}
	public static void main(String[] args) {
		EggsDropping ed = new EggsDropping();
		int eggs=2;
		int floors =10;
		System.out.printf("(DP) Minimum number of drops required in worst case with eggs: %s and floors: %s is : %s",eggs,floors,ed.getDrops(eggs,floors));
	}
}
