package com.leetcode.solved;

public class FactorialTrailingZero {

	/*Each trailing zero is the product of 2 and 5.
	 * The power of 2 and 5 in the prime factorization of a number.
	 * Since the power of 2 is always greater than the power of 5.
	 * The number of zeros would be the power of 5 in the number.
	 * 
	 */
	public static int trailingZeroes(int n) {
		if(n == 0) return 0;
		return n/5 + trailingZeroes(n/5);
    }
	public static void main(String[] args) {
		System.out.println(trailingZeroes(10));
		System.out.println(trailingZeroes(7));
		System.out.println(trailingZeroes(12));

	}

}
