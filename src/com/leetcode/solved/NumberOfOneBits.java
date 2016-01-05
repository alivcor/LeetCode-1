package com.leetcode.solved;

public class NumberOfOneBits {

	/*
	 * Return the count of set 1 in a number.
	 * The regular way is to traverse through the number,
	 * Doing an and operation each time by 1 and right shifting.
	 * 
	 *  A quick way:
	 *  For any number N, perform an AND operation each time with (N-1).
	 *  This would set the rightmost 1 bit to 0.
	 *  Assign this value to N.
	 *  Keep doing this in a loop and save the count.
	 *  Return the count when N == 0.
	 *   
	 */
	public int hammingWeight(int n) {
        int count = 0;
        while(n != 0){
            count++;
            n = (n&(n-1));
        }
        return count;
    }

}
