package com.leetcode.solved;

public class NumberOfDigitOne {
	public static int countDigitOne(int n) {
		int sum = 0;
		for(long i = 1; i <= n; i*=10){
			long a = n/i;
			long b = n%i;
			sum += (a + 8)/10*i + ((a%10 == 1) ? b + 1 : 0);
		}
		
		return sum;
    }

}
