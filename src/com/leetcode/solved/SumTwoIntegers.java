package com.leetcode.solved;

public class SumTwoIntegers {

	public static int getSum(int a, int b) {
		if(b == 0) return a;
		
		int sum = a^b;
		int carry = (a&b)<<1;
		return getSum(sum, carry);
    }
	public static void main(String[] args) {
		System.out.println(getSum(10, 19));

	}

}
