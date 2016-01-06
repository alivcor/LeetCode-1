package com.leetcode.solved;

public class PowerOfTwo {

	/*
	 * If number is zero or negative, it would not be a power of 2.
	 * For others we know if there is just one set bit in the integer, it is a power of 2.
	 */
	public static boolean isPowerOfTwo(int n) {
		if(n <= 0) return false;
		return ((n&(n-1)) == 0) ? true : false;
    }
}
