package com.leetcode.solved;

public class PowerOfThree {
	
	public static boolean isPowerOfThree(int n) {
		if(n <= 0) return false;
		double logbase3 = Math.log(n)/Math.log(3);
		logbase3 = Math.round(logbase3*1000000000)/1000000000.00;
		return (logbase3%1 == 0);  
    }

	public static void main(String[] args) {
		System.out.println(isPowerOfThree(9));
		System.out.println(isPowerOfThree(81));
		System.out.println(isPowerOfThree(19));
		System.out.println(isPowerOfThree(243));

	}

}
