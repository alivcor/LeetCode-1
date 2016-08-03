package com.leetcode.solved;

public class BestTimeToBuyAndSellStockIII {

	public int maxProfit(int[] prices) {
        int buy1 = Integer.MIN_VALUE;
        int sell2 = 0;
        int sell1 = 0;
        int buy2 = Integer.MIN_VALUE;
        
        for(int i = 0; i < prices.length; i++){
            sell2 = Integer.max(sell2, buy2 + prices[i]);
            buy2 = Integer.max(buy2, sell1 - prices[i]);
            sell1 = Integer.max(sell1, buy1 + prices[i]);
            buy1 = Integer.max(buy1, -prices[i]);
        }
        return sell2;
    }
}
