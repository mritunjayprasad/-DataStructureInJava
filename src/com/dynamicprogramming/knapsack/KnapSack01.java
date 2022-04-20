package com.dynamicprogramming.knapsack;

public class KnapSack01 {

	
	public static int maxProfit(int w[],int val[],int len,int W,int dp[][]) {
		
		if(len==0 || W==0) {
			return 0;
		}
		
		if(dp[len+1][W]!=0) {
			return dp[len][W];
		}
		if(w[len]<=W) {
			
			return dp[len+1][W]=Math.max(val[len]+maxProfit(w,val,len-1,W-w[len-1],dp),maxProfit(w,val,len-1,W,dp));
		}else {
			return dp[len+1][W]=maxProfit(w,val,len-1,W,dp);
		}
	}
	public static void main(String[] args) {
		 
		int val[] = new int[] { 60, 100, 120 };
        int wt[] = new int[] { 10, 20, 30 };
        int W = 50;
        int len = val.length;
        int dp[][]=new int [len+1][W+1];
        
        System.out.println("max profit is:"+ maxProfit(wt, val, len-1, W,dp));
        System.out.println(dp[len][W]);
	}

}
