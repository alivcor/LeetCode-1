package com.leetcode.solved;

public class PowerOfFour {
	public static boolean isPowerOfFour(int num) {
		if(num <= 0) return false;
		
        double val = Math.log(num)/Math.log(4);
        return (num == 1 || Math.floor(val) == val);
    }

	public static void main(String[] args) {
		System.out.println(isPowerOfFour(16));
		System.out.println(isPowerOfFour(1024*1024*1024*1024));

	}

}
