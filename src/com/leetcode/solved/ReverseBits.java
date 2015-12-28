package com.leetcode.solved;

public class ReverseBits {

	public static int reverseBitsUtil(long n) {
		long number = 0;
		for(int i = 0; i < 32; i++){
			long val = n&1;
			number = number<<1;
			number = number|val;
			n = n>>1;
		}
		return (int)number;
    }
	
	public static int reverseBits(int n){
		return reverseBitsUtil(n);
	}
	
}
