package com.leetcode.solved;

public class BestTimeToBuyAndSellStockCooldown {
    public int maxProfit(int[] prices) {
        if(prices == null) return 0;
        int prev_buy;
        int buy = Integer.MIN_VALUE;
        int sell = 0;
        int prev_sell = 0;
        
        for(int i = 0; i < prices.length; i++){
            prev_buy = buy;
            buy = Integer.max(buy, prev_sell - prices[i]);
            prev_sell = sell;
            sell = Integer.max(sell, prev_buy + prices[i]);
        }
        
        return sell;
    }
}
