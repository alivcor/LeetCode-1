package com.leetcode.solved;

public class ClimbStairs {
	/*
	 * Given N, return the number of ways stairs can be climbed.
	 * 
	 * This is more of a Fibonacci series, after defining the base cases,
	 * step #N can be reached from N-1 and N-2. So reaching at step N
	 * would be possible : sum(#reaching N-1, #reaching N-2)
	 */
	public int climbStairs(int n) {
        if(n == 0) return 0;
        if(n == 1) return 1;
        if(n == 2) return 2;
        int a = 1;
        int b = 2;
        
        for(int i = 3; i <= n; i++){
            int temp = a + b;
            a = b;
            b = temp;
        }
        
        return b;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
