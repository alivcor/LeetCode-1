package com.leetcode.solved;

public class GuessNumberHigherOrLowerII {

	public static int getMoneyAmount(int n) {
		int array[][] = new int[n+2][n+2];
		for(int size = 1; size <= n; size++){
			for(int start = 1; start < n-size + 1; start++){
				int end = start+size;
				array[start][end] = Integer.MAX_VALUE;
				for(int i = start; i <= end; i++){
					array[start][end] = Integer.min(array[start][end],
							i + Integer.max(array[start][i-1], array[i+1][end]));
				}
			}
		}
		return array[1][n];
    }
	
	public static void main(String[] args) {
		System.out.println(getMoneyAmount(10));

	}

}
