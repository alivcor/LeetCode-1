package com.leetcode.solved;

public class ID441_ArrangingCoins {
	public int arrangeCoins(int n) {
        return (int)((-1 + Math.sqrt(1 + 8 * (long)n)) / 2);
    }

}
