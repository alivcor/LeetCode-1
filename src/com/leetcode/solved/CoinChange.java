package com.leetcode.solved;


import java.util.Arrays;

public class CoinChange {
	
	public static int coinChange(int[] coins, int amount) {
		if(coins == null || coins.length == 0) return -1;
		
		int dparray[] = new int[amount + 1];
		Arrays.fill(dparray, Integer.MAX_VALUE);
		
		for(int coinVal : coins) {
			if(coinVal > amount) break;
			dparray[coinVal] = 1;
		}
		dparray[0] = 0;
		for (int i = 1; i <= amount; i++){
			for(int coin : coins){
				if(i >= coin && dparray[i] > dparray[i - coin]){
					dparray[i] = 1 + dparray[i - coin];
				}
			}
		}
		
		return (dparray[amount] == Integer.MAX_VALUE) ? -1 : dparray[amount];
    }

	public static void main(String[] args) {
		int coins[] = {1};
		System.out.println(coinChange(coins, 2));

	}

}
