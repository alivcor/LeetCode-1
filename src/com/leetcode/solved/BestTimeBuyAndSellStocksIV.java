package com.leetcode.solved;

public class BestTimeBuyAndSellStocksIV {
	public int maxProfit(int k, int[] prices) {
        if(prices.length <=1) return 0;
        if(prices.length/2 < k) return maxP(prices);
        int maxP[][] = new int[k+1][prices.length];
        
        for(int i = 1; i <= k; i++){
            int tempMx = maxP[i-1][0] - prices[0];
            for(int j = 1; j < prices.length; j++){
                //ya to previous, ya to for every price j' less than current price dp[i-1,j'] + curPr - j'pr
                // =ya to previous, OR  prices[j] + max(dp[i-1, j'] - prices[j'])) : j' = 0->j-1
                maxP[i][j] = Integer.max(maxP[i][j-1],prices[j] + tempMx);
                tempMx = Integer.max(tempMx,maxP[i-1][j] - prices[j]);
            }
        }
        return maxP[k][prices.length-1];
    }
    
    private int maxP(int prices[]){
        int sum = 0;
        for(int i = 1; i < prices.length; i++){
            sum += (prices[i] - prices[i-1] > 0) ? prices[i] - prices[i-1] : 0;
        }
        return sum;
    }

}
