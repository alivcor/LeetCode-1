package com.leetcode.solved;

public class BestTimeToBuyAndSellStocks {
	public int maxProfit(int[] prices) {
        if(prices == null || prices.length <= 1) return 0;
        int minVal = prices[0];
        int maxProfit = 0;
        for(int i = 1; i < prices.length; i++){
            if(prices[i] - minVal > maxProfit) maxProfit = prices[i] - minVal;
            if(prices[i] < minVal) minVal = prices[i];
        }
        return maxProfit;
    }
}
