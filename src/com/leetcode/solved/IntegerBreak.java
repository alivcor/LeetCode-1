package com.leetcode.solved;

public class IntegerBreak {

	public static int integerBreak(int n) {
		if(n <= 1) return 0;
		if(n <= 3) return n-1;
		if(n % 3 == 0) return (int)Math.pow(3, n/3);
		if(n % 3 == 1) return(int)(Math.pow(3, (n-4)/3))*4;
		return(int)(Math.pow(3, (n-2)/3))*2;
    }
	public static void main(String[] args) {
		System.out.println(integerBreak(3));
		System.out.println(integerBreak(2));
		System.out.println(integerBreak(10));

	}

}
