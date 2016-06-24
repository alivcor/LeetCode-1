package com.leetcode.solved;

public class DivideTwoIntegers {
	private static long divideUtil(long dividend, long divisor){
		long divD = dividend;
		long divS = divisor;
		
		boolean isNeg = (divS < 0 && divD > 0) || (divD < 0 && divS > 0);
		divD = Math.abs(divD);
		divS = Math.abs(divS);
		
		if(divS > divD) return 0;
		
		int q = 1;
		long curr = divS;
		
		while(curr + curr < divD){
			q += q;
			curr += curr;
		}
		
		long result = (q + divideUtil((int)(divD - curr),(int) divS));
		return (isNeg) ? -1 * result : result;
        
	}
	public static int divide(int dividend, int divisor) {
		if(divisor == 0) return Integer.MAX_VALUE;
		long result = divideUtil(dividend, divisor);
		return (result > Integer.MAX_VALUE || result < Integer.MIN_VALUE) ? Integer.MAX_VALUE :(int) result;
		
    }

}
