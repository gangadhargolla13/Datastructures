package com.java.core.dp;

public class NoOfPathObstruction {

	public static void main(String[] args) {
        int arrA [][] = {{1,1,1},{1,-1,1},{1,-1,1}};
        NoOfPathObstruction noOfPaths = new NoOfPathObstruction();
        System.out.println("No Of Path (DP):- " +noOfPaths.countDP(arrA));
    }
	
	public int countDP(int [][] arrA){
        int result [][] = arrA;

        for (int i = 1; i <result.length ; i++) {
            for (int j = 1; j <result.length ; j++) {
                if(result[i][j]!=-1){
                    result[i][j]=0;
                    if(result[i-1][j]>0)
                        result[i][j]+=result[i-1][j];
                    if(result[i][j-1]>0)
                        result[i][j]+=result[i][j-1];
                }
            }
        }

        return result[arrA.length-1][arrA.length-1];
    }
}
